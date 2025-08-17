package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzfze extends zzgdu {
    zzfze() {
        super(zzgih.class, new zzfzc(zzfxh.class));
    }

    static /* bridge */ /* synthetic */ zzgds zzg(int i2, int i3, int i4, int i5, int i6, int i7) {
        zzgip zzc = zzgiq.zzc();
        zzgis zzc2 = zzgit.zzc();
        zzc2.zza(16);
        zzc.zzb((zzgit) zzc2.zzal());
        zzc.zza(i2);
        zzgkb zzd = zzgkc.zzd();
        zzgke zzc3 = zzgkf.zzc();
        zzc3.zzb(5);
        zzc3.zza(i5);
        zzd.zzb((zzgkf) zzc3.zzal());
        zzd.zza(32);
        zzgij zza = zzgik.zza();
        zza.zza((zzgiq) zzc.zzal());
        zza.zzb((zzgkc) zzd.zzal());
        return new zzgds((zzgik) zza.zzal(), i7);
    }

    public final zzgdt zza() {
        return new zzfzd(this, zzgik.class);
    }

    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    public final /* synthetic */ zzgqw zzc(zzgoe zzgoe) throws zzgpy {
        return zzgih.zze(zzgoe, zzgoy.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqw) throws GeneralSecurityException {
        zzgih zzgih = (zzgih) zzgqw;
        zzgni.zzb(zzgih.zza(), 0);
        new zzfzs();
        zzfzs.zzh(zzgih.zzf());
        new zzggq();
        zzggq.zzm(zzgih.zzg());
    }

    public final int zzf() {
        return 2;
    }
}
