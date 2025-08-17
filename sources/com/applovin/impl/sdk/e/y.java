package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import org.json.JSONObject;

public abstract class y extends a {
    protected y(String str, m mVar) {
        super(str, mVar);
    }

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public void a(int i2) {
        h.a(i2, this.f15333b);
    }

    /* access modifiers changed from: protected */
    public abstract void a(JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    public void a(JSONObject jSONObject, final b.c<JSONObject> cVar) {
        AnonymousClass1 r02 = new u<JSONObject>(c.a(this.f15333b).a(h.a(a(), this.f15333b)).c(h.b(a(), this.f15333b)).a(h.e(this.f15333b)).b("POST").a(jSONObject).d(((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.b.eA)).booleanValue()).a(new JSONObject()).a(h()).a(), this.f15333b) {
            public void a(int i2, String str, JSONObject jSONObject) {
                cVar.a(i2, str, jSONObject);
            }

            public void a(JSONObject jSONObject, int i2) {
                cVar.a(jSONObject, i2);
            }
        };
        r02.a(com.applovin.impl.sdk.c.b.aT);
        r02.b(com.applovin.impl.sdk.c.b.aU);
        this.f15333b.S().a((a) r02);
    }

    /* access modifiers changed from: protected */
    public abstract int h();

    /* access modifiers changed from: protected */
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        String m2 = this.f15333b.m();
        if (((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.b.ds)).booleanValue() && StringUtils.isValidString(m2)) {
            JsonUtils.putString(jSONObject, "cuid", m2);
        }
        if (((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.b.du)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.f15333b.n());
        }
        if (((Boolean) this.f15333b.a(com.applovin.impl.sdk.c.b.dw)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.f15333b.o());
        }
        a(jSONObject);
        return jSONObject;
    }
}
