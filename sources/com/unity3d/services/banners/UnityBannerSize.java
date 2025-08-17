package com.unity3d.services.banners;

import android.content.Context;
import com.unity3d.services.core.misc.ViewUtilities;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class UnityBannerSize {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final UnityBannerSize iabStandard = new UnityBannerSize(468, 60);
    /* access modifiers changed from: private */
    public static final UnityBannerSize leaderboard = new UnityBannerSize(728, 90);
    /* access modifiers changed from: private */
    public static final UnityBannerSize standard = new UnityBannerSize(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
    private final int height;
    private final int width;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UnityBannerSize getDynamicSize(Context context) {
            Intrinsics.f(context, "context");
            int b2 = MathKt__MathJVMKt.b(ViewUtilities.dpFromPx(context, (float) context.getResources().getDisplayMetrics().widthPixels));
            if (b2 >= getLeaderboard().getWidth()) {
                return getLeaderboard();
            }
            if (b2 >= getIabStandard().getWidth()) {
                return getIabStandard();
            }
            return getStandard();
        }

        public final UnityBannerSize getIabStandard() {
            return UnityBannerSize.iabStandard;
        }

        public final UnityBannerSize getLeaderboard() {
            return UnityBannerSize.leaderboard;
        }

        public final UnityBannerSize getStandard() {
            return UnityBannerSize.standard;
        }
    }

    public UnityBannerSize(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    public static final UnityBannerSize getDynamicSize(Context context) {
        return Companion.getDynamicSize(context);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }
}
