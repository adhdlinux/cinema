package com.chartboost.sdk.impl;

import android.text.TextUtils;
import com.chartboost.sdk.impl.ge;
import java.util.HashSet;
import org.json.JSONObject;

public class af extends xd {
    public af(ge.b bVar, HashSet hashSet, JSONObject jSONObject, long j2) {
        super(bVar, hashSet, jSONObject, j2);
    }

    private void b(String str) {
        ke c2 = ke.c();
        if (c2 != null) {
            for (qd qdVar : c2.b()) {
                if (this.f18997c.contains(qdVar.j())) {
                    qdVar.k().b(str, this.f18999e);
                }
            }
        }
    }

    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        if (me.h(this.f18998d, this.f17787b.a())) {
            return null;
        }
        this.f17787b.a(this.f18998d);
        return this.f18998d.toString();
    }

    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            b(str);
        }
        super.onPostExecute(str);
    }
}
