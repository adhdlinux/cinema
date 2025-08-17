package org.joda.time;

import org.joda.time.base.BaseInterval;
import org.joda.time.field.FieldUtils;

public class MutableInterval extends BaseInterval implements ReadWritableInterval, Cloneable {
    private static final long serialVersionUID = -5982824024992428470L;

    public MutableInterval() {
        super(0, 0, (Chronology) null);
    }

    public static MutableInterval parse(String str) {
        return new MutableInterval(str);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError("Clone error");
        }
    }

    public MutableInterval copy() {
        return (MutableInterval) clone();
    }

    public void setChronology(Chronology chronology) {
        super.setInterval(getStartMillis(), getEndMillis(), chronology);
    }

    public void setDurationAfterStart(long j2) {
        setEndMillis(FieldUtils.safeAdd(getStartMillis(), j2));
    }

    public void setDurationBeforeEnd(long j2) {
        setStartMillis(FieldUtils.safeAdd(getEndMillis(), -j2));
    }

    public void setEnd(ReadableInstant readableInstant) {
        super.setInterval(getStartMillis(), DateTimeUtils.getInstantMillis(readableInstant), getChronology());
    }

    public void setEndMillis(long j2) {
        super.setInterval(getStartMillis(), j2, getChronology());
    }

    public void setInterval(long j2, long j3) {
        super.setInterval(j2, j3, getChronology());
    }

    public void setPeriodAfterStart(ReadablePeriod readablePeriod) {
        if (readablePeriod == null) {
            setEndMillis(getStartMillis());
        } else {
            setEndMillis(getChronology().add(readablePeriod, getStartMillis(), 1));
        }
    }

    public void setPeriodBeforeEnd(ReadablePeriod readablePeriod) {
        if (readablePeriod == null) {
            setStartMillis(getEndMillis());
        } else {
            setStartMillis(getChronology().add(readablePeriod, getEndMillis(), -1));
        }
    }

    public void setStart(ReadableInstant readableInstant) {
        super.setInterval(DateTimeUtils.getInstantMillis(readableInstant), getEndMillis(), getChronology());
    }

    public void setStartMillis(long j2) {
        super.setInterval(j2, getEndMillis(), getChronology());
    }

    public MutableInterval(long j2, long j3) {
        super(j2, j3, (Chronology) null);
    }

    public void setDurationAfterStart(ReadableDuration readableDuration) {
        setEndMillis(FieldUtils.safeAdd(getStartMillis(), DateTimeUtils.getDurationMillis(readableDuration)));
    }

    public void setDurationBeforeEnd(ReadableDuration readableDuration) {
        setStartMillis(FieldUtils.safeAdd(getEndMillis(), -DateTimeUtils.getDurationMillis(readableDuration)));
    }

    public void setInterval(ReadableInterval readableInterval) {
        if (readableInterval != null) {
            super.setInterval(readableInterval.getStartMillis(), readableInterval.getEndMillis(), readableInterval.getChronology());
            return;
        }
        throw new IllegalArgumentException("Interval must not be null");
    }

    public MutableInterval(long j2, long j3, Chronology chronology) {
        super(j2, j3, chronology);
    }

    public MutableInterval(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        super(readableInstant, readableInstant2);
    }

    public MutableInterval(ReadableInstant readableInstant, ReadableDuration readableDuration) {
        super(readableInstant, readableDuration);
    }

    public MutableInterval(ReadableDuration readableDuration, ReadableInstant readableInstant) {
        super(readableDuration, readableInstant);
    }

    public MutableInterval(ReadableInstant readableInstant, ReadablePeriod readablePeriod) {
        super(readableInstant, readablePeriod);
    }

    public void setInterval(ReadableInstant readableInstant, ReadableInstant readableInstant2) {
        if (readableInstant == null && readableInstant2 == null) {
            long currentTimeMillis = DateTimeUtils.currentTimeMillis();
            setInterval(currentTimeMillis, currentTimeMillis);
            return;
        }
        super.setInterval(DateTimeUtils.getInstantMillis(readableInstant), DateTimeUtils.getInstantMillis(readableInstant2), DateTimeUtils.getInstantChronology(readableInstant));
    }

    public MutableInterval(ReadablePeriod readablePeriod, ReadableInstant readableInstant) {
        super(readablePeriod, readableInstant);
    }

    public MutableInterval(Object obj) {
        super(obj, (Chronology) null);
    }

    public MutableInterval(Object obj, Chronology chronology) {
        super(obj, chronology);
    }
}
