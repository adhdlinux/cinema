package org.joda.time.chrono;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

final class BasicWeekyearDateTimeField extends ImpreciseDateTimeField {
    private static final long WEEK_53 = 31449600000L;
    private static final long serialVersionUID = 6215066916806820644L;
    private final BasicChronology iChronology;

    BasicWeekyearDateTimeField(BasicChronology basicChronology) {
        super(DateTimeFieldType.weekyear(), basicChronology.getAverageMillisPerYear());
        this.iChronology = basicChronology;
    }

    private Object readResolve() {
        return this.iChronology.weekyear();
    }

    public long add(long j2, int i2) {
        return i2 == 0 ? j2 : set(j2, get(j2) + i2);
    }

    public long addWrapField(long j2, int i2) {
        return add(j2, i2);
    }

    public int get(long j2) {
        return this.iChronology.getWeekyear(j2);
    }

    public long getDifferenceAsLong(long j2, long j3) {
        if (j2 < j3) {
            return (long) (-getDifference(j3, j2));
        }
        int i2 = get(j2);
        int i3 = get(j3);
        long remainder = remainder(j2);
        long remainder2 = remainder(j3);
        if (remainder2 >= WEEK_53 && this.iChronology.getWeeksInYear(i2) <= 52) {
            remainder2 -= 604800000;
        }
        int i4 = i2 - i3;
        if (remainder < remainder2) {
            i4--;
        }
        return (long) i4;
    }

    public int getLeapAmount(long j2) {
        BasicChronology basicChronology = this.iChronology;
        return basicChronology.getWeeksInYear(basicChronology.getWeekyear(j2)) - 52;
    }

    public DurationField getLeapDurationField() {
        return this.iChronology.weeks();
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
        BasicChronology basicChronology = this.iChronology;
        return basicChronology.getWeeksInYear(basicChronology.getWeekyear(j2)) > 52;
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j2) {
        return j2 - roundFloor(j2);
    }

    public long roundFloor(long j2) {
        long roundFloor = this.iChronology.weekOfWeekyear().roundFloor(j2);
        int weekOfWeekyear = this.iChronology.getWeekOfWeekyear(roundFloor);
        if (weekOfWeekyear > 1) {
            return roundFloor - (((long) (weekOfWeekyear - 1)) * 604800000);
        }
        return roundFloor;
    }

    public long set(long j2, int i2) {
        FieldUtils.verifyValueBounds((DateTimeField) this, Math.abs(i2), this.iChronology.getMinYear(), this.iChronology.getMaxYear());
        int i3 = get(j2);
        if (i3 == i2) {
            return j2;
        }
        int dayOfWeek = this.iChronology.getDayOfWeek(j2);
        int weeksInYear = this.iChronology.getWeeksInYear(i3);
        int weeksInYear2 = this.iChronology.getWeeksInYear(i2);
        if (weeksInYear2 < weeksInYear) {
            weeksInYear = weeksInYear2;
        }
        int weekOfWeekyear = this.iChronology.getWeekOfWeekyear(j2);
        if (weekOfWeekyear <= weeksInYear) {
            weeksInYear = weekOfWeekyear;
        }
        long year = this.iChronology.setYear(j2, i2);
        int i4 = get(year);
        if (i4 < i2) {
            year += 604800000;
        } else if (i4 > i2) {
            year -= 604800000;
        }
        return this.iChronology.dayOfWeek().set(year + (((long) (weeksInYear - this.iChronology.getWeekOfWeekyear(year))) * 604800000), dayOfWeek);
    }

    public long add(long j2, long j3) {
        return add(j2, FieldUtils.safeToInt(j3));
    }
}
