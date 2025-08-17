package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.startapp.d8;
import com.startapp.ia;
import com.startapp.j7;
import com.startapp.j8;
import com.startapp.k7;
import com.startapp.l7;
import com.startapp.lb;
import com.startapp.o6;
import com.startapp.p;
import com.startapp.p7;
import com.startapp.ra;
import com.startapp.sdk.ads.interstitials.OverlayActivity;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.ads.splash.SplashHideListener;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import com.startapp.sdk.adsbase.adlisteners.VideoListener;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.u6;
import com.startapp.v6;
import com.startapp.wb;
import com.startapp.y8;
import com.vungle.ads.internal.Constants;
import java.io.Serializable;
import okhttp3.internal.http2.Http2;

public class StartAppAd extends Ad {
    private static final long serialVersionUID = 1;
    public v6 ad = null;
    private CacheKey adKey = null;
    private AdMode adMode = AdMode.AUTOMATIC;
    private AdPreferences adPreferences = null;
    public AdDisplayListener callback = null;
    private final BroadcastReceiver callbackBroadcastReceiver = new a();
    public VideoListener videoListener = null;

    public enum AdMode {
        AUTOMATIC,
        FULLPAGE,
        OFFERWALL,
        REWARDED_VIDEO,
        VIDEO,
        OVERLAY
    }

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            j7 j7Var;
            p7 p7Var;
            l7 l7Var;
            k7 k7Var;
            String action = intent.getAction();
            if (action == null) {
                action = "";
            }
            if (action.equals("com.startapp.android.ShowFailedDisplayBroadcastListener")) {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    extras = Bundle.EMPTY;
                }
                if (extras.containsKey("showFailedReason")) {
                    StartAppAd.this.a((NotDisplayedReason) extras.getSerializable("showFailedReason"));
                }
                StartAppAd startAppAd = StartAppAd.this;
                p.a(context, startAppAd.callback, (Ad) startAppAd);
                wb.a(context).a((BroadcastReceiver) this);
            } else if (action.equals("com.startapp.android.ShowDisplayBroadcastListener")) {
                StartAppAd startAppAd2 = StartAppAd.this;
                AdDisplayListener adDisplayListener = startAppAd2.callback;
                if (adDisplayListener == null) {
                    k7Var = null;
                } else {
                    k7Var = new k7(adDisplayListener, startAppAd2, context);
                }
                o6.a((Runnable) k7Var);
            } else if (action.equals("com.startapp.android.OnClickCallback")) {
                StartAppAd startAppAd3 = StartAppAd.this;
                AdDisplayListener adDisplayListener2 = startAppAd3.callback;
                if (adDisplayListener2 == null) {
                    l7Var = null;
                } else {
                    l7Var = new l7(adDisplayListener2, startAppAd3, context);
                }
                o6.a((Runnable) l7Var);
            } else if (action.equals("com.startapp.android.OnVideoCompleted")) {
                VideoListener videoListener = StartAppAd.this.videoListener;
                if (videoListener == null) {
                    p7Var = null;
                } else {
                    p7Var = new p7(videoListener, context);
                }
                o6.a((Runnable) p7Var);
            } else {
                StartAppAd startAppAd4 = StartAppAd.this;
                AdDisplayListener adDisplayListener3 = startAppAd4.callback;
                if (adDisplayListener3 == null) {
                    j7Var = null;
                } else {
                    j7Var = new j7(adDisplayListener3, startAppAd4, context);
                }
                o6.a((Runnable) j7Var);
                wb.a(context).a((BroadcastReceiver) this);
            }
            StartAppAd.this.ad = null;
        }
    }

    public static class b extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f36216a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SplashHideListener f36217b;

        public b(Activity activity, SplashHideListener splashHideListener) {
            this.f36216a = activity;
            this.f36217b = splashHideListener;
        }

        public void onReceive(Context context, Intent intent) {
            lb.a(this.f36216a, false);
            SplashHideListener splashHideListener = this.f36217b;
            if (splashHideListener != null) {
                splashHideListener.splashHidden();
            }
            wb.a((Context) this.f36216a).a((BroadcastReceiver) this);
        }
    }

    public StartAppAd(Context context) {
        super(context, (AdPreferences.Placement) null);
        try {
            ComponentLocator.a(context).q().a(8192);
        } catch (Throwable unused) {
        }
    }

    public static void disableAutoInterstitial() {
        u6.a.f36650a.f36645a = false;
    }

    public static void disableSplash() {
        String str = StartAppSDKInternal.f36218a;
        StartAppSDKInternal.c.f36252a.f36242y = true;
        d8.f34354a.b(AdPreferences.Placement.INAPP_SPLASH);
    }

    public static void enableAutoInterstitial() {
        u6.a.f36650a.f36645a = true;
    }

    public static void enableConsent(Context context, boolean z2) {
        ComponentLocator.a(context).f().f35855e = z2;
    }

    public static void init(Context context, String str, String str2) {
        StartAppSDK.init(context, str, str2);
    }

    public static void setAutoInterstitialPreferences(AutoInterstitialPreferences autoInterstitialPreferences) {
        u6 u6Var = u6.a.f36650a;
        u6Var.f36646b = autoInterstitialPreferences;
        u6Var.f36647c = -1;
        u6Var.f36648d = -1;
    }

    public static void setCommonAdsPreferences(Context context, SDKAdPreferences sDKAdPreferences) {
        Context a2 = ia.a(context);
        if (a2 != null) {
            String str = StartAppSDKInternal.f36218a;
            StartAppSDKInternal.c.f36252a.f36221d = sDKAdPreferences;
            ra.b(a2, "shared_prefs_sdk_ad_prefs", sDKAdPreferences);
        }
    }

    public static void setReturnAdsPreferences(AdPreferences adPreferences2) {
        AdPreferences adPreferences3;
        String str = StartAppSDKInternal.f36218a;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        boolean z2 = !lb.a(startAppSDKInternal.f36238u, adPreferences2);
        if (adPreferences2 != null) {
            adPreferences3 = new AdPreferences(adPreferences2);
        } else {
            adPreferences3 = null;
        }
        startAppSDKInternal.f36238u = adPreferences3;
        if (z2) {
            d8 d8Var = d8.f34354a;
            AdPreferences.Placement placement = AdPreferences.Placement.INAPP_RETURN;
            if (!d8Var.f34358e) {
                synchronized (d8Var.f34355b) {
                    for (j8 next : d8Var.f34355b.values()) {
                        if (next.f34743a == placement) {
                            next.b();
                        }
                    }
                }
            }
        }
    }

    public static void showSplash(Activity activity, Bundle bundle) {
        showSplash(activity, bundle, new SplashConfig());
    }

    public AdRulesResult a(String str, AdPreferences.Placement placement) {
        return AdsCommonMetaData.f36186h.b().a(placement, str);
    }

    public void a(AdPreferences adPreferences2, AdEventListener adEventListener) {
    }

    public void close() {
        wb.a(this.f36173b).a(this.callbackBroadcastReceiver);
        wb.a(this.f36173b).a(new Intent("com.startapp.android.CloseAdActivity"));
    }

    public AdPreferences.Placement f() {
        CacheKey cacheKey;
        AdPreferences.Placement placement = this.placement;
        if (placement != null || (cacheKey = this.adKey) == null || d8.f34354a.a(cacheKey) == null) {
            return placement;
        }
        return ((Ad) d8.f34354a.a(this.adKey)).f();
    }

    public String getAdId() {
        v6 a2 = d8.f34354a.a(this.adKey);
        if (a2 instanceof HtmlAd) {
            return ((HtmlAd) a2).getAdId();
        }
        return null;
    }

    public String getBidToken() {
        v6 a2 = d8.f34354a.a(this.adKey);
        if (a2 instanceof HtmlAd) {
            return lb.a(((HtmlAd) a2).j(), "bidToken", "bidToken");
        }
        return null;
    }

    public Ad.AdState getState() {
        v6 a2 = d8.f34354a.a(this.adKey);
        if (a2 != null) {
            return a2.getState();
        }
        return Ad.AdState.UN_INITIALIZED;
    }

    public boolean isBelowMinCPM() {
        v6 a2 = d8.f34354a.a(this.adKey);
        if (a2 != null) {
            return a2.isBelowMinCPM();
        }
        return false;
    }

    public boolean isNetworkAvailable() {
        return lb.g(this.f36173b);
    }

    public boolean isReady() {
        v6 a2 = d8.f34354a.a(this.adKey);
        if (a2 != null) {
            return a2.isReady();
        }
        return false;
    }

    @Deprecated
    public boolean load(AdPreferences adPreferences2, AdEventListener adEventListener) {
        if (!MetaData.f36379h.b()) {
            if (adEventListener != null) {
                setErrorMessage("serving ads disabled");
                p.a(this.f36173b, adEventListener, (Ad) this);
            }
            return false;
        }
        CacheKey a2 = d8.f34354a.a(this.f36173b, this, this.adMode, adPreferences2, adEventListener);
        this.adKey = a2;
        if (a2 != null) {
            return true;
        }
        return false;
    }

    public void loadAd() {
        loadAd(AdMode.AUTOMATIC, new AdPreferences(), (AdEventListener) null);
    }

    public CacheKey loadSplash(AdPreferences adPreferences2, AdEventListener adEventListener) {
        CacheKey cacheKey;
        d8 d8Var = d8.f34354a;
        Context context = this.f36173b;
        AdPreferences.Placement placement = AdPreferences.Placement.INAPP_SPLASH;
        if (d8Var.a(placement)) {
            cacheKey = d8Var.a(context, this, placement, adPreferences2, adEventListener, false, 0);
        } else {
            cacheKey = null;
        }
        this.adKey = cacheKey;
        return cacheKey;
    }

    public void onBackPressed() {
        showAd("exit_ad");
        String str = StartAppSDKInternal.f36218a;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        startAppSDKInternal.f36224g = false;
        startAppSDKInternal.f36226i = true;
    }

    public void onPause() {
    }

    public void onRestoreInstanceState(Bundle bundle) {
        int i2 = bundle.getInt("AdMode");
        this.adMode = AdMode.AUTOMATIC;
        if (i2 == 1) {
            this.adMode = AdMode.FULLPAGE;
        } else if (i2 == 2) {
            this.adMode = AdMode.OFFERWALL;
        } else if (i2 == 3) {
            this.adMode = AdMode.OVERLAY;
        } else if (i2 == 4) {
            this.adMode = AdMode.REWARDED_VIDEO;
        } else if (i2 == 5) {
            this.adMode = AdMode.VIDEO;
        }
        Serializable serializable = bundle.getSerializable("AdPrefs");
        if (serializable != null) {
            this.adPreferences = (AdPreferences) serializable;
        }
    }

    public void onResume() {
        if (!isReady()) {
            loadAd();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        int ordinal = this.adMode.ordinal();
        int i2 = 1;
        if (ordinal != 1) {
            i2 = 2;
            if (ordinal != 2) {
                i2 = 3;
                if (ordinal == 3) {
                    i2 = 4;
                } else if (ordinal != 5) {
                    i2 = 0;
                }
            }
        }
        AdPreferences adPreferences2 = this.adPreferences;
        if (adPreferences2 != null) {
            bundle.putSerializable("AdPrefs", adPreferences2);
        }
        bundle.putInt("AdMode", i2);
    }

    public void setVideoListener(VideoListener videoListener2) {
        this.videoListener = videoListener2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0166, code lost:
        if (r0 == false) goto L_0x0169;
     */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01e2  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean show(java.lang.String r12, com.startapp.sdk.adsbase.adlisteners.AdDisplayListener r13) {
        /*
            r11 = this;
            android.content.Context r0 = r11.f36173b
            com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r0)
            com.startapp.oe r1 = r0.q()     // Catch:{ all -> 0x0011 }
            r3 = 32768(0x8000, float:4.5918E-41)
            r1.a((int) r3)     // Catch:{ all -> 0x0011 }
            goto L_0x0012
        L_0x0011:
        L_0x0012:
            r6 = 0
            r11.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r6)
            r11.callback = r13
            com.startapp.sdk.adsbase.remoteconfig.MetaData r1 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h
            boolean r1 = r1.b()
            r3 = 0
            if (r1 != 0) goto L_0x002e
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r0 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.SERVING_ADS_DISABLED
            r11.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r0)
            android.content.Context r0 = r11.f36173b
            com.startapp.sdk.adsbase.adlisteners.AdDisplayListener r1 = r11.callback
            com.startapp.p.a((android.content.Context) r0, (com.startapp.sdk.adsbase.adlisteners.AdDisplayListener) r1, (com.startapp.sdk.adsbase.Ad) r11)
            return r3
        L_0x002e:
            com.startapp.sdk.adsbase.cache.CacheKey r1 = r11.adKey
            if (r1 != 0) goto L_0x0039
            com.startapp.sdk.adsbase.StartAppAd$AdMode r1 = r11.adMode
            com.startapp.sdk.adsbase.model.AdPreferences r4 = r11.adPreferences
            r11.loadAd((com.startapp.sdk.adsbase.StartAppAd.AdMode) r1, (com.startapp.sdk.adsbase.model.AdPreferences) r4)
        L_0x0039:
            com.startapp.sdk.adsbase.AdsCommonMetaData r1 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h
            boolean r1 = r1.O()
            r4 = 1
            if (r1 == 0) goto L_0x004d
            android.content.Context r1 = r11.f36173b
            boolean r1 = com.startapp.lb.e((android.content.Context) r1)
            if (r1 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r1 = 0
            goto L_0x004e
        L_0x004d:
            r1 = 1
        L_0x004e:
            if (r1 == 0) goto L_0x017a
            boolean r1 = r11.isNetworkAvailable()
            if (r1 == 0) goto L_0x0174
            boolean r1 = r11.isReady()
            if (r1 == 0) goto L_0x010f
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r1 = r11.f()
            com.startapp.sdk.adsbase.adrules.AdRulesResult r5 = r11.a((java.lang.String) r12, (com.startapp.sdk.adsbase.model.AdPreferences.Placement) r1)
            boolean r7 = r5.b()
            if (r7 == 0) goto L_0x0105
            com.startapp.d8 r7 = com.startapp.d8.f34354a
            com.startapp.sdk.adsbase.cache.CacheKey r8 = r11.adKey
            com.startapp.v6 r7 = r7.c(r8)
            r11.ad = r7
            if (r7 == 0) goto L_0x010a
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r8 = r11.placement
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r9 = com.startapp.sdk.adsbase.model.AdPreferences.Placement.INAPP_SPLASH
            if (r8 != r9) goto L_0x0094
            java.lang.String r8 = com.startapp.sdk.adsbase.StartAppSDKInternal.f36218a
            com.startapp.sdk.adsbase.StartAppSDKInternal r8 = com.startapp.sdk.adsbase.StartAppSDKInternal.c.f36252a
            boolean r10 = r8.f36223f
            if (r10 == 0) goto L_0x008a
            boolean r8 = r8.f36224g
            if (r8 == 0) goto L_0x008a
            r8 = 1
            goto L_0x008b
        L_0x008a:
            r8 = 0
        L_0x008b:
            if (r8 == 0) goto L_0x0094
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r0 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.APP_IN_BACKGROUND
            r11.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r0)
            goto L_0x010a
        L_0x0094:
            boolean r7 = r7.a((java.lang.String) r12)
            if (r7 == 0) goto L_0x00ee
            com.startapp.r7 r8 = com.startapp.r7.f35760a
            com.startapp.q7 r10 = new com.startapp.q7
            r10.<init>(r1, r12)
            r8.a(r10)
            com.startapp.sdk.adsbase.StartAppAd$AdMode r1 = r11.adMode
            if (r1 == 0) goto L_0x00bc
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r1 = r11.placement
            if (r1 == r9) goto L_0x00bc
            com.startapp.sdk.adsbase.model.AdPreferences r1 = r11.adPreferences
            if (r1 == 0) goto L_0x00bd
            com.startapp.sdk.adsbase.model.AdPreferences r8 = new com.startapp.sdk.adsbase.model.AdPreferences
            r8.<init>()
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x00bc
            goto L_0x00bd
        L_0x00bc:
            r4 = 0
        L_0x00bd:
            if (r4 == 0) goto L_0x00fd
            com.startapp.d8 r1 = com.startapp.d8.f34354a
            com.startapp.sdk.adsbase.StartAppAd$AdMode r4 = r11.adMode
            java.lang.String r4 = r1.a((com.startapp.sdk.adsbase.StartAppAd.AdMode) r4)
            com.startapp.x6 r0 = r0.d()
            com.startapp.x6$a r0 = r0.edit()
            r0.a((java.lang.String) r4, (int) r3)
            com.startapp.sdk.adsbase.StartAppAd$AdMode r4 = r11.adMode
            com.startapp.sdk.adsbase.StartAppAd$AdMode r8 = com.startapp.sdk.adsbase.StartAppAd.AdMode.AUTOMATIC
            if (r4 != r8) goto L_0x00ea
            com.startapp.sdk.adsbase.StartAppAd$AdMode r4 = com.startapp.sdk.adsbase.StartAppAd.AdMode.FULLPAGE
            java.lang.String r4 = r1.a((com.startapp.sdk.adsbase.StartAppAd.AdMode) r4)
            r0.a((java.lang.String) r4, (int) r3)
            com.startapp.sdk.adsbase.StartAppAd$AdMode r4 = com.startapp.sdk.adsbase.StartAppAd.AdMode.OFFERWALL
            java.lang.String r1 = r1.a((com.startapp.sdk.adsbase.StartAppAd.AdMode) r4)
            r0.a((java.lang.String) r1, (int) r3)
        L_0x00ea:
            r0.apply()
            goto L_0x00fd
        L_0x00ee:
            com.startapp.v6 r0 = r11.ad
            boolean r1 = r0 instanceof com.startapp.sdk.adsbase.Ad
            if (r1 == 0) goto L_0x00fd
            com.startapp.sdk.adsbase.Ad r0 = (com.startapp.sdk.adsbase.Ad) r0
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r0 = r0.getNotDisplayedReason()
            r11.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r0)
        L_0x00fd:
            com.startapp.sdk.adsbase.StartAppAd$AdMode r0 = r11.adMode
            com.startapp.sdk.adsbase.model.AdPreferences r1 = r11.adPreferences
            r11.loadAd(r0, r1, r6)
            goto L_0x010b
        L_0x0105:
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r0 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.AD_RULES
            r11.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r0)
        L_0x010a:
            r7 = 0
        L_0x010b:
            r8 = r7
            r7 = 0
            goto L_0x0182
        L_0x010f:
            com.startapp.sdk.adsbase.StartAppAd$AdMode r0 = r11.adMode
            com.startapp.sdk.adsbase.StartAppAd$AdMode r1 = com.startapp.sdk.adsbase.StartAppAd.AdMode.REWARDED_VIDEO
            if (r0 == r1) goto L_0x0169
            com.startapp.sdk.adsbase.StartAppAd$AdMode r1 = com.startapp.sdk.adsbase.StartAppAd.AdMode.VIDEO
            if (r0 == r1) goto L_0x0169
            com.startapp.sdk.adsbase.remoteconfig.MetaData r0 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x0165
            com.startapp.sdk.adsbase.AdsCommonMetaData r0 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h
            com.startapp.sdk.adsbase.VideoConfig r0 = r0.G()
            boolean r0 = r0.q()
            if (r0 != 0) goto L_0x012e
            goto L_0x0165
        L_0x012e:
            com.startapp.sdk.adsbase.model.AdPreferences r0 = r11.adPreferences
            if (r0 != 0) goto L_0x0137
            com.startapp.sdk.adsbase.model.AdPreferences r0 = new com.startapp.sdk.adsbase.model.AdPreferences
            r0.<init>()
        L_0x0137:
            com.startapp.sdk.adsbase.Ad$AdType r1 = com.startapp.sdk.adsbase.Ad.AdType.NON_VIDEO
            r0.setType(r1)
            com.startapp.sdk.adsbase.model.AdPreferences$Placement r1 = r11.f()
            com.startapp.d8 r5 = com.startapp.d8.f34354a
            com.startapp.sdk.adsbase.cache.CacheKey r7 = new com.startapp.sdk.adsbase.cache.CacheKey
            r7.<init>(r1, r0)
            com.startapp.v6 r0 = r5.a((com.startapp.sdk.adsbase.cache.CacheKey) r7)
            if (r0 == 0) goto L_0x0165
            boolean r5 = r0.isReady()
            if (r5 == 0) goto L_0x0165
            com.startapp.sdk.adsbase.adrules.AdRulesResult r1 = r11.a((java.lang.String) r12, (com.startapp.sdk.adsbase.model.AdPreferences.Placement) r1)
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x0165
            r0.a((boolean) r4)
            boolean r0 = r0.a((java.lang.String) r12)
            goto L_0x0166
        L_0x0165:
            r0 = 0
        L_0x0166:
            if (r0 == 0) goto L_0x0169
            goto L_0x016a
        L_0x0169:
            r4 = 0
        L_0x016a:
            if (r4 != 0) goto L_0x0171
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r0 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.AD_NOT_READY
            r11.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r0)
        L_0x0171:
            r7 = r4
            r5 = r6
            goto L_0x0181
        L_0x0174:
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r0 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.NETWORK_PROBLEM
            r11.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r0)
            goto L_0x017f
        L_0x017a:
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r0 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.APP_IN_BACKGROUND
            r11.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r0)
        L_0x017f:
            r5 = r6
            r7 = 0
        L_0x0181:
            r8 = 0
        L_0x0182:
            if (r8 != 0) goto L_0x0186
            if (r7 == 0) goto L_0x01e0
        L_0x0186:
            android.content.Context r0 = r11.f36173b
            com.startapp.wb r0 = com.startapp.wb.a((android.content.Context) r0)
            android.content.BroadcastReceiver r1 = r11.callbackBroadcastReceiver
            android.content.IntentFilter r4 = new android.content.IntentFilter
            java.lang.String r9 = "com.startapp.android.HideDisplayBroadcastListener"
            r4.<init>(r9)
            r0.a(r1, r4)
            android.content.Context r0 = r11.f36173b
            com.startapp.wb r0 = com.startapp.wb.a((android.content.Context) r0)
            android.content.BroadcastReceiver r1 = r11.callbackBroadcastReceiver
            android.content.IntentFilter r4 = new android.content.IntentFilter
            java.lang.String r9 = "com.startapp.android.ShowDisplayBroadcastListener"
            r4.<init>(r9)
            r0.a(r1, r4)
            android.content.Context r0 = r11.f36173b
            com.startapp.wb r0 = com.startapp.wb.a((android.content.Context) r0)
            android.content.BroadcastReceiver r1 = r11.callbackBroadcastReceiver
            android.content.IntentFilter r4 = new android.content.IntentFilter
            java.lang.String r9 = "com.startapp.android.ShowFailedDisplayBroadcastListener"
            r4.<init>(r9)
            r0.a(r1, r4)
            android.content.Context r0 = r11.f36173b
            com.startapp.wb r0 = com.startapp.wb.a((android.content.Context) r0)
            android.content.BroadcastReceiver r1 = r11.callbackBroadcastReceiver
            android.content.IntentFilter r4 = new android.content.IntentFilter
            java.lang.String r9 = "com.startapp.android.OnClickCallback"
            r4.<init>(r9)
            r0.a(r1, r4)
            android.content.Context r0 = r11.f36173b
            com.startapp.wb r0 = com.startapp.wb.a((android.content.Context) r0)
            android.content.BroadcastReceiver r1 = r11.callbackBroadcastReceiver
            android.content.IntentFilter r4 = new android.content.IntentFilter
            java.lang.String r9 = "com.startapp.android.OnVideoCompleted"
            r4.<init>(r9)
            r0.a(r1, r4)
        L_0x01e0:
            if (r8 != 0) goto L_0x0256
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r0 = r11.getNotDisplayedReason()
            if (r0 != 0) goto L_0x01ed
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r0 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.INTERNAL_ERROR
            r11.a((com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason) r0)
        L_0x01ed:
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r1 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.NETWORK_PROBLEM
            if (r0 == r1) goto L_0x024b
            com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason r1 = com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason.AD_RULES
            if (r0 == r1) goto L_0x0234
            if (r7 == 0) goto L_0x0213
            android.content.Context r0 = r11.f36173b
            com.startapp.v6 r1 = r11.ad
            if (r1 == 0) goto L_0x01fe
            goto L_0x0206
        L_0x01fe:
            com.startapp.d8 r1 = com.startapp.d8.f34354a
            com.startapp.sdk.adsbase.cache.CacheKey r3 = r11.adKey
            com.startapp.v6 r1 = r1.a((com.startapp.sdk.adsbase.cache.CacheKey) r3)
        L_0x0206:
            java.lang.String[] r1 = com.startapp.o6.a((com.startapp.v6) r1)
            java.lang.String r4 = "AD_NOT_READY_VIDEO_FALLBACK"
            r5 = 0
            r3 = 0
            r2 = r12
            com.startapp.o6.a((android.content.Context) r0, (java.lang.String[]) r1, (java.lang.String) r2, (int) r3, (java.lang.String) r4, (org.json.JSONObject) r5)
            goto L_0x024b
        L_0x0213:
            android.content.Context r1 = r11.f36173b
            com.startapp.v6 r3 = r11.ad
            if (r3 == 0) goto L_0x021a
            goto L_0x0222
        L_0x021a:
            com.startapp.d8 r3 = com.startapp.d8.f34354a
            com.startapp.sdk.adsbase.cache.CacheKey r4 = r11.adKey
            com.startapp.v6 r3 = r3.a((com.startapp.sdk.adsbase.cache.CacheKey) r4)
        L_0x0222:
            java.lang.String[] r3 = com.startapp.o6.a((com.startapp.v6) r3)
            java.lang.String r4 = r0.toString()
            r5 = 0
            r9 = 0
            r0 = r1
            r1 = r3
            r2 = r12
            r3 = r9
            com.startapp.o6.a((android.content.Context) r0, (java.lang.String[]) r1, (java.lang.String) r2, (int) r3, (java.lang.String) r4, (org.json.JSONObject) r5)
            goto L_0x024b
        L_0x0234:
            if (r5 == 0) goto L_0x024b
            android.content.Context r0 = r11.f36173b
            com.startapp.d8 r1 = com.startapp.d8.f34354a
            com.startapp.sdk.adsbase.cache.CacheKey r4 = r11.adKey
            com.startapp.v6 r1 = r1.a((com.startapp.sdk.adsbase.cache.CacheKey) r4)
            java.lang.String[] r1 = com.startapp.o6.a((com.startapp.v6) r1)
            java.lang.String r4 = r5.a()
            com.startapp.o6.a((android.content.Context) r0, (java.lang.String[]) r1, (java.lang.String) r12, (int) r3, (java.lang.String) r4)
        L_0x024b:
            r11.ad = r6
            if (r7 != 0) goto L_0x0256
            android.content.Context r0 = r11.f36173b
            com.startapp.sdk.adsbase.adlisteners.AdDisplayListener r1 = r11.callback
            com.startapp.p.a((android.content.Context) r0, (com.startapp.sdk.adsbase.adlisteners.AdDisplayListener) r1, (com.startapp.sdk.adsbase.Ad) r11)
        L_0x0256:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.StartAppAd.show(java.lang.String, com.startapp.sdk.adsbase.adlisteners.AdDisplayListener):boolean");
    }

    public boolean showAd() {
        return showAd((String) null, (AdDisplayListener) null);
    }

    public static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig) {
        showSplash(activity, bundle, splashConfig, new AdPreferences());
    }

    public void loadAd(AdPreferences adPreferences2) {
        loadAd(AdMode.AUTOMATIC, adPreferences2, (AdEventListener) null);
    }

    public boolean showAd(String str) {
        return showAd(str, (AdDisplayListener) null);
    }

    public static void a(Activity activity, Bundle bundle, SplashConfig splashConfig, AdPreferences adPreferences2, SplashHideListener splashHideListener, boolean z2) {
        if (activity != null && bundle == null && MetaData.f36379h.b() && lb.e((Context) activity) && ComponentLocator.a((Context) activity).c().a()) {
            try {
                String str = StartAppSDKInternal.f36218a;
                StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
                if (!(!startAppSDKInternal.f36242y) && z2) {
                    startAppSDKInternal.f36242y = false;
                }
                startAppSDKInternal.f36241x = z2;
                if (!z2) {
                    if (adPreferences2 == null) {
                        adPreferences2 = new AdPreferences();
                    }
                    adPreferences2.setAs(Boolean.TRUE);
                }
                splashConfig.setDefaults(activity);
                lb.a(activity, activity.getResources().getConfiguration().orientation, true);
                Intent intent = new Intent(activity, OverlayActivity.class);
                intent.putExtra("SplashConfig", splashConfig);
                intent.putExtra("AdPreference", adPreferences2);
                intent.putExtra("testMode", false);
                intent.putExtra(Constants.TEMPLATE_TYPE_FULLSCREEN, o6.a(activity));
                intent.putExtra("placement", AdPreferences.Placement.INAPP_SPLASH.a());
                intent.addFlags(32768 | 67108864 | 1073741824);
                activity.startActivity(intent);
                wb.a((Context) activity).a(new b(activity, splashHideListener), new IntentFilter("com.startapp.android.splashHidden"));
            } catch (Throwable th) {
                y8.a((Context) activity, th);
                if (splashHideListener != null) {
                    splashHideListener.splashHidden();
                }
            }
        }
    }

    public static void showSplash(Activity activity, Bundle bundle, AdPreferences adPreferences2) {
        showSplash(activity, bundle, new SplashConfig(), adPreferences2);
    }

    public void loadAd(AdEventListener adEventListener) {
        loadAd(AdMode.AUTOMATIC, new AdPreferences(), adEventListener);
    }

    public boolean showAd(AdDisplayListener adDisplayListener) {
        return showAd((String) null, adDisplayListener);
    }

    public static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig, AdPreferences adPreferences2) {
        showSplash(activity, bundle, splashConfig, adPreferences2, (SplashHideListener) null);
    }

    public void loadAd(AdPreferences adPreferences2, AdEventListener adEventListener) {
        loadAd(AdMode.AUTOMATIC, adPreferences2, adEventListener);
    }

    public boolean showAd(String str, AdDisplayListener adDisplayListener) {
        try {
            return show(str, adDisplayListener);
        } catch (Throwable th) {
            y8.a(this.f36173b, th);
            a(NotDisplayedReason.INTERNAL_ERROR);
            p.a(this.f36173b, this.callback, (Ad) null);
            return false;
        }
    }

    public static void onBackPressed(Context context) {
        new StartAppAd(context).onBackPressed();
    }

    public static void showSplash(Activity activity, Bundle bundle, SplashConfig splashConfig, AdPreferences adPreferences2, SplashHideListener splashHideListener) {
        a(activity, bundle, splashConfig, adPreferences2, splashHideListener, true);
    }

    public void loadAd(AdMode adMode2) {
        loadAd(adMode2, new AdPreferences(), (AdEventListener) null);
    }

    public void loadAd(AdMode adMode2, AdPreferences adPreferences2) {
        loadAd(adMode2, adPreferences2, (AdEventListener) null);
    }

    public void loadAd(AdMode adMode2, AdEventListener adEventListener) {
        loadAd(adMode2, new AdPreferences(), adEventListener);
    }

    public static boolean showAd(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return new StartAppAd(context).showAd();
        } catch (Throwable th) {
            y8.a(context, th);
            return false;
        }
    }

    public void loadAd(AdMode adMode2, AdPreferences adPreferences2, AdEventListener adEventListener) {
        try {
            ComponentLocator.a(this.f36173b).q().a((int) Http2.INITIAL_MAX_FRAME_SIZE);
        } catch (Throwable unused) {
        }
        this.adMode = adMode2;
        this.adPreferences = adPreferences2;
        try {
            load(adPreferences2, adEventListener);
        } catch (Throwable th) {
            y8.a(this.f36173b, th);
            if (adEventListener != null) {
                p.a(this.f36173b, adEventListener, (Ad) this);
            }
        }
    }

    @Deprecated
    public boolean show() {
        return show((String) null, (AdDisplayListener) null);
    }
}
