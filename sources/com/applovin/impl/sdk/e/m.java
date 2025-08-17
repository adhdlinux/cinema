package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.v;
import java.util.Map;
import org.json.JSONObject;

public class m extends a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final a f15374a;

    public interface a {
        void a();
    }

    public m(com.applovin.impl.sdk.m mVar, a aVar) {
        super("TaskFetchVariables", mVar);
        this.f15374a = aVar;
    }

    private Map<String, String> a() {
        return Utils.stringifyObjectMap(this.f15333b.V().a((Map<String, String>) null, false, false));
    }

    public void run() {
        AnonymousClass1 r12 = new u<JSONObject>(c.a(this.f15333b).a(h.k(this.f15333b)).c(h.l(this.f15333b)).a(a()).b("GET").a(new JSONObject()).b(((Integer) this.f15333b.a(b.dc)).intValue()).a(), this.f15333b) {
            public void a(int i2, String str, JSONObject jSONObject) {
                if (v.a()) {
                    d("Unable to fetch variables: server returned " + i2);
                    v.i("AppLovinVariableService", "Failed to load variables.");
                }
                m.this.f15374a.a();
            }

            public void a(JSONObject jSONObject, int i2) {
                h.d(jSONObject, this.f15333b);
                h.c(jSONObject, this.f15333b);
                h.f(jSONObject, this.f15333b);
                h.e(jSONObject, this.f15333b);
                m.this.f15374a.a();
            }
        };
        r12.a(b.aX);
        r12.b(b.aY);
        this.f15333b.S().a((a) r12);
    }
}
