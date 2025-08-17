package org.joda.time.chrono;

import java.io.Serializable;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.UnsupportedDateTimeField;
import org.joda.time.field.UnsupportedDurationField;

public abstract class BaseChronology extends Chronology implements Serializable {
    private static final long serialVersionUID = -7310865996721419676L;

    protected BaseChronology() {
    }

    public long add(ReadablePeriod readablePeriod, long j2, int i2) {
        if (!(i2 == 0 || readablePeriod == null)) {
            int size = readablePeriod.size();
            for (int i3 = 0; i3 < size; i3++) {
                long value = (long) readablePeriod.getValue(i3);
                if (value != 0) {
                    j2 = readablePeriod.getFieldType(i3).getField(this).add(j2, value * ((long) i2));
                }
            }
        }
        return j2;
    }

    public DurationField centuries() {
        return UnsupportedDurationField.getInstance(DurationFieldType.centuries());
    }

    public DateTimeField centuryOfEra() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.centuryOfEra(), centuries());
    }

    public DateTimeField clockhourOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.clockhourOfDay(), hours());
    }

    public DateTimeField clockhourOfHalfday() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.clockhourOfHalfday(), hours());
    }

    public DateTimeField dayOfMonth() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfMonth(), days());
    }

    public DateTimeField dayOfWeek() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfWeek(), days());
    }

    public DateTimeField dayOfYear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfYear(), days());
    }

    public DurationField days() {
        return UnsupportedDurationField.getInstance(DurationFieldType.days());
    }

    public DateTimeField era() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.era(), eras());
    }

    public DurationField eras() {
        return UnsupportedDurationField.getInstance(DurationFieldType.eras());
    }

    public int[] get(ReadablePartial readablePartial, long j2) {
        int size = readablePartial.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = readablePartial.getFieldType(i2).getField(this).get(j2);
        }
        return iArr;
    }

    public long getDateTimeMillis(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        return millisOfDay().set(dayOfMonth().set(monthOfYear().set(year().set(0, i2), i3), i4), i5);
    }

    public abstract DateTimeZone getZone();

    public DateTimeField halfdayOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.halfdayOfDay(), halfdays());
    }

    public DurationField halfdays() {
        return UnsupportedDurationField.getInstance(DurationFieldType.halfdays());
    }

    public DateTimeField hourOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.hourOfDay(), hours());
    }

    public DateTimeField hourOfHalfday() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.hourOfHalfday(), hours());
    }

    public DurationField hours() {
        return UnsupportedDurationField.getInstance(DurationFieldType.hours());
    }

    public DurationField millis() {
        return UnsupportedDurationField.getInstance(DurationFieldType.millis());
    }

    public DateTimeField millisOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.millisOfDay(), millis());
    }

    public DateTimeField millisOfSecond() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.millisOfSecond(), millis());
    }

    public DateTimeField minuteOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.minuteOfDay(), minutes());
    }

    public DateTimeField minuteOfHour() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.minuteOfHour(), minutes());
    }

    public DurationField minutes() {
        return UnsupportedDurationField.getInstance(DurationFieldType.minutes());
    }

    public DateTimeField monthOfYear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.monthOfYear(), months());
    }

    public DurationField months() {
        return UnsupportedDurationField.getInstance(DurationFieldType.months());
    }

    public DateTimeField secondOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.secondOfDay(), seconds());
    }

    public DateTimeField secondOfMinute() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.secondOfMinute(), seconds());
    }

    public DurationField seconds() {
        return UnsupportedDurationField.getInstance(DurationFieldType.seconds());
    }

    public long set(ReadablePartial readablePartial, long j2) {
        int size = readablePartial.size();
        for (int i2 = 0; i2 < size; i2++) {
            j2 = readablePartial.getFieldType(i2).getField(this).set(j2, readablePartial.getValue(i2));
        }
        return j2;
    }

    public abstract String toString();

    public void validate(ReadablePartial readablePartial, int[] iArr) {
        int size = readablePartial.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            int i4 = iArr[i3];
            DateTimeField field = readablePartial.getField(i3);
            if (i4 < field.getMinimumValue()) {
                throw new IllegalFieldValueException(field.getType(), (Number) Integer.valueOf(i4), (Number) Integer.valueOf(field.getMinimumValue()), (Number) null);
            } else if (i4 <= field.getMaximumValue()) {
                i3++;
            } else {
                throw new IllegalFieldValueException(field.getType(), (Number) Integer.valueOf(i4), (Number) null, (Number) Integer.valueOf(field.getMaximumValue()));
            }
        }
        while (i2 < size) {
            int i5 = iArr[i2];
            DateTimeField field2 = readablePartial.getField(i2);
            if (i5 < field2.getMinimumValue(readablePartial, iArr)) {
                throw new IllegalFieldValueException(field2.getType(), (Number) Integer.valueOf(i5), (Number) Integer.valueOf(field2.getMinimumValue(readablePartial, iArr)), (Number) null);
            } else if (i5 <= field2.getMaximumValue(readablePartial, iArr)) {
                i2++;
            } else {
                throw new IllegalFieldValueException(field2.getType(), (Number) Integer.valueOf(i5), (Number) null, (Number) Integer.valueOf(field2.getMaximumValue(readablePartial, iArr)));
            }
        }
    }

    public DateTimeField weekOfWeekyear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekOfWeekyear(), weeks());
    }

    public DurationField weeks() {
        return UnsupportedDurationField.getInstance(DurationFieldType.weeks());
    }

    public DateTimeField weekyear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekyear(), weekyears());
    }

    public DateTimeField weekyearOfCentury() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekyearOfCentury(), weekyears());
    }

    public DurationField weekyears() {
        return UnsupportedDurationField.getInstance(DurationFieldType.weekyears());
    }

    public abstract Chronology withUTC();

    public abstract Chronology withZone(DateTimeZone dateTimeZone);

    public DateTimeField year() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.year(), years());
    }

    public DateTimeField yearOfCentury() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.yearOfCentury(), years());
    }

    public DateTimeField yearOfEra() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.yearOfEra(), years());
    }

    public DurationField years() {
        return UnsupportedDurationField.getInstance(DurationFieldType.years());
    }

    public long add(long j2, long j3, int i2) {
        return (j3 == 0 || i2 == 0) ? j2 : FieldUtils.safeAdd(j2, FieldUtils.safeMultiply(j3, i2));
    }

    public int[] get(ReadablePeriod readablePeriod, long j2, long j3) {
        int size = readablePeriod.size();
        int[] iArr = new int[size];
        if (j2 != j3) {
            for (int i2 = 0; i2 < size; i2++) {
                DurationField field = readablePeriod.getFieldType(i2).getField(this);
                int difference = field.getDifference(j3, j2);
                if (difference != 0) {
                    j2 = field.add(j2, difference);
                }
                iArr[i2] = difference;
            }
        }
        return iArr;
    }

    public long getDateTimeMillis(int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        return millisOfSecond().set(secondOfMinute().set(minuteOfHour().set(hourOfDay().set(dayOfMonth().set(monthOfYear().set(year().set(0, i2), i3), i4), i5), i6), i7), i8);
    }

    public int[] get(ReadablePeriod readablePeriod, long j2) {
        int size = readablePeriod.size();
        int[] iArr = new int[size];
        long j3 = 0;
        if (j2 != 0) {
            for (int i2 = 0; i2 < size; i2++) {
                DurationField field = readablePeriod.getFieldType(i2).getField(this);
                if (field.isPrecise()) {
                    int difference = field.getDifference(j2, j3);
                    j3 = field.add(j3, difference);
                    iArr[i2] = difference;
                }
            }
        }
        return iArr;
    }

    public long getDateTimeMillis(long j2, int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        return millisOfSecond().set(secondOfMinute().set(minuteOfHour().set(hourOfDay().set(j2, i2), i3), i4), i5);
    }
}
