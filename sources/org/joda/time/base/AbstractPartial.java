package org.joda.time.base;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DurationFieldType;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormatter;

public abstract class AbstractPartial implements ReadablePartial, Comparable<ReadablePartial> {
    protected AbstractPartial() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadablePartial)) {
            return false;
        }
        ReadablePartial readablePartial = (ReadablePartial) obj;
        if (size() != readablePartial.size()) {
            return false;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (getValue(i2) != readablePartial.getValue(i2) || getFieldType(i2) != readablePartial.getFieldType(i2)) {
                return false;
            }
        }
        return FieldUtils.equals(getChronology(), readablePartial.getChronology());
    }

    public int get(DateTimeFieldType dateTimeFieldType) {
        return getValue(indexOfSupported(dateTimeFieldType));
    }

    public DateTimeField getField(int i2) {
        return getField(i2, getChronology());
    }

    /* access modifiers changed from: protected */
    public abstract DateTimeField getField(int i2, Chronology chronology);

    public DateTimeFieldType getFieldType(int i2) {
        return getField(i2, getChronology()).getType();
    }

    public DateTimeFieldType[] getFieldTypes() {
        int size = size();
        DateTimeFieldType[] dateTimeFieldTypeArr = new DateTimeFieldType[size];
        for (int i2 = 0; i2 < size; i2++) {
            dateTimeFieldTypeArr[i2] = getFieldType(i2);
        }
        return dateTimeFieldTypeArr;
    }

    public DateTimeField[] getFields() {
        int size = size();
        DateTimeField[] dateTimeFieldArr = new DateTimeField[size];
        for (int i2 = 0; i2 < size; i2++) {
            dateTimeFieldArr[i2] = getField(i2);
        }
        return dateTimeFieldArr;
    }

    public int[] getValues() {
        int size = size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = getValue(i2);
        }
        return iArr;
    }

    public int hashCode() {
        int size = size();
        int i2 = 157;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = (((i2 * 23) + getValue(i3)) * 23) + getFieldType(i3).hashCode();
        }
        return i2 + getChronology().hashCode();
    }

    public int indexOf(DateTimeFieldType dateTimeFieldType) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (getFieldType(i2) == dateTimeFieldType) {
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int indexOfSupported(DateTimeFieldType dateTimeFieldType) {
        int indexOf = indexOf(dateTimeFieldType);
        if (indexOf != -1) {
            return indexOf;
        }
        throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
    }

    public boolean isAfter(ReadablePartial readablePartial) {
        if (readablePartial == null) {
            throw new IllegalArgumentException("Partial cannot be null");
        } else if (compareTo(readablePartial) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBefore(ReadablePartial readablePartial) {
        if (readablePartial == null) {
            throw new IllegalArgumentException("Partial cannot be null");
        } else if (compareTo(readablePartial) < 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEqual(ReadablePartial readablePartial) {
        if (readablePartial == null) {
            throw new IllegalArgumentException("Partial cannot be null");
        } else if (compareTo(readablePartial) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        return indexOf(dateTimeFieldType) != -1;
    }

    public DateTime toDateTime(ReadableInstant readableInstant) {
        Chronology instantChronology = DateTimeUtils.getInstantChronology(readableInstant);
        return new DateTime(instantChronology.set(this, DateTimeUtils.getInstantMillis(readableInstant)), instantChronology);
    }

    public String toString(DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            return toString();
        }
        return dateTimeFormatter.print((ReadablePartial) this);
    }

    public int compareTo(ReadablePartial readablePartial) {
        if (this == readablePartial) {
            return 0;
        }
        if (size() == readablePartial.size()) {
            int size = size();
            int i2 = 0;
            while (i2 < size) {
                if (getFieldType(i2) == readablePartial.getFieldType(i2)) {
                    i2++;
                } else {
                    throw new ClassCastException("ReadablePartial objects must have matching field types");
                }
            }
            int size2 = size();
            for (int i3 = 0; i3 < size2; i3++) {
                if (getValue(i3) > readablePartial.getValue(i3)) {
                    return 1;
                }
                if (getValue(i3) < readablePartial.getValue(i3)) {
                    return -1;
                }
            }
            return 0;
        }
        throw new ClassCastException("ReadablePartial objects must have matching field types");
    }

    /* access modifiers changed from: protected */
    public int indexOf(DurationFieldType durationFieldType) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (getFieldType(i2).getDurationType() == durationFieldType) {
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int indexOfSupported(DurationFieldType durationFieldType) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            return indexOf;
        }
        throw new IllegalArgumentException("Field '" + durationFieldType + "' is not supported");
    }
}
