package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

public final class zzgbj {
    private Integer zza;
    private zzgbk zzb;

    private zzgbj() {
        this.zza = null;
        throw null;
    }

    /* synthetic */ zzgbj(zzgbi zzgbi) {
        this.zza = null;
        this.zzb = zzgbk.zzc;
    }

    public final zzgbj zza(int i2) throws GeneralSecurityException {
        if (i2 == 16 || i2 == 32) {
            this.zza = Integer.valueOf(i2);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i2)}));
    }

    public final zzgbj zzb(zzgbk zzgbk) {
        this.zzb = zzgbk;
        return this;
    }

    public final zzgbm zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb != null) {
            return new zzgbm(num.intValue(), this.zzb, (zzgbl) null);
        } else {
            throw new GeneralSecurityException("Variant is not set");
        }
    }
}
