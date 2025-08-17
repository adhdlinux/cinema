package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public abstract class ImpreciseDateTimeField extends BaseDateTimeField {
    private static final long serialVersionUID = 7190739608550251860L;
    private final DurationField iDurationField;
    final long iUnitMillis;

    private final class LinkedDurationField extends BaseDurationField {
        private static final long serialVersionUID = -203813474600094134L;

        LinkedDurationField(DurationFieldType durationFieldType) {
            super(durationFieldType);
        }

        public long add(long j2, int i2) {
            return ImpreciseDateTimeField.this.add(j2, i2);
        }

        public int getDifference(long j2, long j3) {
            return ImpreciseDateTimeField.this.getDifference(j2, j3);
        }

        public long getDifferenceAsLong(long j2, long j3) {
            return ImpreciseDateTimeField.this.getDifferenceAsLong(j2, j3);
        }

        public long getMillis(int i2, long j2) {
            return ImpreciseDateTimeField.this.add(j2, i2) - j2;
        }

        public long getUnitMillis() {
            return ImpreciseDateTimeField.this.iUnitMillis;
        }

        public int getValue(long j2, long j3) {
            return ImpreciseDateTimeField.this.getDifference(j2 + j3, j3);
        }

        public long getValueAsLong(long j2, long j3) {
            return ImpreciseDateTimeField.this.getDifferenceAsLong(j2 + j3, j3);
        }

        public boolean isPrecise() {
            return false;
        }

        public long add(long j2, long j3) {
            return ImpreciseDateTimeField.this.add(j2, j3);
        }

        public long getMillis(long j2, long j3) {
            return ImpreciseDateTimeField.this.add(j3, j2) - j3;
        }
    }

    public ImpreciseDateTimeField(DateTimeFieldType dateTimeFieldType, long j2) {
        super(dateTimeFieldType);
        this.iUnitMillis = j2;
        this.iDurationField = new LinkedDurationField(dateTimeFieldType.getDurationType());
    }

    public abstract long add(long j2, int i2);

    public abstract long add(long j2, long j3);

    public abstract int get(long j2);

    public int getDifference(long j2, long j3) {
        return FieldUtils.safeToInt(getDifferenceAsLong(j2, j3));
    }

    public long getDifferenceAsLong(long j2, long j3) {
        if (j2 < j3) {
            return -getDifferenceAsLong(j3, j2);
        }
        long j4 = (j2 - j3) / this.iUnitMillis;
        if (add(j3, j4) < j2) {
            do {
                j4++;
            } while (add(j3, j4) <= j2);
            return j4 - 1;
        } else if (add(j3, j4) <= j2) {
            return j4;
        } else {
            do {
                j4--;
            } while (add(j3, j4) > j2);
            return j4;
        }
    }

    public final DurationField getDurationField() {
        return this.iDurationField;
    }

    /* access modifiers changed from: protected */
    public final long getDurationUnitMillis() {
        return this.iUnitMillis;
    }

    public abstract DurationField getRangeDurationField();

    public abstract long roundFloor(long j2);

    public abstract long set(long j2, int i2);
}
