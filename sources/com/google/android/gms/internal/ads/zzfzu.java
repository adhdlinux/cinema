package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzfzu {
    private zzgae zza = null;
    private zzgnl zzb = null;
    private Integer zzc = null;

    private zzfzu() {
    }

    /* synthetic */ zzfzu(zzfzt zzfzt) {
    }

    public final zzfzu zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzfzu zzb(zzgnl zzgnl) {
        this.zzb = zzgnl;
        return this;
    }

    public final zzfzu zzc(zzgae zzgae) {
        this.zza = zzgae;
        return this;
    }

    public final zzfzw zzd() throws GeneralSecurityException {
        zzgnl zzgnl;
        zzgnk zzb2;
        zzgae zzgae = this.zza;
        if (zzgae == null || (zzgnl = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzgae.zzb() != zzgnl.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzgae.zzd() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzd() || this.zzc == null) {
            if (this.zza.zzc() == zzgac.zzc) {
                zzb2 = zzgnk.zzb(new byte[0]);
            } else if (this.zza.zzc() == zzgac.zzb) {
                zzb2 = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzc() == zzgac.zza) {
                zzb2 = zzgnk.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(this.zza.zzc())));
            }
            return new zzfzw(this.zza, this.zzb, zzb2, this.zzc, (zzfzv) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
