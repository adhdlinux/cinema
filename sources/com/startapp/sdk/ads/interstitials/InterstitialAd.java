package com.startapp.sdk.ads.interstitials;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.react.uimanager.ViewProps;
import com.startapp.lb;
import com.startapp.o6;
import com.startapp.s8;
import com.startapp.sdk.ads.splash.SplashAd;
import com.startapp.sdk.adsbase.ActivityExtra;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.VideoConfig;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.v6;
import com.startapp.y8;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import com.vungle.ads.internal.Constants;
import java.util.Map;

public abstract class InterstitialAd extends HtmlAd implements v6 {
    private static final long serialVersionUID = -8158520010577551438L;

    public InterstitialAd(Context context, AdPreferences.Placement placement) {
        super(context, placement);
    }

    /* JADX WARNING: type inference failed for: r11v7, types: [java.lang.Boolean[], java.io.Serializable] */
    public boolean a(String str) {
        String a2 = o6.a();
        if (!u() || !AdsCommonMetaData.f36186h.G().a().equals(VideoConfig.BackMode.DISABLED) || !a2.equals("back")) {
            if (!AdsConstants.f36193g.booleanValue()) {
                setState(Ad.AdState.UN_INITIALIZED);
            }
            if (j() == null) {
                a(NotDisplayedReason.INTERNAL_ERROR);
                return false;
            } else if (super.d()) {
                a(NotDisplayedReason.AD_EXPIRED);
                return false;
            } else {
                ActivityExtra activityExtra = this.activityExtra;
                boolean z2 = activityExtra != null && activityExtra.a();
                Intent intent = new Intent(this.f36173b, OverlayActivity.class);
                intent.putExtra("fileUrl", "exit.html");
                String[] strArr = this.trackingUrls;
                String str2 = "&position=" + o6.a();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    String str3 = strArr[i2];
                    if (str3 != null && !"".equals(str3)) {
                        strArr[i2] = strArr[i2] + str2;
                    }
                }
                intent.putExtra("tracking", strArr);
                intent.putExtra("trackingClickUrl", o());
                intent.putExtra("packageNames", m());
                intent.putExtra("htmlUuid", k());
                intent.putExtra("smartRedirect", this.smartRedirect);
                intent.putExtra("browserEnabled", this.inAppBrowserEnabled);
                intent.putExtra("placement", this.placement.a());
                intent.putExtra("adInfoOverride", getAdInfoOverride());
                intent.putExtra("ad", this);
                intent.putExtra("videoAd", u());
                intent.putExtra(Constants.TEMPLATE_TYPE_FULLSCREEN, z2);
                intent.putExtra(AdUnitActivity.EXTRA_ORIENTATION, l() == 0 ? this.f36173b.getResources().getConfiguration().orientation : l());
                intent.putExtra("adTag", str);
                intent.putExtra("lastLoadTime", super.b());
                intent.putExtra("adCacheTtl", super.c());
                intent.putExtra("closingUrl", g());
                intent.putExtra("rewardDuration", n());
                intent.putExtra("rewardedHideTimer", s());
                if (h() != null) {
                    intent.putExtra("delayImpressionSeconds", h());
                }
                intent.putExtra("sendRedirectHops", t());
                intent.putExtra("mraidAd", r());
                if (r()) {
                    intent.putExtra("activityShouldLockOrientation", false);
                }
                Map<Activity, Integer> map = lb.f34876a;
                if (this instanceof SplashAd) {
                    intent.putExtra("isSplash", true);
                }
                intent.putExtra(ViewProps.POSITION, a2);
                intent.addFlags(343932928);
                s8 f2 = ComponentLocator.a(this.f36173b).f();
                if (f2.f35854d) {
                    f2.f35853c = intent;
                } else {
                    try {
                        this.f36173b.startActivity(intent);
                    } catch (Throwable th) {
                        y8.a(this.f36173b, th);
                        return false;
                    }
                }
                return true;
            }
        } else {
            a(NotDisplayedReason.VIDEO_BACK);
            return false;
        }
    }

    public Long b() {
        return super.b();
    }

    public Long c() {
        return super.c();
    }

    public boolean d() {
        return super.d();
    }

    public boolean u() {
        return false;
    }

    public boolean a() {
        return super.a();
    }

    public void a(boolean z2) {
        super.a(z2);
    }
}
