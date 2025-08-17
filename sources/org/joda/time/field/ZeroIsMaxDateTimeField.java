package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;

public final class ZeroIsMaxDateTimeField extends DecoratedDateTimeField {
    private static final long serialVersionUID = 961749798233026866L;

    public ZeroIsMaxDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType) {
        super(dateTimeField, dateTimeFieldType);
        if (dateTimeField.getMinimumValue() != 0) {
            throw new IllegalArgumentException("Wrapped field's minumum value must be zero");
        }
    }

    public long add(long j2, int i2) {
        return getWrappedField().add(j2, i2);
    }

    public long addWrapField(long j2, int i2) {
        return getWrappedField().addWrapField(j2, i2);
    }

    public int get(long j2) {
        int i2 = getWrappedField().get(j2);
        if (i2 == 0) {
            return getMaximumValue();
        }
        return i2;
    }

    public int getDifference(long j2, long j3) {
        return getWrappedField().getDifference(j2, j3);
    }

    public long getDifferenceAsLong(long j2, long j3) {
        return getWrappedField().getDifferenceAsLong(j2, j3);
    }

    public int getLeapAmount(long j2) {
        return getWrappedField().getLeapAmount(j2);
    }

    public DurationField getLeapDurationField() {
        return getWrappedField().getLeapDurationField();
    }

    public int getMaximumValue() {
        return getWrappedField().getMaximumValue() + 1;
    }

    public int getMinimumValue() {
        return 1;
    }

    public int getMinimumValue(long j2) {
        return 1;
    }

    public int getMinimumValue(ReadablePartial readablePartial) {
        return 1;
    }

    public int getMinimumValue(ReadablePartial readablePartial, int[] iArr) {
        return 1;
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
        int maximumValue = getMaximumValue();
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, 1, maximumValue);
        if (i2 == maximumValue) {
            i2 = 0;
        }
        return getWrappedField().set(j2, i2);
    }

    public long add(long j2, long j3) {
        return getWrappedField().add(j2, j3);
    }

    public int[] addWrapField(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        return getWrappedField().addWrapField(readablePartial, i2, iArr, i3);
    }

    public int getMaximumValue(long j2) {
        return getWrappedField().getMaximumValue(j2) + 1;
    }

    public int getMaximumValue(ReadablePartial readablePartial) {
        return getWrappedField().getMaximumValue(readablePartial) + 1;
    }

    public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
        return getWrappedField().getMaximumValue(readablePartial, iArr) + 1;
    }
}
