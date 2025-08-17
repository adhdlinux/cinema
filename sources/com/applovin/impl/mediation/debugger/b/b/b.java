package com.applovin.impl.mediation.debugger.b.b;

import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.d.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements AppLovinCommunicatorSubscriber, Comparable<b> {
    private final Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.b> A;

    /* renamed from: a  reason: collision with root package name */
    private final m f14511a;

    /* renamed from: b  reason: collision with root package name */
    private final a f14512b;

    /* renamed from: c  reason: collision with root package name */
    private int f14513c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f14514d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f14515e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f14516f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f14517g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f14518h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f14519i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f14520j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f14521k;

    /* renamed from: l  reason: collision with root package name */
    private final String f14522l;

    /* renamed from: m  reason: collision with root package name */
    private final String f14523m;

    /* renamed from: n  reason: collision with root package name */
    private final String f14524n;

    /* renamed from: o  reason: collision with root package name */
    private String f14525o;

    /* renamed from: p  reason: collision with root package name */
    private final String f14526p;

    /* renamed from: q  reason: collision with root package name */
    private final String f14527q;

    /* renamed from: r  reason: collision with root package name */
    private final String f14528r;

    /* renamed from: s  reason: collision with root package name */
    private final int f14529s;

    /* renamed from: t  reason: collision with root package name */
    private final List<MaxAdFormat> f14530t;

    /* renamed from: u  reason: collision with root package name */
    private final List<d> f14531u;

    /* renamed from: v  reason: collision with root package name */
    private final List<a> f14532v;

    /* renamed from: w  reason: collision with root package name */
    private final List<String> f14533w;

    /* renamed from: x  reason: collision with root package name */
    private final c f14534x;

    /* renamed from: y  reason: collision with root package name */
    private final boolean f14535y;

    /* renamed from: z  reason: collision with root package name */
    private final String f14536z;

    public enum a {
        MISSING("MISSING"),
        INCOMPLETE_INTEGRATION("INCOMPLETE INTEGRATION"),
        INVALID_INTEGRATION("INVALID INTEGRATION"),
        COMPLETE("COMPLETE");
        

        /* renamed from: e  reason: collision with root package name */
        private final String f14542e;

        private a(String str) {
            this.f14542e = str;
        }

        /* access modifiers changed from: private */
        public String a() {
            return this.f14542e;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.b.b.b$b  reason: collision with other inner class name */
    public enum C0015b {
        NOT_SUPPORTED("Not Supported", -65536, "This network does not support test mode."),
        INVALID_INTEGRATION("Invalid Integration", -65536, "Please address all the integration issue(s) marked in red above."),
        NOT_INITIALIZED("Not Initialized", -65536, "Please configure this network in your MAX dashboard."),
        DISABLED("Enable", -16776961, "Please re-launch the app to enable test ads."),
        READY("", -16776961, "");
        

        /* renamed from: f  reason: collision with root package name */
        private final String f14549f;

        /* renamed from: g  reason: collision with root package name */
        private final int f14550g;

        /* renamed from: h  reason: collision with root package name */
        private final String f14551h;

        private C0015b(String str, int i2, String str2) {
            this.f14549f = str;
            this.f14550g = i2;
            this.f14551h = str2;
        }

        public String a() {
            return this.f14549f;
        }

        public int b() {
            return this.f14550g;
        }

        public String c() {
            return this.f14551h;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0160 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0214  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(org.json.JSONObject r19, com.applovin.impl.sdk.m r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.String r4 = "MediatedNetwork"
            r18.<init>()
            r1.f14511a = r3
            java.lang.String r0 = "name"
            java.lang.String r5 = ""
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            r1.f14522l = r0
            java.lang.String r0 = "display_name"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r0, r5)
            r1.f14523m = r0
            java.lang.String r6 = "adapter_class"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r6, r5)
            r1.f14524n = r0
            java.lang.String r7 = "latest_adapter_version"
            java.lang.String r7 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r7, r5)
            r1.f14527q = r7
            java.util.List r7 = r18.a((org.json.JSONObject) r19)
            r1.f14533w = r7
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            java.lang.String r8 = "hide_if_missing"
            java.lang.Boolean r8 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r2, r8, r7)
            boolean r8 = r8.booleanValue()
            r1.f14520j = r8
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r9 = "configuration"
            org.json.JSONObject r8 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r2, (java.lang.String) r9, (org.json.JSONObject) r8)
            java.util.List r9 = r1.a(r8, r3)
            r1.f14531u = r9
            com.applovin.impl.mediation.debugger.b.b.c r9 = new com.applovin.impl.mediation.debugger.b.b.c
            r9.<init>(r8, r3)
            r1.f14534x = r9
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            java.lang.String r10 = "test_mode"
            org.json.JSONObject r9 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r2, (java.lang.String) r10, (org.json.JSONObject) r9)
            java.lang.String r10 = "supported"
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            java.lang.Boolean r10 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r9, r10, r11)
            boolean r10 = r10.booleanValue()
            r1.f14518h = r10
            java.lang.String r10 = "test_mode_requires_init"
            java.lang.Boolean r7 = com.applovin.impl.sdk.utils.JsonUtils.getBoolean(r2, r10, r7)
            boolean r7 = r7.booleanValue()
            r1.f14519i = r7
            java.lang.String r7 = "message"
            r10 = 0
            java.lang.String r7 = com.applovin.impl.sdk.utils.JsonUtils.getString(r9, r7, r10)
            r1.f14528r = r7
            java.lang.String r7 = "existence_classes"
            java.util.List r7 = com.applovin.impl.sdk.utils.JsonUtils.getList(r2, r7, r10)
            if (r7 == 0) goto L_0x0096
            boolean r7 = com.applovin.impl.sdk.utils.Utils.checkClassesExistence(r7)
            goto L_0x00a0
        L_0x0096:
            java.lang.String r7 = "existence_class"
            java.lang.String r7 = com.applovin.impl.sdk.utils.JsonUtils.getString(r2, r7, r5)
            boolean r7 = com.applovin.impl.sdk.utils.Utils.checkClassExistence(r7)
        L_0x00a0:
            r1.f14514d = r7
            java.util.List r7 = java.util.Collections.emptyList()
            com.applovin.mediation.adapter.MaxAdapter r0 = com.applovin.impl.mediation.d.c.b(r0, r3)
            r9 = 1
            r11 = 0
            if (r0 == 0) goto L_0x012d
            r1.f14515e = r9
            java.lang.String r12 = r0.getAdapterVersion()     // Catch:{ all -> 0x00d2 }
            java.lang.String r13 = r0.getSdkVersion()     // Catch:{ all -> 0x00cf }
            if (r13 == 0) goto L_0x00bf
            java.lang.String r13 = r0.getSdkVersion()     // Catch:{ all -> 0x00cf }
            goto L_0x00c0
        L_0x00bf:
            r13 = r5
        L_0x00c0:
            java.util.List r7 = r1.a((com.applovin.mediation.adapter.MaxAdapter) r0)     // Catch:{ all -> 0x00cd }
            boolean r0 = r0.isBeta()     // Catch:{ all -> 0x00cd }
            r14 = r13
            r13 = r12
            r12 = r7
            r7 = r0
            goto L_0x00f7
        L_0x00cd:
            r0 = move-exception
            goto L_0x00d5
        L_0x00cf:
            r0 = move-exception
            r13 = r5
            goto L_0x00d5
        L_0x00d2:
            r0 = move-exception
            r12 = r5
            r13 = r12
        L_0x00d5:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Failed to load adapter for network "
            r14.append(r15)
            java.lang.String r15 = r1.f14522l
            r14.append(r15)
            java.lang.String r15 = ". Please check that you have a compatible network SDK integrated. Error: "
            r14.append(r15)
            r14.append(r0)
            java.lang.String r0 = r14.toString()
            com.applovin.impl.sdk.v.i(r4, r0)
            r14 = r13
            r13 = r12
            r12 = r7
            r7 = 0
        L_0x00f7:
            java.lang.String r0 = r1.f14524n     // Catch:{ all -> 0x011f }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x011f }
            java.lang.String r15 = "loadNativeAd"
            r10 = 3
            java.lang.Class[] r10 = new java.lang.Class[r10]     // Catch:{ all -> 0x011f }
            java.lang.Class<com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters> r16 = com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters.class
            r10[r11] = r16     // Catch:{ all -> 0x011f }
            java.lang.Class<android.app.Activity> r16 = android.app.Activity.class
            r10[r9] = r16     // Catch:{ all -> 0x011f }
            java.lang.Class<com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener> r16 = com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener.class
            r17 = 2
            r10[r17] = r16     // Catch:{ all -> 0x011f }
            java.lang.reflect.Method r10 = r0.getMethod(r15, r10)     // Catch:{ all -> 0x011f }
            java.lang.Class r10 = r10.getDeclaringClass()     // Catch:{ all -> 0x011f }
            boolean r0 = r10.equals(r0)     // Catch:{ all -> 0x011f }
            r4 = r7
            r7 = r12
            goto L_0x0133
        L_0x011f:
            r0 = move-exception
            com.applovin.impl.sdk.v r10 = r20.A()
            java.lang.String r15 = "Failed to check if adapter overrides MaxNativeAdAdapter"
            r10.b(r4, r15, r0)
            r4 = r7
            r7 = r12
            r0 = 0
            goto L_0x0133
        L_0x012d:
            r1.f14515e = r11
            r13 = r5
            r14 = r13
            r0 = 0
            r4 = 0
        L_0x0133:
            r1.f14526p = r13
            r1.f14525o = r14
            r1.f14530t = r7
            r1.f14521k = r0
            java.util.List r0 = r1.a(r8, r13, r3)
            r1.f14532v = r0
            java.lang.String r0 = "alternative_network"
            r7 = 0
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r2, (java.lang.String) r0, (org.json.JSONObject) r7)
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r0, r6, r5)
            boolean r0 = com.applovin.impl.sdk.utils.Utils.checkClassExistence(r0)
            r1.f14517g = r0
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = r18.A()
            r1.f14512b = r0
            java.lang.String r0 = r1.f14527q
            boolean r0 = r13.equals(r0)
            if (r0 != 0) goto L_0x0164
            if (r4 != 0) goto L_0x0164
            r0 = 1
            goto L_0x0165
        L_0x0164:
            r0 = 0
        L_0x0165:
            r1.f14516f = r0
            android.content.Context r0 = r20.L()
            java.lang.String r2 = r1.f14522l
            java.lang.String r3 = "_"
            int r2 = r2.lastIndexOf(r3)
            r3 = -1
            if (r2 == r3) goto L_0x0181
            java.lang.String r3 = r1.f14522l
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r2 = r3.substring(r11, r2)
            goto L_0x0187
        L_0x0181:
            java.lang.String r2 = r1.f14522l
            java.lang.String r2 = r2.toLowerCase()
        L_0x0187:
            android.content.res.Resources r3 = r0.getResources()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "applovin_ic_mediation_"
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r4 = "drawable"
            java.lang.String r5 = r0.getPackageName()
            int r2 = r3.getIdentifier(r2, r4, r5)
            r1.f14529s = r2
            com.applovin.mediation.adapter.MaxAdapter$InitializationStatus r2 = com.applovin.mediation.adapter.MaxAdapter.InitializationStatus.NOT_INITIALIZED
            int r2 = r2.getCode()
            r1.f14513c = r2
            com.applovin.communicator.AppLovinCommunicator r0 = com.applovin.communicator.AppLovinCommunicator.getInstance(r0)
            java.lang.String r2 = "adapter_initialization_status"
            r0.subscribe((com.applovin.communicator.AppLovinCommunicatorSubscriber) r1, (java.lang.String) r2)
            java.lang.String r0 = "amazon_marketplace"
            r2 = 0
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r8, (java.lang.String) r0, (org.json.JSONObject) r2)
            if (r0 == 0) goto L_0x0214
            boolean r3 = r1.f14514d
            if (r3 == 0) goto L_0x0214
            r1.f14535y = r9
            java.lang.String r3 = "test_mode_app_id"
            java.lang.String r3 = com.applovin.impl.sdk.utils.JsonUtils.getString(r0, r3, r2)
            r1.f14536z = r3
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "test_mode_slot_ids"
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r0, (java.lang.String) r3, (org.json.JSONObject) r2)
            java.util.HashMap r2 = new java.util.HashMap
            int r3 = r0.length()
            r2.<init>(r3)
            java.util.Iterator r3 = r0.keys()
        L_0x01e8:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0219
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            com.applovin.mediation.MaxAdFormat r5 = com.applovin.mediation.MaxAdFormat.formatFromString(r4)
            r6 = 0
            org.json.JSONObject r4 = com.applovin.impl.sdk.utils.JsonUtils.getJSONObject((org.json.JSONObject) r0, (java.lang.String) r4, (org.json.JSONObject) r6)
            if (r5 == 0) goto L_0x01e8
            if (r4 != 0) goto L_0x0202
            goto L_0x01e8
        L_0x0202:
            java.lang.String r7 = "uuid"
            java.lang.String r7 = com.applovin.impl.sdk.utils.JsonUtils.getString(r4, r7, r6)
            if (r7 != 0) goto L_0x020b
            goto L_0x01e8
        L_0x020b:
            com.applovin.impl.mediation.debugger.a.b r6 = new com.applovin.impl.mediation.debugger.a.b
            r6.<init>(r7, r4, r5)
            r2.put(r5, r6)
            goto L_0x01e8
        L_0x0214:
            r1.f14535y = r11
            r2 = 0
            r1.f14536z = r2
        L_0x0219:
            r1.A = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.b.b.b.<init>(org.json.JSONObject, com.applovin.impl.sdk.m):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        r0 = com.applovin.impl.mediation.debugger.b.b.b.a.f14537a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        if (r3.f14517g != false) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r3.f14515e != false) goto L_0x0014;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.applovin.impl.mediation.debugger.b.b.b.a A() {
        /*
            r3 = this;
            boolean r0 = r3.f14514d
            if (r0 == 0) goto L_0x0010
            boolean r0 = r3.f14515e
            if (r0 == 0) goto L_0x000b
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = com.applovin.impl.mediation.debugger.b.b.b.a.COMPLETE
            goto L_0x0019
        L_0x000b:
            boolean r0 = r3.f14517g
            if (r0 == 0) goto L_0x0014
            goto L_0x0017
        L_0x0010:
            boolean r0 = r3.f14515e
            if (r0 == 0) goto L_0x0017
        L_0x0014:
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = com.applovin.impl.mediation.debugger.b.b.b.a.INCOMPLETE_INTEGRATION
            goto L_0x0019
        L_0x0017:
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = com.applovin.impl.mediation.debugger.b.b.b.a.MISSING
        L_0x0019:
            com.applovin.impl.mediation.debugger.b.b.b$a r1 = com.applovin.impl.mediation.debugger.b.b.b.a.MISSING
            if (r0 != r1) goto L_0x001e
            return r0
        L_0x001e:
            java.util.List<com.applovin.impl.mediation.debugger.b.b.d> r1 = r3.f14531u
            java.util.Iterator r1 = r1.iterator()
        L_0x0024:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r1.next()
            com.applovin.impl.mediation.debugger.b.b.d r2 = (com.applovin.impl.mediation.debugger.b.b.d) r2
            boolean r2 = r2.c()
            if (r2 != 0) goto L_0x0024
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = com.applovin.impl.mediation.debugger.b.b.b.a.INVALID_INTEGRATION
            return r0
        L_0x0039:
            java.util.List<com.applovin.impl.mediation.debugger.b.b.a> r1 = r3.f14532v
            java.util.Iterator r1 = r1.iterator()
        L_0x003f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0054
            java.lang.Object r2 = r1.next()
            com.applovin.impl.mediation.debugger.b.b.a r2 = (com.applovin.impl.mediation.debugger.b.b.a) r2
            boolean r2 = r2.c()
            if (r2 != 0) goto L_0x003f
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = com.applovin.impl.mediation.debugger.b.b.b.a.INVALID_INTEGRATION
            return r0
        L_0x0054:
            com.applovin.impl.mediation.debugger.b.b.c r1 = r3.f14534x
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x0066
            com.applovin.impl.mediation.debugger.b.b.c r1 = r3.f14534x
            boolean r1 = r1.b()
            if (r1 != 0) goto L_0x0066
            com.applovin.impl.mediation.debugger.b.b.b$a r0 = com.applovin.impl.mediation.debugger.b.b.b.a.INVALID_INTEGRATION
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.debugger.b.b.b.A():com.applovin.impl.mediation.debugger.b.b.b$a");
    }

    private List<MaxAdFormat> a(MaxAdapter maxAdapter) {
        ArrayList arrayList = new ArrayList(5);
        if (maxAdapter instanceof MaxInterstitialAdapter) {
            arrayList.add(MaxAdFormat.INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxRewardedAdapter) {
            arrayList.add(MaxAdFormat.REWARDED);
        }
        if (maxAdapter instanceof MaxRewardedInterstitialAdapter) {
            arrayList.add(MaxAdFormat.REWARDED_INTERSTITIAL);
        }
        if (maxAdapter instanceof MaxAdViewAdapter) {
            arrayList.add(MaxAdFormat.BANNER);
            arrayList.add(MaxAdFormat.LEADER);
            arrayList.add(MaxAdFormat.MREC);
        }
        if (maxAdapter instanceof MaxNativeAdAdapter) {
            arrayList.add(MaxAdFormat.NATIVE);
        }
        return arrayList;
    }

    private List<String> a(JSONObject jSONObject) {
        return JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "supported_regions", (JSONArray) null), (List) null);
    }

    private List<d> a(JSONObject jSONObject, m mVar) {
        ArrayList arrayList = new ArrayList();
        if (this.f14524n.equals("com.applovin.mediation.adapters.AppLovinMediationAdapter")) {
            d dVar = new d("com.google.android.gms.permission.AD_ID", "Please add\n<uses-permission android:name=\"com.google.android.gms.permission.AD_ID\" />\nto your AndroidManifest.xml", mVar.L());
            if (dVar.c()) {
                arrayList.add(dVar);
            }
        }
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "permissions", new JSONObject());
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                arrayList.add(new d(next, jSONObject2.getString(next), mVar.L()));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    private List<a> a(JSONObject jSONObject, String str, m mVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "dependencies", new JSONArray());
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "dependencies_v2", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length() + jSONArray2.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i2, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new a(jSONObject2, mVar));
            }
        }
        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray2, i3, (JSONObject) null);
            if (jSONObject3 != null && a.a(str, JsonUtils.getString(jSONObject3, "min_adapter_version", (String) null), JsonUtils.getString(jSONObject3, "max_adapter_version", (String) null))) {
                arrayList.add(new a(jSONObject3, mVar));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        return this.f14523m.compareToIgnoreCase(bVar.f14523m);
    }

    public a a() {
        return this.f14512b;
    }

    public int b() {
        return this.f14513c;
    }

    public C0015b c() {
        return !this.f14518h ? C0015b.NOT_SUPPORTED : this.f14512b == a.INVALID_INTEGRATION ? C0015b.INVALID_INTEGRATION : !this.f14511a.J().a() ? C0015b.DISABLED : (!this.f14519i || !(this.f14513c == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE.getCode() || this.f14513c == MaxAdapter.InitializationStatus.INITIALIZING.getCode())) ? C0015b.READY : C0015b.NOT_INITIALIZED;
    }

    public boolean d() {
        return this.f14514d;
    }

    public boolean e() {
        return this.f14515e;
    }

    public boolean f() {
        return this.f14516f;
    }

    public boolean g() {
        return this.f14512b == a.MISSING && this.f14520j;
    }

    public String getCommunicatorId() {
        return "MediatedNetwork";
    }

    public String h() {
        return this.f14522l;
    }

    public String i() {
        return this.f14523m;
    }

    public String j() {
        return this.f14525o;
    }

    public String k() {
        return this.f14526p;
    }

    public String l() {
        return this.f14527q;
    }

    public String m() {
        return this.f14524n;
    }

    public List<String> n() {
        return this.f14533w;
    }

    public int o() {
        return this.f14529s;
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        String string = appLovinCommunicatorMessage.getMessageData().getString("adapter_class", "");
        if (this.f14524n.equals(string)) {
            this.f14513c = appLovinCommunicatorMessage.getMessageData().getInt("init_status", 0);
            MaxAdapter b2 = c.b(string, this.f14511a);
            if (b2 != null && !this.f14525o.equals(b2.getSdkVersion())) {
                this.f14525o = b2.getSdkVersion();
                this.f14511a.ag().a(this.f14525o, string);
            }
        }
    }

    public List<MaxAdFormat> p() {
        return this.f14530t;
    }

    public boolean q() {
        return this.f14521k;
    }

    public List<d> r() {
        return this.f14531u;
    }

    public List<a> s() {
        return this.f14532v;
    }

    public final c t() {
        return this.f14534x;
    }

    public String toString() {
        return "MediatedNetwork{name=" + this.f14522l + ", displayName=" + this.f14523m + ", sdkAvailable=" + this.f14514d + ", sdkVersion=" + this.f14525o + ", adapterAvailable=" + this.f14515e + ", adapterVersion=" + this.f14526p + "}";
    }

    public String u() {
        return this.f14528r;
    }

    public final m v() {
        return this.f14511a;
    }

    public final String w() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n---------- ");
        sb.append(this.f14522l);
        sb.append(" ----------");
        sb.append("\nStatus  - ");
        sb.append(this.f14512b.a());
        sb.append("\nSDK     - ");
        String str = "UNAVAILABLE";
        sb.append((!this.f14514d || TextUtils.isEmpty(this.f14525o)) ? str : this.f14525o);
        sb.append("\nAdapter - ");
        if (this.f14515e && !TextUtils.isEmpty(this.f14526p)) {
            str = this.f14526p;
        }
        sb.append(str);
        if (this.f14534x.a() && !this.f14534x.b()) {
            sb.append("\n* ");
            sb.append(this.f14534x.c());
        }
        for (d next : r()) {
            if (!next.c()) {
                sb.append("\n* MISSING ");
                sb.append(next.a());
                sb.append(": ");
                sb.append(next.b());
            }
        }
        for (a next2 : s()) {
            if (!next2.c()) {
                sb.append("\n* MISSING ");
                sb.append(next2.a());
                sb.append(": ");
                sb.append(next2.b());
            }
        }
        return sb.toString();
    }

    public boolean x() {
        return this.f14535y;
    }

    public String y() {
        return this.f14536z;
    }

    public Map<MaxAdFormat, com.applovin.impl.mediation.debugger.a.b> z() {
        return this.A;
    }
}
