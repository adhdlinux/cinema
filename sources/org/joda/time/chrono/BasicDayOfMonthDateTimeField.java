package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;
import org.joda.time.field.PreciseDurationDateTimeField;

final class BasicDayOfMonthDateTimeField extends PreciseDurationDateTimeField {
    private static final long serialVersionUID = -4677223814028011723L;
    private final BasicChronology iChronology;

    BasicDayOfMonthDateTimeField(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.dayOfMonth(), durationField);
        this.iChronology = basicChronology;
    }

    private Object readResolve() {
        return this.iChronology.dayOfMonth();
    }

    public int get(long j2) {
        return this.iChronology.getDayOfMonth(j2);
    }

    public int getMaximumValue() {
        return this.iChronology.getDaysInMonthMax();
    }

    /* access modifiers changed from: protected */
    public int getMaximumValueForSet(long j2, int i2) {
        return this.iChronology.getDaysInMonthMaxForSet(j2, i2);
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.iChronology.months();
    }

    public boolean isLeap(long j2) {
        return this.iChronology.isLeapDay(j2);
    }

    public int getMaximumValue(long j2) {
        return this.iChronology.getDaysInMonthMax(j2);
    }

    public int getMaximumValue(ReadablePartial readablePartial) {
        if (!readablePartial.isSupported(DateTimeFieldType.monthOfYear())) {
            return getMaximumValue();
        }
        int i2 = readablePartial.get(DateTimeFieldType.monthOfYear());
        if (!readablePartial.isSupported(DateTimeFieldType.year())) {
            return this.iChronology.getDaysInMonthMax(i2);
        }
        return this.iChronology.getDaysInYearMonth(readablePartial.get(DateTimeFieldType.year()), i2);
    }

    public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
        int size = readablePartial.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (readablePartial.getFieldType(i2) == DateTimeFieldType.monthOfYear()) {
                int i3 = iArr[i2];
                for (int i4 = 0; i4 < size; i4++) {
                    if (readablePartial.getFieldType(i4) == DateTimeFieldType.year()) {
                        return this.iChronology.getDaysInYearMonth(iArr[i4], i3);
                    }
                }
                return this.iChronology.getDaysInMonthMax(i3);
            }
        }
        return getMaximumValue();
    }
}
