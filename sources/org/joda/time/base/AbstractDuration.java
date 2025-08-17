package org.joda.time.base;

import org.joda.convert.ToString;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.ReadableDuration;
import org.joda.time.format.FormatUtils;

public abstract class AbstractDuration implements ReadableDuration {
    protected AbstractDuration() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ReadableDuration) && getMillis() == ((ReadableDuration) obj).getMillis()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long millis = getMillis();
        return (int) (millis ^ (millis >>> 32));
    }

    public boolean isEqual(ReadableDuration readableDuration) {
        if (readableDuration == null) {
            readableDuration = Duration.ZERO;
        }
        if (compareTo(readableDuration) == 0) {
            return true;
        }
        return false;
    }

    public boolean isLongerThan(ReadableDuration readableDuration) {
        if (readableDuration == null) {
            readableDuration = Duration.ZERO;
        }
        if (compareTo(readableDuration) > 0) {
            return true;
        }
        return false;
    }

    public boolean isShorterThan(ReadableDuration readableDuration) {
        if (readableDuration == null) {
            readableDuration = Duration.ZERO;
        }
        if (compareTo(readableDuration) < 0) {
            return true;
        }
        return false;
    }

    public Duration toDuration() {
        return new Duration(getMillis());
    }

    public Period toPeriod() {
        return new Period(getMillis());
    }

    @ToString
    public String toString() {
        boolean z2;
        int i2;
        long millis = getMillis();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PT");
        if (millis < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        FormatUtils.appendUnpaddedInteger(stringBuffer, millis);
        while (true) {
            int length = stringBuffer.length();
            if (z2) {
                i2 = 7;
            } else {
                i2 = 6;
            }
            int i3 = 3;
            if (length >= i2) {
                break;
            }
            if (!z2) {
                i3 = 2;
            }
            stringBuffer.insert(i3, "0");
        }
        if ((millis / 1000) * 1000 == millis) {
            stringBuffer.setLength(stringBuffer.length() - 3);
        } else {
            stringBuffer.insert(stringBuffer.length() - 3, ".");
        }
        stringBuffer.append('S');
        return stringBuffer.toString();
    }

    public int compareTo(ReadableDuration readableDuration) {
        int i2 = (getMillis() > readableDuration.getMillis() ? 1 : (getMillis() == readableDuration.getMillis() ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }
}
