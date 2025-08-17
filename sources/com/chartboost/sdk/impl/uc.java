package com.chartboost.sdk.impl;

public abstract class uc {

    /* renamed from: a  reason: collision with root package name */
    public static final String f18782a = tc.class.getSimpleName();

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.chartboost.sdk.impl.s9 b(com.chartboost.sdk.impl.rc r3, com.chartboost.sdk.impl.cb r4, com.chartboost.sdk.impl.v5 r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0012
            java.io.File r1 = r5.c()     // Catch:{ Exception -> 0x0010 }
            java.lang.String r2 = r3.d()     // Catch:{ Exception -> 0x0010 }
            java.io.File r5 = r5.a((java.io.File) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0010 }
            goto L_0x0013
        L_0x0010:
            r3 = move-exception
            goto L_0x0034
        L_0x0012:
            r5 = r0
        L_0x0013:
            if (r5 == 0) goto L_0x0021
            boolean r1 = r5.exists()     // Catch:{ Exception -> 0x0010 }
            r2 = 1
            if (r1 != r2) goto L_0x0021
            java.io.RandomAccessFile r3 = r4.a(r5)     // Catch:{ Exception -> 0x0010 }
            goto L_0x0043
        L_0x0021:
            java.io.File r5 = r3.b()     // Catch:{ Exception -> 0x0010 }
            java.lang.String r3 = r3.d()     // Catch:{ Exception -> 0x0010 }
            java.io.File r3 = r4.a(r5, r3)     // Catch:{ Exception -> 0x0010 }
            if (r3 == 0) goto L_0x0042
            java.io.RandomAccessFile r3 = r4.a(r3)     // Catch:{ Exception -> 0x0010 }
            goto L_0x0043
        L_0x0034:
            java.lang.String r4 = f18782a
            java.lang.String r5 = "TAG"
            kotlin.jvm.internal.Intrinsics.e(r4, r5)
            java.lang.String r3 = r3.toString()
            com.chartboost.sdk.impl.w7.b(r4, r3)
        L_0x0042:
            r3 = r0
        L_0x0043:
            if (r3 == 0) goto L_0x004a
            com.chartboost.sdk.impl.s9 r0 = new com.chartboost.sdk.impl.s9
            r0.<init>(r3)
        L_0x004a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.uc.b(com.chartboost.sdk.impl.rc, com.chartboost.sdk.impl.cb, com.chartboost.sdk.impl.v5):com.chartboost.sdk.impl.s9");
    }
}
