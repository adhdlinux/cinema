package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

public final class zzgng {
    private static final ThreadLocal zza = new zzgnf();

    public static byte[] zza(int i2) {
        byte[] bArr = new byte[i2];
        ((SecureRandom) zza.get()).nextBytes(bArr);
        return bArr;
    }
}
