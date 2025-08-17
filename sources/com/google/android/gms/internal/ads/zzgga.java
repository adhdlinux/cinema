package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final /* synthetic */ class zzgga implements zzgem {
    public static final /* synthetic */ zzgga zza = new zzgga();

    private /* synthetic */ zzgga() {
    }

    public final zzgfd zza(zzfyf zzfyf) {
        zzglq zzglq;
        zzgfz zzgfz = (zzgfz) zzfyf;
        int i2 = zzgge.zza;
        zzgko zza2 = zzgkp.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzgia zzc = zzgib.zzc();
        zzgid zzc2 = zzgie.zzc();
        zzc2.zza(zzgfz.zza());
        zzc.zzb((zzgie) zzc2.zzal());
        zzc.zza(zzgfz.zzb());
        zza2.zzc(((zzgib) zzc.zzal()).zzau());
        zzgfx zzd = zzgfz.zzd();
        if (zzgfx.zza.equals(zzd)) {
            zzglq = zzglq.TINK;
        } else if (zzgfx.zzb.equals(zzd)) {
            zzglq = zzglq.CRUNCHY;
        } else if (zzgfx.zzd.equals(zzd)) {
            zzglq = zzglq.RAW;
        } else if (zzgfx.zzc.equals(zzd)) {
            zzglq = zzglq.LEGACY;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzd)));
        }
        zza2.zza(zzglq);
        return zzgfb.zza((zzgkp) zza2.zzal());
    }
}
