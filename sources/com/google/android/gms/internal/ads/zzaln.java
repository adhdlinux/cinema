package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzaln {
    private final AtomicInteger zza = new AtomicInteger();
    private final Set zzb = new HashSet();
    private final PriorityBlockingQueue zzc = new PriorityBlockingQueue();
    private final PriorityBlockingQueue zzd = new PriorityBlockingQueue();
    private final zzaku zze;
    private final zzald zzf;
    private final zzale[] zzg;
    private zzakw zzh;
    private final List zzi = new ArrayList();
    private final List zzj = new ArrayList();
    private final zzalb zzk;

    public zzaln(zzaku zzaku, zzald zzald, int i2) {
        zzalb zzalb = new zzalb(new Handler(Looper.getMainLooper()));
        this.zze = zzaku;
        this.zzf = zzald;
        this.zzg = new zzale[4];
        this.zzk = zzalb;
    }

    public final zzalk zza(zzalk zzalk) {
        zzalk.zzf(this);
        synchronized (this.zzb) {
            this.zzb.add(zzalk);
        }
        zzalk.zzg(this.zza.incrementAndGet());
        zzalk.zzm("add-to-queue");
        zzc(zzalk, 0);
        this.zzc.add(zzalk);
        return zzalk;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzalk zzalk) {
        synchronized (this.zzb) {
            this.zzb.remove(zzalk);
        }
        synchronized (this.zzi) {
            for (zzalm zza2 : this.zzi) {
                zza2.zza();
            }
        }
        zzc(zzalk, 5);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzalk zzalk, int i2) {
        synchronized (this.zzj) {
            for (zzall zza2 : this.zzj) {
                zza2.zza();
            }
        }
    }

    public final void zzd() {
        zzakw zzakw = this.zzh;
        if (zzakw != null) {
            zzakw.zzb();
        }
        zzale[] zzaleArr = this.zzg;
        for (int i2 = 0; i2 < 4; i2++) {
            zzale zzale = zzaleArr[i2];
            if (zzale != null) {
                zzale.zza();
            }
        }
        zzakw zzakw2 = new zzakw(this.zzc, this.zzd, this.zze, this.zzk);
        this.zzh = zzakw2;
        zzakw2.start();
        for (int i3 = 0; i3 < 4; i3++) {
            zzale zzale2 = new zzale(this.zzd, this.zzf, this.zze, this.zzk);
            this.zzg[i3] = zzale2;
            zzale2.start();
        }
    }
}
