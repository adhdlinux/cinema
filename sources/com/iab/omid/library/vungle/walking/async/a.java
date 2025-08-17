package com.iab.omid.library.vungle.walking.async;

import com.iab.omid.library.vungle.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

public abstract class a extends b {

    /* renamed from: c  reason: collision with root package name */
    protected final HashSet<String> f31785c;

    /* renamed from: d  reason: collision with root package name */
    protected final JSONObject f31786d;

    /* renamed from: e  reason: collision with root package name */
    protected final long f31787e;

    public a(b.C0051b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
        super(bVar);
        this.f31785c = new HashSet<>(hashSet);
        this.f31786d = jSONObject;
        this.f31787e = j2;
    }
}
