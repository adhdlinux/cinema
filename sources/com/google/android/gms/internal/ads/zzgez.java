package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

public final class zzgez {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    /* synthetic */ zzgez(zzgev zzgev, zzgey zzgey) {
        this.zza = new HashMap(zzgev.zza);
        this.zzb = new HashMap(zzgev.zzb);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzfyn) this.zzb.get(cls)).zza();
        }
        String obj = cls.toString();
        throw new GeneralSecurityException("No input primitive class for " + obj + " available");
    }

    public final Object zzb(zzfxn zzfxn, Class cls) throws GeneralSecurityException {
        zzgex zzgex = new zzgex(zzfxn.getClass(), cls, (zzgew) null);
        if (this.zza.containsKey(zzgex)) {
            return ((zzges) this.zza.get(zzgex)).zza(zzfxn);
        }
        String obj = zzgex.toString();
        throw new GeneralSecurityException("No PrimitiveConstructor for " + obj + " available");
    }

    public final Object zzc(zzfym zzfym, Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            zzfyn zzfyn = (zzfyn) this.zzb.get(cls);
            if (zzfym.zzc().equals(zzfyn.zza()) && zzfyn.zza().equals(zzfym.zzc())) {
                return zzfyn.zzc(zzfym);
            }
            throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
    }
}
