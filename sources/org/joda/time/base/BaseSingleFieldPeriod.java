package org.joda.time.base;

import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.FieldUtils;

public abstract class BaseSingleFieldPeriod implements ReadablePeriod, Comparable<BaseSingleFieldPeriod>, Serializable {
    private static final long START_1972 = 63072000000L;
    private static final long serialVersionUID = 9386874258972L;
    private volatile int iPeriod;

    protected BaseSingleFieldPeriod(int i2) {
        this.iPeriod = i2;
    }

    protected static int between(ReadableInstant readableInstant, ReadableInstant readableInstant2, DurationFieldType durationFieldType) {
        if (readableInstant != null && readableInstant2 != null) {
            return durationFieldType.getField(DateTimeUtils.getInstantChronology(readableInstant)).getDifference(readableInstant2.getMillis(), readableInstant.getMillis());
        }
        throw new IllegalArgumentException("ReadableInstant objects must not be null");
    }

    protected static int standardPeriodIn(ReadablePeriod readablePeriod, long j2) {
        if (readablePeriod == null) {
            return 0;
        }
        ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
        long j3 = 0;
        for (int i2 = 0; i2 < readablePeriod.size(); i2++) {
            int value = readablePeriod.getValue(i2);
            if (value != 0) {
                DurationField field = readablePeriod.getFieldType(i2).getField(instanceUTC);
                if (field.isPrecise()) {
                    j3 = FieldUtils.safeAdd(j3, FieldUtils.safeMultiply(field.getUnitMillis(), value));
                } else {
                    throw new IllegalArgumentException("Cannot convert period to duration as " + field.getName() + " is not precise in the period " + readablePeriod);
                }
            }
        }
        return FieldUtils.safeToInt(j3 / j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadablePeriod)) {
            return false;
        }
        ReadablePeriod readablePeriod = (ReadablePeriod) obj;
        if (readablePeriod.getPeriodType() == getPeriodType() && readablePeriod.getValue(0) == getValue()) {
            return true;
        }
        return false;
    }

    public int get(DurationFieldType durationFieldType) {
        if (durationFieldType == getFieldType()) {
            return getValue();
        }
        return 0;
    }

    public abstract DurationFieldType getFieldType();

    public DurationFieldType getFieldType(int i2) {
        if (i2 == 0) {
            return getFieldType();
        }
        throw new IndexOutOfBoundsException(String.valueOf(i2));
    }

    public abstract PeriodType getPeriodType();

    /* access modifiers changed from: protected */
    public int getValue() {
        return this.iPeriod;
    }

    public int hashCode() {
        return ((459 + getValue()) * 27) + getFieldType().hashCode();
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        return durationFieldType == getFieldType();
    }

    /* access modifiers changed from: protected */
    public void setValue(int i2) {
        this.iPeriod = i2;
    }

    public int size() {
        return 1;
    }

    public MutablePeriod toMutablePeriod() {
        MutablePeriod mutablePeriod = new MutablePeriod();
        mutablePeriod.add((ReadablePeriod) this);
        return mutablePeriod;
    }

    public Period toPeriod() {
        return Period.ZERO.withFields(this);
    }

    public int compareTo(BaseSingleFieldPeriod baseSingleFieldPeriod) {
        if (baseSingleFieldPeriod.getClass() == getClass()) {
            int value = baseSingleFieldPeriod.getValue();
            int value2 = getValue();
            if (value2 > value) {
                return 1;
            }
            return value2 < value ? -1 : 0;
        }
        throw new ClassCastException(getClass() + " cannot be compared to " + baseSingleFieldPeriod.getClass());
    }

    public int getValue(int i2) {
        if (i2 == 0) {
            return getValue();
        }
        throw new IndexOutOfBoundsException(String.valueOf(i2));
    }

    protected static int between(ReadablePartial readablePartial, ReadablePartial readablePartial2, ReadablePeriod readablePeriod) {
        if (readablePartial == null || readablePartial2 == null) {
            throw new IllegalArgumentException("ReadablePartial objects must not be null");
        } else if (readablePartial.size() == readablePartial2.size()) {
            int size = readablePartial.size();
            int i2 = 0;
            while (i2 < size) {
                if (readablePartial.getFieldType(i2) == readablePartial2.getFieldType(i2)) {
                    i2++;
                } else {
                    throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
                }
            }
            if (DateTimeUtils.isContiguous(readablePartial)) {
                Chronology withUTC = DateTimeUtils.getChronology(readablePartial.getChronology()).withUTC();
                return withUTC.get(readablePeriod, withUTC.set(readablePartial, START_1972), withUTC.set(readablePartial2, START_1972))[0];
            }
            throw new IllegalArgumentException("ReadablePartial objects must be contiguous");
        } else {
            throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
        }
    }
}
