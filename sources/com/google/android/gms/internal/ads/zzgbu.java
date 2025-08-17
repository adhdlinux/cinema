package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzgbu extends zzgdt {
    final /* synthetic */ zzgbv zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgbu(zzgbv zzgbv, Class cls) {
        super(cls);
        this.zza = zzgbv;
    }

    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqw) throws GeneralSecurityException {
        zzgju zzgju = (zzgju) zzgqw;
        zzgjq zzc = zzgjr.zzc();
        zzc.zzb(0);
        byte[] zza2 = zzgng.zza(32);
        zzc.zza(zzgoe.zzv(zza2, 0, zza2.length));
        return (zzgjr) zzc.zzal();
    }

    public final /* synthetic */ zzgqw zzb(zzgoe zzgoe) throws zzgpy {
        return zzgju.zzd(zzgoe, zzgoy.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("CHACHA20_POLY1305", new zzgds(zzgju.zzc(), 1));
        hashMap.put("CHACHA20_POLY1305_RAW", new zzgds(zzgju.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgqw zzgqw) throws GeneralSecurityException {
        zzgju zzgju = (zzgju) zzgqw;
    }
}
