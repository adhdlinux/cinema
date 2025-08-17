package com.google.android.gms.internal.ads;

import android.content.Context;

@Deprecated
public final class zzln {
    private final zzir zza;

    @Deprecated
    public zzln(Context context, zzcei zzcei) {
        this.zza = new zzir(context, zzcei);
    }

    @Deprecated
    public final zzln zza(zzkk zzkk) {
        zzir zzir = this.zza;
        zzdy.zzf(!zzir.zzq);
        zzkk.getClass();
        zzir.zzf = new zzij(zzkk);
        return this;
    }

    @Deprecated
    public final zzln zzb(zzxg zzxg) {
        zzir zzir = this.zza;
        zzdy.zzf(!zzir.zzq);
        zzxg.getClass();
        zzir.zze = new zzik(zzxg);
        return this;
    }

    @Deprecated
    public final zzlo zzc() {
        zzir zzir = this.zza;
        zzdy.zzf(!zzir.zzq);
        zzir.zzq = true;
        return new zzlo(zzir);
    }
}
