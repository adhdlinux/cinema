package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzcvt extends zzdaq implements zzcvk {
    private final ScheduledExecutorService zzb;
    private ScheduledFuture zzc;
    private boolean zzd = false;

    public zzcvt(zzcvs zzcvs, Set set, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        super(set);
        this.zzb = scheduledExecutorService;
        zzm(zzcvs, executor);
    }

    public final void zza(zze zze) {
        zzp(new zzcvm(zze));
    }

    public final void zzb() {
        zzp(zzcvo.zza);
    }

    public final void zzc(zzdev zzdev) {
        if (!this.zzd) {
            ScheduledFuture scheduledFuture = this.zzc;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            zzp(new zzcvl(zzdev));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        synchronized (this) {
            zzbzr.zzg("Timeout waiting for show call succeed to be called.");
            zzc(new zzdev("Timeout for show call succeed."));
            this.zzd = true;
        }
    }

    public final synchronized void zze() {
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public final void zzf() {
        this.zzc = this.zzb.schedule(new zzcvn(this), (long) ((Integer) zzba.zzc().zzb(zzbbm.zzjp)).intValue(), TimeUnit.MILLISECONDS);
    }
}
