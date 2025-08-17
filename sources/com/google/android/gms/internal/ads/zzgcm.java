package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class zzgcm extends zzgdt {
    final /* synthetic */ zzgcn zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgcm(zzgcn zzgcn, Class cls) {
        super(cls);
        this.zza = zzgcn;
    }

    public final /* bridge */ /* synthetic */ zzgqw zza(zzgqw zzgqw) throws GeneralSecurityException {
        zzglz zzglz = (zzglz) zzgqw;
        zzglv zzc = zzglw.zzc();
        zzc.zzb(0);
        byte[] zza2 = zzgng.zza(32);
        zzc.zza(zzgoe.zzv(zza2, 0, zza2.length));
        return (zzglw) zzc.zzal();
    }

    public final /* synthetic */ zzgqw zzb(zzgoe zzgoe) throws zzgpy {
        return zzglz.zzd(zzgoe, zzgoy.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", new zzgds(zzglz.zzc(), 1));
        hashMap.put("XCHACHA20_POLY1305_RAW", new zzgds(zzglz.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzgqw zzgqw) throws GeneralSecurityException {
        zzglz zzglz = (zzglz) zzgqw;
    }
}
