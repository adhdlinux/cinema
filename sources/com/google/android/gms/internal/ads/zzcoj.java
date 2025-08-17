package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzcoj implements zzaut {
    private final ScheduledExecutorService zza;
    private final Clock zzb;
    private ScheduledFuture zzc;
    private long zzd = -1;
    private long zze = -1;
    private Runnable zzf = null;
    private boolean zzg = false;

    public zzcoj(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zza = scheduledExecutorService;
        this.zzb = clock;
        zzt.zzb().zzc(this);
    }

    public final void zza(boolean z2) {
        if (z2) {
            zzc();
        } else {
            zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzb() {
        if (!this.zzg) {
            ScheduledFuture scheduledFuture = this.zzc;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.zze = -1;
            } else {
                this.zzc.cancel(true);
                this.zze = this.zzd - this.zzb.elapsedRealtime();
            }
            this.zzg = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzc() {
        ScheduledFuture scheduledFuture;
        if (this.zzg) {
            if (this.zze > 0 && (scheduledFuture = this.zzc) != null && scheduledFuture.isCancelled()) {
                this.zzc = this.zza.schedule(this.zzf, this.zze, TimeUnit.MILLISECONDS);
            }
            this.zzg = false;
        }
    }

    public final synchronized void zzd(int i2, Runnable runnable) {
        this.zzf = runnable;
        long j2 = (long) i2;
        this.zzd = this.zzb.elapsedRealtime() + j2;
        this.zzc = this.zza.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }
}
