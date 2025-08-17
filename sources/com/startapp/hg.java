package com.startapp;

import com.startapp.ig;
import java.util.HashSet;
import org.json.JSONObject;

public abstract class hg extends ig {

    /* renamed from: c  reason: collision with root package name */
    public final HashSet<String> f34671c;

    /* renamed from: d  reason: collision with root package name */
    public final JSONObject f34672d;

    /* renamed from: e  reason: collision with root package name */
    public final long f34673e;

    public hg(ig.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
        super(bVar);
        this.f34671c = new HashSet<>(hashSet);
        this.f34672d = jSONObject;
        this.f34673e = j2;
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }
}
