package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.TimeoutException;

public final class zzlf {
    private final zzle zza;
    private final zzld zzb;
    private final zzdz zzc;
    private final zzcw zzd;
    private int zze;
    private Object zzf;
    private final Looper zzg;
    private final int zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    public zzlf(zzld zzld, zzle zzle, zzcw zzcw, int i2, zzdz zzdz, Looper looper) {
        this.zzb = zzld;
        this.zza = zzle;
        this.zzd = zzcw;
        this.zzg = looper;
        this.zzc = zzdz;
        this.zzh = i2;
    }

    public final int zza() {
        return this.zze;
    }

    public final Looper zzb() {
        return this.zzg;
    }

    public final zzle zzc() {
        return this.zza;
    }

    public final zzlf zzd() {
        zzdy.zzf(!this.zzi);
        this.zzi = true;
        this.zzb.zzm(this);
        return this;
    }

    public final zzlf zze(Object obj) {
        zzdy.zzf(!this.zzi);
        this.zzf = obj;
        return this;
    }

    public final zzlf zzf(int i2) {
        zzdy.zzf(!this.zzi);
        this.zze = i2;
        return this;
    }

    public final Object zzg() {
        return this.zzf;
    }

    public final synchronized void zzh(boolean z2) {
        this.zzj = z2 | this.zzj;
        this.zzk = true;
        notifyAll();
    }

    public final synchronized boolean zzi(long j2) throws InterruptedException, TimeoutException {
        boolean z2;
        zzdy.zzf(this.zzi);
        if (this.zzg.getThread() != Thread.currentThread()) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdy.zzf(z2);
        long elapsedRealtime = SystemClock.elapsedRealtime() + j2;
        while (!this.zzk) {
            if (j2 > 0) {
                wait(j2);
                j2 = elapsedRealtime - SystemClock.elapsedRealtime();
            } else {
                throw new TimeoutException("Message delivery timed out.");
            }
        }
        return this.zzj;
    }

    public final synchronized boolean zzj() {
        return false;
    }
}
