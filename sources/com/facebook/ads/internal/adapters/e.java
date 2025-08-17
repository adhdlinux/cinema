package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.q.a.v;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<g> f19784a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<AdPlacementType, String> f19785b = new ConcurrentHashMap();

    /* renamed from: com.facebook.ads.internal.adapters.e$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19786a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.ads.internal.protocol.AdPlacementType[] r0 = com.facebook.ads.internal.protocol.AdPlacementType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19786a = r0
                com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19786a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19786a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.NATIVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f19786a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.NATIVE_BANNER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f19786a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.INSTREAM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f19786a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.e.AnonymousClass1.<clinit>():void");
        }
    }

    static {
        Class cls;
        for (g next : g.a()) {
            switch (AnonymousClass1.f19786a[next.f19807m.ordinal()]) {
                case 1:
                    cls = BannerAdapter.class;
                    break;
                case 2:
                    cls = InterstitialAdapter.class;
                    break;
                case 3:
                case 4:
                    cls = y.class;
                    break;
                case 5:
                    cls = s.class;
                    break;
                case 6:
                    cls = ab.class;
                    break;
                default:
                    cls = null;
                    break;
            }
            if (cls != null) {
                Class<?> cls2 = next.f19804j;
                if (cls2 == null) {
                    try {
                        cls2 = Class.forName(next.f19805k);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                if (cls2 != null && cls.isAssignableFrom(cls2)) {
                    f19784a.add(next);
                }
            }
        }
    }

    public static AdAdapter a(f fVar, AdPlacementType adPlacementType) {
        AdAdapter adAdapter = null;
        try {
            g b2 = b(fVar, adPlacementType);
            if (b2 == null || !f19784a.contains(b2)) {
                return null;
            }
            Class<?> cls = b2.f19804j;
            if (cls == null) {
                cls = Class.forName(b2.f19805k);
            }
            AdAdapter adAdapter2 = (AdAdapter) cls.newInstance();
            try {
                if (adAdapter2 instanceof m) {
                    ((m) adAdapter2).a(adPlacementType);
                }
                return adAdapter2;
            } catch (Exception e2) {
                adAdapter = adAdapter2;
                e = e2;
                e.printStackTrace();
                return adAdapter;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return adAdapter;
        }
    }

    public static AdAdapter a(String str, AdPlacementType adPlacementType) {
        return a(f.a(str), adPlacementType);
    }

    public static String a(AdPlacementType adPlacementType) {
        Map<AdPlacementType, String> map = f19785b;
        if (map.containsKey(adPlacementType)) {
            return map.get(adPlacementType);
        }
        HashSet hashSet = new HashSet();
        for (g next : f19784a) {
            if (next.f19807m == adPlacementType) {
                hashSet.add(next.f19806l.toString());
            }
        }
        String a2 = v.a(hashSet, ",");
        f19785b.put(adPlacementType, a2);
        return a2;
    }

    private static g b(f fVar, AdPlacementType adPlacementType) {
        for (g next : f19784a) {
            if (next.f19806l == fVar && next.f19807m == adPlacementType) {
                return next;
            }
        }
        return null;
    }
}
