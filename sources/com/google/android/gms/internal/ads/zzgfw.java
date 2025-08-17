package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

public final class zzgfw {
    private Integer zza;
    private Integer zzb;
    private zzgfx zzc;

    private zzgfw() {
        this.zza = null;
        this.zzb = null;
        throw null;
    }

    /* synthetic */ zzgfw(zzgfv zzgfv) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzgfx.zzd;
    }

    public final zzgfw zza(int i2) throws GeneralSecurityException {
        if (i2 == 16 || i2 == 32) {
            this.zza = Integer.valueOf(i2);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(i2 * 8)}));
    }

    public final zzgfw zzb(int i2) throws GeneralSecurityException {
        if (i2 < 10 || i2 > 16) {
            throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i2);
        }
        this.zzb = Integer.valueOf(i2);
        return this;
    }

    public final zzgfw zzc(zzgfx zzgfx) {
        this.zzc = zzgfx;
        return this;
    }

    public final zzgfz zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("tag size not set");
        } else if (this.zzc != null) {
            return new zzgfz(num.intValue(), this.zzb.intValue(), this.zzc, (zzgfy) null);
        } else {
            throw new GeneralSecurityException("variant not set");
        }
    }
}
