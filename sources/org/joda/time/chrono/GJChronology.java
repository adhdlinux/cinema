package org.joda.time.chrono;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.DecoratedDurationField;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class GJChronology extends AssembledChronology {
    static final Instant DEFAULT_CUTOVER = new Instant(-12219292800000L);
    private static final ConcurrentHashMap<GJCacheKey, GJChronology> cCache = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -2545574827706931671L;
    private Instant iCutoverInstant;
    private long iCutoverMillis;
    /* access modifiers changed from: private */
    public long iGapDuration;
    /* access modifiers changed from: private */
    public GregorianChronology iGregorianChronology;
    private JulianChronology iJulianChronology;

    private class CutoverField extends BaseDateTimeField {
        private static final long serialVersionUID = 3528501219481026402L;
        final boolean iConvertByWeekyear;
        final long iCutover;
        protected DurationField iDurationField;
        final DateTimeField iGregorianField;
        final DateTimeField iJulianField;
        protected DurationField iRangeDurationField;

        CutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, long j2) {
            this(gJChronology, dateTimeField, dateTimeField2, j2, false);
        }

        public long add(long j2, int i2) {
            return this.iGregorianField.add(j2, i2);
        }

        public int get(long j2) {
            if (j2 >= this.iCutover) {
                return this.iGregorianField.get(j2);
            }
            return this.iJulianField.get(j2);
        }

        public String getAsShortText(long j2, Locale locale) {
            if (j2 >= this.iCutover) {
                return this.iGregorianField.getAsShortText(j2, locale);
            }
            return this.iJulianField.getAsShortText(j2, locale);
        }

        public String getAsText(long j2, Locale locale) {
            if (j2 >= this.iCutover) {
                return this.iGregorianField.getAsText(j2, locale);
            }
            return this.iJulianField.getAsText(j2, locale);
        }

        public int getDifference(long j2, long j3) {
            return this.iGregorianField.getDifference(j2, j3);
        }

        public long getDifferenceAsLong(long j2, long j3) {
            return this.iGregorianField.getDifferenceAsLong(j2, j3);
        }

        public DurationField getDurationField() {
            return this.iDurationField;
        }

        public int getLeapAmount(long j2) {
            if (j2 >= this.iCutover) {
                return this.iGregorianField.getLeapAmount(j2);
            }
            return this.iJulianField.getLeapAmount(j2);
        }

        public DurationField getLeapDurationField() {
            return this.iGregorianField.getLeapDurationField();
        }

        public int getMaximumShortTextLength(Locale locale) {
            return Math.max(this.iJulianField.getMaximumShortTextLength(locale), this.iGregorianField.getMaximumShortTextLength(locale));
        }

        public int getMaximumTextLength(Locale locale) {
            return Math.max(this.iJulianField.getMaximumTextLength(locale), this.iGregorianField.getMaximumTextLength(locale));
        }

        public int getMaximumValue() {
            return this.iGregorianField.getMaximumValue();
        }

        public int getMinimumValue() {
            return this.iJulianField.getMinimumValue();
        }

        public DurationField getRangeDurationField() {
            return this.iRangeDurationField;
        }

        /* access modifiers changed from: protected */
        public long gregorianToJulian(long j2) {
            if (this.iConvertByWeekyear) {
                return GJChronology.this.gregorianToJulianByWeekyear(j2);
            }
            return GJChronology.this.gregorianToJulianByYear(j2);
        }

        public boolean isLeap(long j2) {
            if (j2 >= this.iCutover) {
                return this.iGregorianField.isLeap(j2);
            }
            return this.iJulianField.isLeap(j2);
        }

        public boolean isLenient() {
            return false;
        }

        /* access modifiers changed from: protected */
        public long julianToGregorian(long j2) {
            if (this.iConvertByWeekyear) {
                return GJChronology.this.julianToGregorianByWeekyear(j2);
            }
            return GJChronology.this.julianToGregorianByYear(j2);
        }

        public long roundCeiling(long j2) {
            if (j2 >= this.iCutover) {
                return this.iGregorianField.roundCeiling(j2);
            }
            long roundCeiling = this.iJulianField.roundCeiling(j2);
            if (roundCeiling < this.iCutover || roundCeiling - GJChronology.this.iGapDuration < this.iCutover) {
                return roundCeiling;
            }
            return julianToGregorian(roundCeiling);
        }

        public long roundFloor(long j2) {
            if (j2 < this.iCutover) {
                return this.iJulianField.roundFloor(j2);
            }
            long roundFloor = this.iGregorianField.roundFloor(j2);
            if (roundFloor >= this.iCutover || GJChronology.this.iGapDuration + roundFloor >= this.iCutover) {
                return roundFloor;
            }
            return gregorianToJulian(roundFloor);
        }

        public long set(long j2, int i2) {
            long j3;
            if (j2 >= this.iCutover) {
                j3 = this.iGregorianField.set(j2, i2);
                if (j3 < this.iCutover) {
                    if (GJChronology.this.iGapDuration + j3 < this.iCutover) {
                        j3 = gregorianToJulian(j3);
                    }
                    if (get(j3) != i2) {
                        throw new IllegalFieldValueException(this.iGregorianField.getType(), (Number) Integer.valueOf(i2), (Number) null, (Number) null);
                    }
                }
            } else {
                j3 = this.iJulianField.set(j2, i2);
                if (j3 >= this.iCutover) {
                    if (j3 - GJChronology.this.iGapDuration >= this.iCutover) {
                        j3 = julianToGregorian(j3);
                    }
                    if (get(j3) != i2) {
                        throw new IllegalFieldValueException(this.iJulianField.getType(), (Number) Integer.valueOf(i2), (Number) null, (Number) null);
                    }
                }
            }
            return j3;
        }

        CutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, long j2, boolean z2) {
            this(dateTimeField, dateTimeField2, (DurationField) null, j2, z2);
        }

        public long add(long j2, long j3) {
            return this.iGregorianField.add(j2, j3);
        }

        public int getMaximumValue(long j2) {
            if (j2 >= this.iCutover) {
                return this.iGregorianField.getMaximumValue(j2);
            }
            int maximumValue = this.iJulianField.getMaximumValue(j2);
            long j3 = this.iJulianField.set(j2, maximumValue);
            long j4 = this.iCutover;
            if (j3 < j4) {
                return maximumValue;
            }
            DateTimeField dateTimeField = this.iJulianField;
            return dateTimeField.get(dateTimeField.add(j4, -1));
        }

        public int getMinimumValue(ReadablePartial readablePartial) {
            return this.iJulianField.getMinimumValue(readablePartial);
        }

        CutoverField(DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, long j2, boolean z2) {
            super(dateTimeField2.getType());
            this.iJulianField = dateTimeField;
            this.iGregorianField = dateTimeField2;
            this.iCutover = j2;
            this.iConvertByWeekyear = z2;
            this.iDurationField = dateTimeField2.getDurationField();
            if (durationField == null && (durationField = dateTimeField2.getRangeDurationField()) == null) {
                durationField = dateTimeField.getRangeDurationField();
            }
            this.iRangeDurationField = durationField;
        }

        public int[] add(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                return iArr;
            }
            if (!DateTimeUtils.isContiguous(readablePartial)) {
                return super.add(readablePartial, i2, iArr, i3);
            }
            int size = readablePartial.size();
            long j2 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                j2 = readablePartial.getFieldType(i4).getField(GJChronology.this).set(j2, iArr[i4]);
            }
            return GJChronology.this.get(readablePartial, add(j2, i3));
        }

        public int getMinimumValue(ReadablePartial readablePartial, int[] iArr) {
            return this.iJulianField.getMinimumValue(readablePartial, iArr);
        }

        public String getAsShortText(int i2, Locale locale) {
            return this.iGregorianField.getAsShortText(i2, locale);
        }

        public String getAsText(int i2, Locale locale) {
            return this.iGregorianField.getAsText(i2, locale);
        }

        public int getMinimumValue(long j2) {
            if (j2 < this.iCutover) {
                return this.iJulianField.getMinimumValue(j2);
            }
            int minimumValue = this.iGregorianField.getMinimumValue(j2);
            long j3 = this.iGregorianField.set(j2, minimumValue);
            long j4 = this.iCutover;
            return j3 < j4 ? this.iGregorianField.get(j4) : minimumValue;
        }

        public int getMaximumValue(ReadablePartial readablePartial) {
            return getMaximumValue(GJChronology.getInstanceUTC().set(readablePartial, 0));
        }

        public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
            GJChronology instanceUTC = GJChronology.getInstanceUTC();
            int size = readablePartial.size();
            long j2 = 0;
            for (int i2 = 0; i2 < size; i2++) {
                DateTimeField field = readablePartial.getFieldType(i2).getField(instanceUTC);
                if (iArr[i2] <= field.getMaximumValue(j2)) {
                    j2 = field.set(j2, iArr[i2]);
                }
            }
            return getMaximumValue(j2);
        }

        public long set(long j2, String str, Locale locale) {
            if (j2 >= this.iCutover) {
                long j3 = this.iGregorianField.set(j2, str, locale);
                if (j3 >= this.iCutover || GJChronology.this.iGapDuration + j3 >= this.iCutover) {
                    return j3;
                }
                return gregorianToJulian(j3);
            }
            long j4 = this.iJulianField.set(j2, str, locale);
            return (j4 < this.iCutover || j4 - GJChronology.this.iGapDuration < this.iCutover) ? j4 : julianToGregorian(j4);
        }
    }

    private final class ImpreciseCutoverField extends CutoverField {
        private static final long serialVersionUID = 3410248757173576441L;

        ImpreciseCutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, long j2) {
            this(dateTimeField, dateTimeField2, (DurationField) null, j2, false);
        }

        public long add(long j2, int i2) {
            if (j2 >= this.iCutover) {
                long add = this.iGregorianField.add(j2, i2);
                if (add >= this.iCutover || GJChronology.this.iGapDuration + add >= this.iCutover) {
                    return add;
                }
                if (this.iConvertByWeekyear) {
                    if (GJChronology.this.iGregorianChronology.weekyear().get(add) <= 0) {
                        add = GJChronology.this.iGregorianChronology.weekyear().add(add, -1);
                    }
                } else if (GJChronology.this.iGregorianChronology.year().get(add) <= 0) {
                    add = GJChronology.this.iGregorianChronology.year().add(add, -1);
                }
                return gregorianToJulian(add);
            }
            long add2 = this.iJulianField.add(j2, i2);
            return (add2 < this.iCutover || add2 - GJChronology.this.iGapDuration < this.iCutover) ? add2 : julianToGregorian(add2);
        }

        public int getDifference(long j2, long j3) {
            long j4 = this.iCutover;
            if (j2 >= j4) {
                if (j3 >= j4) {
                    return this.iGregorianField.getDifference(j2, j3);
                }
                return this.iJulianField.getDifference(gregorianToJulian(j2), j3);
            } else if (j3 < j4) {
                return this.iJulianField.getDifference(j2, j3);
            } else {
                return this.iGregorianField.getDifference(julianToGregorian(j2), j3);
            }
        }

        public long getDifferenceAsLong(long j2, long j3) {
            long j4 = this.iCutover;
            if (j2 >= j4) {
                if (j3 >= j4) {
                    return this.iGregorianField.getDifferenceAsLong(j2, j3);
                }
                return this.iJulianField.getDifferenceAsLong(gregorianToJulian(j2), j3);
            } else if (j3 < j4) {
                return this.iJulianField.getDifferenceAsLong(j2, j3);
            } else {
                return this.iGregorianField.getDifferenceAsLong(julianToGregorian(j2), j3);
            }
        }

        public int getMaximumValue(long j2) {
            if (j2 >= this.iCutover) {
                return this.iGregorianField.getMaximumValue(j2);
            }
            return this.iJulianField.getMaximumValue(j2);
        }

        public int getMinimumValue(long j2) {
            if (j2 >= this.iCutover) {
                return this.iGregorianField.getMinimumValue(j2);
            }
            return this.iJulianField.getMinimumValue(j2);
        }

        ImpreciseCutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, long j2) {
            this(dateTimeField, dateTimeField2, durationField, j2, false);
        }

        ImpreciseCutoverField(GJChronology gJChronology, DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, DurationField durationField2, long j2) {
            this(dateTimeField, dateTimeField2, durationField, j2, false);
            this.iRangeDurationField = durationField2;
        }

        ImpreciseCutoverField(DateTimeField dateTimeField, DateTimeField dateTimeField2, DurationField durationField, long j2, boolean z2) {
            super(GJChronology.this, dateTimeField, dateTimeField2, j2, z2);
            this.iDurationField = durationField == null ? new LinkedDurationField(this.iDurationField, this) : durationField;
        }

        public long add(long j2, long j3) {
            if (j2 >= this.iCutover) {
                long add = this.iGregorianField.add(j2, j3);
                if (add >= this.iCutover || GJChronology.this.iGapDuration + add >= this.iCutover) {
                    return add;
                }
                if (this.iConvertByWeekyear) {
                    if (GJChronology.this.iGregorianChronology.weekyear().get(add) <= 0) {
                        add = GJChronology.this.iGregorianChronology.weekyear().add(add, -1);
                    }
                } else if (GJChronology.this.iGregorianChronology.year().get(add) <= 0) {
                    add = GJChronology.this.iGregorianChronology.year().add(add, -1);
                }
                return gregorianToJulian(add);
            }
            long add2 = this.iJulianField.add(j2, j3);
            return (add2 < this.iCutover || add2 - GJChronology.this.iGapDuration < this.iCutover) ? add2 : julianToGregorian(add2);
        }
    }

    private static class LinkedDurationField extends DecoratedDurationField {
        private static final long serialVersionUID = 4097975388007713084L;
        private final ImpreciseCutoverField iField;

        LinkedDurationField(DurationField durationField, ImpreciseCutoverField impreciseCutoverField) {
            super(durationField, durationField.getType());
            this.iField = impreciseCutoverField;
        }

        public long add(long j2, int i2) {
            return this.iField.add(j2, i2);
        }

        public int getDifference(long j2, long j3) {
            return this.iField.getDifference(j2, j3);
        }

        public long getDifferenceAsLong(long j2, long j3) {
            return this.iField.getDifferenceAsLong(j2, j3);
        }

        public long add(long j2, long j3) {
            return this.iField.add(j2, j3);
        }
    }

    private GJChronology(JulianChronology julianChronology, GregorianChronology gregorianChronology, Instant instant) {
        super((Chronology) null, new Object[]{julianChronology, gregorianChronology, instant});
    }

    private static long convertByWeekyear(long j2, Chronology chronology, Chronology chronology2) {
        return chronology2.millisOfDay().set(chronology2.dayOfWeek().set(chronology2.weekOfWeekyear().set(chronology2.weekyear().set(0, chronology.weekyear().get(j2)), chronology.weekOfWeekyear().get(j2)), chronology.dayOfWeek().get(j2)), chronology.millisOfDay().get(j2));
    }

    private static long convertByYear(long j2, Chronology chronology, Chronology chronology2) {
        return chronology2.getDateTimeMillis(chronology.year().get(j2), chronology.monthOfYear().get(j2), chronology.dayOfMonth().get(j2), chronology.millisOfDay().get(j2));
    }

    public static GJChronology getInstance() {
        return getInstance(DateTimeZone.getDefault(), (ReadableInstant) DEFAULT_CUTOVER, 4);
    }

    public static GJChronology getInstanceUTC() {
        return getInstance(DateTimeZone.UTC, (ReadableInstant) DEFAULT_CUTOVER, 4);
    }

    private Object readResolve() {
        return getInstance(getZone(), (ReadableInstant) this.iCutoverInstant, getMinimumDaysInFirstWeek());
    }

    /* access modifiers changed from: protected */
    public void assemble(AssembledChronology.Fields fields) {
        Object[] objArr = (Object[]) getParam();
        JulianChronology julianChronology = (JulianChronology) objArr[0];
        GregorianChronology gregorianChronology = (GregorianChronology) objArr[1];
        Instant instant = (Instant) objArr[2];
        this.iCutoverMillis = instant.getMillis();
        this.iJulianChronology = julianChronology;
        this.iGregorianChronology = gregorianChronology;
        this.iCutoverInstant = instant;
        if (getBase() == null) {
            if (julianChronology.getMinimumDaysInFirstWeek() == gregorianChronology.getMinimumDaysInFirstWeek()) {
                long j2 = this.iCutoverMillis;
                this.iGapDuration = j2 - julianToGregorianByYear(j2);
                fields.copyFieldsFrom(gregorianChronology);
                if (gregorianChronology.millisOfDay().get(this.iCutoverMillis) == 0) {
                    fields.millisOfSecond = new CutoverField(this, julianChronology.millisOfSecond(), fields.millisOfSecond, this.iCutoverMillis);
                    fields.millisOfDay = new CutoverField(this, julianChronology.millisOfDay(), fields.millisOfDay, this.iCutoverMillis);
                    fields.secondOfMinute = new CutoverField(this, julianChronology.secondOfMinute(), fields.secondOfMinute, this.iCutoverMillis);
                    fields.secondOfDay = new CutoverField(this, julianChronology.secondOfDay(), fields.secondOfDay, this.iCutoverMillis);
                    fields.minuteOfHour = new CutoverField(this, julianChronology.minuteOfHour(), fields.minuteOfHour, this.iCutoverMillis);
                    fields.minuteOfDay = new CutoverField(this, julianChronology.minuteOfDay(), fields.minuteOfDay, this.iCutoverMillis);
                    fields.hourOfDay = new CutoverField(this, julianChronology.hourOfDay(), fields.hourOfDay, this.iCutoverMillis);
                    fields.hourOfHalfday = new CutoverField(this, julianChronology.hourOfHalfday(), fields.hourOfHalfday, this.iCutoverMillis);
                    fields.clockhourOfDay = new CutoverField(this, julianChronology.clockhourOfDay(), fields.clockhourOfDay, this.iCutoverMillis);
                    fields.clockhourOfHalfday = new CutoverField(this, julianChronology.clockhourOfHalfday(), fields.clockhourOfHalfday, this.iCutoverMillis);
                    fields.halfdayOfDay = new CutoverField(this, julianChronology.halfdayOfDay(), fields.halfdayOfDay, this.iCutoverMillis);
                }
                fields.era = new CutoverField(this, julianChronology.era(), fields.era, this.iCutoverMillis);
                ImpreciseCutoverField impreciseCutoverField = new ImpreciseCutoverField(this, julianChronology.year(), fields.year, this.iCutoverMillis);
                fields.year = impreciseCutoverField;
                fields.years = impreciseCutoverField.getDurationField();
                fields.yearOfEra = new ImpreciseCutoverField(this, julianChronology.yearOfEra(), fields.yearOfEra, fields.years, this.iCutoverMillis);
                ImpreciseCutoverField impreciseCutoverField2 = new ImpreciseCutoverField(this, julianChronology.centuryOfEra(), fields.centuryOfEra, this.iCutoverMillis);
                fields.centuryOfEra = impreciseCutoverField2;
                fields.centuries = impreciseCutoverField2.getDurationField();
                fields.yearOfCentury = new ImpreciseCutoverField(this, julianChronology.yearOfCentury(), fields.yearOfCentury, fields.years, fields.centuries, this.iCutoverMillis);
                ImpreciseCutoverField impreciseCutoverField3 = new ImpreciseCutoverField(this, julianChronology.monthOfYear(), fields.monthOfYear, (DurationField) null, fields.years, this.iCutoverMillis);
                fields.monthOfYear = impreciseCutoverField3;
                fields.months = impreciseCutoverField3.getDurationField();
                ImpreciseCutoverField impreciseCutoverField4 = new ImpreciseCutoverField(julianChronology.weekyear(), fields.weekyear, (DurationField) null, this.iCutoverMillis, true);
                fields.weekyear = impreciseCutoverField4;
                fields.weekyears = impreciseCutoverField4.getDurationField();
                fields.weekyearOfCentury = new ImpreciseCutoverField(this, julianChronology.weekyearOfCentury(), fields.weekyearOfCentury, fields.weekyears, fields.centuries, this.iCutoverMillis);
                fields.dayOfYear = new CutoverField(julianChronology.dayOfYear(), fields.dayOfYear, fields.years, gregorianChronology.year().roundCeiling(this.iCutoverMillis), false);
                fields.weekOfWeekyear = new CutoverField(julianChronology.weekOfWeekyear(), fields.weekOfWeekyear, fields.weekyears, gregorianChronology.weekyear().roundCeiling(this.iCutoverMillis), true);
                CutoverField cutoverField = new CutoverField(this, julianChronology.dayOfMonth(), fields.dayOfMonth, this.iCutoverMillis);
                cutoverField.iRangeDurationField = fields.months;
                fields.dayOfMonth = cutoverField;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GJChronology)) {
            return false;
        }
        GJChronology gJChronology = (GJChronology) obj;
        if (this.iCutoverMillis == gJChronology.iCutoverMillis && getMinimumDaysInFirstWeek() == gJChronology.getMinimumDaysInFirstWeek() && getZone().equals(gJChronology.getZone())) {
            return true;
        }
        return false;
    }

    public long getDateTimeMillis(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        Chronology base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i2, i3, i4, i5);
        }
        long dateTimeMillis = this.iGregorianChronology.getDateTimeMillis(i2, i3, i4, i5);
        if (dateTimeMillis < this.iCutoverMillis) {
            dateTimeMillis = this.iJulianChronology.getDateTimeMillis(i2, i3, i4, i5);
            if (dateTimeMillis >= this.iCutoverMillis) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
        }
        return dateTimeMillis;
    }

    public Instant getGregorianCutover() {
        return this.iCutoverInstant;
    }

    public int getMinimumDaysInFirstWeek() {
        return this.iGregorianChronology.getMinimumDaysInFirstWeek();
    }

    public DateTimeZone getZone() {
        Chronology base = getBase();
        if (base != null) {
            return base.getZone();
        }
        return DateTimeZone.UTC;
    }

    /* access modifiers changed from: package-private */
    public long gregorianToJulianByWeekyear(long j2) {
        return convertByWeekyear(j2, this.iGregorianChronology, this.iJulianChronology);
    }

    /* access modifiers changed from: package-private */
    public long gregorianToJulianByYear(long j2) {
        return convertByYear(j2, this.iGregorianChronology, this.iJulianChronology);
    }

    public int hashCode() {
        return 25025 + getZone().hashCode() + getMinimumDaysInFirstWeek() + this.iCutoverInstant.hashCode();
    }

    /* access modifiers changed from: package-private */
    public long julianToGregorianByWeekyear(long j2) {
        return convertByWeekyear(j2, this.iJulianChronology, this.iGregorianChronology);
    }

    /* access modifiers changed from: package-private */
    public long julianToGregorianByYear(long j2) {
        return convertByYear(j2, this.iJulianChronology, this.iGregorianChronology);
    }

    public String toString() {
        DateTimeFormatter dateTimeFormatter;
        StringBuffer stringBuffer = new StringBuffer(60);
        stringBuffer.append("GJChronology");
        stringBuffer.append('[');
        stringBuffer.append(getZone().getID());
        if (this.iCutoverMillis != DEFAULT_CUTOVER.getMillis()) {
            stringBuffer.append(",cutover=");
            if (withUTC().dayOfYear().remainder(this.iCutoverMillis) == 0) {
                dateTimeFormatter = ISODateTimeFormat.date();
            } else {
                dateTimeFormatter = ISODateTimeFormat.dateTime();
            }
            dateTimeFormatter.withChronology(withUTC()).printTo(stringBuffer, this.iCutoverMillis);
        }
        if (getMinimumDaysInFirstWeek() != 4) {
            stringBuffer.append(",mdfw=");
            stringBuffer.append(getMinimumDaysInFirstWeek());
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public Chronology withUTC() {
        return withZone(DateTimeZone.UTC);
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        return getInstance(dateTimeZone, (ReadableInstant) this.iCutoverInstant, getMinimumDaysInFirstWeek());
    }

    private GJChronology(Chronology chronology, JulianChronology julianChronology, GregorianChronology gregorianChronology, Instant instant) {
        super(chronology, new Object[]{julianChronology, gregorianChronology, instant});
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone) {
        return getInstance(dateTimeZone, (ReadableInstant) DEFAULT_CUTOVER, 4);
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, ReadableInstant readableInstant) {
        return getInstance(dateTimeZone, readableInstant, 4);
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, ReadableInstant readableInstant, int i2) {
        Instant instant;
        GJChronology gJChronology;
        DateTimeZone zone = DateTimeUtils.getZone(dateTimeZone);
        if (readableInstant == null) {
            instant = DEFAULT_CUTOVER;
        } else {
            instant = readableInstant.toInstant();
            if (new LocalDate(instant.getMillis(), (Chronology) GregorianChronology.getInstance(zone)).getYear() <= 0) {
                throw new IllegalArgumentException("Cutover too early. Must be on or after 0001-01-01.");
            }
        }
        GJCacheKey gJCacheKey = new GJCacheKey(zone, instant, i2);
        ConcurrentHashMap<GJCacheKey, GJChronology> concurrentHashMap = cCache;
        GJChronology gJChronology2 = concurrentHashMap.get(gJCacheKey);
        if (gJChronology2 != null) {
            return gJChronology2;
        }
        DateTimeZone dateTimeZone2 = DateTimeZone.UTC;
        if (zone == dateTimeZone2) {
            gJChronology = new GJChronology(JulianChronology.getInstance(zone, i2), GregorianChronology.getInstance(zone, i2), instant);
        } else {
            GJChronology instance = getInstance(dateTimeZone2, (ReadableInstant) instant, i2);
            gJChronology = new GJChronology(ZonedChronology.getInstance(instance, zone), instance.iJulianChronology, instance.iGregorianChronology, instance.iCutoverInstant);
        }
        GJChronology putIfAbsent = concurrentHashMap.putIfAbsent(gJCacheKey, gJChronology);
        return putIfAbsent != null ? putIfAbsent : gJChronology;
    }

    public long getDateTimeMillis(int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        long j2;
        Chronology base = getBase();
        if (base != null) {
            return base.getDateTimeMillis(i2, i3, i4, i5, i6, i7, i8);
        }
        try {
            j2 = this.iGregorianChronology.getDateTimeMillis(i2, i3, i4, i5, i6, i7, i8);
            int i9 = i3;
            int i10 = i4;
        } catch (IllegalFieldValueException e2) {
            if (i3 == 2 && i4 == 29) {
                j2 = this.iGregorianChronology.getDateTimeMillis(i2, i3, 28, i5, i6, i7, i8);
                if (j2 >= this.iCutoverMillis) {
                    throw e2;
                }
            } else {
                throw e2;
            }
        }
        if (j2 < this.iCutoverMillis) {
            j2 = this.iJulianChronology.getDateTimeMillis(i2, i3, i4, i5, i6, i7, i8);
            if (j2 >= this.iCutoverMillis) {
                throw new IllegalArgumentException("Specified date does not exist");
            }
        }
        return j2;
    }

    public static GJChronology getInstance(DateTimeZone dateTimeZone, long j2, int i2) {
        Instant instant;
        if (j2 == DEFAULT_CUTOVER.getMillis()) {
            instant = null;
        } else {
            instant = new Instant(j2);
        }
        return getInstance(dateTimeZone, (ReadableInstant) instant, i2);
    }
}
