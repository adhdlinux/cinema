package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public class PreciseDateTimeField extends PreciseDurationDateTimeField {
    private static final long serialVersionUID = -5586801265774496376L;
    private final int iRange;
    private final DurationField iRangeField;

    public PreciseDateTimeField(DateTimeFieldType dateTimeFieldType, DurationField durationField, DurationField durationField2) {
        super(dateTimeFieldType, durationField);
        if (durationField2.isPrecise()) {
            int unitMillis = (int) (durationField2.getUnitMillis() / getUnitMillis());
            this.iRange = unitMillis;
            if (unitMillis >= 2) {
                this.iRangeField = durationField2;
                return;
            }
            throw new IllegalArgumentException("The effective range must be at least 2");
        }
        throw new IllegalArgumentException("Range duration field must be precise");
    }

    public long addWrapField(long j2, int i2) {
        int i3 = get(j2);
        return j2 + (((long) (FieldUtils.getWrappedValue(i3, i2, getMinimumValue(), getMaximumValue()) - i3)) * getUnitMillis());
    }

    public int get(long j2) {
        if (j2 >= 0) {
            return (int) ((j2 / getUnitMillis()) % ((long) this.iRange));
        }
        return (this.iRange - 1) + ((int) (((j2 + 1) / getUnitMillis()) % ((long) this.iRange)));
    }

    public int getMaximumValue() {
        return this.iRange - 1;
    }

    public int getRange() {
        return this.iRange;
    }

    public DurationField getRangeDurationField() {
        return this.iRangeField;
    }

    public long set(long j2, int i2) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, getMinimumValue(), getMaximumValue());
        return j2 + (((long) (i2 - get(j2))) * this.iUnitMillis);
    }
}
