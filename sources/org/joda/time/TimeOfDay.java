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
public final class TimeOfDay extends BasePartial {
    private static final DateTimeFieldType[] FIELD_TYPES = {DateTimeFieldType.hourOfDay(), DateTimeFieldType.minuteOfHour(), DateTimeFieldType.secondOfMinute(), DateTimeFieldType.millisOfSecond()};
    public static final int HOUR_OF_DAY = 0;
    public static final TimeOfDay MIDNIGHT = new TimeOfDay(0, 0, 0, 0);
    public static final int MILLIS_OF_SECOND = 3;
    public static final int MINUTE_OF_HOUR = 1;
    public static final int SECOND_OF_MINUTE = 2;
    private static final long serialVersionUID = 3633353405803318660L;

    public TimeOfDay() {
    }

    public static TimeOfDay fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new TimeOfDay(calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static TimeOfDay fromDateFields(Date date) {
        if (date != null) {
            return new TimeOfDay(date.getHours(), date.getMinutes(), date.getSeconds(), (((int) (date.getTime() % 1000)) + 1000) % 1000);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static TimeOfDay fromMillisOfDay(long j2) {
        return fromMillisOfDay(j2, (Chronology) null);
    }

    /* access modifiers changed from: protected */
    public DateTimeField getField(int i2, Chronology chronology) {
        if (i2 == 0) {
            return chronology.hourOfDay();
        }
        if (i2 == 1) {
            return chronology.minuteOfHour();
        }
        if (i2 == 2) {
            return chronology.secondOfMinute();
        }
        if (i2 == 3) {
            return chronology.millisOfSecond();
        }
        throw new IndexOutOfBoundsException("Invalid index: " + i2);
    }

    public DateTimeFieldType getFieldType(int i2) {
        return FIELD_TYPES[i2];
    }

    public DateTimeFieldType[] getFieldTypes() {
        return (DateTimeFieldType[]) FIELD_TYPES.clone();
    }

    public int getHourOfDay() {
        return getValue(0);
    }

    public int getMillisOfSecond() {
        return getValue(3);
    }

    public int getMinuteOfHour() {
        return getValue(1);
    }

    public int getSecondOfMinute() {
        return getValue(2);
    }

    public Property hourOfDay() {
        return new Property(this, 0);
    }

    public Property millisOfSecond() {
        return new Property(this, 3);
    }

    public TimeOfDay minus(ReadablePeriod readablePeriod) {
        return withPeriodAdded(readablePeriod, -1);
    }

    public TimeOfDay minusHours(int i2) {
        return withFieldAdded(DurationFieldType.hours(), FieldUtils.safeNegate(i2));
    }

    public TimeOfDay minusMillis(int i2) {
        return withFieldAdded(DurationFieldType.millis(), FieldUtils.safeNegate(i2));
    }

    public TimeOfDay minusMinutes(int i2) {
        return withFieldAdded(DurationFieldType.minutes(), FieldUtils.safeNegate(i2));
    }

    public TimeOfDay minusSeconds(int i2) {
        return withFieldAdded(DurationFieldType.seconds(), FieldUtils.safeNegate(i2));
    }

    public Property minuteOfHour() {
        return new Property(this, 1);
    }

    public TimeOfDay plus(ReadablePeriod readablePeriod) {
        return withPeriodAdded(readablePeriod, 1);
    }

    public TimeOfDay plusHours(int i2) {
        return withFieldAdded(DurationFieldType.hours(), i2);
    }

    public TimeOfDay plusMillis(int i2) {
        return withFieldAdded(DurationFieldType.millis(), i2);
    }

    public TimeOfDay plusMinutes(int i2) {
        return withFieldAdded(DurationFieldType.minutes(), i2);
    }

    public TimeOfDay plusSeconds(int i2) {
        return withFieldAdded(DurationFieldType.seconds(), i2);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    public Property secondOfMinute() {
        return new Property(this, 2);
    }

    public int size() {
        return 4;
    }

    public DateTime toDateTimeToday() {
        return toDateTimeToday((DateTimeZone) null);
    }

    public LocalTime toLocalTime() {
        return new LocalTime(getHourOfDay(), getMinuteOfHour(), getSecondOfMinute(), getMillisOfSecond(), getChronology());
    }

    public String toString() {
        return ISODateTimeFormat.tTime().print((ReadablePartial) this);
    }

    public TimeOfDay withChronologyRetainFields(Chronology chronology) {
        Chronology withUTC = DateTimeUtils.getChronology(chronology).withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        TimeOfDay timeOfDay = new TimeOfDay(this, withUTC);
        withUTC.validate(timeOfDay, getValues());
        return timeOfDay;
    }

    public TimeOfDay withField(DateTimeFieldType dateTimeFieldType, int i2) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i2 == getValue(indexOfSupported)) {
            return this;
        }
        return new TimeOfDay(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i2));
    }

    public TimeOfDay withFieldAdded(DurationFieldType durationFieldType, int i2) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i2 == 0) {
            return this;
        }
        return new TimeOfDay(this, getField(indexOfSupported).addWrapPartial(this, indexOfSupported, getValues(), i2));
    }

    public TimeOfDay withHourOfDay(int i2) {
        return new TimeOfDay(this, getChronology().hourOfDay().set(this, 0, getValues(), i2));
    }

    public TimeOfDay withMillisOfSecond(int i2) {
        return new TimeOfDay(this, getChronology().millisOfSecond().set(this, 3, getValues(), i2));
    }

    public TimeOfDay withMinuteOfHour(int i2) {
        return new TimeOfDay(this, getChronology().minuteOfHour().set(this, 1, getValues(), i2));
    }

    public TimeOfDay withPeriodAdded(ReadablePeriod readablePeriod, int i2) {
        if (readablePeriod == null || i2 == 0) {
            return this;
        }
        int[] values = getValues();
        for (int i3 = 0; i3 < readablePeriod.size(); i3++) {
            int indexOf = indexOf(readablePeriod.getFieldType(i3));
            if (indexOf >= 0) {
                values = getField(indexOf).addWrapPartial(this, indexOf, values, FieldUtils.safeMultiply(readablePeriod.getValue(i3), i2));
            }
        }
        return new TimeOfDay(this, values);
    }

    public TimeOfDay withSecondOfMinute(int i2) {
        return new TimeOfDay(this, getChronology().secondOfMinute().set(this, 2, getValues(), i2));
    }

    public TimeOfDay(DateTimeZone dateTimeZone) {
        super((Chronology) ISOChronology.getInstance(dateTimeZone));
    }

    public static TimeOfDay fromMillisOfDay(long j2, Chronology chronology) {
        return new TimeOfDay(j2, DateTimeUtils.getChronology(chronology).withUTC());
    }

    public DateTime toDateTimeToday(DateTimeZone dateTimeZone) {
        Chronology withZone = getChronology().withZone(dateTimeZone);
        return new DateTime(withZone.set(this, DateTimeUtils.currentTimeMillis()), withZone);
    }

    @Deprecated
    public static class Property extends AbstractPartialFieldProperty implements Serializable {
        private static final long serialVersionUID = 5598459141741063833L;
        private final int iFieldIndex;
        private final TimeOfDay iTimeOfDay;

        Property(TimeOfDay timeOfDay, int i2) {
            this.iTimeOfDay = timeOfDay;
            this.iFieldIndex = i2;
        }

        public TimeOfDay addNoWrapToCopy(int i2) {
            return new TimeOfDay(this.iTimeOfDay, getField().add(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i2));
        }

        public TimeOfDay addToCopy(int i2) {
            return new TimeOfDay(this.iTimeOfDay, getField().addWrapPartial(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i2));
        }

        public TimeOfDay addWrapFieldToCopy(int i2) {
            return new TimeOfDay(this.iTimeOfDay, getField().addWrapField(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i2));
        }

        public int get() {
            return this.iTimeOfDay.getValue(this.iFieldIndex);
        }

        public DateTimeField getField() {
            return this.iTimeOfDay.getField(this.iFieldIndex);
        }

        /* access modifiers changed from: protected */
        public ReadablePartial getReadablePartial() {
            return this.iTimeOfDay;
        }

        public TimeOfDay getTimeOfDay() {
            return this.iTimeOfDay;
        }

        public TimeOfDay setCopy(int i2) {
            return new TimeOfDay(this.iTimeOfDay, getField().set(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i2));
        }

        public TimeOfDay withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public TimeOfDay withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public TimeOfDay setCopy(String str, Locale locale) {
            return new TimeOfDay(this.iTimeOfDay, getField().set(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), str, locale));
        }

        public TimeOfDay setCopy(String str) {
            return setCopy(str, (Locale) null);
        }
    }

    public TimeOfDay(Chronology chronology) {
        super(chronology);
    }

    public TimeOfDay(long j2) {
        super(j2);
    }

    public TimeOfDay(long j2, Chronology chronology) {
        super(j2, chronology);
    }

    public TimeOfDay(Object obj) {
        super(obj, (Chronology) null, ISODateTimeFormat.timeParser());
    }

    public TimeOfDay(Object obj, Chronology chronology) {
        super(obj, DateTimeUtils.getChronology(chronology), ISODateTimeFormat.timeParser());
    }

    public TimeOfDay(int i2, int i3) {
        this(i2, i3, 0, 0, (Chronology) null);
    }

    public TimeOfDay(int i2, int i3, Chronology chronology) {
        this(i2, i3, 0, 0, chronology);
    }

    public TimeOfDay(int i2, int i3, int i4) {
        this(i2, i3, i4, 0, (Chronology) null);
    }

    public TimeOfDay(int i2, int i3, int i4, Chronology chronology) {
        this(i2, i3, i4, 0, chronology);
    }

    public TimeOfDay(int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5, (Chronology) null);
    }

    public TimeOfDay(int i2, int i3, int i4, int i5, Chronology chronology) {
        super(new int[]{i2, i3, i4, i5}, chronology);
    }

    TimeOfDay(TimeOfDay timeOfDay, int[] iArr) {
        super((BasePartial) timeOfDay, iArr);
    }

    TimeOfDay(TimeOfDay timeOfDay, Chronology chronology) {
        super((BasePartial) timeOfDay, chronology);
    }
}
