package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.n7;
import com.chartboost.sdk.impl.u;
import com.facebook.hermes.intl.Constants;
import com.facebook.imageutils.JfifUtil;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import com.vungle.ads.internal.model.AdPayload;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class x8 {

    /* renamed from: a  reason: collision with root package name */
    public final q1 f18947a;

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public String f18969a;

        /* renamed from: b  reason: collision with root package name */
        public String f18970b;

        /* renamed from: c  reason: collision with root package name */
        public String f18971c;

        /* renamed from: d  reason: collision with root package name */
        public String f18972d;

        /* renamed from: e  reason: collision with root package name */
        public List f18973e;

        /* renamed from: f  reason: collision with root package name */
        public List f18974f;

        public c(String str, String str2, String str3, String str4, List list, List list2) {
            Intrinsics.f(str, "id");
            Intrinsics.f(str2, "nbr");
            Intrinsics.f(str3, "currency");
            Intrinsics.f(str4, "bidId");
            Intrinsics.f(list, "seatbidList");
            Intrinsics.f(list2, "assets");
            this.f18969a = str;
            this.f18970b = str2;
            this.f18971c = str3;
            this.f18972d = str4;
            this.f18973e = list;
            this.f18974f = list2;
        }

        public final List a() {
            return this.f18974f;
        }

        public final Map b() {
            List list = this.f18974f;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.b(MapsKt__MapsJVMKt.d(CollectionsKt__IterablesKt.p(list, 10)), 16));
            for (Object next : list) {
                linkedHashMap.put(((f1) next).f17672b, next);
            }
            return MapsKt__MapsKt.w(linkedHashMap);
        }

        public final List c() {
            return this.f18973e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.a(this.f18969a, cVar.f18969a) && Intrinsics.a(this.f18970b, cVar.f18970b) && Intrinsics.a(this.f18971c, cVar.f18971c) && Intrinsics.a(this.f18972d, cVar.f18972d) && Intrinsics.a(this.f18973e, cVar.f18973e) && Intrinsics.a(this.f18974f, cVar.f18974f);
        }

        public int hashCode() {
            return (((((((((this.f18969a.hashCode() * 31) + this.f18970b.hashCode()) * 31) + this.f18971c.hashCode()) * 31) + this.f18972d.hashCode()) * 31) + this.f18973e.hashCode()) * 31) + this.f18974f.hashCode();
        }

        public String toString() {
            return "OpenRTBModel(id=" + this.f18969a + ", nbr=" + this.f18970b + ", currency=" + this.f18971c + ", bidId=" + this.f18972d + ", seatbidList=" + this.f18973e + ", assets=" + this.f18974f + ')';
        }
    }

    public x8(q1 q1Var) {
        Intrinsics.f(q1Var, "base64Wrapper");
        this.f18947a = q1Var;
    }

    public final v a(u uVar, JSONObject jSONObject) {
        u uVar2 = uVar;
        JSONObject jSONObject2 = jSONObject;
        Intrinsics.f(uVar2, "adType");
        if (jSONObject2 != null) {
            c d2 = d(jSONObject2);
            a b2 = b(c(d2.c()).a());
            b b3 = b2.b();
            f1 a2 = a(d2.a());
            f1 f1Var = a2;
            Map b4 = d2.b();
            Map map = b4;
            b4.put("body", a2);
            String m2 = b3.m();
            String str = m2;
            String a3 = g0.a(m2);
            LinkedHashMap linkedHashMap = r2;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("imptrackers", b3.g());
            LinkedHashMap linkedHashMap3 = r2;
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            a((Map) linkedHashMap4, b2, uVar2);
            return new v("", b3.a(), b3.b(), b3.f(), b3.h(), b3.c(), "", b3.e(), map, str, a3, "", "", "", 0, "", "dummy_template", f1Var, linkedHashMap3, b3.j(), b3.k(), linkedHashMap, b2.a(), b3.i(), g0.a(b2.c()), l3.f18098c.a(b3.d()), this.f18947a.b(b2.a()));
        }
        throw new JSONException("Missing response");
    }

    public final String b(u uVar) {
        if (Intrinsics.a(uVar, u.a.f18735g)) {
            return "10";
        }
        if (Intrinsics.a(uVar, u.b.f18736g)) {
            return "8";
        }
        if (Intrinsics.a(uVar, u.c.f18737g)) {
            return "9";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final d c(List list) {
        d dVar = (d) CollectionsKt___CollectionsKt.D(list);
        return dVar == null ? new d((String) null, (List) null, 3, (DefaultConstructorMarker) null) : dVar;
    }

    public final c d(JSONObject jSONObject) {
        List<JSONObject> asList;
        b bVar;
        JSONObject jSONObject2 = jSONObject;
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject2.optJSONArray("seatbid");
        b bVar2 = new b((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, 0, (String) null, (n7) null, (aa) null, (List) null, 8191, (DefaultConstructorMarker) null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!(optJSONArray == null || (asList = r5.asList(optJSONArray)) == null)) {
            for (JSONObject jSONObject3 : asList) {
                String optString = jSONObject3.optString("seat");
                JSONArray optJSONArray2 = jSONObject3.optJSONArray("bid");
                if (optJSONArray2 != null) {
                    Intrinsics.e(optJSONArray2, "bidArray");
                    List<JSONObject> asList2 = r5.asList(optJSONArray2);
                    if (asList2 != null) {
                        for (JSONObject jSONObject4 : asList2) {
                            JSONObject optJSONObject = jSONObject4.optJSONObject("ext");
                            if (optJSONObject != null) {
                                Intrinsics.e(optJSONObject, "optJSONObject(\"ext\")");
                                bVar = a(optJSONObject);
                                f1 a2 = a(bVar.l());
                                if (a2 != null) {
                                    arrayList.add(a2);
                                }
                            } else {
                                bVar = bVar2;
                            }
                            arrayList2.add(a(jSONObject4, bVar));
                            bVar2 = bVar;
                        }
                    }
                }
                Intrinsics.e(optString, "seat");
                arrayList3.add(new d(optString, arrayList2));
            }
        }
        return a(jSONObject2, (List) arrayList3, (List) arrayList);
    }

    public final n7.a c(JSONObject jSONObject) {
        return new n7.a(jSONObject.optDouble("w"), jSONObject.optDouble("h"));
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f18975a;

        /* renamed from: b  reason: collision with root package name */
        public final List f18976b;

        public d(String str, List list) {
            Intrinsics.f(str, "seat");
            Intrinsics.f(list, "bidList");
            this.f18975a = str;
            this.f18976b = list;
        }

        public final List a() {
            return this.f18976b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return Intrinsics.a(this.f18975a, dVar.f18975a) && Intrinsics.a(this.f18976b, dVar.f18976b);
        }

        public int hashCode() {
            return (this.f18975a.hashCode() * 31) + this.f18976b.hashCode();
        }

        public String toString() {
            return "SeatbidModel(seat=" + this.f18975a + ", bidList=" + this.f18976b + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? CollectionsKt__CollectionsKt.f() : list);
        }
    }

    public final a b(List list) {
        a aVar = (a) CollectionsKt___CollectionsKt.D(list);
        return aVar == null ? new a((String) null, (String) null, 0.0d, (String) null, (String) null, (String) null, 0, (b) null, JfifUtil.MARKER_FIRST_BYTE, (DefaultConstructorMarker) null) : aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002a, code lost:
        r0 = c(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.chartboost.sdk.impl.n7 b(org.json.JSONObject r15) {
        /*
            r14 = this;
            java.lang.String r0 = "imageurl"
            java.lang.String r2 = r15.optString(r0)
            java.lang.String r0 = "infoIcon.optString(\"imageurl\")"
            kotlin.jvm.internal.Intrinsics.e(r2, r0)
            java.lang.String r0 = "clickthroughurl"
            java.lang.String r3 = r15.optString(r0)
            java.lang.String r0 = "infoIcon.optString(\"clickthroughurl\")"
            kotlin.jvm.internal.Intrinsics.e(r3, r0)
            com.chartboost.sdk.impl.n7$b$a r0 = com.chartboost.sdk.impl.n7.b.f18247c
            java.lang.String r1 = "position"
            int r1 = r15.optInt(r1)
            com.chartboost.sdk.impl.n7$b r4 = r0.a(r1)
            java.lang.String r0 = "margin"
            org.json.JSONObject r0 = r15.optJSONObject(r0)
            if (r0 == 0) goto L_0x0033
            com.chartboost.sdk.impl.n7$a r0 = r14.c((org.json.JSONObject) r0)
            if (r0 != 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r5 = r0
            goto L_0x003f
        L_0x0033:
            com.chartboost.sdk.impl.n7$a r0 = new com.chartboost.sdk.impl.n7$a
            r6 = 0
            r8 = 0
            r10 = 3
            r11 = 0
            r5 = r0
            r5.<init>(r6, r8, r10, r11)
        L_0x003f:
            java.lang.String r0 = "padding"
            org.json.JSONObject r0 = r15.optJSONObject(r0)
            if (r0 == 0) goto L_0x0050
            com.chartboost.sdk.impl.n7$a r0 = r14.c((org.json.JSONObject) r0)
            if (r0 != 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r6 = r0
            goto L_0x005c
        L_0x0050:
            com.chartboost.sdk.impl.n7$a r0 = new com.chartboost.sdk.impl.n7$a
            r7 = 0
            r9 = 0
            r11 = 3
            r12 = 0
            r6 = r0
            r6.<init>(r7, r9, r11, r12)
        L_0x005c:
            java.lang.String r0 = "size"
            org.json.JSONObject r15 = r15.optJSONObject(r0)
            if (r15 == 0) goto L_0x006d
            com.chartboost.sdk.impl.n7$a r15 = r14.c((org.json.JSONObject) r15)
            if (r15 != 0) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            r7 = r15
            goto L_0x0079
        L_0x006d:
            com.chartboost.sdk.impl.n7$a r15 = new com.chartboost.sdk.impl.n7$a
            r8 = 0
            r10 = 0
            r12 = 3
            r13 = 0
            r7 = r15
            r7.<init>(r8, r10, r12, r13)
        L_0x0079:
            com.chartboost.sdk.impl.n7 r15 = new com.chartboost.sdk.impl.n7
            r1 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.x8.b(org.json.JSONObject):com.chartboost.sdk.impl.n7");
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f18948a;

        /* renamed from: b  reason: collision with root package name */
        public final String f18949b;

        /* renamed from: c  reason: collision with root package name */
        public final double f18950c;

        /* renamed from: d  reason: collision with root package name */
        public final String f18951d;

        /* renamed from: e  reason: collision with root package name */
        public final String f18952e;

        /* renamed from: f  reason: collision with root package name */
        public final String f18953f;

        /* renamed from: g  reason: collision with root package name */
        public final int f18954g;

        /* renamed from: h  reason: collision with root package name */
        public final b f18955h;

        public a(String str, String str2, double d2, String str3, String str4, String str5, int i2, b bVar) {
            Intrinsics.f(str, "id");
            Intrinsics.f(str2, "impid");
            Intrinsics.f(str3, "burl");
            Intrinsics.f(str4, "crid");
            Intrinsics.f(str5, "adm");
            Intrinsics.f(bVar, "ext");
            this.f18948a = str;
            this.f18949b = str2;
            this.f18950c = d2;
            this.f18951d = str3;
            this.f18952e = str4;
            this.f18953f = str5;
            this.f18954g = i2;
            this.f18955h = bVar;
        }

        public final String a() {
            return this.f18953f;
        }

        public final b b() {
            return this.f18955h;
        }

        public final int c() {
            return this.f18954g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.a(this.f18948a, aVar.f18948a) && Intrinsics.a(this.f18949b, aVar.f18949b) && Double.compare(this.f18950c, aVar.f18950c) == 0 && Intrinsics.a(this.f18951d, aVar.f18951d) && Intrinsics.a(this.f18952e, aVar.f18952e) && Intrinsics.a(this.f18953f, aVar.f18953f) && this.f18954g == aVar.f18954g && Intrinsics.a(this.f18955h, aVar.f18955h);
        }

        public int hashCode() {
            return (((((((((((((this.f18948a.hashCode() * 31) + this.f18949b.hashCode()) * 31) + Double.doubleToLongBits(this.f18950c)) * 31) + this.f18951d.hashCode()) * 31) + this.f18952e.hashCode()) * 31) + this.f18953f.hashCode()) * 31) + this.f18954g) * 31) + this.f18955h.hashCode();
        }

        public String toString() {
            return "BidModel(id=" + this.f18948a + ", impid=" + this.f18949b + ", price=" + this.f18950c + ", burl=" + this.f18951d + ", crid=" + this.f18952e + ", adm=" + this.f18953f + ", mtype=" + this.f18954g + ", ext=" + this.f18955h + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ a(java.lang.String r26, java.lang.String r27, double r28, java.lang.String r30, java.lang.String r31, java.lang.String r32, int r33, com.chartboost.sdk.impl.x8.b r34, int r35, kotlin.jvm.internal.DefaultConstructorMarker r36) {
            /*
                r25 = this;
                r0 = r35
                r1 = r0 & 1
                java.lang.String r2 = ""
                if (r1 == 0) goto L_0x000a
                r1 = r2
                goto L_0x000c
            L_0x000a:
                r1 = r26
            L_0x000c:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0012
                r3 = r2
                goto L_0x0014
            L_0x0012:
                r3 = r27
            L_0x0014:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x001b
                r4 = 0
                goto L_0x001d
            L_0x001b:
                r4 = r28
            L_0x001d:
                r6 = r0 & 8
                if (r6 == 0) goto L_0x0023
                r6 = r2
                goto L_0x0025
            L_0x0023:
                r6 = r30
            L_0x0025:
                r7 = r0 & 16
                if (r7 == 0) goto L_0x002b
                r7 = r2
                goto L_0x002d
            L_0x002b:
                r7 = r31
            L_0x002d:
                r8 = r0 & 32
                if (r8 == 0) goto L_0x0032
                goto L_0x0034
            L_0x0032:
                r2 = r32
            L_0x0034:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x003a
                r8 = 0
                goto L_0x003c
            L_0x003a:
                r8 = r33
            L_0x003c:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x005f
                com.chartboost.sdk.impl.x8$b r0 = new com.chartboost.sdk.impl.x8$b
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r23 = 8191(0x1fff, float:1.1478E-41)
                r24 = 0
                r9 = r0
                r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
                goto L_0x0061
            L_0x005f:
                r0 = r34
            L_0x0061:
                r26 = r25
                r27 = r1
                r28 = r3
                r29 = r4
                r31 = r6
                r32 = r7
                r33 = r2
                r34 = r8
                r35 = r0
                r26.<init>(r27, r28, r29, r31, r32, r33, r34, r35)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.x8.a.<init>(java.lang.String, java.lang.String, double, java.lang.String, java.lang.String, java.lang.String, int, com.chartboost.sdk.impl.x8$b, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f18956a;

        /* renamed from: b  reason: collision with root package name */
        public final String f18957b;

        /* renamed from: c  reason: collision with root package name */
        public final String f18958c;

        /* renamed from: d  reason: collision with root package name */
        public final String f18959d;

        /* renamed from: e  reason: collision with root package name */
        public final String f18960e;

        /* renamed from: f  reason: collision with root package name */
        public final String f18961f;

        /* renamed from: g  reason: collision with root package name */
        public final List f18962g;

        /* renamed from: h  reason: collision with root package name */
        public final String f18963h;

        /* renamed from: i  reason: collision with root package name */
        public final int f18964i;

        /* renamed from: j  reason: collision with root package name */
        public final String f18965j;

        /* renamed from: k  reason: collision with root package name */
        public final n7 f18966k;

        /* renamed from: l  reason: collision with root package name */
        public final aa f18967l;

        /* renamed from: m  reason: collision with root package name */
        public final List f18968m;

        public b(String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, int i2, String str8, n7 n7Var, aa aaVar, List list2) {
            Intrinsics.f(str, "impressionid");
            Intrinsics.f(str2, "crtype");
            Intrinsics.f(str3, "adId");
            Intrinsics.f(str4, "cgn");
            Intrinsics.f(str5, AdPayload.KEY_TEMPLATE);
            Intrinsics.f(str6, "videoUrl");
            Intrinsics.f(list, "imptrackers");
            Intrinsics.f(str7, "params");
            Intrinsics.f(str8, "baseUrl");
            Intrinsics.f(n7Var, "infoIcon");
            Intrinsics.f(aaVar, "renderEngine");
            Intrinsics.f(list2, "scripts");
            this.f18956a = str;
            this.f18957b = str2;
            this.f18958c = str3;
            this.f18959d = str4;
            this.f18960e = str5;
            this.f18961f = str6;
            this.f18962g = list;
            this.f18963h = str7;
            this.f18964i = i2;
            this.f18965j = str8;
            this.f18966k = n7Var;
            this.f18967l = aaVar;
            this.f18968m = list2;
        }

        public final String a() {
            return this.f18958c;
        }

        public final String b() {
            return this.f18965j;
        }

        public final String c() {
            return this.f18959d;
        }

        public final int d() {
            return this.f18964i;
        }

        public final String e() {
            return this.f18957b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.a(this.f18956a, bVar.f18956a) && Intrinsics.a(this.f18957b, bVar.f18957b) && Intrinsics.a(this.f18958c, bVar.f18958c) && Intrinsics.a(this.f18959d, bVar.f18959d) && Intrinsics.a(this.f18960e, bVar.f18960e) && Intrinsics.a(this.f18961f, bVar.f18961f) && Intrinsics.a(this.f18962g, bVar.f18962g) && Intrinsics.a(this.f18963h, bVar.f18963h) && this.f18964i == bVar.f18964i && Intrinsics.a(this.f18965j, bVar.f18965j) && Intrinsics.a(this.f18966k, bVar.f18966k) && this.f18967l == bVar.f18967l && Intrinsics.a(this.f18968m, bVar.f18968m);
        }

        public final String f() {
            return this.f18956a;
        }

        public final List g() {
            return this.f18962g;
        }

        public final n7 h() {
            return this.f18966k;
        }

        public int hashCode() {
            return (((((((((((((((((((((((this.f18956a.hashCode() * 31) + this.f18957b.hashCode()) * 31) + this.f18958c.hashCode()) * 31) + this.f18959d.hashCode()) * 31) + this.f18960e.hashCode()) * 31) + this.f18961f.hashCode()) * 31) + this.f18962g.hashCode()) * 31) + this.f18963h.hashCode()) * 31) + this.f18964i) * 31) + this.f18965j.hashCode()) * 31) + this.f18966k.hashCode()) * 31) + this.f18967l.hashCode()) * 31) + this.f18968m.hashCode();
        }

        public final String i() {
            return this.f18963h;
        }

        public final aa j() {
            return this.f18967l;
        }

        public final List k() {
            return this.f18968m;
        }

        public final String l() {
            return this.f18960e;
        }

        public final String m() {
            return this.f18961f;
        }

        public String toString() {
            return "ExtensionModel(impressionid=" + this.f18956a + ", crtype=" + this.f18957b + ", adId=" + this.f18958c + ", cgn=" + this.f18959d + ", template=" + this.f18960e + ", videoUrl=" + this.f18961f + ", imptrackers=" + this.f18962g + ", params=" + this.f18963h + ", clkp=" + this.f18964i + ", baseUrl=" + this.f18965j + ", infoIcon=" + this.f18966k + ", renderEngine=" + this.f18967l + ", scripts=" + this.f18968m + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ b(java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.util.List r27, java.lang.String r28, int r29, java.lang.String r30, com.chartboost.sdk.impl.n7 r31, com.chartboost.sdk.impl.aa r32, java.util.List r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
            /*
                r20 = this;
                r0 = r34
                r1 = r0 & 1
                java.lang.String r2 = ""
                if (r1 == 0) goto L_0x000a
                r1 = r2
                goto L_0x000c
            L_0x000a:
                r1 = r21
            L_0x000c:
                r3 = r0 & 2
                if (r3 == 0) goto L_0x0012
                r3 = r2
                goto L_0x0014
            L_0x0012:
                r3 = r22
            L_0x0014:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x001a
                r4 = r2
                goto L_0x001c
            L_0x001a:
                r4 = r23
            L_0x001c:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x0022
                r5 = r2
                goto L_0x0024
            L_0x0022:
                r5 = r24
            L_0x0024:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x002a
                r6 = r2
                goto L_0x002c
            L_0x002a:
                r6 = r25
            L_0x002c:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x0032
                r7 = r2
                goto L_0x0034
            L_0x0032:
                r7 = r26
            L_0x0034:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x003d
                java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsKt.f()
                goto L_0x003f
            L_0x003d:
                r8 = r27
            L_0x003f:
                r9 = r0 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L_0x0044
                goto L_0x0046
            L_0x0044:
                r2 = r28
            L_0x0046:
                r9 = r0 & 256(0x100, float:3.59E-43)
                if (r9 == 0) goto L_0x0051
                com.chartboost.sdk.impl.l3 r9 = com.chartboost.sdk.impl.l3.CLICK_PREFERENCE_EMBEDDED
                int r9 = r9.b()
                goto L_0x0053
            L_0x0051:
                r9 = r29
            L_0x0053:
                r10 = r0 & 512(0x200, float:7.175E-43)
                if (r10 == 0) goto L_0x005a
                java.lang.String r10 = "https://live.chartboost.com"
                goto L_0x005c
            L_0x005a:
                r10 = r30
            L_0x005c:
                r11 = r0 & 1024(0x400, float:1.435E-42)
                if (r11 == 0) goto L_0x0084
                com.chartboost.sdk.impl.n7 r11 = new com.chartboost.sdk.impl.n7
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                r18 = 63
                r19 = 0
                r21 = r11
                r22 = r12
                r23 = r13
                r24 = r14
                r25 = r15
                r26 = r16
                r27 = r17
                r28 = r18
                r29 = r19
                r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29)
                goto L_0x0086
            L_0x0084:
                r11 = r31
            L_0x0086:
                r12 = r0 & 2048(0x800, float:2.87E-42)
                if (r12 == 0) goto L_0x008d
                com.chartboost.sdk.impl.aa r12 = com.chartboost.sdk.impl.aa.UNKNOWN
                goto L_0x008f
            L_0x008d:
                r12 = r32
            L_0x008f:
                r0 = r0 & 4096(0x1000, float:5.74E-42)
                if (r0 == 0) goto L_0x0098
                java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.f()
                goto L_0x009a
            L_0x0098:
                r0 = r33
            L_0x009a:
                r21 = r20
                r22 = r1
                r23 = r3
                r24 = r4
                r25 = r5
                r26 = r6
                r27 = r7
                r28 = r8
                r29 = r2
                r30 = r9
                r31 = r10
                r32 = r11
                r33 = r12
                r34 = r0
                r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.x8.b.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, int, java.lang.String, com.chartboost.sdk.impl.n7, com.chartboost.sdk.impl.aa, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    public final void a(Map map, a aVar, u uVar) {
        map.put("{% encoding %}", "base64");
        map.put(ka.f18046b, aVar.a());
        map.put("{{ ad_type }}", b(uVar));
        map.put("{{ show_close_button }}", a(uVar));
        map.put("{{ preroll_popup }}", Constants.CASEFIRST_FALSE);
        map.put("{{ post_video_reward_toaster_enabled }}", Constants.CASEFIRST_FALSE);
        if (Intrinsics.a(uVar, u.a.f18735g)) {
            map.put("{% is_banner %}", "true");
        }
    }

    public final String a(u uVar) {
        if (Intrinsics.a(uVar, u.b.f18736g)) {
            return "true";
        }
        if (Intrinsics.a(uVar, u.c.f18737g) || Intrinsics.a(uVar, u.a.f18735g)) {
            return Constants.CASEFIRST_FALSE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final f1 a(List list) {
        f1 f1Var = (f1) CollectionsKt___CollectionsKt.D(list);
        return f1Var == null ? new f1("", "", "") : f1Var;
    }

    public final f1 a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String substring = str.substring(StringsKt__StringsKt.a0(str, '/', 0, false, 6, (Object) null) + 1);
        Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
        return new f1("html", substring, str);
    }

    public final b a(JSONObject jSONObject) {
        List list;
        n7 n7Var;
        List list2;
        JSONObject jSONObject2 = jSONObject;
        String optString = jSONObject2.optString("impressionid");
        Intrinsics.e(optString, "ext.optString(\"impressionid\")");
        String optString2 = jSONObject2.optString("crtype");
        Intrinsics.e(optString2, "ext.optString(\"crtype\")");
        String optString3 = jSONObject2.optString("adId");
        Intrinsics.e(optString3, "ext.optString(\"adId\")");
        String optString4 = jSONObject2.optString("cgn");
        Intrinsics.e(optString4, "ext.optString(\"cgn\")");
        String string = jSONObject2.getString(AdPayload.KEY_TEMPLATE);
        Intrinsics.e(string, "ext.getString(\"template\")");
        String optString5 = jSONObject2.optString("videoUrl");
        Intrinsics.e(optString5, "ext.optString(\"videoUrl\")");
        JSONArray optJSONArray = jSONObject2.optJSONArray("imptrackers");
        if (optJSONArray == null || (list = r5.asList(optJSONArray)) == null) {
            list = CollectionsKt__CollectionsKt.f();
        }
        List list3 = list;
        String optString6 = jSONObject2.optString("params");
        Intrinsics.e(optString6, "ext.optString(\"params\")");
        int optInt = jSONObject2.optInt("clkp");
        String optString7 = jSONObject2.optString("baseurl");
        Intrinsics.e(optString7, "ext.optString(BASE_URL_JSON_FIELD)");
        JSONObject optJSONObject = jSONObject2.optJSONObject("infoicon");
        if (optJSONObject == null || (n7Var = b(optJSONObject)) == null) {
            n7Var = new n7((String) null, (String) null, (n7.b) null, (n7.a) null, (n7.a) null, (n7.a) null, 63, (DefaultConstructorMarker) null);
        }
        n7 n7Var2 = n7Var;
        aa a2 = aa.f17218c.a(jSONObject2.optString("renderingengine"));
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("scripts");
        if (optJSONArray2 == null || (list2 = r5.asList(optJSONArray2)) == null) {
            list2 = CollectionsKt__CollectionsKt.f();
        }
        return new b(optString, optString2, optString3, optString4, string, optString5, list3, optString6, optInt, optString7, n7Var2, a2, list2);
    }

    public final a a(JSONObject jSONObject, b bVar) {
        String string = jSONObject.getString("id");
        Intrinsics.e(string, "bid.getString(\"id\")");
        String string2 = jSONObject.getString("impid");
        Intrinsics.e(string2, "bid.getString(\"impid\")");
        double d2 = jSONObject.getDouble(InAppPurchaseMetaData.KEY_PRICE);
        String optString = jSONObject.optString("burl");
        Intrinsics.e(optString, "bid.optString(\"burl\")");
        String optString2 = jSONObject.optString("crid");
        Intrinsics.e(optString2, "bid.optString(\"crid\")");
        String optString3 = jSONObject.optString("adm");
        Intrinsics.e(optString3, "bid.optString(\"adm\")");
        return new a(string, string2, d2, optString, optString2, optString3, jSONObject.optInt("mtype"), bVar);
    }

    public final c a(JSONObject jSONObject, List list, List list2) {
        String string = jSONObject.getString("id");
        Intrinsics.e(string, "response.getString(\"id\")");
        String optString = jSONObject.optString("nbr");
        Intrinsics.e(optString, "response.optString(\"nbr\")");
        String optString2 = jSONObject.optString("cur", "USD");
        Intrinsics.e(optString2, "response.optString(\"cur\", \"USD\")");
        String optString3 = jSONObject.optString("bidid");
        Intrinsics.e(optString3, "response.optString(\"bidid\")");
        return new c(string, optString, optString2, optString3, list, list2);
    }
}
