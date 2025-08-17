package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.ge;
import java.util.HashSet;
import org.json.JSONObject;

public class xe extends xd {
    public xe(ge.b bVar, HashSet hashSet, JSONObject jSONObject, long j2) {
        super(bVar, hashSet, jSONObject, j2);
    }

    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        return this.f18998d.toString();
    }

    public final void b(String str) {
        ke c2 = ke.c();
        if (c2 != null) {
            for (qd qdVar : c2.b()) {
                if (this.f18997c.contains(qdVar.j())) {
                    qdVar.k().a(str, this.f18999e);
                }
            }
        }
    }

    /* renamed from: a */
    public void onPostExecute(String str) {
        b(str);
        super.onPostExecute(str);
    }
}
