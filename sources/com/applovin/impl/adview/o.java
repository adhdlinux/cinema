package com.applovin.impl.adview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.adview.AppLovinFullscreenAdViewObserver;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.adview.activity.b.a;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

public class o implements AppLovinInterstitialAdDialog {

    /* renamed from: a  reason: collision with root package name */
    protected final m f14097a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f14098b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile AppLovinAdLoadListener f14099c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile AppLovinAdDisplayListener f14100d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public volatile AppLovinAdVideoPlaybackListener f14101e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public volatile AppLovinAdClickListener f14102f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public volatile e f14103g;

    /* renamed from: h  reason: collision with root package name */
    private volatile e.b f14104h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f14105i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public AppLovinFullscreenAdViewObserver f14106j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public a f14107k;

    public o(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            this.f14097a = appLovinSdk.coreSdk;
            this.f14098b = new WeakReference<>(context);
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* access modifiers changed from: private */
    public void a(final int i2) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (o.this.f14099c != null) {
                    o.this.f14099c.failedToReceiveAd(i2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        Intent intent = new Intent(context, AppLovinFullscreenActivity.class);
        intent.putExtra("com.applovin.interstitial.sdk_key", this.f14097a.z());
        AppLovinFullscreenActivity.parentInterstitialWrapper = this;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(0, 0);
        } else {
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    private void a(e eVar, final Context context) {
        if (this.f14097a.af().b() == null) {
            this.f14097a.T().a(f.f15314m);
        }
        this.f14103g = eVar;
        this.f14104h = this.f14103g.p();
        final long max = Math.max(0, ((Long) this.f14097a.a(b.cl)).longValue());
        if (v.a()) {
            v A = this.f14097a.A();
            A.b("InterstitialAdDialogWrapper", "Presenting ad with delay of " + max);
        }
        a(eVar, context, new Runnable() {
            public void run() {
                new Handler(context.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        if (o.this.f14105i == null || o.this.f14106j == null) {
                            if (v.a()) {
                                o.this.f14097a.A().b("InterstitialAdDialogWrapper", "Presenting ad in a fullscreen activity");
                            }
                            AnonymousClass2 r02 = AnonymousClass2.this;
                            o.this.a(context);
                            return;
                        }
                        if (v.a()) {
                            v A = o.this.f14097a.A();
                            A.b("InterstitialAdDialogWrapper", "Presenting ad in a containerView(" + o.this.f14105i + ")");
                        }
                        o.this.f14105i.setBackgroundColor(-16777216);
                        e c2 = o.this.f14103g;
                        AppLovinAdClickListener d2 = o.this.f14102f;
                        AppLovinAdDisplayListener e2 = o.this.f14100d;
                        AppLovinAdVideoPlaybackListener f2 = o.this.f14101e;
                        o oVar = o.this;
                        a.a(c2, d2, e2, f2, oVar.f14097a, (Activity) oVar.f(), new a.C0008a() {
                            public void a(a aVar) {
                                a unused = o.this.f14107k = aVar;
                                o.this.f14106j.setPresenter(aVar);
                                aVar.a(o.this.f14105i);
                            }

                            public void a(String str, Throwable th) {
                                o.a(o.this.f14103g, o.this.f14100d, str, th, (AppLovinFullscreenActivity) null);
                            }
                        });
                    }
                }, max);
            }
        });
    }

    private void a(e eVar, Context context, final Runnable runnable) {
        if (!TextUtils.isEmpty(eVar.N()) || !eVar.ah() || h.a(context) || !(context instanceof Activity)) {
            runnable.run();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(context).setTitle(eVar.ai()).setMessage(eVar.aj()).setPositiveButton(eVar.ak(), (DialogInterface.OnClickListener) null).create();
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        create.show();
    }

    public static void a(e eVar, AppLovinAdDisplayListener appLovinAdDisplayListener, String str, Throwable th, AppLovinFullscreenActivity appLovinFullscreenActivity) {
        if (v.a()) {
            v.c("InterstitialAdDialogWrapper", str, th);
        }
        if (appLovinAdDisplayListener instanceof g) {
            j.a(appLovinAdDisplayListener, str);
        } else {
            j.b(appLovinAdDisplayListener, (AppLovinAd) eVar);
        }
        if (appLovinFullscreenActivity != null) {
            appLovinFullscreenActivity.dismiss();
        }
    }

    private void a(AppLovinAd appLovinAd) {
        if (this.f14100d != null) {
            this.f14100d.adHidden(appLovinAd);
        }
    }

    /* access modifiers changed from: private */
    public void b(final AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                if (o.this.f14099c != null) {
                    o.this.f14099c.adReceived(appLovinAd);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public Context f() {
        return this.f14098b.get();
    }

    public e a() {
        return this.f14103g;
    }

    /* access modifiers changed from: protected */
    public void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f14097a.u().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    public AppLovinAdVideoPlaybackListener b() {
        return this.f14101e;
    }

    public AppLovinAdDisplayListener c() {
        return this.f14100d;
    }

    public AppLovinAdClickListener d() {
        return this.f14102f;
    }

    public void e() {
        this.f14105i = null;
        this.f14106j = null;
        this.f14102f = null;
        this.f14099c = null;
        this.f14101e = null;
        this.f14100d = null;
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f14102f = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f14100d = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f14099c = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f14101e = appLovinAdVideoPlaybackListener;
    }

    public void show() {
        a((AppLovinAdLoadListener) new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                o.this.b(appLovinAd);
                o.this.showAndRender(appLovinAd);
            }

            public void failedToReceiveAd(int i2) {
                o.this.a(i2);
            }
        });
    }

    public void showAndRender(AppLovinAd appLovinAd) {
        Context f2 = f();
        if (f2 == null) {
            if (v.a()) {
                v.i("InterstitialAdDialogWrapper", "Failed to show interstitial: stale activity reference provided");
            }
            a(appLovinAd);
            return;
        }
        AppLovinAd maybeRetrieveNonDummyAd = Utils.maybeRetrieveNonDummyAd(appLovinAd, this.f14097a);
        if (maybeRetrieveNonDummyAd == null) {
            if (v.a()) {
                v.i("InterstitialAdDialogWrapper", "Failed to show ad: " + appLovinAd);
            }
            a(appLovinAd);
        } else if (((AppLovinAdImpl) maybeRetrieveNonDummyAd).hasShown() && ((Boolean) this.f14097a.a(b.bZ)).booleanValue()) {
            throw new IllegalStateException("Failed to display ad - ad can only be displayed once. Load the next ad.");
        } else if (maybeRetrieveNonDummyAd instanceof e) {
            a((e) maybeRetrieveNonDummyAd, f2);
        } else {
            if (v.a()) {
                v A = this.f14097a.A();
                A.e("InterstitialAdDialogWrapper", "Failed to show interstitial: unknown ad type provided: '" + maybeRetrieveNonDummyAd + "'");
            }
            a(maybeRetrieveNonDummyAd);
        }
    }

    public void showAndRender(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle) {
        if (viewGroup == null || lifecycle == null) {
            if (v.a()) {
                v.i("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad with null containerView or lifecycle");
            }
            a(appLovinAd);
            return;
        }
        this.f14105i = viewGroup;
        AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver = new AppLovinFullscreenAdViewObserver(lifecycle, this, this.f14097a);
        this.f14106j = appLovinFullscreenAdViewObserver;
        lifecycle.a(appLovinFullscreenAdViewObserver);
        showAndRender(appLovinAd);
    }

    public String toString() {
        return "AppLovinInterstitialAdDialog{}";
    }
}
