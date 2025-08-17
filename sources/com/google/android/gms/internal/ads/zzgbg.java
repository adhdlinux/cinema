package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzgbg extends zzgdt {
    final /* synthetic */ zzgbh zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgbg(zzgbh zzgbh, Class cls) {
        super(cls);
        this.zza = zzgbh;
    }

    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqw) throws GeneralSecurityException {
        zzgjk zzc = zzgjl.zzc();
        byte[] zza2 = zzgng.zza(((zzgjo) zzgqw).zza());
        zzc.zza(zzgoe.zzv(zza2, 0, zza2.length));
        zzc.zzb(0);
        return (zzgjl) zzc.zzal();
    }

    public final /* synthetic */ zzgqw zzb(zzgoe zzgoe) throws zzgpy {
        return zzgjo.zze(zzgoe, zzgoy.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM_SIV", zzgbh.zzh(16, 1));
        hashMap.put("AES128_GCM_SIV_RAW", zzgbh.zzh(16, 3));
        hashMap.put("AES256_GCM_SIV", zzgbh.zzh(32, 1));
        hashMap.put("AES256_GCM_SIV_RAW", zzgbh.zzh(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzgqw zzgqw) throws GeneralSecurityException {
        zzgni.zza(((zzgjo) zzgqw).zza());
    }
}
