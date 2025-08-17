package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzgbc {
    private zzgbm zza = null;
    private zzgnl zzb = null;
    private Integer zzc = null;

    private zzgbc() {
    }

    /* synthetic */ zzgbc(zzgbb zzgbb) {
    }

    public final zzgbc zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgbc zzb(zzgnl zzgnl) {
        this.zzb = zzgnl;
        return this;
    }

    public final zzgbc zzc(zzgbm zzgbm) {
        this.zza = zzgbm;
        return this;
    }

    public final zzgbe zzd() throws GeneralSecurityException {
        zzgnl zzgnl;
        zzgnk zzb2;
        zzgbm zzgbm = this.zza;
        if (zzgbm == null || (zzgnl = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgbm.zza() != zzgnl.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgbm.zzc() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzc() || this.zzc == null) {
            if (this.zza.zzb() == zzgbk.zzc) {
                zzb2 = zzgnk.zzb(new byte[0]);
            } else if (this.zza.zzb() == zzgbk.zzb) {
                zzb2 = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzb() == zzgbk.zza) {
                zzb2 = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(this.zza.zzb())));
            }
            return new zzgbe(this.zza, this.zzb, zzb2, this.zzc, (zzgbd) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
