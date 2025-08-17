package org.joda.time.field;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;

public final class UnsupportedDateTimeField extends DateTimeField implements Serializable {
    private static HashMap<DateTimeFieldType, UnsupportedDateTimeField> cCache = null;
    private static final long serialVersionUID = -1934618396111902255L;
    private final DurationField iDurationField;
    private final DateTimeFieldType iType;

    private UnsupportedDateTimeField(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        if (dateTimeFieldType == null || durationField == null) {
            throw new IllegalArgumentException();
        }
        this.iType = dateTimeFieldType;
        this.iDurationField = durationField;
    }

    public static synchronized UnsupportedDateTimeField getInstance(DateTimeFieldType dateTimeFieldType, DurationField durationField) {
        UnsupportedDateTimeField unsupportedDateTimeField;
        synchronized (UnsupportedDateTimeField.class) {
            HashMap<DateTimeFieldType, UnsupportedDateTimeField> hashMap = cCache;
            unsupportedDateTimeField = null;
            if (hashMap == null) {
                cCache = new HashMap<>(7);
            } else {
                UnsupportedDateTimeField unsupportedDateTimeField2 = hashMap.get(dateTimeFieldType);
                if (unsupportedDateTimeField2 == null || unsupportedDateTimeField2.getDurationField() == durationField) {
                    unsupportedDateTimeField = unsupportedDateTimeField2;
                }
            }
            if (unsupportedDateTimeField == null) {
                unsupportedDateTimeField = new UnsupportedDateTimeField(dateTimeFieldType, durationField);
                cCache.put(dateTimeFieldType, unsupportedDateTimeField);
            }
        }
        return unsupportedDateTimeField;
    }

    private Object readResolve() {
        return getInstance(this.iType, this.iDurationField);
    }

    private UnsupportedOperationException unsupported() {
        return new UnsupportedOperationException(this.iType + " field is unsupported");
    }

    public long add(long j2, int i2) {
        return getDurationField().add(j2, i2);
    }

    public long addWrapField(long j2, int i2) {
        throw unsupported();
    }

    public int[] addWrapPartial(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        throw unsupported();
    }

    public int get(long j2) {
        throw unsupported();
    }

    public String getAsShortText(long j2, Locale locale) {
        throw unsupported();
    }

    public String getAsText(long j2, Locale locale) {
        throw unsupported();
    }

    public int getDifference(long j2, long j3) {
        return getDurationField().getDifference(j2, j3);
    }

    public long getDifferenceAsLong(long j2, long j3) {
        return getDurationField().getDifferenceAsLong(j2, j3);
    }

    public DurationField getDurationField() {
        return this.iDurationField;
    }

    public int getLeapAmount(long j2) {
        throw unsupported();
    }

    public DurationField getLeapDurationField() {
        return null;
    }

    public int getMaximumShortTextLength(Locale locale) {
        throw unsupported();
    }

    public int getMaximumTextLength(Locale locale) {
        throw unsupported();
    }

    public int getMaximumValue() {
        throw unsupported();
    }

    public int getMinimumValue() {
        throw unsupported();
    }

    public String getName() {
        return this.iType.getName();
    }

    public DurationField getRangeDurationField() {
        return null;
    }

    public DateTimeFieldType getType() {
        return this.iType;
    }

    public boolean isLeap(long j2) {
        throw unsupported();
    }

    public boolean isLenient() {
        return false;
    }

    public boolean isSupported() {
        return false;
    }

    public long remainder(long j2) {
        throw unsupported();
    }

    public long roundCeiling(long j2) {
        throw unsupported();
    }

    public long roundFloor(long j2) {
        throw unsupported();
    }

    public long roundHalfCeiling(long j2) {
        throw unsupported();
    }

    public long roundHalfEven(long j2) {
        throw unsupported();
    }

    public long roundHalfFloor(long j2) {
        throw unsupported();
    }

    public long set(long j2, int i2) {
        throw unsupported();
    }

    public String toString() {
        return "UnsupportedDateTimeField";
    }

    public long add(long j2, long j3) {
        return getDurationField().add(j2, j3);
    }

    public int[] addWrapField(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        throw unsupported();
    }

    public String getAsShortText(long j2) {
        throw unsupported();
    }

    public String getAsText(long j2) {
        throw unsupported();
    }

    public int getMaximumValue(long j2) {
        throw unsupported();
    }

    public int getMinimumValue(long j2) {
        throw unsupported();
    }

    public int[] set(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        throw unsupported();
    }

    public int[] add(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        throw unsupported();
    }

    public String getAsShortText(ReadablePartial readablePartial, int i2, Locale locale) {
        throw unsupported();
    }

    public String getAsText(ReadablePartial readablePartial, int i2, Locale locale) {
        throw unsupported();
    }

    public int getMaximumValue(ReadablePartial readablePartial) {
        throw unsupported();
    }

    public int getMinimumValue(ReadablePartial readablePartial) {
        throw unsupported();
    }

    public long set(long j2, String str, Locale locale) {
        throw unsupported();
    }

    public String getAsShortText(ReadablePartial readablePartial, Locale locale) {
        throw unsupported();
    }

    public String getAsText(ReadablePartial readablePartial, Locale locale) {
        throw unsupported();
    }

    public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
        throw unsupported();
    }

    public int getMinimumValue(ReadablePartial readablePartial, int[] iArr) {
        throw unsupported();
    }

    public long set(long j2, String str) {
        throw unsupported();
    }

    public String getAsShortText(int i2, Locale locale) {
        throw unsupported();
    }

    public String getAsText(int i2, Locale locale) {
        throw unsupported();
    }

    public int[] set(ReadablePartial readablePartial, int i2, int[] iArr, String str, Locale locale) {
        throw unsupported();
    }
}
