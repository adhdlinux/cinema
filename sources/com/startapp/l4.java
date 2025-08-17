package com.startapp;

import com.startapp.sdk.adsbase.model.AdDetails;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class l4 {

    /* renamed from: a  reason: collision with root package name */
    public e4 f34854a = new e4();

    /* renamed from: b  reason: collision with root package name */
    public List<j4> f34855b;

    /* renamed from: c  reason: collision with root package name */
    public String f34856c = "";

    public void a(AdDetails adDetails) {
        j4 j4Var = new j4(adDetails);
        this.f34855b.add(j4Var);
        this.f34854a.a(this.f34855b.size() - 1, j4Var.f34716a, j4Var.f34724i);
    }

    public void a() {
        for (z6 next : this.f34854a.f34424a.values()) {
            if (next != null) {
                next.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
            }
        }
    }

    public void a(n4 n4Var, boolean z2) {
        e4 e4Var = this.f34854a;
        e4Var.f34427d = n4Var;
        if (z2) {
            e4Var.f34426c.clear();
            e4Var.f34428e = 0;
            e4Var.f34429f.clear();
            HashMap<String, z6> hashMap = e4Var.f34424a;
            if (hashMap != null) {
                for (z6 next : hashMap.values()) {
                    if (next != null) {
                        next.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
                    }
                }
                e4Var.f34424a.clear();
            }
        }
    }
}
