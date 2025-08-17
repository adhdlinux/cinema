package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzfyz {
    private zzfzk zza = null;
    private zzgnl zzb = null;
    private zzgnl zzc = null;
    private Integer zzd = null;

    private zzfyz() {
    }

    /* synthetic */ zzfyz(zzfyy zzfyy) {
    }

    public final zzfyz zza(zzgnl zzgnl) {
        this.zzb = zzgnl;
        return this;
    }

    public final zzfyz zzb(zzgnl zzgnl) {
        this.zzc = zzgnl;
        return this;
    }

    public final zzfyz zzc(Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzfyz zzd(zzfzk zzfzk) {
        this.zza = zzfzk;
        return this;
    }

    public final zzfzb zze() throws GeneralSecurityException {
        zzgnk zzb2;
        zzfzk zzfzk = this.zza;
        if (zzfzk != null) {
            zzgnl zzgnl = this.zzb;
            if (zzgnl == null || this.zzc == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            } else if (zzfzk.zza() != zzgnl.zza()) {
                throw new GeneralSecurityException("AES key size mismatch");
            } else if (zzfzk.zzb() != this.zzc.zza()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            } else if (this.zza.zzg() && this.zzd == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zzg() || this.zzd == null) {
                if (this.zza.zzf() == zzfzi.zzc) {
                    zzb2 = zzgnk.zzb(new byte[0]);
                } else if (this.zza.zzf() == zzfzi.zzb) {
                    zzb2 = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzd.intValue()).array());
                } else if (this.zza.zzf() == zzfzi.zza) {
                    zzb2 = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzd.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(this.zza.zzf())));
                }
                return new zzfzb(this.zza, this.zzb, this.zzc, zzb2, this.zzd, (zzfza) null);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        } else {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
    }
}
