package com.chartboost.sdk.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.core.os.HandlerCompat;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.callbacks.BannerCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.CacheEvent;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.events.ShowEvent;
import com.chartboost.sdk.impl.i;
import com.chartboost.sdk.impl.p1;
import com.chartboost.sdk.internal.Model.CBError;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@SuppressLint({"ViewConstructor"})
public final class Banner extends FrameLayout implements Ad {
    private final Lazy api$delegate;
    private final BannerCallback callback;
    private final String location;
    private final Handler mainThreadHandler;
    /* access modifiers changed from: private */
    public final Mediation mediation;
    private final BannerSize size;

    public enum BannerSize {
        STANDARD(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 50),
        MEDIUM(300, 250),
        LEADERBOARD(728, 90);
        
        private final int height;
        private final int width;

        private BannerSize(int i2, int i3) {
            this.width = i2;
            this.height = i3;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }
    }

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Banner f17164b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Banner banner) {
            super(0);
            this.f17164b = banner;
        }

        /* renamed from: a */
        public final p1 invoke() {
            return i.a(this.f17164b.mediation);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Banner(Context context, String str, BannerSize bannerSize, BannerCallback bannerCallback, Mediation mediation2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, bannerSize, bannerCallback, (i2 & 16) != 0 ? null : mediation2);
    }

    private final p1 getApi() {
        return (p1) this.api$delegate.getValue();
    }

    private final void postSessionNotStartedInMainThread(boolean z2) {
        try {
            this.mainThreadHandler.post(new a0.a(z2, this));
        } catch (Exception e2) {
            Log.e("Chartboost", "Interstitial ad cannot post session not started callback " + e2);
        }
    }

    /* access modifiers changed from: private */
    public static final void postSessionNotStartedInMainThread$lambda$0(boolean z2, Banner banner) {
        Intrinsics.f(banner, "this$0");
        if (z2) {
            banner.callback.onAdLoaded(new CacheEvent((String) null, banner), new CacheError(CacheError.Code.SESSION_NOT_STARTED, (Exception) null, 2, (DefaultConstructorMarker) null));
        } else {
            banner.callback.onAdShown(new ShowEvent((String) null, banner), new ShowError(ShowError.Code.SESSION_NOT_STARTED, (Exception) null, 2, (DefaultConstructorMarker) null));
        }
    }

    public void cache() {
        if (!Chartboost.isSdkStarted()) {
            postSessionNotStartedInMainThread(true);
        } else {
            getApi().a(this, this.callback);
        }
    }

    public void clearCache() {
        if (Chartboost.isSdkStarted()) {
            getApi().a();
        }
    }

    public final void detach() {
        if (Chartboost.isSdkStarted()) {
            getApi().d();
        }
    }

    public final int getBannerHeight() {
        return this.size.getHeight();
    }

    public final int getBannerWidth() {
        return this.size.getWidth();
    }

    public String getLocation() {
        return this.location;
    }

    public boolean isCached() {
        if (Chartboost.isSdkStarted()) {
            return getApi().b();
        }
        return false;
    }

    public void show() {
        if (!Chartboost.isSdkStarted()) {
            postSessionNotStartedInMainThread(false);
            return;
        }
        getApi().a(this);
        getApi().b(this, this.callback);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Banner(Context context, String str, BannerSize bannerSize, BannerCallback bannerCallback, Mediation mediation2) {
        super(context);
        Intrinsics.f(context, "context");
        Intrinsics.f(str, "location");
        Intrinsics.f(bannerSize, "size");
        Intrinsics.f(bannerCallback, "callback");
        this.location = str;
        this.size = bannerSize;
        this.callback = bannerCallback;
        this.mediation = mediation2;
        this.api$delegate = LazyKt__LazyJVMKt.b(new a(this));
        Handler a2 = HandlerCompat.a(Looper.getMainLooper());
        Intrinsics.e(a2, "createAsync(Looper.getMainLooper())");
        this.mainThreadHandler = a2;
    }

    public void cache(String str) {
        if (!Chartboost.isSdkStarted()) {
            postSessionNotStartedInMainThread(true);
        } else if (str == null || str.length() == 0) {
            getApi().b("", CBError.CBImpressionError.INVALID_RESPONSE);
        } else {
            getApi().a(this, this.callback, str);
        }
    }
}
