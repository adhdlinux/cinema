package com.vungle.ads.internal.util;

import kotlin.jvm.internal.Intrinsics;

public final class LogEntry {
    private String adSource;
    private String creativeId;
    private String eventId;
    private String placementRefId;

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<LogEntry> cls2 = LogEntry.class;
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.a(cls2, cls)) {
            return false;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type com.vungle.ads.internal.util.LogEntry");
        LogEntry logEntry = (LogEntry) obj;
        if (Intrinsics.a(this.placementRefId, logEntry.placementRefId) && Intrinsics.a(this.creativeId, logEntry.creativeId) && Intrinsics.a(this.eventId, logEntry.eventId) && Intrinsics.a(this.adSource, logEntry.adSource)) {
            return true;
        }
        return false;
    }

    public final String getAdSource$vungle_ads_release() {
        return this.adSource;
    }

    public final String getCreativeId$vungle_ads_release() {
        return this.creativeId;
    }

    public final String getEventId$vungle_ads_release() {
        return this.eventId;
    }

    public final String getPlacementRefId$vungle_ads_release() {
        return this.placementRefId;
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4;
        String str = this.placementRefId;
        int i5 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = i2 * 31;
        String str2 = this.creativeId;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (i6 + i3) * 31;
        String str3 = this.eventId;
        if (str3 != null) {
            i4 = str3.hashCode();
        } else {
            i4 = 0;
        }
        int i8 = (i7 + i4) * 31;
        String str4 = this.adSource;
        if (str4 != null) {
            i5 = str4.hashCode();
        }
        return i8 + i5;
    }

    public final void setAdSource$vungle_ads_release(String str) {
        this.adSource = str;
    }

    public final void setCreativeId$vungle_ads_release(String str) {
        this.creativeId = str;
    }

    public final void setEventId$vungle_ads_release(String str) {
        this.eventId = str;
    }

    public final void setPlacementRefId$vungle_ads_release(String str) {
        this.placementRefId = str;
    }

    public String toString() {
        return "LogEntry(placementRefId=" + this.placementRefId + ", creativeId=" + this.creativeId + ", eventId=" + this.eventId + ", adSource=" + this.adSource + ')';
    }
}
