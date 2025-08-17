package org.joda.time.tz;

import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.joda.time.DateTimeZone;

public final class FixedDateTimeZone extends DateTimeZone {
    private static final long serialVersionUID = -3513011772763289092L;
    private final String iNameKey;
    private final int iStandardOffset;
    private final int iWallOffset;

    public FixedDateTimeZone(String str, String str2, int i2, int i3) {
        super(str);
        this.iNameKey = str2;
        this.iWallOffset = i2;
        this.iStandardOffset = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FixedDateTimeZone)) {
            return false;
        }
        FixedDateTimeZone fixedDateTimeZone = (FixedDateTimeZone) obj;
        if (getID().equals(fixedDateTimeZone.getID()) && this.iStandardOffset == fixedDateTimeZone.iStandardOffset && this.iWallOffset == fixedDateTimeZone.iWallOffset) {
            return true;
        }
        return false;
    }

    public String getNameKey(long j2) {
        return this.iNameKey;
    }

    public int getOffset(long j2) {
        return this.iWallOffset;
    }

    public int getOffsetFromLocal(long j2) {
        return this.iWallOffset;
    }

    public int getStandardOffset(long j2) {
        return this.iStandardOffset;
    }

    public int hashCode() {
        return getID().hashCode() + (this.iStandardOffset * 37) + (this.iWallOffset * 31);
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
        String id = getID();
        if (id.length() != 6 || (!id.startsWith("+") && !id.startsWith("-"))) {
            return new SimpleTimeZone(this.iWallOffset, getID());
        }
        return TimeZone.getTimeZone("GMT" + getID());
    }
}
