package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public abstract class PreciseDurationDateTimeField extends BaseDateTimeField {
    private static final long serialVersionUID = 5004523158306266035L;
    private final DurationField iUnitField;
    final long iUnitMillis;

    public PreciseDurationDateTimeField(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        super(dateTimeFieldType);
        if (durationField.isPrecise()) {
            long unitMillis = durationField.getUnitMillis();
            this.iUnitMillis = unitMillis;
            if (unitMillis >= 1) {
                this.iUnitField = durationField;
                return;
            }
            throw new IllegalArgumentException("The unit milliseconds must be at least 1");
        }
        throw new IllegalArgumentException("Unit duration field must be precise");
    }

    public DurationField getDurationField() {
        return this.iUnitField;
    }

    /* access modifiers changed from: protected */
    public int getMaximumValueForSet(long j2, int i2) {
        return getMaximumValue(j2);
    }

    public int getMinimumValue() {
        return 0;
    }

    public final long getUnitMillis() {
        return this.iUnitMillis;
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j2) {
        if (j2 >= 0) {
            return j2 % this.iUnitMillis;
        }
        long j3 = this.iUnitMillis;
        return (((j2 + 1) % j3) + j3) - 1;
    }

    public long roundCeiling(long j2) {
        if (j2 <= 0) {
            return j2 - (j2 % this.iUnitMillis);
        }
        long j3 = j2 - 1;
        long j4 = this.iUnitMillis;
        return (j3 - (j3 % j4)) + j4;
    }

    public long roundFloor(long j2) {
        long j3;
        if (j2 >= 0) {
            j3 = j2 % this.iUnitMillis;
        } else {
            long j4 = j2 + 1;
            j3 = this.iUnitMillis;
            j2 = j4 - (j4 % j3);
        }
        return j2 - j3;
    }

    public long set(long j2, int i2) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, getMinimumValue(), getMaximumValueForSet(j2, i2));
        return j2 + (((long) (i2 - get(j2))) * this.iUnitMillis);
    }
}
