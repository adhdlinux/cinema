package org.joda.time.chrono;

import org.joda.time.DateTimeZone;
import org.joda.time.Instant;

class GJCacheKey {
    private final Instant cutoverInstant;
    private final int minDaysInFirstWeek;
    private final DateTimeZone zone;

    GJCacheKey(DateTimeZone dateTimeZone, Instant instant, int i2) {
        this.zone = dateTimeZone;
        this.cutoverInstant = instant;
        this.minDaysInFirstWeek = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GJCacheKey)) {
            return false;
        }
        GJCacheKey gJCacheKey = (GJCacheKey) obj;
        Instant instant = this.cutoverInstant;
        if (instant == null) {
            if (gJCacheKey.cutoverInstant != null) {
                return false;
            }
        } else if (!instant.equals(gJCacheKey.cutoverInstant)) {
            return false;
        }
        if (this.minDaysInFirstWeek != gJCacheKey.minDaysInFirstWeek) {
            return false;
        }
        DateTimeZone dateTimeZone = this.zone;
        if (dateTimeZone == null) {
            if (gJCacheKey.zone != null) {
                return false;
            }
        } else if (!dateTimeZone.equals(gJCacheKey.zone)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        Instant instant = this.cutoverInstant;
        int i3 = 0;
        if (instant == null) {
            i2 = 0;
        } else {
            i2 = instant.hashCode();
        }
        int i4 = (((i2 + 31) * 31) + this.minDaysInFirstWeek) * 31;
        DateTimeZone dateTimeZone = this.zone;
        if (dateTimeZone != null) {
            i3 = dateTimeZone.hashCode();
        }
        return i4 + i3;
    }
}
