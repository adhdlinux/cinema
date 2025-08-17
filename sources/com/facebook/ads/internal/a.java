package com.facebook.ads.internal;

import android.content.Context;
import android.os.Handler;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.e;
import com.facebook.ads.internal.adapters.y;
import com.facebook.ads.internal.adapters.z;
import com.facebook.ads.internal.o.c;
import com.facebook.ads.internal.o.g;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.d;
import com.facebook.ads.internal.protocol.f;
import com.facebook.ads.internal.protocol.h;
import com.facebook.ads.internal.q.a.l;
import com.facebook.ads.internal.q.a.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a implements c.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f19621a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19622b;

    /* renamed from: c  reason: collision with root package name */
    private final c f19623c;

    /* renamed from: d  reason: collision with root package name */
    private final f f19624d;

    /* renamed from: e  reason: collision with root package name */
    private final d f19625e;

    /* renamed from: f  reason: collision with root package name */
    private final AdSize f19626f;

    /* renamed from: g  reason: collision with root package name */
    private final int f19627g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19628h = true;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final Handler f19629i = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Runnable f19630j = new b(this);

    /* renamed from: k  reason: collision with root package name */
    private final com.facebook.ads.internal.m.c f19631k;

    /* renamed from: l  reason: collision with root package name */
    private C0029a f19632l;

    /* renamed from: m  reason: collision with root package name */
    private com.facebook.ads.internal.h.c f19633m;

    /* renamed from: com.facebook.ads.internal.a$a  reason: collision with other inner class name */
    public interface C0029a {
        void a(com.facebook.ads.internal.protocol.a aVar);

        void a(List<y> list);
    }

    private static final class b extends com.facebook.ads.internal.q.a.y<a> {
        public b(a aVar) {
            super(aVar);
        }

        public void run() {
            a aVar = (a) a();
            if (aVar != null) {
                if (com.facebook.ads.internal.q.e.a.a(aVar.f19621a)) {
                    aVar.a();
                } else {
                    aVar.f19629i.postDelayed(aVar.f19630j, 5000);
                }
            }
        }
    }

    static {
        com.facebook.ads.internal.q.a.d.a();
    }

    public a(Context context, String str, f fVar, AdSize adSize, d dVar, int i2) {
        this.f19621a = context;
        this.f19622b = str;
        this.f19624d = fVar;
        this.f19626f = adSize;
        this.f19625e = dVar;
        this.f19627g = i2;
        c cVar = new c(context);
        this.f19623c = cVar;
        cVar.a((c.a) this);
        this.f19631k = com.facebook.ads.internal.m.d.a(context);
        com.facebook.ads.internal.i.a.a(context).a();
    }

    private List<y> d() {
        com.facebook.ads.internal.h.c cVar = this.f19633m;
        final ArrayList arrayList = new ArrayList(cVar.c());
        for (com.facebook.ads.internal.h.a d2 = cVar.d(); d2 != null; d2 = cVar.d()) {
            String a2 = d2.a();
            AdPlacementType adPlacementType = AdPlacementType.NATIVE;
            AdAdapter a3 = e.a(a2, adPlacementType);
            if (a3 != null && a3.getPlacementType() == adPlacementType) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", d2.b());
                hashMap.put("definition", cVar.a());
                ((y) a3).a(this.f19621a, new z() {
                    public void a(y yVar) {
                        arrayList.add(yVar);
                    }

                    public void a(y yVar, com.facebook.ads.internal.protocol.a aVar) {
                    }

                    public void b(y yVar) {
                    }

                    public void c(y yVar) {
                    }
                }, this.f19631k, hashMap, NativeAdBase.getViewTraversalPredicate());
            }
        }
        return arrayList;
    }

    public void a() {
        try {
            l lVar = null;
            h hVar = new h(this.f19621a, (String) null, (String) null, (f) null);
            Context context = this.f19621a;
            com.facebook.ads.internal.i.c cVar = new com.facebook.ads.internal.i.c(this.f19621a, false);
            String str = this.f19622b;
            AdSize adSize = this.f19626f;
            if (adSize != null) {
                lVar = new l(adSize.getHeight(), this.f19626f.getWidth());
            }
            f fVar = this.f19624d;
            this.f19623c.a(new com.facebook.ads.internal.o.b(context, cVar, str, lVar, fVar, this.f19625e, (String) null, e.a(com.facebook.ads.internal.protocol.c.a(fVar).a()), this.f19627g, AdSettings.isTestMode(this.f19621a), AdSettings.isChildDirected(), hVar, o.a(com.facebook.ads.internal.l.a.q(this.f19621a))));
        } catch (com.facebook.ads.internal.protocol.b e2) {
            a(com.facebook.ads.internal.protocol.a.a(e2));
        }
    }

    public void a(C0029a aVar) {
        this.f19632l = aVar;
    }

    public void a(g gVar) {
        com.facebook.ads.internal.h.c a2 = gVar.a();
        if (a2 != null) {
            if (this.f19628h) {
                long c2 = a2.a().c();
                if (c2 == 0) {
                    c2 = 1800000;
                }
                this.f19629i.postDelayed(this.f19630j, c2);
            }
            this.f19633m = a2;
            List<y> d2 = d();
            if (this.f19632l == null) {
                return;
            }
            if (d2.isEmpty()) {
                this.f19632l.a(com.facebook.ads.internal.protocol.a.a(AdErrorType.NO_FILL, ""));
            } else {
                this.f19632l.a(d2);
            }
        } else {
            throw new IllegalStateException("no placement in response");
        }
    }

    public void a(com.facebook.ads.internal.protocol.a aVar) {
        if (this.f19628h) {
            this.f19629i.postDelayed(this.f19630j, 1800000);
        }
        C0029a aVar2 = this.f19632l;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public void b() {
    }

    public void c() {
        this.f19628h = false;
        this.f19629i.removeCallbacks(this.f19630j);
    }
}
