package org.joda.time.chrono;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;
import org.joda.time.field.DecoratedDateTimeField;
import org.joda.time.field.FieldUtils;

class ISOYearOfEraDateTimeField extends DecoratedDateTimeField {
    static final DateTimeField INSTANCE = new ISOYearOfEraDateTimeField();
    private static final long serialVersionUID = 7037524068969447317L;

    private ISOYearOfEraDateTimeField() {
        super(GregorianChronology.getInstanceUTC().year(), DateTimeFieldType.yearOfEra());
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public long add(long j2, int i2) {
        return getWrappedField().add(j2, i2);
    }

    public long addWrapField(long j2, int i2) {
        return getWrappedField().addWrapField(j2, i2);
    }

    public int get(long j2) {
        int i2 = getWrappedField().get(j2);
        return i2 < 0 ? -i2 : i2;
    }

    public int getDifference(long j2, long j3) {
        return getWrappedField().getDifference(j2, j3);
    }

    public long getDifferenceAsLong(long j2, long j3) {
        return getWrappedField().getDifferenceAsLong(j2, j3);
    }

    public int getMaximumValue() {
        return getWrappedField().getMaximumValue();
    }

    public int getMinimumValue() {
        return 0;
    }

    public DurationField getRangeDurationField() {
        return GregorianChronology.getInstanceUTC().eras();
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

    public long set(long j2, int i2) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, 0, getMaximumValue());
        if (getWrappedField().get(j2) < 0) {
            i2 = -i2;
        }
        return super.set(j2, i2);
    }

    public long add(long j2, long j3) {
        return getWrappedField().add(j2, j3);
    }

    public int[] addWrapField(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        return getWrappedField().addWrapField(readablePartial, i2, iArr, i3);
    }
}
