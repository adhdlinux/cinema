package com.startapp.sdk.ads.banner.bannerstandard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.iab.omid.library.startio.adsession.FriendlyObstructionPurpose;
import com.startapp.ha;
import com.startapp.hc;
import com.startapp.j9;
import com.startapp.k9;
import com.startapp.l9;
import com.startapp.lb;
import com.startapp.m9;
import com.startapp.me;
import com.startapp.n3;
import com.startapp.n9;
import com.startapp.o6;
import com.startapp.o9;
import com.startapp.p;
import com.startapp.p3;
import com.startapp.pb;
import com.startapp.r3;
import com.startapp.sdk.ads.banner.BannerBase;
import com.startapp.sdk.ads.banner.BannerInterface;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.ads.banner.bannerstandard.CloseableLayout;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.mraid.bridge.MraidState;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.td;
import com.startapp.y8;
import com.startapp.z6;
import com.startapp.z8;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class BannerStandard extends BannerBase implements AdEventListener, BannerInterface {

    /* renamed from: r  reason: collision with root package name */
    public static final String f35917r = "BannerStandard";
    public BannerOptions A;
    public AdPreferences B;
    public final r3 C;
    public BannerListener D;
    public boolean E;
    public AdInformationObject F;
    public RelativeLayout G;
    public RelativeLayout H;
    public CloseableLayout I;
    public z6 J;
    public me K;
    public pb L;
    public pb M;
    public MraidBannerController N;
    public MraidBannerController O;
    public ViewGroup P;
    public final z6.a Q;
    public final Runnable R;
    public final Runnable S;

    /* renamed from: s  reason: collision with root package name */
    public BannerStandardAd f35918s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f35919t;
    public WebView twoPartWebView;

    /* renamed from: u  reason: collision with root package name */
    public boolean f35920u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f35921v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f35922w;
    public WebView webView;

    /* renamed from: x  reason: collision with root package name */
    public boolean f35923x;

    /* renamed from: y  reason: collision with root package name */
    public final Handler f35924y;

    /* renamed from: z  reason: collision with root package name */
    public long f35925z;

    public class MraidBannerController extends j9 {
        private WebView activeWebView;
        /* access modifiers changed from: private */
        public MraidState mraidState = MraidState.LOADING;
        private boolean mraidVisibility = false;
        /* access modifiers changed from: private */
        public m9 nativeFeatureManager;
        private n9 orientationProperties;
        private o9 resizeProperties;

        public class BannerWebViewClient extends l9 {
            public BannerWebViewClient(k9 k9Var) {
                super(k9Var);
            }

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (MraidBannerController.this.mraidState == MraidState.LOADING) {
                    lb.a(webView, true, "mraid.setPlacementType", "inline");
                    p.a(BannerStandard.this.getContext(), webView, MraidBannerController.this.nativeFeatureManager);
                    MraidBannerController.this.updateDisplayMetrics(webView);
                    MraidState unused = MraidBannerController.this.mraidState = MraidState.DEFAULT;
                    p.a(MraidBannerController.this.mraidState, webView);
                    lb.a(webView, true, "mraid.fireReadyEvent", new Object[0]);
                }
                BannerStandard bannerStandard = BannerStandard.this;
                bannerStandard.p();
                if (MetaData.f36379h.P()) {
                    try {
                        bannerStandard.b(webView);
                    } catch (Throwable th) {
                        y8.a(bannerStandard.getContext(), th);
                    }
                }
            }
        }

        public MraidBannerController(WebView webView, j9.a aVar) {
            super(aVar);
            this.activeWebView = webView;
            webView.setWebViewClient(new BannerWebViewClient(this));
            this.nativeFeatureManager = new m9(BannerStandard.this.getContext());
            this.orientationProperties = new n9();
        }

        /* access modifiers changed from: private */
        public void fireViewableChangeEvent(boolean z2) {
            if (this.mraidVisibility != z2) {
                this.mraidVisibility = z2;
                lb.a(this.activeWebView, true, "mraid.fireViewableChangeEvent", Boolean.valueOf(z2));
            }
        }

        /* access modifiers changed from: private */
        public void updateDisplayMetrics(WebView webView) {
            Context context = BannerStandard.this.getContext();
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                int i2 = displayMetrics.widthPixels;
                int i3 = displayMetrics.heightPixels;
                int[] iArr = new int[2];
                BannerStandard.this.getLocationOnScreen(iArr);
                int i4 = iArr[0];
                int i5 = iArr[1];
                p.b(context, i2, i3, webView);
                Point point = BannerStandard.this.C.f35750a;
                p.b(context, i4, i5, point.x, point.y, webView);
                p.a(context, i2, i3, webView);
                Point point2 = BannerStandard.this.C.f35750a;
                p.a(context, i4, i5, point2.x, point2.y, webView);
            } catch (Throwable th) {
                y8.a(context, th);
            }
        }

        public void close() {
            BannerStandard.a(BannerStandard.this);
        }

        public void expand(String str) {
            boolean z2;
            BannerStandard bannerStandard = BannerStandard.this;
            String str2 = BannerStandard.f35917r;
            bannerStandard.b();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (str == null || TextUtils.isEmpty(str)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                bannerStandard.f35920u = false;
                if (bannerStandard.twoPartWebView == null) {
                    bannerStandard.twoPartWebView = ComponentLocator.a(bannerStandard.getContext()).u().b();
                }
                bannerStandard.O = new MraidBannerController(bannerStandard.twoPartWebView, new j9.a() {
                    public boolean onClickEvent(String str) {
                        if (!BannerStandard.this.f35920u) {
                            y8 y8Var = new y8(z8.f36996c);
                            y8Var.f36954d = "fake_click";
                            y8Var.f36957g = o6.a(str, (String) null);
                            y8Var.f36955e = "jsTag=" + BannerStandard.this.f35921v;
                            y8Var.a(BannerStandard.this.getContext());
                        }
                        BannerStandard bannerStandard = BannerStandard.this;
                        if ((!bannerStandard.f35921v || bannerStandard.f35920u) && str != null) {
                            return BannerStandard.a(bannerStandard, str);
                        }
                        return false;
                    }
                });
                bannerStandard.M = new pb(bannerStandard.twoPartWebView, BannerMetaData.f35889b.a(), new pb.b() {
                    public boolean onUpdate(boolean z2) {
                        BannerStandard.this.N.fireViewableChangeEvent(z2);
                        BannerStandard.this.O.fireViewableChangeEvent(z2);
                        return BannerStandard.this.f35918s.r();
                    }
                });
                bannerStandard.twoPartWebView.setId(159868226);
                bannerStandard.a(bannerStandard.twoPartWebView);
                bannerStandard.twoPartWebView.loadUrl(str);
            }
            if (bannerStandard.N.getState() == MraidState.DEFAULT) {
                if (z2) {
                    bannerStandard.I.addView(bannerStandard.twoPartWebView, layoutParams);
                } else {
                    RelativeLayout relativeLayout = bannerStandard.H;
                    if (relativeLayout != null) {
                        relativeLayout.removeView(bannerStandard.webView);
                        bannerStandard.H.setVisibility(4);
                    }
                    bannerStandard.I.addView(bannerStandard.webView, layoutParams);
                }
                if (bannerStandard.P == null) {
                    bannerStandard.P = bannerStandard.s();
                }
                bannerStandard.P.addView(bannerStandard.I, new FrameLayout.LayoutParams(-1, -1));
            } else if (bannerStandard.N.getState() == MraidState.RESIZED && z2) {
                bannerStandard.I.removeView(bannerStandard.webView);
                RelativeLayout relativeLayout2 = bannerStandard.H;
                if (relativeLayout2 != null) {
                    relativeLayout2.addView(bannerStandard.webView, layoutParams);
                    bannerStandard.H.setVisibility(4);
                }
                bannerStandard.I.addView(bannerStandard.twoPartWebView, layoutParams);
            }
            bannerStandard.I.setLayoutParams(layoutParams);
            bannerStandard.N.setState(MraidState.EXPANDED);
        }

        public o9 getResizeProperties() {
            return this.resizeProperties;
        }

        public MraidState getState() {
            return this.mraidState;
        }

        public boolean isFeatureSupported(String str) {
            return this.nativeFeatureManager.f34913b.contains(str);
        }

        public void resize() {
            BannerStandard bannerStandard = BannerStandard.this;
            o9 resizeProperties2 = bannerStandard.N.getResizeProperties();
            if (resizeProperties2 == null) {
                p.a(bannerStandard.webView, "requires: setResizeProperties first", "resize");
                return;
            }
            bannerStandard.b();
            if (bannerStandard.N.getState() != MraidState.LOADING && bannerStandard.N.getState() != MraidState.HIDDEN) {
                if (bannerStandard.N.getState() == MraidState.EXPANDED) {
                    p.a(bannerStandard.webView, "Not allowed to resize from an already expanded ad", "resize");
                    return;
                }
                int i2 = resizeProperties2.f35557a;
                int i3 = resizeProperties2.f35558b;
                int i4 = resizeProperties2.f35559c;
                int i5 = resizeProperties2.f35560d;
                int[] iArr = new int[2];
                bannerStandard.webView.getLocationOnScreen(iArr);
                Context context = bannerStandard.getContext();
                int b2 = p.b(context, iArr[0]) + i4;
                int b3 = p.b(context, iArr[1]) + i5;
                Rect rect = new Rect(b2, b3, i2 + b2, i3 + b3);
                ViewGroup s2 = bannerStandard.s();
                int b4 = p.b(context, s2.getWidth());
                int b5 = p.b(context, s2.getHeight());
                int[] iArr2 = new int[2];
                s2.getLocationOnScreen(iArr2);
                int b6 = p.b(context, iArr2[0]);
                int b7 = p.b(context, iArr2[1]);
                if (!resizeProperties2.f35562f) {
                    if (rect.width() > b4 || rect.height() > b5) {
                        p.a(bannerStandard.webView, "Not enough room for the ad", "resize");
                        return;
                    }
                    rect.offsetTo(Math.max(b6, Math.min(rect.left, (b6 + b4) - rect.width())), Math.max(b7, Math.min(rect.top, (b7 + b5) - rect.height())));
                }
                Rect rect2 = new Rect();
                try {
                    CloseableLayout.ClosePosition a2 = CloseableLayout.ClosePosition.a(resizeProperties2.f35561e, CloseableLayout.ClosePosition.TOP_RIGHT);
                    int i6 = bannerStandard.I.f35931f;
                    Gravity.apply(a2.a(), i6, i6, rect, rect2);
                    if (!new Rect(b6, b7, b4 + b6, b5 + b7).contains(rect2)) {
                        p.a(bannerStandard.webView, "The close region to appear within the max allowed size", "resize");
                    } else if (!rect.contains(rect2)) {
                        p.a(bannerStandard.webView, "The close region to appear within the max allowed size", "resize");
                    } else {
                        bannerStandard.I.setCloseVisible(false);
                        bannerStandard.I.setClosePosition(a2);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
                        layoutParams.leftMargin = rect.left - b6;
                        layoutParams.topMargin = rect.top - b7;
                        if (bannerStandard.N.getState() == MraidState.DEFAULT) {
                            RelativeLayout relativeLayout = bannerStandard.H;
                            if (relativeLayout != null) {
                                relativeLayout.removeView(bannerStandard.webView);
                                bannerStandard.H.setVisibility(4);
                            }
                            bannerStandard.I.addView(bannerStandard.webView, new FrameLayout.LayoutParams(-1, -1));
                            if (bannerStandard.P == null) {
                                bannerStandard.P = bannerStandard.s();
                            }
                            bannerStandard.P.addView(bannerStandard.I, layoutParams);
                        } else if (bannerStandard.N.getState() == MraidState.RESIZED) {
                            bannerStandard.I.setLayoutParams(layoutParams);
                        }
                        bannerStandard.I.setClosePosition(a2);
                        bannerStandard.N.setState(MraidState.RESIZED);
                    }
                } catch (Exception e2) {
                    p.a(bannerStandard.webView, e2.getMessage(), "resize");
                }
            }
        }

        public void setExpandProperties(Map<String, String> map) {
            String str = map.get("useCustomClose");
            if (str != null) {
                BannerStandard.a(BannerStandard.this, Boolean.parseBoolean(str));
            }
        }

        public void setOrientationProperties(Map<String, String> map) {
            boolean parseBoolean = Boolean.parseBoolean(map.get("allowOrientationChange"));
            String str = map.get("forceOrientation");
            n9 n9Var = this.orientationProperties;
            if (n9Var.f34964b != parseBoolean || n9Var.f34965c != n9.a(str)) {
                n9 n9Var2 = this.orientationProperties;
                n9Var2.f34964b = parseBoolean;
                n9Var2.f34965c = n9.a(str);
                applyOrientationProperties((Activity) BannerStandard.this.getContext(), this.orientationProperties);
            }
        }

        public void setResizeProperties(Map<String, String> map) {
            boolean z2;
            try {
                int parseInt = Integer.parseInt(map.get("width"));
                int parseInt2 = Integer.parseInt(map.get("height"));
                int parseInt3 = Integer.parseInt(map.get("offsetX"));
                int parseInt4 = Integer.parseInt(map.get("offsetY"));
                String str = map.get("allowOffscreen");
                String str2 = map.get("customClosePosition");
                if (str != null) {
                    if (!Boolean.parseBoolean(str)) {
                        z2 = false;
                        this.resizeProperties = new o9(parseInt, parseInt2, parseInt3, parseInt4, str2, z2);
                    }
                }
                z2 = true;
                this.resizeProperties = new o9(parseInt, parseInt2, parseInt3, parseInt4, str2, z2);
            } catch (Exception unused) {
                p.a(this.activeWebView, "wrong format", "setResizeProperties");
            }
        }

        public void setState(MraidState mraidState2) {
            this.mraidState = mraidState2;
            p.a(mraidState2, this.activeWebView);
        }

        public void useCustomClose(String str) {
            BannerStandard.a(BannerStandard.this, Boolean.parseBoolean(str));
        }
    }

    public BannerStandard(Activity activity) {
        this((Context) activity);
    }

    public final void a(WebView webView2) {
        webView2.setBackgroundColor(0);
        webView2.setHorizontalScrollBarEnabled(false);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setVerticalScrollBarEnabled(false);
        webView2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BannerStandard.this.f35920u = true;
                if (motionEvent.getAction() == 2) {
                    return true;
                }
                return false;
            }
        });
        webView2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                return true;
            }
        });
        webView2.setLongClickable(false);
    }

    public final void b(Point point, int i2) {
        if (point.x <= 0) {
            point.x = i2;
        }
    }

    public int c() {
        return Math.max(this.A.i() - ((int) this.f35925z), 0);
    }

    public int d() {
        return this.f35877i;
    }

    public String e() {
        return "StartApp Banner";
    }

    public int f() {
        return this.A.i();
    }

    public View g() {
        RelativeLayout relativeLayout = this.H;
        return relativeLayout != null ? relativeLayout : this;
    }

    public String getBidToken() {
        BannerStandardAd bannerStandardAd = this.f35918s;
        if (bannerStandardAd != null) {
            return lb.a(bannerStandardAd.j(), "bidToken", "bidToken");
        }
        return null;
    }

    public int getHeightInDp() {
        return 50;
    }

    public int getWidthInDp() {
        return 300;
    }

    public void hideBanner() {
        this.f35923x = false;
        o6.a(this.S);
    }

    public void i() {
        int i2;
        try {
            Context context = getContext();
            CloseableLayout closeableLayout = new CloseableLayout(context);
            this.I = closeableLayout;
            closeableLayout.setOnCloseListener(new CloseableLayout.a() {
                public void onClose() {
                    BannerStandard.a(BannerStandard.this);
                }
            });
            WebView b2 = ComponentLocator.a(context).u().b();
            this.webView = b2;
            this.N = new MraidBannerController(b2, new j9.a() {
                public boolean onClickEvent(String str) {
                    if (!BannerStandard.this.f35920u) {
                        y8 y8Var = new y8(z8.f36996c);
                        y8Var.f36954d = "fake_click";
                        y8Var.f36957g = o6.a(str, (String) null);
                        y8Var.f36955e = "jsTag=" + BannerStandard.this.f35921v;
                        y8Var.a(BannerStandard.this.getContext());
                    }
                    BannerStandard bannerStandard = BannerStandard.this;
                    if ((!bannerStandard.f35921v || bannerStandard.f35920u) && str != null) {
                        return BannerStandard.a(bannerStandard, str);
                    }
                    return false;
                }
            });
            this.A = new BannerOptions();
            if (this.f35918s == null) {
                BannerStandardAd bannerStandardAd = this.f35918s;
                if (bannerStandardAd == null) {
                    i2 = 0;
                } else {
                    i2 = bannerStandardAd.v();
                }
                this.f35918s = new BannerStandardAd(context, i2);
            }
            if (this.B == null) {
                this.B = new AdPreferences();
            }
            if (getId() == -1) {
                setId(this.f35877i);
            }
            this.webView.setId(159868225);
            a(this.webView);
            this.A = BannerMetaData.f35889b.b();
            a(this.B);
            setMinimumWidth(p.a(getContext(), this.C.f35750a.x));
            setMinimumHeight(p.a(getContext(), this.C.f35750a.y));
            WebView webView2 = this.webView;
            Context context2 = getContext();
            AnonymousClass8 r4 = new Runnable() {
                public void run() {
                }
            };
            TrackingParams trackingParams = new TrackingParams(this.f35878j);
            boolean a2 = this.f35918s.a(0);
            td tdVar = new td(context2, r4, trackingParams);
            tdVar.f36583b = a2;
            webView2.addJavascriptInterface(tdVar, "startappwall");
            this.H = new RelativeLayout(getContext());
            a((View) this.webView);
            o6.a(this.S);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            addView(this.H, layoutParams);
            if (this.f35922w) {
                getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        ViewTreeObserver viewTreeObserver = BannerStandard.this.getViewTreeObserver();
                        int i2 = hc.f34643a;
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                        BannerStandard bannerStandard = BannerStandard.this;
                        if (!bannerStandard.f35919t) {
                            bannerStandard.k();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            y8.a(getContext(), th);
            hideBanner();
            a("BannerStandard.init - webview failed");
        }
    }

    public void l() {
        if (v()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    BannerStandard bannerStandard = BannerStandard.this;
                    String str = BannerStandard.f35917r;
                    bannerStandard.u();
                }
            }, 4000);
        } else {
            u();
        }
    }

    public void loadHtml() {
        String j2;
        BannerStandardAd bannerStandardAd = this.f35918s;
        if (bannerStandardAd != null && (j2 = bannerStandardAd.j()) != null) {
            String str = this.f35878j;
            if (str != null && str.length() > 0) {
                j2 = j2.replaceAll("startapp_adtag_placeholder", this.f35878j);
            }
            this.f35924y.postDelayed(new Runnable() {
                public void run() {
                    BannerStandard bannerStandard = BannerStandard.this;
                    String str = BannerStandard.f35917r;
                    bannerStandard.j();
                }
            }, (long) this.A.i());
            this.f35925z = System.currentTimeMillis();
            lb.a(getContext(), this.webView, j2);
        }
    }

    public void m() {
        z6 z6Var = this.J;
        if (z6Var != null && z6Var.f36991k.get()) {
            super.m();
        }
    }

    public final void n() {
        if (this.F == null && this.G == null) {
            this.G = new RelativeLayout(getContext());
            AdInformationObject adInformationObject = new AdInformationObject(getContext(), AdInformationObject.Size.SMALL, AdPreferences.Placement.INAPP_BANNER, this.f35918s.getAdInfoOverride(), this.f35918s.getConsentData());
            this.F = adInformationObject;
            adInformationObject.a(this.G);
        }
        try {
            ViewGroup viewGroup = (ViewGroup) this.G.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.G);
            }
        } catch (Exception unused) {
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.webView.addView(this.G, layoutParams);
    }

    public final void o() {
        BannerStandardAd bannerStandardAd = this.f35918s;
        if (bannerStandardAd != null && bannerStandardAd.r()) {
            this.L = new pb(this.webView, BannerMetaData.f35889b.a(), new pb.b() {
                public boolean onUpdate(boolean z2) {
                    BannerStandard.this.N.fireViewableChangeEvent(z2);
                    return BannerStandard.this.f35918s.r();
                }
            });
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        WebView webView2 = this.webView;
        if (webView2 != null) {
            hc.b(webView2);
        }
        WebView webView3 = this.twoPartWebView;
        if (webView3 != null) {
            hc.b(webView3);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WebView webView2 = this.webView;
        if (webView2 != null) {
            hc.a(webView2);
        }
        WebView webView3 = this.twoPartWebView;
        if (webView3 != null) {
            hc.a(webView3);
        }
        z6 z6Var = this.J;
        if (z6Var != null) {
            z6Var.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
        }
        pb pbVar = this.L;
        if (pbVar != null) {
            pbVar.a();
        }
        pb pbVar2 = this.M;
        if (pbVar2 != null) {
            pbVar2.a();
        }
        p();
        v();
        WebView webView4 = this.webView;
        Map<Activity, Integer> map = lb.f34876a;
        new Handler(Looper.getMainLooper()).postAtTime((Runnable) null, webView4, SystemClock.uptimeMillis() + 1000);
    }

    public void onFailedToReceiveAd(Ad ad) {
        if (ad != null) {
            a(ad.getErrorMessage());
        }
    }

    public void onReceiveAd(Ad ad) {
        n3 n3Var;
        this.f35920u = false;
        removeView(this.G);
        BannerStandardAd bannerStandardAd = this.f35918s;
        if (bannerStandardAd == null || bannerStandardAd.j() == null || this.f35918s.j().compareTo("") == 0) {
            a("No Banner received");
            return;
        }
        this.f35921v = "true".equals(lb.a(this.f35918s.j(), "@jsTag@", "@jsTag@"));
        loadHtml();
        try {
            if (a(Integer.parseInt(lb.a(this.f35918s.j(), "@width@", "@width@")), Integer.parseInt(lb.a(this.f35918s.j(), "@height@", "@height@")))) {
                this.f35919t = true;
                n();
                t();
                a();
                o();
                if (this.f35923x) {
                    o6.a(this.R);
                }
                if (this.D != null && !this.E) {
                    this.E = true;
                    Context context = getContext();
                    BannerListener bannerListener = this.D;
                    if (bannerListener == null) {
                        n3Var = null;
                    } else {
                        n3Var = new n3(bannerListener, this, context);
                    }
                    o6.a((Runnable) n3Var);
                    return;
                }
                return;
            }
            a("Banner cannot be displayed (not enough room)");
        } catch (NumberFormatException unused) {
            a("Error Casting width & height from HTML");
        } catch (Throwable th) {
            y8.a(getContext(), th);
            a(th.getMessage());
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        double ceil = Math.ceil((double) (((float) i2) / displayMetrics.density));
        double ceil2 = Math.ceil((double) (((float) i3) / displayMetrics.density));
        Point point = this.C.f35750a;
        if (ceil < ((double) point.x) || ceil2 < ((double) point.y)) {
            o6.a(this.S);
        } else if (this.f35923x && this.f35919t) {
            o6.a(this.R);
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            WebView webView2 = this.webView;
            if (webView2 != null) {
                hc.b(webView2);
            }
            WebView webView3 = this.twoPartWebView;
            if (webView3 != null) {
                hc.b(webView3);
                return;
            }
            return;
        }
        WebView webView4 = this.webView;
        if (webView4 != null) {
            hc.a(webView4);
        }
        WebView webView5 = this.twoPartWebView;
        if (webView5 != null) {
            hc.a(webView5);
        }
    }

    public final void p() {
        this.f35924y.removeCallbacksAndMessages((Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096 A[SYNTHETIC, Splitter:B:32:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a8 A[Catch:{ all -> 0x00ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c7 A[Catch:{ all -> 0x00ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f6 A[Catch:{ all -> 0x00ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0111 A[Catch:{ all -> 0x00ef }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0093 A[EDGE_INSN: B:56:0x0093->B:30:0x0093 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f4 A[EDGE_INSN: B:57:0x00f4->B:48:0x00f4 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Point q() {
        /*
            r8 = this;
            android.graphics.Point r0 = new android.graphics.Point
            r0.<init>()
            android.view.ViewGroup$LayoutParams r1 = r8.getLayoutParams()
            r2 = 1
            if (r1 == 0) goto L_0x0025
            android.view.ViewGroup$LayoutParams r1 = r8.getLayoutParams()
            int r1 = r1.width
            if (r1 <= 0) goto L_0x0025
            android.content.Context r1 = r8.getContext()
            android.view.ViewGroup$LayoutParams r3 = r8.getLayoutParams()
            int r3 = r3.width
            int r3 = r3 + r2
            int r1 = com.startapp.p.b((android.content.Context) r1, (int) r3)
            r0.x = r1
        L_0x0025:
            android.view.ViewGroup$LayoutParams r1 = r8.getLayoutParams()
            if (r1 == 0) goto L_0x0044
            android.view.ViewGroup$LayoutParams r1 = r8.getLayoutParams()
            int r1 = r1.height
            if (r1 <= 0) goto L_0x0044
            android.content.Context r1 = r8.getContext()
            android.view.ViewGroup$LayoutParams r3 = r8.getLayoutParams()
            int r3 = r3.height
            int r3 = r3 + r2
            int r1 = com.startapp.p.b((android.content.Context) r1, (int) r3)
            r0.y = r1
        L_0x0044:
            android.view.ViewGroup$LayoutParams r1 = r8.getLayoutParams()
            if (r1 == 0) goto L_0x005f
            android.view.ViewGroup$LayoutParams r1 = r8.getLayoutParams()
            int r1 = r1.width
            if (r1 <= 0) goto L_0x005f
            android.view.ViewGroup$LayoutParams r1 = r8.getLayoutParams()
            int r1 = r1.height
            if (r1 <= 0) goto L_0x005f
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r1 = r8.f35918s
            r1.b(r2)
        L_0x005f:
            android.view.ViewGroup$LayoutParams r1 = r8.getLayoutParams()
            if (r1 == 0) goto L_0x0075
            android.view.ViewGroup$LayoutParams r1 = r8.getLayoutParams()
            int r1 = r1.width
            if (r1 <= 0) goto L_0x0075
            android.view.ViewGroup$LayoutParams r1 = r8.getLayoutParams()
            int r1 = r1.height
            if (r1 > 0) goto L_0x0167
        L_0x0075:
            android.content.Context r1 = r8.getContext()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            android.view.ViewParent r2 = r8.getParent()     // Catch:{ all -> 0x0144 }
            boolean r2 = r2 instanceof android.view.View     // Catch:{ all -> 0x0144 }
            if (r2 == 0) goto L_0x0092
            android.view.ViewParent r2 = r8.getParent()     // Catch:{ all -> 0x0144 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x0144 }
            r3 = r2
            r2 = r8
            goto L_0x0094
        L_0x0092:
            r2 = r8
        L_0x0093:
            r3 = 0
        L_0x0094:
            if (r3 == 0) goto L_0x00f4
            int r4 = r3.getMeasuredWidth()     // Catch:{ all -> 0x00ef }
            if (r4 <= 0) goto L_0x00a2
            int r4 = r3.getMeasuredHeight()     // Catch:{ all -> 0x00ef }
            if (r4 > 0) goto L_0x00f4
        L_0x00a2:
            int r4 = r3.getMeasuredWidth()     // Catch:{ all -> 0x00ef }
            if (r4 <= 0) goto L_0x00c1
            android.content.Context r4 = r2.getContext()     // Catch:{ all -> 0x00ef }
            int r5 = r3.getMeasuredWidth()     // Catch:{ all -> 0x00ef }
            int r6 = r3.getPaddingLeft()     // Catch:{ all -> 0x00ef }
            int r5 = r5 - r6
            int r6 = r3.getPaddingRight()     // Catch:{ all -> 0x00ef }
            int r5 = r5 - r6
            int r4 = com.startapp.p.b((android.content.Context) r4, (int) r5)     // Catch:{ all -> 0x00ef }
            r2.b(r0, r4)     // Catch:{ all -> 0x00ef }
        L_0x00c1:
            int r4 = r3.getMeasuredHeight()     // Catch:{ all -> 0x00ef }
            if (r4 <= 0) goto L_0x00e0
            android.content.Context r4 = r2.getContext()     // Catch:{ all -> 0x00ef }
            int r5 = r3.getMeasuredHeight()     // Catch:{ all -> 0x00ef }
            int r6 = r3.getPaddingBottom()     // Catch:{ all -> 0x00ef }
            int r5 = r5 - r6
            int r6 = r3.getPaddingTop()     // Catch:{ all -> 0x00ef }
            int r5 = r5 - r6
            int r4 = com.startapp.p.b((android.content.Context) r4, (int) r5)     // Catch:{ all -> 0x00ef }
            r2.a((android.graphics.Point) r0, (int) r4)     // Catch:{ all -> 0x00ef }
        L_0x00e0:
            android.view.ViewParent r4 = r3.getParent()     // Catch:{ all -> 0x00ef }
            boolean r4 = r4 instanceof android.view.View     // Catch:{ all -> 0x00ef }
            if (r4 == 0) goto L_0x0093
            android.view.ViewParent r3 = r3.getParent()     // Catch:{ all -> 0x00ef }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x00ef }
            goto L_0x0094
        L_0x00ef:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x0146
        L_0x00f4:
            if (r3 != 0) goto L_0x0111
            android.content.Context r3 = r2.getContext()     // Catch:{ all -> 0x00ef }
            int r4 = r1.widthPixels     // Catch:{ all -> 0x00ef }
            int r3 = com.startapp.p.b((android.content.Context) r3, (int) r4)     // Catch:{ all -> 0x00ef }
            r2.b(r0, r3)     // Catch:{ all -> 0x00ef }
            android.content.Context r3 = r2.getContext()     // Catch:{ all -> 0x00ef }
            int r4 = r1.heightPixels     // Catch:{ all -> 0x00ef }
            int r3 = com.startapp.p.b((android.content.Context) r3, (int) r4)     // Catch:{ all -> 0x00ef }
            r2.a((android.graphics.Point) r0, (int) r3)     // Catch:{ all -> 0x00ef }
            goto L_0x0167
        L_0x0111:
            android.content.Context r4 = r2.getContext()     // Catch:{ all -> 0x00ef }
            int r5 = r3.getMeasuredWidth()     // Catch:{ all -> 0x00ef }
            int r6 = r3.getPaddingLeft()     // Catch:{ all -> 0x00ef }
            int r5 = r5 - r6
            int r6 = r3.getPaddingRight()     // Catch:{ all -> 0x00ef }
            int r5 = r5 - r6
            int r4 = com.startapp.p.b((android.content.Context) r4, (int) r5)     // Catch:{ all -> 0x00ef }
            r2.b(r0, r4)     // Catch:{ all -> 0x00ef }
            android.content.Context r4 = r2.getContext()     // Catch:{ all -> 0x00ef }
            int r5 = r3.getMeasuredHeight()     // Catch:{ all -> 0x00ef }
            int r6 = r3.getPaddingBottom()     // Catch:{ all -> 0x00ef }
            int r5 = r5 - r6
            int r3 = r3.getPaddingTop()     // Catch:{ all -> 0x00ef }
            int r5 = r5 - r3
            int r3 = com.startapp.p.b((android.content.Context) r4, (int) r5)     // Catch:{ all -> 0x00ef }
            r2.a((android.graphics.Point) r0, (int) r3)     // Catch:{ all -> 0x00ef }
            goto L_0x0167
        L_0x0144:
            r2 = move-exception
            r3 = r8
        L_0x0146:
            android.content.Context r4 = r3.getContext()
            com.startapp.y8.a((android.content.Context) r4, (java.lang.Throwable) r2)
            android.content.Context r2 = r3.getContext()
            int r4 = r1.widthPixels
            int r2 = com.startapp.p.b((android.content.Context) r2, (int) r4)
            r3.b(r0, r2)
            android.content.Context r2 = r3.getContext()
            int r1 = r1.heightPixels
            int r1 = com.startapp.p.b((android.content.Context) r2, (int) r1)
            r3.a((android.graphics.Point) r0, (int) r1)
        L_0x0167:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.q():android.graphics.Point");
    }

    public int r() {
        return 0;
    }

    public final ViewGroup s() {
        View view;
        View rootView;
        ViewGroup viewGroup = this.P;
        if (viewGroup != null) {
            return viewGroup;
        }
        Context context = getContext();
        RelativeLayout relativeLayout = this.H;
        View view2 = null;
        if (!(context instanceof Activity)) {
            view = null;
        } else {
            view = ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        }
        if (!(relativeLayout == null || (rootView = relativeLayout.getRootView()) == null || (view2 = rootView.findViewById(16908290)) != null)) {
            view2 = rootView;
        }
        if (view == null) {
            view = view2;
        }
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return this.H;
    }

    public void setAdTag(String str) {
        this.f35878j = str;
    }

    public void setBannerListener(BannerListener bannerListener) {
        this.D = bannerListener;
    }

    public void showBanner() {
        try {
            ComponentLocator.a(getContext()).q().a(2048);
        } catch (Throwable unused) {
        }
        this.f35923x = true;
        o6.a(this.R);
    }

    public void t() {
        long j2;
        Context context = getContext();
        String[] strArr = this.f35918s.trackingUrls;
        TrackingParams trackingParams = new TrackingParams(this.f35878j);
        if (this.f35918s.h() != null) {
            j2 = TimeUnit.SECONDS.toMillis(this.f35918s.h().longValue());
        } else {
            j2 = TimeUnit.SECONDS.toMillis(MetaData.f36379h.n());
        }
        z6 z6Var = new z6(context, strArr, trackingParams, j2);
        this.J = z6Var;
        z6Var.f36992l = new WeakReference<>(this.Q);
        a(this.J);
    }

    public final void u() {
        if (this.B == null) {
            this.B = new AdPreferences();
        }
        if (this.f35918s != null) {
            Point point = this.f35874f;
            if (point == null) {
                point = q();
            }
            this.f35918s.a(point.x, point.y);
            this.f35918s.setState(Ad.AdState.UN_INITIALIZED);
            this.f35918s.c(r());
            this.f35918s.load(this.B, this);
        }
    }

    public final boolean v() {
        me meVar = this.K;
        this.K = null;
        if (meVar == null) {
            return false;
        }
        try {
            meVar.a();
            return true;
        } catch (Throwable th) {
            y8.a(getContext(), th);
            return false;
        }
    }

    public BannerStandard(Activity activity, AdPreferences adPreferences) {
        this((Context) activity, adPreferences);
    }

    public BannerStandard(Activity activity, BannerListener bannerListener) {
        this((Context) activity, bannerListener);
    }

    public final void b(WebView webView2) {
        me meVar = this.K;
        if (meVar == null) {
            meVar = new me(webView2);
            this.K = meVar;
        }
        if (meVar.c()) {
            try {
                RelativeLayout relativeLayout = this.G;
                if (relativeLayout != null) {
                    meVar.a(relativeLayout, FriendlyObstructionPurpose.OTHER, (String) null);
                }
                CloseableLayout closeableLayout = this.I;
                if (closeableLayout != null) {
                    meVar.a(closeableLayout, FriendlyObstructionPurpose.CLOSE_AD, (String) null);
                }
            } catch (RuntimeException e2) {
                Log.e(f35917r, "OMSDK error", e2);
            }
            meVar.a(webView2);
            meVar.e();
            meVar.d();
            meVar.b();
        }
    }

    public BannerStandard(Activity activity, AdPreferences adPreferences, BannerListener bannerListener) {
        this((Context) activity, adPreferences, bannerListener);
    }

    public BannerStandard(Activity activity, boolean z2) {
        this((Context) activity, z2);
    }

    public BannerStandard(Activity activity, boolean z2, AdPreferences adPreferences) {
        this((Context) activity, z2, adPreferences);
    }

    public BannerStandard(Activity activity, AttributeSet attributeSet) {
        this((Context) activity, attributeSet);
    }

    public BannerStandard(Activity activity, AttributeSet attributeSet, int i2) {
        this((Context) activity, attributeSet, i2);
    }

    public final void a(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(p.a(getContext(), this.C.f35750a.x), p.a(getContext(), this.C.f35750a.y));
        layoutParams.addRule(13);
        this.H.addView(view, layoutParams);
    }

    @Deprecated
    public BannerStandard(Context context) {
        this(context, true, (AdPreferences) null);
    }

    @Deprecated
    public BannerStandard(Context context, AdPreferences adPreferences) {
        this(context, true, adPreferences);
    }

    @Deprecated
    public BannerStandard(Context context, BannerListener bannerListener) {
        this(context, true, (AdPreferences) null);
        setBannerListener(bannerListener);
    }

    @Deprecated
    public BannerStandard(Context context, AdPreferences adPreferences, BannerListener bannerListener) {
        this(context, true, adPreferences);
        setBannerListener(bannerListener);
    }

    @Deprecated
    public BannerStandard(Context context, boolean z2) {
        this(context, z2, (AdPreferences) null);
    }

    public BannerStandard(Context context, boolean z2, AdPreferences adPreferences) {
        this(context, z2, adPreferences, (BannerStandardAd) null);
    }

    public BannerStandard(Context context, boolean z2, AdPreferences adPreferences, BannerStandardAd bannerStandardAd) {
        super(context);
        this.f35919t = false;
        this.f35920u = true;
        this.f35921v = false;
        this.f35922w = true;
        this.f35923x = true;
        this.f35924y = new Handler(Looper.getMainLooper());
        this.C = new r3(getWidthInDp(), getHeightInDp());
        this.E = false;
        this.F = null;
        this.G = null;
        this.Q = new z6.a() {
            public void onSent() {
                p3 p3Var;
                BannerStandard bannerStandard = BannerStandard.this;
                Context context = bannerStandard.getContext();
                BannerListener bannerListener = bannerStandard.D;
                if (bannerListener == null) {
                    p3Var = null;
                } else {
                    p3Var = new p3(bannerListener, bannerStandard, context);
                }
                o6.a((Runnable) p3Var);
                bannerStandard.f35925z = System.currentTimeMillis() - bannerStandard.f35925z;
                bannerStandard.m();
            }
        };
        this.R = new Runnable() {
            public void run() {
                BannerStandard bannerStandard = BannerStandard.this;
                RelativeLayout relativeLayout = bannerStandard.H;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                if (bannerStandard.f35918s != null) {
                    ha r2 = ComponentLocator.a(bannerStandard.getContext()).r();
                    AdPreferences.Placement placement = AdPreferences.Placement.INAPP_BANNER;
                    int r3 = bannerStandard.r();
                    String adId = bannerStandard.f35918s.getAdId();
                    r2.getClass();
                    if (adId != null) {
                        r2.f34636a.put(new ha.a(placement, r3), adId);
                    }
                }
            }
        };
        this.S = new Runnable() {
            public void run() {
                RelativeLayout relativeLayout = BannerStandard.this.H;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(4);
                }
            }
        };
        try {
            this.f35922w = z2;
            this.B = adPreferences;
            this.f35918s = bannerStandardAd;
            h();
        } catch (Throwable th) {
            y8.a(context, th);
        }
    }

    public final void a(Point point, int i2) {
        if (point.y <= 0) {
            point.y = i2;
        }
    }

    public final void a(String str) {
        setErrorMessage(str);
        if (this.D != null && !this.E) {
            this.E = true;
            p.a(getContext(), this.D, (View) this);
        }
    }

    public final boolean a(int i2, int i3) {
        Point q2 = q();
        if (q2.x < i2 || q2.y < i3) {
            Point point = new Point(0, 0);
            ViewGroup.LayoutParams layoutParams = this.webView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(point.x, point.y);
            } else {
                layoutParams.width = point.x;
                layoutParams.height = point.y;
            }
            this.webView.setLayoutParams(layoutParams);
            return false;
        }
        Point point2 = this.C.f35750a;
        point2.x = i2;
        point2.y = i3;
        int a2 = p.a(getContext(), this.C.f35750a.x);
        int a3 = p.a(getContext(), this.C.f35750a.y);
        this.H.setMinimumWidth(a2);
        this.H.setMinimumHeight(a3);
        ViewGroup.LayoutParams layoutParams2 = this.webView.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(a2, a3);
        } else {
            layoutParams2.width = a2;
            layoutParams2.height = a3;
        }
        this.webView.setLayoutParams(layoutParams2);
        return true;
    }

    @Deprecated
    public BannerStandard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public BannerStandard(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35919t = false;
        this.f35920u = true;
        this.f35921v = false;
        this.f35922w = true;
        this.f35923x = true;
        this.f35924y = new Handler(Looper.getMainLooper());
        this.C = new r3(getWidthInDp(), getHeightInDp());
        this.E = false;
        this.F = null;
        this.G = null;
        this.Q = new z6.a() {
            public void onSent() {
                p3 p3Var;
                BannerStandard bannerStandard = BannerStandard.this;
                Context context = bannerStandard.getContext();
                BannerListener bannerListener = bannerStandard.D;
                if (bannerListener == null) {
                    p3Var = null;
                } else {
                    p3Var = new p3(bannerListener, bannerStandard, context);
                }
                o6.a((Runnable) p3Var);
                bannerStandard.f35925z = System.currentTimeMillis() - bannerStandard.f35925z;
                bannerStandard.m();
            }
        };
        this.R = new Runnable() {
            public void run() {
                BannerStandard bannerStandard = BannerStandard.this;
                RelativeLayout relativeLayout = bannerStandard.H;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                if (bannerStandard.f35918s != null) {
                    ha r2 = ComponentLocator.a(bannerStandard.getContext()).r();
                    AdPreferences.Placement placement = AdPreferences.Placement.INAPP_BANNER;
                    int r3 = bannerStandard.r();
                    String adId = bannerStandard.f35918s.getAdId();
                    r2.getClass();
                    if (adId != null) {
                        r2.f34636a.put(new ha.a(placement, r3), adId);
                    }
                }
            }
        };
        this.S = new Runnable() {
            public void run() {
                RelativeLayout relativeLayout = BannerStandard.this.H;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(4);
                }
            }
        };
        try {
            h();
        } catch (Throwable th) {
            y8.a(context, th);
        }
    }

    public void a(int i2) {
        this.f35877i = i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: java.lang.String[]} */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e2 A[Catch:{ all -> 0x0105 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.startapp.sdk.ads.banner.bannerstandard.BannerStandard r22, java.lang.String r23) {
        /*
            r1 = r22
            android.content.Context r0 = r22.getContext()
            com.startapp.sdk.ads.banner.BannerListener r2 = r1.D
            r3 = 0
            if (r2 != 0) goto L_0x000d
            r4 = r3
            goto L_0x0012
        L_0x000d:
            com.startapp.q3 r4 = new com.startapp.q3
            r4.<init>(r2, r1, r0)
        L_0x0012:
            com.startapp.o6.a((java.lang.Runnable) r4)
            com.startapp.z6 r0 = r1.J
            if (r0 == 0) goto L_0x001c
            r0.a(r3, r3)
        L_0x001c:
            com.startapp.pb r0 = r1.L
            if (r0 == 0) goto L_0x0023
            r0.a()
        L_0x0023:
            com.startapp.pb r0 = r1.M
            if (r0 == 0) goto L_0x002a
            r0.a()
        L_0x002a:
            r22.p()
            android.content.Context r0 = r22.getContext()
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r2 = com.startapp.sdk.adsbase.model.AdPreferences.Placement.INAPP_BANNER
            boolean r0 = com.startapp.o6.a((android.content.Context) r0, (com.startapp.sdk.adsbase.model.AdPreferences.Placement) r2)
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r2 = r1.f35918s
            java.lang.String[] r2 = r2.o()
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r4 = r1.f35918s
            java.lang.String[] r4 = r4.m()
            boolean r5 = r1.f35921v
            java.lang.String r6 = "adId: "
            r7 = 1
            r8 = 0
            if (r5 != 0) goto L_0x010e
            java.lang.String r5 = "index="
            r10 = r23
            boolean r5 = r10.contains(r5)
            if (r5 == 0) goto L_0x0110
            int r5 = com.startapp.o6.a((java.lang.String) r23)     // Catch:{ all -> 0x0105 }
            if (r5 >= 0) goto L_0x0086
            com.startapp.y8 r0 = new com.startapp.y8     // Catch:{ all -> 0x0105 }
            com.startapp.z8 r2 = com.startapp.z8.f36996c     // Catch:{ all -> 0x0105 }
            r0.<init>((com.startapp.z8) r2)     // Catch:{ all -> 0x0105 }
            java.lang.String r2 = "Wrong index extracted from URL"
            r0.f36954d = r2     // Catch:{ all -> 0x0105 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0105 }
            r2.<init>()     // Catch:{ all -> 0x0105 }
            r2.append(r6)     // Catch:{ all -> 0x0105 }
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r3 = r1.f35918s     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = r3.getAdId()     // Catch:{ all -> 0x0105 }
            r2.append(r3)     // Catch:{ all -> 0x0105 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0105 }
            r0.f36955e = r2     // Catch:{ all -> 0x0105 }
            android.content.Context r2 = r22.getContext()     // Catch:{ all -> 0x0105 }
            r0.a(r2)     // Catch:{ all -> 0x0105 }
            goto L_0x013c
        L_0x0086:
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r6 = r1.f35918s     // Catch:{ all -> 0x0105 }
            r6.getClass()     // Catch:{ all -> 0x0105 }
            if (r5 < 0) goto L_0x0096
            boolean[] r6 = r6.smartRedirect     // Catch:{ all -> 0x0105 }
            int r9 = r6.length     // Catch:{ all -> 0x0105 }
            if (r5 < r9) goto L_0x0093
            goto L_0x0096
        L_0x0093:
            boolean r6 = r6[r5]     // Catch:{ all -> 0x0105 }
            goto L_0x0097
        L_0x0096:
            r6 = 0
        L_0x0097:
            if (r6 == 0) goto L_0x00db
            if (r0 != 0) goto L_0x00db
            android.content.Context r9 = r22.getContext()     // Catch:{ all -> 0x0105 }
            int r0 = r2.length     // Catch:{ all -> 0x0105 }
            if (r5 >= r0) goto L_0x00aa
            java.lang.String[] r0 = new java.lang.String[r7]     // Catch:{ all -> 0x0105 }
            r2 = r2[r5]     // Catch:{ all -> 0x0105 }
            r0[r8] = r2     // Catch:{ all -> 0x0105 }
            r11 = r0
            goto L_0x00ab
        L_0x00aa:
            r11 = r3
        L_0x00ab:
            int r0 = r4.length     // Catch:{ all -> 0x0105 }
            if (r5 >= r0) goto L_0x00b0
            r3 = r4[r5]     // Catch:{ all -> 0x0105 }
        L_0x00b0:
            r12 = r3
            com.startapp.sdk.adsbase.commontracking.TrackingParams r13 = new com.startapp.sdk.adsbase.commontracking.TrackingParams     // Catch:{ all -> 0x0105 }
            java.lang.String r0 = r1.f35878j     // Catch:{ all -> 0x0105 }
            r13.<init>(r0)     // Catch:{ all -> 0x0105 }
            com.startapp.sdk.adsbase.AdsCommonMetaData r0 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h     // Catch:{ all -> 0x0105 }
            long r14 = r0.z()     // Catch:{ all -> 0x0105 }
            com.startapp.sdk.adsbase.AdsCommonMetaData r0 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h     // Catch:{ all -> 0x0105 }
            long r16 = r0.y()     // Catch:{ all -> 0x0105 }
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r0 = r1.f35918s     // Catch:{ all -> 0x0105 }
            boolean r18 = r0.a((int) r5)     // Catch:{ all -> 0x0105 }
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r0 = r1.f35918s     // Catch:{ all -> 0x0105 }
            java.lang.Boolean r19 = r0.b((int) r5)     // Catch:{ all -> 0x0105 }
            r20 = 0
            r21 = 0
            r10 = r23
            com.startapp.o6.a(r9, r10, r11, r12, r13, r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x0105 }
            goto L_0x01d7
        L_0x00db:
            android.content.Context r9 = r22.getContext()     // Catch:{ all -> 0x0105 }
            int r4 = r2.length     // Catch:{ all -> 0x0105 }
            if (r5 >= r4) goto L_0x00e8
            java.lang.String[] r3 = new java.lang.String[r7]     // Catch:{ all -> 0x0105 }
            r2 = r2[r5]     // Catch:{ all -> 0x0105 }
            r3[r8] = r2     // Catch:{ all -> 0x0105 }
        L_0x00e8:
            r11 = r3
            com.startapp.sdk.adsbase.commontracking.TrackingParams r12 = new com.startapp.sdk.adsbase.commontracking.TrackingParams     // Catch:{ all -> 0x0105 }
            java.lang.String r2 = r1.f35878j     // Catch:{ all -> 0x0105 }
            r12.<init>(r2)     // Catch:{ all -> 0x0105 }
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r2 = r1.f35918s     // Catch:{ all -> 0x0105 }
            boolean r2 = r2.a((int) r5)     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x00fc
            if (r0 != 0) goto L_0x00fc
            r13 = 1
            goto L_0x00fd
        L_0x00fc:
            r13 = 0
        L_0x00fd:
            r14 = 0
            r10 = r23
            com.startapp.o6.a((android.content.Context) r9, (java.lang.String) r10, (java.lang.String[]) r11, (com.startapp.sdk.adsbase.commontracking.TrackingParams) r12, (boolean) r13, (boolean) r14)     // Catch:{ all -> 0x0105 }
            goto L_0x01d7
        L_0x0105:
            r0 = move-exception
            android.content.Context r1 = r22.getContext()
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r0)
            goto L_0x013c
        L_0x010e:
            r10 = r23
        L_0x0110:
            int r3 = r2.length
            if (r3 >= r7) goto L_0x013f
            com.startapp.y8 r0 = new com.startapp.y8
            com.startapp.z8 r2 = com.startapp.z8.f36996c
            r0.<init>((com.startapp.z8) r2)
            java.lang.String r2 = "No tracking URLs"
            r0.f36954d = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r3 = r1.f35918s
            java.lang.String r3 = r3.getAdId()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.f36955e = r2
            android.content.Context r1 = r22.getContext()
            r0.a(r1)
        L_0x013c:
            r7 = 0
            goto L_0x01df
        L_0x013f:
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r3 = r1.f35918s
            r3.getClass()
            boolean[] r3 = r3.smartRedirect
            int r5 = r3.length
            if (r5 > 0) goto L_0x014b
            r3 = 0
            goto L_0x014d
        L_0x014b:
            boolean r3 = r3[r8]
        L_0x014d:
            if (r3 == 0) goto L_0x01b3
            if (r0 != 0) goto L_0x01b3
            int r0 = r4.length
            if (r0 >= r7) goto L_0x017e
            com.startapp.y8 r0 = new com.startapp.y8
            com.startapp.z8 r2 = com.startapp.z8.f36996c
            r0.<init>((com.startapp.z8) r2)
            java.lang.String r2 = "No package names"
            r0.f36954d = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r3 = r1.f35918s
            java.lang.String r3 = r3.getAdId()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.f36955e = r2
            android.content.Context r1 = r22.getContext()
            r0.a(r1)
            goto L_0x013c
        L_0x017e:
            android.content.Context r9 = r22.getContext()
            java.lang.String[] r11 = new java.lang.String[r7]
            r0 = r2[r8]
            r11[r8] = r0
            r12 = r4[r8]
            com.startapp.sdk.adsbase.commontracking.TrackingParams r13 = new com.startapp.sdk.adsbase.commontracking.TrackingParams
            java.lang.String r0 = r1.f35878j
            r13.<init>(r0)
            com.startapp.sdk.adsbase.AdsCommonMetaData r0 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h
            long r14 = r0.z()
            com.startapp.sdk.adsbase.AdsCommonMetaData r0 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h
            long r16 = r0.y()
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r0 = r1.f35918s
            boolean r18 = r0.a((int) r8)
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r0 = r1.f35918s
            java.lang.Boolean r19 = r0.b((int) r8)
            r20 = 0
            r21 = 0
            r10 = r23
            com.startapp.o6.a(r9, r10, r11, r12, r13, r14, r16, r18, r19, r20, r21)
            goto L_0x01d7
        L_0x01b3:
            android.content.Context r9 = r22.getContext()
            java.lang.String[] r11 = new java.lang.String[r7]
            r2 = r2[r8]
            r11[r8] = r2
            com.startapp.sdk.adsbase.commontracking.TrackingParams r12 = new com.startapp.sdk.adsbase.commontracking.TrackingParams
            java.lang.String r2 = r1.f35878j
            r12.<init>(r2)
            com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd r2 = r1.f35918s
            boolean r2 = r2.a((int) r8)
            if (r2 == 0) goto L_0x01d0
            if (r0 != 0) goto L_0x01d0
            r13 = 1
            goto L_0x01d1
        L_0x01d0:
            r13 = 0
        L_0x01d1:
            r14 = 0
            r10 = r23
            com.startapp.o6.a((android.content.Context) r9, (java.lang.String) r10, (java.lang.String[]) r11, (com.startapp.sdk.adsbase.commontracking.TrackingParams) r12, (boolean) r13, (boolean) r14)
        L_0x01d7:
            android.webkit.WebView r0 = r1.webView
            r0.stopLoading()
            r1.setClicked(r7)
        L_0x01df:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.banner.bannerstandard.BannerStandard.a(com.startapp.sdk.ads.banner.bannerstandard.BannerStandard, java.lang.String):boolean");
    }

    public static void a(BannerStandard bannerStandard, boolean z2) {
        if (z2 != (!bannerStandard.I.f35929d.isVisible())) {
            bannerStandard.I.setCloseVisible(!z2);
        }
    }

    public static void a(BannerStandard bannerStandard) {
        MraidState mraidState;
        if (bannerStandard.N.getState() != MraidState.LOADING && bannerStandard.N.getState() != (mraidState = MraidState.HIDDEN)) {
            if (bannerStandard.N.getState() == MraidState.RESIZED || bannerStandard.N.getState() == MraidState.EXPANDED) {
                if (bannerStandard.O != null) {
                    bannerStandard.I.removeView(bannerStandard.twoPartWebView);
                    bannerStandard.M.a();
                    bannerStandard.M = null;
                    bannerStandard.O = null;
                    bannerStandard.twoPartWebView.stopLoading();
                    bannerStandard.twoPartWebView = null;
                } else {
                    bannerStandard.I.removeView(bannerStandard.webView);
                    bannerStandard.a((View) bannerStandard.webView);
                    o6.a(bannerStandard.R);
                }
                CloseableLayout closeableLayout = bannerStandard.I;
                if (!(closeableLayout == null || closeableLayout.getParent() == null || !(closeableLayout.getParent() instanceof ViewGroup))) {
                    ((ViewGroup) closeableLayout.getParent()).removeView(closeableLayout);
                }
                bannerStandard.N.setState(MraidState.DEFAULT);
            } else if (bannerStandard.N.getState() == MraidState.DEFAULT) {
                o6.a(bannerStandard.S);
                bannerStandard.N.setState(mraidState);
            }
            bannerStandard.m();
        }
    }
}
