package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.view.f.a;
import com.facebook.ads.internal.view.f.b.b;
import com.facebook.ads.internal.view.f.b.d;
import com.facebook.ads.internal.view.f.b.l;
import com.facebook.ads.internal.view.f.c.d;
import com.facebook.ads.internal.view.f.c.e;
import com.facebook.ads.internal.view.f.c.i;
import com.facebook.ads.internal.view.f.c.k;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class j extends s {

    /* renamed from: e  reason: collision with root package name */
    static final /* synthetic */ boolean f19832e = true;

    /* renamed from: a  reason: collision with root package name */
    protected c f19833a;

    /* renamed from: b  reason: collision with root package name */
    protected a f19834b;

    /* renamed from: c  reason: collision with root package name */
    protected JSONObject f19835c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f19836d;

    /* renamed from: f  reason: collision with root package name */
    private final f<b> f19837f = new f<b>() {
        public Class<b> a() {
            return b.class;
        }

        public void a(b bVar) {
            if (j.this.f19841j != null) {
                j.this.f19841j.d(j.this);
            }
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final f<l> f19838g = new f<l>() {
        public Class<l> a() {
            return l.class;
        }

        public void a(l lVar) {
            boolean unused = j.this.f19843l = true;
            if (j.this.f19841j != null) {
                j.this.f19841j.a(j.this);
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final f<d> f19839h = new f<d>() {
        public Class<d> a() {
            return d.class;
        }

        public void a(d dVar) {
            if (j.this.f19841j != null) {
                j.this.f19841j.a((s) j.this, AdError.INTERNAL_ERROR);
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final f<com.facebook.ads.internal.view.f.b.a> f19840i = new f<com.facebook.ads.internal.view.f.b.a>() {
        public Class<com.facebook.ads.internal.view.f.b.a> a() {
            return com.facebook.ads.internal.view.f.b.a.class;
        }

        public void a(com.facebook.ads.internal.view.f.b.a aVar) {
            if (j.this.f19841j != null) {
                j.this.f19841j.b(j.this);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public com.facebook.ads.a.a f19841j;

    /* renamed from: k  reason: collision with root package name */
    private String f19842k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f19843l = false;

    /* renamed from: m  reason: collision with root package name */
    private com.facebook.ads.internal.view.f.c f19844m;

    /* renamed from: n  reason: collision with root package name */
    private String f19845n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f19846o = false;

    /* renamed from: p  reason: collision with root package name */
    private com.facebook.ads.internal.d.b f19847p;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x00b7, code lost:
        if (r13.isNull(r0) == false) goto L_0x00bc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r17, com.facebook.ads.a.a r18, org.json.JSONObject r19, com.facebook.ads.internal.m.c r20, android.os.Bundle r21, java.util.EnumSet<com.facebook.ads.CacheFlag> r22, int r23) {
        /*
            r16 = this;
            r9 = r16
            r10 = r17
            r0 = r19
            r11 = r21
            r9.f19836d = r10
            r1 = r18
            r9.f19841j = r1
            r12 = r20
            r9.f19833a = r12
            r9.f19835c = r0
            r1 = 0
            r9.f19843l = r1
            java.lang.String r2 = "video"
            org.json.JSONObject r13 = r0.getJSONObject(r2)
            java.lang.String r2 = "ct"
            java.lang.String r0 = r0.optString(r2)
            r9.f19845n = r0
            com.facebook.ads.internal.view.f.a r0 = new com.facebook.ads.internal.view.f.a
            r0.<init>(r10)
            r9.f19834b = r0
            r2 = r23
            r0.setVideoProgressReportIntervalMs(r2)
            r16.a()
            com.facebook.ads.internal.view.f.a r0 = r9.f19834b
            com.facebook.ads.internal.j.e r0 = r0.getEventBus()
            r2 = 4
            com.facebook.ads.internal.j.f[] r2 = new com.facebook.ads.internal.j.f[r2]
            com.facebook.ads.internal.j.f<com.facebook.ads.internal.view.f.b.b> r3 = r9.f19837f
            r2[r1] = r3
            r1 = 1
            com.facebook.ads.internal.j.f<com.facebook.ads.internal.view.f.b.l> r3 = r9.f19838g
            r2[r1] = r3
            r1 = 2
            com.facebook.ads.internal.j.f<com.facebook.ads.internal.view.f.b.d> r3 = r9.f19839h
            r2[r1] = r3
            r1 = 3
            com.facebook.ads.internal.j.f<com.facebook.ads.internal.view.f.b.a> r3 = r9.f19840i
            r2[r1] = r3
            r0.a((T[]) r2)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.facebook.ads.internal.adapters.j$5 r15 = new com.facebook.ads.internal.adapters.j$5
            r2 = 4502148214488346440(0x3e7ad7f29abcaf48, double:1.0E-7)
            r4 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r6 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            r8 = 0
            r0 = r15
            r1 = r16
            r0.<init>(r2, r4, r6, r8)
            r14.add(r15)
            if (r11 == 0) goto L_0x008b
            com.facebook.ads.internal.view.f.b r8 = new com.facebook.ads.internal.view.f.b
            com.facebook.ads.internal.view.f.a r3 = r9.f19834b
            java.lang.String r5 = r9.f19845n
            java.lang.String r0 = "logger"
            android.os.Bundle r6 = r11.getBundle(r0)
            r7 = 0
            r0 = r8
            r1 = r17
            r2 = r20
            r4 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r9.f19844m = r8
            goto L_0x009c
        L_0x008b:
            com.facebook.ads.internal.view.f.b r6 = new com.facebook.ads.internal.view.f.b
            com.facebook.ads.internal.view.f.a r3 = r9.f19834b
            java.lang.String r5 = r9.f19845n
            r0 = r6
            r1 = r17
            r2 = r20
            r4 = r14
            r0.<init>((android.content.Context) r1, (com.facebook.ads.internal.m.c) r2, (com.facebook.ads.internal.view.f.a) r3, (java.util.List<com.facebook.ads.internal.b.b>) r4, (java.lang.String) r5)
            r9.f19844m = r6
        L_0x009c:
            com.facebook.ads.a.a r0 = r9.f19841j
            com.facebook.ads.internal.view.f.a r1 = r9.f19834b
            r0.a((com.facebook.ads.internal.adapters.s) r9, (android.view.View) r1)
            com.facebook.ads.internal.q.a.s$a r0 = com.facebook.ads.internal.q.a.s.a(r17)
            com.facebook.ads.internal.q.a.s$a r1 = com.facebook.ads.internal.q.a.s.a.MOBILE_INTERNET
            if (r0 != r1) goto L_0x00ba
            java.lang.String r0 = "videoHDURL"
            boolean r1 = r13.has(r0)
            if (r1 == 0) goto L_0x00ba
            boolean r1 = r13.isNull(r0)
            if (r1 != 0) goto L_0x00ba
            goto L_0x00bc
        L_0x00ba:
            java.lang.String r0 = "videoURL"
        L_0x00bc:
            java.lang.String r0 = r13.getString(r0)
            r9.f19842k = r0
            com.facebook.ads.CacheFlag r0 = com.facebook.ads.CacheFlag.VIDEO
            r1 = r22
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L_0x00e3
            com.facebook.ads.internal.d.b r0 = new com.facebook.ads.internal.d.b
            r0.<init>(r10)
            r9.f19847p = r0
            java.lang.String r1 = r9.f19842k
            r0.a((java.lang.String) r1)
            com.facebook.ads.internal.d.b r0 = r9.f19847p
            com.facebook.ads.internal.adapters.j$6 r1 = new com.facebook.ads.internal.adapters.j$6
            r1.<init>()
            r0.a((com.facebook.ads.internal.d.a) r1)
            goto L_0x00ec
        L_0x00e3:
            com.facebook.ads.internal.view.f.a r0 = r9.f19834b
            java.lang.String r1 = r16.h()
            r0.setVideoURI((java.lang.String) r1)
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.j.a(android.content.Context, com.facebook.ads.a.a, org.json.JSONObject, com.facebook.ads.internal.m.c, android.os.Bundle, java.util.EnumSet, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.f19842k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String h() {
        /*
            r2 = this;
            com.facebook.ads.internal.d.b r0 = r2.f19847p
            if (r0 == 0) goto L_0x000d
            java.lang.String r1 = r2.f19842k
            if (r1 == 0) goto L_0x000d
            java.lang.String r0 = r0.b((java.lang.String) r1)
            goto L_0x000f
        L_0x000d:
            java.lang.String r0 = ""
        L_0x000f:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0017
            java.lang.String r0 = r2.f19842k
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.j.h():java.lang.String");
    }

    /* access modifiers changed from: protected */
    public void a() {
        boolean z2 = f19832e;
        if (!z2 && this.f19836d == null) {
            throw new AssertionError();
        } else if (z2 || this.f19835c != null) {
            JSONObject optJSONObject = this.f19835c.optJSONObject("text");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.f19834b.a((com.facebook.ads.internal.view.f.a.b) new k(this.f19836d));
            com.facebook.ads.internal.view.f.c.l lVar = new com.facebook.ads.internal.view.f.c.l(this.f19836d);
            this.f19834b.a((com.facebook.ads.internal.view.f.a.b) lVar);
            this.f19834b.a((com.facebook.ads.internal.view.f.a.b) new com.facebook.ads.internal.view.f.c.d(lVar, d.a.INVSIBLE));
            this.f19834b.a((com.facebook.ads.internal.view.f.a.b) new com.facebook.ads.internal.view.f.c.b(this.f19836d));
            String b2 = b();
            if (b2 != null) {
                com.facebook.ads.internal.view.f.c.c cVar = new com.facebook.ads.internal.view.f.c.c(this.f19836d, b2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                cVar.setLayoutParams(layoutParams);
                cVar.setCountdownTextColor(-1);
                this.f19834b.a((com.facebook.ads.internal.view.f.a.b) cVar);
            }
            if (this.f19835c.has("cta") && !this.f19835c.isNull("cta")) {
                JSONObject jSONObject = this.f19835c.getJSONObject("cta");
                e eVar = new e(this.f19836d, jSONObject.getString(ImagesContract.URL), this.f19833a, this.f19845n, jSONObject.getString("text"));
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(10);
                layoutParams2.addRule(11);
                eVar.setLayoutParams(layoutParams2);
                this.f19834b.a((com.facebook.ads.internal.view.f.a.b) eVar);
            }
            String d2 = d();
            if (!TextUtils.isEmpty(d2)) {
                this.f19834b.a((com.facebook.ads.internal.view.f.a.b) new com.facebook.ads.internal.view.f.c.a(this.f19836d, d2, this.f19845n, new float[]{0.0f, 0.0f, 8.0f, 0.0f}));
            }
            int c2 = c();
            if (c2 > 0) {
                i iVar = new i(this.f19836d, c2, optJSONObject.optString("skipAdIn", "Skip Ad in"), optJSONObject.optString("skipAd", "Skip Ad"));
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(12);
                layoutParams3.addRule(11);
                iVar.setLayoutParams(layoutParams3);
                iVar.setPadding(0, 0, 0, 30);
                this.f19834b.a((com.facebook.ads.internal.view.f.a.b) iVar);
            }
        } else {
            throw new AssertionError();
        }
    }

    public final void a(Context context, com.facebook.ads.a.a aVar, c cVar, Bundle bundle, EnumSet<CacheFlag> enumSet) {
        try {
            JSONObject jSONObject = new JSONObject(bundle.getString("ad_response"));
            a(context, aVar, jSONObject, cVar, bundle, enumSet, jSONObject.optInt("video_time_polling_interval", 200));
        } catch (JSONException unused) {
            aVar.a((s) this, AdError.INTERNAL_ERROR);
        }
    }

    public final void a(Context context, com.facebook.ads.a.a aVar, Map<String, Object> map, c cVar, EnumSet<CacheFlag> enumSet) {
        try {
            JSONObject jSONObject = (JSONObject) map.get("data");
            com.facebook.ads.internal.h.d dVar = (com.facebook.ads.internal.h.d) map.get("definition");
            a(context, aVar, jSONObject, cVar, (Bundle) null, enumSet, dVar == null ? 200 : dVar.k());
        } catch (JSONException unused) {
            aVar.a((s) this, AdError.INTERNAL_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    public String b() {
        if (f19832e || this.f19835c != null) {
            try {
                JSONObject jSONObject = this.f19835c.getJSONObject("capabilities");
                if (jSONObject.has("countdown")) {
                    if (!jSONObject.isNull("countdown")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("countdown");
                        if (jSONObject2.has("format")) {
                            return jSONObject2.optString("format");
                        }
                    }
                }
                return null;
            } catch (Exception e2) {
                Log.w(String.valueOf(j.class), "Invalid JSON", e2);
                return null;
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: protected */
    public int c() {
        if (f19832e || this.f19835c != null) {
            try {
                JSONObject jSONObject = this.f19835c.getJSONObject("capabilities");
                if (jSONObject.has("skipButton")) {
                    if (!jSONObject.isNull("skipButton")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("skipButton");
                        if (jSONObject2.has("skippableSeconds")) {
                            return jSONObject2.getInt("skippableSeconds");
                        }
                    }
                }
                return -1;
            } catch (Exception e2) {
                Log.w(String.valueOf(j.class), "Invalid JSON", e2);
                return -1;
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: protected */
    public String d() {
        if (f19832e || this.f19835c != null) {
            try {
                JSONObject jSONObject = this.f19835c.getJSONObject("capabilities");
                if (jSONObject.has("adChoices")) {
                    if (!jSONObject.isNull("adChoices")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("adChoices");
                        if (jSONObject2.has(ImagesContract.URL)) {
                            return jSONObject2.getString(ImagesContract.URL);
                        }
                    }
                }
                return null;
            } catch (Exception e2) {
                Log.w(String.valueOf(j.class), "Invalid JSON", e2);
                return null;
            }
        } else {
            throw new AssertionError();
        }
    }

    public boolean e() {
        if (!this.f19843l || this.f19834b == null) {
            return false;
        }
        if (this.f19844m.j() > 0) {
            this.f19834b.a(this.f19844m.j());
        }
        this.f19834b.a(com.facebook.ads.internal.view.f.a.a.AUTO_STARTED);
        return true;
    }

    /* access modifiers changed from: protected */
    public void f() {
        c cVar = this.f19833a;
        if (cVar != null && !this.f19846o) {
            this.f19846o = true;
            cVar.a(this.f19845n, new HashMap());
            com.facebook.ads.a.a aVar = this.f19841j;
            if (aVar != null) {
                aVar.c(this);
            }
        }
    }

    public Bundle g() {
        if (this.f19844m == null || this.f19835c == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("logger", this.f19844m.g());
        bundle.putString("ad_response", this.f19835c.toString());
        return bundle;
    }

    public void onDestroy() {
        a aVar = this.f19834b;
        if (aVar != null) {
            aVar.f();
            this.f19834b.k();
        }
        this.f19841j = null;
        this.f19833a = null;
        this.f19842k = null;
        this.f19843l = false;
        this.f19845n = null;
        this.f19834b = null;
        this.f19844m = null;
        this.f19835c = null;
        this.f19836d = null;
        this.f19846o = false;
    }
}
