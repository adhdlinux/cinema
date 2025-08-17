package org.joda.time.field;

import org.joda.time.DurationFieldType;

public class PreciseDurationField extends BaseDurationField {
    private static final long serialVersionUID = -8346152187724495365L;
    private final long iUnitMillis;

    public PreciseDurationField(DurationFieldType durationFieldType, long j2) {
        super(durationFieldType);
        this.iUnitMillis = j2;
    }

    public long add(long j2, int i2) {
        return FieldUtils.safeAdd(j2, ((long) i2) * this.iUnitMillis);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreciseDurationField)) {
            return false;
        }
        PreciseDurationField preciseDurationField = (PreciseDurationField) obj;
        if (getType() == preciseDurationField.getType() && this.iUnitMillis == preciseDurationField.iUnitMillis) {
            return true;
        }
        return false;
    }

    public long getDifferenceAsLong(long j2, long j3) {
        return FieldUtils.safeSubtract(j2, j3) / this.iUnitMillis;
    }

    public long getMillis(int i2, long j2) {
        return ((long) i2) * this.iUnitMillis;
    }

    public final long getUnitMillis() {
        return this.iUnitMillis;
    }

    public long getValueAsLong(long j2, long j3) {
        return j2 / this.iUnitMillis;
    }

    public int hashCode() {
        long j2 = this.iUnitMillis;
        return ((int) (j2 ^ (j2 >>> 32))) + getType().hashCode();
    }

    public final boolean isPrecise() {
        return true;
    }

    public long getMillis(long j2, long j3) {
        return FieldUtils.safeMultiply(j2, this.iUnitMillis);
    }

    public long add(long j2, long j3) {
        return FieldUtils.safeAdd(j2, FieldUtils.safeMultiply(j3, this.iUnitMillis));
    }
}
