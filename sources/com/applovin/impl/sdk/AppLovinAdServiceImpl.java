package com.applovin.impl.sdk;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.TextUtils;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.ad.f;
import com.applovin.impl.sdk.e.k;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.network.h;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class AppLovinAdServiceImpl implements AppLovinAdService {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m f14933a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final v f14934b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f14935c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private final Map<d, b> f14936d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f14937e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f14938f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference<JSONObject> f14939g = new AtomicReference<>();

    private class a implements AppLovinAdLoadListener {

        /* renamed from: b  reason: collision with root package name */
        private final b f14949b;

        private a(b bVar) {
            this.f14949b = bVar;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            HashSet<AppLovinAdLoadListener> hashSet;
            AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
            d adZone = appLovinAdImpl.getAdZone();
            if (!(appLovinAd instanceof f)) {
                AppLovinAdServiceImpl.this.f14933a.Z().a(appLovinAdImpl);
                appLovinAd = new f(adZone, AppLovinAdServiceImpl.this.f14933a);
            }
            synchronized (this.f14949b.f14950a) {
                hashSet = new HashSet<>(this.f14949b.f14952c);
                this.f14949b.f14952c.clear();
                this.f14949b.f14951b = false;
            }
            for (AppLovinAdLoadListener a2 : hashSet) {
                AppLovinAdServiceImpl.this.a(appLovinAd, a2);
            }
        }

        public void failedToReceiveAd(int i2) {
            HashSet<AppLovinAdLoadListener> hashSet;
            synchronized (this.f14949b.f14950a) {
                hashSet = new HashSet<>(this.f14949b.f14952c);
                this.f14949b.f14952c.clear();
                this.f14949b.f14951b = false;
            }
            for (AppLovinAdLoadListener a2 : hashSet) {
                AppLovinAdServiceImpl.this.a(i2, a2);
            }
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f14950a;

        /* renamed from: b  reason: collision with root package name */
        boolean f14951b;

        /* renamed from: c  reason: collision with root package name */
        final Collection<AppLovinAdLoadListener> f14952c;

        private b() {
            this.f14950a = new Object();
            this.f14952c = new HashSet();
        }

        public String toString() {
            return "AdLoadState{, isWaitingForAd=" + this.f14951b + ", pendingAdListeners=" + this.f14952c + '}';
        }
    }

    AppLovinAdServiceImpl(m mVar) {
        this.f14933a = mVar;
        this.f14934b = mVar.A();
        HashMap hashMap = new HashMap(5);
        this.f14936d = hashMap;
        hashMap.put(d.g(), new b());
        hashMap.put(d.h(), new b());
        hashMap.put(d.i(), new b());
        hashMap.put(d.j(), new b());
        hashMap.put(d.k(), new b());
    }

    private Uri a(Uri uri, String str) {
        try {
            return Uri.parse(uri.getQueryParameter(str));
        } catch (Throwable unused) {
            if (!v.a()) {
                return null;
            }
            v A = this.f14933a.A();
            A.d("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
            return null;
        }
    }

    private b a(d dVar) {
        b bVar;
        synchronized (this.f14937e) {
            bVar = this.f14936d.get(dVar);
            if (bVar == null) {
                bVar = new b();
                this.f14936d.put(dVar, bVar);
            }
        }
        return bVar;
    }

    private String a(String str, long j2, int i2, String str2, boolean z2) {
        try {
            if (!StringUtils.isValidString(str)) {
                return null;
            }
            if (i2 < 0 || i2 > 100) {
                i2 = 0;
            }
            return Uri.parse(str).buildUpon().appendQueryParameter("et_s", Long.toString(j2)).appendQueryParameter("pv", Integer.toString(i2)).appendQueryParameter("vid_ts", str2).appendQueryParameter("uvs", Boolean.toString(z2)).build().toString();
        } catch (Throwable th) {
            if (v.a()) {
                v vVar = this.f14934b;
                vVar.b("AppLovinAdService", "Unknown error parsing the video end url: " + str, th);
            }
            return null;
        }
    }

    private String a(String str, long j2, long j3, List<Long> list, boolean z2, int i2) {
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("et_ms", Long.toString(j2)).appendQueryParameter("vs_ms", Long.toString(j3));
        if (list != null && list.size() > 0) {
            appendQueryParameter.appendQueryParameter("ec_ms", list.toString());
        }
        if (i2 != h.f15469a) {
            appendQueryParameter.appendQueryParameter("musw_ch", Boolean.toString(z2));
            appendQueryParameter.appendQueryParameter("musw_st", Boolean.toString(h.a(i2)));
        }
        return appendQueryParameter.build().toString();
    }

    /* access modifiers changed from: private */
    public void a(final int i2, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f14935c.post(new Runnable() {
            public void run() {
                try {
                    appLovinAdLoadListener.failedToReceiveAd(i2);
                } catch (Throwable th) {
                    if (v.a()) {
                        v.c("AppLovinAdService", "Unable to notify listener about ad load failure", th);
                    }
                }
            }
        });
    }

    private void a(Uri uri, e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar) {
        if (Utils.openUri(appLovinAdView.getContext(), uri, this.f14933a)) {
            j.c(bVar.g(), (AppLovinAd) eVar, appLovinAdView);
        }
        bVar.o();
    }

    private void a(Uri uri, e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Context context, m mVar) {
        if (uri != null && StringUtils.isValidString(uri.getQuery())) {
            Uri a2 = a(uri, "primaryUrl");
            List<Uri> b2 = b(uri, "primaryTrackingUrl");
            Uri a3 = a(uri, "fallbackUrl");
            List<Uri> b3 = b(uri, "fallbackTrackingUrl");
            if (a2 != null || a3 != null) {
                if (!a(a2, "primary", b2, eVar, appLovinAdView, bVar, context, mVar)) {
                    a(a3, "backup", b3, eVar, appLovinAdView, bVar, context, mVar);
                }
                if (bVar != null) {
                    bVar.o();
                }
            } else if (v.a()) {
                mVar.A().e("AppLovinAdService", "Failed to parse both primary and backup URLs for Deep Link+ command");
            }
        } else if (v.a()) {
            mVar.A().e("AppLovinAdService", "Failed to execute Deep Link+ command - no query parameters found");
        }
    }

    private void a(Uri uri, e eVar, com.applovin.impl.adview.b bVar, final com.applovin.impl.adview.activity.b.a aVar) {
        if (v.a(this.f14933a)) {
            v vVar = this.f14934b;
            vVar.b("AppLovinAdService", "Forwarding click " + uri);
        }
        eVar.setMaxAdValue("forwarding_clicked_url", uri.toString());
        String str = this.f14933a.p().getExtraParameters().get("close_ad_on_forwarding_click_scheme");
        if (StringUtils.isValidString(str) && Boolean.parseBoolean(str)) {
            if (aVar != null) {
                this.f14935c.post(new Runnable() {
                    public void run() {
                        if (aVar != null) {
                            if (v.a(AppLovinAdServiceImpl.this.f14933a)) {
                                AppLovinAdServiceImpl.this.f14934b.b("AppLovinAdService", "Dismissing ad after forwarding click");
                            }
                            aVar.h();
                        }
                    }
                });
            } else if (bVar != null && !Utils.isBML(eVar.getSize())) {
                if (v.a(this.f14933a)) {
                    this.f14934b.b("AppLovinAdService", "Closing ad after forwarding click");
                }
                bVar.l();
            }
        }
    }

    private void a(d dVar, a aVar) {
        AppLovinAdImpl a2 = this.f14933a.Z().a(dVar);
        if (a2 != null) {
            if (v.a()) {
                v vVar = this.f14934b;
                vVar.b("AppLovinAdService", "Using pre-loaded ad: " + a2 + " for " + dVar);
            }
            aVar.adReceived(a2);
            return;
        }
        a((com.applovin.impl.sdk.e.a) new k(dVar, aVar, this.f14933a));
    }

    private void a(d dVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (dVar == null) {
            throw new IllegalArgumentException("No zone specified");
        } else if (appLovinAdLoadListener != null) {
            if (v.a()) {
                v A = this.f14933a.A();
                A.b("AppLovinAdService", "Loading next ad of zone {" + dVar + "}...");
            }
            b a2 = a(dVar);
            synchronized (a2.f14950a) {
                a2.f14952c.add(appLovinAdLoadListener);
                if (!a2.f14951b) {
                    a2.f14951b = true;
                    a(dVar, new a(a2));
                } else if (v.a()) {
                    this.f14934b.b("AppLovinAdService", "Already waiting on an ad load...");
                }
            }
        } else {
            throw new IllegalArgumentException("No callback specified");
        }
    }

    private void a(com.applovin.impl.sdk.d.a aVar) {
        if (StringUtils.isValidString(aVar.a())) {
            this.f14933a.U().a(h.o().c(aVar.a()).d(StringUtils.isValidString(aVar.b()) ? aVar.b() : null).b(aVar.c()).a(false).c(aVar.d()).a());
        } else if (v.a()) {
            this.f14934b.d("AppLovinAdService", "Requested a postback dispatch for a null URL; nothing to do...");
        }
    }

    private void a(com.applovin.impl.sdk.e.a aVar) {
        if (!this.f14933a.d() && v.a()) {
            v.h("AppLovinSdk", "Attempted to load ad before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        this.f14933a.a();
        this.f14933a.S().a(aVar, o.a.MAIN);
    }

    /* access modifiers changed from: private */
    public void a(final AppLovinAd appLovinAd, final AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f14935c.post(new Runnable() {
            public void run() {
                try {
                    appLovinAdLoadListener.adReceived(appLovinAd);
                } catch (Throwable th) {
                    if (v.a()) {
                        v.c("AppLovinAdService", "Unable to notify listener about a newly loaded ad", th);
                    }
                }
            }
        });
    }

    private boolean a(Uri uri, String str, List<Uri> list, e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Context context, m mVar) {
        if (v.a()) {
            v A = mVar.A();
            A.b("AppLovinAdService", "Opening " + str + " URL: " + uri);
        }
        boolean openUri = Utils.openUri(context, uri, mVar);
        boolean a2 = v.a();
        if (openUri) {
            if (a2) {
                v A2 = mVar.A();
                A2.b("AppLovinAdService", "URL opened successfully, dispatching tracking URLs: " + list);
            }
            for (Uri uri2 : list) {
                mVar.X().dispatchPostbackAsync(uri2.toString(), (AppLovinPostbackListener) null);
            }
            if (bVar != null) {
                j.c(bVar.g(), (AppLovinAd) eVar, appLovinAdView);
            }
        } else if (a2) {
            mVar.A().e("AppLovinAdService", "URL failed to open");
        }
        return openUri;
    }

    private boolean a(String str) {
        String str2 = this.f14933a.p().getExtraParameters().get("forwarding_click_scheme");
        return StringUtils.isValidString(str2) && StringUtils.isValidString(str) && str.equalsIgnoreCase(str2);
    }

    private List<Uri> b(Uri uri, String str) {
        List<String> queryParameters = uri.getQueryParameters(str);
        ArrayList arrayList = new ArrayList(queryParameters.size());
        for (String parse : queryParameters) {
            try {
                arrayList.add(Uri.parse(parse));
            } catch (Throwable unused) {
                if (v.a()) {
                    v A = this.f14933a.A();
                    A.d("AppLovinAdService", "Unable to parse query parameter into Uri: " + str);
                }
            }
        }
        return arrayList;
    }

    public void addCustomQueryParams(Map<String, String> map) {
        synchronized (this.f14938f) {
            this.f14938f.putAll(map);
        }
    }

    public AppLovinAd dequeueAd(d dVar) {
        AppLovinAdImpl b2 = this.f14933a.Z().b(dVar);
        if (v.a()) {
            v vVar = this.f14934b;
            vVar.b("AppLovinAdService", "Dequeued ad: " + b2 + " for zone: " + dVar + "...");
        }
        return b2;
    }

    public JSONObject getAndResetCustomPostBody() {
        return this.f14939g.getAndSet((Object) null);
    }

    public Map<String, String> getAndResetCustomQueryParams() {
        HashMap hashMap;
        synchronized (this.f14938f) {
            hashMap = new HashMap(this.f14938f);
            this.f14938f.clear();
        }
        return hashMap;
    }

    public String getBidToken() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        String a2 = this.f14933a.V().a();
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return a2;
    }

    public void loadNextAd(AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        a(d.a(appLovinAdSize, AppLovinAdType.REGULAR), appLovinAdLoadListener);
    }

    public void loadNextAd(String str, AppLovinAdSize appLovinAdSize, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (v.a()) {
            v vVar = this.f14934b;
            vVar.b("AppLovinAdService", "Loading next ad of zone {" + str + "} with size " + appLovinAdSize);
        }
        a(d.a(appLovinAdSize, AppLovinAdType.REGULAR, str), appLovinAdLoadListener);
    }

    /* JADX WARNING: type inference failed for: r11v27, types: [com.applovin.impl.sdk.e.l] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadNextAdForAdToken(java.lang.String r11, com.applovin.sdk.AppLovinAdLoadListener r12) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0007
            java.lang.String r11 = r11.trim()
            goto L_0x0008
        L_0x0007:
            r11 = 0
        L_0x0008:
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = -8
            java.lang.String r2 = "AppLovinAdService"
            if (r0 == 0) goto L_0x0020
            boolean r11 = com.applovin.impl.sdk.v.a()
            if (r11 == 0) goto L_0x001c
            java.lang.String r11 = "Invalid ad token specified"
            com.applovin.impl.sdk.v.i(r2, r11)
        L_0x001c:
            r10.a((int) r1, (com.applovin.sdk.AppLovinAdLoadListener) r12)
            return
        L_0x0020:
            com.applovin.impl.sdk.ad.c r0 = new com.applovin.impl.sdk.ad.c
            com.applovin.impl.sdk.m r3 = r10.f14933a
            r0.<init>(r11, r3)
            com.applovin.impl.sdk.ad.c$a r11 = r0.b()
            com.applovin.impl.sdk.ad.c$a r3 = com.applovin.impl.sdk.ad.c.a.REGULAR
            if (r11 != r3) goto L_0x0057
            boolean r11 = com.applovin.impl.sdk.v.a()
            if (r11 == 0) goto L_0x004b
            com.applovin.impl.sdk.v r11 = r10.f14934b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Loading next ad for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r11.b(r2, r1)
        L_0x004b:
            com.applovin.impl.sdk.e.l r11 = new com.applovin.impl.sdk.e.l
            com.applovin.impl.sdk.m r1 = r10.f14933a
            r11.<init>(r0, r12, r1)
        L_0x0052:
            r10.a((com.applovin.impl.sdk.e.a) r11)
            goto L_0x010a
        L_0x0057:
            com.applovin.impl.sdk.ad.c$a r11 = r0.b()
            com.applovin.impl.sdk.ad.c$a r3 = com.applovin.impl.sdk.ad.c.a.AD_RESPONSE_JSON
            if (r11 != r3) goto L_0x00ed
            org.json.JSONObject r5 = r0.d()
            if (r5 == 0) goto L_0x00df
            com.applovin.impl.sdk.m r11 = r10.f14933a
            com.applovin.impl.sdk.utils.h.f(r5, r11)
            com.applovin.impl.sdk.m r11 = r10.f14933a
            com.applovin.impl.sdk.utils.h.d(r5, r11)
            com.applovin.impl.sdk.m r11 = r10.f14933a
            com.applovin.impl.sdk.utils.h.c(r5, r11)
            com.applovin.impl.sdk.m r11 = r10.f14933a
            com.applovin.impl.sdk.utils.h.e(r5, r11)
            com.applovin.impl.sdk.m r11 = r10.f14933a
            com.applovin.impl.sdk.f.a((com.applovin.impl.sdk.m) r11)
            org.json.JSONArray r11 = new org.json.JSONArray
            r11.<init>()
            java.lang.String r1 = "ads"
            org.json.JSONArray r11 = com.applovin.impl.sdk.utils.JsonUtils.getJSONArray(r5, r1, r11)
            int r11 = r11.length()
            if (r11 <= 0) goto L_0x00bd
            boolean r11 = com.applovin.impl.sdk.v.a()
            if (r11 == 0) goto L_0x00ab
            com.applovin.impl.sdk.v r11 = r10.f14934b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Rendering ad for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.b(r2, r0)
        L_0x00ab:
            com.applovin.impl.sdk.m r11 = r10.f14933a
            com.applovin.impl.sdk.ad.d r6 = com.applovin.impl.sdk.utils.Utils.getZone(r5, r11)
            com.applovin.impl.sdk.e.p r11 = new com.applovin.impl.sdk.e.p
            com.applovin.impl.sdk.ad.b r7 = com.applovin.impl.sdk.ad.b.DECODED_AD_TOKEN_JSON
            com.applovin.impl.sdk.m r9 = r10.f14933a
            r4 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x0052
        L_0x00bd:
            boolean r11 = com.applovin.impl.sdk.v.a()
            if (r11 == 0) goto L_0x00d9
            com.applovin.impl.sdk.v r11 = r10.f14934b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "No ad returned from the server for token: "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.e(r2, r0)
        L_0x00d9:
            r11 = 204(0xcc, float:2.86E-43)
            r12.failedToReceiveAd(r11)
            goto L_0x010a
        L_0x00df:
            boolean r11 = com.applovin.impl.sdk.v.a()
            if (r11 == 0) goto L_0x0107
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r3 = "Unable to retrieve ad response JSON from token: "
            goto L_0x00fa
        L_0x00ed:
            boolean r11 = com.applovin.impl.sdk.v.a()
            if (r11 == 0) goto L_0x0107
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r3 = "Invalid ad token specified: "
        L_0x00fa:
            r11.append(r3)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.applovin.impl.sdk.v.i(r2, r11)
        L_0x0107:
            r12.failedToReceiveAd(r1)
        L_0x010a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.AppLovinAdServiceImpl.loadNextAdForAdToken(java.lang.String, com.applovin.sdk.AppLovinAdLoadListener):void");
    }

    public void loadNextAdForZoneId(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (!TextUtils.isEmpty(str)) {
            if (v.a()) {
                v vVar = this.f14934b;
                vVar.b("AppLovinAdService", "Loading next ad of zone {" + str + "}");
            }
            a(d.a(str), appLovinAdLoadListener);
            return;
        }
        throw new IllegalArgumentException("No zone id specified");
    }

    public void loadNextAdForZoneIds(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener) {
        List<String> removeTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(list);
        if (removeTrimmedEmptyStrings == null || removeTrimmedEmptyStrings.isEmpty()) {
            if (v.a()) {
                v.i("AppLovinAdService", "No zones were provided");
            }
            a(-7, appLovinAdLoadListener);
            return;
        }
        if (v.a()) {
            v vVar = this.f14934b;
            vVar.b("AppLovinAdService", "Loading next ad for zones: " + removeTrimmedEmptyStrings);
        }
        a((com.applovin.impl.sdk.e.a) new com.applovin.impl.sdk.e.j(removeTrimmedEmptyStrings, appLovinAdLoadListener, this.f14933a));
    }

    public void loadNextIncentivizedAd(String str, AppLovinAdLoadListener appLovinAdLoadListener) {
        if (v.a()) {
            v vVar = this.f14934b;
            vVar.b("AppLovinAdService", "Loading next incentivized ad of zone {" + str + "}");
        }
        a(d.b(str), appLovinAdLoadListener);
    }

    public void maybeSubmitPersistentPostbacks(List<com.applovin.impl.sdk.d.a> list) {
        if (list != null && !list.isEmpty()) {
            for (com.applovin.impl.sdk.d.a a2 : list) {
                a(a2);
            }
        }
    }

    public void setCustomPostBody(JSONObject jSONObject) {
        this.f14939g.set(jSONObject);
    }

    public String toString() {
        return "AppLovinAdService{adLoadStates=" + this.f14936d + '}';
    }

    public void trackAndLaunchClick(e eVar, AppLovinAdView appLovinAdView, com.applovin.impl.adview.b bVar, Uri uri, PointF pointF, boolean z2) {
        if (eVar != null) {
            if (v.a()) {
                this.f14934b.b("AppLovinAdService", "Tracking click on an ad...");
            }
            maybeSubmitPersistentPostbacks(eVar.a(pointF, z2));
            if (appLovinAdView == null || uri == null) {
                if (v.a()) {
                    this.f14934b.e("AppLovinAdService", "Unable to launch click - adView has been prematurely destroyed");
                }
            } else if (a(uri.getScheme())) {
                a(uri, eVar, bVar, (com.applovin.impl.adview.activity.b.a) null);
            } else if (Utils.isDeepLinkPlusUrl(uri)) {
                a(uri, eVar, appLovinAdView, bVar, appLovinAdView.getContext(), this.f14933a);
            } else {
                a(uri, eVar, appLovinAdView, bVar);
            }
        } else if (v.a()) {
            this.f14934b.e("AppLovinAdService", "Unable to track ad view click. No ad specified");
        }
    }

    public void trackAndLaunchVideoClick(e eVar, Uri uri, PointF pointF, com.applovin.impl.adview.activity.b.a aVar, Context context) {
        if (eVar != null) {
            if (v.a()) {
                this.f14934b.b("AppLovinAdService", "Tracking VIDEO click on an ad...");
            }
            maybeSubmitPersistentPostbacks(eVar.a(pointF));
            if (a(uri.getScheme())) {
                a(uri, eVar, (com.applovin.impl.adview.b) null, aVar);
            } else if (Utils.isDeepLinkPlusUrl(uri)) {
                a(uri, eVar, (AppLovinAdView) null, (com.applovin.impl.adview.b) null, context, this.f14933a);
            } else {
                Utils.openUri(context, uri, this.f14933a);
            }
        } else if (v.a()) {
            this.f14934b.e("AppLovinAdService", "Unable to track video click. No ad specified");
        }
    }

    public void trackAppKilled(e eVar) {
        if (eVar != null) {
            if (v.a()) {
                this.f14934b.b("AppLovinAdService", "Tracking app killed during ad...");
            }
            List<com.applovin.impl.sdk.d.a> as = eVar.as();
            if (as != null && !as.isEmpty()) {
                for (com.applovin.impl.sdk.d.a next : as) {
                    a(new com.applovin.impl.sdk.d.a(next.a(), next.b()));
                }
            } else if (v.a()) {
                v vVar = this.f14934b;
                vVar.d("AppLovinAdService", "Unable to track app killed during AD #" + eVar.getAdIdNumber() + ". Missing app killed tracking URL.");
            }
        } else if (v.a()) {
            this.f14934b.e("AppLovinAdService", "Unable to track app killed. No ad specified");
        }
    }

    public void trackFullScreenAdClosed(e eVar, long j2, List<Long> list, long j3, boolean z2, int i2) {
        boolean a2 = v.a();
        if (eVar != null) {
            if (a2) {
                this.f14934b.b("AppLovinAdService", "Tracking ad closed...");
            }
            List<com.applovin.impl.sdk.d.a> ar = eVar.ar();
            if (ar != null && !ar.isEmpty()) {
                for (com.applovin.impl.sdk.d.a next : ar) {
                    long j4 = j2;
                    long j5 = j3;
                    List<Long> list2 = list;
                    boolean z3 = z2;
                    int i3 = i2;
                    String a3 = a(next.a(), j4, j5, list2, z3, i3);
                    String a4 = a(next.b(), j4, j5, list2, z3, i3);
                    if (StringUtils.isValidString(a3)) {
                        a(new com.applovin.impl.sdk.d.a(a3, a4));
                    } else if (v.a()) {
                        v vVar = this.f14934b;
                        vVar.e("AppLovinAdService", "Failed to parse url: " + next.a());
                    }
                }
            } else if (v.a()) {
                v vVar2 = this.f14934b;
                vVar2.d("AppLovinAdService", "Unable to track ad closed for AD #" + eVar.getAdIdNumber() + ". Missing ad close tracking URL." + eVar.getAdIdNumber());
            }
        } else if (a2) {
            this.f14934b.e("AppLovinAdService", "Unable to track ad closed. No ad specified.");
        }
    }

    public void trackImpression(e eVar) {
        if (eVar != null) {
            if (v.a()) {
                this.f14934b.b("AppLovinAdService", "Tracking impression on ad...");
            }
            maybeSubmitPersistentPostbacks(eVar.at());
        } else if (v.a()) {
            this.f14934b.e("AppLovinAdService", "Unable to track impression click. No ad specified");
        }
    }

    public void trackVideoEnd(e eVar, long j2, int i2, boolean z2) {
        boolean a2 = v.a();
        if (eVar != null) {
            if (a2) {
                this.f14934b.b("AppLovinAdService", "Tracking video end on ad...");
            }
            List<com.applovin.impl.sdk.d.a> aq = eVar.aq();
            if (aq != null && !aq.isEmpty()) {
                String l2 = Long.toString(System.currentTimeMillis());
                for (com.applovin.impl.sdk.d.a next : aq) {
                    if (StringUtils.isValidString(next.a())) {
                        long j3 = j2;
                        int i3 = i2;
                        String str = l2;
                        boolean z3 = z2;
                        String a3 = a(next.a(), j3, i3, str, z3);
                        String a4 = a(next.b(), j3, i3, str, z3);
                        if (a3 != null) {
                            a(new com.applovin.impl.sdk.d.a(a3, a4));
                        } else if (v.a()) {
                            v vVar = this.f14934b;
                            vVar.e("AppLovinAdService", "Failed to parse url: " + next.a());
                        }
                    } else if (v.a()) {
                        this.f14934b.d("AppLovinAdService", "Requested a postback dispatch for an empty video end URL; nothing to do...");
                    }
                }
            } else if (v.a()) {
                v vVar2 = this.f14934b;
                vVar2.d("AppLovinAdService", "Unable to submit persistent postback for AD #" + eVar.getAdIdNumber() + ". Missing video end tracking URL.");
            }
        } else if (a2) {
            this.f14934b.e("AppLovinAdService", "Unable to track video end. No ad specified");
        }
    }
}
