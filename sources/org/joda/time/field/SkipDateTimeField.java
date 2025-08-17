package org.joda.time.field;

import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

public final class SkipDateTimeField extends DelegatedDateTimeField {
    private static final long serialVersionUID = -8869148464118507846L;
    private final Chronology iChronology;
    private transient int iMinValue;
    private final int iSkip;

    public SkipDateTimeField(Chronology chronology, DateTimeField dateTimeField) {
        this(chronology, dateTimeField, 0);
    }

    private Object readResolve() {
        return getType().getField(this.iChronology);
    }

    public int get(long j2) {
        int i2 = super.get(j2);
        if (i2 <= this.iSkip) {
            return i2 - 1;
        }
        return i2;
    }

    public int getMinimumValue() {
        return this.iMinValue;
    }

    public long set(long j2, int i2) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, this.iMinValue, getMaximumValue());
        int i3 = this.iSkip;
        if (i2 <= i3) {
            if (i2 != i3) {
                i2++;
            } else {
                throw new IllegalFieldValueException(DateTimeFieldType.year(), (Number) Integer.valueOf(i2), (Number) null, (Number) null);
            }
        }
        return super.set(j2, i2);
    }

    public SkipDateTimeField(Chronology chronology, DateTimeField dateTimeField, int i2) {
        super(dateTimeField);
        this.iChronology = chronology;
        int minimumValue = super.getMinimumValue();
        if (minimumValue < i2) {
            this.iMinValue = minimumValue - 1;
        } else if (minimumValue == i2) {
            this.iMinValue = i2 + 1;
        } else {
            this.iMinValue = minimumValue;
        }
        this.iSkip = i2;
    }
}
