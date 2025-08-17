package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Collections;
import java.util.Set;

public class zzcpi {
    private final zzcrb zza;
    private final View zzb;
    private final zzezo zzc;
    private final zzcez zzd;

    public zzcpi(View view, zzcez zzcez, zzcrb zzcrb, zzezo zzezo) {
        this.zzb = view;
        this.zzd = zzcez;
        this.zza = zzcrb;
        this.zzc = zzezo;
    }

    public static final zzdcm zzf(Context context, zzbzx zzbzx, zzezn zzezn, zzfai zzfai) {
        return new zzdcm(new zzcpg(context, zzbzx, zzezn, zzfai), zzcae.zzf);
    }

    public static final Set zzg(zzcqs zzcqs) {
        return Collections.singleton(new zzdcm(zzcqs, zzcae.zzf));
    }

    public static final zzdcm zzh(zzcqq zzcqq) {
        return new zzdcm(zzcqq, zzcae.zze);
    }

    public final View zza() {
        return this.zzb;
    }

    public final zzcez zzb() {
        return this.zzd;
    }

    public final zzcrb zzc() {
        return this.zza;
    }

    public zzcws zzd(Set set) {
        return new zzcws(set);
    }

    public final zzezo zze() {
        return this.zzc;
    }
}
