package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

public final class zzggs {
    private Integer zza;
    private Integer zzb;
    private zzggt zzc;
    private zzggu zzd;

    private zzggs() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    /* synthetic */ zzggs(zzggr zzggr) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzggu.zzd;
    }

    public final zzggs zza(zzggt zzggt) {
        this.zzc = zzggt;
        return this;
    }

    public final zzggs zzb(int i2) throws GeneralSecurityException {
        this.zza = Integer.valueOf(i2);
        return this;
    }

    public final zzggs zzc(int i2) throws GeneralSecurityException {
        this.zzb = Integer.valueOf(i2);
        return this;
    }

    public final zzggs zzd(zzggu zzggu) {
        this.zzd = zzggu;
        return this;
    }

    public final zzggw zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("tag size is not set");
        } else if (this.zzc == null) {
            throw new GeneralSecurityException("hash type is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("variant is not set");
        } else if (num.intValue() >= 16) {
            int intValue = this.zzb.intValue();
            zzggt zzggt = this.zzc;
            if (intValue >= 10) {
                if (zzggt == zzggt.zza) {
                    if (intValue > 20) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zzggt == zzggt.zzb) {
                    if (intValue > 28) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zzggt == zzggt.zzc) {
                    if (intValue > 32) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zzggt == zzggt.zzd) {
                    if (intValue > 48) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zzggt != zzggt.zze) {
                    throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                } else if (intValue > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{Integer.valueOf(intValue)}));
                }
                return new zzggw(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, (zzggv) null);
            }
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{Integer.valueOf(intValue)}));
        } else {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", new Object[]{this.zza}));
        }
    }
}
