package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.e.u;
import com.applovin.impl.sdk.m;
import org.json.JSONObject;

public class a extends com.applovin.impl.sdk.e.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f15602a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final c<JSONObject> f15603c;

    public a(String str, c<JSONObject> cVar, m mVar) {
        super("CommunicatorRequestTask:" + str, mVar);
        this.f15602a = str;
        this.f15603c = cVar;
    }

    public void run() {
        this.f15333b.S().a((com.applovin.impl.sdk.e.a) new u<JSONObject>(this.f15603c, this.f15333b, g()) {
            public void a(int i2, String str, JSONObject jSONObject) {
                this.f15333b.ag().a(a.this.f15602a, a.this.f15603c.a(), i2, jSONObject, str, false);
            }

            public void a(JSONObject jSONObject, int i2) {
                this.f15333b.ag().a(a.this.f15602a, a.this.f15603c.a(), i2, jSONObject, (String) null, true);
            }
        });
    }
}
