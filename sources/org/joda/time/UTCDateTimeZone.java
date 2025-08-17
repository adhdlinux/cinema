package org.joda.time;

import java.util.SimpleTimeZone;
import java.util.TimeZone;

final class UTCDateTimeZone extends DateTimeZone {
    static final DateTimeZone INSTANCE = new UTCDateTimeZone();
    private static final long serialVersionUID = -3513011772763289092L;

    public UTCDateTimeZone() {
        super("UTC");
    }

    public boolean equals(Object obj) {
        return obj instanceof UTCDateTimeZone;
    }

    public String getNameKey(long j2) {
        return "UTC";
    }

    public int getOffset(long j2) {
        return 0;
    }

    public int getOffsetFromLocal(long j2) {
        return 0;
    }

    public int getStandardOffset(long j2) {
        return 0;
    }

    public int hashCode() {
        return getID().hashCode();
    }

    public boolean isFixed() {
        return true;
    }

    public long nextTransition(long j2) {
        return j2;
    }

    public long previousTransition(long j2) {
        return j2;
    }

    public TimeZone toTimeZone() {
        return new SimpleTimeZone(0, getID());
    }
}
