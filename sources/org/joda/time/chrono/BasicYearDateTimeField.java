package org.joda.time.chrono;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

class BasicYearDateTimeField extends ImpreciseDateTimeField {
    private static final long serialVersionUID = -98628754872287L;
    protected final BasicChronology iChronology;

    BasicYearDateTimeField(BasicChronology basicChronology) {
        super(DateTimeFieldType.year(), basicChronology.getAverageMillisPerYear());
        this.iChronology = basicChronology;
    }

    private Object readResolve() {
        return this.iChronology.year();
    }

    public long add(long j2, int i2) {
        if (i2 == 0) {
            return j2;
        }
        return set(j2, FieldUtils.safeAdd(get(j2), i2));
    }

    public long addWrapField(long j2, int i2) {
        if (i2 == 0) {
            return j2;
        }
        return set(j2, FieldUtils.getWrappedValue(this.iChronology.getYear(j2), i2, this.iChronology.getMinYear(), this.iChronology.getMaxYear()));
    }

    public int get(long j2) {
        return this.iChronology.getYear(j2);
    }

    public long getDifferenceAsLong(long j2, long j3) {
        if (j2 < j3) {
            return -this.iChronology.getYearDifference(j3, j2);
        }
        return this.iChronology.getYearDifference(j2, j3);
    }

    public int getLeapAmount(long j2) {
        return this.iChronology.isLeapYear(get(j2)) ? 1 : 0;
    }

    public DurationField getLeapDurationField() {
        return this.iChronology.days();
    }

    public int getMaximumValue() {
        return this.iChronology.getMaxYear();
    }

    public int getMinimumValue() {
        return this.iChronology.getMinYear();
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public boolean isLeap(long j2) {
        return this.iChronology.isLeapYear(get(j2));
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j2) {
        return j2 - roundFloor(j2);
    }

    public long roundCeiling(long j2) {
        int i2 = get(j2);
        if (j2 != this.iChronology.getYearMillis(i2)) {
            return this.iChronology.getYearMillis(i2 + 1);
        }
        return j2;
    }

    public long roundFloor(long j2) {
        return this.iChronology.getYearMillis(get(j2));
    }

    public long set(long j2, int i2) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, this.iChronology.getMinYear(), this.iChronology.getMaxYear());
        return this.iChronology.setYear(j2, i2);
    }

    public long setExtended(long j2, int i2) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, this.iChronology.getMinYear() - 1, this.iChronology.getMaxYear() + 1);
        return this.iChronology.setYear(j2, i2);
    }

    public long add(long j2, long j3) {
        return add(j2, FieldUtils.safeToInt(j3));
    }
}
