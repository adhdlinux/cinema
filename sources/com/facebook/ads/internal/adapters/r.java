package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.ads.internal.n.c;
import com.facebook.ads.internal.n.f;
import com.facebook.ads.internal.n.h;
import com.facebook.ads.internal.n.j;
import com.facebook.ads.internal.n.k;
import com.facebook.ads.internal.n.m;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.a;
import com.facebook.ads.internal.q.a.d;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiNative;
import com.inmobi.sdk.InMobiSdk;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class r extends y implements u {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public z f19978a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public InMobiNative f19979b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f19980c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public View f19981d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f19982e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f19983f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f19984g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public j f19985h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public h f19986i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public h f19987j;

    public String A() {
        return null;
    }

    public String B() {
        return null;
    }

    public m C() {
        return m.DEFAULT;
    }

    public int D() {
        return 0;
    }

    public String E() {
        return null;
    }

    public List<f> F() {
        return null;
    }

    public int G() {
        return 0;
    }

    public int H() {
        return 0;
    }

    public c I() {
        return c.INMOBI;
    }

    public f J() {
        return f.INMOBI;
    }

    public void a(int i2) {
    }

    public void a(final Context context, z zVar, com.facebook.ads.internal.m.c cVar, Map<String, Object> map, f.c cVar2) {
        d.a(context, v.a(J()) + " Loading");
        JSONObject jSONObject = (JSONObject) map.get("data");
        String optString = jSONObject.optString("account_id");
        Long valueOf = Long.valueOf(jSONObject.optLong("placement_id"));
        if (TextUtils.isEmpty(optString) || valueOf == null) {
            zVar.a(this, new a(AdErrorType.MEDIATION_ERROR, "Mediation Error"));
            return;
        }
        this.f19978a = zVar;
        InMobiSdk.init(context, optString);
        InMobiNative inMobiNative = new InMobiNative(valueOf.longValue(), new InMobiNative.NativeAdListener() {
            public void onAdDismissed(InMobiNative inMobiNative) {
            }

            public void onAdDisplayed(InMobiNative inMobiNative) {
            }

            public void onAdLoadFailed(InMobiNative inMobiNative, InMobiAdRequestStatus inMobiAdRequestStatus) {
                Context context = context;
                d.a(context, v.a(r.this.J()) + " Failed with InMobi error: " + inMobiAdRequestStatus.getMessage());
                if (r.this.f19978a != null) {
                    r.this.f19978a.a(r.this, new a(AdErrorType.MEDIATION_ERROR.getErrorCode(), inMobiAdRequestStatus.getMessage()));
                }
            }

            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0084 */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x0092 A[Catch:{ Exception -> 0x00d4 }] */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x00a8 A[Catch:{ Exception -> 0x00d4 }] */
            /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onAdLoadSucceeded(com.inmobi.ads.InMobiNative r10) {
                /*
                    r9 = this;
                    org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d4 }
                    java.lang.Object r1 = r10.getAdContent()     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x00d4 }
                    r0.<init>(r1)     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.r r1 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r2 = "title"
                    java.lang.String r2 = r0.optString(r2)     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String unused = r1.f19982e = r2     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.r r1 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r2 = "description"
                    java.lang.String r2 = r0.optString(r2)     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String unused = r1.f19983f = r2     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.r r1 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r2 = "cta"
                    java.lang.String r2 = r0.optString(r2)     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String unused = r1.f19984g = r2     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r1 = "icon"
                    org.json.JSONObject r1 = r0.optJSONObject(r1)     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r2 = "url"
                    java.lang.String r3 = "height"
                    java.lang.String r4 = "width"
                    if (r1 == 0) goto L_0x0050
                    int r5 = r1.optInt(r4)     // Catch:{ Exception -> 0x00d4 }
                    int r6 = r1.optInt(r3)     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r1 = r1.optString(r2)     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.r r7 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.n.h r8 = new com.facebook.ads.internal.n.h     // Catch:{ Exception -> 0x00d4 }
                    r8.<init>(r1, r5, r6)     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.n.h unused = r7.f19986i = r8     // Catch:{ Exception -> 0x00d4 }
                L_0x0050:
                    java.lang.String r1 = "screenshots"
                    org.json.JSONObject r1 = r0.optJSONObject(r1)     // Catch:{ Exception -> 0x00d4 }
                    if (r1 == 0) goto L_0x006e
                    int r4 = r1.optInt(r4)     // Catch:{ Exception -> 0x00d4 }
                    int r3 = r1.optInt(r3)     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r1 = r1.optString(r2)     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.r r2 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.n.h r5 = new com.facebook.ads.internal.n.h     // Catch:{ Exception -> 0x00d4 }
                    r5.<init>(r1, r4, r3)     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.n.h unused = r2.f19987j = r5     // Catch:{ Exception -> 0x00d4 }
                L_0x006e:
                    java.lang.String r1 = "rating"
                    java.lang.String r0 = r0.optString(r1)     // Catch:{ Exception -> 0x00d4 }
                    double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0084 }
                    com.facebook.ads.internal.adapters.r r2 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x0084 }
                    com.facebook.ads.internal.n.j r3 = new com.facebook.ads.internal.n.j     // Catch:{ Exception -> 0x0084 }
                    r4 = 4617315517961601024(0x4014000000000000, double:5.0)
                    r3.<init>(r0, r4)     // Catch:{ Exception -> 0x0084 }
                    com.facebook.ads.internal.n.j unused = r2.f19985h = r3     // Catch:{ Exception -> 0x0084 }
                L_0x0084:
                    com.facebook.ads.internal.adapters.r r0 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    r1 = 1
                    boolean unused = r0.f19980c = r1     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.r r0 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    android.view.View r0 = r0.f19981d     // Catch:{ Exception -> 0x00d4 }
                    if (r0 == 0) goto L_0x00a0
                    com.facebook.ads.internal.adapters.r r0 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    com.inmobi.ads.InMobiNative unused = r0.f19979b     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.r r0 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    android.view.View r0 = r0.f19981d     // Catch:{ Exception -> 0x00d4 }
                    com.inmobi.ads.InMobiNative.bind(r0, r10)     // Catch:{ Exception -> 0x00d4 }
                L_0x00a0:
                    com.facebook.ads.internal.adapters.r r10 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.z r10 = r10.f19978a     // Catch:{ Exception -> 0x00d4 }
                    if (r10 == 0) goto L_0x0110
                    android.content.Context r10 = r3     // Catch:{ Exception -> 0x00d4 }
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d4 }
                    r0.<init>()     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.r r1 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.f r1 = r1.J()     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r1 = com.facebook.ads.internal.adapters.v.a(r1)     // Catch:{ Exception -> 0x00d4 }
                    r0.append(r1)     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r1 = " Loaded"
                    r0.append(r1)     // Catch:{ Exception -> 0x00d4 }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.q.a.d.a(r10, r0)     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.r r10 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.z r10 = r10.f19978a     // Catch:{ Exception -> 0x00d4 }
                    com.facebook.ads.internal.adapters.r r0 = com.facebook.ads.internal.adapters.r.this     // Catch:{ Exception -> 0x00d4 }
                    r10.a(r0)     // Catch:{ Exception -> 0x00d4 }
                    goto L_0x0110
                L_0x00d4:
                    com.facebook.ads.internal.adapters.r r10 = com.facebook.ads.internal.adapters.r.this
                    com.facebook.ads.internal.adapters.z r10 = r10.f19978a
                    if (r10 == 0) goto L_0x0110
                    android.content.Context r10 = r3
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    com.facebook.ads.internal.adapters.r r1 = com.facebook.ads.internal.adapters.r.this
                    com.facebook.ads.internal.adapters.f r1 = r1.J()
                    java.lang.String r1 = com.facebook.ads.internal.adapters.v.a(r1)
                    r0.append(r1)
                    java.lang.String r1 = " Failed. Internal AN SDK error"
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    com.facebook.ads.internal.q.a.d.a(r10, r0)
                    com.facebook.ads.internal.adapters.r r10 = com.facebook.ads.internal.adapters.r.this
                    com.facebook.ads.internal.adapters.z r10 = r10.f19978a
                    com.facebook.ads.internal.adapters.r r0 = com.facebook.ads.internal.adapters.r.this
                    com.facebook.ads.internal.protocol.AdErrorType r1 = com.facebook.ads.internal.protocol.AdErrorType.INTERNAL_ERROR
                    java.lang.String r2 = "Internal Error"
                    com.facebook.ads.internal.protocol.a r1 = com.facebook.ads.internal.protocol.a.a(r1, r2)
                    r10.a(r0, r1)
                L_0x0110:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.r.AnonymousClass1.onAdLoadSucceeded(com.inmobi.ads.InMobiNative):void");
            }

            public void onUserLeftApplication(InMobiNative inMobiNative) {
            }
        });
        this.f19979b = inMobiNative;
        inMobiNative.load();
    }

    public void a(View view, List<View> list) {
        this.f19981d = view;
        if (c_()) {
            InMobiNative.bind(this.f19981d, this.f19979b);
        }
    }

    public void a(z zVar) {
        this.f19978a = zVar;
    }

    public void a(Map<String, String> map) {
        this.f19978a.b(this);
    }

    public void b(Map<String, String> map) {
        if (c_()) {
            this.f19978a.c(this);
            this.f19979b.reportAdClickAndOpenLandingPage((Map) null);
        }
    }

    public void b_() {
        if (c_()) {
            InMobiNative.unbind(this.f19981d);
        }
        this.f19981d = null;
    }

    public String c() {
        return null;
    }

    public boolean c_() {
        return this.f19979b != null && this.f19980c;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return true;
    }

    public int h() {
        return 0;
    }

    public int i() {
        return 0;
    }

    public int j() {
        return 0;
    }

    public h k() {
        return this.f19986i;
    }

    public h l() {
        return this.f19987j;
    }

    public k m() {
        return null;
    }

    public String n() {
        return null;
    }

    public String o() {
        return null;
    }

    public void onDestroy() {
        b_();
        this.f19979b = null;
        this.f19978a = null;
    }

    public String p() {
        return this.f19983f;
    }

    public String q() {
        return this.f19984g;
    }

    public String r() {
        return null;
    }

    public String s() {
        return null;
    }

    public String t() {
        return null;
    }

    public String u() {
        return null;
    }

    public String v() {
        return null;
    }

    public j w() {
        return null;
    }

    public h x() {
        return null;
    }

    public String y() {
        return null;
    }

    public String z() {
        return "Ad";
    }
}
