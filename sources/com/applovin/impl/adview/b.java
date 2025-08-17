package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.utils.k;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.ads.AudienceNetworkActivity;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class b implements AppLovinCommunicatorSubscriber {
    private volatile AppLovinAdClickListener A;
    private volatile g B = null;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f13995a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f13996b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public m f13997c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AppLovinAdServiceImpl f13998d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public v f13999e;

    /* renamed from: f  reason: collision with root package name */
    private AppLovinCommunicator f14000f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public AppLovinAdSize f14001g;

    /* renamed from: h  reason: collision with root package name */
    private String f14002h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public d f14003i;

    /* renamed from: j  reason: collision with root package name */
    private e f14004j;

    /* renamed from: k  reason: collision with root package name */
    private c f14005k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public d f14006l;

    /* renamed from: m  reason: collision with root package name */
    private Runnable f14007m;

    /* renamed from: n  reason: collision with root package name */
    private Runnable f14008n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public volatile e f14009o = null;

    /* renamed from: p  reason: collision with root package name */
    private volatile AppLovinAd f14010p = null;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public l f14011q = null;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public l f14012r = null;

    /* renamed from: s  reason: collision with root package name */
    private final AtomicReference<AppLovinAd> f14013s = new AtomicReference<>();
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public final AtomicBoolean f14014t = new AtomicBoolean();

    /* renamed from: u  reason: collision with root package name */
    private volatile boolean f14015u = false;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public volatile boolean f14016v = false;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public volatile boolean f14017w = false;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public volatile AppLovinAdLoadListener f14018x;

    /* renamed from: y  reason: collision with root package name */
    private volatile AppLovinAdDisplayListener f14019y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public volatile AppLovinAdViewEventListener f14020z;

    private class a implements Runnable {
        private a() {
        }

        public void run() {
            if (b.this.f14006l != null) {
                b.this.f14006l.setVisibility(8);
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.b$b  reason: collision with other inner class name */
    private class C0009b implements Runnable {
        private C0009b() {
        }

        public void run() {
            if (b.this.f14009o == null) {
                return;
            }
            if (b.this.f14006l != null) {
                b.this.x();
                if (v.a()) {
                    v c2 = b.this.f13999e;
                    c2.b("AppLovinAdView", "Rendering advertisement ad for #" + b.this.f14009o.getAdIdNumber() + "...");
                }
                b.b((View) b.this.f14006l, b.this.f14009o.getSize());
                b.this.f14006l.a(b.this.f14009o);
                if (b.this.f14009o.getSize() != AppLovinAdSize.INTERSTITIAL && !b.this.f14016v) {
                    b bVar = b.this;
                    d unused = bVar.f14003i = new d(bVar.f14009o, b.this.f13997c);
                    b.this.f14003i.a();
                    b.this.f14006l.setStatsManagerHelper(b.this.f14003i);
                    b.this.f14009o.setHasShown(true);
                }
                if (b.this.f14006l.getStatsManagerHelper() != null) {
                    b.this.f14006l.getStatsManagerHelper().a(b.this.f14009o.z() ? 0 : 1);
                    return;
                }
                return;
            }
            if (v.a()) {
                v.i("AppLovinAdView", "Unable to render advertisement for ad #" + b.this.f14009o.getAdIdNumber() + ". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
            }
            j.a(b.this.f14020z, (AppLovinAd) b.this.f14009o, (AppLovinAdView) null, AppLovinAdViewDisplayErrorCode.WEBVIEW_NOT_FOUND);
        }
    }

    static class c implements AppLovinAdLoadListener {

        /* renamed from: a  reason: collision with root package name */
        private final b f14039a;

        c(b bVar, m mVar) {
            if (bVar == null) {
                throw new IllegalArgumentException("No view specified");
            } else if (mVar != null) {
                this.f14039a = bVar;
            } else {
                throw new IllegalArgumentException("No sdk specified");
            }
        }

        private b a() {
            return this.f14039a;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            b a2 = a();
            if (a2 != null) {
                a2.b(appLovinAd);
            } else if (v.a()) {
                v.i("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
            }
        }

        public void failedToReceiveAd(int i2) {
            b a2 = a();
            if (a2 != null) {
                a2.a(i2);
            }
        }
    }

    private void a(AppLovinAdView appLovinAdView, m mVar, AppLovinAdSize appLovinAdSize, String str, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (mVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (appLovinAdSize != null) {
            this.f13997c = mVar;
            this.f13998d = mVar.u();
            this.f13999e = mVar.A();
            this.f14000f = AppLovinCommunicator.getInstance(context);
            this.f14001g = appLovinAdSize;
            this.f14002h = str;
            if (!(context instanceof AppLovinFullscreenActivity)) {
                context = context.getApplicationContext();
            }
            this.f13995a = context;
            this.f13996b = appLovinAdView;
            this.f14004j = new e(this, mVar);
            this.f14008n = new a();
            this.f14007m = new C0009b();
            this.f14005k = new c(this, mVar);
            a(appLovinAdSize);
        } else {
            throw new IllegalArgumentException("No ad size specified");
        }
    }

    private void a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    /* access modifiers changed from: private */
    public static void b(View view, AppLovinAdSize appLovinAdSize) {
        if (view != null) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            String label = appLovinAdSize.getLabel();
            AppLovinAdSize appLovinAdSize2 = AppLovinAdSize.INTERSTITIAL;
            int i2 = -1;
            int applyDimension = label.equals(appLovinAdSize2.getLabel()) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getWidth(), displayMetrics);
            if (!appLovinAdSize.getLabel().equals(appLovinAdSize2.getLabel())) {
                i2 = appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, (float) appLovinAdSize.getHeight(), displayMetrics);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            }
            layoutParams.width = applyDimension;
            layoutParams.height = i2;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(10);
                layoutParams2.addRule(9);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    private void t() {
        v vVar;
        if (v.a() && (vVar = this.f13999e) != null) {
            vVar.b("AppLovinAdView", "Destroying...");
        }
        d dVar = this.f14006l;
        if (dVar != null) {
            ViewParent parent = dVar.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f14006l);
            }
            this.f14006l.removeAllViews();
            this.f14006l.loadUrl("about:blank");
            this.f14006l.onPause();
            this.f14006l.destroyDrawingCache();
            this.f14006l.destroy();
            this.f14006l = null;
        }
        this.f14018x = null;
        this.f14019y = null;
        this.A = null;
        this.f14020z = null;
        this.f14016v = true;
    }

    private void u() {
        a((Runnable) new Runnable() {
            public void run() {
                if (b.this.f14011q != null) {
                    if (v.a()) {
                        v c2 = b.this.f13999e;
                        c2.b("AppLovinAdView", "Detaching expanded ad: " + b.this.f14011q.a());
                    }
                    b bVar = b.this;
                    l unused = bVar.f14012r = bVar.f14011q;
                    l unused2 = b.this.f14011q = null;
                    b bVar2 = b.this;
                    bVar2.a(bVar2.f14001g);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void v() {
        a((Runnable) new Runnable() {
            public void run() {
                com.applovin.impl.sdk.ad.a aVar;
                if (b.this.f14012r != null || b.this.f14011q != null) {
                    if (b.this.f14012r != null) {
                        aVar = b.this.f14012r.a();
                        b.this.f14012r.dismiss();
                        l unused = b.this.f14012r = null;
                    } else {
                        aVar = b.this.f14011q.a();
                        b.this.f14011q.dismiss();
                        l unused2 = b.this.f14011q = null;
                    }
                    j.b(b.this.f14020z, (AppLovinAd) aVar, (AppLovinAdView) b.this.f13996b);
                }
            }
        });
    }

    private void w() {
        d dVar = this.f14003i;
        if (dVar != null) {
            dVar.c();
            this.f14003i = null;
        }
    }

    /* access modifiers changed from: private */
    public void x() {
        if (v.a()) {
            e eVar = this.f14009o;
            k kVar = new k();
            kVar.a().a(eVar).a(r());
            if (!Utils.isBML(eVar.getSize())) {
                kVar.a().a("Fullscreen Ad Properties").b(eVar);
            }
            kVar.a(this.f13997c);
            kVar.a();
            this.f13999e.b("AppLovinAdView", kVar.toString());
        }
    }

    public void a() {
        if (this.f13997c != null && this.f14005k != null && this.f13995a != null && this.f14015u) {
            this.f13998d.loadNextAd(this.f14002h, this.f14001g, this.f14005k);
        } else if (v.a()) {
            v.g("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(final int i2) {
        if (!this.f14016v) {
            a(this.f14008n);
        }
        a((Runnable) new Runnable() {
            public void run() {
                try {
                    if (b.this.f14018x != null) {
                        b.this.f14018x.failedToReceiveAd(i2);
                    }
                } catch (Throwable th) {
                    if (v.a()) {
                        v.c("AppLovinAdView", "Exception while running app load  callback", th);
                    }
                }
            }
        });
    }

    public void a(final PointF pointF) {
        a((Runnable) new Runnable() {
            public void run() {
                if (b.this.f14011q == null && (b.this.f14009o instanceof com.applovin.impl.sdk.ad.a) && b.this.f14006l != null) {
                    com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) b.this.f14009o;
                    Activity retrieveParentActivity = b.this.f13995a instanceof Activity ? (Activity) b.this.f13995a : Utils.retrieveParentActivity(b.this.f14006l, b.this.f13997c);
                    if (retrieveParentActivity != null) {
                        if (b.this.f13996b != null) {
                            b.this.f13996b.removeView(b.this.f14006l);
                        }
                        l unused = b.this.f14011q = new l(aVar, b.this.f14006l, retrieveParentActivity, b.this.f13997c);
                        b.this.f14011q.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            public void onDismiss(DialogInterface dialogInterface) {
                                b.this.k();
                            }
                        });
                        b.this.f14011q.show();
                        j.a(b.this.f14020z, (AppLovinAd) b.this.f14009o, (AppLovinAdView) b.this.f13996b);
                        if (b.this.f14003i != null) {
                            b.this.f14003i.d();
                        }
                        if (b.this.f14009o.isOpenMeasurementEnabled()) {
                            b.this.f14009o.o().a((View) b.this.f14011q.b());
                            return;
                        }
                        return;
                    }
                    if (v.a()) {
                        v.i("AppLovinAdView", "Unable to expand ad. No Activity found.");
                    }
                    Uri j2 = aVar.j();
                    if (j2 != null) {
                        AppLovinAdServiceImpl l2 = b.this.f13998d;
                        AppLovinAdView r2 = b.this.r();
                        b bVar = b.this;
                        l2.trackAndLaunchClick(aVar, r2, bVar, j2, pointF, bVar.f14017w);
                        if (b.this.f14003i != null) {
                            b.this.f14003i.b();
                        }
                    }
                    b.this.f14006l.a("javascript:al_onFailedExpand();");
                }
            }
        });
    }

    public void a(final WebView webView) {
        a((Runnable) new Runnable() {
            public void run() {
                webView.setVisibility(0);
            }
        });
        try {
            if (this.f14009o != this.f14010p) {
                this.f14010p = this.f14009o;
                if (this.f14019y != null) {
                    j.a(this.f14019y, (AppLovinAd) this.f14009o);
                    this.f14006l.a("javascript:al_onAdViewRendered();");
                }
                if ((this.f14009o instanceof com.applovin.impl.sdk.ad.a) && this.f14009o.isOpenMeasurementEnabled()) {
                    this.f13997c.S().a((com.applovin.impl.sdk.e.a) new z(this.f13997c, new Runnable() {
                        public void run() {
                            b.this.f14009o.o().b(webView);
                            b.this.f14009o.o().a((View) webView);
                            b.this.f14009o.o().c();
                            b.this.f14009o.o().d();
                        }
                    }), o.a.MAIN, 500);
                }
            }
        } catch (Throwable th) {
            if (v.a()) {
                v.c("AppLovinAdView", "Exception while notifying ad display listener", th);
            }
        }
    }

    public void a(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        } else if (context != null) {
            if (appLovinAdSize == null && (appLovinAdSize = com.applovin.impl.sdk.utils.b.a(attributeSet)) == null) {
                appLovinAdSize = AppLovinAdSize.BANNER;
            }
            AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
            if (appLovinSdk == null) {
                appLovinSdk = AppLovinSdk.getInstance(context);
            }
            if (appLovinSdk != null) {
                a(appLovinAdView, appLovinSdk.coreSdk, appLovinAdSize2, str, context);
                if (com.applovin.impl.sdk.utils.b.b(attributeSet)) {
                    a();
                }
            }
        } else if (v.a()) {
            v.i("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
        }
    }

    public void a(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.f14020z = appLovinAdViewEventListener;
    }

    public void a(g gVar) {
        this.B = gVar;
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar, AppLovinAdView appLovinAdView, Uri uri, PointF pointF) {
        if (appLovinAdView != null) {
            this.f13998d.trackAndLaunchClick(eVar, appLovinAdView, this, uri, pointF, this.f14017w);
        } else if (v.a()) {
            this.f13999e.e("AppLovinAdView", "Unable to process ad click - AppLovinAdView destroyed prematurely");
        }
        j.a(this.A, (AppLovinAd) eVar);
    }

    public void a(d dVar) {
        d dVar2 = this.f14006l;
        if (dVar2 != null) {
            dVar2.setStatsManagerHelper(dVar);
        }
    }

    public void a(AppLovinAd appLovinAd) {
        a(appLovinAd, (String) null);
    }

    public void a(AppLovinAd appLovinAd, String str) {
        if (appLovinAd != null) {
            Utils.validateAdSdkKey(appLovinAd, this.f13997c);
            if (this.f14015u) {
                e eVar = (e) Utils.maybeRetrieveNonDummyAd(appLovinAd, this.f13997c);
                if (eVar != null && eVar != this.f14009o) {
                    if (v.a()) {
                        v vVar = this.f13999e;
                        vVar.b("AppLovinAdView", "Rendering ad #" + eVar.getAdIdNumber() + " (" + eVar.getSize() + ")");
                    }
                    j.b(this.f14019y, (AppLovinAd) this.f14009o);
                    if (eVar.getSize() != AppLovinAdSize.INTERSTITIAL) {
                        w();
                    }
                    if (this.f14009o != null && this.f14009o.isOpenMeasurementEnabled()) {
                        this.f14009o.o().e();
                    }
                    this.f14013s.set((Object) null);
                    this.f14010p = null;
                    this.f14009o = eVar;
                    if (!this.f14016v && Utils.isBML(this.f14001g)) {
                        this.f13997c.u().trackImpression(eVar);
                    }
                    if (this.f14011q != null) {
                        u();
                    }
                    a(this.f14007m);
                } else if (eVar != null) {
                    if (v.a()) {
                        v vVar2 = this.f13999e;
                        vVar2.d("AppLovinAdView", "Ad #" + eVar.getAdIdNumber() + " is already showing, ignoring");
                    }
                    if (((Boolean) this.f13997c.a(com.applovin.impl.sdk.c.b.bZ)).booleanValue()) {
                        throw new IllegalStateException("Failed to display ad - ad can only be displayed once. Load the next ad.");
                    }
                } else if (v.a()) {
                    this.f13999e.d("AppLovinAdView", "Unable to render ad. Ad is null. Internal inconsistency error.");
                }
            } else if (v.a()) {
                v.g("AppLovinAdView", "Unable to render ad: AppLovinAdView is not initialized.");
            }
        } else {
            throw new IllegalArgumentException("No ad specified");
        }
    }

    public void a(AppLovinAdClickListener appLovinAdClickListener) {
        this.A = appLovinAdClickListener;
    }

    public void a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f14019y = appLovinAdDisplayListener;
    }

    public void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f14018x = appLovinAdLoadListener;
    }

    /* access modifiers changed from: protected */
    public void a(AppLovinAdSize appLovinAdSize) {
        try {
            d dVar = new d(this.f14004j, this.f13997c, this.f13995a);
            this.f14006l = dVar;
            dVar.setBackgroundColor(0);
            this.f14006l.setWillNotCacheDrawing(false);
            this.f13996b.setBackgroundColor(0);
            this.f13996b.addView(this.f14006l);
            b((View) this.f14006l, appLovinAdSize);
            if (!this.f14015u) {
                a(this.f14008n);
            }
            a((Runnable) new Runnable() {
                public void run() {
                    b.this.f14006l.loadDataWithBaseURL("/", "<html></html>", AudienceNetworkActivity.WEBVIEW_MIME_TYPE, (String) null, "");
                }
            });
            this.f14015u = true;
        } catch (Throwable th) {
            if (v.a()) {
                v.c("AppLovinAdView", "Failed to initialize AdWebView", th);
            }
            this.f14014t.set(true);
        }
    }

    public AppLovinAdSize b() {
        return this.f14001g;
    }

    /* access modifiers changed from: package-private */
    public void b(final AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            if (!this.f14016v) {
                a(appLovinAd);
            } else {
                this.f14013s.set(appLovinAd);
                if (v.a()) {
                    this.f13999e.b("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
                }
            }
            a((Runnable) new Runnable() {
                public void run() {
                    if (b.this.f14014t.compareAndSet(true, false)) {
                        b bVar = b.this;
                        bVar.a(bVar.f14001g);
                    }
                    try {
                        if (b.this.f14018x != null) {
                            b.this.f14018x.adReceived(appLovinAd);
                        }
                    } catch (Throwable th) {
                        if (v.a()) {
                            v.i("AppLovinAdView", "Exception while running ad load callback: " + th.getMessage());
                        }
                    }
                }
            });
            return;
        }
        if (v.a()) {
            this.f13999e.e("AppLovinAdView", "No provided when to the view controller");
        }
        a(-1);
    }

    public String c() {
        return this.f14002h;
    }

    public void d() {
        if (this.f14015u && !this.f14016v) {
            this.f14016v = true;
        }
    }

    public void e() {
        if (this.f14015u) {
            AppLovinAd andSet = this.f14013s.getAndSet((Object) null);
            if (andSet != null) {
                a(andSet);
            }
            this.f14016v = false;
        }
    }

    public void f() {
        if (!(this.f14006l == null || this.f14011q == null)) {
            k();
        }
        t();
    }

    public AppLovinAdViewEventListener g() {
        return this.f14020z;
    }

    public String getCommunicatorId() {
        return b.class.getSimpleName();
    }

    public g h() {
        return this.B;
    }

    public void i() {
        if (com.applovin.impl.sdk.utils.b.a((View) this.f14006l)) {
            this.f13997c.T().a(f.f15314m);
        }
    }

    public void j() {
        if (this.f14015u) {
            j.b(this.f14019y, (AppLovinAd) this.f14009o);
            if (this.f14009o != null && this.f14009o.isOpenMeasurementEnabled() && Utils.isBML(this.f14009o.getSize())) {
                this.f14009o.o().e();
            }
            if (this.f14006l != null && this.f14011q != null) {
                if (v.a()) {
                    this.f13999e.b("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
                }
                u();
            } else if (v.a()) {
                this.f13999e.b("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
            }
        }
    }

    public void k() {
        a((Runnable) new Runnable() {
            public void run() {
                b.this.v();
                if (b.this.f13996b != null && b.this.f14006l != null && b.this.f14006l.getParent() == null) {
                    b.this.f13996b.addView(b.this.f14006l);
                    b.b((View) b.this.f14006l, b.this.f14009o.getSize());
                    if (b.this.f14009o.isOpenMeasurementEnabled()) {
                        b.this.f14009o.o().a((View) b.this.f14006l);
                    }
                }
            }
        });
    }

    public void l() {
        if (this.f14011q == null && this.f14012r == null) {
            if (v.a()) {
                v vVar = this.f13999e;
                vVar.b("AppLovinAdView", "Ad: " + this.f14009o + " closed.");
            }
            a(this.f14008n);
            j.b(this.f14019y, (AppLovinAd) this.f14009o);
            this.f14009o = null;
            return;
        }
        k();
    }

    public void m() {
        this.f14017w = true;
    }

    public void n() {
        this.f14017w = false;
    }

    public void o() {
        if ((this.f13995a instanceof k) && this.f14009o != null) {
            if (this.f14009o.F() == e.a.DISMISS) {
                ((k) this.f13995a).dismiss();
            }
        }
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("crash_applovin_ad_webview".equals(appLovinCommunicatorMessage.getTopic())) {
            a((Runnable) new Runnable() {
                public void run() {
                    b.this.s().loadUrl("chrome://crash");
                }
            });
        }
    }

    public e p() {
        return this.f14009o;
    }

    public m q() {
        return this.f13997c;
    }

    public AppLovinAdView r() {
        return (AppLovinAdView) this.f13996b;
    }

    public d s() {
        return this.f14006l;
    }
}
