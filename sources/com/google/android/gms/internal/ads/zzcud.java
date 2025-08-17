package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzcud implements zzcvg, zzdcd, zzczy, zzcvw, zzaua {
    /* access modifiers changed from: private */
    public final zzcvy zza;
    private final zzezn zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final zzfwv zze = zzfwv.zzf();
    private ScheduledFuture zzf;
    private final AtomicBoolean zzg = new AtomicBoolean();
    private final String zzh;

    zzcud(zzcvy zzcvy, zzezn zzezn, ScheduledExecutorService scheduledExecutorService, Executor executor, String str) {
        this.zza = zzcvy;
        this.zzb = zzezn;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
        this.zzh = str;
    }

    private final boolean zzh() {
        return this.zzh.equals("com.google.ads.mediation.admob.AdMobAdapter");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        synchronized (this) {
            if (!this.zze.isDone()) {
                this.zze.zzd(Boolean.TRUE);
            }
        }
    }

    public final void zzbr() {
    }

    public final void zzc(zzatz zzatz) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjP)).booleanValue() && zzh() && zzatz.zzj && this.zzg.compareAndSet(false, true)) {
            zze.zza("Full screen 1px impression occurred");
            this.zza.zza();
        }
    }

    public final void zzd() {
    }

    public final synchronized void zze() {
        if (!this.zze.isDone()) {
            ScheduledFuture scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzd(Boolean.TRUE);
        }
    }

    public final void zzf() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbs)).booleanValue()) {
            zzezn zzezn = this.zzb;
            if (zzezn.zzZ != 2) {
                return;
            }
            if (zzezn.zzr == 0) {
                this.zza.zza();
                return;
            }
            zzfwc.zzq(this.zze, new zzcuc(this), this.zzd);
            this.zzf = this.zzc.schedule(new zzcub(this), (long) this.zzb.zzr, TimeUnit.MILLISECONDS);
        }
    }

    public final void zzg() {
    }

    public final void zzj() {
    }

    public final synchronized void zzk(com.google.android.gms.ads.internal.client.zze zze2) {
        if (!this.zze.isDone()) {
            ScheduledFuture scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zze(new Exception());
        }
    }

    public final void zzm() {
    }

    public final void zzo() {
        int i2 = this.zzb.zzZ;
        if (i2 == 0 || i2 == 1) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjP)).booleanValue() || !zzh()) {
                this.zza.zza();
            }
        }
    }

    public final void zzp(zzbuu zzbuu, String str, String str2) {
    }

    public final void zzq() {
    }
}
