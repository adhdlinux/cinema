package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;

public class DelegatedDurationField extends DurationField implements Serializable {
    private static final long serialVersionUID = -5576443481242007829L;
    private final DurationField iField;
    private final DurationFieldType iType;

    protected DelegatedDurationField(DurationField durationField) {
        this(durationField, (DurationFieldType) null);
    }

    public long add(long j2, int i2) {
        return this.iField.add(j2, i2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DelegatedDurationField) {
            return this.iField.equals(((DelegatedDurationField) obj).iField);
        }
        return false;
    }

    public int getDifference(long j2, long j3) {
        return this.iField.getDifference(j2, j3);
    }

    public long getDifferenceAsLong(long j2, long j3) {
        return this.iField.getDifferenceAsLong(j2, j3);
    }

    public long getMillis(int i2) {
        return this.iField.getMillis(i2);
    }

    public String getName() {
        return this.iType.getName();
    }

    public DurationFieldType getType() {
        return this.iType;
    }

    public long getUnitMillis() {
        return this.iField.getUnitMillis();
    }

    public int getValue(long j2) {
        return this.iField.getValue(j2);
    }

    public long getValueAsLong(long j2) {
        return this.iField.getValueAsLong(j2);
    }

    public final DurationField getWrappedField() {
        return this.iField;
    }

    public int hashCode() {
        return this.iField.hashCode() ^ this.iType.hashCode();
    }

    public boolean isPrecise() {
        return this.iField.isPrecise();
    }

    public boolean isSupported() {
        return this.iField.isSupported();
    }

    public String toString() {
        if (this.iType == null) {
            return this.iField.toString();
        }
        return "DurationField[" + this.iType + ']';
    }

    protected DelegatedDurationField(DurationField durationField, DurationFieldType durationFieldType) {
        if (durationField != null) {
            this.iField = durationField;
            this.iType = durationFieldType == null ? durationField.getType() : durationFieldType;
            return;
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    public long add(long j2, long j3) {
        return this.iField.add(j2, j3);
    }

    public int compareTo(DurationField durationField) {
        return this.iField.compareTo(durationField);
    }

    public long getMillis(long j2) {
        return this.iField.getMillis(j2);
    }

    public int getValue(long j2, long j3) {
        return this.iField.getValue(j2, j3);
    }

    public long getValueAsLong(long j2, long j3) {
        return this.iField.getValueAsLong(j2, j3);
    }

    public long getMillis(int i2, long j2) {
        return this.iField.getMillis(i2, j2);
    }

    public long getMillis(long j2, long j3) {
        return this.iField.getMillis(j2, j3);
    }
}
