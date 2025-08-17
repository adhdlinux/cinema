package com.facebook.ads;

import com.facebook.ads.internal.protocol.e;
import java.io.Serializable;

public class AdSize implements Serializable {
    @Deprecated
    public static final AdSize BANNER_320_50 = new AdSize(e.BANNER_320_50);
    public static final AdSize BANNER_HEIGHT_50 = new AdSize(e.BANNER_HEIGHT_50);
    public static final AdSize BANNER_HEIGHT_90 = new AdSize(e.BANNER_HEIGHT_90);
    public static final AdSize INTERSTITIAL = new AdSize(e.INTERSTITIAL);
    public static final AdSize RECTANGLE_HEIGHT_250 = new AdSize(e.RECTANGLE_HEIGHT_250);

    /* renamed from: a  reason: collision with root package name */
    private final int f19421a;

    /* renamed from: b  reason: collision with root package name */
    private final int f19422b;

    public AdSize(int i2, int i3) {
        this.f19421a = i2;
        this.f19422b = i3;
    }

    private AdSize(e eVar) {
        this.f19421a = eVar.a();
        this.f19422b = eVar.b();
    }

    public static AdSize fromWidthAndHeight(int i2, int i3) {
        AdSize adSize = INTERSTITIAL;
        if (adSize.f19422b == i3 && adSize.f19421a == i2) {
            return adSize;
        }
        AdSize adSize2 = BANNER_320_50;
        if (adSize2.f19422b == i3 && adSize2.f19421a == i2) {
            return adSize2;
        }
        AdSize adSize3 = BANNER_HEIGHT_50;
        if (adSize3.f19422b == i3 && adSize3.f19421a == i2) {
            return adSize3;
        }
        AdSize adSize4 = BANNER_HEIGHT_90;
        if (adSize4.f19422b == i3 && adSize4.f19421a == i2) {
            return adSize4;
        }
        AdSize adSize5 = RECTANGLE_HEIGHT_250;
        if (adSize5.f19422b == i3 && adSize5.f19421a == i2) {
            return adSize5;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.f19421a == adSize.f19421a && this.f19422b == adSize.f19422b;
    }

    public int getHeight() {
        return this.f19422b;
    }

    public int getWidth() {
        return this.f19421a;
    }

    public int hashCode() {
        return (this.f19421a * 31) + this.f19422b;
    }

    public e toInternalAdSize() {
        return e.a(this.f19421a, this.f19422b);
    }
}
