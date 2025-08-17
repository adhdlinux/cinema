package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgeg {
    private static final zzgeg zza;
    private final AtomicReference zzb = new AtomicReference(new zzgfk(new zzgfe(), (zzgfj) null));

    static {
        try {
            zzgeg zzgeg = new zzgeg();
            Class<zzgdw> cls = zzgdw.class;
            zzgeg.zzf(new zzgdo(cls, zzgfa.class, zzgef.zza));
            zza = zzgeg;
        } catch (Exception e2) {
            throw new zzgfl((Throwable) e2);
        }
    }

    public static zzgeg zzc() {
        return zza;
    }

    public final zzfxn zza(zzgfa zzgfa, zzfyq zzfyq) throws GeneralSecurityException {
        if (!((zzgfk) this.zzb.get()).zzh(zzgfa)) {
            return new zzgdw(zzgfa, zzfyq);
        }
        return ((zzgfk) this.zzb.get()).zza(zzgfa, zzfyq);
    }

    public final zzfyf zzb(zzgfd zzgfd) throws GeneralSecurityException {
        return ((zzgfk) this.zzb.get()).zzb(zzgfd);
    }

    public final zzgfd zzd(zzfyf zzfyf, Class cls) throws GeneralSecurityException {
        return ((zzgfk) this.zzb.get()).zzc(zzfyf, cls);
    }

    public final synchronized void zze(zzgdn zzgdn) throws GeneralSecurityException {
        zzgfe zzgfe = new zzgfe((zzgfk) this.zzb.get());
        zzgfe.zza(zzgdn);
        this.zzb.set(new zzgfk(zzgfe, (zzgfj) null));
    }

    public final synchronized void zzf(zzgdr zzgdr) throws GeneralSecurityException {
        zzgfe zzgfe = new zzgfe((zzgfk) this.zzb.get());
        zzgfe.zzb(zzgdr);
        this.zzb.set(new zzgfk(zzgfe, (zzgfj) null));
    }

    public final synchronized void zzg(zzgek zzgek) throws GeneralSecurityException {
        zzgfe zzgfe = new zzgfe((zzgfk) this.zzb.get());
        zzgfe.zzc(zzgek);
        this.zzb.set(new zzgfk(zzgfe, (zzgfj) null));
    }

    public final synchronized void zzh(zzgeo zzgeo) throws GeneralSecurityException {
        zzgfe zzgfe = new zzgfe((zzgfk) this.zzb.get());
        zzgfe.zzd(zzgeo);
        this.zzb.set(new zzgfk(zzgfe, (zzgfj) null));
    }

    public final boolean zzi(zzgfd zzgfd) {
        return ((zzgfk) this.zzb.get()).zzi(zzgfd);
    }
}
