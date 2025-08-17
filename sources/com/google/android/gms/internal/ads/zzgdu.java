package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class zzgdu {
    private final Class zza;
    private final Map zzb;
    private final Class zzc;

    @SafeVarargs
    protected zzgdu(Class cls, zzget... zzgetArr) {
        this.zza = cls;
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 <= 0) {
            zzget zzget = zzgetArr[i2];
            if (!hashMap.containsKey(zzget.zzb())) {
                hashMap.put(zzget.zzb(), zzget);
                i2++;
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive ".concat(String.valueOf(zzget.zzb().getCanonicalName())));
            }
        }
        this.zzc = zzgetArr[0].zzb();
        this.zzb = Collections.unmodifiableMap(hashMap);
    }

    public zzgdt zza() {
        throw null;
    }

    public abstract zzgkj zzb();

    public abstract zzgqw zzc(zzgoe zzgoe) throws zzgpy;

    public abstract String zzd();

    public abstract void zze(zzgqw zzgqw) throws GeneralSecurityException;

    public int zzf() {
        return 1;
    }

    public final Class zzi() {
        return this.zzc;
    }

    public final Class zzj() {
        return this.zza;
    }

    public final Object zzk(zzgqw zzgqw, Class cls) throws GeneralSecurityException {
        zzget zzget = (zzget) this.zzb.get(cls);
        if (zzget != null) {
            return zzget.zza(zzgqw);
        }
        String canonicalName = cls.getCanonicalName();
        throw new IllegalArgumentException("Requested primitive class " + canonicalName + " not supported.");
    }

    public final Set zzl() {
        return this.zzb.keySet();
    }
}
