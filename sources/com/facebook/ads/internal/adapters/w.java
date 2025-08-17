package com.facebook.ads.internal.adapters;

public class w {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f19995a = {"com.flurry.android.FlurryAgent", "com.flurry.android.ads.FlurryAdErrorType", "com.flurry.android.ads.FlurryAdNative", "com.flurry.android.ads.FlurryAdNativeAsset", "com.flurry.android.ads.FlurryAdNativeListener"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f19996b = {"com.inmobi.ads.InMobiNative", "com.inmobi.sdk.InMobiSdk"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f19997c = {"com.google.android.gms.ads.formats.NativeAdView"};

    /* renamed from: com.facebook.ads.internal.adapters.w$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19998a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.ads.internal.adapters.f[] r0 = com.facebook.ads.internal.adapters.f.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19998a = r0
                com.facebook.ads.internal.adapters.f r1 = com.facebook.ads.internal.adapters.f.AN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19998a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.adapters.f r1 = com.facebook.ads.internal.adapters.f.YAHOO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19998a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.ads.internal.adapters.f r1 = com.facebook.ads.internal.adapters.f.INMOBI     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f19998a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.ads.internal.adapters.f r1 = com.facebook.ads.internal.adapters.f.ADMOB     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.w.AnonymousClass1.<clinit>():void");
        }
    }

    public static boolean a(f fVar) {
        int i2 = AnonymousClass1.f19998a[fVar.ordinal()];
        if (i2 == 1) {
            return true;
        }
        if (i2 == 2) {
            return a(f19995a);
        }
        if (i2 == 3) {
            return a(f19996b);
        }
        if (i2 != 4) {
            return false;
        }
        return a(f19997c);
    }

    private static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean a(String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String a2 : strArr) {
            if (!a(a2)) {
                return false;
            }
        }
        return true;
    }
}
