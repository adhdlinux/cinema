package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.ads.AudienceNetworkActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private String f15702a;

    /* renamed from: b  reason: collision with root package name */
    private String f15703b;

    /* renamed from: c  reason: collision with root package name */
    private String f15704c;

    /* renamed from: d  reason: collision with root package name */
    private String f15705d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f15706e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f15707f;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, Object> f15708g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15709h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f15710i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15711j;

    /* renamed from: k  reason: collision with root package name */
    private String f15712k;

    /* renamed from: l  reason: collision with root package name */
    private int f15713l;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f15714a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f15715b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f15716c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f15717d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public Map<String, String> f15718e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public Map<String, String> f15719f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Object> f15720g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public boolean f15721h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public boolean f15722i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public boolean f15723j;

        public a a(String str) {
            this.f15714a = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.f15718e = map;
            return this;
        }

        public a a(boolean z2) {
            this.f15721h = z2;
            return this;
        }

        public h a() {
            return new h(this);
        }

        public a b(String str) {
            this.f15715b = str;
            return this;
        }

        public a b(Map<String, String> map) {
            this.f15719f = map;
            return this;
        }

        public a b(boolean z2) {
            this.f15722i = z2;
            return this;
        }

        public a c(String str) {
            this.f15716c = str;
            return this;
        }

        public a c(Map<String, Object> map) {
            this.f15720g = map;
            return this;
        }

        public a c(boolean z2) {
            this.f15723j = z2;
            return this;
        }

        public a d(String str) {
            this.f15717d = str;
            return this;
        }
    }

    private h(a aVar) {
        this.f15702a = UUID.randomUUID().toString();
        this.f15703b = aVar.f15715b;
        this.f15704c = aVar.f15716c;
        this.f15705d = aVar.f15717d;
        this.f15706e = aVar.f15718e;
        this.f15707f = aVar.f15719f;
        this.f15708g = aVar.f15720g;
        this.f15709h = aVar.f15721h;
        this.f15710i = aVar.f15722i;
        this.f15711j = aVar.f15723j;
        this.f15712k = aVar.f15714a;
        this.f15713l = 0;
    }

    h(JSONObject jSONObject, m mVar) throws Exception {
        String string = JsonUtils.getString(jSONObject, AudienceNetworkActivity.AUDIENCE_NETWORK_UNIQUE_ID_EXTRA, UUID.randomUUID().toString());
        String string2 = JsonUtils.getString(jSONObject, "communicatorRequestId", "");
        JsonUtils.getString(jSONObject, "httpMethod", "");
        String string3 = jSONObject.getString("targetUrl");
        String string4 = JsonUtils.getString(jSONObject, "backupUrl", "");
        int i2 = jSONObject.getInt("attemptNumber");
        Map<String, String> synchronizedMap = JsonUtils.valueExists(jSONObject, "parameters") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("parameters"))) : new HashMap<>(0);
        Map<String, String> synchronizedMap2 = JsonUtils.valueExists(jSONObject, "httpHeaders") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("httpHeaders"))) : new HashMap<>(0);
        Map<String, Object> synchronizedMap3 = JsonUtils.valueExists(jSONObject, "requestBody") ? Collections.synchronizedMap(JsonUtils.toStringObjectMap(jSONObject.getJSONObject("requestBody"))) : new HashMap<>(0);
        this.f15702a = string;
        this.f15712k = string2;
        this.f15704c = string3;
        this.f15705d = string4;
        this.f15706e = synchronizedMap;
        this.f15707f = synchronizedMap2;
        this.f15708g = synchronizedMap3;
        this.f15709h = jSONObject.optBoolean("isEncodingEnabled", false);
        this.f15710i = jSONObject.optBoolean("gzipBodyEncoding", false);
        this.f15711j = jSONObject.optBoolean("shouldFireInWebView", false);
        this.f15713l = i2;
    }

    public static a o() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.f15703b;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.f15704c;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.f15705d;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> d() {
        return this.f15706e;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> e() {
        return this.f15707f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f15702a.equals(((h) obj).f15702a);
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> f() {
        return this.f15708g;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.f15709h;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f15710i;
    }

    public int hashCode() {
        return this.f15702a.hashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f15711j;
    }

    /* access modifiers changed from: package-private */
    public String j() {
        return this.f15712k;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f15713l;
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f15713l++;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.f15706e;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("postback_ts", String.valueOf(System.currentTimeMillis()));
        this.f15706e = hashMap;
    }

    /* access modifiers changed from: package-private */
    public JSONObject n() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AudienceNetworkActivity.AUDIENCE_NETWORK_UNIQUE_ID_EXTRA, this.f15702a);
        jSONObject.put("communicatorRequestId", this.f15712k);
        jSONObject.put("httpMethod", this.f15703b);
        jSONObject.put("targetUrl", this.f15704c);
        jSONObject.put("backupUrl", this.f15705d);
        jSONObject.put("isEncodingEnabled", this.f15709h);
        jSONObject.put("gzipBodyEncoding", this.f15710i);
        jSONObject.put("attemptNumber", this.f15713l);
        if (this.f15706e != null) {
            jSONObject.put("parameters", new JSONObject(this.f15706e));
        }
        if (this.f15707f != null) {
            jSONObject.put("httpHeaders", new JSONObject(this.f15707f));
        }
        if (this.f15708g != null) {
            jSONObject.put("requestBody", new JSONObject(this.f15708g));
        }
        return jSONObject;
    }

    public String toString() {
        return "PostbackRequest{uniqueId='" + this.f15702a + '\'' + ", communicatorRequestId='" + this.f15712k + '\'' + ", httpMethod='" + this.f15703b + '\'' + ", targetUrl='" + this.f15704c + '\'' + ", backupUrl='" + this.f15705d + '\'' + ", attemptNumber=" + this.f15713l + ", isEncodingEnabled=" + this.f15709h + ", isGzipBodyEncoding=" + this.f15710i + '}';
    }
}
