package com.applovin.impl.mediation.debugger.b.b;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.google.android.gms.cast.MediaTrack;
import java.util.List;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f14508a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14509b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14510c;

    a(JSONObject jSONObject, m mVar) {
        this.f14508a = JsonUtils.getString(jSONObject, "name", "");
        this.f14509b = JsonUtils.getString(jSONObject, MediaTrack.ROLE_DESCRIPTION, "");
        List list = JsonUtils.getList(jSONObject, "existence_classes", (List) null);
        this.f14510c = list != null ? Utils.checkClassesExistence(list) : Utils.checkClassExistence(JsonUtils.getString(jSONObject, "existence_class", ""));
    }

    public static boolean a(String str, String str2, String str3) {
        if (str == null) {
            return true;
        }
        if (str2 == null || Utils.compare(str2, str) != 1) {
            return str3 == null || Utils.compare(str3, str) != -1;
        }
        return false;
    }

    public String a() {
        return this.f14508a;
    }

    public String b() {
        return this.f14509b;
    }

    public boolean c() {
        return this.f14510c;
    }
}
