package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;

public final class zzgne implements zzfye {
    private final zzghv zza;
    private final int zzb;

    public zzgne(zzghv zzghv, int i2) throws GeneralSecurityException {
        this.zza = zzghv;
        this.zzb = i2;
        if (i2 >= 10) {
            zzghv.zza(new byte[0], i2);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!MessageDigest.isEqual(this.zza.zza(bArr2, this.zzb), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
