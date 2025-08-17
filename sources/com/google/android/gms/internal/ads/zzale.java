package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class zzale extends Thread {
    private final BlockingQueue zza;
    private final zzald zzb;
    private final zzaku zzc;
    private volatile boolean zzd = false;
    private final zzalb zze;

    public zzale(BlockingQueue blockingQueue, zzald zzald, zzaku zzaku, zzalb zzalb) {
        this.zza = blockingQueue;
        this.zzb = zzald;
        this.zzc = zzaku;
        this.zze = zzalb;
    }

    private void zzb() throws InterruptedException {
        zzalk zzalk = (zzalk) this.zza.take();
        SystemClock.elapsedRealtime();
        zzalk.zzt(3);
        try {
            zzalk.zzm("network-queue-take");
            zzalk.zzw();
            TrafficStats.setThreadStatsTag(zzalk.zzc());
            zzalg zza2 = this.zzb.zza(zzalk);
            zzalk.zzm("network-http-complete");
            if (!zza2.zze || !zzalk.zzv()) {
                zzalq zzh = zzalk.zzh(zza2);
                zzalk.zzm("network-parse-complete");
                if (zzh.zzb != null) {
                    this.zzc.zzd(zzalk.zzj(), zzh.zzb);
                    zzalk.zzm("network-cache-written");
                }
                zzalk.zzq();
                this.zze.zzb(zzalk, zzh, (Runnable) null);
                zzalk.zzs(zzh);
                zzalk.zzt(4);
                return;
            }
            zzalk.zzp("not-modified");
            zzalk.zzr();
        } catch (zzalt e2) {
            SystemClock.elapsedRealtime();
            this.zze.zza(zzalk, e2);
            zzalk.zzr();
        } catch (Exception e3) {
            zzalw.zzc(e3, "Unhandled exception %s", e3.toString());
            zzalt zzalt = new zzalt((Throwable) e3);
            SystemClock.elapsedRealtime();
            this.zze.zza(zzalk, zzalt);
            zzalk.zzr();
        } finally {
            zzalk.zzt(4);
        }
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzalw.zzb("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
