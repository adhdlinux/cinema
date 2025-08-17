package com.facebook.ads.internal.q.a;

import org.json.JSONArray;

public enum c {
    APP_AD(0),
    LINK_AD(1),
    APP_AD_V2(2),
    LINK_AD_V2(3),
    APP_ENGAGEMENT_AD(4),
    AD_CHOICES(5),
    JS_TRIGGER(6),
    JS_TRIGGER_NO_AUTO_IMP_LOGGING(7),
    VIDEO_AD(8),
    INLINE_VIDEO_AD(9),
    BANNER_TO_INTERSTITIAL(10),
    NATIVE_CLOSE_BUTTON(11),
    UNIFIED_LOGGING(16),
    HTTP_LINKS(17);
    

    /* renamed from: o  reason: collision with root package name */
    public static final c[] f20609o = null;

    /* renamed from: q  reason: collision with root package name */
    private static final String f20610q = null;

    /* renamed from: p  reason: collision with root package name */
    private final int f20612p;

    static {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        c cVar6;
        c cVar7;
        c[] cVarArr = {cVar, cVar2, cVar3, cVar4, cVar5, cVar7, cVar6};
        f20609o = cVarArr;
        JSONArray jSONArray = new JSONArray();
        for (c a2 : cVarArr) {
            jSONArray.put(a2.a());
        }
        f20610q = jSONArray.toString();
    }

    private c(int i2) {
        this.f20612p = i2;
    }

    public static String b() {
        return f20610q;
    }

    public int a() {
        return this.f20612p;
    }

    public String toString() {
        return String.valueOf(this.f20612p);
    }
}
