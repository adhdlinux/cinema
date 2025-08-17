package com.facebook.ads;

import com.facebook.ads.internal.n.m;

public enum VideoAutoplayBehavior {
    DEFAULT,
    ON,
    OFF;

    /* renamed from: com.facebook.ads.VideoAutoplayBehavior$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19564a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.ads.internal.n.m[] r0 = com.facebook.ads.internal.n.m.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19564a = r0
                com.facebook.ads.internal.n.m r1 = com.facebook.ads.internal.n.m.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19564a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.n.m r1 = com.facebook.ads.internal.n.m.ON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19564a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.ads.internal.n.m r1 = com.facebook.ads.internal.n.m.OFF     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.VideoAutoplayBehavior.AnonymousClass1.<clinit>():void");
        }
    }

    public static VideoAutoplayBehavior fromInternalAutoplayBehavior(m mVar) {
        if (mVar == null) {
            return DEFAULT;
        }
        int i2 = AnonymousClass1.f19564a[mVar.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? DEFAULT : OFF : ON : DEFAULT;
    }
}
