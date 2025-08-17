package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.facebook.ads.internal.a.d;
import com.facebook.ads.internal.a.e;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.j.b;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.n.f;
import com.facebook.ads.internal.n.h;
import com.facebook.ads.internal.n.j;
import com.facebook.ads.internal.n.k;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.q.a.q;
import com.facebook.ads.internal.q.a.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class m extends y implements e.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19901a = "m";
    private int A;
    private String B;
    private String C;
    private com.facebook.ads.internal.n.m D;
    private int E = 200;
    private String F;
    private h G;
    private String H;
    private String I;
    private k J;
    private List<f> K;
    private int L = -1;
    private int M;
    /* access modifiers changed from: private */
    public String N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private long T = 0;
    private a.C0033a U = null;
    /* access modifiers changed from: private */
    public c V;
    private f.c W;

    /* renamed from: b  reason: collision with root package name */
    private Context f19902b;

    /* renamed from: c  reason: collision with root package name */
    private z f19903c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f19904d;

    /* renamed from: e  reason: collision with root package name */
    private String f19905e;

    /* renamed from: f  reason: collision with root package name */
    private String f19906f;

    /* renamed from: g  reason: collision with root package name */
    private String f19907g;

    /* renamed from: h  reason: collision with root package name */
    private String f19908h;

    /* renamed from: i  reason: collision with root package name */
    private String f19909i;

    /* renamed from: j  reason: collision with root package name */
    private String f19910j;

    /* renamed from: k  reason: collision with root package name */
    private String f19911k;

    /* renamed from: l  reason: collision with root package name */
    private String f19912l;

    /* renamed from: m  reason: collision with root package name */
    private String f19913m;

    /* renamed from: n  reason: collision with root package name */
    private String f19914n;

    /* renamed from: o  reason: collision with root package name */
    private String f19915o;

    /* renamed from: p  reason: collision with root package name */
    private h f19916p;

    /* renamed from: q  reason: collision with root package name */
    private h f19917q;

    /* renamed from: r  reason: collision with root package name */
    private j f19918r;

    /* renamed from: s  reason: collision with root package name */
    private String f19919s;

    /* renamed from: t  reason: collision with root package name */
    private d f19920t;

    /* renamed from: u  reason: collision with root package name */
    private Collection<String> f19921u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f19922v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f19923w;

    /* renamed from: x  reason: collision with root package name */
    private int f19924x;

    /* renamed from: y  reason: collision with root package name */
    private int f19925y;

    /* renamed from: z  reason: collision with root package name */
    private int f19926z;

    private boolean M() {
        return ((!this.O && !TextUtils.isEmpty(this.f19905e)) || (!TextUtils.isEmpty(this.f19906f) && this.O)) && (this.f19916p != null || this.O) && (this.f19917q != null || getPlacementType() == AdPlacementType.NATIVE_BANNER);
    }

    private void N() {
        if (!this.S) {
            c cVar = this.V;
            if (cVar != null) {
                cVar.a(this.f19919s);
            }
            this.S = true;
        }
    }

    private void a(Context context, JSONObject jSONObject, c cVar, String str, int i2, int i3) {
        this.O = true;
        this.f19902b = context;
        this.V = cVar;
        this.L = i2;
        this.M = i3;
        a(jSONObject, str);
    }

    private void a(Map<String, String> map, final Map<String, String> map2) {
        try {
            final Map<String, String> c2 = c(map);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (!TextUtils.isEmpty(m.this.N)) {
                        HashMap hashMap = new HashMap();
                        hashMap.putAll(map2);
                        hashMap.putAll(c2);
                        if (m.this.V != null) {
                            m.this.V.f(m.this.N, hashMap);
                        }
                    }
                }
            }, (long) (this.f19924x * 1000));
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x018b A[Catch:{ JSONException -> 0x01b1 }, LOOP:0: B:44:0x0189->B:45:0x018b, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r13, java.lang.String r14) {
        /*
            r12 = this;
            boolean r0 = r12.P
            if (r0 != 0) goto L_0x01c3
            if (r13 != 0) goto L_0x0007
            return
        L_0x0007:
            android.content.Context r0 = r12.f19902b
            java.lang.String r1 = "Audience Network Loaded"
            com.facebook.ads.internal.q.a.d.a(r0, r1)
            r12.N = r14
            java.lang.String r0 = "fbad_command"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto L_0x001f
            r0 = r2
            goto L_0x0023
        L_0x001f:
            android.net.Uri r0 = android.net.Uri.parse(r0)
        L_0x0023:
            r12.f19904d = r0
            java.lang.String r0 = "advertiser_name"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.f19905e = r0
            java.lang.String r0 = "title"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.f19906f = r0
            java.lang.String r0 = "subtitle"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.f19907g = r0
            java.lang.String r0 = "headline"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.f19908h = r0
            java.lang.String r0 = "body"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.f19909i = r0
            java.lang.String r0 = "call_to_action"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.f19910j = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x005d
            r12.f19910j = r2
        L_0x005d:
            java.lang.String r0 = "social_context"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.f19911k = r0
            java.lang.String r0 = "link_description"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.f19912l = r0
            java.lang.String r0 = "sponsored_translation"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.f19913m = r0
            java.lang.String r0 = "ad_translation"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.f19914n = r0
            java.lang.String r0 = "promoted_translation"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.f19915o = r0
            java.lang.String r0 = "icon"
            org.json.JSONObject r0 = r13.optJSONObject(r0)
            com.facebook.ads.internal.n.h r0 = com.facebook.ads.internal.n.h.a(r0)
            r12.f19916p = r0
            java.lang.String r0 = "image"
            org.json.JSONObject r0 = r13.optJSONObject(r0)
            com.facebook.ads.internal.n.h r0 = com.facebook.ads.internal.n.h.a(r0)
            r12.f19917q = r0
            java.lang.String r0 = "star_rating"
            org.json.JSONObject r0 = r13.optJSONObject(r0)
            com.facebook.ads.internal.n.j r0 = com.facebook.ads.internal.n.j.a(r0)
            r12.f19918r = r0
            java.lang.String r0 = "used_report_url"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.f19919s = r0
            java.lang.String r0 = "enable_view_log"
            boolean r0 = r13.optBoolean(r0)
            r12.f19922v = r0
            java.lang.String r0 = "enable_snapshot_log"
            boolean r0 = r13.optBoolean(r0)
            r12.f19923w = r0
            java.lang.String r0 = "snapshot_log_delay_second"
            r1 = 4
            int r0 = r13.optInt(r0, r1)
            r12.f19924x = r0
            java.lang.String r0 = "snapshot_compress_quality"
            r1 = 0
            int r0 = r13.optInt(r0, r1)
            r12.f19925y = r0
            java.lang.String r0 = "viewability_check_initial_delay"
            int r0 = r13.optInt(r0, r1)
            r12.f19926z = r0
            java.lang.String r0 = "viewability_check_interval"
            r3 = 1000(0x3e8, float:1.401E-42)
            int r0 = r13.optInt(r0, r3)
            r12.A = r0
            java.lang.String r0 = "ad_choices_icon"
            org.json.JSONObject r0 = r13.optJSONObject(r0)
            java.lang.String r3 = "native_ui_config"
            org.json.JSONObject r3 = r13.optJSONObject(r3)
            if (r3 == 0) goto L_0x0100
            int r4 = r3.length()     // Catch:{ JSONException -> 0x0104 }
            if (r4 != 0) goto L_0x00fa
            goto L_0x0100
        L_0x00fa:
            com.facebook.ads.internal.n.k r4 = new com.facebook.ads.internal.n.k     // Catch:{ JSONException -> 0x0104 }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x0104 }
            goto L_0x0101
        L_0x0100:
            r4 = r2
        L_0x0101:
            r12.J = r4     // Catch:{ JSONException -> 0x0104 }
            goto L_0x0106
        L_0x0104:
            r12.J = r2
        L_0x0106:
            if (r0 == 0) goto L_0x010e
            com.facebook.ads.internal.n.h r0 = com.facebook.ads.internal.n.h.a(r0)
            r12.G = r0
        L_0x010e:
            java.lang.String r0 = "ad_choices_link_url"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.H = r0
            java.lang.String r0 = "request_id"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.I = r0
            java.lang.String r0 = "invalidation_behavior"
            java.lang.String r0 = r13.optString(r0)
            com.facebook.ads.internal.a.d r0 = com.facebook.ads.internal.a.d.a(r0)
            r12.f19920t = r0
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r3 = "detection_strings"
            java.lang.String r3 = r13.optString(r3)     // Catch:{ JSONException -> 0x0136 }
            r0.<init>(r3)     // Catch:{ JSONException -> 0x0136 }
            goto L_0x013b
        L_0x0136:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r2
        L_0x013b:
            java.util.Collection r0 = com.facebook.ads.internal.a.e.a(r0)
            r12.f19921u = r0
            java.lang.String r0 = "video_url"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.B = r0
            java.lang.String r0 = "video_mpd"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.C = r0
            java.lang.String r0 = "video_autoplay_enabled"
            boolean r3 = r13.has(r0)
            if (r3 != 0) goto L_0x015e
            com.facebook.ads.internal.n.m r0 = com.facebook.ads.internal.n.m.DEFAULT
        L_0x015b:
            r12.D = r0
            goto L_0x016a
        L_0x015e:
            boolean r0 = r13.optBoolean(r0)
            if (r0 == 0) goto L_0x0167
            com.facebook.ads.internal.n.m r0 = com.facebook.ads.internal.n.m.ON
            goto L_0x015b
        L_0x0167:
            com.facebook.ads.internal.n.m r0 = com.facebook.ads.internal.n.m.OFF
            goto L_0x015b
        L_0x016a:
            java.lang.String r0 = "video_report_url"
            java.lang.String r0 = com.facebook.ads.internal.q.a.k.a(r13, r0)
            r12.F = r0
            java.lang.String r0 = "carousel"
            org.json.JSONArray r13 = r13.optJSONArray(r0)     // Catch:{ JSONException -> 0x01b1 }
            if (r13 == 0) goto L_0x01b9
            int r0 = r13.length()     // Catch:{ JSONException -> 0x01b1 }
            if (r0 <= 0) goto L_0x01b9
            int r0 = r13.length()     // Catch:{ JSONException -> 0x01b1 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ JSONException -> 0x01b1 }
            r10.<init>(r0)     // Catch:{ JSONException -> 0x01b1 }
        L_0x0189:
            if (r1 >= r0) goto L_0x01ae
            com.facebook.ads.internal.adapters.m r11 = new com.facebook.ads.internal.adapters.m     // Catch:{ JSONException -> 0x01b1 }
            r11.<init>()     // Catch:{ JSONException -> 0x01b1 }
            android.content.Context r4 = r12.f19902b     // Catch:{ JSONException -> 0x01b1 }
            org.json.JSONObject r5 = r13.getJSONObject(r1)     // Catch:{ JSONException -> 0x01b1 }
            com.facebook.ads.internal.m.c r6 = r12.V     // Catch:{ JSONException -> 0x01b1 }
            r3 = r11
            r7 = r14
            r8 = r1
            r9 = r0
            r3.a(r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x01b1 }
            com.facebook.ads.internal.n.f r3 = new com.facebook.ads.internal.n.f     // Catch:{ JSONException -> 0x01b1 }
            android.content.Context r4 = r12.f19902b     // Catch:{ JSONException -> 0x01b1 }
            com.facebook.ads.internal.n.f$c r5 = r12.W     // Catch:{ JSONException -> 0x01b1 }
            r3.<init>(r4, r11, r2, r5)     // Catch:{ JSONException -> 0x01b1 }
            r10.add(r3)     // Catch:{ JSONException -> 0x01b1 }
            int r1 = r1 + 1
            goto L_0x0189
        L_0x01ae:
            r12.K = r10     // Catch:{ JSONException -> 0x01b1 }
            goto L_0x01b9
        L_0x01b1:
            r13 = move-exception
            java.lang.String r14 = f19901a
            java.lang.String r0 = "Unable to parse carousel data."
            android.util.Log.e(r14, r0, r13)
        L_0x01b9:
            r13 = 1
            r12.P = r13
            boolean r13 = r12.M()
            r12.Q = r13
            return
        L_0x01c3:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "Adapter already loaded data"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.m.a(org.json.JSONObject, java.lang.String):void");
    }

    private Map<String, String> c(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map.containsKey("view")) {
            hashMap.put("view", map.get("view"));
        }
        if (map.containsKey("snapshot")) {
            hashMap.put("snapshot", map.get("snapshot"));
        }
        return hashMap;
    }

    public String A() {
        if (!c_()) {
            return null;
        }
        return this.B;
    }

    public String B() {
        if (!c_()) {
            return null;
        }
        return this.C;
    }

    public com.facebook.ads.internal.n.m C() {
        return !c_() ? com.facebook.ads.internal.n.m.DEFAULT : this.D;
    }

    public int D() {
        return this.E;
    }

    public String E() {
        return this.F;
    }

    public List<f> F() {
        if (!c_()) {
            return null;
        }
        return this.K;
    }

    public int G() {
        return this.L;
    }

    public int H() {
        return this.M;
    }

    public com.facebook.ads.internal.n.c I() {
        return com.facebook.ads.internal.n.c.AN;
    }

    public String K() {
        if (!c_()) {
            return null;
        }
        N();
        return this.f19909i;
    }

    public boolean L() {
        return this.O;
    }

    public d a() {
        return this.f19920t;
    }

    public void a(int i2) {
        a.C0033a aVar;
        if (c_() && i2 == 0) {
            long j2 = this.T;
            if (j2 > 0 && (aVar = this.U) != null) {
                b.a(a.a(j2, aVar, this.I));
                this.T = 0;
                this.U = null;
            }
        }
    }

    public void a(Context context, z zVar, c cVar, Map<String, Object> map, f.c cVar2) {
        this.f19902b = context;
        this.f19903c = zVar;
        this.V = cVar;
        this.W = cVar2;
        JSONObject jSONObject = (JSONObject) map.get("data");
        com.facebook.ads.internal.h.d dVar = (com.facebook.ads.internal.h.d) map.get("definition");
        this.E = dVar != null ? dVar.k() : 200;
        a(jSONObject, com.facebook.ads.internal.q.a.k.a(jSONObject, "ct"));
        if (e.a(context, this, cVar)) {
            zVar.a(this, new com.facebook.ads.internal.protocol.a(AdErrorType.NO_FILL, "No Fill"));
            return;
        }
        if (zVar != null) {
            zVar.a(this);
        }
        a.f20219a = this.I;
    }

    public void a(View view, List<View> list) {
    }

    public void a(z zVar) {
        this.f19903c = zVar;
    }

    public void a(Map<String, String> map) {
        c cVar;
        if (c_() && !this.R) {
            z zVar = this.f19903c;
            if (zVar != null) {
                zVar.b(this);
            }
            HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            if (this.O) {
                hashMap.put("cardind", String.valueOf(this.L));
                hashMap.put("cardcnt", String.valueOf(this.M));
            }
            if (!TextUtils.isEmpty(c()) && (cVar = this.V) != null) {
                cVar.a(c(), hashMap);
            }
            if (e() || d()) {
                a(map, (Map<String, String>) hashMap);
            }
            this.R = true;
        }
    }

    public boolean a_() {
        return c_() && this.f19904d != null;
    }

    public Collection<String> b() {
        return this.f19921u;
    }

    public void b(Map<String, String> map) {
        if (c_()) {
            if (!com.facebook.ads.internal.l.a.c(this.f19902b) || !z.a(map)) {
                HashMap hashMap = new HashMap();
                if (map != null) {
                    hashMap.putAll(map);
                }
                com.facebook.ads.internal.q.a.d.a(this.f19902b, "Click logged");
                z zVar = this.f19903c;
                if (zVar != null) {
                    zVar.c(this);
                }
                if (this.O) {
                    hashMap.put("cardind", String.valueOf(this.L));
                    hashMap.put("cardcnt", String.valueOf(this.M));
                }
                com.facebook.ads.internal.a.b a2 = com.facebook.ads.internal.a.c.a(this.f19902b, this.V, this.N, this.f19904d, hashMap);
                if (a2 != null) {
                    try {
                        this.T = System.currentTimeMillis();
                        this.U = a2.a();
                        a2.b();
                    } catch (Exception e2) {
                        Log.e(f19901a, "Error executing action", e2);
                    }
                }
            } else {
                Log.e(f19901a, "Click happened on lockscreen ad");
            }
        }
    }

    public void b_() {
        List<f> list = this.K;
        if (list != null && !list.isEmpty()) {
            for (f J2 : this.K) {
                J2.J();
            }
        }
    }

    public String c() {
        return this.N;
    }

    public boolean c_() {
        return this.P && this.Q;
    }

    public boolean d() {
        return c_() && this.f19923w;
    }

    public boolean e() {
        return c_() && this.f19922v;
    }

    public boolean f() {
        return c_() && this.J != null;
    }

    public boolean g() {
        return true;
    }

    public int h() {
        int i2 = this.f19925y;
        if (i2 < 0 || i2 > 100) {
            return 0;
        }
        return i2;
    }

    public int i() {
        return this.f19926z;
    }

    public int j() {
        return this.A;
    }

    public h k() {
        if (!c_()) {
            return null;
        }
        return this.f19916p;
    }

    public h l() {
        if (!c_()) {
            return null;
        }
        return this.f19917q;
    }

    public k m() {
        if (!c_()) {
            return null;
        }
        return this.J;
    }

    public String n() {
        if (!c_()) {
            return null;
        }
        N();
        return this.f19905e;
    }

    public String o() {
        if (!c_()) {
            return null;
        }
        N();
        return this.f19908h;
    }

    public void onDestroy() {
    }

    public String p() {
        if (!c_()) {
            return null;
        }
        N();
        return q.a(this.f19909i);
    }

    public String q() {
        if (!c_()) {
            return null;
        }
        N();
        return this.f19910j;
    }

    public String r() {
        if (!c_()) {
            return null;
        }
        N();
        return this.f19911k;
    }

    public String s() {
        if (!c_()) {
            return null;
        }
        N();
        return this.f19912l;
    }

    public String t() {
        if (!c_()) {
            return null;
        }
        N();
        return this.f19913m;
    }

    public String u() {
        if (!c_()) {
            return null;
        }
        N();
        return this.f19914n;
    }

    public String v() {
        if (!c_()) {
            return null;
        }
        N();
        return this.f19915o;
    }

    public j w() {
        if (!c_()) {
            return null;
        }
        N();
        return this.f19918r;
    }

    public h x() {
        if (!c_()) {
            return null;
        }
        return this.G;
    }

    public String y() {
        if (!c_()) {
            return null;
        }
        return this.H;
    }

    public String z() {
        if (!c_()) {
            return null;
        }
        return "AdChoices";
    }
}
