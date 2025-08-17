package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzesu implements zzeqy {
    private final Context zza;
    private final zzbza zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final String zze;
    private final zzbyr zzf;

    public zzesu(zzbyr zzbyr, int i2, Context context, zzbza zzbza, ScheduledExecutorService scheduledExecutorService, Executor executor, String str) {
        this.zzf = zzbyr;
        this.zza = context;
        this.zzb = zzbza;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
        this.zze = str;
    }

    public final int zza() {
        return 44;
    }

    public final zzfwm zzb() {
        return zzfwc.zze((zzfvt) zzfwc.zzn(zzfwc.zzl(zzfvt.zzv(zzfwc.zzk(new zzesr(this), this.zzd)), zzess.zza, this.zzd), ((Long) zzba.zzc().zzb(zzbbm.zzaS)).longValue(), TimeUnit.MILLISECONDS, this.zzc), Exception.class, new zzest(this), zzfwt.zzb());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzesv zzc(Exception exc) {
        this.zzb.zzu(exc, "AttestationTokenSignal");
        return null;
    }
}
