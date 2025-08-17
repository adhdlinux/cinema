package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;

public enum BannerAdSize {
    VUNGLE_MREC("mrec", 300, 250),
    BANNER("banner", Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 50),
    BANNER_SHORT("banner_short", 300, 50),
    BANNER_LEADERBOARD("banner_leaderboard", 728, 90);
    
    private final int height;
    private final String sizeName;
    private final int width;

    private BannerAdSize(String str, int i2, int i3) {
        this.sizeName = str;
        this.width = i2;
        this.height = i3;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getSizeName() {
        return this.sizeName;
    }

    public final int getWidth() {
        return this.width;
    }
}
