package org.threeten.bp.temporal;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;

public final class ValueRange implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;
    private final long maxLargest;
    private final long maxSmallest;
    private final long minLargest;
    private final long minSmallest;

    private ValueRange(long j2, long j3, long j4, long j5) {
        this.minSmallest = j2;
        this.minLargest = j3;
        this.maxSmallest = j4;
        this.maxLargest = j5;
    }

    public static ValueRange of(long j2, long j3) {
        if (j2 <= j3) {
            return new ValueRange(j2, j2, j3, j3);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public int checkValidIntValue(long j2, TemporalField temporalField) {
        if (isValidIntValue(j2)) {
            return (int) j2;
        }
        throw new DateTimeException("Invalid int value for " + temporalField + ": " + j2);
    }

    public long checkValidValue(long j2, TemporalField temporalField) {
        if (isValidValue(j2)) {
            return j2;
        }
        if (temporalField != null) {
            throw new DateTimeException("Invalid value for " + temporalField + " (valid values " + this + "): " + j2);
        }
        throw new DateTimeException("Invalid value (valid values " + this + "): " + j2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueRange)) {
            return false;
        }
        ValueRange valueRange = (ValueRange) obj;
        if (this.minSmallest == valueRange.minSmallest && this.minLargest == valueRange.minLargest && this.maxSmallest == valueRange.maxSmallest && this.maxLargest == valueRange.maxLargest) {
            return true;
        }
        return false;
    }

    public long getLargestMinimum() {
        return this.minLargest;
    }

    public long getMaximum() {
        return this.maxLargest;
    }

    public long getMinimum() {
        return this.minSmallest;
    }

    public long getSmallestMaximum() {
        return this.maxSmallest;
    }

    public int hashCode() {
        long j2 = this.minSmallest;
        long j3 = this.minLargest;
        long j4 = this.maxSmallest;
        long j5 = this.maxLargest;
        long j6 = ((((((j2 + j3) << ((int) (j3 + 16))) >> ((int) (j4 + 48))) << ((int) (j4 + 32))) >> ((int) (32 + j5))) << ((int) (j5 + 48))) >> 16;
        return (int) (j6 ^ (j6 >>> 32));
    }

    public boolean isFixed() {
        return this.minSmallest == this.minLargest && this.maxSmallest == this.maxLargest;
    }

    public boolean isIntValue() {
        return getMinimum() >= -2147483648L && getMaximum() <= 2147483647L;
    }

    public boolean isValidIntValue(long j2) {
        return isIntValue() && isValidValue(j2);
    }

    public boolean isValidValue(long j2) {
        return j2 >= getMinimum() && j2 <= getMaximum();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.minSmallest);
        if (this.minSmallest != this.minLargest) {
            sb.append('/');
            sb.append(this.minLargest);
        }
        sb.append(" - ");
        sb.append(this.maxSmallest);
        if (this.maxSmallest != this.maxLargest) {
            sb.append('/');
            sb.append(this.maxLargest);
        }
        return sb.toString();
    }

    public static ValueRange of(long j2, long j3, long j4) {
        return of(j2, j2, j3, j4);
    }

    public static ValueRange of(long j2, long j3, long j4, long j5) {
        if (j2 > j3) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        } else if (j4 > j5) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (j3 <= j5) {
            return new ValueRange(j2, j3, j4, j5);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }
}
