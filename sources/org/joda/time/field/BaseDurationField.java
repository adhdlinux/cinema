package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public abstract class BaseDurationField extends DurationField implements Serializable {
    private static final long serialVersionUID = -2554245107589433218L;
    private final DurationFieldType iType;

    protected BaseDurationField(DurationFieldType durationFieldType) {
        if (durationFieldType != null) {
            this.iType = durationFieldType;
            return;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    public int getDifference(long j2, long j3) {
        return FieldUtils.safeToInt(getDifferenceAsLong(j2, j3));
    }

    public long getMillis(int i2) {
        return ((long) i2) * getUnitMillis();
    }

    public final String getName() {
        return this.iType.getName();
    }

    public final DurationFieldType getType() {
        return this.iType;
    }

    public int getValue(long j2) {
        return FieldUtils.safeToInt(getValueAsLong(j2));
    }

    public long getValueAsLong(long j2) {
        return j2 / getUnitMillis();
    }

    public final boolean isSupported() {
        return true;
    }

    public String toString() {
        return "DurationField[" + getName() + ']';
    }

    public int compareTo(DurationField durationField) {
        int i2 = (getUnitMillis() > durationField.getUnitMillis() ? 1 : (getUnitMillis() == durationField.getUnitMillis() ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        return i2 < 0 ? -1 : 1;
    }

    public long getMillis(long j2) {
        return FieldUtils.safeMultiply(j2, getUnitMillis());
    }

    public int getValue(long j2, long j3) {
        return FieldUtils.safeToInt(getValueAsLong(j2, j3));
    }
}
