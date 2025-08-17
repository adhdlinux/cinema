package com.iab.omid.library.applovin.walking.a;

import com.iab.omid.library.applovin.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

public abstract class a extends b {

    /* renamed from: a  reason: collision with root package name */
    protected final HashSet<String> f31565a;

    /* renamed from: b  reason: collision with root package name */
    protected final JSONObject f31566b;

    /* renamed from: c  reason: collision with root package name */
    protected final long f31567c;

    public a(b.C0047b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
        super(bVar);
        this.f31565a = new HashSet<>(hashSet);
        this.f31566b = jSONObject;
        this.f31567c = j2;
    }
}
