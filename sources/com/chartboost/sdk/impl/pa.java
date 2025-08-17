package com.chartboost.sdk.impl;

import com.chartboost.sdk.privacy.model.CCPA;
import com.chartboost.sdk.privacy.model.COPPA;
import com.chartboost.sdk.privacy.model.LGPD;
import com.facebook.react.uimanager.ViewProps;
import com.unity3d.ads.metadata.MediationMetaData;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class pa {
    public final String A;
    public final a B;
    public b C;
    public final String D;
    public final ob E;
    public final xc F;
    public final j8 G;

    /* renamed from: a  reason: collision with root package name */
    public final String f18357a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f18358b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f18359c;

    /* renamed from: d  reason: collision with root package name */
    public final List f18360d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f18361e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f18362f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f18363g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f18364h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f18365i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f18366j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f18367k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f18368l;

    /* renamed from: m  reason: collision with root package name */
    public final int f18369m;

    /* renamed from: n  reason: collision with root package name */
    public final int f18370n;

    /* renamed from: o  reason: collision with root package name */
    public final int f18371o;

    /* renamed from: p  reason: collision with root package name */
    public final List f18372p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f18373q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f18374r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f18375s;

    /* renamed from: t  reason: collision with root package name */
    public final int f18376t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f18377u;

    /* renamed from: v  reason: collision with root package name */
    public final int f18378v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f18379w;

    /* renamed from: x  reason: collision with root package name */
    public final String f18380x;

    /* renamed from: y  reason: collision with root package name */
    public final String f18381y;

    /* renamed from: z  reason: collision with root package name */
    public final String f18382z;

    public pa(JSONObject jSONObject) {
        this.f18357a = jSONObject.optString("configVariant");
        this.f18358b = jSONObject.optBoolean("prefetchDisable");
        this.f18359c = jSONObject.optBoolean("publisherDisable");
        this.B = a.a(jSONObject);
        try {
            this.C = b.a(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.D = jSONObject.optString("publisherWarning", (String) null);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("invalidateFolderList");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                String optString = optJSONArray.optString(i2);
                if (!optString.isEmpty()) {
                    arrayList.add(optString);
                }
            }
        }
        this.f18360d = Collections.unmodifiableList(arrayList);
        JSONObject optJSONObject = jSONObject.optJSONObject("trackingLevels");
        optJSONObject = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.f18361e = optJSONObject.optBoolean("critical", true);
        this.f18368l = optJSONObject.optBoolean("includeStackTrace", true);
        this.f18362f = optJSONObject.optBoolean(MRAIDPresenter.ERROR);
        this.f18363g = optJSONObject.optBoolean("debug");
        this.f18364h = optJSONObject.optBoolean("session");
        this.f18365i = optJSONObject.optBoolean("system");
        this.f18366j = optJSONObject.optBoolean("timing");
        this.f18367k = optJSONObject.optBoolean("user");
        this.E = pb.b(jSONObject);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("videoPreCaching");
        this.F = xc.a(optJSONObject2 == null ? new JSONObject() : optJSONObject2);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("omSdk");
        this.G = k8.b(optJSONObject3 == null ? new JSONObject() : optJSONObject3);
        JSONObject optJSONObject4 = jSONObject.optJSONObject("webview");
        optJSONObject4 = optJSONObject4 == null ? new JSONObject() : optJSONObject4;
        this.f18369m = optJSONObject4.optInt("cacheMaxBytes", 104857600);
        int i3 = 10;
        int optInt = optJSONObject4.optInt("cacheMaxUnits", 10);
        this.f18370n = optInt > 0 ? optInt : i3;
        this.f18371o = (int) TimeUnit.SECONDS.toDays((long) optJSONObject4.optInt("cacheTTLs", v1.f18815a));
        ArrayList arrayList2 = new ArrayList();
        JSONArray optJSONArray2 = optJSONObject4.optJSONArray("directories");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i4 = 0; i4 < length2; i4++) {
                String optString2 = optJSONArray2.optString(i4);
                if (!optString2.isEmpty()) {
                    arrayList2.add(optString2);
                }
            }
        }
        this.f18372p = Collections.unmodifiableList(arrayList2);
        this.f18373q = optJSONObject4.optBoolean(ViewProps.ENABLED, i());
        this.f18374r = optJSONObject4.optBoolean("inplayEnabled", true);
        this.f18375s = optJSONObject4.optBoolean("interstitialEnabled", true);
        int optInt2 = optJSONObject4.optInt("invalidatePendingImpression", 3);
        this.f18376t = optInt2 <= 0 ? 3 : optInt2;
        this.f18377u = optJSONObject4.optBoolean("lockOrientation", true);
        this.f18378v = optJSONObject4.optInt("prefetchSession", 3);
        this.f18379w = optJSONObject4.optBoolean("rewardVideoEnabled", true);
        String optString3 = optJSONObject4.optString(MediationMetaData.KEY_VERSION, "v2");
        this.f18380x = optString3;
        this.f18381y = String.format("%s/%s%s", new Object[]{"webview", optString3, "/interstitial/get"});
        this.f18382z = String.format("%s/%s/%s", new Object[]{"webview", optString3, "prefetch"});
        this.A = String.format("%s/%s%s", new Object[]{"webview", optString3, "/reward/get"});
    }

    public static boolean i() {
        int[] iArr = {4, 4, 2};
        String a2 = y0.b().a();
        if (a2 != null && a2.length() > 0) {
            String[] split = a2.replaceAll("[^\\d.]", "").split("\\.");
            int i2 = 0;
            while (i2 < split.length && i2 < 3) {
                try {
                    if (Integer.valueOf(split[i2]).intValue() > iArr[i2]) {
                        return true;
                    }
                    if (Integer.valueOf(split[i2]).intValue() < iArr[i2]) {
                        return false;
                    }
                    i2++;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }

    public a a() {
        return this.B;
    }

    public j8 b() {
        return this.G;
    }

    public xc c() {
        return this.F;
    }

    public boolean d() {
        return this.f18358b;
    }

    public boolean e() {
        return this.f18359c;
    }

    public String f() {
        return this.D;
    }

    public ob g() {
        return this.E;
    }

    public boolean h() {
        return this.f18373q;
    }

    public z3 j() {
        return new z3(this.f18357a, this.f18373q, this.f18380x);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f18383a;

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            aVar.f18383a = jSONObject.optBoolean("bannerEnable", true);
            return aVar;
        }

        public boolean a() {
            return this.f18383a;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HashSet f18384a;

        public static b a(JSONObject jSONObject) {
            b bVar = new b();
            HashSet hashSet = new HashSet();
            hashSet.add(CCPA.CCPA_STANDARD);
            hashSet.add(COPPA.COPPA_STANDARD);
            hashSet.add(LGPD.LGPD_STANDARD);
            JSONArray optJSONArray = jSONObject.optJSONArray("privacyStandards");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                a(optJSONArray, hashSet, length);
                a(hashSet, length);
            }
            bVar.f18384a = hashSet;
            return bVar;
        }

        public static void a(JSONArray jSONArray, HashSet hashSet, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                hashSet.add(jSONArray.getString(i3));
            }
        }

        public static void a(HashSet hashSet, int i2) {
            if (i2 == 0) {
                hashSet.clear();
            }
        }

        public HashSet a() {
            return this.f18384a;
        }
    }
}
