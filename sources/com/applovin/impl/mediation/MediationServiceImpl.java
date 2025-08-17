package com.applovin.impl.mediation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.a.c;
import com.applovin.impl.mediation.a.e;
import com.applovin.impl.mediation.a.g;
import com.applovin.impl.mediation.a.h;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.c.d;
import com.applovin.impl.mediation.c.f;
import com.applovin.impl.mediation.c.g;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class MediationServiceImpl implements AppLovinBroadcastManager.Receiver {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f14186a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final v f14187b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<JSONObject> f14188c = new AtomicReference<>();

    public class a implements a.C0011a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {

        /* renamed from: b  reason: collision with root package name */
        private final com.applovin.impl.mediation.a.a f14210b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public a.C0011a f14211c;

        public a(com.applovin.impl.mediation.a.a aVar, a.C0011a aVar2) {
            this.f14210b = aVar;
            this.f14211c = aVar2;
        }

        public void a(a.C0011a aVar) {
            this.f14211c = aVar;
        }

        public void a(MaxAd maxAd, Bundle bundle) {
            this.f14210b.r();
            this.f14210b.a(bundle);
            MediationServiceImpl.this.a(this.f14210b);
            j.a((MaxAdListener) this.f14211c, maxAd);
        }

        public void b(MaxAd maxAd, Bundle bundle) {
            if (v.a()) {
                MediationServiceImpl.this.f14187b.b("MediationService", "Scheduling impression for ad via callback...");
            }
            MediationServiceImpl.this.processCallbackAdImpressionPostback(this.f14210b, this.f14211c);
            this.f14210b.a(bundle);
            MediationServiceImpl.this.f14186a.ag().a(this.f14210b, "DID_DISPLAY");
            if (maxAd.getFormat().isFullscreenAd()) {
                MediationServiceImpl.this.f14186a.ae().a((Object) maxAd);
                MediationServiceImpl.this.f14186a.ak().a((Object) maxAd);
            }
            j.b((MaxAdListener) this.f14211c, maxAd);
        }

        public void c(final MaxAd maxAd, Bundle bundle) {
            if (bundle != null && bundle.size() > 0) {
                ((com.applovin.impl.mediation.a.a) maxAd).a(BundleUtils.toJSONObject(bundle.getBundle(Utils.KEY_AD_VALUES)));
            }
            MediationServiceImpl.this.f14186a.ag().a((com.applovin.impl.mediation.a.a) maxAd, "DID_HIDE");
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    if (maxAd.getFormat().isFullscreenAd()) {
                        MediationServiceImpl.this.f14186a.ae().b((Object) maxAd);
                        MediationServiceImpl.this.f14186a.ak().a();
                    }
                    j.c(a.this.f14211c, maxAd);
                }
            }, maxAd instanceof c ? ((c) maxAd).A() : 0);
        }

        public void d(MaxAd maxAd, Bundle bundle) {
            if (bundle != null && bundle.size() > 0) {
                ((com.applovin.impl.mediation.a.a) maxAd).a(BundleUtils.toJSONObject(bundle.getBundle(Utils.KEY_AD_VALUES)));
            }
            MediationServiceImpl.this.a(this.f14210b, this.f14211c);
            j.d(this.f14211c, maxAd);
        }

        public void onAdClicked(MaxAd maxAd) {
            d(maxAd, (Bundle) null);
        }

        public void onAdCollapsed(MaxAd maxAd) {
            j.h(this.f14211c, maxAd);
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            MediationServiceImpl.this.b(this.f14210b, maxError, this.f14211c);
            if ((maxAd.getFormat() == MaxAdFormat.REWARDED || maxAd.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) && (maxAd instanceof c)) {
                ((c) maxAd).F();
            }
        }

        public void onAdDisplayed(MaxAd maxAd) {
            b(maxAd, (Bundle) null);
        }

        public void onAdExpanded(MaxAd maxAd) {
            j.g(this.f14211c, maxAd);
        }

        public void onAdHidden(MaxAd maxAd) {
            c(maxAd, (Bundle) null);
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            this.f14210b.r();
            MediationServiceImpl.this.a(this.f14210b, maxError, (MaxAdListener) this.f14211c);
        }

        public void onAdLoaded(MaxAd maxAd) {
            a(maxAd, (Bundle) null);
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            j.f(this.f14211c, maxAd);
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            j.e(this.f14211c, maxAd);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            j.a((MaxAdListener) this.f14211c, maxAd, maxReward);
            MediationServiceImpl.this.f14186a.S().a((com.applovin.impl.sdk.e.a) new f((c) maxAd, MediationServiceImpl.this.f14186a), o.a.MEDIATION_REWARD);
        }
    }

    public MediationServiceImpl(m mVar) {
        this.f14186a = mVar;
        this.f14187b = mVar.A();
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
    }

    private g a(c cVar) {
        g g2 = cVar.g();
        if (g2 != null) {
            return g2;
        }
        this.f14186a.ae().a(false);
        if (v.a()) {
            v vVar = this.f14187b;
            vVar.d("MediationService", "Failed to show " + cVar + ": adapter not found");
            v.i("MediationService", "There may be an integration problem with the adapter for ad unit id '" + cVar.getAdUnitId() + "'. Please check if you have a supported version of that SDK integrated into your project.");
        }
        throw new IllegalStateException("Could not find adapter for provided ad");
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.a aVar) {
        this.f14186a.ag().a(aVar, "DID_LOAD");
        if (aVar.d().endsWith("load")) {
            this.f14186a.ag().a(aVar);
        }
        long o2 = aVar.o();
        HashMap hashMap = new HashMap(1);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(o2));
        a("load", (Map<String, String>) hashMap, (com.applovin.impl.mediation.a.f) aVar);
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.a aVar, a.C0011a aVar2) {
        this.f14186a.ag().a(aVar, "DID_CLICKED");
        this.f14186a.ag().a(aVar, "DID_CLICK");
        if (aVar.d().endsWith("click")) {
            this.f14186a.ag().a(aVar);
            j.a((MaxAdRevenueListener) aVar2, (MaxAd) aVar);
        }
        a("mclick", (com.applovin.impl.mediation.a.f) aVar);
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.a aVar, MaxError maxError, MaxAdListener maxAdListener) {
        a(maxError, aVar);
        destroyAd(aVar);
        j.a(maxAdListener, aVar.getAdUnitId(), maxError);
    }

    /* access modifiers changed from: private */
    public void a(c cVar, a.C0011a aVar) {
        this.f14186a.ae().a(false);
        a(cVar, (MaxAdListener) aVar);
        if (v.a()) {
            this.f14187b.b("MediationService", "Scheduling impression for ad manually...");
        }
        processRawAdImpressionPostback(cVar, aVar);
    }

    private void a(c cVar, MaxAdListener maxAdListener) {
        long longValue = ((Long) this.f14186a.a(com.applovin.impl.sdk.c.a.F)).longValue();
        if (longValue > 0) {
            final c cVar2 = cVar;
            final long j2 = longValue;
            final MaxAdListener maxAdListener2 = maxAdListener;
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    if (!cVar2.s().get()) {
                        String str = "Ad (" + cVar2.M() + ") has not been displayed after " + j2 + "ms. Failing ad display...";
                        if (v.a()) {
                            v.i("MediationService", str);
                        }
                        MediationServiceImpl.this.b(cVar2, new MaxErrorImpl(-1, str), maxAdListener2);
                        MediationServiceImpl.this.f14186a.ae().b((Object) cVar2);
                        MediationServiceImpl.this.f14186a.ak().a();
                    }
                }
            }, longValue);
        }
    }

    private void a(MaxError maxError, com.applovin.impl.mediation.a.a aVar) {
        long o2 = aVar.o();
        HashMap hashMap = new HashMap(1);
        hashMap.put("{LOAD_TIME_MS}", String.valueOf(o2));
        a("mlerr", (Map<String, String>) hashMap, maxError, (com.applovin.impl.mediation.a.f) aVar);
    }

    private void a(String str, com.applovin.impl.mediation.a.f fVar) {
        a(str, (Map<String, String>) Collections.EMPTY_MAP, (MaxError) null, fVar);
    }

    /* access modifiers changed from: private */
    public void a(String str, h hVar, g gVar) {
        HashMap hashMap = new HashMap(2);
        Utils.putObjectForStringIfValid("{ADAPTER_VERSION}", gVar.i(), hashMap);
        Utils.putObjectForStringIfValid("{SDK_VERSION}", gVar.h(), hashMap);
        a("serr", (Map<String, String>) hashMap, (MaxError) new MaxErrorImpl(str), (com.applovin.impl.mediation.a.f) hVar);
    }

    private void a(String str, Map<String, String> map, com.applovin.impl.mediation.a.f fVar) {
        a(str, map, (MaxError) null, fVar);
    }

    private void a(String str, Map<String, String> map, MaxError maxError, com.applovin.impl.mediation.a.f fVar) {
        HashMap hashMap = new HashMap(map);
        hashMap.put("{PLACEMENT}", StringUtils.emptyIfNull(fVar.getPlacement()));
        hashMap.put("{CUSTOM_DATA}", StringUtils.emptyIfNull(fVar.Z()));
        if (fVar instanceof com.applovin.impl.mediation.a.a) {
            hashMap.put("{CREATIVE_ID}", StringUtils.emptyIfNull(((com.applovin.impl.mediation.a.a) fVar).getCreativeId()));
        }
        this.f14186a.S().a((com.applovin.impl.sdk.e.a) new d(str, hashMap, maxError, fVar, this.f14186a), o.a.MEDIATION_POSTBACKS);
    }

    /* access modifiers changed from: private */
    public void b(com.applovin.impl.mediation.a.a aVar, MaxError maxError, MaxAdListener maxAdListener) {
        this.f14186a.ag().a(aVar, "DID_FAIL_DISPLAY");
        processAdDisplayErrorPostback(maxError, aVar);
        if (aVar.s().compareAndSet(false, true)) {
            j.a(maxAdListener, (MaxAd) aVar, maxError);
        }
    }

    /* access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar.getFormat() == MaxAdFormat.REWARDED || cVar.getFormat() == MaxAdFormat.REWARDED_INTERSTITIAL) {
            this.f14186a.S().a((com.applovin.impl.sdk.e.a) new g(cVar, this.f14186a), o.a.MEDIATION_REWARD);
        }
    }

    public void collectSignal(MaxAdFormat maxAdFormat, final h hVar, Context context, final g.a aVar) {
        String str;
        v vVar;
        String str2;
        StringBuilder sb;
        if (hVar == null) {
            throw new IllegalArgumentException("No spec specified");
        } else if (context == null) {
            throw new IllegalArgumentException("No context specified");
        } else if (aVar != null) {
            final g a2 = this.f14186a.C().a(hVar, true);
            if (a2 != null) {
                Activity an = context instanceof Activity ? (Activity) context : this.f14186a.an();
                MaxAdapterParametersImpl a3 = MaxAdapterParametersImpl.a(hVar, maxAdFormat);
                if (((Boolean) this.f14186a.a(com.applovin.impl.sdk.c.a.R)).booleanValue()) {
                    this.f14186a.D().a((com.applovin.impl.mediation.a.f) hVar, an);
                }
                AnonymousClass3 r12 = new MaxSignalCollectionListener() {
                    public void onSignalCollected(String str) {
                        aVar.a(com.applovin.impl.mediation.a.g.a(hVar, a2, str));
                        a2.j();
                    }

                    public void onSignalCollectionFailed(String str) {
                        MediationServiceImpl.this.a(str, hVar, a2);
                        aVar.a(com.applovin.impl.mediation.a.g.b(hVar, a2, str));
                        a2.j();
                    }
                };
                if (!hVar.a()) {
                    if (v.a()) {
                        vVar = this.f14187b;
                        sb = new StringBuilder();
                        str2 = "Collecting signal for adapter: ";
                    }
                    a2.a((MaxAdapterSignalCollectionParameters) a3, hVar, an, (MaxSignalCollectionListener) r12);
                    return;
                } else if (this.f14186a.D().a((com.applovin.impl.mediation.a.f) hVar)) {
                    if (v.a()) {
                        vVar = this.f14187b;
                        sb = new StringBuilder();
                        str2 = "Collecting signal for now-initialized adapter: ";
                    }
                    a2.a((MaxAdapterSignalCollectionParameters) a3, hVar, an, (MaxSignalCollectionListener) r12);
                    return;
                } else {
                    if (v.a()) {
                        v vVar2 = this.f14187b;
                        vVar2.e("MediationService", "Skip collecting signal for not-initialized adapter: " + a2.d());
                    }
                    str = "Adapter not initialized yet";
                }
                sb.append(str2);
                sb.append(a2.d());
                vVar.b("MediationService", sb.toString());
                a2.a((MaxAdapterSignalCollectionParameters) a3, hVar, an, (MaxSignalCollectionListener) r12);
                return;
            }
            str = "Could not load adapter";
            aVar.a(com.applovin.impl.mediation.a.g.a(hVar, str));
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    public void destroyAd(MaxAd maxAd) {
        if (maxAd instanceof com.applovin.impl.mediation.a.a) {
            if (v.a()) {
                v vVar = this.f14187b;
                vVar.c("MediationService", "Destroying " + maxAd);
            }
            com.applovin.impl.mediation.a.a aVar = (com.applovin.impl.mediation.a.a) maxAd;
            g g2 = aVar.g();
            if (g2 != null) {
                g2.j();
                aVar.t();
            }
            this.f14186a.B().c(aVar.f());
        }
    }

    public JSONObject getAndResetCustomPostBodyData() {
        return this.f14188c.getAndSet((Object) null);
    }

    public void loadAd(String str, String str2, MaxAdFormat maxAdFormat, Map<String, Object> map, Map<String, Object> map2, Context context, a.C0011a aVar) {
        String str3 = str;
        a.C0011a aVar2 = aVar;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (context == null) {
            throw new IllegalArgumentException("No context specified");
        } else if (aVar2 != null) {
            if (v.a() && TextUtils.isEmpty(this.f14186a.t())) {
                v.i("AppLovinSdk", "Mediation provider is null. Please set AppLovin SDK mediation provider via AppLovinSdk.getInstance(context).setMediationProvider()");
            }
            if (v.a() && !this.f14186a.d()) {
                v.h("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
            }
            this.f14186a.a();
            if (str.length() != 16 && !str.startsWith("test_mode") && !this.f14186a.z().startsWith("05TMD") && v.a()) {
                v.i("MediationService", "Please double-check the ad unit " + str + " for " + maxAdFormat.getLabel() + " : " + Log.getStackTraceString(new Throwable("")));
            }
            MaxAdFormat maxAdFormat2 = maxAdFormat;
            if (this.f14186a.a(maxAdFormat)) {
                if (v.a()) {
                    v.i("MediationService", "Ad load failed due to disabled ad format " + maxAdFormat.getLabel());
                }
                j.a((MaxAdListener) aVar2, str, (MaxError) new MaxErrorImpl(-1, "Disabled ad format " + maxAdFormat.getLabel()));
                return;
            }
            this.f14186a.I().a(str, str2, maxAdFormat, map, map2, context, aVar);
        } else {
            throw new IllegalArgumentException("No listener specified");
        }
    }

    public void loadThirdPartyMediatedAd(String str, com.applovin.impl.mediation.a.a aVar, Activity activity, a.C0011a aVar2) {
        if (aVar != null) {
            if (v.a()) {
                this.f14187b.b("MediationService", "Loading " + aVar + "...");
            }
            this.f14186a.ag().a(aVar, "WILL_LOAD");
            g a2 = this.f14186a.C().a((com.applovin.impl.mediation.a.f) aVar);
            if (a2 != null) {
                MaxAdapterParametersImpl a3 = MaxAdapterParametersImpl.a(aVar);
                if (((Boolean) this.f14186a.a(com.applovin.impl.sdk.c.a.S)).booleanValue()) {
                    this.f14186a.D().a((com.applovin.impl.mediation.a.f) aVar, activity);
                }
                com.applovin.impl.mediation.a.a a4 = aVar.a(a2);
                a2.a(str, a4);
                a4.p();
                a2.a(str, a3, a4, activity, new a(a4, aVar2));
                return;
            }
            String str2 = "Failed to load " + aVar + ": adapter not loaded";
            if (v.a()) {
                v.i("MediationService", str2);
            }
            a(aVar, (MaxError) new MaxErrorImpl(-5001, str2), (MaxAdListener) aVar2);
            return;
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction())) {
            Object c2 = this.f14186a.ae().c();
            if (c2 instanceof com.applovin.impl.mediation.a.a) {
                processAdDisplayErrorPostback(MaxAdapterError.WEBVIEW_ERROR, (com.applovin.impl.mediation.a.a) c2);
            }
        }
    }

    public void processAdDisplayErrorPostback(MaxError maxError, com.applovin.impl.mediation.a.a aVar) {
        a("mierr", (Map<String, String>) Collections.EMPTY_MAP, maxError, (com.applovin.impl.mediation.a.f) aVar);
    }

    public void processAdLossPostback(com.applovin.impl.mediation.a.a aVar, Float f2) {
        String f3 = f2 != null ? f2.toString() : "";
        HashMap hashMap = new HashMap(1);
        hashMap.put("{MBR}", f3);
        a("mloss", (Map<String, String>) hashMap, (com.applovin.impl.mediation.a.f) aVar);
    }

    public void processAdapterInitializationPostback(com.applovin.impl.mediation.a.f fVar, long j2, MaxAdapter.InitializationStatus initializationStatus, String str) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("{INIT_STATUS}", String.valueOf(initializationStatus.getCode()));
        hashMap.put("{INIT_TIME_MS}", String.valueOf(j2));
        a("minit", (Map<String, String>) hashMap, (MaxError) new MaxErrorImpl(str), fVar);
    }

    public void processCallbackAdImpressionPostback(com.applovin.impl.mediation.a.a aVar, a.C0011a aVar2) {
        if (aVar.d().endsWith("cimp")) {
            this.f14186a.ag().a(aVar);
            j.a((MaxAdRevenueListener) aVar2, (MaxAd) aVar);
        }
        a("mcimp", (com.applovin.impl.mediation.a.f) aVar);
    }

    public void processRawAdImpressionPostback(com.applovin.impl.mediation.a.a aVar, a.C0011a aVar2) {
        this.f14186a.ag().a(aVar, "WILL_DISPLAY");
        if (aVar.d().endsWith("mimp")) {
            this.f14186a.ag().a(aVar);
            j.a((MaxAdRevenueListener) aVar2, (MaxAd) aVar);
        }
        HashMap hashMap = new HashMap(1);
        if (aVar instanceof c) {
            hashMap.put("{TIME_TO_SHOW_MS}", String.valueOf(((c) aVar).y()));
        }
        a("mimp", (Map<String, String>) hashMap, (com.applovin.impl.mediation.a.f) aVar);
    }

    public void processViewabilityAdImpressionPostback(e eVar, long j2, a.C0011a aVar) {
        if (eVar.d().endsWith("vimp")) {
            this.f14186a.ag().a((com.applovin.impl.mediation.a.a) eVar);
            j.a((MaxAdRevenueListener) aVar, (MaxAd) eVar);
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("{VIEWABILITY_FLAGS}", String.valueOf(j2));
        hashMap.put("{USED_VIEWABILITY_TIMER}", String.valueOf(eVar.G()));
        a("mvimp", (Map<String, String>) hashMap, (com.applovin.impl.mediation.a.f) eVar);
    }

    public void setCustomPostBodyData(JSONObject jSONObject) {
        this.f14188c.set(jSONObject);
    }

    public void showFullscreenAd(c cVar, Activity activity, a.C0011a aVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (activity != null) {
            this.f14186a.ae().a(true);
            final g a2 = a(cVar);
            long z2 = cVar.z();
            if (v.a()) {
                v vVar = this.f14187b;
                vVar.c("MediationService", "Showing ad " + cVar.getAdUnitId() + " with delay of " + z2 + "ms...");
            }
            final c cVar2 = cVar;
            final Activity activity2 = activity;
            final a.C0011a aVar2 = aVar;
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    MediationServiceImpl.this.b(cVar2);
                    a2.a((com.applovin.impl.mediation.a.a) cVar2, activity2);
                    MediationServiceImpl.this.a(cVar2, aVar2);
                }
            }, z2);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    public void showFullscreenAd(c cVar, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, a.C0011a aVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No ad specified");
        } else if (activity != null) {
            this.f14186a.ae().a(true);
            final g a2 = a(cVar);
            long z2 = cVar.z();
            if (v.a()) {
                v vVar = this.f14187b;
                vVar.c("MediationService", "Showing ad " + cVar.getAdUnitId() + " with delay of " + z2 + "ms...");
            }
            final c cVar2 = cVar;
            final ViewGroup viewGroup2 = viewGroup;
            final Lifecycle lifecycle2 = lifecycle;
            final Activity activity2 = activity;
            final a.C0011a aVar2 = aVar;
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    MediationServiceImpl.this.b(cVar2);
                    a2.a((com.applovin.impl.mediation.a.a) cVar2, viewGroup2, lifecycle2, activity2);
                    MediationServiceImpl.this.a(cVar2, aVar2);
                }
            }, z2);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }
}
