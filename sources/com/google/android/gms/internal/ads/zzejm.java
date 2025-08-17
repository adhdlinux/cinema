package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class zzejm implements AppEventListener, zzcyb, zzcwu, zzcvj, zzcwa, zza, zzcvg, zzcxr, zzcvw, zzdcu {
    final BlockingQueue zza = new ArrayBlockingQueue(((Integer) zzba.zzc().zzb(zzbbm.zzir)).intValue());
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicBoolean zzg = new AtomicBoolean(true);
    private final AtomicBoolean zzh = new AtomicBoolean(false);
    private final AtomicBoolean zzi = new AtomicBoolean(false);
    private final zzfev zzj;

    public zzejm(zzfev zzfev) {
        this.zzj = zzfev;
    }

    private final void zzu() {
        if (this.zzh.get() && this.zzi.get()) {
            for (Pair zzejd : this.zza) {
                zzews.zza(this.zzc, new zzejd(zzejd));
            }
            this.zza.clear();
            this.zzg.set(false);
        }
    }

    public final void onAdClicked() {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjs)).booleanValue()) {
            zzews.zza(this.zzb, zzeje.zza);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onAppEvent(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.zzg     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0036
            java.util.concurrent.BlockingQueue r0 = r3.zza     // Catch:{ all -> 0x0042 }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x0042 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.offer(r1)     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x0034
            java.lang.String r0 = "The queue for app events is full, dropping the new event."
            com.google.android.gms.internal.ads.zzbzr.zze(r0)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzfev r0 = r3.zzj     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0034
            java.lang.String r1 = "dae_action"
            com.google.android.gms.internal.ads.zzfeu r1 = com.google.android.gms.internal.ads.zzfeu.zzb(r1)     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = "dae_name"
            r1.zza(r2, r4)     // Catch:{ all -> 0x0042 }
            java.lang.String r4 = "dae_data"
            r1.zza(r4, r5)     // Catch:{ all -> 0x0042 }
            r0.zzb(r1)     // Catch:{ all -> 0x0042 }
            monitor-exit(r3)
            return
        L_0x0034:
            monitor-exit(r3)
            return
        L_0x0036:
            java.util.concurrent.atomic.AtomicReference r0 = r3.zzc     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzeiz r1 = new com.google.android.gms.internal.ads.zzeiz     // Catch:{ all -> 0x0042 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzews.zza(r0, r1)     // Catch:{ all -> 0x0042 }
            monitor-exit(r3)
            return
        L_0x0042:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejm.onAppEvent(java.lang.String, java.lang.String):void");
    }

    public final void zza(zze zze2) {
        zzews.zza(this.zzb, new zzejg(zze2));
        zzews.zza(this.zzb, new zzejh(zze2));
        zzews.zza(this.zze, new zzeji(zze2));
        this.zzg.set(false);
        this.zza.clear();
    }

    public final void zzb(zzezz zzezz) {
        this.zzg.set(true);
        this.zzi.set(false);
    }

    public final void zzbA(zzbue zzbue) {
    }

    public final void zzbr() {
    }

    public final synchronized zzbh zzc() {
        return (zzbh) this.zzb.get();
    }

    public final synchronized zzcb zzd() {
        return (zzcb) this.zzc.get();
    }

    public final void zze(zzbh zzbh) {
        this.zzb.set(zzbh);
    }

    public final void zzf(zzbk zzbk) {
        this.zze.set(zzbk);
    }

    public final void zzg(zzdg zzdg) {
        this.zzd.set(zzdg);
    }

    public final void zzh(zzs zzs) {
        zzews.zza(this.zzd, new zzejb(zzs));
    }

    public final void zzi(zzcb zzcb) {
        this.zzc.set(zzcb);
        this.zzh.set(true);
        zzu();
    }

    public final void zzj() {
        zzews.zza(this.zzb, zzejl.zza);
        zzews.zza(this.zzf, zzeiu.zza);
    }

    public final void zzk(zze zze2) {
        zzews.zza(this.zzf, new zzeja(zze2));
    }

    public final void zzl() {
        zzews.zza(this.zzb, zzeit.zza);
    }

    public final void zzm() {
        zzews.zza(this.zzb, zzejc.zza);
    }

    public final synchronized void zzn() {
        zzews.zza(this.zzb, zzejj.zza);
        zzews.zza(this.zze, zzejk.zza);
        this.zzi.set(true);
        zzu();
    }

    public final void zzo() {
        zzews.zza(this.zzb, zzeiw.zza);
        zzews.zza(this.zzf, zzeix.zza);
        zzews.zza(this.zzf, zzeiy.zza);
    }

    public final void zzp(zzbuu zzbuu, String str, String str2) {
    }

    public final void zzq() {
    }

    public final void zzr() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjs)).booleanValue()) {
            zzews.zza(this.zzb, zzeje.zza);
        }
        zzews.zza(this.zzf, zzejf.zza);
    }

    public final void zzs() {
        zzews.zza(this.zzb, zzeiv.zza);
    }

    public final void zzt(zzci zzci) {
        this.zzf.set(zzci);
    }
}
