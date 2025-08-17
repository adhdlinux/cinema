package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzgap extends zzgdt {
    final /* synthetic */ zzgaq zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgap(zzgaq zzgaq, Class cls) {
        super(cls);
        this.zza = zzgaq;
    }

    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqw) throws GeneralSecurityException {
        zzgje zzc = zzgjf.zzc();
        byte[] zza2 = zzgng.zza(((zzgji) zzgqw).zza());
        zzc.zza(zzgoe.zzv(zza2, 0, zza2.length));
        zzc.zzb(0);
        return (zzgjf) zzc.zzal();
    }

    public final /* synthetic */ zzgqw zzb(zzgoe zzgoe) throws zzgpy {
        return zzgji.zze(zzgoe, zzgoy.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzgaq.zzg(16, 1));
        hashMap.put("AES128_GCM_RAW", zzgaq.zzg(16, 3));
        hashMap.put("AES256_GCM", zzgaq.zzg(32, 1));
        hashMap.put("AES256_GCM_RAW", zzgaq.zzg(32, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* synthetic */ void zzd(zzgqw zzgqw) throws GeneralSecurityException {
        zzgni.zza(((zzgji) zzgqw).zza());
    }
}
