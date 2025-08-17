package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.startapp.sdk.ads.interstitials.ReturnAd;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.ads.splash.SplashHideListener;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AutoInterstitialPreferences;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.adrules.AdRules;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.u6;
import java.util.Map;

public final class g7 extends oa {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        startAppSDKInternal.getClass();
        boolean z6 = true;
        if (activity.getClass().getName().equals(lb.c((Context) activity))) {
            startAppSDKInternal.A = true;
        }
        startAppSDKInternal.f36237t = bundle;
        u6 u6Var = u6.a.f36650a;
        boolean equals = activity.getClass().getName().equals(lb.c((Context) activity));
        if (bundle == null) {
            String[] split = u6.class.getName().split("\\.");
            if (split.length < 3) {
                z2 = false;
            } else {
                z2 = activity.getClass().getName().startsWith(split[0] + "." + split[1] + "." + split[2]);
            }
            if (!z2 && !equals) {
                u6Var.f36648d++;
                if (!u6Var.f36645a || !AdsCommonMetaData.f36186h.I()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    if (u6Var.f36646b == null) {
                        u6Var.f36646b = new AutoInterstitialPreferences();
                    }
                    if (u6Var.f36647c <= 0 || System.currentTimeMillis() >= u6Var.f36647c + ((long) (u6Var.f36646b.getSecondsBetweenAds() * 1000))) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    int i2 = u6Var.f36648d;
                    if (i2 <= 0 || i2 >= u6Var.f36646b.getActivitiesBetweenAds()) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z4 || !z5) {
                        z6 = false;
                    }
                    if (z6) {
                        if (u6Var.f36649e == null) {
                            u6Var.f36649e = new StartAppAd(activity);
                        }
                        u6Var.f36649e.loadAd(StartAppAd.AdMode.AUTOMATIC, new AdPreferences().setAi(Boolean.TRUE), new t6(u6Var));
                    }
                }
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        if (startAppSDKInternal.a(activity)) {
            startAppSDKInternal.f36243z = false;
        }
        if (startAppSDKInternal.f36229l.size() == 0) {
            startAppSDKInternal.f36224g = false;
        }
    }

    public void onActivityPaused(Activity activity) {
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        startAppSDKInternal.getClass();
        startAppSDKInternal.f36227j = System.currentTimeMillis();
        startAppSDKInternal.f36231n = null;
    }

    public void onActivityResumed(Activity activity) {
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        if (startAppSDKInternal.f36222e && startAppSDKInternal.f36225h) {
            startAppSDKInternal.f36225h = false;
            d8 d8Var = d8.f34354a;
            if (!d8Var.f34358e) {
                synchronized (d8Var.f34355b) {
                    for (j8 b2 : d8Var.f34355b.values()) {
                        b2.b();
                    }
                }
            }
        }
        if (startAppSDKInternal.f36232o) {
            startAppSDKInternal.f36232o = false;
            SimpleTokenUtils.f(activity);
        }
        startAppSDKInternal.f36231n = activity;
    }

    public void onActivityStarted(Activity activity) {
        boolean z2;
        boolean z3;
        boolean z4;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        startAppSDKInternal.getClass();
        activity.getClass();
        boolean a2 = startAppSDKInternal.a(activity);
        if (!startAppSDKInternal.f36243z && a2 && startAppSDKInternal.f36237t == null && startAppSDKInternal.f36229l.size() == 0 && StartAppSDKInternal.f36220c == StartAppSDKInternal.InitState.EXPLICIT) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            ComponentLocator.a((Context) activity).f().a(false, (String) null, (String) null, (String) null);
        }
        Map<Activity, Integer> map = lb.f34876a;
        if (!ComponentLocator.a((Context) activity).f().f35854d && !AdsCommonMetaData.f36186h.L() && !startAppSDKInternal.f36242y && !startAppSDKInternal.a("MoPub") && !startAppSDKInternal.a("AdMob") && !startAppSDKInternal.f36241x && z2) {
            StartAppAd.a(activity, startAppSDKInternal.f36237t, new SplashConfig(), new AdPreferences(), (SplashHideListener) null, false);
        }
        if (a2) {
            startAppSDKInternal.A = false;
            startAppSDKInternal.f36243z = true;
        }
        if (startAppSDKInternal.f36224g) {
            if (MetaData.f36379h.b() && startAppSDKInternal.f36240w && !AdsCommonMetaData.f36186h.K() && !startAppSDKInternal.f36234q) {
                if (System.currentTimeMillis() - startAppSDKInternal.f36227j > AdsCommonMetaData.f36186h.x()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    v6 c2 = d8.f34354a.c(startAppSDKInternal.f36239v);
                    startAppSDKInternal.B = c2;
                    if (c2 != null && c2.isReady()) {
                        AdRules b2 = AdsCommonMetaData.f36186h.b();
                        AdPreferences.Placement placement = AdPreferences.Placement.INAPP_RETURN;
                        AdRulesResult a3 = b2.a(placement, (String) null);
                        if (!a3.b()) {
                            o6.a((Context) activity, ((ReturnAd) startAppSDKInternal.B).trackingUrls, (String) null, 0, a3.a());
                        } else if (startAppSDKInternal.B.a((String) null)) {
                            r7.f35760a.a(new q7(placement, (String) null));
                        }
                    }
                }
            }
            if (System.currentTimeMillis() - startAppSDKInternal.f36227j > MetaData.f36379h.D()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                startAppSDKInternal.b(activity, MetaDataRequest.RequestReason.APP_IDLE);
            }
        }
        startAppSDKInternal.f36226i = false;
        startAppSDKInternal.f36224g = false;
        if (startAppSDKInternal.f36229l.get(Integer.valueOf(activity.hashCode())) == null) {
            startAppSDKInternal.f36229l.put(Integer.valueOf(activity.hashCode()), Integer.valueOf(new Integer(0).intValue() + 1));
        }
    }

    public void onActivityStopped(Activity activity) {
        boolean z2;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.c.f36252a;
        Integer num = startAppSDKInternal.f36229l.get(Integer.valueOf(activity.hashCode()));
        if (num != null) {
            Integer valueOf = Integer.valueOf(num.intValue() - 1);
            if (valueOf.intValue() == 0) {
                startAppSDKInternal.f36229l.remove(Integer.valueOf(activity.hashCode()));
            } else {
                startAppSDKInternal.f36229l.put(Integer.valueOf(activity.hashCode()), valueOf);
            }
            if (startAppSDKInternal.f36229l.size() == 0) {
                if (!startAppSDKInternal.f36226i) {
                    startAppSDKInternal.f36224g = true;
                    startAppSDKInternal.e(activity);
                }
                if (startAppSDKInternal.f36222e) {
                    Context b2 = ia.b(activity);
                    d8 d8Var = d8.f34354a;
                    boolean z3 = startAppSDKInternal.f36226i;
                    d8Var.getClass();
                    try {
                        if (d8Var.f34357d || !CacheMetaData.f36308a.a().f()) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            ComponentLocator.a(b2).h().execute(new b8(d8Var, b2));
                        }
                        d8Var.a(z3);
                    } catch (Throwable th) {
                        y8.a(b2, th);
                    }
                    startAppSDKInternal.f36225h = true;
                }
            }
        }
    }
}
