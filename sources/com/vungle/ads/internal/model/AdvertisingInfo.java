package com.vungle.ads.internal.model;

public final class AdvertisingInfo {
    private String advertisingId;
    private boolean limitAdTracking;

    public final String getAdvertisingId() {
        return this.advertisingId;
    }

    public final boolean getLimitAdTracking() {
        return this.limitAdTracking;
    }

    public final void setAdvertisingId(String str) {
        this.advertisingId = str;
    }

    public final void setLimitAdTracking(boolean z2) {
        this.limitAdTracking = z2;
    }
}
