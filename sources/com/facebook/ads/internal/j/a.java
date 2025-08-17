package com.facebook.ads.internal.j;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f20219a;

    /* renamed from: b  reason: collision with root package name */
    private String f20220b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f20221c;

    /* renamed from: d  reason: collision with root package name */
    private int f20222d;

    /* renamed from: e  reason: collision with root package name */
    private String f20223e;

    /* renamed from: com.facebook.ads.internal.j.a$a  reason: collision with other inner class name */
    public enum C0033a {
        OPEN_STORE(0),
        OPEN_LINK(1),
        XOUT(2),
        OPEN_URL(3),
        SHOW_INTERSTITIAL(4);
        

        /* renamed from: f  reason: collision with root package name */
        int f20230f;

        private C0033a(int i2) {
            this.f20230f = i2;
        }
    }

    public enum b {
        LOADING_AD(0);
        

        /* renamed from: b  reason: collision with root package name */
        int f20233b;

        private b(int i2) {
            this.f20233b = i2;
        }
    }

    public a(String str, Map<String, Object> map, int i2, String str2) {
        this.f20220b = str;
        this.f20221c = map;
        this.f20222d = i2;
        this.f20223e = str2;
    }

    public static a a(long j2, C0033a aVar, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("Time", String.valueOf(currentTimeMillis - j2));
        hashMap.put("AdAction", String.valueOf(aVar.f20230f));
        return new a("bounceback", hashMap, (int) (currentTimeMillis / 1000), str);
    }

    public static a a(b bVar, String str, long j2, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("LatencyType", String.valueOf(bVar.f20233b));
        hashMap.put("AdPlacementType", str);
        hashMap.put("Time", String.valueOf(j2));
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (str2 == null) {
            str2 = f20219a;
        }
        return new a("latency", hashMap, currentTimeMillis, str2);
    }

    public static a a(Throwable th, String str) {
        HashMap hashMap = new HashMap();
        if (th != null) {
            hashMap.put("ex", th.getClass().getSimpleName());
            hashMap.put("ex_msg", th.getMessage());
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (str == null) {
            str = f20219a;
        }
        return new a(MRAIDPresenter.ERROR, hashMap, currentTimeMillis, str);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f20220b);
            jSONObject.put("data", new JSONObject(this.f20221c));
            jSONObject.put("time", this.f20222d);
            jSONObject.put("request_id", this.f20223e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
