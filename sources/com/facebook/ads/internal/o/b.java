package com.facebook.ads.internal.o;

import android.content.Context;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.c;
import com.facebook.ads.internal.protocol.d;
import com.facebook.ads.internal.protocol.f;
import com.facebook.ads.internal.protocol.h;
import com.facebook.ads.internal.q.a.l;
import com.facebook.ads.internal.q.a.t;
import com.facebook.ads.internal.q.a.z;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected String f20405a;

    /* renamed from: b  reason: collision with root package name */
    public Context f20406b;

    /* renamed from: c  reason: collision with root package name */
    public f f20407c;

    /* renamed from: d  reason: collision with root package name */
    private c f20408d;

    /* renamed from: e  reason: collision with root package name */
    private final AdPlacementType f20409e = this.f20408d.a();

    /* renamed from: f  reason: collision with root package name */
    private final String f20410f;

    /* renamed from: g  reason: collision with root package name */
    private final String f20411g;

    /* renamed from: h  reason: collision with root package name */
    private d f20412h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f20413i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f20414j;

    /* renamed from: k  reason: collision with root package name */
    private int f20415k;

    /* renamed from: l  reason: collision with root package name */
    private l f20416l;

    /* renamed from: m  reason: collision with root package name */
    private final Map<String, String> f20417m;

    /* renamed from: n  reason: collision with root package name */
    private final h f20418n;

    /* renamed from: o  reason: collision with root package name */
    private String f20419o;

    public b(Context context, com.facebook.ads.internal.i.c cVar, String str, l lVar, f fVar, d dVar, String str2, String str3, int i2, boolean z2, boolean z3, h hVar, String str4) {
        this.f20405a = str;
        this.f20416l = lVar;
        this.f20407c = fVar;
        this.f20408d = c.a(fVar);
        this.f20412h = dVar;
        this.f20410f = str2;
        this.f20411g = str3;
        this.f20415k = i2;
        this.f20413i = z2;
        this.f20414j = z3;
        this.f20417m = cVar.b();
        this.f20418n = hVar;
        this.f20406b = context;
        this.f20419o = str4;
    }

    private void a(Map<String, String> map, String str, String str2) {
        map.put(str, str2);
    }

    public String a() {
        return this.f20405a;
    }

    public c b() {
        return this.f20408d;
    }

    public l c() {
        return this.f20416l;
    }

    public int d() {
        return this.f20415k;
    }

    public h e() {
        return this.f20418n;
    }

    public Map<String, String> f() {
        HashMap hashMap = new HashMap(this.f20417m);
        a(hashMap, "IDFA", com.facebook.ads.internal.c.b.f20056b);
        a(hashMap, "IDFA_FLAG", com.facebook.ads.internal.c.b.f20057c ? "0" : "1");
        a(hashMap, "COPPA", String.valueOf(this.f20414j));
        a(hashMap, "PLACEMENT_ID", this.f20405a);
        AdPlacementType adPlacementType = this.f20409e;
        if (adPlacementType != AdPlacementType.UNKNOWN) {
            a(hashMap, "PLACEMENT_TYPE", adPlacementType.toString().toLowerCase());
        }
        l lVar = this.f20416l;
        if (lVar != null) {
            a(hashMap, "WIDTH", String.valueOf(lVar.b()));
            a(hashMap, "HEIGHT", String.valueOf(this.f20416l.a()));
        }
        a(hashMap, "ADAPTERS", this.f20411g);
        f fVar = this.f20407c;
        if (fVar != null) {
            a(hashMap, "TEMPLATE_ID", String.valueOf(fVar.a()));
        }
        d dVar = this.f20412h;
        if (dVar != null) {
            a(hashMap, "REQUEST_TYPE", String.valueOf(dVar.a()));
        }
        if (this.f20413i) {
            a(hashMap, "TEST_MODE", "1");
        }
        String str = this.f20410f;
        if (str != null) {
            a(hashMap, "DEMO_AD_ID", str);
        }
        int i2 = this.f20415k;
        if (i2 != 0) {
            a(hashMap, "NUM_ADS_REQUESTED", String.valueOf(i2));
        }
        a(hashMap, "CLIENT_EVENTS", com.facebook.ads.internal.j.b.a());
        a(hashMap, "KG_RESTRICTED", String.valueOf(z.a(this.f20406b)));
        a(hashMap, "REQUEST_TIME", t.a(System.currentTimeMillis()));
        if (this.f20418n.c()) {
            a(hashMap, "BID_ID", this.f20418n.d());
        }
        String str2 = this.f20419o;
        if (str2 != null) {
            a(hashMap, "STACK_TRACE", str2);
        }
        a(hashMap, "CLIENT_REQUEST_ID", UUID.randomUUID().toString());
        return hashMap;
    }
}
