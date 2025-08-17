package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public final class MillisDurationField extends DurationField implements Serializable {
    public static final DurationField INSTANCE = new MillisDurationField();
    private static final long serialVersionUID = 2656707858124633367L;

    private MillisDurationField() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public long add(long j2, int i2) {
        return FieldUtils.safeAdd(j2, (long) i2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MillisDurationField) || getUnitMillis() != ((MillisDurationField) obj).getUnitMillis()) {
            return false;
        }
        return true;
    }

    public int getDifference(long j2, long j3) {
        return FieldUtils.safeToInt(FieldUtils.safeSubtract(j2, j3));
    }

    public long getDifferenceAsLong(long j2, long j3) {
        return FieldUtils.safeSubtract(j2, j3);
    }

    public long getMillis(int i2) {
        return (long) i2;
    }

    public long getMillis(int i2, long j2) {
        return (long) i2;
    }

    public long getMillis(long j2) {
        return j2;
    }

    public long getMillis(long j2, long j3) {
        return j2;
    }

    public String getName() {
        return "millis";
    }

    public DurationFieldType getType() {
        return DurationFieldType.millis();
    }

    public final long getUnitMillis() {
        return 1;
    }

    public int getValue(long j2) {
        return FieldUtils.safeToInt(j2);
    }

    public long getValueAsLong(long j2) {
        return j2;
    }

    public long getValueAsLong(long j2, long j3) {
        return j2;
    }

    public int hashCode() {
        return (int) getUnitMillis();
    }

    public final boolean isPrecise() {
        return true;
    }

    public boolean isSupported() {
        return true;
    }

    public String toString() {
        return "DurationField[millis]";
    }

    public long add(long j2, long j3) {
        return FieldUtils.safeAdd(j2, j3);
    }

    public int compareTo(DurationField durationField) {
        int i2 = (getUnitMillis() > durationField.getUnitMillis() ? 1 : (getUnitMillis() == durationField.getUnitMillis() ? 0 : -1));
        if (i2 == 0) {
            return 0;
        }
        return i2 < 0 ? -1 : 1;
    }

    public int getValue(long j2, long j3) {
        return FieldUtils.safeToInt(j2);
    }
}
