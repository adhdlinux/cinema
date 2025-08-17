package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzddr {
    private final zzdew zza;
    private final zzcez zzb;

    public zzddr(zzdew zzdew, zzcez zzcez) {
        this.zza = zzdew;
        this.zzb = zzcez;
    }

    public static final zzdcm zzh(zzffk zzffk) {
        return new zzdcm(zzffk, zzcae.zzf);
    }

    public static final zzdcm zzi(zzdfb zzdfb) {
        return new zzdcm(zzdfb, zzcae.zzf);
    }

    public final View zza() {
        zzcez zzcez = this.zzb;
        if (zzcez == null) {
            return null;
        }
        return zzcez.zzG();
    }

    public final View zzb() {
        zzcez zzcez = this.zzb;
        if (zzcez != null) {
            return zzcez.zzG();
        }
        return null;
    }

    public final zzcez zzc() {
        return this.zzb;
    }

    public final zzdcm zzd(Executor executor) {
        return new zzdcm(new zzddp(this.zzb), executor);
    }

    public final zzdew zze() {
        return this.zza;
    }

    public Set zzf(zzcud zzcud) {
        return Collections.singleton(new zzdcm(zzcud, zzcae.zzf));
    }

    public Set zzg(zzcud zzcud) {
        return Collections.singleton(new zzdcm(zzcud, zzcae.zzf));
    }
}
