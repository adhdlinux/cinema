package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final /* synthetic */ class zzgby implements zzgem {
    public static final /* synthetic */ zzgby zza = new zzgby();

    private /* synthetic */ zzgby() {
    }

    public final zzgfd zza(zzfyf zzfyf) {
        zzglq zzglq;
        int i2 = zzgcc.zza;
        zzgko zza2 = zzgkp.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza2.zzc(zzgju.zzc().zzau());
        zzgbw zza3 = ((zzgbx) zzfyf).zza();
        if (zzgbw.zza.equals(zza3)) {
            zzglq = zzglq.TINK;
        } else if (zzgbw.zzb.equals(zza3)) {
            zzglq = zzglq.CRUNCHY;
        } else if (zzgbw.zzc.equals(zza3)) {
            zzglq = zzglq.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(zza3.toString()));
        }
        zza2.zza(zzglq);
        return zzgfb.zza((zzgkp) zza2.zzal());
    }
}
