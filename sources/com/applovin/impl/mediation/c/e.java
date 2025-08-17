package com.applovin.impl.mediation.c;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.mediation.MaxAdWaterfallInfoImpl;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.MaxNetworkResponseInfoImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d.c;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.d.g;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends com.applovin.impl.sdk.e.a {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f14410a = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f14411c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final MaxAdFormat f14412d;

    /* renamed from: e  reason: collision with root package name */
    private final JSONObject f14413e;

    /* renamed from: f  reason: collision with root package name */
    private final List<com.applovin.impl.mediation.a.a> f14414f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final a.C0011a f14415g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final WeakReference<Context> f14416h;

    /* renamed from: i  reason: collision with root package name */
    private long f14417i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final List<MaxNetworkResponseInfo> f14418j;

    private class a extends com.applovin.impl.sdk.e.a {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f14423c = SystemClock.elapsedRealtime();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final int f14424d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final com.applovin.impl.mediation.a.a f14425e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final List<com.applovin.impl.mediation.a.a> f14426f;

        a(int i2, List<com.applovin.impl.mediation.a.a> list) {
            super(e.this.e(), e.this.f15333b);
            this.f14424d = i2;
            this.f14425e = list.get(i2);
            this.f14426f = list;
        }

        /* access modifiers changed from: private */
        public void a(com.applovin.impl.mediation.a.a aVar, MaxNetworkResponseInfo.AdLoadState adLoadState, long j2, MaxError maxError) {
            MaxNetworkResponseInfo.AdLoadState adLoadState2 = adLoadState;
            e.this.f14418j.add(new MaxNetworkResponseInfoImpl(adLoadState2, aVar.h(), new MaxMediatedNetworkInfoImpl(c.a(aVar.K(), this.f15333b)), j2, maxError));
        }

        /* access modifiers changed from: private */
        public void e(String str) {
        }

        public void run() {
            if (v.a()) {
                a("Loading ad " + (this.f14424d + 1) + " of " + this.f14426f.size() + ": " + this.f14425e.L());
            }
            e("started to load ad");
            Context context = (Context) e.this.f14416h.get();
            this.f15333b.E().loadThirdPartyMediatedAd(e.this.f14411c, this.f14425e, context instanceof Activity ? (Activity) context : this.f15333b.an(), new com.applovin.impl.mediation.d.a(e.this.f14415g) {
                public void onAdLoadFailed(String str, MaxError maxError) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f14423c;
                    if (v.a()) {
                        a aVar = a.this;
                        aVar.a("Ad failed to load in " + elapsedRealtime + " ms with error: " + maxError);
                    }
                    if (v.a()) {
                        a aVar2 = a.this;
                        aVar2.e("failed to load ad: " + maxError.getCode());
                    }
                    a aVar3 = a.this;
                    aVar3.a(aVar3.f14425e, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, elapsedRealtime, maxError);
                    if (a.this.f14424d < a.this.f14426f.size() - 1) {
                        a aVar4 = a.this;
                        a.this.f15333b.S().a((com.applovin.impl.sdk.e.a) new a(aVar4.f14424d + 1, a.this.f14426f), c.a(e.this.f14412d));
                        return;
                    }
                    e.this.a((MaxError) new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                }

                public void onAdLoaded(MaxAd maxAd) {
                    a.this.e("loaded ad");
                    long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.f14423c;
                    if (v.a()) {
                        a aVar = a.this;
                        aVar.a("Ad loaded in " + elapsedRealtime + "ms");
                    }
                    com.applovin.impl.mediation.a.a aVar2 = (com.applovin.impl.mediation.a.a) maxAd;
                    a.this.a(aVar2, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, elapsedRealtime, (MaxError) null);
                    int b2 = a.this.f14424d;
                    while (true) {
                        b2++;
                        if (b2 < a.this.f14426f.size()) {
                            a aVar3 = a.this;
                            aVar3.a((com.applovin.impl.mediation.a.a) aVar3.f14426f.get(b2), MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1, (MaxError) null);
                        } else {
                            e.this.a(aVar2);
                            return;
                        }
                    }
                }
            });
        }
    }

    e(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, JSONObject jSONObject, Context context, m mVar, a.C0011a aVar) {
        super("TaskProcessMediationWaterfall:" + str + ":" + maxAdFormat.getLabel(), mVar);
        this.f14411c = str;
        this.f14412d = maxAdFormat;
        this.f14413e = jSONObject;
        this.f14415g = aVar;
        this.f14416h = new WeakReference<>(context);
        this.f14414f = new ArrayList(jSONObject.length());
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ads", new JSONArray());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            this.f14414f.add(com.applovin.impl.mediation.a.a.a(map, JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null), jSONObject, mVar));
        }
        this.f14418j = new ArrayList(this.f14414f.size());
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.a aVar) {
        this.f15333b.F().a(aVar);
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f14417i;
        if (v.a()) {
            b("Waterfall loaded in " + elapsedRealtime + "ms for " + aVar.L());
        }
        aVar.a((MaxAdWaterfallInfo) new MaxAdWaterfallInfoImpl(aVar, elapsedRealtime, this.f14418j));
        j.a((MaxAdListener) this.f14415g, (MaxAd) aVar);
    }

    /* access modifiers changed from: private */
    public void a(MaxError maxError) {
        g T;
        f fVar;
        if (maxError.getCode() == 204) {
            T = this.f15333b.T();
            fVar = f.f15317p;
        } else if (maxError.getCode() == -5001) {
            T = this.f15333b.T();
            fVar = f.f15318q;
        } else {
            T = this.f15333b.T();
            fVar = f.f15319r;
        }
        T.a(fVar);
        ArrayList arrayList = new ArrayList(this.f14418j.size());
        for (MaxNetworkResponseInfo next : this.f14418j) {
            if (next.getAdLoadState() == MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder("======FAILED AD LOADS======");
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            int i2 = 0;
            while (i2 < arrayList.size()) {
                MaxNetworkResponseInfo maxNetworkResponseInfo = (MaxNetworkResponseInfo) arrayList.get(i2);
                i2++;
                sb.append(i2);
                sb.append(") ");
                sb.append(maxNetworkResponseInfo.getMediatedNetwork().getName());
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                sb.append("..code: ");
                sb.append(maxNetworkResponseInfo.getError().getCode());
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                sb.append("..message: ");
                sb.append(maxNetworkResponseInfo.getError().getMessage());
                sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            }
            ((MaxErrorImpl) maxError).setAdLoadFailureInfo(sb.toString());
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f14417i;
        if (v.a()) {
            b("Waterfall failed in " + elapsedRealtime + "ms with error: " + maxError);
        }
        ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl((com.applovin.impl.mediation.a.a) null, JsonUtils.getString(this.f14413e, "waterfall_name", ""), JsonUtils.getString(this.f14413e, "waterfall_test_name", ""), elapsedRealtime, this.f14418j));
        j.a((MaxAdListener) this.f14415g, this.f14411c, maxError);
    }

    public void run() {
        this.f14417i = SystemClock.elapsedRealtime();
        if (this.f14413e.optBoolean("is_testing", false) && !this.f15333b.J().a() && f14410a.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    Utils.showAlert("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", e.this.f15333b.an());
                }
            });
        }
        if (this.f14414f.size() > 0) {
            if (v.a()) {
                a("Starting waterfall for " + this.f14414f.size() + " ad(s)...");
            }
            this.f15333b.S().a((com.applovin.impl.sdk.e.a) new a(0, this.f14414f));
            return;
        }
        if (v.a()) {
            c("No ads were returned from the server");
        }
        Utils.maybeHandleNoFillResponseForPublisher(this.f14411c, this.f14412d, this.f14413e, this.f15333b);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f14413e, "settings", new JSONObject());
        long j2 = JsonUtils.getLong(jSONObject, "alfdcs", 0);
        final MaxErrorImpl maxErrorImpl = new MaxErrorImpl(204, "MAX returned no eligible ads from any mediated networks for this app/device.");
        if (j2 > 0) {
            long millis = TimeUnit.SECONDS.toMillis(j2);
            AnonymousClass2 r4 = new Runnable() {
                public void run() {
                    e.this.a(maxErrorImpl);
                }
            };
            if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", Boolean.FALSE).booleanValue()) {
                com.applovin.impl.sdk.utils.e.a(millis, this.f15333b, r4);
            } else {
                AppLovinSdkUtils.runOnUiThreadDelayed(r4, millis);
            }
        } else {
            a((MaxError) maxErrorImpl);
        }
    }
}
