package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class zzgcx {
    private static final ThreadLocal zza = new zzgcw();
    private final SecretKey zzb;

    public zzgcx(byte[] bArr, boolean z2) throws GeneralSecurityException {
        if (zzgdh.zza(2)) {
            zzgni.zza(bArr.length);
            this.zzb = new SecretKeySpec(bArr, "AES");
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (r2.equals("The Android Project") != false) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zza(byte[] r7, byte[] r8, byte[] r9) throws java.security.GeneralSecurityException {
        /*
            r6 = this;
            int r0 = r7.length
            r1 = 12
            if (r0 != r1) goto L_0x0082
            int r0 = r8.length
            r2 = 28
            if (r0 < r2) goto L_0x007a
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r7)
            r3 = 0
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r8, r3, r1)
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0072
            java.lang.String r2 = "java.vendor"
            java.lang.String r2 = java.lang.System.getProperty(r2)
            java.lang.String r4 = "The Android Project"
            if (r2 == r4) goto L_0x002c
            r5 = 0
            if (r2 == 0) goto L_0x0032
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0032
        L_0x002c:
            int r2 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
        L_0x0032:
            if (r5 == 0) goto L_0x0042
            int r2 = r5.intValue()
            r4 = 19
            if (r2 > r4) goto L_0x0042
            javax.crypto.spec.IvParameterSpec r2 = new javax.crypto.spec.IvParameterSpec
            r2.<init>(r7, r3, r1)
            goto L_0x0049
        L_0x0042:
            javax.crypto.spec.GCMParameterSpec r2 = new javax.crypto.spec.GCMParameterSpec
            r4 = 128(0x80, float:1.794E-43)
            r2.<init>(r4, r7, r3, r1)
        L_0x0049:
            java.lang.ThreadLocal r7 = zza
            java.lang.Object r3 = r7.get()
            javax.crypto.Cipher r3 = (javax.crypto.Cipher) r3
            r4 = 2
            javax.crypto.SecretKey r5 = r6.zzb
            r3.init(r4, r5, r2)
            if (r9 == 0) goto L_0x0065
            int r2 = r9.length
            if (r2 == 0) goto L_0x0065
            java.lang.Object r2 = r7.get()
            javax.crypto.Cipher r2 = (javax.crypto.Cipher) r2
            r2.updateAAD(r9)
        L_0x0065:
            int r0 = r0 + -12
            java.lang.Object r7 = r7.get()
            javax.crypto.Cipher r7 = (javax.crypto.Cipher) r7
            byte[] r7 = r7.doFinal(r8, r1, r0)
            return r7
        L_0x0072:
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException
            java.lang.String r8 = "iv does not match prepended iv"
            r7.<init>(r8)
            throw r7
        L_0x007a:
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException
            java.lang.String r8 = "ciphertext too short"
            r7.<init>(r8)
            throw r7
        L_0x0082:
            java.security.GeneralSecurityException r7 = new java.security.GeneralSecurityException
            java.lang.String r8 = "iv is wrong size"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgcx.zza(byte[], byte[], byte[]):byte[]");
    }
}
