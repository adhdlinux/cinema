package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzgaq extends zzgdu {
    zzgaq() {
        super(zzgjf.class, new zzgao(zzfxh.class));
    }

    static /* bridge */ /* synthetic */ zzgds zzg(int i2, int i3) {
        zzgjh zzc = zzgji.zzc();
        zzc.zza(i2);
        return new zzgds((zzgji) zzc.zzal(), i3);
    }

    public final zzgdt zza() {
        return new zzgap(this, zzgji.class);
    }

    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    public final /* synthetic */ zzgqw zzc(zzgoe zzgoe) throws zzgpy {
        return zzgjf.zze(zzgoe, zzgoy.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqw) throws GeneralSecurityException {
        zzgjf zzgjf = (zzgjf) zzgqw;
        zzgni.zzb(zzgjf.zza(), 0);
        zzgni.zza(zzgjf.zzf().zzd());
    }

    public final int zzf() {
        return 2;
    }
}
