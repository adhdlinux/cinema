package com.facebook.ads.internal.adapters;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.internal.n.c;
import com.facebook.ads.internal.n.f;
import com.facebook.ads.internal.n.h;
import com.facebook.ads.internal.n.j;
import com.facebook.ads.internal.n.k;
import com.facebook.ads.internal.n.m;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAdView;
import com.google.android.gms.ads.formats.NativeContentAdView;
import java.util.List;
import java.util.Map;

public class d extends y implements u {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19764a = "d";

    /* renamed from: b  reason: collision with root package name */
    private View f19765b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public NativeAd f19766c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public z f19767d;

    /* renamed from: e  reason: collision with root package name */
    private NativeAdView f19768e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public View f19769f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f19770g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Uri f19771h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Uri f19772i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f19773j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public String f19774k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public String f19775l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public String f19776m;

    private void a(View view) {
        ViewGroup viewGroup;
        if (view != null && (viewGroup = (ViewGroup) view.getParent()) != null) {
            viewGroup.removeView(view);
        }
    }

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
        return c.ADMOB;
    }

    public f J() {
        return f.ADMOB;
    }

    public void a(int i2) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(final android.content.Context r11, com.facebook.ads.internal.adapters.z r12, com.facebook.ads.internal.m.c r13, java.util.Map<java.lang.String, java.lang.Object> r14, com.facebook.ads.internal.n.f.c r15) {
        /*
            r10 = this;
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            com.facebook.ads.internal.adapters.f r15 = r10.J()
            java.lang.String r15 = com.facebook.ads.internal.adapters.v.a(r15)
            r13.append(r15)
            java.lang.String r15 = " Loading"
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            com.facebook.ads.internal.q.a.d.a(r11, r13)
            java.lang.String r13 = "data"
            java.lang.Object r13 = r14.get(r13)
            org.json.JSONObject r13 = (org.json.JSONObject) r13
            java.lang.String r14 = "ad_unit_id"
            java.lang.String r14 = r13.optString(r14)
            java.lang.String r15 = "creative_types"
            org.json.JSONArray r13 = r13.optJSONArray(r15)
            java.lang.String r15 = "Server Error"
            java.lang.String r0 = " AN server error"
            r1 = 1
            r2 = 0
            if (r13 == 0) goto L_0x009c
            int r3 = r13.length()
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x003f:
            if (r4 >= r3) goto L_0x009a
            java.lang.String r7 = r13.getString(r4)     // Catch:{ JSONException -> 0x0076 }
            if (r7 == 0) goto L_0x0073
            int r8 = r7.hashCode()     // Catch:{ JSONException -> 0x0076 }
            r9 = 704091517(0x29f7957d, float:1.09949356E-13)
            if (r8 == r9) goto L_0x0060
            r9 = 883765328(0x34ad3050, float:3.2258913E-7)
            if (r8 == r9) goto L_0x0056
            goto L_0x006a
        L_0x0056:
            java.lang.String r8 = "page_post"
            boolean r7 = r7.equals(r8)     // Catch:{ JSONException -> 0x0076 }
            if (r7 == 0) goto L_0x006a
            r7 = 1
            goto L_0x006b
        L_0x0060:
            java.lang.String r8 = "app_install"
            boolean r7 = r7.equals(r8)     // Catch:{ JSONException -> 0x0076 }
            if (r7 == 0) goto L_0x006a
            r7 = 0
            goto L_0x006b
        L_0x006a:
            r7 = -1
        L_0x006b:
            if (r7 == 0) goto L_0x0072
            if (r7 == r1) goto L_0x0070
            goto L_0x0073
        L_0x0070:
            r6 = 1
            goto L_0x0073
        L_0x0072:
            r5 = 1
        L_0x0073:
            int r4 = r4 + 1
            goto L_0x003f
        L_0x0076:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            com.facebook.ads.internal.adapters.f r14 = r10.J()
            java.lang.String r14 = com.facebook.ads.internal.adapters.v.a(r14)
            r13.append(r14)
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            com.facebook.ads.internal.q.a.d.a(r11, r13)
            com.facebook.ads.internal.protocol.AdErrorType r11 = com.facebook.ads.internal.protocol.AdErrorType.SERVER_ERROR
            com.facebook.ads.internal.protocol.a r11 = com.facebook.ads.internal.protocol.a.a(r11, r15)
            r12.a(r10, r11)
            return
        L_0x009a:
            r2 = r5
            goto L_0x009d
        L_0x009c:
            r6 = 0
        L_0x009d:
            boolean r13 = android.text.TextUtils.isEmpty(r14)
            if (r13 != 0) goto L_0x00ee
            if (r2 != 0) goto L_0x00a8
            if (r6 != 0) goto L_0x00a8
            goto L_0x00ee
        L_0x00a8:
            r10.f19767d = r12
            com.google.android.gms.ads.AdLoader$Builder r12 = new com.google.android.gms.ads.AdLoader$Builder
            r12.<init>(r11, r14)
            if (r2 == 0) goto L_0x00b9
            com.facebook.ads.internal.adapters.d$1 r13 = new com.facebook.ads.internal.adapters.d$1
            r13.<init>(r11)
            r12.forAppInstallAd(r13)
        L_0x00b9:
            if (r6 == 0) goto L_0x00c3
            com.facebook.ads.internal.adapters.d$2 r13 = new com.facebook.ads.internal.adapters.d$2
            r13.<init>(r11)
            r12.forContentAd(r13)
        L_0x00c3:
            com.facebook.ads.internal.adapters.d$3 r13 = new com.facebook.ads.internal.adapters.d$3
            r13.<init>(r11)
            com.google.android.gms.ads.AdLoader$Builder r11 = r12.withAdListener(r13)
            com.google.android.gms.ads.formats.NativeAdOptions$Builder r12 = new com.google.android.gms.ads.formats.NativeAdOptions$Builder
            r12.<init>()
            com.google.android.gms.ads.formats.NativeAdOptions$Builder r12 = r12.setReturnUrlsForImageAssets(r1)
            com.google.android.gms.ads.formats.NativeAdOptions r12 = r12.build()
            com.google.android.gms.ads.AdLoader$Builder r11 = r11.withNativeAdOptions((com.google.android.gms.ads.formats.NativeAdOptions) r12)
            com.google.android.gms.ads.AdLoader r11 = r11.build()
            com.google.android.gms.ads.AdRequest$Builder r12 = new com.google.android.gms.ads.AdRequest$Builder
            r12.<init>()
            com.google.android.gms.ads.AdRequest r12 = r12.build()
            r11.loadAd((com.google.android.gms.ads.AdRequest) r12)
            return
        L_0x00ee:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            com.facebook.ads.internal.adapters.f r14 = r10.J()
            java.lang.String r14 = com.facebook.ads.internal.adapters.v.a(r14)
            r13.append(r14)
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            com.facebook.ads.internal.q.a.d.a(r11, r13)
            com.facebook.ads.internal.protocol.AdErrorType r11 = com.facebook.ads.internal.protocol.AdErrorType.SERVER_ERROR
            com.facebook.ads.internal.protocol.a r11 = com.facebook.ads.internal.protocol.a.a(r11, r15)
            r12.a(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.d.a(android.content.Context, com.facebook.ads.internal.adapters.z, com.facebook.ads.internal.m.c, java.util.Map, com.facebook.ads.internal.n.f$c):void");
    }

    public void a(View view, List<View> list) {
        throw null;
    }

    public void a(z zVar) {
        this.f19767d = zVar;
    }

    public void a(Map<String, String> map) {
        z zVar;
        if (c_() && (zVar = this.f19767d) != null) {
            zVar.b(this);
        }
    }

    public void b(Map<String, String> map) {
    }

    public void b_() {
        ViewGroup viewGroup;
        a(this.f19769f);
        this.f19769f = null;
        View view = this.f19765b;
        if (view != null) {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (((viewGroup2 instanceof NativeContentAdView) || (viewGroup2 instanceof NativeAppInstallAdView)) && (viewGroup = (ViewGroup) viewGroup2.getParent()) != null) {
                int indexOfChild = viewGroup.indexOfChild(viewGroup2);
                a(this.f19765b);
                a((View) viewGroup2);
                viewGroup.addView(this.f19765b, indexOfChild);
            }
            this.f19765b = null;
        }
        this.f19768e = null;
    }

    public String c() {
        return null;
    }

    public boolean c_() {
        return this.f19770g && this.f19766c != null;
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
        return false;
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
        Uri uri;
        if (!c_() || (uri = this.f19772i) == null) {
            return null;
        }
        return new h(uri.toString(), 50, 50);
    }

    public h l() {
        Uri uri;
        if (!c_() || (uri = this.f19771h) == null) {
            return null;
        }
        return new h(uri.toString(), 1200, 600);
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
        this.f19767d = null;
        this.f19766c = null;
        this.f19770g = false;
        this.f19771h = null;
        this.f19772i = null;
        this.f19773j = null;
        this.f19774k = null;
        this.f19775l = null;
        this.f19776m = null;
    }

    public String p() {
        return this.f19774k;
    }

    public String q() {
        return this.f19775l;
    }

    public String r() {
        return this.f19776m;
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
        return null;
    }
}
