package com.applovin.impl.mediation.debugger.b.b;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.d;
import com.applovin.impl.sdk.utils.h;
import com.google.android.gms.cast.MediaTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f14552a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f14553b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14554c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14555d;

    public c(JSONObject jSONObject, m mVar) {
        this.f14552a = d.a(mVar.L()).a();
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "cleartext_traffic", (JSONObject) null);
        boolean z2 = false;
        if (jSONObject2 != null) {
            this.f14553b = true;
            this.f14555d = JsonUtils.getString(jSONObject2, MediaTrack.ROLE_DESCRIPTION, "");
            if (h.a()) {
                this.f14554c = true;
                return;
            }
            List list = JsonUtils.getList(jSONObject2, "domains", new ArrayList());
            if (list.size() > 0) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!h.a((String) it2.next())) {
                            break;
                        }
                    } else {
                        z2 = true;
                        break;
                    }
                }
            }
            this.f14554c = z2;
            return;
        }
        this.f14553b = false;
        this.f14555d = "";
        this.f14554c = h.a();
    }

    public boolean a() {
        return this.f14553b;
    }

    public boolean b() {
        boolean z2 = this.f14554c;
        return z2 && (this.f14552a || z2);
    }

    public String c() {
        return this.f14552a ? this.f14555d : "You must include an entry in your AndroidManifest.xml to point to your network_security_config.xml.\n\nFor more information, visit: https://developer.android.com/training/articles/security-config";
    }
}
