package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.v;
import java.util.Map;
import org.json.JSONObject;

public abstract class w extends y {
    protected w(String str, m mVar) {
        super(str, mVar);
    }

    private JSONObject a(c cVar) {
        JSONObject i2 = i();
        JsonUtils.putString(i2, "result", cVar.b());
        Map<String, String> a2 = cVar.a();
        if (a2 != null) {
            JsonUtils.putJSONObject(i2, "params", new JSONObject(a2));
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public abstract c b();

    /* access modifiers changed from: protected */
    public abstract void b(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public abstract void c();

    /* access modifiers changed from: protected */
    public int h() {
        return ((Integer) this.f15333b.a(b.bt)).intValue();
    }

    public void run() {
        c b2 = b();
        if (b2 != null) {
            if (v.a()) {
                a("Reporting pending reward: " + b2 + "...");
            }
            a(a(b2), new b.c<JSONObject>() {
                public void a(int i2, String str, JSONObject jSONObject) {
                    w.this.a(i2);
                }

                public void a(JSONObject jSONObject, int i2) {
                    w.this.b(jSONObject);
                }
            });
            return;
        }
        if (v.a()) {
            d("Pending reward not found");
        }
        c();
    }
}
