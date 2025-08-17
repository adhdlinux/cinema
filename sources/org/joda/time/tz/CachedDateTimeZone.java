package org.joda.time.tz;

import org.joda.time.DateTimeZone;

public class CachedDateTimeZone extends DateTimeZone {
    private static final int cInfoCacheMask;
    private static final long serialVersionUID = 5472298452022250685L;
    private final transient Info[] iInfoCache = new Info[(cInfoCacheMask + 1)];
    private final DateTimeZone iZone;

    private static final class Info {
        private String iNameKey;
        Info iNextInfo;
        private int iOffset = Integer.MIN_VALUE;
        public final long iPeriodStart;
        private int iStandardOffset = Integer.MIN_VALUE;
        public final DateTimeZone iZoneRef;

        Info(DateTimeZone dateTimeZone, long j2) {
            this.iPeriodStart = j2;
            this.iZoneRef = dateTimeZone;
        }

        public String getNameKey(long j2) {
            Info info = this.iNextInfo;
            if (info != null && j2 >= info.iPeriodStart) {
                return info.getNameKey(j2);
            }
            if (this.iNameKey == null) {
                this.iNameKey = this.iZoneRef.getNameKey(this.iPeriodStart);
            }
            return this.iNameKey;
        }

        public int getOffset(long j2) {
            Info info = this.iNextInfo;
            if (info != null && j2 >= info.iPeriodStart) {
                return info.getOffset(j2);
            }
            if (this.iOffset == Integer.MIN_VALUE) {
                this.iOffset = this.iZoneRef.getOffset(this.iPeriodStart);
            }
            return this.iOffset;
        }

        public int getStandardOffset(long j2) {
            Info info = this.iNextInfo;
            if (info != null && j2 >= info.iPeriodStart) {
                return info.getStandardOffset(j2);
            }
            if (this.iStandardOffset == Integer.MIN_VALUE) {
                this.iStandardOffset = this.iZoneRef.getStandardOffset(this.iPeriodStart);
            }
            return this.iStandardOffset;
        }
    }

    static {
        Integer num;
        int i2;
        try {
            num = Integer.getInteger("org.joda.time.tz.CachedDateTimeZone.size");
        } catch (SecurityException unused) {
            num = null;
        }
        if (num == null) {
            i2 = 512;
        } else {
            int i3 = 0;
            for (int intValue = num.intValue() - 1; intValue > 0; intValue >>= 1) {
                i3++;
            }
            i2 = 1 << i3;
        }
        cInfoCacheMask = i2 - 1;
    }

    private CachedDateTimeZone(DateTimeZone dateTimeZone) {
        super(dateTimeZone.getID());
        this.iZone = dateTimeZone;
    }

    private Info createInfo(long j2) {
        long j3 = j2 & -4294967296L;
        Info info = new Info(this.iZone, j3);
        long j4 = 4294967295L | j3;
        Info info2 = info;
        while (true) {
            long nextTransition = this.iZone.nextTransition(j3);
            if (nextTransition == j3 || nextTransition > j4) {
                return info;
            }
            Info info3 = new Info(this.iZone, nextTransition);
            info2.iNextInfo = info3;
            info2 = info3;
            j3 = nextTransition;
        }
        return info;
    }

    public static CachedDateTimeZone forZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone instanceof CachedDateTimeZone) {
            return (CachedDateTimeZone) dateTimeZone;
        }
        return new CachedDateTimeZone(dateTimeZone);
    }

    private Info getInfo(long j2) {
        int i2 = (int) (j2 >> 32);
        Info[] infoArr = this.iInfoCache;
        int i3 = cInfoCacheMask & i2;
        Info info = infoArr[i3];
        if (info != null && ((int) (info.iPeriodStart >> 32)) == i2) {
            return info;
        }
        Info createInfo = createInfo(j2);
        infoArr[i3] = createInfo;
        return createInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CachedDateTimeZone) {
            return this.iZone.equals(((CachedDateTimeZone) obj).iZone);
        }
        return false;
    }

    public String getNameKey(long j2) {
        return getInfo(j2).getNameKey(j2);
    }

    public int getOffset(long j2) {
        return getInfo(j2).getOffset(j2);
    }

    public int getStandardOffset(long j2) {
        return getInfo(j2).getStandardOffset(j2);
    }

    public DateTimeZone getUncachedZone() {
        return this.iZone;
    }

    public int hashCode() {
        return this.iZone.hashCode();
    }

    public boolean isFixed() {
        return this.iZone.isFixed();
    }

    public long nextTransition(long j2) {
        return this.iZone.nextTransition(j2);
    }

    public long previousTransition(long j2) {
        return this.iZone.previousTransition(j2);
    }
}
