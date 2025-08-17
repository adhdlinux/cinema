package com.iab.omid.library.applovin.walking;

import com.iab.omid.library.applovin.walking.a.b;
import com.iab.omid.library.applovin.walking.a.c;
import com.iab.omid.library.applovin.walking.a.d;
import com.iab.omid.library.applovin.walking.a.e;
import com.iab.omid.library.applovin.walking.a.f;
import java.util.HashSet;
import org.json.JSONObject;

public class b implements b.C0047b {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f31574a;

    /* renamed from: b  reason: collision with root package name */
    private final c f31575b;

    public b(c cVar) {
        this.f31575b = cVar;
    }

    public void a() {
        this.f31575b.b(new d(this));
    }

    public void a(JSONObject jSONObject) {
        this.f31574a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j2) {
        this.f31575b.b(new f(this, hashSet, jSONObject, j2));
    }

    public JSONObject b() {
        return this.f31574a;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j2) {
        this.f31575b.b(new e(this, hashSet, jSONObject, j2));
    }
}
