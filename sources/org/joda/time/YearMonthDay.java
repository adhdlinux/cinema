package org.joda.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractPartialFieldProperty;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISODateTimeFormat;

@Deprecated
public final class YearMonthDay extends BasePartial {
    public static final int DAY_OF_MONTH = 2;
    private static final DateTimeFieldType[] FIELD_TYPES = {DateTimeFieldType.year(), DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth()};
    public static final int MONTH_OF_YEAR = 1;
    public static final int YEAR = 0;
    private static final long serialVersionUID = 797544782896179L;

    public YearMonthDay() {
    }

    public static YearMonthDay fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new YearMonthDay(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static YearMonthDay fromDateFields(Date date) {
        if (date != null) {
            return new YearMonthDay(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public Property dayOfMonth() {
        return new Property(this, 2);
    }

    public int getDayOfMonth() {
        return getValue(2);
    }

    /* access modifiers changed from: protected */
    public DateTimeField getField(int i2, Chronology chronology) {
        if (i2 == 0) {
            return chronology.year();
        }
        if (i2 == 1) {
            return chronology.monthOfYear();
        }
        if (i2 == 2) {
            return chronology.dayOfMonth();
        }
        throw new IndexOutOfBoundsException("Invalid index: " + i2);
    }

    public DateTimeFieldType getFieldType(int i2) {
        return FIELD_TYPES[i2];
    }

    public DateTimeFieldType[] getFieldTypes() {
        return (DateTimeFieldType[]) FIELD_TYPES.clone();
    }

    public int getMonthOfYear() {
        return getValue(1);
    }

    public int getYear() {
        return getValue(0);
    }

    public YearMonthDay minus(ReadablePeriod readablePeriod) {
        return withPeriodAdded(readablePeriod, -1);
    }

    public YearMonthDay minusDays(int i2) {
        return withFieldAdded(DurationFieldType.days(), FieldUtils.safeNegate(i2));
    }

    public YearMonthDay minusMonths(int i2) {
        return withFieldAdded(DurationFieldType.months(), FieldUtils.safeNegate(i2));
    }

    public YearMonthDay minusYears(int i2) {
        return withFieldAdded(DurationFieldType.years(), FieldUtils.safeNegate(i2));
    }

    public Property monthOfYear() {
        return new Property(this, 1);
    }

    public YearMonthDay plus(ReadablePeriod readablePeriod) {
        return withPeriodAdded(readablePeriod, 1);
    }

    public YearMonthDay plusDays(int i2) {
        return withFieldAdded(DurationFieldType.days(), i2);
    }

    public YearMonthDay plusMonths(int i2) {
        return withFieldAdded(DurationFieldType.months(), i2);
    }

    public YearMonthDay plusYears(int i2) {
        return withFieldAdded(DurationFieldType.years(), i2);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    public int size() {
        return 3;
    }

    public DateMidnight toDateMidnight() {
        return toDateMidnight((DateTimeZone) null);
    }

    public DateTime toDateTime(TimeOfDay timeOfDay) {
        return toDateTime(timeOfDay, (DateTimeZone) null);
    }

    public DateTime toDateTimeAtCurrentTime() {
        return toDateTimeAtCurrentTime((DateTimeZone) null);
    }

    public DateTime toDateTimeAtMidnight() {
        return toDateTimeAtMidnight((DateTimeZone) null);
    }

    public Interval toInterval() {
        return toInterval((DateTimeZone) null);
    }

    public LocalDate toLocalDate() {
        return new LocalDate(getYear(), getMonthOfYear(), getDayOfMonth(), getChronology());
    }

    public String toString() {
        return ISODateTimeFormat.yearMonthDay().print((ReadablePartial) this);
    }

    public YearMonthDay withChronologyRetainFields(Chronology chronology) {
        Chronology withUTC = DateTimeUtils.getChronology(chronology).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        YearMonthDay yearMonthDay = new YearMonthDay(this, withUTC);
        withUTC.validate(yearMonthDay, getValues());
        return yearMonthDay;
    }

    public YearMonthDay withDayOfMonth(int i2) {
        return new YearMonthDay(this, getChronology().dayOfMonth().set(this, 2, getValues(), i2));
    }

    public YearMonthDay withField(DateTimeFieldType dateTimeFieldType, int i2) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i2 == getValue(indexOfSupported)) {
            return this;
        }
        return new YearMonthDay(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i2));
    }

    public YearMonthDay withFieldAdded(DurationFieldType durationFieldType, int i2) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i2 == 0) {
            return this;
        }
        return new YearMonthDay(this, getField(indexOfSupported).add(this, indexOfSupported, getValues(), i2));
    }

    public YearMonthDay withMonthOfYear(int i2) {
        return new YearMonthDay(this, getChronology().monthOfYear().set(this, 1, getValues(), i2));
    }

    public YearMonthDay withPeriodAdded(ReadablePeriod readablePeriod, int i2) {
        if (readablePeriod == null || i2 == 0) {
            return this;
        }
        int[] values = getValues();
        for (int i3 = 0; i3 < readablePeriod.size(); i3++) {
            int indexOf = indexOf(readablePeriod.getFieldType(i3));
            if (indexOf >= 0) {
                values = getField(indexOf).add(this, indexOf, values, FieldUtils.safeMultiply(readablePeriod.getValue(i3), i2));
            }
        }
        return new YearMonthDay(this, values);
    }

    public YearMonthDay withYear(int i2) {
        return new YearMonthDay(this, getChronology().year().set(this, 0, getValues(), i2));
    }

    public Property year() {
        return new Property(this, 0);
    }

    public YearMonthDay(DateTimeZone dateTimeZone) {
        super((Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public DateMidnight toDateMidnight(DateTimeZone dateTimeZone) {
        return new DateMidnight(getYear(), getMonthOfYear(), getDayOfMonth(), getChronology().withZone(dateTimeZone));
    }

    public DateTime toDateTime(TimeOfDay timeOfDay, DateTimeZone dateTimeZone) {
        Chronology withZone = getChronology().withZone(dateTimeZone);
        long j2 = withZone.set(this, DateTimeUtils.currentTimeMillis());
        if (timeOfDay != null) {
            j2 = withZone.set(timeOfDay, j2);
        }
        return new DateTime(j2, withZone);
    }

    public DateTime toDateTimeAtCurrentTime(DateTimeZone dateTimeZone) {
        Chronology withZone = getChronology().withZone(dateTimeZone);
        return new DateTime(withZone.set(this, DateTimeUtils.currentTimeMillis()), withZone);
    }

    public DateTime toDateTimeAtMidnight(DateTimeZone dateTimeZone) {
        return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), 0, 0, 0, 0, getChronology().withZone(dateTimeZone));
    }

    public Interval toInterval(DateTimeZone dateTimeZone) {
        return toDateMidnight(DateTimeUtils.getZone(dateTimeZone)).toInterval();
    }

    @Deprecated
    public static class Property extends AbstractPartialFieldProperty implements Serializable {
        private static final long serialVersionUID = 5727734012190224363L;
        private final int iFieldIndex;
        private final YearMonthDay iYearMonthDay;

        Property(YearMonthDay yearMonthDay, int i2) {
            this.iYearMonthDay = yearMonthDay;
            this.iFieldIndex = i2;
        }

        public YearMonthDay addToCopy(int i2) {
            return new YearMonthDay(this.iYearMonthDay, getField().add(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), i2));
        }

        public YearMonthDay addWrapFieldToCopy(int i2) {
            return new YearMonthDay(this.iYearMonthDay, getField().addWrapField(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), i2));
        }

        public int get() {
            return this.iYearMonthDay.getValue(this.iFieldIndex);
        }

        public DateTimeField getField() {
            return this.iYearMonthDay.getField(this.iFieldIndex);
        }

        /* access modifiers changed from: protected */
        public ReadablePartial getReadablePartial() {
            return this.iYearMonthDay;
        }

        public YearMonthDay getYearMonthDay() {
            return this.iYearMonthDay;
        }

        public YearMonthDay setCopy(int i2) {
            return new YearMonthDay(this.iYearMonthDay, getField().set(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), i2));
        }

        public YearMonthDay withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public YearMonthDay withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public YearMonthDay setCopy(String str, Locale locale) {
            return new YearMonthDay(this.iYearMonthDay, getField().set(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), str, locale));
        }

        public YearMonthDay setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    public YearMonthDay(Chronology chronology) {
        super(chronology);
    }

    public YearMonthDay(long j2) {
        super(j2);
    }

    public YearMonthDay(long j2, Chronology chronology) {
        super(j2, chronology);
    }

    public YearMonthDay(Object obj) {
        super(obj, (Chronology) null, ISODateTimeFormat.dateOptionalTimeParser());
    }

    public YearMonthDay(Object obj, Chronology chronology) {
        super(obj, DateTimeUtils.getChronology(chronology), ISODateTimeFormat.dateOptionalTimeParser());
    }

    public YearMonthDay(int i2, int i3, int i4) {
        this(i2, i3, i4, (Chronology) null);
    }

    public YearMonthDay(int i2, int i3, int i4, Chronology chronology) {
        super(new int[]{i2, i3, i4}, chronology);
    }

    YearMonthDay(YearMonthDay yearMonthDay, int[] iArr) {
        super((BasePartial) yearMonthDay, iArr);
    }

    YearMonthDay(YearMonthDay yearMonthDay, Chronology chronology) {
        super((BasePartial) yearMonthDay, chronology);
    }
}
