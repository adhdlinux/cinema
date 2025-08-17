package com.startapp.sdk.ads.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.startapp.a5;
import com.startapp.b5;
import com.startapp.hc;
import com.startapp.ia;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.x4;
import com.startapp.y8;
import com.startapp.z4;

public class SplashScreen {

    /* renamed from: a  reason: collision with root package name */
    public Activity f36050a;

    /* renamed from: b  reason: collision with root package name */
    public SplashEventHandler f36051b;

    /* renamed from: c  reason: collision with root package name */
    public SplashConfig f36052c;

    /* renamed from: d  reason: collision with root package name */
    public CacheKey f36053d;

    /* renamed from: e  reason: collision with root package name */
    public SplashHtml f36054e = null;

    /* renamed from: f  reason: collision with root package name */
    public Handler f36055f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    public boolean f36056g = false;

    /* renamed from: h  reason: collision with root package name */
    public SplashStartAppAd f36057h;

    /* renamed from: i  reason: collision with root package name */
    public AdPreferences f36058i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f36059j = new a();

    /* renamed from: k  reason: collision with root package name */
    public Runnable f36060k = new b();

    /* renamed from: l  reason: collision with root package name */
    public AdEventListener f36061l = new c();

    public static class SplashStartAppAd extends StartAppAd {
        private static final long serialVersionUID = 1;

        public SplashStartAppAd(Context context) {
            super(context);
            this.placement = AdPreferences.Placement.INAPP_SPLASH;
        }

        public AdRulesResult a(String str, AdPreferences.Placement placement) {
            return new AdRulesResult(true, "");
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            View view;
            boolean z2;
            SplashScreen splashScreen = SplashScreen.this;
            if (splashScreen.f36052c.b(splashScreen.f36050a)) {
                if (splashScreen.b()) {
                    view = splashScreen.f36052c.a((Context) splashScreen.f36050a);
                } else {
                    SplashHtml splashHtml = splashScreen.f36054e;
                    if (splashHtml != null) {
                        view = splashHtml.b();
                    } else {
                        view = null;
                    }
                }
                if (view != null) {
                    splashScreen.f36050a.setContentView(view, new ViewGroup.LayoutParams(-1, -1));
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    SplashScreen splashScreen2 = SplashScreen.this;
                    Context a2 = ia.a(splashScreen2.f36050a);
                    if (a2 == null) {
                        a2 = splashScreen2.f36050a;
                    }
                    SplashStartAppAd splashStartAppAd = new SplashStartAppAd(a2);
                    splashScreen2.f36057h = splashStartAppAd;
                    splashScreen2.f36053d = splashStartAppAd.loadSplash(splashScreen2.f36058i, splashScreen2.f36061l);
                    SplashScreen splashScreen3 = SplashScreen.this;
                    splashScreen3.f36055f.postDelayed(new z4(splashScreen3), splashScreen3.f36052c.a().longValue());
                    splashScreen3.f36055f.postDelayed(new a5(splashScreen3), splashScreen3.f36052c.getMinSplashTime().getIndex());
                    return;
                }
                SplashScreen.this.f36050a.finish();
                return;
            }
            throw new IllegalArgumentException(splashScreen.f36052c.getErrorMessage());
        }
    }

    public class b implements Runnable {

        public class a implements x4 {

            /* renamed from: com.startapp.sdk.ads.splash.SplashScreen$b$a$a  reason: collision with other inner class name */
            public class C0059a implements AdDisplayListener {
                public C0059a() {
                }

                public void adClicked(Ad ad) {
                    SplashScreen.this.f36051b.f36033f = true;
                }

                public void adDisplayed(Ad ad) {
                    SplashScreen.this.f36051b.f36036i = SplashEventHandler.SplashState.DISPLAYED;
                }

                public void adHidden(Ad ad) {
                    SplashEventHandler splashEventHandler = SplashScreen.this.f36051b;
                    splashEventHandler.f36036i = SplashEventHandler.SplashState.HIDDEN;
                    splashEventHandler.b();
                }

                public void adNotDisplayed(Ad ad) {
                }
            }

            public a() {
            }

            public void a() {
                SplashStartAppAd splashStartAppAd;
                SplashScreen splashScreen = SplashScreen.this;
                if (!splashScreen.f36056g && (splashStartAppAd = splashScreen.f36057h) != null) {
                    splashStartAppAd.showAd((AdDisplayListener) new C0059a());
                    SplashScreen splashScreen2 = SplashScreen.this;
                    if (splashScreen2.f36052c.getMaxAdDisplayTime() != SplashConfig.MaxAdDisplayTime.FOR_EVER) {
                        splashScreen2.f36055f.postDelayed(new b5(splashScreen2), splashScreen2.f36052c.getMaxAdDisplayTime().getIndex());
                    }
                    SplashScreen.this.f36050a.finish();
                }
            }
        }

        public b() {
        }

        public void run() {
            SplashScreen splashScreen = SplashScreen.this;
            SplashEventHandler splashEventHandler = splashScreen.f36051b;
            SplashHtml splashHtml = splashScreen.f36054e;
            a aVar = new a();
            splashEventHandler.getClass();
            if (splashHtml == null) {
                aVar.a();
                return;
            }
            splashHtml.callback = aVar;
            splashHtml.a();
        }
    }

    public class c implements AdEventListener {
        public c() {
        }

        public void onFailedToReceiveAd(Ad ad) {
            SplashScreen splashScreen = SplashScreen.this;
            if (splashScreen.f36057h != null) {
                SplashEventHandler splashEventHandler = splashScreen.f36051b;
                splashEventHandler.f36036i = SplashEventHandler.SplashState.DO_NOT_DISPLAY;
                splashEventHandler.a((Runnable) null);
            }
        }

        public void onReceiveAd(Ad ad) {
            SplashScreen splashScreen = SplashScreen.this;
            SplashEventHandler splashEventHandler = splashScreen.f36051b;
            Runnable runnable = splashScreen.f36060k;
            if (splashEventHandler.f36036i == SplashEventHandler.SplashState.LOADING) {
                splashEventHandler.f36036i = SplashEventHandler.SplashState.RECEIVED;
            }
            splashEventHandler.a(runnable);
        }
    }

    public SplashScreen(Activity activity, SplashConfig splashConfig, AdPreferences adPreferences) {
        this.f36050a = activity;
        this.f36052c = splashConfig;
        this.f36058i = adPreferences;
        try {
            a();
            this.f36051b = new SplashEventHandler(activity, this.f36054e);
        } catch (Throwable th) {
            SplashEventHandler splashEventHandler = new SplashEventHandler(activity);
            this.f36051b = splashEventHandler;
            splashEventHandler.d();
            this.f36051b.a();
            y8.a((Context) activity, th);
        }
    }

    public final void a() {
        SplashConfig splashConfig = this.f36052c;
        Activity activity = this.f36050a;
        if (splashConfig.getLogo() == null && splashConfig.getLogoRes() == -1 && splashConfig.getLogoByteArray() != null) {
            byte[] logoByteArray = splashConfig.getLogoByteArray();
            splashConfig.f36026f = new BitmapDrawable(activity.getResources(), BitmapFactory.decodeByteArray(logoByteArray, 0, logoByteArray.length));
        }
        if (!b()) {
            this.f36054e = this.f36052c.a(this.f36050a);
        }
    }

    public final boolean b() {
        return !this.f36052c.isHtmlSplash() || this.f36052c.b();
    }

    public final boolean c() {
        int i2 = this.f36050a.getResources().getConfiguration().orientation;
        if (this.f36052c.getOrientation() == SplashConfig.Orientation.AUTO) {
            if (i2 == 2) {
                this.f36052c.setOrientation(SplashConfig.Orientation.LANDSCAPE);
            } else {
                this.f36052c.setOrientation(SplashConfig.Orientation.PORTRAIT);
            }
        }
        int ordinal = this.f36052c.getOrientation().ordinal();
        boolean z2 = true;
        if (ordinal == 0) {
            if (i2 != 2) {
                z2 = false;
            }
            Activity activity = this.f36050a;
            int i3 = hc.f34643a;
            activity.setRequestedOrientation(7);
        } else if (ordinal != 1) {
            return false;
        } else {
            if (i2 != 1) {
                z2 = false;
            }
            Activity activity2 = this.f36050a;
            int i4 = hc.f34643a;
            try {
                activity2.setRequestedOrientation(6);
            } catch (Throwable unused) {
            }
        }
        return z2;
    }
}
