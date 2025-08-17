package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.q;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.v;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

public class g extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final long f15698a = TimeUnit.SECONDS.toMillis(5);

    /* renamed from: c  reason: collision with root package name */
    private final AtomicLong f15699c = new AtomicLong();

    /* renamed from: d  reason: collision with root package name */
    private final f f15700d;

    /* renamed from: e  reason: collision with root package name */
    private final v f15701e;

    g(f fVar, m mVar) {
        super("PersistentPostbackQueueSaveTask", mVar);
        this.f15701e = mVar.A();
        this.f15700d = fVar;
    }

    private void a(List<h> list) {
        JSONArray jSONArray = new JSONArray();
        for (h n2 : list) {
            try {
                jSONArray.put(n2.n());
            } catch (Throwable th) {
                if (v.a()) {
                    this.f15701e.b("PersistentPostbackQueueSaveTask", "Unable to serialize postback request to JSON.", th);
                }
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pb", jSONArray);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jSONObject.toString().getBytes("UTF-8"));
            q ab = this.f15333b.ab();
            ab.a((InputStream) byteArrayInputStream, ab.a("persistent_postback_cache.json", this.f15333b.L()));
            if (v.a()) {
                this.f15701e.b("PersistentPostbackQueueSaveTask", "Wrote updated postback queue to disk.");
            }
        } catch (Throwable th2) {
            if (v.a()) {
                this.f15701e.b("PersistentPostbackQueueSaveTask", "Failed to persist postbacks", th2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<h> a(int i2) {
        ArrayList<h> arrayList = new ArrayList<>();
        try {
            q ab = this.f15333b.ab();
            if (ab.b("persistent_postback_cache.json", this.f15333b.L())) {
                String a2 = ab.a(ab.a("persistent_postback_cache.json", this.f15333b.L()));
                if (StringUtils.isValidString(a2)) {
                    JSONArray jSONArray = new JSONObject(a2).getJSONArray("pb");
                    if (v.a()) {
                        v vVar = this.f15701e;
                        vVar.b("PersistentPostbackQueueSaveTask", "Deserializing " + jSONArray.length() + " postback(s).");
                    }
                    arrayList.ensureCapacity(Math.max(1, jSONArray.length()));
                    int intValue = ((Integer) this.f15333b.a(b.cJ)).intValue();
                    for (int i3 = 0; i3 < jSONArray.length() && arrayList.size() < i2; i3++) {
                        h hVar = new h(jSONArray.getJSONObject(i3), this.f15333b);
                        if (hVar.k() < intValue) {
                            arrayList.add(hVar);
                        } else if (v.a()) {
                            v vVar2 = this.f15701e;
                            vVar2.b("PersistentPostbackQueueSaveTask", "Skipping deserialization because maximum attempt count exceeded for postback: " + hVar);
                        }
                    }
                    if (v.a()) {
                        v vVar3 = this.f15701e;
                        vVar3.b("PersistentPostbackQueueSaveTask", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
                    }
                }
            }
        } catch (Throwable th) {
            if (v.a()) {
                this.f15701e.b("PersistentPostbackQueueSaveTask", "Failed to deserialize postback queue", th);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f15699c.set(System.currentTimeMillis());
        this.f15333b.S().a((a) this, o.a.POSTBACKS, f15698a);
    }

    public void run() {
        if (this.f15700d.a() > this.f15699c.get()) {
            a(this.f15700d.b());
        }
        a();
    }
}
