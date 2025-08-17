package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.internal.q.a.d;
import com.facebook.ads.internal.r.a;
import java.util.HashMap;
import java.util.Map;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected final c f19760a;

    /* renamed from: b  reason: collision with root package name */
    protected final a f19761b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f19762c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19763d;

    public b(Context context, c cVar, a aVar) {
        this.f19762c = context;
        this.f19760a = cVar;
        this.f19761b = aVar;
    }

    public final void a() {
        if (!this.f19763d) {
            c cVar = this.f19760a;
            if (cVar != null) {
                cVar.a();
            }
            HashMap hashMap = new HashMap();
            a aVar = this.f19761b;
            if (aVar != null) {
                aVar.a((Map<String, String>) hashMap);
            }
            a(hashMap);
            this.f19763d = true;
            d.a(this.f19762c, "Impression logged");
            c cVar2 = this.f19760a;
            if (cVar2 != null) {
                cVar2.b();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(Map<String, String> map);
}
