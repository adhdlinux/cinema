package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.ArrayList;
import java.util.List;

public enum g {
    ANBANNER(i.class, r13, AdPlacementType.BANNER),
    ANINTERSTITIAL(k.class, r11, AdPlacementType.INTERSTITIAL),
    ADMOBNATIVE(d.class, r18, r2),
    ANNATIVE(m.class, r11, r2),
    ANNATIVEBANNER(m.class, r11, AdPlacementType.NATIVE_BANNER),
    ANINSTREAMVIDEO(j.class, r11, AdPlacementType.INSTREAM),
    ANREWARDEDVIDEO(n.class, r11, AdPlacementType.REWARDED_VIDEO),
    INMOBINATIVE(r.class, f.INMOBI, r12),
    YAHOONATIVE(o.class, f.YAHOO, r12);
    

    /* renamed from: n  reason: collision with root package name */
    private static List<g> f19802n;

    /* renamed from: j  reason: collision with root package name */
    public Class<?> f19804j;

    /* renamed from: k  reason: collision with root package name */
    public String f19805k;

    /* renamed from: l  reason: collision with root package name */
    public f f19806l;

    /* renamed from: m  reason: collision with root package name */
    public AdPlacementType f19807m;

    private g(Class<?> cls, f fVar, AdPlacementType adPlacementType) {
        this.f19804j = cls;
        this.f19806l = fVar;
        this.f19807m = adPlacementType;
    }

    public static List<g> a() {
        if (f19802n == null) {
            synchronized (g.class) {
                ArrayList arrayList = new ArrayList();
                f19802n = arrayList;
                arrayList.add(ANBANNER);
                f19802n.add(ANINTERSTITIAL);
                f19802n.add(ANNATIVE);
                f19802n.add(ANNATIVEBANNER);
                f19802n.add(ANINSTREAMVIDEO);
                f19802n.add(ANREWARDEDVIDEO);
                if (w.a(f.YAHOO)) {
                    f19802n.add(YAHOONATIVE);
                }
                if (w.a(f.INMOBI)) {
                    f19802n.add(INMOBINATIVE);
                }
                if (w.a(f.ADMOB)) {
                    f19802n.add(ADMOBNATIVE);
                }
            }
        }
        return f19802n;
    }
}
