package com.iab.omid.library.adcolony.walking;

import com.iab.omid.library.adcolony.walking.a.b;
import com.iab.omid.library.adcolony.walking.a.c;
import com.iab.omid.library.adcolony.walking.a.d;
import com.iab.omid.library.adcolony.walking.a.e;
import com.iab.omid.library.adcolony.walking.a.f;
import java.util.HashSet;
import org.json.JSONObject;

public class b implements b.C0044b {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f31457a;

    /* renamed from: b  reason: collision with root package name */
    private final c f31458b;

    public b(c cVar) {
        this.f31458b = cVar;
    }

    public void a() {
        this.f31458b.c(new d(this));
    }

    public void a(JSONObject jSONObject) {
        this.f31457a = jSONObject;
    }

    public JSONObject b() {
        return this.f31457a;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j2) {
        this.f31458b.c(new f(this, hashSet, jSONObject, j2));
    }

    public void c(JSONObject jSONObject, HashSet<String> hashSet, long j2) {
        this.f31458b.c(new e(this, hashSet, jSONObject, j2));
    }
}
