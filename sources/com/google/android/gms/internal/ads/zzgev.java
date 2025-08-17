package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

public final class zzgev {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    private zzgev() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzgev zza(zzges zzges) throws GeneralSecurityException {
        zzgex zzgex = new zzgex(zzges.zzc(), zzges.zzd(), (zzgew) null);
        if (this.zza.containsKey(zzgex)) {
            zzges zzges2 = (zzges) this.zza.get(zzgex);
            if (!zzges2.equals(zzges) || !zzges.equals(zzges2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzgex.toString()));
            }
        } else {
            this.zza.put(zzgex, zzges);
        }
        return this;
    }

    public final zzgev zzb(zzfyn zzfyn) throws GeneralSecurityException {
        if (zzfyn != null) {
            Map map = this.zzb;
            Class zzb2 = zzfyn.zzb();
            if (map.containsKey(zzb2)) {
                zzfyn zzfyn2 = (zzfyn) this.zzb.get(zzb2);
                if (!zzfyn2.equals(zzfyn) || !zzfyn.equals(zzfyn2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(zzb2.toString()));
                }
            } else {
                this.zzb.put(zzb2, zzfyn);
            }
            return this;
        }
        throw new NullPointerException("wrapper must be non-null");
    }

    /* synthetic */ zzgev(zzgeu zzgeu) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    /* synthetic */ zzgev(zzgez zzgez, zzgeu zzgeu) {
        this.zza = new HashMap(zzgez.zza);
        this.zzb = new HashMap(zzgez.zzb);
    }
}
