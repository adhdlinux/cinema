package com.adcolony.sdk;

import com.unity3d.ads.metadata.MediationMetaData;
import org.json.JSONObject;

public class AdColonyAppOptions {

    /* renamed from: a  reason: collision with root package name */
    private String f12847a = "";

    /* renamed from: b  reason: collision with root package name */
    private f1 f12848b = new f1();

    public AdColonyAppOptions() {
        j("google");
    }

    /* access modifiers changed from: package-private */
    public AdColonyAppOptions a(String str) {
        if (str == null) {
            return this;
        }
        this.f12847a = str;
        c0.n(this.f12848b, "app_id", str);
        return this;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.f12847a;
    }

    /* access modifiers changed from: package-private */
    public f1 c() {
        return this.f12848b;
    }

    public boolean d() {
        return c0.t(this.f12848b, "keep_screen_on");
    }

    public JSONObject e() {
        f1 q2 = c0.q();
        c0.n(q2, "name", c0.E(this.f12848b, "mediation_network"));
        c0.n(q2, MediationMetaData.KEY_VERSION, c0.E(this.f12848b, "mediation_network_version"));
        return q2.g();
    }

    public boolean f() {
        return c0.t(this.f12848b, "multi_window_enabled");
    }

    public Object g(String str) {
        return c0.D(this.f12848b, str);
    }

    public JSONObject h() {
        f1 q2 = c0.q();
        c0.n(q2, "name", c0.E(this.f12848b, "plugin"));
        c0.n(q2, MediationMetaData.KEY_VERSION, c0.E(this.f12848b, "plugin_version"));
        return q2.g();
    }

    public AdColonyAppOptions i(String str, String str2) {
        c0.n(this.f12848b, str, str2);
        return this;
    }

    public AdColonyAppOptions j(String str) {
        i("origin_store", str);
        return this;
    }
}
