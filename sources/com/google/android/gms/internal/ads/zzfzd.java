package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzfzd extends zzgdt {
    final /* synthetic */ zzfze zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfzd(zzfze zzfze, Class cls) {
        super(cls);
        this.zza = zzfze;
    }

    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqw) throws GeneralSecurityException {
        zzgik zzgik = (zzgik) zzgqw;
        new zzfzs();
        zzgin zzf = zzfzr.zzf(zzgik.zze());
        zzgqw zza2 = new zzggq().zza().zza(zzgik.zzf());
        zzgig zzc = zzgih.zzc();
        zzc.zza(zzf);
        zzc.zzb((zzgjz) zza2);
        zzc.zzc(0);
        return (zzgih) zzc.zzal();
    }

    public final /* synthetic */ zzgqw zzb(zzgoe zzgoe) throws zzgpy {
        return zzgik.zzd(zzgoe, zzgoy.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzfze.zzg(16, 16, 32, 16, 5, 1));
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzfze.zzg(16, 16, 32, 16, 5, 3));
        hashMap.put("AES256_CTR_HMAC_SHA256", zzfze.zzg(32, 16, 32, 32, 5, 1));
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzfze.zzg(32, 16, 32, 32, 5, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgqw zzgqw) throws GeneralSecurityException {
        zzgik zzgik = (zzgik) zzgqw;
        ((zzfzr) new zzfzs().zza()).zzd(zzgik.zze());
        new zzggq().zza().zzd(zzgik.zzf());
        zzgni.zza(zzgik.zze().zza());
    }
}
