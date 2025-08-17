package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

public final class zzgab {
    private Integer zza;
    private Integer zzb;
    private Integer zzc;
    private zzgac zzd;

    private zzgab() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    /* synthetic */ zzgab(zzgaa zzgaa) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzgac.zzc;
    }

    public final zzgab zza(int i2) throws GeneralSecurityException {
        if (i2 == 12 || i2 == 16) {
            this.zzb = Integer.valueOf(i2);
            return this;
        }
        throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", new Object[]{Integer.valueOf(i2)}));
    }

    public final zzgab zzb(int i2) throws GeneralSecurityException {
        if (i2 == 16 || i2 == 24 || i2 == 32) {
            this.zza = Integer.valueOf(i2);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i2)}));
    }

    public final zzgab zzc(int i2) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzgab zzd(zzgac zzgac) {
        this.zzd = zzgac;
        return this;
    }

    public final zzgae zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        } else if (this.zzc != null) {
            int intValue = num.intValue();
            int intValue2 = this.zzb.intValue();
            this.zzc.intValue();
            return new zzgae(intValue, intValue2, 16, this.zzd, (zzgad) null);
        } else {
            throw new GeneralSecurityException("Tag size is not set");
        }
    }
}
