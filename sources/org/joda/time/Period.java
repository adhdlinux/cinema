package org.joda.time;

import com.vungle.ads.internal.signals.SignalManager;
import org.joda.convert.FromString;
import org.joda.time.base.BasePeriod;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

public final class Period extends BasePeriod {
    public static final Period ZERO = new Period();
    private static final long serialVersionUID = 741052353876488155L;

    public Period() {
        super(0, (PeriodType) null, (Chronology) null);
    }

    private void checkYearsAndMonths(String str) {
        if (getMonths() != 0) {
            throw new UnsupportedOperationException("Cannot convert to " + str + " as this period contains months and months vary in length");
        } else if (getYears() != 0) {
            throw new UnsupportedOperationException("Cannot convert to " + str + " as this period contains years and years vary in length");
        }
    }

    public static Period days(int i2) {
        return new Period(new int[]{0, 0, 0, i2, 0, 0, 0, 0}, PeriodType.standard());
    }

    public static Period fieldDifference(ReadablePartial readablePartial, ReadablePartial readablePartial2) {
        if (readablePartial == null || readablePartial2 == null) {
            throw new IllegalArgumentException("ReadablePartial objects must not be null");
        } else if (readablePartial.size() == readablePartial2.size()) {
            DurationFieldType[] durationFieldTypeArr = new DurationFieldType[readablePartial.size()];
            int[] iArr = new int[readablePartial.size()];
            int size = readablePartial.size();
            int i2 = 0;
            while (i2 < size) {
                if (readablePartial.getFieldType(i2) == readablePartial2.getFieldType(i2)) {
                    DurationFieldType durationType = readablePartial.getFieldType(i2).getDurationType();
                    durationFieldTypeArr[i2] = durationType;
                    if (i2 <= 0 || durationFieldTypeArr[i2 - 1] != durationType) {
                        iArr[i2] = readablePartial2.getValue(i2) - readablePartial.getValue(i2);
                        i2++;
                    } else {
                        throw new IllegalArgumentException("ReadablePartial objects must not have overlapping fields");
                    }
                } else {
                    throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
                }
            }
            return new Period(iArr, PeriodType.forFields(durationFieldTypeArr));
        } else {
            throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
        }
    }

    public static Period hours(int i2) {
        return new Period(new int[]{0, 0, 0, 0, i2, 0, 0, 0}, PeriodType.standard());
    }

    public static Period millis(int i2) {
        return new Period(new int[]{0, 0, 0, 0, 0, 0, 0, i2}, PeriodType.standard());
    }

    public static Period minutes(int i2) {
        return new Period(new int[]{0, 0, 0, 0, 0, i2, 0, 0}, PeriodType.standard());
    }

    public static Period months(int i2) {
        return new Period(new int[]{0, i2, 0, 0, 0, 0, 0, 0}, PeriodType.standard());
    }

    @FromString
    public static Period parse(String str) {
        return parse(str, ISOPeriodFormat.standard());
    }

    public static Period seconds(int i2) {
        return new Period(new int[]{0, 0, 0, 0, 0, 0, i2, 0}, PeriodType.standard());
    }

    public static Period weeks(int i2) {
        return new Period(new int[]{0, 0, i2, 0, 0, 0, 0, 0}, PeriodType.standard());
    }

    public static Period years(int i2) {
        return new Period(new int[]{i2, 0, 0, 0, 0, 0, 0, 0, 0}, PeriodType.standard());
    }

    public int getDays() {
        return getPeriodType().getIndexedField(this, PeriodType.DAY_INDEX);
    }

    public int getHours() {
        return getPeriodType().getIndexedField(this, PeriodType.HOUR_INDEX);
    }

    public int getMillis() {
        return getPeriodType().getIndexedField(this, PeriodType.MILLI_INDEX);
    }

    public int getMinutes() {
        return getPeriodType().getIndexedField(this, PeriodType.MINUTE_INDEX);
    }

    public int getMonths() {
        return getPeriodType().getIndexedField(this, PeriodType.MONTH_INDEX);
    }

    public int getSeconds() {
        return getPeriodType().getIndexedField(this, PeriodType.SECOND_INDEX);
    }

    public int getWeeks() {
        return getPeriodType().getIndexedField(this, PeriodType.WEEK_INDEX);
    }

    public int getYears() {
        return getPeriodType().getIndexedField(this, PeriodType.YEAR_INDEX);
    }

    public Period minus(ReadablePeriod readablePeriod) {
        if (readablePeriod == null) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, values, -readablePeriod.get(DurationFieldType.YEARS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, values, -readablePeriod.get(DurationFieldType.MONTHS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, values, -readablePeriod.get(DurationFieldType.WEEKS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, values, -readablePeriod.get(DurationFieldType.DAYS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, values, -readablePeriod.get(DurationFieldType.HOURS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, values, -readablePeriod.get(DurationFieldType.MINUTES_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, values, -readablePeriod.get(DurationFieldType.SECONDS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, values, -readablePeriod.get(DurationFieldType.MILLIS_TYPE));
        return new Period(values, getPeriodType());
    }

    public Period minusDays(int i2) {
        return plusDays(-i2);
    }

    public Period minusHours(int i2) {
        return plusHours(-i2);
    }

    public Period minusMillis(int i2) {
        return plusMillis(-i2);
    }

    public Period minusMinutes(int i2) {
        return plusMinutes(-i2);
    }

    public Period minusMonths(int i2) {
        return plusMonths(-i2);
    }

    public Period minusSeconds(int i2) {
        return plusSeconds(-i2);
    }

    public Period minusWeeks(int i2) {
        return plusWeeks(-i2);
    }

    public Period minusYears(int i2) {
        return plusYears(-i2);
    }

    public Period multipliedBy(int i2) {
        if (this == ZERO || i2 == 1) {
            return this;
        }
        int[] values = getValues();
        for (int i3 = 0; i3 < values.length; i3++) {
            values[i3] = FieldUtils.safeMultiply(values[i3], i2);
        }
        return new Period(values, getPeriodType());
    }

    public Period negated() {
        return multipliedBy(-1);
    }

    public Period normalizedStandard() {
        return normalizedStandard(PeriodType.standard());
    }

    public Period plus(ReadablePeriod readablePeriod) {
        if (readablePeriod == null) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, values, readablePeriod.get(DurationFieldType.YEARS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, values, readablePeriod.get(DurationFieldType.MONTHS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, values, readablePeriod.get(DurationFieldType.WEEKS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, values, readablePeriod.get(DurationFieldType.DAYS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, values, readablePeriod.get(DurationFieldType.HOURS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, values, readablePeriod.get(DurationFieldType.MINUTES_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, values, readablePeriod.get(DurationFieldType.SECONDS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, values, readablePeriod.get(DurationFieldType.MILLIS_TYPE));
        return new Period(values, getPeriodType());
    }

    public Period plusDays(int i2) {
        if (i2 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period plusHours(int i2) {
        if (i2 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period plusMillis(int i2) {
        if (i2 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period plusMinutes(int i2) {
        if (i2 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period plusMonths(int i2) {
        if (i2 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period plusSeconds(int i2) {
        if (i2 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period plusWeeks(int i2) {
        if (i2 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period plusYears(int i2) {
        if (i2 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period toPeriod() {
        return this;
    }

    public Days toStandardDays() {
        checkYearsAndMonths("Days");
        return Days.days(FieldUtils.safeToInt(FieldUtils.safeAdd(FieldUtils.safeAdd((((((long) getMillis()) + (((long) getSeconds()) * 1000)) + (((long) getMinutes()) * 60000)) + (((long) getHours()) * 3600000)) / SignalManager.TWENTY_FOUR_HOURS_MILLIS, (long) getDays()), ((long) getWeeks()) * 7)));
    }

    public Duration toStandardDuration() {
        checkYearsAndMonths("Duration");
        return new Duration(((long) getMillis()) + (((long) getSeconds()) * 1000) + (((long) getMinutes()) * 60000) + (((long) getHours()) * 3600000) + (((long) getDays()) * SignalManager.TWENTY_FOUR_HOURS_MILLIS) + (((long) getWeeks()) * 604800000));
    }

    public Hours toStandardHours() {
        checkYearsAndMonths("Hours");
        return Hours.hours(FieldUtils.safeToInt(FieldUtils.safeAdd(FieldUtils.safeAdd(FieldUtils.safeAdd(((((long) getMillis()) + (((long) getSeconds()) * 1000)) + (((long) getMinutes()) * 60000)) / 3600000, (long) getHours()), ((long) getDays()) * 24), ((long) getWeeks()) * 168)));
    }

    public Minutes toStandardMinutes() {
        checkYearsAndMonths("Minutes");
        return Minutes.minutes(FieldUtils.safeToInt(FieldUtils.safeAdd(FieldUtils.safeAdd(FieldUtils.safeAdd(FieldUtils.safeAdd((((long) getMillis()) + (((long) getSeconds()) * 1000)) / 60000, (long) getMinutes()), ((long) getHours()) * 60), ((long) getDays()) * 1440), ((long) getWeeks()) * 10080)));
    }

    public Seconds toStandardSeconds() {
        checkYearsAndMonths("Seconds");
        return Seconds.seconds(FieldUtils.safeToInt(FieldUtils.safeAdd(FieldUtils.safeAdd(FieldUtils.safeAdd(FieldUtils.safeAdd(FieldUtils.safeAdd((long) (getMillis() / 1000), (long) getSeconds()), ((long) getMinutes()) * 60), ((long) getHours()) * 3600), ((long) getDays()) * 86400), ((long) getWeeks()) * 604800)));
    }

    public Weeks toStandardWeeks() {
        checkYearsAndMonths("Weeks");
        return Weeks.weeks(FieldUtils.safeToInt(((long) getWeeks()) + (((((((long) getMillis()) + (((long) getSeconds()) * 1000)) + (((long) getMinutes()) * 60000)) + (((long) getHours()) * 3600000)) + (((long) getDays()) * SignalManager.TWENTY_FOUR_HOURS_MILLIS)) / 604800000)));
    }

    public Period withDays(int i2) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.DAY_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period withField(DurationFieldType durationFieldType, int i2) {
        if (durationFieldType != null) {
            int[] values = getValues();
            super.setFieldInto(values, durationFieldType, i2);
            return new Period(values, getPeriodType());
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public Period withFieldAdded(DurationFieldType durationFieldType, int i2) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        } else if (i2 == 0) {
            return this;
        } else {
            int[] values = getValues();
            super.addFieldInto(values, durationFieldType, i2);
            return new Period(values, getPeriodType());
        }
    }

    public Period withFields(ReadablePeriod readablePeriod) {
        if (readablePeriod == null) {
            return this;
        }
        return new Period(super.mergePeriodInto(getValues(), readablePeriod), getPeriodType());
    }

    public Period withHours(int i2) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.HOUR_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period withMillis(int i2) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.MILLI_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period withMinutes(int i2) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.MINUTE_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period withMonths(int i2) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.MONTH_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period withPeriodType(PeriodType periodType) {
        PeriodType periodType2 = DateTimeUtils.getPeriodType(periodType);
        if (periodType2.equals(getPeriodType())) {
            return this;
        }
        return new Period((Object) this, periodType2);
    }

    public Period withSeconds(int i2) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.SECOND_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period withWeeks(int i2) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.WEEK_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period withYears(int i2) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.YEAR_INDEX, values, i2);
        return new Period(values, getPeriodType());
    }

    public Period(int i2, int i3, int i4, int i5) {
        super(0, 0, 0, 0, i2, i3, i4, i5, PeriodType.standard());
    }

    public static Period parse(String str, PeriodFormatter periodFormatter) {
        return periodFormatter.parsePeriod(str);
    }

    public Period normalizedStandard(PeriodType periodType) {
        PeriodType periodType2 = DateTimeUtils.getPeriodType(periodType);
        Period period = new Period(((long) getMillis()) + (((long) getSeconds()) * 1000) + (((long) getMinutes()) * 60000) + (((long) getHours()) * 3600000) + (((long) getDays()) * SignalManager.TWENTY_FOUR_HOURS_MILLIS) + (((long) getWeeks()) * 604800000), periodType2, (Chronology) ISOChronology.getInstanceUTC());
        int years = getYears();
        int months = getMonths();
        if (!(years == 0 && months == 0)) {
            long j2 = (((long) years) * 12) + ((long) months);
            if (periodType2.isSupported(DurationFieldType.YEARS_TYPE)) {
                int safeToInt = FieldUtils.safeToInt(j2 / 12);
                period = period.withYears(safeToInt);
                j2 -= (long) (safeToInt * 12);
            }
            if (periodType2.isSupported(DurationFieldType.MONTHS_TYPE)) {
                int safeToInt2 = FieldUtils.safeToInt(j2);
                j2 -= (long) safeToInt2;
                period = period.withMonths(safeToInt2);
            }
            if (j2 != 0) {
                throw new UnsupportedOperationException("Unable to normalize as PeriodType is missing either years or months but period has a month/year amount: " + toString());
            }
        }
        return period;
    }

    public Period(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super(i2, i3, i4, i5, i6, i7, i8, i9, PeriodType.standard());
    }

    public Period(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, PeriodType periodType) {
        super(i2, i3, i4, i5, i6, i7, i8, i9, periodType);
    }

    public Period(long j2) {
        super(j2);
    }

    public Period(long j2, PeriodType periodType) {
        super(j2, periodType, (Chronology) null);
    }

    public Period(long j2, Chronology chronology) {
        super(j2, (PeriodType) null, chronology);
    }

    public Period(long j2, PeriodType periodType, Chronology chronology) {
        super(j2, periodType, chronology);
    }

    public Period(long j2, long j3) {
        super(j2, j3, (PeriodType) null, (Chronology) null);
    }

    public Period(long j2, long j3, PeriodType periodType) {
        super(j2, j3, periodType, (Chronology) null);
    }

    public Period(long j2, long j3, Chronology chronology) {
        super(j2, j3, (PeriodType) null, chronology);
    }

    public Period(long j2, long j3, PeriodType periodType, Chronology chronology) {
        super(j2, j3, periodType, chronology);
    }

    public Period(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        super(readableInstant, readableInstant2, (PeriodType) null);
    }

    public Period(ReadableInstant readableInstant, ReadableInstant readableInstant2, PeriodType periodType) {
        super(readableInstant, readableInstant2, periodType);
    }

    public Period(ReadablePartial readablePartial, ReadablePartial readablePartial2) {
        super(readablePartial, readablePartial2, (PeriodType) null);
    }

    public Period(ReadablePartial readablePartial, ReadablePartial readablePartial2, PeriodType periodType) {
        super(readablePartial, readablePartial2, periodType);
    }

    public Period(ReadableInstant readableInstant, ReadableDuration readableDuration) {
        super(readableInstant, readableDuration, (PeriodType) null);
    }

    public Period(ReadableInstant readableInstant, ReadableDuration readableDuration, PeriodType periodType) {
        super(readableInstant, readableDuration, periodType);
    }

    public Period(ReadableDuration readableDuration, ReadableInstant readableInstant) {
        super(readableDuration, readableInstant, (PeriodType) null);
    }

    public Period(ReadableDuration readableDuration, ReadableInstant readableInstant, PeriodType periodType) {
        super(readableDuration, readableInstant, periodType);
    }

    public Period(Object obj) {
        super(obj, (PeriodType) null, (Chronology) null);
    }

    public Period(Object obj, PeriodType periodType) {
        super(obj, periodType, (Chronology) null);
    }

    public Period(Object obj, Chronology chronology) {
        super(obj, (PeriodType) null, chronology);
    }

    public Period(Object obj, PeriodType periodType, Chronology chronology) {
        super(obj, periodType, chronology);
    }

    private Period(int[] iArr, PeriodType periodType) {
        super(iArr, periodType);
    }
}
