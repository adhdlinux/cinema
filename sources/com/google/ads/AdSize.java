package com.google.ads;

import android.content.Context;
import com.vungle.ads.internal.protos.Sdk$SDKError;

@Deprecated
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
    public static final int FULL_WIDTH = -1;
    public static final AdSize IAB_BANNER = new AdSize(468, 60);
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90);
    public static final AdSize IAB_MRECT = new AdSize(300, 250);
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600);
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    public static final AdSize SMART_BANNER = new AdSize(-1, -2);

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.gms.ads.AdSize f22248a;

    public AdSize(int i2, int i3) {
        this(new com.google.android.gms.ads.AdSize(i2, i3));
    }

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.f22248a = adSize;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdSize)) {
            return false;
        }
        return this.f22248a.equals(((AdSize) obj).f22248a);
    }

    public AdSize findBestSize(AdSize... adSizeArr) {
        AdSize adSize = null;
        if (adSizeArr == null) {
            return null;
        }
        int width = getWidth();
        int height = getHeight();
        float f2 = 0.0f;
        for (AdSize adSize2 : adSizeArr) {
            int width2 = adSize2.getWidth();
            int height2 = adSize2.getHeight();
            if (isSizeAppropriate(width2, height2)) {
                float f3 = ((float) (width2 * height2)) / ((float) (width * height));
                if (f3 > 1.0f) {
                    f3 = 1.0f / f3;
                }
                if (f3 > f2) {
                    adSize = adSize2;
                    f2 = f3;
                }
            }
        }
        return adSize;
    }

    public int getHeight() {
        return this.f22248a.getHeight();
    }

    public int getHeightInPixels(Context context) {
        return this.f22248a.getHeightInPixels(context);
    }

    public int getWidth() {
        return this.f22248a.getWidth();
    }

    public int getWidthInPixels(Context context) {
        return this.f22248a.getWidthInPixels(context);
    }

    public int hashCode() {
        return this.f22248a.hashCode();
    }

    public boolean isAutoHeight() {
        return this.f22248a.isAutoHeight();
    }

    public boolean isCustomAdSize() {
        return false;
    }

    public boolean isFullWidth() {
        return this.f22248a.isFullWidth();
    }

    public boolean isSizeAppropriate(int i2, int i3) {
        float width = (float) getWidth();
        float f2 = (float) i2;
        int i4 = (f2 > (width * 1.25f) ? 1 : (f2 == (width * 1.25f) ? 0 : -1));
        int height = getHeight();
        if (i4 > 0 || f2 < width * 0.8f) {
            return false;
        }
        float f3 = (float) i3;
        float f4 = (float) height;
        if (f3 > 1.25f * f4 || f3 < f4 * 0.8f) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.f22248a.toString();
    }
}
