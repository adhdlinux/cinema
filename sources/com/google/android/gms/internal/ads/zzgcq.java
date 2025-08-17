package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final /* synthetic */ class zzgcq implements zzgem {
    public static final /* synthetic */ zzgcq zza = new zzgcq();

    private /* synthetic */ zzgcq() {
    }

    public final zzgfd zza(zzfyf zzfyf) {
        zzglq zzglq;
        int i2 = zzgcu.zza;
        zzgko zza2 = zzgkp.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza2.zzc(zzglz.zzc().zzau());
        zzgco zza3 = ((zzgcp) zzfyf).zza();
        if (zzgco.zza.equals(zza3)) {
            zzglq = zzglq.TINK;
        } else if (zzgco.zzb.equals(zza3)) {
            zzglq = zzglq.CRUNCHY;
        } else if (zzgco.zzc.equals(zza3)) {
            zzglq = zzglq.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(zza3.toString()));
        }
        zza2.zza(zzglq);
        return zzgfb.zza((zzgkp) zza2.zzal());
    }
}
