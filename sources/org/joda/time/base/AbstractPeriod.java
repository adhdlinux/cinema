package org.joda.time.base;

import org.joda.convert.ToString;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.ReadablePeriod;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

public abstract class AbstractPeriod implements ReadablePeriod {
    protected AbstractPeriod() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadablePeriod)) {
            return false;
        }
        ReadablePeriod readablePeriod = (ReadablePeriod) obj;
        if (size() != readablePeriod.size()) {
            return false;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (getValue(i2) != readablePeriod.getValue(i2) || getFieldType(i2) != readablePeriod.getFieldType(i2)) {
                return false;
            }
        }
        return true;
    }

    public int get(DurationFieldType durationFieldType) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf == -1) {
            return 0;
        }
        return getValue(indexOf);
    }

    public DurationFieldType getFieldType(int i2) {
        return getPeriodType().getFieldType(i2);
    }

    public DurationFieldType[] getFieldTypes() {
        int size = size();
        DurationFieldType[] durationFieldTypeArr = new DurationFieldType[size];
        for (int i2 = 0; i2 < size; i2++) {
            durationFieldTypeArr[i2] = getFieldType(i2);
        }
        return durationFieldTypeArr;
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
        int i2 = 17;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = (((i2 * 27) + getValue(i3)) * 27) + getFieldType(i3).hashCode();
        }
        return i2;
    }

    public int indexOf(DurationFieldType durationFieldType) {
        return getPeriodType().indexOf(durationFieldType);
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        return getPeriodType().isSupported(durationFieldType);
    }

    public int size() {
        return getPeriodType().size();
    }

    public MutablePeriod toMutablePeriod() {
        return new MutablePeriod((Object) this);
    }

    public Period toPeriod() {
        return new Period((Object) this);
    }

    @ToString
    public String toString() {
        return ISOPeriodFormat.standard().print(this);
    }

    public String toString(PeriodFormatter periodFormatter) {
        if (periodFormatter == null) {
            return toString();
        }
        return periodFormatter.print(this);
    }
}
