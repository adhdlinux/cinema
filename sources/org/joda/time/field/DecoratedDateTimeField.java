package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;

public abstract class DecoratedDateTimeField extends BaseDateTimeField {
    private static final long serialVersionUID = 203115783733757597L;
    private final DateTimeField iField;

    protected DecoratedDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType) {
        super(dateTimeFieldType);
        if (dateTimeField == null) {
            throw new IllegalArgumentException("The field must not be null");
        } else if (dateTimeField.isSupported()) {
            this.iField = dateTimeField;
        } else {
            throw new IllegalArgumentException("The field must be supported");
        }
    }

    public int get(long j2) {
        return this.iField.get(j2);
    }

    public DurationField getDurationField() {
        return this.iField.getDurationField();
    }

    public int getMaximumValue() {
        return this.iField.getMaximumValue();
    }

    public int getMinimumValue() {
        return this.iField.getMinimumValue();
    }

    public DurationField getRangeDurationField() {
        return this.iField.getRangeDurationField();
    }

    public final DateTimeField getWrappedField() {
        return this.iField;
    }

    public boolean isLenient() {
        return this.iField.isLenient();
    }

    public long roundFloor(long j2) {
        return this.iField.roundFloor(j2);
    }

    public long set(long j2, int i2) {
        return this.iField.set(j2, i2);
    }
}
