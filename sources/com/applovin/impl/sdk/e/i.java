package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.security.ProviderInstaller;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class i extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f15365a = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final int f15366c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Object f15367d = new Object();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f15368e;

    public interface a {
        void a(JSONObject jSONObject);
    }

    private class b extends a {
        public b(m mVar) {
            super("TaskTimeoutFetchBasicSettings", mVar, true);
        }

        public void run() {
            synchronized (i.this.f15367d) {
                if (i.this.f15368e != null) {
                    if (v.a()) {
                        d("Timing out fetch basic settings...");
                    }
                    i.this.a(new JSONObject());
                }
            }
        }
    }

    public i(int i2, m mVar, a aVar) {
        super("TaskFetchBasicSettings", mVar, true);
        this.f15366c = i2;
        this.f15368e = aVar;
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        synchronized (this.f15367d) {
            a aVar = this.f15368e;
            if (aVar != null) {
                aVar.a(jSONObject);
                this.f15368e = null;
            }
        }
    }

    private String c() {
        return h.a((String) this.f15333b.a(com.applovin.impl.sdk.c.b.aP), "5.0/i", d());
    }

    private String h() {
        return h.a((String) this.f15333b.a(com.applovin.impl.sdk.c.b.aQ), "5.0/i", d());
    }

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("rid", UUID.randomUUID().toString());
        if (!((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.b.ep)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f15333b.z());
        }
        Boolean a2 = j.b().a(f());
        if (a2 != null) {
            hashMap.put("huc", a2.toString());
        }
        Boolean a3 = j.a().a(f());
        if (a3 != null) {
            hashMap.put("aru", a3.toString());
        }
        Boolean a4 = j.c().a(f());
        if (a4 != null) {
            hashMap.put("dns", a4.toString());
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|(1:4)|5|(1:7)|8|(1:10)|11|(1:13)|14|(1:16)|17|(1:21)|22|(1:24)|25|26|(1:28)|29|30|(1:32)|33|(1:37)|38|(1:41)|42|(1:44)|45|(1:47)|48|(1:50)|51|(1:53)|54|(1:56)|57|62) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x01cc */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01dc A[Catch:{ JSONException -> 0x02cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0250 A[Catch:{ JSONException -> 0x02cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x026b A[Catch:{ JSONException -> 0x02cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0286 A[Catch:{ JSONException -> 0x02cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x029d A[Catch:{ JSONException -> 0x02cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02b2 A[Catch:{ JSONException -> 0x02cc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject b() {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r0 = "screen_size_in"
            java.lang.String r2 = "is_tablet"
            java.lang.String r3 = "revision"
            java.lang.String r4 = "model"
            java.lang.String r5 = "hardware"
            java.lang.String r6 = "brand_name"
            java.lang.String r7 = "brand"
            java.lang.String r8 = "locale"
            java.lang.String r9 = "os"
            java.lang.String r10 = "platform"
            java.lang.String r11 = "target_sdk"
            java.lang.String r12 = "tg"
            java.lang.String r13 = "debug"
            java.lang.String r14 = "test_ads"
            java.lang.String r15 = "app_version"
            r16 = r0
            java.lang.String r0 = "package_name"
            r17 = r2
            java.lang.String r2 = "IABTCF_TCString"
            r18 = r3
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r19 = r4
            java.lang.String r4 = "sdk_version"
            r20 = r5
            java.lang.String r5 = com.applovin.sdk.AppLovinSdk.VERSION     // Catch:{ JSONException -> 0x02cc }
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r4 = "is_cross_promo"
            com.applovin.impl.sdk.m r5 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            boolean r5 = r5.e()     // Catch:{ JSONException -> 0x02cc }
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r4 = "init_count"
            int r5 = r1.f15366c     // Catch:{ JSONException -> 0x02cc }
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r4 = "server_installed_at"
            com.applovin.impl.sdk.m r5 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            r21 = r6
            com.applovin.impl.sdk.c.b<java.lang.String> r6 = com.applovin.impl.sdk.c.b.af     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r5 = r5.a(r6)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r4 = com.applovin.impl.sdk.utils.Utils.getUserEngagementSdkVersion()     // Catch:{ JSONException -> 0x02cc }
            boolean r5 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r4)     // Catch:{ JSONException -> 0x02cc }
            if (r5 == 0) goto L_0x006a
            java.lang.String r5 = "ue_sdk_version"
            r3.put(r5, r4)     // Catch:{ JSONException -> 0x02cc }
        L_0x006a:
            com.applovin.impl.sdk.m r4 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            boolean r4 = r4.P()     // Catch:{ JSONException -> 0x02cc }
            r5 = 1
            if (r4 == 0) goto L_0x0078
            java.lang.String r4 = "first_install"
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x02cc }
        L_0x0078:
            com.applovin.impl.sdk.m r4 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            boolean r4 = r4.Q()     // Catch:{ JSONException -> 0x02cc }
            if (r4 != 0) goto L_0x0085
            java.lang.String r4 = "first_install_v2"
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x02cc }
        L_0x0085:
            com.applovin.impl.sdk.m r4 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.c.b<java.lang.String> r6 = com.applovin.impl.sdk.c.b.dz     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r4 = r4.a(r6)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x02cc }
            boolean r6 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r4)     // Catch:{ JSONException -> 0x02cc }
            if (r6 == 0) goto L_0x009a
            java.lang.String r6 = "plugin_version"
            r3.put(r6, r4)     // Catch:{ JSONException -> 0x02cc }
        L_0x009a:
            com.applovin.impl.sdk.m r4 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r4 = r4.t()     // Catch:{ JSONException -> 0x02cc }
            boolean r6 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r4)     // Catch:{ JSONException -> 0x02cc }
            if (r6 == 0) goto L_0x00ab
            java.lang.String r6 = "mediation_provider"
            r3.put(r6, r4)     // Catch:{ JSONException -> 0x02cc }
        L_0x00ab:
            java.lang.String r4 = "installed_mediation_adapters"
            com.applovin.impl.sdk.m r6 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            org.json.JSONArray r6 = com.applovin.impl.mediation.d.c.a((com.applovin.impl.sdk.m) r6)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r4, r6)     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.m r4 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.o r4 = r4.V()     // Catch:{ JSONException -> 0x02cc }
            java.util.Map r4 = r4.h()     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r6 = r4.get(r0)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r0, r6)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r0 = r4.get(r15)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r15, r0)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r0 = r4.get(r14)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r14, r0)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r0 = r4.get(r13)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r13, r0)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r0 = r4.get(r12)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r12, r0)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r0 = r4.get(r11)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r11, r0)     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.m r0 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.sdk.AppLovinSdkSettings r0 = r0.p()     // Catch:{ JSONException -> 0x02cc }
            java.util.List r0 = r0.getInitializationAdUnitIds()     // Catch:{ JSONException -> 0x02cc }
            if (r0 == 0) goto L_0x010d
            int r6 = r0.size()     // Catch:{ JSONException -> 0x02cc }
            if (r6 <= 0) goto L_0x010d
            java.util.List r0 = com.applovin.impl.sdk.utils.CollectionUtils.removeTrimmedEmptyStrings(r0)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r6 = "ad_unit_ids"
            int r11 = r0.size()     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r0 = com.applovin.impl.sdk.utils.CollectionUtils.implode(r0, r11)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r6, r0)     // Catch:{ JSONException -> 0x02cc }
        L_0x010d:
            java.lang.Object r0 = r4.get(r2)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r0)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r0 = "IABTCF_gdprApplies"
            java.lang.Object r0 = r4.get(r0)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r0)     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.m r0 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.o r0 = r0.V()     // Catch:{ JSONException -> 0x02cc }
            java.util.Map r0 = r0.b()     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r2 = r0.get(r10)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r10, r2)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r2 = r0.get(r9)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r9, r2)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r2 = r0.get(r8)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r8, r2)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r2 = r0.get(r7)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r7, r2)     // Catch:{ JSONException -> 0x02cc }
            r2 = r21
            java.lang.Object r4 = r0.get(r2)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x02cc }
            r2 = r20
            java.lang.Object r4 = r0.get(r2)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x02cc }
            r2 = r19
            java.lang.Object r4 = r0.get(r2)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x02cc }
            r2 = r18
            java.lang.Object r4 = r0.get(r2)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x02cc }
            r2 = r17
            java.lang.Object r4 = r0.get(r2)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x02cc }
            r2 = r16
            java.lang.Object r0 = r0.get(r2)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r0)     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.m r0 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.c.b.dI     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r0 = r0.a(r2)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x02cc }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x02cc }
            if (r0 == 0) goto L_0x0198
            java.lang.String r0 = "mtl"
            com.applovin.impl.sdk.m r2 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.y r2 = r2.ad()     // Catch:{ JSONException -> 0x02cc }
            int r2 = r2.b()     // Catch:{ JSONException -> 0x02cc }
            r3.put(r0, r2)     // Catch:{ JSONException -> 0x02cc }
        L_0x0198:
            com.applovin.impl.sdk.m r0 = r1.f15333b     // Catch:{ all -> 0x01cc }
            android.content.Context r0 = r0.L()     // Catch:{ all -> 0x01cc }
            java.lang.String r2 = "activity"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ all -> 0x01cc }
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch:{ all -> 0x01cc }
            android.app.ActivityManager$MemoryInfo r2 = new android.app.ActivityManager$MemoryInfo     // Catch:{ all -> 0x01cc }
            r2.<init>()     // Catch:{ all -> 0x01cc }
            if (r0 == 0) goto L_0x01cc
            r0.getMemoryInfo(r2)     // Catch:{ all -> 0x01cc }
            java.lang.String r0 = "fm"
            long r6 = r2.availMem     // Catch:{ all -> 0x01cc }
            r3.put(r0, r6)     // Catch:{ all -> 0x01cc }
            java.lang.String r0 = "tm"
            long r6 = r2.totalMem     // Catch:{ all -> 0x01cc }
            r3.put(r0, r6)     // Catch:{ all -> 0x01cc }
            java.lang.String r0 = "lmt"
            long r6 = r2.threshold     // Catch:{ all -> 0x01cc }
            r3.put(r0, r6)     // Catch:{ all -> 0x01cc }
            java.lang.String r0 = "lm"
            boolean r2 = r2.lowMemory     // Catch:{ all -> 0x01cc }
            r3.put(r0, r2)     // Catch:{ all -> 0x01cc }
        L_0x01cc:
            com.applovin.impl.sdk.m r0 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.AppLovinTargetingDataImpl r0 = r0.r()     // Catch:{ JSONException -> 0x02cc }
            java.util.Map r0 = r0.getAllData()     // Catch:{ JSONException -> 0x02cc }
            boolean r2 = r0.isEmpty()     // Catch:{ JSONException -> 0x02cc }
            if (r2 != 0) goto L_0x01e6
            java.lang.String r2 = "targeting_data"
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02cc }
            r4.<init>(r0)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x02cc }
        L_0x01e6:
            com.applovin.impl.sdk.m r0 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.o r0 = r0.V()     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.o$a r0 = r0.k()     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r2 = "dnt"
            boolean r4 = r0.f15743a     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.m r2 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r4 = com.applovin.impl.sdk.c.b.dx     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r2 = r2.a(r4)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ JSONException -> 0x02cc }
            boolean r2 = r2.booleanValue()     // Catch:{ JSONException -> 0x02cc }
            if (r2 == 0) goto L_0x0216
            java.lang.String r2 = r0.f15744b     // Catch:{ JSONException -> 0x02cc }
            boolean r2 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r2)     // Catch:{ JSONException -> 0x02cc }
            if (r2 == 0) goto L_0x0216
            java.lang.String r2 = "idfa"
            java.lang.String r0 = r0.f15744b     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r0)     // Catch:{ JSONException -> 0x02cc }
        L_0x0216:
            com.applovin.impl.sdk.m r0 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.o r0 = r0.V()     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.o$b r0 = r0.l()     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.m r2 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r4 = com.applovin.impl.sdk.c.b.dq     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r2 = r2.a(r4)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ JSONException -> 0x02cc }
            boolean r2 = r2.booleanValue()     // Catch:{ JSONException -> 0x02cc }
            if (r2 == 0) goto L_0x0240
            if (r0 == 0) goto L_0x0240
            java.lang.String r2 = "idfv"
            java.lang.String r4 = r0.f15745a     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r4)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r2 = "idfv_scope"
            int r0 = r0.f15746b     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r0)     // Catch:{ JSONException -> 0x02cc }
        L_0x0240:
            com.applovin.impl.sdk.m r0 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.sdk.AppLovinUserSegment r0 = r0.q()     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r0 = r0.getName()     // Catch:{ JSONException -> 0x02cc }
            boolean r2 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)     // Catch:{ JSONException -> 0x02cc }
            if (r2 == 0) goto L_0x025b
            java.lang.String r2 = "user_segment_name"
            com.applovin.impl.sdk.m r4 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.encodeUriString(r0, r4)     // Catch:{ JSONException -> 0x02cc }
            r3.put(r2, r0)     // Catch:{ JSONException -> 0x02cc }
        L_0x025b:
            com.applovin.impl.sdk.m r0 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.c.b.dt     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r0 = r0.a(r2)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x02cc }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x02cc }
            if (r0 == 0) goto L_0x0276
            java.lang.String r0 = "compass_random_token"
            com.applovin.impl.sdk.m r2 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r2 = r2.n()     // Catch:{ JSONException -> 0x02cc }
            r3.put(r0, r2)     // Catch:{ JSONException -> 0x02cc }
        L_0x0276:
            com.applovin.impl.sdk.m r0 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r2 = com.applovin.impl.sdk.c.b.dv     // Catch:{ JSONException -> 0x02cc }
            java.lang.Object r0 = r0.a(r2)     // Catch:{ JSONException -> 0x02cc }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ JSONException -> 0x02cc }
            boolean r0 = r0.booleanValue()     // Catch:{ JSONException -> 0x02cc }
            if (r0 == 0) goto L_0x0291
            java.lang.String r0 = "applovin_random_token"
            com.applovin.impl.sdk.m r2 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r2 = r2.o()     // Catch:{ JSONException -> 0x02cc }
            r3.put(r0, r2)     // Catch:{ JSONException -> 0x02cc }
        L_0x0291:
            com.applovin.impl.sdk.m r0 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.mediation.debugger.ui.testmode.b r0 = r0.J()     // Catch:{ JSONException -> 0x02cc }
            boolean r0 = r0.a()     // Catch:{ JSONException -> 0x02cc }
            if (r0 == 0) goto L_0x02a2
            java.lang.String r0 = "test_mode"
            r3.put(r0, r5)     // Catch:{ JSONException -> 0x02cc }
        L_0x02a2:
            com.applovin.impl.sdk.m r0 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.mediation.debugger.ui.testmode.b r0 = r0.J()     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r0 = r0.c()     // Catch:{ JSONException -> 0x02cc }
            boolean r2 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)     // Catch:{ JSONException -> 0x02cc }
            if (r2 == 0) goto L_0x02b7
            java.lang.String r2 = "test_mode_network"
            r3.put(r2, r0)     // Catch:{ JSONException -> 0x02cc }
        L_0x02b7:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02cc }
            com.applovin.impl.sdk.m r2 = r1.f15333b     // Catch:{ JSONException -> 0x02cc }
            com.applovin.sdk.AppLovinSdkSettings r2 = r2.p()     // Catch:{ JSONException -> 0x02cc }
            java.util.Map r2 = r2.getExtraParameters()     // Catch:{ JSONException -> 0x02cc }
            r0.<init>(r2)     // Catch:{ JSONException -> 0x02cc }
            java.lang.String r2 = "sdk_extra_parameters"
            r3.put(r2, r0)     // Catch:{ JSONException -> 0x02cc }
            goto L_0x02d8
        L_0x02cc:
            r0 = move-exception
            boolean r2 = com.applovin.impl.sdk.v.a()
            if (r2 == 0) goto L_0x02d8
            java.lang.String r2 = "Failed to construct JSON body"
            r1.a(r2, r0)
        L_0x02d8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.e.i.b():org.json.JSONObject");
    }

    public void run() {
        if (!g.i() && f15365a.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(this.f15333b.L());
            } catch (Throwable th) {
                if (v.a()) {
                    a("Cannot update security provider", th);
                }
            }
        }
        Map<String, String> a2 = a();
        c.a<T> c2 = c.a(this.f15333b).a(c()).c(h()).a(a2).a(b()).d(((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.b.ev)).booleanValue()).b("POST").a(new JSONObject()).a(((Integer) this.f15333b.a(com.applovin.impl.sdk.c.b.cY)).intValue()).c(((Integer) this.f15333b.a(com.applovin.impl.sdk.c.b.db)).intValue());
        m mVar = this.f15333b;
        com.applovin.impl.sdk.c.b bVar = com.applovin.impl.sdk.c.b.cX;
        c<T> a3 = c2.b(((Integer) mVar.a(bVar)).intValue()).a();
        this.f15333b.S().a((a) new b(this.f15333b), o.a.TIMEOUT, ((long) ((Integer) this.f15333b.a(bVar)).intValue()) + 250);
        AnonymousClass1 r12 = new u<JSONObject>(a3, this.f15333b, g()) {
            public void a(int i2, String str, JSONObject jSONObject) {
                if (v.a()) {
                    d("Unable to fetch basic SDK settings: server returned " + i2);
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                i.this.a(jSONObject);
            }

            public void a(JSONObject jSONObject, int i2) {
                i.this.a(jSONObject);
            }
        };
        r12.a(com.applovin.impl.sdk.c.b.aP);
        r12.b(com.applovin.impl.sdk.c.b.aQ);
        this.f15333b.S().a((a) r12);
    }
}
