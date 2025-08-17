package com.facebook.ads;

import com.facebook.ads.internal.n.c;

public enum AdNetwork {
    AN(c.AN),
    ADMOB(c.ADMOB),
    FLURRY(c.FLURRY),
    INMOBI(c.INMOBI);
    

    /* renamed from: a  reason: collision with root package name */
    private final c f19414a;

    /* renamed from: com.facebook.ads.AdNetwork$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19415a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.ads.internal.n.c[] r0 = com.facebook.ads.internal.n.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19415a = r0
                com.facebook.ads.internal.n.c r1 = com.facebook.ads.internal.n.c.AN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19415a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.n.c r1 = com.facebook.ads.internal.n.c.ADMOB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19415a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.ads.internal.n.c r1 = com.facebook.ads.internal.n.c.FLURRY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f19415a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.ads.internal.n.c r1 = com.facebook.ads.internal.n.c.INMOBI     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.AdNetwork.AnonymousClass1.<clinit>():void");
        }
    }

    private AdNetwork(c cVar) {
        this.f19414a = cVar;
    }

    public static AdNetwork fromInternalAdNetwork(c cVar) {
        if (cVar == null) {
            return AN;
        }
        int i2 = AnonymousClass1.f19415a[cVar.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? AN : INMOBI : FLURRY : ADMOB : AN;
    }
}
