package com.vungle.ads;

import android.content.Context;
import com.facebook.ads.AudienceNetworkActivity;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.util.ViewUtility;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class VungleAdSize {
    public static final VungleAdSize BANNER = new VungleAdSize(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
    public static final VungleAdSize BANNER_LEADERBOARD = new VungleAdSize(728, 90);
    public static final VungleAdSize BANNER_SHORT = new VungleAdSize(300, 50);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final VungleAdSize MREC = new VungleAdSize(300, 250);
    private final int height;
    private boolean isAdaptiveHeight;
    private boolean isAdaptiveWidth;
    private final int width;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VungleAdSize getAdSizeWithWidth(Context context, int i2) {
            Intrinsics.f(context, "context");
            int intValue = ViewUtility.INSTANCE.getDeviceWidthAndHeightWithOrientation(context, 0).b().intValue();
            if (i2 < 0) {
                i2 = 0;
            }
            VungleAdSize vungleAdSize = new VungleAdSize(i2, intValue);
            if (vungleAdSize.getWidth() == 0) {
                vungleAdSize.setAdaptiveWidth$vungle_ads_release(true);
            }
            vungleAdSize.setAdaptiveHeight$vungle_ads_release(true);
            return vungleAdSize;
        }

        public final VungleAdSize getAdSizeWithWidthAndHeight(int i2, int i3) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            VungleAdSize vungleAdSize = new VungleAdSize(i2, i3);
            if (vungleAdSize.getWidth() == 0) {
                vungleAdSize.setAdaptiveWidth$vungle_ads_release(true);
            }
            if (vungleAdSize.getHeight() == 0) {
                vungleAdSize.setAdaptiveHeight$vungle_ads_release(true);
            }
            return vungleAdSize;
        }

        public final VungleAdSize getAdSizeWithWidthAndMaxHeight(int i2, int i3) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            VungleAdSize vungleAdSize = new VungleAdSize(i2, i3);
            if (vungleAdSize.getWidth() == 0) {
                vungleAdSize.setAdaptiveWidth$vungle_ads_release(true);
            }
            vungleAdSize.setAdaptiveHeight$vungle_ads_release(true);
            return vungleAdSize;
        }

        public final VungleAdSize getValidAdSizeFromSize(int i2, int i3, String str) {
            Intrinsics.f(str, AudienceNetworkActivity.PLACEMENT_ID);
            Placement placement = ConfigManager.INSTANCE.getPlacement(str);
            if (placement != null) {
                if (!placement.isInline()) {
                    placement = null;
                }
                if (placement != null) {
                    return VungleAdSize.Companion.getAdSizeWithWidthAndHeight(i2, i3);
                }
            }
            VungleAdSize vungleAdSize = VungleAdSize.MREC;
            if (i2 >= vungleAdSize.getWidth() && i3 >= vungleAdSize.getHeight()) {
                return vungleAdSize;
            }
            VungleAdSize vungleAdSize2 = VungleAdSize.BANNER_LEADERBOARD;
            if (i2 >= vungleAdSize2.getWidth() && i3 >= vungleAdSize2.getHeight()) {
                return vungleAdSize2;
            }
            VungleAdSize vungleAdSize3 = VungleAdSize.BANNER;
            if (i2 >= vungleAdSize3.getWidth() && i3 >= vungleAdSize3.getHeight()) {
                return vungleAdSize3;
            }
            VungleAdSize vungleAdSize4 = VungleAdSize.BANNER_SHORT;
            if (i2 < vungleAdSize4.getWidth() || i3 < vungleAdSize4.getHeight()) {
                return getAdSizeWithWidthAndHeight(i2, i3);
            }
            return vungleAdSize4;
        }
    }

    public VungleAdSize(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    public static final VungleAdSize getAdSizeWithWidth(Context context, int i2) {
        return Companion.getAdSizeWithWidth(context, i2);
    }

    public static final VungleAdSize getAdSizeWithWidthAndHeight(int i2, int i3) {
        return Companion.getAdSizeWithWidthAndHeight(i2, i3);
    }

    public static final VungleAdSize getAdSizeWithWidthAndMaxHeight(int i2, int i3) {
        return Companion.getAdSizeWithWidthAndMaxHeight(i2, i3);
    }

    public static final VungleAdSize getValidAdSizeFromSize(int i2, int i3, String str) {
        return Companion.getValidAdSizeFromSize(i2, i3, str);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isAdaptiveHeight$vungle_ads_release() {
        return this.isAdaptiveHeight;
    }

    public final boolean isAdaptiveWidth$vungle_ads_release() {
        return this.isAdaptiveWidth;
    }

    public final boolean isValidSize$vungle_ads_release() {
        return this.width >= 0 && this.height >= 0;
    }

    public final void setAdaptiveHeight$vungle_ads_release(boolean z2) {
        this.isAdaptiveHeight = z2;
    }

    public final void setAdaptiveWidth$vungle_ads_release(boolean z2) {
        this.isAdaptiveWidth = z2;
    }

    public String toString() {
        return "VungleAdSize(width=" + this.width + ", height=" + this.height + ')';
    }
}
