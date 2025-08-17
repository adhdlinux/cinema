package org.joda.time.base;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.MutableInterval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadableInterval;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public abstract class AbstractInterval implements ReadableInterval {
    protected AbstractInterval() {
    }

    /* access modifiers changed from: protected */
    public void checkInterval(long j2, long j3) {
        if (j3 < j2) {
            throw new IllegalArgumentException("The end instant must be greater than the start instant");
        }
    }

    public boolean contains(long j2) {
        return j2 >= getStartMillis() && j2 < getEndMillis();
    }

    public boolean containsNow() {
        return contains(DateTimeUtils.currentTimeMillis());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadableInterval)) {
            return false;
        }
        ReadableInterval readableInterval = (ReadableInterval) obj;
        if (getStartMillis() == readableInterval.getStartMillis() && getEndMillis() == readableInterval.getEndMillis() && FieldUtils.equals(getChronology(), readableInterval.getChronology())) {
            return true;
        }
        return false;
    }

    public DateTime getEnd() {
        return new DateTime(getEndMillis(), getChronology());
    }

    public DateTime getStart() {
        return new DateTime(getStartMillis(), getChronology());
    }

    public int hashCode() {
        long startMillis = getStartMillis();
        long endMillis = getEndMillis();
        return ((((3007 + ((int) (startMillis ^ (startMillis >>> 32)))) * 31) + ((int) (endMillis ^ (endMillis >>> 32)))) * 31) + getChronology().hashCode();
    }

    public boolean isAfter(long j2) {
        return getStartMillis() > j2;
    }

    public boolean isAfterNow() {
        return isAfter(DateTimeUtils.currentTimeMillis());
    }

    public boolean isBefore(long j2) {
        return getEndMillis() <= j2;
    }

    public boolean isBeforeNow() {
        return isBefore(DateTimeUtils.currentTimeMillis());
    }

    public boolean isEqual(ReadableInterval readableInterval) {
        return getStartMillis() == readableInterval.getStartMillis() && getEndMillis() == readableInterval.getEndMillis();
    }

    public boolean overlaps(ReadableInterval readableInterval) {
        long startMillis = getStartMillis();
        long endMillis = getEndMillis();
        if (readableInterval == null) {
            long currentTimeMillis = DateTimeUtils.currentTimeMillis();
            if (startMillis >= currentTimeMillis || currentTimeMillis >= endMillis) {
                return false;
            }
            return true;
        }
        long startMillis2 = readableInterval.getStartMillis();
        if (startMillis >= readableInterval.getEndMillis() || startMillis2 >= endMillis) {
            return false;
        }
        return true;
    }

    public Duration toDuration() {
        long durationMillis = toDurationMillis();
        if (durationMillis == 0) {
            return Duration.ZERO;
        }
        return new Duration(durationMillis);
    }

    public long toDurationMillis() {
        return FieldUtils.safeSubtract(getEndMillis(), getStartMillis());
    }

    public Interval toInterval() {
        return new Interval(getStartMillis(), getEndMillis(), getChronology());
    }

    public MutableInterval toMutableInterval() {
        return new MutableInterval(getStartMillis(), getEndMillis(), getChronology());
    }

    public Period toPeriod() {
        return new Period(getStartMillis(), getEndMillis(), getChronology());
    }

    public String toString() {
        DateTimeFormatter withChronology = ISODateTimeFormat.dateTime().withChronology(getChronology());
        StringBuffer stringBuffer = new StringBuffer(48);
        withChronology.printTo(stringBuffer, getStartMillis());
        stringBuffer.append('/');
        withChronology.printTo(stringBuffer, getEndMillis());
        return stringBuffer.toString();
    }

    public boolean isAfter(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return isAfterNow();
        }
        return isAfter(readableInstant.getMillis());
    }

    public boolean isBefore(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return isBeforeNow();
        }
        return isBefore(readableInstant.getMillis());
    }

    public Period toPeriod(PeriodType periodType) {
        return new Period(getStartMillis(), getEndMillis(), periodType, getChronology());
    }

    public boolean contains(ReadableInstant readableInstant) {
        if (readableInstant == null) {
            return containsNow();
        }
        return contains(readableInstant.getMillis());
    }

    public boolean isAfter(ReadableInterval readableInterval) {
        long j2;
        if (readableInterval == null) {
            j2 = DateTimeUtils.currentTimeMillis();
        } else {
            j2 = readableInterval.getEndMillis();
        }
        return getStartMillis() >= j2;
    }

    public boolean isBefore(ReadableInterval readableInterval) {
        if (readableInterval == null) {
            return isBeforeNow();
        }
        return isBefore(readableInterval.getStartMillis());
    }

    public boolean contains(ReadableInterval readableInterval) {
        if (readableInterval == null) {
            return containsNow();
        }
        long startMillis = readableInterval.getStartMillis();
        long endMillis = readableInterval.getEndMillis();
        long startMillis2 = getStartMillis();
        long endMillis2 = getEndMillis();
        return startMillis2 <= startMillis && startMillis < endMillis2 && endMillis <= endMillis2;
    }
}
