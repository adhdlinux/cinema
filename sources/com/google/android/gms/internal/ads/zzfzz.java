package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzfzz extends zzgdu {
    zzfzz() {
        super(zzgiw.class, new zzfzx(zzfxh.class));
    }

    static /* bridge */ /* synthetic */ zzgds zzg(int i2, int i3, int i4) {
        zzgiy zzc = zzgiz.zzc();
        zzc.zza(i2);
        zzgjb zzc2 = zzgjc.zzc();
        zzc2.zza(16);
        zzc.zzb((zzgjc) zzc2.zzal());
        return new zzgds((zzgiz) zzc.zzal(), i4);
    }

    public final zzgdt zza() {
        return new zzfzy(this, zzgiz.class);
    }

    public final zzgkj zzb() {
        return zzgkj.SYMMETRIC;
    }

    public final /* synthetic */ zzgqw zzc(zzgoe zzgoe) throws zzgpy {
        return zzgiw.zze(zzgoe, zzgoy.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzgqw zzgqw) throws GeneralSecurityException {
        zzgiw zzgiw = (zzgiw) zzgqw;
        zzgni.zzb(zzgiw.zza(), 0);
        zzgni.zza(zzgiw.zzg().zzd());
        if (zzgiw.zzf().zza() != 12 && zzgiw.zzf().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
