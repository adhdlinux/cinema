package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzgfo {
    private zzgfz zza = null;
    private zzgnl zzb = null;
    private Integer zzc = null;

    private zzgfo() {
    }

    /* synthetic */ zzgfo(zzgfn zzgfn) {
    }

    public final zzgfo zza(zzgnl zzgnl) throws GeneralSecurityException {
        this.zzb = zzgnl;
        return this;
    }

    public final zzgfo zzb(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgfo zzc(zzgfz zzgfz) {
        this.zza = zzgfz;
        return this;
    }

    public final zzgfq zzd() throws GeneralSecurityException {
        zzgnl zzgnl;
        zzgnk zzb2;
        zzgfz zzgfz = this.zza;
        if (zzgfz == null || (zzgnl = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgfz.zzb() != zzgnl.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgfz.zze() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zze() || this.zzc == null) {
            if (this.zza.zzd() == zzgfx.zzd) {
                zzb2 = zzgnk.zzb(new byte[0]);
            } else if (this.zza.zzd() == zzgfx.zzc || this.zza.zzd() == zzgfx.zzb) {
                zzb2 = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzd() == zzgfx.zza) {
                zzb2 = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            return new zzgfq(this.zza, this.zzb, zzb2, this.zzc, (zzgfp) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
