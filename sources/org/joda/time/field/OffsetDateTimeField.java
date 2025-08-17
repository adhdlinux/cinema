package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class OffsetDateTimeField extends DecoratedDateTimeField {
    private static final long serialVersionUID = 3145790132623583142L;
    private final int iMax;
    private final int iMin;
    private final int iOffset;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OffsetDateTimeField(DateTimeField dateTimeField, int i2) {
        this(dateTimeField, dateTimeField == null ? null : dateTimeField.getType(), i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public long add(long j2, int i2) {
        long add = super.add(j2, i2);
        FieldUtils.verifyValueBounds((DateTimeField) this, get(add), this.iMin, this.iMax);
        return add;
    }

    public long addWrapField(long j2, int i2) {
        return set(j2, FieldUtils.getWrappedValue(get(j2), i2, this.iMin, this.iMax));
    }

    public int get(long j2) {
        return super.get(j2) + this.iOffset;
    }

    public int getLeapAmount(long j2) {
        return getWrappedField().getLeapAmount(j2);
    }

    public DurationField getLeapDurationField() {
        return getWrappedField().getLeapDurationField();
    }

    public int getMaximumValue() {
        return this.iMax;
    }

    public int getMinimumValue() {
        return this.iMin;
    }

    public int getOffset() {
        return this.iOffset;
    }

    public boolean isLeap(long j2) {
        return getWrappedField().isLeap(j2);
    }

    public long remainder(long j2) {
        return getWrappedField().remainder(j2);
    }

    public long roundCeiling(long j2) {
        return getWrappedField().roundCeiling(j2);
    }

    public long roundFloor(long j2) {
        return getWrappedField().roundFloor(j2);
    }

    public long roundHalfCeiling(long j2) {
        return getWrappedField().roundHalfCeiling(j2);
    }

    public long roundHalfEven(long j2) {
        return getWrappedField().roundHalfEven(j2);
    }

    public long roundHalfFloor(long j2) {
        return getWrappedField().roundHalfFloor(j2);
    }

    public long set(long j2, int i2) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, this.iMin, this.iMax);
        return super.set(j2, i2 - this.iOffset);
    }

    public OffsetDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i2) {
        this(dateTimeField, dateTimeFieldType, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public OffsetDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i2, int i3, int i4) {
        super(dateTimeField, dateTimeFieldType);
        if (i2 != 0) {
            this.iOffset = i2;
            if (i3 < dateTimeField.getMinimumValue() + i2) {
                this.iMin = dateTimeField.getMinimumValue() + i2;
            } else {
                this.iMin = i3;
            }
            if (i4 > dateTimeField.getMaximumValue() + i2) {
                this.iMax = dateTimeField.getMaximumValue() + i2;
            } else {
                this.iMax = i4;
            }
        } else {
            throw new IllegalArgumentException("The offset cannot be zero");
        }
    }

    public long add(long j2, long j3) {
        long add = super.add(j2, j3);
        FieldUtils.verifyValueBounds((DateTimeField) this, get(add), this.iMin, this.iMax);
        return add;
    }
}
