package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class zzeo {
    private final zzdz zza;
    private final zzei zzb;
    private final zzem zzc;
    private final CopyOnWriteArraySet zzd;
    private final ArrayDeque zze;
    private final ArrayDeque zzf;
    private final Object zzg;
    private boolean zzh;
    private boolean zzi;

    public zzeo(Looper looper, zzdz zzdz, zzem zzem) {
        this(new CopyOnWriteArraySet(), looper, zzdz, zzem, true);
    }

    public static /* synthetic */ boolean zzg(zzeo zzeo, Message message) {
        Iterator it2 = zzeo.zzd.iterator();
        while (it2.hasNext()) {
            ((zzen) it2.next()).zzb(zzeo.zzc);
            if (zzeo.zzb.zzg(0)) {
                return true;
            }
        }
        return true;
    }

    private final void zzh() {
        if (this.zzi) {
            zzdy.zzf(Thread.currentThread() == this.zzb.zza().getThread());
        }
    }

    public final zzeo zza(Looper looper, zzem zzem) {
        return new zzeo(this.zzd, looper, this.zza, zzem, this.zzi);
    }

    public final void zzb(Object obj) {
        synchronized (this.zzg) {
            if (!this.zzh) {
                this.zzd.add(new zzen(obj));
            }
        }
    }

    public final void zzc() {
        zzh();
        if (!this.zzf.isEmpty()) {
            if (!this.zzb.zzg(0)) {
                zzei zzei = this.zzb;
                zzei.zzk(zzei.zzb(0));
            }
            boolean z2 = !this.zze.isEmpty();
            this.zze.addAll(this.zzf);
            this.zzf.clear();
            if (!z2) {
                while (!this.zze.isEmpty()) {
                    ((Runnable) this.zze.peekFirst()).run();
                    this.zze.removeFirst();
                }
            }
        }
    }

    public final void zzd(int i2, zzel zzel) {
        zzh();
        this.zzf.add(new zzek(new CopyOnWriteArraySet(this.zzd), i2, zzel));
    }

    public final void zze() {
        zzh();
        synchronized (this.zzg) {
            this.zzh = true;
        }
        Iterator it2 = this.zzd.iterator();
        while (it2.hasNext()) {
            ((zzen) it2.next()).zzc(this.zzc);
        }
        this.zzd.clear();
    }

    public final void zzf(Object obj) {
        zzh();
        Iterator it2 = this.zzd.iterator();
        while (it2.hasNext()) {
            zzen zzen = (zzen) it2.next();
            if (zzen.zza.equals(obj)) {
                zzen.zzc(this.zzc);
                this.zzd.remove(zzen);
            }
        }
    }

    private zzeo(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, zzdz zzdz, zzem zzem, boolean z2) {
        this.zza = zzdz;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzem;
        this.zzg = new Object();
        this.zze = new ArrayDeque();
        this.zzf = new ArrayDeque();
        this.zzb = zzdz.zzb(looper, new zzej(this));
        this.zzi = z2;
    }
}
