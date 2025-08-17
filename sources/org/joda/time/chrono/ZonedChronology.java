package org.joda.time.chrono;

import com.facebook.common.time.Clock;
import java.util.HashMap;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;
import org.joda.time.ReadablePartial;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.BaseDateTimeField;
import org.joda.time.field.BaseDurationField;

public final class ZonedChronology extends AssembledChronology {
    private static final long NEAR_ZERO = 604800000;
    private static final long serialVersionUID = -1079258847191166848L;

    static final class ZonedDateTimeField extends BaseDateTimeField {
        private static final long serialVersionUID = -3968986277775529794L;
        final DurationField iDurationField;
        final DateTimeField iField;
        final DurationField iLeapDurationField;
        final DurationField iRangeDurationField;
        final boolean iTimeField;
        final DateTimeZone iZone;

        ZonedDateTimeField(DateTimeField dateTimeField, DateTimeZone dateTimeZone, DurationField durationField, DurationField durationField2, DurationField durationField3) {
            super(dateTimeField.getType());
            if (dateTimeField.isSupported()) {
                this.iField = dateTimeField;
                this.iZone = dateTimeZone;
                this.iDurationField = durationField;
                this.iTimeField = ZonedChronology.useTimeArithmetic(durationField);
                this.iRangeDurationField = durationField2;
                this.iLeapDurationField = durationField3;
                return;
            }
            throw new IllegalArgumentException();
        }

        private int getOffsetToAdd(long j2) {
            int offset = this.iZone.getOffset(j2);
            long j3 = (long) offset;
            if (((j2 + j3) ^ j2) >= 0 || (j2 ^ j3) < 0) {
                return offset;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        public long add(long j2, int i2) {
            if (this.iTimeField) {
                long offsetToAdd = (long) getOffsetToAdd(j2);
                return this.iField.add(j2 + offsetToAdd, i2) - offsetToAdd;
            }
            return this.iZone.convertLocalToUTC(this.iField.add(this.iZone.convertUTCToLocal(j2), i2), false, j2);
        }

        public long addWrapField(long j2, int i2) {
            if (this.iTimeField) {
                long offsetToAdd = (long) getOffsetToAdd(j2);
                return this.iField.addWrapField(j2 + offsetToAdd, i2) - offsetToAdd;
            }
            return this.iZone.convertLocalToUTC(this.iField.addWrapField(this.iZone.convertUTCToLocal(j2), i2), false, j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ZonedDateTimeField)) {
                return false;
            }
            ZonedDateTimeField zonedDateTimeField = (ZonedDateTimeField) obj;
            if (!this.iField.equals(zonedDateTimeField.iField) || !this.iZone.equals(zonedDateTimeField.iZone) || !this.iDurationField.equals(zonedDateTimeField.iDurationField) || !this.iRangeDurationField.equals(zonedDateTimeField.iRangeDurationField)) {
                return false;
            }
            return true;
        }

        public int get(long j2) {
            return this.iField.get(this.iZone.convertUTCToLocal(j2));
        }

        public String getAsShortText(long j2, Locale locale) {
            return this.iField.getAsShortText(this.iZone.convertUTCToLocal(j2), locale);
        }

        public String getAsText(long j2, Locale locale) {
            return this.iField.getAsText(this.iZone.convertUTCToLocal(j2), locale);
        }

        public int getDifference(long j2, long j3) {
            int i2;
            int offsetToAdd = getOffsetToAdd(j3);
            DateTimeField dateTimeField = this.iField;
            if (this.iTimeField) {
                i2 = offsetToAdd;
            } else {
                i2 = getOffsetToAdd(j2);
            }
            return dateTimeField.getDifference(j2 + ((long) i2), j3 + ((long) offsetToAdd));
        }

        public long getDifferenceAsLong(long j2, long j3) {
            int i2;
            int offsetToAdd = getOffsetToAdd(j3);
            DateTimeField dateTimeField = this.iField;
            if (this.iTimeField) {
                i2 = offsetToAdd;
            } else {
                i2 = getOffsetToAdd(j2);
            }
            return dateTimeField.getDifferenceAsLong(j2 + ((long) i2), j3 + ((long) offsetToAdd));
        }

        public final DurationField getDurationField() {
            return this.iDurationField;
        }

        public int getLeapAmount(long j2) {
            return this.iField.getLeapAmount(this.iZone.convertUTCToLocal(j2));
        }

        public final DurationField getLeapDurationField() {
            return this.iLeapDurationField;
        }

        public int getMaximumShortTextLength(Locale locale) {
            return this.iField.getMaximumShortTextLength(locale);
        }

        public int getMaximumTextLength(Locale locale) {
            return this.iField.getMaximumTextLength(locale);
        }

        public int getMaximumValue() {
            return this.iField.getMaximumValue();
        }

        public int getMinimumValue() {
            return this.iField.getMinimumValue();
        }

        public final DurationField getRangeDurationField() {
            return this.iRangeDurationField;
        }

        public int hashCode() {
            return this.iField.hashCode() ^ this.iZone.hashCode();
        }

        public boolean isLeap(long j2) {
            return this.iField.isLeap(this.iZone.convertUTCToLocal(j2));
        }

        public boolean isLenient() {
            return this.iField.isLenient();
        }

        public long remainder(long j2) {
            return this.iField.remainder(this.iZone.convertUTCToLocal(j2));
        }

        public long roundCeiling(long j2) {
            if (this.iTimeField) {
                long offsetToAdd = (long) getOffsetToAdd(j2);
                return this.iField.roundCeiling(j2 + offsetToAdd) - offsetToAdd;
            }
            return this.iZone.convertLocalToUTC(this.iField.roundCeiling(this.iZone.convertUTCToLocal(j2)), false, j2);
        }

        public long roundFloor(long j2) {
            if (this.iTimeField) {
                long offsetToAdd = (long) getOffsetToAdd(j2);
                return this.iField.roundFloor(j2 + offsetToAdd) - offsetToAdd;
            }
            return this.iZone.convertLocalToUTC(this.iField.roundFloor(this.iZone.convertUTCToLocal(j2)), false, j2);
        }

        public long set(long j2, int i2) {
            long j3 = this.iField.set(this.iZone.convertUTCToLocal(j2), i2);
            long convertLocalToUTC = this.iZone.convertLocalToUTC(j3, false, j2);
            if (get(convertLocalToUTC) == i2) {
                return convertLocalToUTC;
            }
            IllegalInstantException illegalInstantException = new IllegalInstantException(j3, this.iZone.getID());
            IllegalFieldValueException illegalFieldValueException = new IllegalFieldValueException(this.iField.getType(), Integer.valueOf(i2), illegalInstantException.getMessage());
            illegalFieldValueException.initCause(illegalInstantException);
            throw illegalFieldValueException;
        }

        public int getMaximumValue(long j2) {
            return this.iField.getMaximumValue(this.iZone.convertUTCToLocal(j2));
        }

        public int getMinimumValue(long j2) {
            return this.iField.getMinimumValue(this.iZone.convertUTCToLocal(j2));
        }

        public String getAsShortText(int i2, Locale locale) {
            return this.iField.getAsShortText(i2, locale);
        }

        public String getAsText(int i2, Locale locale) {
            return this.iField.getAsText(i2, locale);
        }

        public int getMaximumValue(ReadablePartial readablePartial) {
            return this.iField.getMaximumValue(readablePartial);
        }

        public int getMinimumValue(ReadablePartial readablePartial) {
            return this.iField.getMinimumValue(readablePartial);
        }

        public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
            return this.iField.getMaximumValue(readablePartial, iArr);
        }

        public int getMinimumValue(ReadablePartial readablePartial, int[] iArr) {
            return this.iField.getMinimumValue(readablePartial, iArr);
        }

        public long add(long j2, long j3) {
            if (this.iTimeField) {
                long offsetToAdd = (long) getOffsetToAdd(j2);
                return this.iField.add(j2 + offsetToAdd, j3) - offsetToAdd;
            }
            return this.iZone.convertLocalToUTC(this.iField.add(this.iZone.convertUTCToLocal(j2), j3), false, j2);
        }

        public long set(long j2, String str, Locale locale) {
            return this.iZone.convertLocalToUTC(this.iField.set(this.iZone.convertUTCToLocal(j2), str, locale), false, j2);
        }
    }

    static class ZonedDurationField extends BaseDurationField {
        private static final long serialVersionUID = -485345310999208286L;
        final DurationField iField;
        final boolean iTimeField;
        final DateTimeZone iZone;

        ZonedDurationField(DurationField durationField, DateTimeZone dateTimeZone) {
            super(durationField.getType());
            if (durationField.isSupported()) {
                this.iField = durationField;
                this.iTimeField = ZonedChronology.useTimeArithmetic(durationField);
                this.iZone = dateTimeZone;
                return;
            }
            throw new IllegalArgumentException();
        }

        private long addOffset(long j2) {
            return this.iZone.convertUTCToLocal(j2);
        }

        private int getOffsetFromLocalToSubtract(long j2) {
            int offsetFromLocal = this.iZone.getOffsetFromLocal(j2);
            long j3 = (long) offsetFromLocal;
            if (((j2 - j3) ^ j2) >= 0 || (j2 ^ j3) >= 0) {
                return offsetFromLocal;
            }
            throw new ArithmeticException("Subtracting time zone offset caused overflow");
        }

        private int getOffsetToAdd(long j2) {
            int offset = this.iZone.getOffset(j2);
            long j3 = (long) offset;
            if (((j2 + j3) ^ j2) >= 0 || (j2 ^ j3) < 0) {
                return offset;
            }
            throw new ArithmeticException("Adding time zone offset caused overflow");
        }

        public long add(long j2, int i2) {
            int offsetToAdd = getOffsetToAdd(j2);
            long add = this.iField.add(j2 + ((long) offsetToAdd), i2);
            if (!this.iTimeField) {
                offsetToAdd = getOffsetFromLocalToSubtract(add);
            }
            return add - ((long) offsetToAdd);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ZonedDurationField)) {
                return false;
            }
            ZonedDurationField zonedDurationField = (ZonedDurationField) obj;
            if (!this.iField.equals(zonedDurationField.iField) || !this.iZone.equals(zonedDurationField.iZone)) {
                return false;
            }
            return true;
        }

        public int getDifference(long j2, long j3) {
            int i2;
            int offsetToAdd = getOffsetToAdd(j3);
            DurationField durationField = this.iField;
            if (this.iTimeField) {
                i2 = offsetToAdd;
            } else {
                i2 = getOffsetToAdd(j2);
            }
            return durationField.getDifference(j2 + ((long) i2), j3 + ((long) offsetToAdd));
        }

        public long getDifferenceAsLong(long j2, long j3) {
            int i2;
            int offsetToAdd = getOffsetToAdd(j3);
            DurationField durationField = this.iField;
            if (this.iTimeField) {
                i2 = offsetToAdd;
            } else {
                i2 = getOffsetToAdd(j2);
            }
            return durationField.getDifferenceAsLong(j2 + ((long) i2), j3 + ((long) offsetToAdd));
        }

        public long getMillis(int i2, long j2) {
            return this.iField.getMillis(i2, addOffset(j2));
        }

        public long getUnitMillis() {
            return this.iField.getUnitMillis();
        }

        public int getValue(long j2, long j3) {
            return this.iField.getValue(j2, addOffset(j3));
        }

        public long getValueAsLong(long j2, long j3) {
            return this.iField.getValueAsLong(j2, addOffset(j3));
        }

        public int hashCode() {
            return this.iField.hashCode() ^ this.iZone.hashCode();
        }

        public boolean isPrecise() {
            return this.iTimeField ? this.iField.isPrecise() : this.iField.isPrecise() && this.iZone.isFixed();
        }

        public long getMillis(long j2, long j3) {
            return this.iField.getMillis(j2, addOffset(j3));
        }

        public long add(long j2, long j3) {
            int offsetToAdd = getOffsetToAdd(j2);
            long add = this.iField.add(j2 + ((long) offsetToAdd), j3);
            if (!this.iTimeField) {
                offsetToAdd = getOffsetFromLocalToSubtract(add);
            }
            return add - ((long) offsetToAdd);
        }
    }

    private ZonedChronology(Chronology chronology, DateTimeZone dateTimeZone) {
        super(chronology, dateTimeZone);
    }

    private DurationField convertField(DurationField durationField, HashMap<Object, Object> hashMap) {
        if (durationField == null || !durationField.isSupported()) {
            return durationField;
        }
        if (hashMap.containsKey(durationField)) {
            return (DurationField) hashMap.get(durationField);
        }
        ZonedDurationField zonedDurationField = new ZonedDurationField(durationField, getZone());
        hashMap.put(durationField, zonedDurationField);
        return zonedDurationField;
    }

    public static ZonedChronology getInstance(Chronology chronology, DateTimeZone dateTimeZone) {
        if (chronology != null) {
            Chronology withUTC = chronology.withUTC();
            if (withUTC == null) {
                throw new IllegalArgumentException("UTC chronology must not be null");
            } else if (dateTimeZone != null) {
                return new ZonedChronology(withUTC, dateTimeZone);
            } else {
                throw new IllegalArgumentException("DateTimeZone must not be null");
            }
        } else {
            throw new IllegalArgumentException("Must supply a chronology");
        }
    }

    private long localToUTC(long j2) {
        if (j2 == Clock.MAX_TIME) {
            return Clock.MAX_TIME;
        }
        if (j2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        DateTimeZone zone = getZone();
        int offsetFromLocal = zone.getOffsetFromLocal(j2);
        long j3 = j2 - ((long) offsetFromLocal);
        if (j2 > NEAR_ZERO && j3 < 0) {
            return Clock.MAX_TIME;
        }
        if (j2 < -604800000 && j3 > 0) {
            return Long.MIN_VALUE;
        }
        if (offsetFromLocal == zone.getOffset(j3)) {
            return j3;
        }
        throw new IllegalInstantException(j2, zone.getID());
    }

    static boolean useTimeArithmetic(DurationField durationField) {
        return durationField != null && durationField.getUnitMillis() < 43200000;
    }

    /* access modifiers changed from: protected */
    public void assemble(AssembledChronology.Fields fields) {
        HashMap hashMap = new HashMap();
        fields.eras = convertField(fields.eras, (HashMap<Object, Object>) hashMap);
        fields.centuries = convertField(fields.centuries, (HashMap<Object, Object>) hashMap);
        fields.years = convertField(fields.years, (HashMap<Object, Object>) hashMap);
        fields.months = convertField(fields.months, (HashMap<Object, Object>) hashMap);
        fields.weekyears = convertField(fields.weekyears, (HashMap<Object, Object>) hashMap);
        fields.weeks = convertField(fields.weeks, (HashMap<Object, Object>) hashMap);
        fields.days = convertField(fields.days, (HashMap<Object, Object>) hashMap);
        fields.halfdays = convertField(fields.halfdays, (HashMap<Object, Object>) hashMap);
        fields.hours = convertField(fields.hours, (HashMap<Object, Object>) hashMap);
        fields.minutes = convertField(fields.minutes, (HashMap<Object, Object>) hashMap);
        fields.seconds = convertField(fields.seconds, (HashMap<Object, Object>) hashMap);
        fields.millis = convertField(fields.millis, (HashMap<Object, Object>) hashMap);
        fields.year = convertField(fields.year, (HashMap<Object, Object>) hashMap);
        fields.yearOfEra = convertField(fields.yearOfEra, (HashMap<Object, Object>) hashMap);
        fields.yearOfCentury = convertField(fields.yearOfCentury, (HashMap<Object, Object>) hashMap);
        fields.centuryOfEra = convertField(fields.centuryOfEra, (HashMap<Object, Object>) hashMap);
        fields.era = convertField(fields.era, (HashMap<Object, Object>) hashMap);
        fields.dayOfWeek = convertField(fields.dayOfWeek, (HashMap<Object, Object>) hashMap);
        fields.dayOfMonth = convertField(fields.dayOfMonth, (HashMap<Object, Object>) hashMap);
        fields.dayOfYear = convertField(fields.dayOfYear, (HashMap<Object, Object>) hashMap);
        fields.monthOfYear = convertField(fields.monthOfYear, (HashMap<Object, Object>) hashMap);
        fields.weekOfWeekyear = convertField(fields.weekOfWeekyear, (HashMap<Object, Object>) hashMap);
        fields.weekyear = convertField(fields.weekyear, (HashMap<Object, Object>) hashMap);
        fields.weekyearOfCentury = convertField(fields.weekyearOfCentury, (HashMap<Object, Object>) hashMap);
        fields.millisOfSecond = convertField(fields.millisOfSecond, (HashMap<Object, Object>) hashMap);
        fields.millisOfDay = convertField(fields.millisOfDay, (HashMap<Object, Object>) hashMap);
        fields.secondOfMinute = convertField(fields.secondOfMinute, (HashMap<Object, Object>) hashMap);
        fields.secondOfDay = convertField(fields.secondOfDay, (HashMap<Object, Object>) hashMap);
        fields.minuteOfHour = convertField(fields.minuteOfHour, (HashMap<Object, Object>) hashMap);
        fields.minuteOfDay = convertField(fields.minuteOfDay, (HashMap<Object, Object>) hashMap);
        fields.hourOfDay = convertField(fields.hourOfDay, (HashMap<Object, Object>) hashMap);
        fields.hourOfHalfday = convertField(fields.hourOfHalfday, (HashMap<Object, Object>) hashMap);
        fields.clockhourOfDay = convertField(fields.clockhourOfDay, (HashMap<Object, Object>) hashMap);
        fields.clockhourOfHalfday = convertField(fields.clockhourOfHalfday, (HashMap<Object, Object>) hashMap);
        fields.halfdayOfDay = convertField(fields.halfdayOfDay, (HashMap<Object, Object>) hashMap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedChronology)) {
            return false;
        }
        ZonedChronology zonedChronology = (ZonedChronology) obj;
        if (!getBase().equals(zonedChronology.getBase()) || !getZone().equals(zonedChronology.getZone())) {
            return false;
        }
        return true;
    }

    public long getDateTimeMillis(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        return localToUTC(getBase().getDateTimeMillis(i2, i3, i4, i5));
    }

    public DateTimeZone getZone() {
        return (DateTimeZone) getParam();
    }

    public int hashCode() {
        return (getZone().hashCode() * 11) + 326565 + (getBase().hashCode() * 7);
    }

    public String toString() {
        return "ZonedChronology[" + getBase() + ", " + getZone().getID() + ']';
    }

    public Chronology withUTC() {
        return getBase();
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getParam()) {
            return this;
        }
        if (dateTimeZone == DateTimeZone.UTC) {
            return getBase();
        }
        return new ZonedChronology(getBase(), dateTimeZone);
    }

    public long getDateTimeMillis(int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        return localToUTC(getBase().getDateTimeMillis(i2, i3, i4, i5, i6, i7, i8));
    }

    public long getDateTimeMillis(long j2, int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        return localToUTC(getBase().getDateTimeMillis(((long) getZone().getOffset(j2)) + j2, i2, i3, i4, i5));
    }

    private DateTimeField convertField(DateTimeField dateTimeField, HashMap<Object, Object> hashMap) {
        if (dateTimeField == null || !dateTimeField.isSupported()) {
            return dateTimeField;
        }
        if (hashMap.containsKey(dateTimeField)) {
            return (DateTimeField) hashMap.get(dateTimeField);
        }
        ZonedDateTimeField zonedDateTimeField = new ZonedDateTimeField(dateTimeField, getZone(), convertField(dateTimeField.getDurationField(), hashMap), convertField(dateTimeField.getRangeDurationField(), hashMap), convertField(dateTimeField.getLeapDurationField(), hashMap));
        hashMap.put(dateTimeField, zonedDateTimeField);
        return zonedDateTimeField;
    }
}
