package com.facebook.ads.internal.protocol;

public enum f {
    UNKNOWN(0),
    WEBVIEW_BANNER_LEGACY(4),
    WEBVIEW_BANNER_50(5),
    WEBVIEW_BANNER_90(6),
    WEBVIEW_BANNER_250(7),
    WEBVIEW_INTERSTITIAL_UNKNOWN(100),
    WEBVIEW_INTERSTITIAL_HORIZONTAL(101),
    WEBVIEW_INTERSTITIAL_VERTICAL(102),
    WEBVIEW_INTERSTITIAL_TABLET(103),
    NATIVE_UNKNOWN(200),
    NATIVE_BANNER(500),
    NATIVE_250(201),
    REWARDED_VIDEO(400),
    INSTREAM_VIDEO(300);
    

    /* renamed from: o  reason: collision with root package name */
    private final int f20582o;

    private f(int i2) {
        this.f20582o = i2;
    }

    public int a() {
        return this.f20582o;
    }
}
