package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class zzakw extends Thread {
    private static final boolean zza = zzalw.zzb;
    private final BlockingQueue zzb;
    /* access modifiers changed from: private */
    public final BlockingQueue zzc;
    private final zzaku zzd;
    private volatile boolean zze = false;
    private final zzalx zzf;
    private final zzalb zzg;

    public zzakw(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzaku zzaku, zzalb zzalb) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzaku;
        this.zzg = zzalb;
        this.zzf = new zzalx(this, blockingQueue2, zzalb);
    }

    private void zzc() throws InterruptedException {
        zzalk zzalk = (zzalk) this.zzb.take();
        zzalk.zzm("cache-queue-take");
        zzalk.zzt(1);
        try {
            zzalk.zzw();
            zzakt zza2 = this.zzd.zza(zzalk.zzj());
            if (zza2 == null) {
                zzalk.zzm("cache-miss");
                if (!this.zzf.zzc(zzalk)) {
                    this.zzc.put(zzalk);
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (zza2.zza(currentTimeMillis)) {
                zzalk.zzm("cache-hit-expired");
                zzalk.zze(zza2);
                if (!this.zzf.zzc(zzalk)) {
                    this.zzc.put(zzalk);
                }
                zzalk.zzt(2);
                return;
            }
            zzalk.zzm("cache-hit");
            zzalq zzh = zzalk.zzh(new zzalg(zza2.zza, zza2.zzg));
            zzalk.zzm("cache-hit-parsed");
            if (!zzh.zzc()) {
                zzalk.zzm("cache-parsing-failed");
                this.zzd.zzc(zzalk.zzj(), true);
                zzalk.zze((zzakt) null);
                if (!this.zzf.zzc(zzalk)) {
                    this.zzc.put(zzalk);
                }
                zzalk.zzt(2);
                return;
            }
            if (zza2.zzf < currentTimeMillis) {
                zzalk.zzm("cache-hit-refresh-needed");
                zzalk.zze(zza2);
                zzh.zzd = true;
                if (!this.zzf.zzc(zzalk)) {
                    this.zzg.zzb(zzalk, zzh, new zzakv(this, zzalk));
                } else {
                    this.zzg.zzb(zzalk, zzh, (Runnable) null);
                }
            } else {
                this.zzg.zzb(zzalk, zzh, (Runnable) null);
            }
            zzalk.zzt(2);
        } finally {
            zzalk.zzt(2);
        }
    }

    public final void run() {
        if (zza) {
            zzalw.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzalw.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
