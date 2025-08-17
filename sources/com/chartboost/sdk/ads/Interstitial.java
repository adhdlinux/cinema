package com.chartboost.sdk.ads;

import a0.b;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.os.HandlerCompat;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.callbacks.InterstitialCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.CacheEvent;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.events.ShowEvent;
import com.chartboost.sdk.impl.i;
import com.chartboost.sdk.impl.t7;
import com.chartboost.sdk.internal.Model.CBError;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class Interstitial implements Ad {
    private final Lazy api$delegate;
    private final InterstitialCallback callback;
    private final String location;
    private final Handler mainThreadHandler;
    /* access modifiers changed from: private */
    public final Mediation mediation;

    public static final class a extends Lambda implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Interstitial f17165b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Interstitial interstitial) {
            super(0);
            this.f17165b = interstitial;
        }

        /* renamed from: a */
        public final t7 invoke() {
            return i.b(this.f17165b.mediation);
        }
    }

    public Interstitial(String str, InterstitialCallback interstitialCallback, Mediation mediation2) {
        Intrinsics.f(str, "location");
        Intrinsics.f(interstitialCallback, "callback");
        this.location = str;
        this.callback = interstitialCallback;
        this.mediation = mediation2;
        this.api$delegate = LazyKt__LazyJVMKt.b(new a(this));
        Handler a2 = HandlerCompat.a(Looper.getMainLooper());
        Intrinsics.e(a2, "createAsync(Looper.getMainLooper())");
        this.mainThreadHandler = a2;
    }

    private final t7 getApi() {
        return (t7) this.api$delegate.getValue();
    }

    private final void postSessionNotStartedInMainThread(boolean z2) {
        try {
            this.mainThreadHandler.post(new b(z2, this));
        } catch (Exception e2) {
            Log.e("Chartboost", "Interstitial ad cannot post session not started callback " + e2);
        }
    }

    /* access modifiers changed from: private */
    public static final void postSessionNotStartedInMainThread$lambda$0(boolean z2, Interstitial interstitial) {
        Intrinsics.f(interstitial, "this$0");
        if (z2) {
            interstitial.callback.onAdLoaded(new CacheEvent((String) null, interstitial), new CacheError(CacheError.Code.SESSION_NOT_STARTED, (Exception) null, 2, (DefaultConstructorMarker) null));
        } else {
            interstitial.callback.onAdShown(new ShowEvent((String) null, interstitial), new ShowError(ShowError.Code.SESSION_NOT_STARTED, (Exception) null, 2, (DefaultConstructorMarker) null));
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
        } else {
            getApi().b(this, this.callback);
        }
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Interstitial(String str, InterstitialCallback interstitialCallback, Mediation mediation2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, interstitialCallback, (i2 & 4) != 0 ? null : mediation2);
    }
}
