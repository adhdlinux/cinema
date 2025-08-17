package com.startapp.sdk.adsbase.model;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.util.Pair;
import com.startapp.eb;
import com.startapp.fc;
import com.startapp.ha;
import com.startapp.hb;
import com.startapp.hc;
import com.startapp.lb;
import com.startapp.q6;
import com.startapp.r7;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.SDKAdPreferences;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.common.SDKException;
import com.startapp.sdk.components.ComponentLocator;
import com.vungle.ads.internal.model.AdPayload;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GetAdRequest extends q6 {
    public Set<String> A0 = null;
    public Set<String> B0 = null;
    public Set<String> C0 = null;
    public Set<String> D0 = null;
    public Pair<String, String> E0;
    public boolean F0 = true;
    public long G0 = (System.currentTimeMillis() - hb.f34639a.b());
    public int H0;
    public String I0;
    public String J0;
    public String K0;
    public boolean L0;
    public Boolean M0;
    public Boolean N0;
    public String O0;
    public String P0 = null;
    public String Q0 = null;
    public Ad.AdType R0 = null;

    /* renamed from: h0  reason: collision with root package name */
    public AdPreferences.Placement f36334h0;

    /* renamed from: i0  reason: collision with root package name */
    public boolean f36335i0;

    /* renamed from: j0  reason: collision with root package name */
    public Integer f36336j0;

    /* renamed from: k0  reason: collision with root package name */
    public Long f36337k0;

    /* renamed from: l0  reason: collision with root package name */
    public Boolean f36338l0;

    /* renamed from: m0  reason: collision with root package name */
    public SDKAdPreferences.Gender f36339m0;

    /* renamed from: n0  reason: collision with root package name */
    public String f36340n0;

    /* renamed from: o0  reason: collision with root package name */
    public String f36341o0;

    /* renamed from: p0  reason: collision with root package name */
    public int f36342p0 = 1;

    /* renamed from: q0  reason: collision with root package name */
    public boolean f36343q0 = true;

    /* renamed from: r0  reason: collision with root package name */
    public Boolean f36344r0;

    /* renamed from: s0  reason: collision with root package name */
    public boolean f36345s0 = AdsCommonMetaData.k().M();

    /* renamed from: t0  reason: collision with root package name */
    public Double f36346t0;

    /* renamed from: u0  reason: collision with root package name */
    public String f36347u0;

    /* renamed from: v0  reason: collision with root package name */
    public String f36348v0;

    /* renamed from: w0  reason: collision with root package name */
    public Integer f36349w0;

    /* renamed from: x0  reason: collision with root package name */
    public boolean f36350x0 = true;

    /* renamed from: y0  reason: collision with root package name */
    public int f36351y0 = 0;

    /* renamed from: z0  reason: collision with root package name */
    public Set<String> f36352z0 = null;

    public enum VideoRequestMode {
        INTERSTITIAL,
        REWARDED
    }

    public enum VideoRequestType {
        ENABLED,
        DISABLED,
        FORCED,
        FORCED_NONVAST
    }

    public GetAdRequest() {
        super(4);
        Map<Activity, Integer> map = lb.f34876a;
        this.H0 = r7.a().b();
        this.I0 = MetaData.r().z();
    }

    public void a(Context context, AdPreferences adPreferences, AdPreferences.Placement placement, Pair<String, String> pair) {
        this.f36334h0 = placement;
        this.E0 = pair;
        this.M0 = adPreferences.getAi();
        this.N0 = adPreferences.getAs();
        this.f36339m0 = adPreferences.getGender(context);
        this.f36340n0 = adPreferences.getKeywords();
        this.f36335i0 = adPreferences.isTestMode();
        this.f36352z0 = adPreferences.getCategories();
        this.A0 = adPreferences.getCategoriesExclude();
        this.f36343q0 = adPreferences.b();
        this.f36349w0 = adPreferences.a();
        int i2 = hc.f34643a;
        boolean z2 = false;
        if (Settings.Global.getInt(context.getContentResolver(), "auto_time", 0) > 0) {
            z2 = true;
        }
        this.f36344r0 = Boolean.valueOf(z2);
        this.f36346t0 = adPreferences.getMinCpm();
        this.f36347u0 = adPreferences.getAdTag();
        Object obj = MetaData.f36372a;
        this.f36350x0 = !context.getFileStreamPath("StartappMetadata").exists();
        this.P0 = adPreferences.country;
        this.Q0 = adPreferences.advertiserId;
        this.f36341o0 = adPreferences.template;
        this.R0 = adPreferences.type;
        this.f35653c = adPreferences.getCustomProductId();
        this.C0 = adPreferences.packageInclude;
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        Ad.AdType adType = this.R0;
        if (adType == Ad.AdType.VIDEO || adType == Ad.AdType.REWARDED_VIDEO) {
            return true;
        }
        return false;
    }

    public void f(Context context) {
        String str;
        ha r2 = ComponentLocator.a(context).r();
        AdPreferences.Placement placement = this.f36334h0;
        r2.getClass();
        if (placement == null) {
            str = null;
        } else {
            str = r2.f34636a.get(new ha.a(placement, -1));
        }
        this.f36348v0 = str;
    }

    public void a(eb ebVar) throws SDKException {
        String str;
        super.a(ebVar);
        ebVar.a("placement", (Object) this.f36334h0.name(), true, true);
        ebVar.a("testMode", (Object) Boolean.toString(this.f36335i0), false, true);
        ebVar.a("gender", (Object) this.f36339m0, false, true);
        ebVar.a("keywords", (Object) this.f36340n0, false, true);
        ebVar.a(AdPayload.KEY_TEMPLATE, (Object) this.f36341o0, false, true);
        ebVar.a("adsNumber", (Object) Integer.toString(this.f36342p0), false, true);
        ebVar.a("category", this.f36352z0, false, true);
        ebVar.a("categoryExclude", this.A0, false, true);
        ebVar.a("packageExclude", this.B0, false, true);
        ebVar.a("campaignExclude", this.D0, false, true);
        ebVar.a("offset", (Object) Integer.toString(this.f36351y0), false, true);
        ebVar.a("ai", (Object) this.M0, false, true);
        ebVar.a("as", (Object) this.N0, false, true);
        Double d2 = this.f36346t0;
        Map<Activity, Integer> map = lb.f34876a;
        Boolean bool = null;
        if (d2 != null) {
            str = String.format(Locale.US, "%.2f", new Object[]{d2});
        } else {
            str = null;
        }
        ebVar.a("minCPM", (Object) str, false, true);
        ebVar.a("adTag", (Object) this.f36347u0, false, true);
        ebVar.a("previousAdId", (Object) this.f36348v0, false, true);
        ebVar.a("twoClicks", (Object) Boolean.valueOf(!this.f36345s0), false, true);
        ebVar.a("engInclude", (Object) Boolean.toString(this.F0), false, true);
        Ad.AdType adType = this.R0;
        if (adType == Ad.AdType.INTERSTITIAL || adType == Ad.AdType.RICH_TEXT) {
            ebVar.a("type", (Object) adType, false, true);
        }
        ebVar.a("timeSinceSessionStart", (Object) Long.valueOf(this.G0), true, true);
        ebVar.a("adsDisplayed", (Object) Integer.valueOf(this.H0), true, true);
        ebVar.a("profileId", (Object) this.I0, false, true);
        ebVar.a("hardwareAccelerated", (Object) Boolean.valueOf(this.f36343q0), false, true);
        ebVar.a("autoLoadAmount", (Object) this.f36349w0, false, true);
        ebVar.a("dts", (Object) this.f36344r0, false, true);
        ebVar.a("downloadingMode", (Object) "CACHE", false, true);
        ebVar.a("primaryImg", (Object) this.J0, false, true);
        ebVar.a("moreImg", (Object) this.K0, false, true);
        ebVar.a("contentAd", (Object) Boolean.toString(this.L0), false, true);
        ebVar.a("ct", (Object) this.f36336j0, false, true);
        ebVar.a("tsc", (Object) this.f36337k0, false, true);
        ebVar.a("apc", (Object) this.f36338l0, false, true);
        String str2 = StartAppSDKInternal.f36218a;
        if (StartAppSDKInternal.c.f36252a.F) {
            bool = Boolean.TRUE;
        }
        ebVar.a("testAdsEnabled", (Object) bool, false, true);
        String a2 = fc.a();
        ebVar.a(fc.f34530b, (Object) a2, true, true);
        String str3 = fc.f34532d;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f35653c);
        sb.append(this.f36334h0.name());
        String str4 = this.R;
        if (str4 == null) {
            str4 = "";
        }
        sb.append(str4);
        sb.append(this.f35655d);
        sb.append(a2);
        ebVar.a(str3, (Object) fc.a(sb.toString()), true, false);
        String str5 = this.P0;
        if (str5 != null) {
            ebVar.a("country", (Object) str5, false, true);
        }
        String str6 = this.Q0;
        if (str6 != null) {
            ebVar.a("advertiserId", (Object) str6, false, true);
        }
        Set<String> set = this.C0;
        if (set != null) {
            ebVar.a("packageInclude", set, false, true);
        }
        ebVar.a("defaultMetaData", (Object) Boolean.valueOf(this.f36350x0), true, true);
        Pair<String, String> pair = this.E0;
        ebVar.a((String) pair.first, pair.second, false, true);
        String str7 = this.O0;
        if (str7 != null) {
            ebVar.a("trv", (Object) str7, false, false);
        }
    }
}
