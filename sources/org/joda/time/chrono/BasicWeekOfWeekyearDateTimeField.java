package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;
import org.joda.time.field.PreciseDurationDateTimeField;

final class BasicWeekOfWeekyearDateTimeField extends PreciseDurationDateTimeField {
    private static final long serialVersionUID = -1587436826395135328L;
    private final BasicChronology iChronology;

    BasicWeekOfWeekyearDateTimeField(BasicChronology basicChronology, DurationField durationField) {
        super(DateTimeFieldType.weekOfWeekyear(), durationField);
        this.iChronology = basicChronology;
    }

    private Object readResolve() {
        return this.iChronology.weekOfWeekyear();
    }

    public int get(long j2) {
        return this.iChronology.getWeekOfWeekyear(j2);
    }

    public int getMaximumValue() {
        return 53;
    }

    public int getMaximumValue(long j2) {
        return this.iChronology.getWeeksInYear(this.iChronology.getWeekyear(j2));
    }

    /* access modifiers changed from: protected */
    public int getMaximumValueForSet(long j2, int i2) {
        if (i2 > 52) {
            return getMaximumValue(j2);
        }
        return 52;
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.iChronology.weekyears();
    }

    public long remainder(long j2) {
        return super.remainder(j2 + 259200000);
    }

    public long roundCeiling(long j2) {
        return super.roundCeiling(j2 + 259200000) - 259200000;
    }

    public long roundFloor(long j2) {
        return super.roundFloor(j2 + 259200000) - 259200000;
    }

    public int getMaximumValue(ReadablePartial readablePartial) {
        if (!readablePartial.isSupported(DateTimeFieldType.weekyear())) {
            return 53;
        }
        return this.iChronology.getWeeksInYear(readablePartial.get(DateTimeFieldType.weekyear()));
    }

    public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
        int size = readablePartial.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (readablePartial.getFieldType(i2) == DateTimeFieldType.weekyear()) {
                return this.iChronology.getWeeksInYear(iArr[i2]);
            }
        }
        return 53;
    }
}
