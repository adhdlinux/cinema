package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

public final class zzgas {
    private Integer zza;
    private Integer zzb;
    private Integer zzc;
    private zzgat zzd;

    private zzgas() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    /* synthetic */ zzgas(zzgar zzgar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzgat.zzc;
    }

    public final zzgas zza(int i2) throws GeneralSecurityException {
        this.zzb = 12;
        return this;
    }

    public final zzgas zzb(int i2) throws GeneralSecurityException {
        if (i2 == 16 || i2 == 24 || i2 == 32) {
            this.zza = Integer.valueOf(i2);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i2)}));
    }

    public final zzgas zzc(int i2) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzgas zzd(zzgat zzgat) {
        this.zzd = zzgat;
        return this;
    }

    public final zzgav zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        } else if (this.zzc != null) {
            int intValue = num.intValue();
            this.zzb.intValue();
            this.zzc.intValue();
            return new zzgav(intValue, 12, 16, this.zzd, (zzgau) null);
        } else {
            throw new GeneralSecurityException("Tag size is not set");
        }
    }
}
