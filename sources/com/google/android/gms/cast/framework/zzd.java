package com.google.android.gms.cast.framework;

import android.content.Context;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.internal.cast.zzbf;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzd implements Callable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ CastOptions zzb;
    public final /* synthetic */ OptionsProvider zzc;
    public final /* synthetic */ zzbf zzd;
    public final /* synthetic */ zzn zze;

    public /* synthetic */ zzd(Context context, CastOptions castOptions, OptionsProvider optionsProvider, zzbf zzbf, zzn zzn) {
        this.zza = context;
        this.zzb = castOptions;
        this.zzc = optionsProvider;
        this.zzd = zzbf;
        this.zze = zzn;
    }

    public final Object call() {
        return CastContext.zzb(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
