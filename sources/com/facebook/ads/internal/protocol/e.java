package com.facebook.ads.internal.protocol;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.Serializable;

public enum e implements Serializable {
    BANNER_320_50(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 50),
    INTERSTITIAL(0, 0),
    BANNER_HEIGHT_50(-1, 50),
    BANNER_HEIGHT_90(-1, 90),
    RECTANGLE_HEIGHT_250(-1, 250);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f20565f;

    /* renamed from: g  reason: collision with root package name */
    private final int f20566g;

    private e(int i2, int i3) {
        this.f20565f = i2;
        this.f20566g = i3;
    }

    public static e a(int i2, int i3) {
        e eVar = INTERSTITIAL;
        if (eVar.f20566g == i3 && eVar.f20565f == i2) {
            return eVar;
        }
        e eVar2 = BANNER_320_50;
        if (eVar2.f20566g == i3 && eVar2.f20565f == i2) {
            return eVar2;
        }
        e eVar3 = BANNER_HEIGHT_50;
        if (eVar3.f20566g == i3 && eVar3.f20565f == i2) {
            return eVar3;
        }
        e eVar4 = BANNER_HEIGHT_90;
        if (eVar4.f20566g == i3 && eVar4.f20565f == i2) {
            return eVar4;
        }
        e eVar5 = RECTANGLE_HEIGHT_250;
        if (eVar5.f20566g == i3 && eVar5.f20565f == i2) {
            return eVar5;
        }
        return null;
    }

    public int a() {
        return this.f20565f;
    }

    public int b() {
        return this.f20566g;
    }
}
