package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;
import org.joda.time.field.PreciseDurationDateTimeField;

final class BasicDayOfYearDateTimeField extends PreciseDurationDateTimeField {
    private static final long serialVersionUID = -6821236822336841037L;
    private final BasicChronology iChronology;

    BasicDayOfYearDateTimeField(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.dayOfYear(), durationField);
        this.iChronology = basicChronology;
    }

    private Object readResolve() {
        return this.iChronology.dayOfYear();
    }

    public int get(long j2) {
        return this.iChronology.getDayOfYear(j2);
    }

    public int getMaximumValue() {
        return this.iChronology.getDaysInYearMax();
    }

    /* access modifiers changed from: protected */
    public int getMaximumValueForSet(long j2, int i2) {
        int daysInYearMax = this.iChronology.getDaysInYearMax() - 1;
        if (i2 > daysInYearMax || i2 < 1) {
            return getMaximumValue(j2);
        }
        return daysInYearMax;
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.iChronology.years();
    }

    public boolean isLeap(long j2) {
        return this.iChronology.isLeapDay(j2);
    }

    public int getMaximumValue(long j2) {
        return this.iChronology.getDaysInYear(this.iChronology.getYear(j2));
    }

    public int getMaximumValue(ReadablePartial readablePartial) {
        if (!readablePartial.isSupported(DateTimeFieldType.year())) {
            return this.iChronology.getDaysInYearMax();
        }
        return this.iChronology.getDaysInYear(readablePartial.get(DateTimeFieldType.year()));
    }

    public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
        int size = readablePartial.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (readablePartial.getFieldType(i2) == DateTimeFieldType.year()) {
                return this.iChronology.getDaysInYear(iArr[i2]);
            }
        }
        return this.iChronology.getDaysInYearMax();
    }
}
