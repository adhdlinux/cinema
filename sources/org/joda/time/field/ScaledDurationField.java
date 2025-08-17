package org.joda.time.field;

import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public class ScaledDurationField extends DecoratedDurationField {
    private static final long serialVersionUID = -3205227092378684157L;
    private final int iScalar;

    public ScaledDurationField(DurationField durationField, DurationFieldType durationFieldType, int i2) {
        super(durationField, durationFieldType);
        if (i2 == 0 || i2 == 1) {
            throw new IllegalArgumentException("The scalar must not be 0 or 1");
        }
        this.iScalar = i2;
    }

    public long add(long j2, int i2) {
        return getWrappedField().add(j2, ((long) i2) * ((long) this.iScalar));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScaledDurationField)) {
            return false;
        }
        ScaledDurationField scaledDurationField = (ScaledDurationField) obj;
        if (getWrappedField().equals(scaledDurationField.getWrappedField()) && getType() == scaledDurationField.getType() && this.iScalar == scaledDurationField.iScalar) {
            return true;
        }
        return false;
    }

    public int getDifference(long j2, long j3) {
        return getWrappedField().getDifference(j2, j3) / this.iScalar;
    }

    public long getDifferenceAsLong(long j2, long j3) {
        return getWrappedField().getDifferenceAsLong(j2, j3) / ((long) this.iScalar);
    }

    public long getMillis(int i2) {
        return getWrappedField().getMillis(((long) i2) * ((long) this.iScalar));
    }

    public int getScalar() {
        return this.iScalar;
    }

    public long getUnitMillis() {
        return getWrappedField().getUnitMillis() * ((long) this.iScalar);
    }

    public int getValue(long j2) {
        return getWrappedField().getValue(j2) / this.iScalar;
    }

    public long getValueAsLong(long j2) {
        return getWrappedField().getValueAsLong(j2) / ((long) this.iScalar);
    }

    public int hashCode() {
        long j2 = (long) this.iScalar;
        return ((int) (j2 ^ (j2 >>> 32))) + getType().hashCode() + getWrappedField().hashCode();
    }

    public int getValue(long j2, long j3) {
        return getWrappedField().getValue(j2, j3) / this.iScalar;
    }

    public long getValueAsLong(long j2, long j3) {
        return getWrappedField().getValueAsLong(j2, j3) / ((long) this.iScalar);
    }

    public long add(long j2, long j3) {
        return getWrappedField().add(j2, FieldUtils.safeMultiply(j3, this.iScalar));
    }

    public long getMillis(long j2) {
        return getWrappedField().getMillis(FieldUtils.safeMultiply(j2, this.iScalar));
    }

    public long getMillis(int i2, long j2) {
        return getWrappedField().getMillis(((long) i2) * ((long) this.iScalar), j2);
    }

    public long getMillis(long j2, long j3) {
        return getWrappedField().getMillis(FieldUtils.safeMultiply(j2, this.iScalar), j3);
    }
}
