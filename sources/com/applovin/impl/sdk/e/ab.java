package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.v;
import org.json.JSONObject;

public abstract class ab extends y {
    protected ab(String str, m mVar) {
        super(str, mVar);
    }

    /* access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        c c2 = c(jSONObject);
        if (c2 != null) {
            a(c2);
            if (v.a()) {
                a("Pending reward handled: " + c2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r3 = java.util.Collections.emptyMap();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.applovin.impl.sdk.b.c c(org.json.JSONObject r3) {
        /*
            r2 = this;
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.h.a((org.json.JSONObject) r3)     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.m r1 = r2.f15333b     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.utils.h.d(r0, r1)     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.m r1 = r2.f15333b     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.utils.h.c(r3, r1)     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.m r1 = r2.f15333b     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.utils.h.e(r3, r1)     // Catch:{ JSONException -> 0x0032 }
            java.lang.String r3 = "params"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0020 }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ all -> 0x0020 }
            java.util.Map r3 = com.applovin.impl.sdk.utils.JsonUtils.toStringMap(r3)     // Catch:{ all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            java.util.Map r3 = java.util.Collections.emptyMap()     // Catch:{ JSONException -> 0x0032 }
        L_0x0024:
            java.lang.String r1 = "result"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x002b }
            goto L_0x002d
        L_0x002b:
            java.lang.String r0 = "network_timeout"
        L_0x002d:
            com.applovin.impl.sdk.b.c r3 = com.applovin.impl.sdk.b.c.a(r0, r3)     // Catch:{ JSONException -> 0x0032 }
            return r3
        L_0x0032:
            r3 = move-exception
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x003e
            java.lang.String r0 = "Unable to parse API response"
            r2.a(r0, r3)
        L_0x003e:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.e.ab.c(org.json.JSONObject):com.applovin.impl.sdk.b.c");
    }

    /* access modifiers changed from: protected */
    public abstract void a(c cVar);

    /* access modifiers changed from: protected */
    public abstract boolean b();

    /* access modifiers changed from: protected */
    public int h() {
        return ((Integer) this.f15333b.a(b.bs)).intValue();
    }

    public void run() {
        a(i(), new b.c<JSONObject>() {
            public void a(int i2, String str, JSONObject jSONObject) {
                if (!ab.this.b()) {
                    if (v.a()) {
                        ab abVar = ab.this;
                        abVar.d("Reward validation failed with code " + i2 + " and error: " + str);
                    }
                    ab.this.a(i2);
                } else if (v.a()) {
                    ab abVar2 = ab.this;
                    abVar2.d("Reward validation failed with error code " + i2 + " but task was cancelled already");
                }
            }

            public void a(JSONObject jSONObject, int i2) {
                if (!ab.this.b()) {
                    if (v.a()) {
                        ab abVar = ab.this;
                        abVar.a("Reward validation succeeded with code " + i2 + " and response: " + jSONObject);
                    }
                    ab.this.b(jSONObject);
                } else if (v.a()) {
                    ab abVar2 = ab.this;
                    abVar2.d("Reward validation succeeded with code " + i2 + " but task was cancelled already");
                    ab abVar3 = ab.this;
                    abVar3.d("Response: " + jSONObject);
                }
            }
        });
    }
}
