package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfzy extends zzgdt {
    final /* synthetic */ zzfzz zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfzy(zzfzz zzfzz, Class cls) {
        super(cls);
        this.zza = zzfzz;
    }

    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqw) throws GeneralSecurityException {
        zzgiz zzgiz = (zzgiz) zzgqw;
        zzgiv zzc = zzgiw.zzc();
        byte[] zza2 = zzgng.zza(zzgiz.zza());
        zzc.zza(zzgoe.zzv(zza2, 0, zza2.length));
        zzc.zzb(zzgiz.zzf());
        zzc.zzc(0);
        return (zzgiw) zzc.zzal();
    }

    public final /* synthetic */ zzgqw zzb(zzgoe zzgoe) throws zzgpy {
        return zzgiz.zze(zzgoe, zzgoy.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", zzfzz.zzg(16, 16, 1));
        hashMap.put("AES128_EAX_RAW", zzfzz.zzg(16, 16, 3));
        hashMap.put("AES256_EAX", zzfzz.zzg(32, 16, 1));
        hashMap.put("AES256_EAX_RAW", zzfzz.zzg(32, 16, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgqw zzgqw) throws GeneralSecurityException {
        zzgiz zzgiz = (zzgiz) zzgqw;
        zzgni.zza(zzgiz.zza());
        if (zzgiz.zzf().zza() != 12 && zzgiz.zzf().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
