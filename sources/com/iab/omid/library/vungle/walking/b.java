package com.iab.omid.library.vungle.walking;

import com.iab.omid.library.vungle.walking.async.b;
import com.iab.omid.library.vungle.walking.async.c;
import com.iab.omid.library.vungle.walking.async.d;
import com.iab.omid.library.vungle.walking.async.e;
import com.iab.omid.library.vungle.walking.async.f;
import java.util.HashSet;
import org.json.JSONObject;

public class b implements b.C0051b {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f31794a;

    /* renamed from: b  reason: collision with root package name */
    private final c f31795b;

    public b(c cVar) {
        this.f31795b = cVar;
    }

    public JSONObject a() {
        return this.f31794a;
    }

    public void a(JSONObject jSONObject) {
        this.f31794a = jSONObject;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j2) {
        this.f31795b.c(new e(this, hashSet, jSONObject, j2));
    }

    public void c() {
        this.f31795b.c(new d(this));
    }

    public void d(JSONObject jSONObject, HashSet<String> hashSet, long j2) {
        this.f31795b.c(new f(this, hashSet, jSONObject, j2));
    }
}
