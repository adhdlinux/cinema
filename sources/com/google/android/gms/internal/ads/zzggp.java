package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzggp extends zzgdt {
    final /* synthetic */ zzggq zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzggp(zzggq zzggq, Class cls) {
        super(cls);
        this.zza = zzggq;
    }

    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqw) throws GeneralSecurityException {
        zzgkc zzgkc = (zzgkc) zzgqw;
        zzgjy zzc = zzgjz.zzc();
        zzc.zzc(0);
        zzc.zzb(zzgkc.zzh());
        byte[] zza2 = zzgng.zza(zzgkc.zza());
        zzc.zza(zzgoe.zzv(zza2, 0, zza2.length));
        return (zzgjz) zzc.zzal();
    }

    public final /* synthetic */ zzgqw zzb(zzgoe zzgoe) throws zzgpy {
        return zzgkc.zzg(zzgoe, zzgoy.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", zzggq.zzn(32, 16, 5, 1));
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzggq.zzn(32, 16, 5, 3));
        hashMap.put("HMAC_SHA256_256BITTAG", zzggq.zzn(32, 32, 5, 1));
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzggq.zzn(32, 32, 5, 3));
        hashMap.put("HMAC_SHA512_128BITTAG", zzggq.zzn(64, 16, 6, 1));
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzggq.zzn(64, 16, 6, 3));
        hashMap.put("HMAC_SHA512_256BITTAG", zzggq.zzn(64, 32, 6, 1));
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzggq.zzn(64, 32, 6, 3));
        hashMap.put("HMAC_SHA512_512BITTAG", zzggq.zzn(64, 64, 6, 1));
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzggq.zzn(64, 64, 6, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgqw zzgqw) throws GeneralSecurityException {
        zzgkc zzgkc = (zzgkc) zzgqw;
        if (zzgkc.zza() >= 16) {
            zzggq.zzo(zzgkc.zzh());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}
