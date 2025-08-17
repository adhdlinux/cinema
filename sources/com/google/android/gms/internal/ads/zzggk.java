package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzggk {
    private zzggw zza = null;
    private zzgnl zzb = null;
    private Integer zzc = null;

    private zzggk() {
    }

    /* synthetic */ zzggk(zzggj zzggj) {
    }

    public final zzggk zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzggk zzb(zzgnl zzgnl) {
        this.zzb = zzgnl;
        return this;
    }

    public final zzggk zzc(zzggw zzggw) {
        this.zza = zzggw;
        return this;
    }

    public final zzggm zzd() throws GeneralSecurityException {
        zzgnl zzgnl;
        zzgnk zzb2;
        zzggw zzggw = this.zza;
        if (zzggw == null || (zzgnl = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzggw.zzb() != zzgnl.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzggw.zzf() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzf() || this.zzc == null) {
            if (this.zza.zze() == zzggu.zzd) {
                zzb2 = zzgnk.zzb(new byte[0]);
            } else if (this.zza.zze() == zzggu.zzc || this.zza.zze() == zzggu.zzb) {
                zzb2 = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zze() == zzggu.zza) {
                zzb2 = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(this.zza.zze())));
            }
            return new zzggm(this.zza, this.zzb, zzb2, this.zzc, (zzggl) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
