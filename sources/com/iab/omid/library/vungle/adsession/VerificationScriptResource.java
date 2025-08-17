package com.iab.omid.library.vungle.adsession;

import com.iab.omid.library.vungle.utils.c;
import java.net.URL;
import org.json.JSONObject;

public final class VerificationScriptResource {

    /* renamed from: a  reason: collision with root package name */
    private final String f31679a;

    /* renamed from: b  reason: collision with root package name */
    private final URL f31680b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31681c;

    public URL a() {
        return this.f31680b;
    }

    public String b() {
        return this.f31679a;
    }

    public String c() {
        return this.f31681c;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        c.i(jSONObject, "vendorKey", this.f31679a);
        c.i(jSONObject, "resourceUrl", this.f31680b.toString());
        c.i(jSONObject, "verificationParameters", this.f31681c);
        return jSONObject;
    }
}
