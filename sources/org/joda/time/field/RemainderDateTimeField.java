package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class RemainderDateTimeField extends DecoratedDateTimeField {
    private static final long serialVersionUID = 5708241235177666790L;
    final int iDivisor;
    final DurationField iDurationField;
    final DurationField iRangeField;

    public RemainderDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i2) {
        super(dateTimeField, dateTimeFieldType);
        if (i2 >= 2) {
            DurationField durationField = dateTimeField.getDurationField();
            if (durationField == null) {
                this.iRangeField = null;
            } else {
                this.iRangeField = new ScaledDurationField(durationField, dateTimeFieldType.getRangeDurationType(), i2);
            }
            this.iDurationField = dateTimeField.getDurationField();
            this.iDivisor = i2;
            return;
        }
        throw new IllegalArgumentException("The divisor must be at least 2");
    }

    private int getDivided(int i2) {
        if (i2 >= 0) {
            return i2 / this.iDivisor;
        }
        return ((i2 + 1) / this.iDivisor) - 1;
    }

    public long addWrapField(long j2, int i2) {
        return set(j2, FieldUtils.getWrappedValue(get(j2), i2, 0, this.iDivisor - 1));
    }

    public int get(long j2) {
        int i2 = getWrappedField().get(j2);
        if (i2 >= 0) {
            return i2 % this.iDivisor;
        }
        int i3 = this.iDivisor;
        return (i3 - 1) + ((i2 + 1) % i3);
    }

    public int getDivisor() {
        return this.iDivisor;
    }

    public DurationField getDurationField() {
        return this.iDurationField;
    }

    public int getMaximumValue() {
        return this.iDivisor - 1;
    }

    public int getMinimumValue() {
        return 0;
    }

    public DurationField getRangeDurationField() {
        return this.iRangeField;
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
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, 0, this.iDivisor - 1);
        return getWrappedField().set(j2, (getDivided(getWrappedField().get(j2)) * this.iDivisor) + i2);
    }

    public RemainderDateTimeField(DateTimeField dateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType, int i2) {
        super(dateTimeField, dateTimeFieldType);
        if (i2 >= 2) {
            this.iRangeField = durationField;
            this.iDurationField = dateTimeField.getDurationField();
            this.iDivisor = i2;
            return;
        }
        throw new IllegalArgumentException("The divisor must be at least 2");
    }

    public RemainderDateTimeField(DividedDateTimeField dividedDateTimeField) {
        this(dividedDateTimeField, dividedDateTimeField.getType());
    }

    public RemainderDateTimeField(DividedDateTimeField dividedDateTimeField, DateTimeFieldType dateTimeFieldType) {
        this(dividedDateTimeField, dividedDateTimeField.getWrappedField().getDurationField(), dateTimeFieldType);
    }

    public RemainderDateTimeField(DividedDateTimeField dividedDateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType) {
        super(dividedDateTimeField.getWrappedField(), dateTimeFieldType);
        this.iDivisor = dividedDateTimeField.iDivisor;
        this.iDurationField = durationField;
        this.iRangeField = dividedDateTimeField.iDurationField;
    }
}
