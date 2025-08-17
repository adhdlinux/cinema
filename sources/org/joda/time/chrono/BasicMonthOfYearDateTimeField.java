package org.joda.time.chrono;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.ImpreciseDateTimeField;

class BasicMonthOfYearDateTimeField extends ImpreciseDateTimeField {
    private static final int MIN = 1;
    private static final long serialVersionUID = -8258715387168736L;
    private final BasicChronology iChronology;
    private final int iLeapMonth;
    private final int iMax;

    BasicMonthOfYearDateTimeField(BasicChronology basicChronology, int i2) {
        super(DateTimeFieldType.monthOfYear(), basicChronology.getAverageMillisPerMonth());
        this.iChronology = basicChronology;
        this.iMax = basicChronology.getMaxMonth();
        this.iLeapMonth = i2;
    }

    private Object readResolve() {
        return this.iChronology.monthOfYear();
    }

    public long add(long j2, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (i2 == 0) {
            return j2;
        }
        long millisOfDay = (long) this.iChronology.getMillisOfDay(j2);
        int year = this.iChronology.getYear(j2);
        int monthOfYear = this.iChronology.getMonthOfYear(j2, year);
        int i8 = monthOfYear - 1;
        int i9 = i8 + i2;
        if (monthOfYear <= 0 || i9 >= 0) {
            i3 = year;
        } else {
            if (Math.signum((float) (this.iMax + i2)) == Math.signum((float) i2)) {
                i7 = year - 1;
                i6 = i2 + this.iMax;
            } else {
                i7 = year + 1;
                i6 = i2 - this.iMax;
            }
            int i10 = i7;
            i9 = i6 + i8;
            i3 = i10;
        }
        if (i9 >= 0) {
            int i11 = this.iMax;
            i4 = i3 + (i9 / i11);
            i5 = (i9 % i11) + 1;
        } else {
            i4 = (i3 + (i9 / this.iMax)) - 1;
            int abs = Math.abs(i9);
            int i12 = this.iMax;
            int i13 = abs % i12;
            if (i13 == 0) {
                i13 = i12;
            }
            i5 = (i12 - i13) + 1;
            if (i5 == 1) {
                i4++;
            }
        }
        int dayOfMonth = this.iChronology.getDayOfMonth(j2, year, monthOfYear);
        int daysInYearMonth = this.iChronology.getDaysInYearMonth(i4, i5);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.iChronology.getYearMonthDayMillis(i4, i5, dayOfMonth) + millisOfDay;
    }

    public long addWrapField(long j2, int i2) {
        return set(j2, FieldUtils.getWrappedValue(get(j2), i2, 1, this.iMax));
    }

    public int get(long j2) {
        return this.iChronology.getMonthOfYear(j2);
    }

    public long getDifferenceAsLong(long j2, long j3) {
        if (j2 < j3) {
            return (long) (-getDifference(j3, j2));
        }
        int year = this.iChronology.getYear(j2);
        int monthOfYear = this.iChronology.getMonthOfYear(j2, year);
        int year2 = this.iChronology.getYear(j3);
        int monthOfYear2 = this.iChronology.getMonthOfYear(j3, year2);
        long j4 = ((((long) (year - year2)) * ((long) this.iMax)) + ((long) monthOfYear)) - ((long) monthOfYear2);
        int dayOfMonth = this.iChronology.getDayOfMonth(j2, year, monthOfYear);
        if (dayOfMonth == this.iChronology.getDaysInYearMonth(year, monthOfYear) && this.iChronology.getDayOfMonth(j3, year2, monthOfYear2) > dayOfMonth) {
            j3 = this.iChronology.dayOfMonth().set(j3, dayOfMonth);
        }
        if (j2 - this.iChronology.getYearMonthMillis(year, monthOfYear) < j3 - this.iChronology.getYearMonthMillis(year2, monthOfYear2)) {
            return j4 - 1;
        }
        return j4;
    }

    public int getLeapAmount(long j2) {
        return isLeap(j2) ? 1 : 0;
    }

    public DurationField getLeapDurationField() {
        return this.iChronology.days();
    }

    public int getMaximumValue() {
        return this.iMax;
    }

    public int getMinimumValue() {
        return 1;
    }

    public DurationField getRangeDurationField() {
        return this.iChronology.years();
    }

    public boolean isLeap(long j2) {
        int year = this.iChronology.getYear(j2);
        if (!this.iChronology.isLeapYear(year) || this.iChronology.getMonthOfYear(j2, year) != this.iLeapMonth) {
            return false;
        }
        return true;
    }

    public boolean isLenient() {
        return false;
    }

    public long remainder(long j2) {
        return j2 - roundFloor(j2);
    }

    public long roundFloor(long j2) {
        int year = this.iChronology.getYear(j2);
        return this.iChronology.getYearMonthMillis(year, this.iChronology.getMonthOfYear(j2, year));
    }

    public long set(long j2, int i2) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i2, 1, this.iMax);
        int year = this.iChronology.getYear(j2);
        int dayOfMonth = this.iChronology.getDayOfMonth(j2, year);
        int daysInYearMonth = this.iChronology.getDaysInYearMonth(year, i2);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.iChronology.getYearMonthDayMillis(year, i2, dayOfMonth) + ((long) this.iChronology.getMillisOfDay(j2));
    }

    public long add(long j2, long j3) {
        long j4;
        long j5;
        long j6 = j2;
        long j7 = j3;
        int i2 = (int) j7;
        if (((long) i2) == j7) {
            return add(j6, i2);
        }
        long millisOfDay = (long) this.iChronology.getMillisOfDay(j6);
        int year = this.iChronology.getYear(j6);
        int monthOfYear = this.iChronology.getMonthOfYear(j6, year);
        long j8 = ((long) (monthOfYear - 1)) + j7;
        if (j8 >= 0) {
            int i3 = this.iMax;
            j4 = ((long) year) + (j8 / ((long) i3));
            j5 = (j8 % ((long) i3)) + 1;
        } else {
            j4 = (((long) year) + (j8 / ((long) this.iMax))) - 1;
            long abs = Math.abs(j8);
            int i4 = this.iMax;
            int i5 = (int) (abs % ((long) i4));
            if (i5 == 0) {
                i5 = i4;
            }
            j5 = (long) ((i4 - i5) + 1);
            if (j5 == 1) {
                j4++;
            }
        }
        if (j4 < ((long) this.iChronology.getMinYear()) || j4 > ((long) this.iChronology.getMaxYear())) {
            throw new IllegalArgumentException("Magnitude of add amount is too large: " + j7);
        }
        int i6 = (int) j4;
        int i7 = (int) j5;
        int dayOfMonth = this.iChronology.getDayOfMonth(j6, year, monthOfYear);
        int daysInYearMonth = this.iChronology.getDaysInYearMonth(i6, i7);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.iChronology.getYearMonthDayMillis(i6, i7, dayOfMonth) + millisOfDay;
    }

    public int[] add(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            return iArr;
        }
        if (readablePartial.size() > 0 && readablePartial.getFieldType(0).equals(DateTimeFieldType.monthOfYear()) && i2 == 0) {
            return set(readablePartial, 0, iArr, ((((iArr[0] - 1) + (i3 % 12)) + 12) % 12) + 1);
        }
        if (!DateTimeUtils.isContiguous(readablePartial)) {
            return super.add(readablePartial, i2, iArr, i3);
        }
        int size = readablePartial.size();
        long j2 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            j2 = readablePartial.getFieldType(i4).getField(this.iChronology).set(j2, iArr[i4]);
        }
        return this.iChronology.get(readablePartial, add(j2, i3));
    }
}
