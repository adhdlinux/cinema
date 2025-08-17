package org.joda.time.field;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.ReadablePartial;

public class DelegatedDateTimeField extends DateTimeField implements Serializable {
    private static final long serialVersionUID = -4730164440214502503L;
    private final DateTimeField iField;
    private final DurationField iRangeDurationField;
    private final DateTimeFieldType iType;

    public DelegatedDateTimeField(DateTimeField dateTimeField) {
        this(dateTimeField, (DateTimeFieldType) null);
    }

    public long add(long j2, int i2) {
        return this.iField.add(j2, i2);
    }

    public long addWrapField(long j2, int i2) {
        return this.iField.addWrapField(j2, i2);
    }

    public int[] addWrapPartial(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        return this.iField.addWrapPartial(readablePartial, i2, iArr, i3);
    }

    public int get(long j2) {
        return this.iField.get(j2);
    }

    public String getAsShortText(long j2, Locale locale) {
        return this.iField.getAsShortText(j2, locale);
    }

    public String getAsText(long j2, Locale locale) {
        return this.iField.getAsText(j2, locale);
    }

    public int getDifference(long j2, long j3) {
        return this.iField.getDifference(j2, j3);
    }

    public long getDifferenceAsLong(long j2, long j3) {
        return this.iField.getDifferenceAsLong(j2, j3);
    }

    public DurationField getDurationField() {
        return this.iField.getDurationField();
    }

    public int getLeapAmount(long j2) {
        return this.iField.getLeapAmount(j2);
    }

    public DurationField getLeapDurationField() {
        return this.iField.getLeapDurationField();
    }

    public int getMaximumShortTextLength(Locale locale) {
        return this.iField.getMaximumShortTextLength(locale);
    }

    public int getMaximumTextLength(Locale locale) {
        return this.iField.getMaximumTextLength(locale);
    }

    public int getMaximumValue() {
        return this.iField.getMaximumValue();
    }

    public int getMinimumValue() {
        return this.iField.getMinimumValue();
    }

    public String getName() {
        return this.iType.getName();
    }

    public DurationField getRangeDurationField() {
        DurationField durationField = this.iRangeDurationField;
        if (durationField != null) {
            return durationField;
        }
        return this.iField.getRangeDurationField();
    }

    public DateTimeFieldType getType() {
        return this.iType;
    }

    public final DateTimeField getWrappedField() {
        return this.iField;
    }

    public boolean isLeap(long j2) {
        return this.iField.isLeap(j2);
    }

    public boolean isLenient() {
        return this.iField.isLenient();
    }

    public boolean isSupported() {
        return this.iField.isSupported();
    }

    public long remainder(long j2) {
        return this.iField.remainder(j2);
    }

    public long roundCeiling(long j2) {
        return this.iField.roundCeiling(j2);
    }

    public long roundFloor(long j2) {
        return this.iField.roundFloor(j2);
    }

    public long roundHalfCeiling(long j2) {
        return this.iField.roundHalfCeiling(j2);
    }

    public long roundHalfEven(long j2) {
        return this.iField.roundHalfEven(j2);
    }

    public long roundHalfFloor(long j2) {
        return this.iField.roundHalfFloor(j2);
    }

    public long set(long j2, int i2) {
        return this.iField.set(j2, i2);
    }

    public String toString() {
        return "DateTimeField[" + getName() + ']';
    }

    public DelegatedDateTimeField(DateTimeField dateTimeField, DateTimeFieldType dateTimeFieldType) {
        this(dateTimeField, (DurationField) null, dateTimeFieldType);
    }

    public long add(long j2, long j3) {
        return this.iField.add(j2, j3);
    }

    public int[] addWrapField(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        return this.iField.addWrapField(readablePartial, i2, iArr, i3);
    }

    public String getAsShortText(long j2) {
        return this.iField.getAsShortText(j2);
    }

    public String getAsText(long j2) {
        return this.iField.getAsText(j2);
    }

    public int getMaximumValue(long j2) {
        return this.iField.getMaximumValue(j2);
    }

    public int getMinimumValue(long j2) {
        return this.iField.getMinimumValue(j2);
    }

    public long set(long j2, String str, Locale locale) {
        return this.iField.set(j2, str, locale);
    }

    public DelegatedDateTimeField(DateTimeField dateTimeField, DurationField durationField, DateTimeFieldType dateTimeFieldType) {
        if (dateTimeField != null) {
            this.iField = dateTimeField;
            this.iRangeDurationField = durationField;
            this.iType = dateTimeFieldType == null ? dateTimeField.getType() : dateTimeFieldType;
            return;
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    public int[] add(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        return this.iField.add(readablePartial, i2, iArr, i3);
    }

    public String getAsShortText(ReadablePartial readablePartial, int i2, Locale locale) {
        return this.iField.getAsShortText(readablePartial, i2, locale);
    }

    public String getAsText(ReadablePartial readablePartial, int i2, Locale locale) {
        return this.iField.getAsText(readablePartial, i2, locale);
    }

    public int getMaximumValue(ReadablePartial readablePartial) {
        return this.iField.getMaximumValue(readablePartial);
    }

    public int getMinimumValue(ReadablePartial readablePartial) {
        return this.iField.getMinimumValue(readablePartial);
    }

    public long set(long j2, String str) {
        return this.iField.set(j2, str);
    }

    public String getAsShortText(ReadablePartial readablePartial, Locale locale) {
        return this.iField.getAsShortText(readablePartial, locale);
    }

    public String getAsText(ReadablePartial readablePartial, Locale locale) {
        return this.iField.getAsText(readablePartial, locale);
    }

    public int getMaximumValue(ReadablePartial readablePartial, int[] iArr) {
        return this.iField.getMaximumValue(readablePartial, iArr);
    }

    public int getMinimumValue(ReadablePartial readablePartial, int[] iArr) {
        return this.iField.getMinimumValue(readablePartial, iArr);
    }

    public int[] set(ReadablePartial readablePartial, int i2, int[] iArr, int i3) {
        return this.iField.set(readablePartial, i2, iArr, i3);
    }

    public String getAsShortText(int i2, Locale locale) {
        return this.iField.getAsShortText(i2, locale);
    }

    public String getAsText(int i2, Locale locale) {
        return this.iField.getAsText(i2, locale);
    }

    public int[] set(ReadablePartial readablePartial, int i2, int[] iArr, String str, Locale locale) {
        return this.iField.set(readablePartial, i2, iArr, str, locale);
    }
}
