package com.facebook.ads.internal.o;

import com.facebook.ads.internal.protocol.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Long> f20401a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, Long> f20402b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, String> f20403c = new ConcurrentHashMap();

    /* renamed from: com.facebook.ads.internal.o.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20404a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.ads.internal.protocol.c[] r0 = com.facebook.ads.internal.protocol.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20404a = r0
                com.facebook.ads.internal.protocol.c r1 = com.facebook.ads.internal.protocol.c.BANNER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20404a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.protocol.c r1 = com.facebook.ads.internal.protocol.c.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20404a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.ads.internal.protocol.c r1 = com.facebook.ads.internal.protocol.c.NATIVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20404a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.ads.internal.protocol.c r1 = com.facebook.ads.internal.protocol.c.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.o.a.AnonymousClass1.<clinit>():void");
        }
    }

    private static long a(String str, c cVar) {
        return f20401a.containsKey(str) ? f20401a.get(str).longValue() : AnonymousClass1.f20404a[cVar.ordinal()] != 1 ? -1000 : 15000;
    }

    public static void a(long j2, b bVar) {
        f20401a.put(d(bVar), Long.valueOf(j2));
    }

    public static void a(String str, b bVar) {
        f20403c.put(d(bVar), str);
    }

    public static boolean a(b bVar) {
        String d2 = d(bVar);
        if (!f20402b.containsKey(d2)) {
            return false;
        }
        return System.currentTimeMillis() - f20402b.get(d2).longValue() < a(d2, bVar.b());
    }

    public static void b(b bVar) {
        f20402b.put(d(bVar), Long.valueOf(System.currentTimeMillis()));
    }

    public static String c(b bVar) {
        return f20403c.get(d(bVar));
    }

    private static String d(b bVar) {
        Object[] objArr = new Object[6];
        int i2 = 0;
        objArr[0] = bVar.a();
        objArr[1] = bVar.b();
        objArr[2] = bVar.f20407c;
        objArr[3] = Integer.valueOf(bVar.c() == null ? 0 : bVar.c().a());
        if (bVar.c() != null) {
            i2 = bVar.c().b();
        }
        objArr[4] = Integer.valueOf(i2);
        objArr[5] = Integer.valueOf(bVar.d());
        return String.format("%s:%s:%s:%d:%d:%d", objArr);
    }
}
