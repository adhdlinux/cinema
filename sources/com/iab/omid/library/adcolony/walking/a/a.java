package com.iab.omid.library.adcolony.walking.a;

import com.iab.omid.library.adcolony.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

public abstract class a extends b {

    /* renamed from: c  reason: collision with root package name */
    protected final HashSet<String> f31448c;

    /* renamed from: d  reason: collision with root package name */
    protected final JSONObject f31449d;

    /* renamed from: e  reason: collision with root package name */
    protected final long f31450e;

    public a(b.C0044b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
        super(bVar);
        this.f31448c = new HashSet<>(hashSet);
        this.f31449d = jSONObject;
        this.f31450e = j2;
    }
}
