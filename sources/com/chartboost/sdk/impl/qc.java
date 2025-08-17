package com.chartboost.sdk.impl;

import java.net.URL;
import org.json.JSONObject;

public final class qc {

    /* renamed from: a  reason: collision with root package name */
    public final String f18481a;

    /* renamed from: b  reason: collision with root package name */
    public final URL f18482b;

    /* renamed from: c  reason: collision with root package name */
    public final String f18483c;

    public qc(String str, URL url, String str2) {
        this.f18481a = str;
        this.f18482b = url;
        this.f18483c = str2;
    }

    public static qc a(String str, URL url, String str2) {
        df.a(str, "VendorKey is null or empty");
        df.a((Object) url, "ResourceURL is null");
        df.a(str2, "VerificationParameters is null or empty");
        return new qc(str, url, str2);
    }

    public String b() {
        return this.f18481a;
    }

    public String c() {
        return this.f18483c;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        me.a(jSONObject, "vendorKey", this.f18481a);
        me.a(jSONObject, "resourceUrl", this.f18482b.toString());
        me.a(jSONObject, "verificationParameters", this.f18483c);
        return jSONObject;
    }

    public URL a() {
        return this.f18482b;
    }
}
