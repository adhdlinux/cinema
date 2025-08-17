package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzgal {
    private zzgav zza = null;
    private zzgnl zzb = null;
    private Integer zzc = null;

    private zzgal() {
    }

    /* synthetic */ zzgal(zzgak zzgak) {
    }

    public final zzgal zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgal zzb(zzgnl zzgnl) {
        this.zzb = zzgnl;
        return this;
    }

    public final zzgal zzc(zzgav zzgav) {
        this.zza = zzgav;
        return this;
    }

    public final zzgan zzd() throws GeneralSecurityException {
        zzgnl zzgnl;
        zzgnk zzb2;
        zzgav zzgav = this.zza;
        if (zzgav == null || (zzgnl = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgav.zza() != zzgnl.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgav.zzc() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzc() || this.zzc == null) {
            if (this.zza.zzb() == zzgat.zzc) {
                zzb2 = zzgnk.zzb(new byte[0]);
            } else if (this.zza.zzb() == zzgat.zzb) {
                zzb2 = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzb() == zzgat.zza) {
                zzb2 = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(this.zza.zzb())));
            }
            return new zzgan(this.zza, this.zzb, zzb2, this.zzc, (zzgam) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
