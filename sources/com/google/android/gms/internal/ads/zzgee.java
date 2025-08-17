package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgee {
    private static final zzgee zza = new zzgee();
    private final AtomicReference zzb = new AtomicReference(new zzgez(new zzgev((zzgeu) null), (zzgey) null));

    zzgee() {
    }

    public static zzgee zza() {
        return zza;
    }

    public final Class zzb(Class cls) throws GeneralSecurityException {
        return ((zzgez) this.zzb.get()).zza(cls);
    }

    public final Object zzc(zzfxn zzfxn, Class cls) throws GeneralSecurityException {
        return ((zzgez) this.zzb.get()).zzb(zzfxn, cls);
    }

    public final Object zzd(zzfym zzfym, Class cls) throws GeneralSecurityException {
        return ((zzgez) this.zzb.get()).zzc(zzfym, cls);
    }

    public final synchronized void zze(zzges zzges) throws GeneralSecurityException {
        zzgev zzgev = new zzgev((zzgez) this.zzb.get(), (zzgeu) null);
        zzgev.zza(zzges);
        this.zzb.set(new zzgez(zzgev, (zzgey) null));
    }

    public final synchronized void zzf(zzfyn zzfyn) throws GeneralSecurityException {
        zzgev zzgev = new zzgev((zzgez) this.zzb.get(), (zzgeu) null);
        zzgev.zzb(zzfyn);
        this.zzb.set(new zzgez(zzgev, (zzgey) null));
    }
}
