package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.content.Context;
import com.startapp.da;
import com.startapp.hb;
import com.startapp.lb;
import com.startapp.p;
import com.startapp.sdk.adsbase.adinformation.AdInformationOverrides;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.consent.ConsentData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.ComponentLocator;
import java.io.Serializable;
import java.util.Map;

public abstract class Ad implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f36172a = false;
    private static final long serialVersionUID = 1;
    public ActivityExtra activityExtra;
    public Long adCacheTtl = null;
    private AdInformationOverrides adInfoOverride;

    /* renamed from: b  reason: collision with root package name */
    public transient Context f36173b;
    public boolean belowMinCPM = false;
    public ConsentData consentData;
    public String errorMessage;
    public Serializable extraData = null;
    private Long lastLoadTime = null;
    private NotDisplayedReason notDisplayedReason;
    public AdPreferences.Placement placement;
    private AdState state = AdState.UN_INITIALIZED;
    private AdType type;
    private boolean videoCancelCallBack;

    public enum AdState {
        UN_INITIALIZED,
        PROCESSING,
        READY
    }

    public enum AdType {
        INTERSTITIAL,
        RICH_TEXT,
        VIDEO,
        REWARDED_VIDEO,
        NON_VIDEO,
        VIDEO_NO_VAST
    }

    public class a implements AdEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdEventListener f36174a;

        public a(AdEventListener adEventListener) {
            this.f36174a = adEventListener;
        }

        public void onFailedToReceiveAd(Ad ad) {
            String str;
            p.a(Ad.this.f36173b, this.f36174a, ad);
            if (ad != null) {
                str = ad.getErrorMessage();
            } else {
                str = null;
            }
            String str2 = "";
            if (str == null) {
                str = str2;
            } else if (str.contains("204")) {
                str = "NO FILL";
            }
            Context context = Ad.this.f36173b;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to load ");
            if (ad != null) {
                str2 = lb.a(ad);
            }
            sb.append(str2);
            sb.append(" ad: ");
            sb.append(str);
            lb.a(context, true, sb.toString(), true);
        }

        public void onReceiveAd(Ad ad) {
            Ad.a(Ad.this, Long.valueOf(System.currentTimeMillis()));
            p.b(Ad.this.f36173b, this.f36174a, ad);
            ConsentData consentData = ad.getConsentData();
            if (consentData != null) {
                ComponentLocator.a(Ad.this.f36173b).f().a(consentData.f(), consentData.e(), consentData.a(), false, true);
            }
            Context context = Ad.this.f36173b;
            lb.a(context, false, "Loaded " + lb.a(ad) + " ad with creative ID - " + ad.getAdId(), true);
        }
    }

    public class b implements da {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdPreferences f36176a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AdEventListener f36177b;

        public b(AdPreferences adPreferences, AdEventListener adEventListener) {
            this.f36176a = adPreferences;
            this.f36177b = adEventListener;
        }

        public void a(MetaDataRequest.RequestReason requestReason, boolean z2) {
            Ad.this.a(this.f36176a, this.f36177b);
        }

        public void a(MetaDataRequest.RequestReason requestReason) {
            Ad.this.a(this.f36176a, this.f36177b);
        }
    }

    public Ad(Context context, AdPreferences.Placement placement2) {
        this.f36173b = context;
        this.placement = placement2;
        Map<Activity, Integer> map = lb.f34876a;
        this.adInfoOverride = AdInformationOverrides.a();
    }

    public void a(NotDisplayedReason notDisplayedReason2) {
        this.notDisplayedReason = notDisplayedReason2;
    }

    public abstract void a(AdPreferences adPreferences, AdEventListener adEventListener);

    public Long b() {
        return this.lastLoadTime;
    }

    public Long c() {
        long e2 = e();
        Long l2 = this.adCacheTtl;
        if (l2 != null) {
            e2 = Math.min(l2.longValue(), e2);
        }
        return Long.valueOf(e2);
    }

    public boolean d() {
        if (this.lastLoadTime != null && System.currentTimeMillis() - this.lastLoadTime.longValue() > c().longValue()) {
            return true;
        }
        return false;
    }

    public long e() {
        return CacheMetaData.f36308a.a().a();
    }

    public AdPreferences.Placement f() {
        return this.placement;
    }

    public abstract String getAdId();

    public AdInformationOverrides getAdInfoOverride() {
        return this.adInfoOverride;
    }

    public abstract String getBidToken();

    public final ConsentData getConsentData() {
        return this.consentData;
    }

    public Context getContext() {
        return this.f36173b;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Serializable getExtraData() {
        return this.extraData;
    }

    public NotDisplayedReason getNotDisplayedReason() {
        return this.notDisplayedReason;
    }

    public AdState getState() {
        return this.state;
    }

    public AdType getType() {
        return this.type;
    }

    public boolean isBelowMinCPM() {
        return this.belowMinCPM;
    }

    public boolean isReady() {
        return this.state == AdState.READY && !d();
    }

    @Deprecated
    public boolean load() {
        return load(new AdPreferences(), (AdEventListener) null);
    }

    public void setActivityExtra(ActivityExtra activityExtra2) {
        this.activityExtra = activityExtra2;
    }

    public void setAdInfoOverride(AdInformationOverrides adInformationOverrides) {
        this.adInfoOverride = adInformationOverrides;
    }

    public void setContext(Context context) {
        this.f36173b = context;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setExtraData(Serializable serializable) {
        this.extraData = serializable;
    }

    public void setState(AdState adState) {
        this.state = adState;
    }

    @Deprecated
    public boolean show() {
        return false;
    }

    public static void a(Ad ad, Long l2) {
        ad.lastLoadTime = l2;
    }

    @Deprecated
    public boolean load(AdEventListener adEventListener) {
        return load(new AdPreferences(), adEventListener);
    }

    public boolean a() {
        return this.videoCancelCallBack;
    }

    @Deprecated
    public boolean load(AdPreferences adPreferences) {
        return load(adPreferences, (AdEventListener) null);
    }

    public void a(boolean z2) {
        this.videoCancelCallBack = z2;
    }

    @Deprecated
    public boolean load(AdPreferences adPreferences, AdEventListener adEventListener) {
        return load(adPreferences, adEventListener, true);
    }

    public boolean load(AdPreferences adPreferences, AdEventListener adEventListener, boolean z2) {
        String str;
        boolean z3;
        a aVar = new a(adEventListener);
        if (!f36172a) {
            SimpleTokenUtils.f(this.f36173b);
            f36172a = true;
        }
        if (this.state != AdState.UN_INITIALIZED) {
            str = "load() was already called.";
            z3 = true;
        } else {
            str = "";
            z3 = false;
        }
        if (!lb.g(this.f36173b)) {
            str = "network not available.";
            z3 = true;
        }
        if (!MetaData.f36379h.b()) {
            str = "serving ads disabled";
            z3 = true;
        }
        if (z3) {
            setErrorMessage("Ad wasn't loaded: " + str);
            p.a(this.f36173b, (AdEventListener) aVar, this);
            return false;
        }
        setState(AdState.PROCESSING);
        b bVar = new b(adPreferences, aVar);
        if (adPreferences.getType() != null) {
            this.type = adPreferences.getType();
        }
        MetaData.f36379h.a(this.f36173b, adPreferences, hb.f34639a.f34642d, z2, bVar, false);
        return true;
    }
}
