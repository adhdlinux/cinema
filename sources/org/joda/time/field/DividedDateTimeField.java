package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class DividedDateTimeField extends DecoratedDateTimeField {
    private static final long serialVersionUID = 8318475124230605365L;
    final int iDivisor;
    final DurationField iDurationField;
    private final int iMax;
    private final int iMin;
    final DurationField iRangeDurationField;

    public DividedDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType, int i2) {
        this(dateTimeField, dateTimeField.getRangeDurationField(), dateTimeFieldType, i2);
    }

    private int getRemainder(int i2) {
        if (i2 >= 0) {
            return i2 % this.iDivisor;
        }
        int i3 = this.iDivisor;
        return (i3 - 1) + ((i2 + 1) % i3);
    }

    public long add(long j2, int i2) {
        return getWrappedField().add(j2, i2 * this.iDivisor);
    }

    public long addWrapField(long j2, int i2) {
        return set(j2, FieldUtils.getWrappedValue(get(j2), i2, this.iMin, this.iMax));
    }

    public int get(long j2) {
        int i2 = getWrappedField().get(j2);
        if (i2 >= 0) {
            return i2 / this.iDivisor;
        }
        return ((i2 + 1) / this.iDivisor) - 1;
    }

    public int getDifference(long j2, long j3) {
        return getWrappedField().getDifference(j2, j3) / this.iDivisor;
    }

    public long getDifferenceAsLong(long j2, long j3) {
        return getWrappedField().getDifferenceAsLong(j2, j3) / ((long) this.iDivisor);
    }

    public int getDivisor() {
        return this.iDivisor;
    }

    public DurationField getDurationField() {
        return this.iDurationField;
    }

    public int getMaximumValue() {
        return this.iMax;
    }

    public int getMinimumValue() {
        return this.iMin;
    }

    public DurationField getRangeDurationField() {
        DurationField durationField = this.iRangeDurationField;
        if (durationField != null) {
            return durationField;
        }
        return super.getRangeDurationField();
    }

    public long remainder(long j2) {
        return set(j2, get(getWrappedField().remainder(j2)));
    }

    public long roundFloor(long j2) {
        DateTimeField wrappedField = getWrappedField();
        return wrappedField.roundFloor(wrappedField.set(j2, get(j2) * this.iDivisor));
    }

    public long set(long j2, int i2) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, this.iMin, this.iMax);
        return getWrappedField().set(j2, (i2 * this.iDivisor) + getRemainder(getWrappedField().get(j2)));
    }

    public DividedDateTimeField(DateTimeField dateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType, int i2) {
        super(dateTimeField, dateTimeFieldType);
        if (i2 >= 2) {
            DurationField durationField2 = dateTimeField.getDurationField();
            if (durationField2 == null) {
                this.iDurationField = null;
            } else {
                this.iDurationField = new ScaledDurationField(durationField2, dateTimeFieldType.getDurationType(), i2);
            }
            this.iRangeDurationField = durationField;
            this.iDivisor = i2;
            int minimumValue = dateTimeField.getMinimumValue();
            int i3 = minimumValue >= 0 ? minimumValue / i2 : ((minimumValue + 1) / i2) - 1;
            int maximumValue = dateTimeField.getMaximumValue();
            int i4 = maximumValue >= 0 ? maximumValue / i2 : ((maximumValue + 1) / i2) - 1;
            this.iMin = i3;
            this.iMax = i4;
            return;
        }
        throw new IllegalArgumentException("The divisor must be at least 2");
    }

    public long add(long j2, long j3) {
        return getWrappedField().add(j2, j3 * ((long) this.iDivisor));
    }

    public DividedDateTimeField(RemainderDateTimeField remainderDateTimeField, DateTimeFieldType dateTimeFieldType) {
        this(remainderDateTimeField, (DurationField) null, dateTimeFieldType);
    }

    public DividedDateTimeField(RemainderDateTimeField remainderDateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType) {
        super(remainderDateTimeField.getWrappedField(), dateTimeFieldType);
        int i2 = remainderDateTimeField.iDivisor;
        this.iDivisor = i2;
        this.iDurationField = remainderDateTimeField.iRangeField;
        this.iRangeDurationField = durationField;
        DateTimeField wrappedField = getWrappedField();
        int minimumValue = wrappedField.getMinimumValue();
        int i3 = minimumValue >= 0 ? minimumValue / i2 : ((minimumValue + 1) / i2) - 1;
        int maximumValue = wrappedField.getMaximumValue();
        int i4 = maximumValue >= 0 ? maximumValue / i2 : ((maximumValue + 1) / i2) - 1;
        this.iMin = i3;
        this.iMax = i4;
    }
}
