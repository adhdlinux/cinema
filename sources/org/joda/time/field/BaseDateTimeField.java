package org.joda.time.field;

import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.ReadablePartial;

public abstract class BaseDateTimeField extends DateTimeField {
    private final DateTimeFieldType iType;

    protected BaseDateTimeField(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            this.iType = dateTimeFieldType;
            return;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    public long add(long j2, int i2) {
        return getDurationField().add(j2, i2);
    }

    public long addWrapField(long j2, int i2) {
        return set(j2, FieldUtils.getWrappedValue(get(j2), i2, getMinimumValue(j2), getMaximumValue(j2)));
    }

    public int[] addWrapPartial(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            return iArr;
        }
        DateTimeField dateTimeField = null;
        while (true) {
            if (i3 <= 0) {
                break;
            }
            int maximumValue = getMaximumValue(readablePartial, iArr);
            int i4 = iArr[i2];
            long j2 = (long) (i4 + i3);
            if (j2 <= ((long) maximumValue)) {
                iArr[i2] = (int) j2;
                break;
            }
            if (dateTimeField == null) {
                if (i2 == 0) {
                    i3 -= (maximumValue + 1) - i4;
                    iArr[i2] = getMinimumValue(readablePartial, iArr);
                } else {
                    dateTimeField = readablePartial.getField(i2 - 1);
                    if (getRangeDurationField().getType() != dateTimeField.getDurationField().getType()) {
                        throw new IllegalArgumentException("Fields invalid for add");
                    }
                }
            }
            i3 -= (maximumValue + 1) - iArr[i2];
            iArr = dateTimeField.addWrapPartial(readablePartial, i2 - 1, iArr, 1);
            iArr[i2] = getMinimumValue(readablePartial, iArr);
        }
        while (true) {
            if (i3 >= 0) {
                break;
            }
            int minimumValue = getMinimumValue(readablePartial, iArr);
            int i5 = iArr[i2];
            long j3 = (long) (i5 + i3);
            if (j3 >= ((long) minimumValue)) {
                iArr[i2] = (int) j3;
                break;
            }
            if (dateTimeField == null) {
                if (i2 == 0) {
                    r13 = i3 - ((minimumValue - 1) - i5);
                    iArr[i2] = getMaximumValue(readablePartial, iArr);
                } else {
                    dateTimeField = readablePartial.getField(i2 - 1);
                    if (getRangeDurationField().getType() != dateTimeField.getDurationField().getType()) {
                        throw new IllegalArgumentException("Fields invalid for add");
                    }
                }
            }
            r13 = i3 - ((minimumValue - 1) - iArr[i2]);
            iArr = dateTimeField.addWrapPartial(readablePartial, i2 - 1, iArr, -1);
            iArr[i2] = getMaximumValue(readablePartial, iArr);
        }
        return set(readablePartial, i2, iArr, iArr[i2]);
    }

    /* access modifiers changed from: protected */
    public int convertText(String str, Locale locale) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new IllegalFieldValueException(getType(), str);
        }
    }

    public abstract int get(long j2);

    public String getAsShortText(long j2, Locale locale) {
        return getAsShortText(get(j2), locale);
    }

    public String getAsText(long j2, Locale locale) {
        return getAsText(get(j2), locale);
    }

    public int getDifference(long j2, long j3) {
        return getDurationField().getDifference(j2, j3);
    }

    public long getDifferenceAsLong(long j2, long j3) {
        return getDurationField().getDifferenceAsLong(j2, j3);
    }

    public abstract DurationField getDurationField();

    public int getLeapAmount(long j2) {
        return 0;
    }

    public DurationField getLeapDurationField() {
        return null;
    }

    public int getMaximumShortTextLength(Locale locale) {
        return getMaximumTextLength(locale);
    }

    public int getMaximumTextLength(Locale locale) {
        int maximumValue = getMaximumValue();
        if (maximumValue >= 0) {
            if (maximumValue < 10) {
                return 1;
            }
            if (maximumValue < 100) {
                return 2;
            }
            if (maximumValue < 1000) {
                return 3;
            }
        }
        return Integer.toString(maximumValue).length();
    }

    public abstract int getMaximumValue();

    public int getMaximumValue(long j2) {
        return getMaximumValue();
    }

    public abstract int getMinimumValue();

    public int getMinimumValue(long j2) {
        return getMinimumValue();
    }

    public final String getName() {
        return this.iType.getName();
    }

    public abstract DurationField getRangeDurationField();

    public final DateTimeFieldType getType() {
        return this.iType;
    }

    public boolean isLeap(long j2) {
        return false;
    }

    public final boolean isSupported() {
        return true;
    }

    public long remainder(long j2) {
        return j2 - roundFloor(j2);
    }

    public long roundCeiling(long j2) {
        long roundFloor = roundFloor(j2);
        if (roundFloor != j2) {
            return add(roundFloor, 1);
        }
        return j2;
    }

    public abstract long roundFloor(long j2);

    public long roundHalfCeiling(long j2) {
        long roundFloor = roundFloor(j2);
        long roundCeiling = roundCeiling(j2);
        if (roundCeiling - j2 <= j2 - roundFloor) {
            return roundCeiling;
        }
        return roundFloor;
    }

    public long roundHalfEven(long j2) {
        long roundFloor = roundFloor(j2);
        long roundCeiling = roundCeiling(j2);
        long j3 = j2 - roundFloor;
        long j4 = roundCeiling - j2;
        if (j3 < j4) {
            return roundFloor;
        }
        if (j4 >= j3 && (get(roundCeiling) & 1) != 0) {
            return roundFloor;
        }
        return roundCeiling;
    }

    public long roundHalfFloor(long j2) {
        long roundFloor = roundFloor(j2);
        long roundCeiling = roundCeiling(j2);
        if (j2 - roundFloor <= roundCeiling - j2) {
            return roundFloor;
        }
        return roundCeiling;
    }

    public abstract long set(long j2, int i2);

    public int[] set(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        FieldUtils.verifyValueBounds((DateTimeField) this, i3, getMinimumValue(readablePartial, iArr), getMaximumValue(readablePartial, iArr));
        iArr[i2] = i3;
        while (true) {
            i2++;
            if (i2 >= readablePartial.size()) {
                return iArr;
            }
            DateTimeField field = readablePartial.getField(i2);
            if (iArr[i2] > field.getMaximumValue(readablePartial, iArr)) {
                iArr[i2] = field.getMaximumValue(readablePartial, iArr);
            }
            if (iArr[i2] < field.getMinimumValue(readablePartial, iArr)) {
                iArr[i2] = field.getMinimumValue(readablePartial, iArr);
            }
        }
    }

    public String toString() {
        return "DateTimeField[" + getName() + ']';
    }

    public long add(long j2, long j3) {
        return getDurationField().add(j2, j3);
    }

    public final String getAsShortText(long j2) {
        return getAsShortText(j2, (Locale) null);
    }

    public final String getAsText(long j2) {
        return getAsText(j2, (Locale) null);
    }

    public int getMaximumValue(ReadablePartial readablePartial) {
        return getMaximumValue();
    }

    public int getMinimumValue(ReadablePartial readablePartial) {
        return getMinimumValue();
    }

    public int[] add(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            return iArr;
        }
        DateTimeField dateTimeField = null;
        while (true) {
            if (i3 <= 0) {
                break;
            }
            int maximumValue = getMaximumValue(readablePartial, iArr);
            long j2 = (long) (iArr[i2] + i3);
            if (j2 <= ((long) maximumValue)) {
                iArr[i2] = (int) j2;
                break;
            }
            if (dateTimeField == null) {
                if (i2 != 0) {
                    dateTimeField = readablePartial.getField(i2 - 1);
                    if (getRangeDurationField().getType() != dateTimeField.getDurationField().getType()) {
                        throw new IllegalArgumentException("Fields invalid for add");
                    }
                } else {
                    throw new IllegalArgumentException("Maximum value exceeded for add");
                }
            }
            i3 -= (maximumValue + 1) - iArr[i2];
            iArr = dateTimeField.add(readablePartial, i2 - 1, iArr, 1);
            iArr[i2] = getMinimumValue(readablePartial, iArr);
        }
        while (true) {
            if (i3 >= 0) {
                break;
            }
            int minimumValue = getMinimumValue(readablePartial, iArr);
            long j3 = (long) (iArr[i2] + i3);
            if (j3 >= ((long) minimumValue)) {
                iArr[i2] = (int) j3;
                break;
            }
            if (dateTimeField == null) {
                if (i2 != 0) {
                    dateTimeField = readablePartial.getField(i2 - 1);
                    if (getRangeDurationField().getType() != dateTimeField.getDurationField().getType()) {
                        throw new IllegalArgumentException("Fields invalid for add");
                    }
                } else {
                    throw new IllegalArgumentException("Maximum value exceeded for add");
                }
            }
            i3 -= (minimumValue - 1) - iArr[i2];
            iArr = dateTimeField.add(readablePartial, i2 - 1, iArr, -1);
            iArr[i2] = getMaximumValue(readablePartial, iArr);
        }
        return set(readablePartial, i2, iArr, iArr[i2]);
    }

    public String getAsShortText(ReadablePartial readablePartial, int i2, Locale locale) {
        return getAsShortText(i2, locale);
    }

    public String getAsText(ReadablePartial readablePartial, int i2, Locale locale) {
        return getAsText(i2, locale);
    }

    public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
        return getMaximumValue(readablePartial);
    }

    public int getMinimumValue(ReadablePartial readablePartial, int[] iArr) {
        return getMinimumValue(readablePartial);
    }

    public int[] addWrapField(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        return set(readablePartial, i2, iArr, FieldUtils.getWrappedValue(iArr[i2], i3, getMinimumValue(readablePartial), getMaximumValue(readablePartial)));
    }

    public final String getAsShortText(ReadablePartial readablePartial, Locale locale) {
        return getAsShortText(readablePartial, readablePartial.get(getType()), locale);
    }

    public final String getAsText(ReadablePartial readablePartial, Locale locale) {
        return getAsText(readablePartial, readablePartial.get(getType()), locale);
    }

    public String getAsShortText(int i2, Locale locale) {
        return getAsText(i2, locale);
    }

    public String getAsText(int i2, Locale locale) {
        return Integer.toString(i2);
    }

    public long set(long j2, String str, Locale locale) {
        return set(j2, convertText(str, locale));
    }

    public final long set(long j2, String str) {
        return set(j2, str, (Locale) null);
    }

    public int[] set(ReadablePartial readablePartial, int i2, int[] iArr, String str, Locale locale) {
        return set(readablePartial, i2, iArr, convertText(str, locale));
    }
}
