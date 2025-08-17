package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzdu;
import com.google.android.gms.ads.internal.client.zzfl;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzevt extends zzbt implements zzo, zzavn {
    protected zzcov zza;
    private final zzcgu zzb;
    private final Context zzc;
    private AtomicBoolean zzd = new AtomicBoolean();
    private final String zze;
    private final zzevn zzf;
    /* access modifiers changed from: private */
    public final zzevl zzg;
    private final zzbzx zzh;
    /* access modifiers changed from: private */
    public final zzdqa zzi;
    private long zzj = -1;
    private zzcoj zzk;

    public zzevt(zzcgu zzcgu, Context context, String str, zzevn zzevn, zzevl zzevl, zzbzx zzbzx, zzdqa zzdqa) {
        this.zzb = zzcgu;
        this.zzc = context;
        this.zze = str;
        this.zzf = zzevn;
        this.zzg = zzevl;
        this.zzh = zzbzx;
        this.zzi = zzdqa;
        zzevl.zzn(this);
    }

    private final synchronized void zzq(int i2) {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzg.zzj();
            zzcoj zzcoj = this.zzk;
            if (zzcoj != null) {
                zzt.zzb().zze(zzcoj);
            }
            if (this.zza != null) {
                long j2 = -1;
                if (this.zzj != -1) {
                    j2 = zzt.zzB().elapsedRealtime() - this.zzj;
                }
                this.zza.zze(j2, i2);
            }
            zzx();
        }
    }

    public final synchronized void zzA() {
    }

    public final synchronized void zzB() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zzC(zzbe zzbe) {
    }

    public final void zzD(zzbh zzbh) {
    }

    public final void zzE(zzby zzby) {
    }

    public final synchronized void zzF(zzq zzq) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final void zzG(zzcb zzcb) {
    }

    public final void zzH(zzavw zzavw) {
        this.zzg.zzp(zzavw);
    }

    public final void zzI(zzw zzw) {
        this.zzf.zzl(zzw);
    }

    public final void zzJ(zzci zzci) {
    }

    public final void zzK(zzdu zzdu) {
    }

    public final void zzL(boolean z2) {
    }

    public final void zzM(zzbsc zzbsc) {
    }

    public final synchronized void zzN(boolean z2) {
    }

    public final synchronized void zzO(zzbck zzbck) {
    }

    public final void zzP(zzdg zzdg) {
    }

    public final void zzQ(zzbsf zzbsf, String str) {
    }

    public final void zzR(String str) {
    }

    public final void zzS(zzbva zzbva) {
    }

    public final void zzT(String str) {
    }

    public final synchronized void zzU(zzfl zzfl) {
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final synchronized void zzX() {
    }

    public final synchronized boolean zzY() {
        return this.zzf.zza();
    }

    public final boolean zzZ() {
        return false;
    }

    public final void zza() {
        zzq(3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c A[SYNTHETIC, Splitter:B:25:0x006c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzaa(com.google.android.gms.ads.internal.client.zzl r6) throws android.os.RemoteException {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.gms.internal.ads.zzbcr r0 = com.google.android.gms.internal.ads.zzbdd.zzd     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x0087 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0087 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0087 }
            r1 = 0
            if (r0 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzjJ     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ all -> 0x0087 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0087 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            com.google.android.gms.internal.ads.zzbzx r2 = r5.zzh     // Catch:{ all -> 0x0087 }
            int r2 = r2.zzc     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zzjK     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzbbk r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0087 }
            java.lang.Object r3 = r4.zzb(r3)     // Catch:{ all -> 0x0087 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x0087 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0087 }
            if (r2 < r3) goto L_0x003d
            if (r0 != 0) goto L_0x0042
        L_0x003d:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0087 }
        L_0x0042:
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0087 }
            android.content.Context r0 = r5.zzc     // Catch:{ all -> 0x0087 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzs.zzD(r0)     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x0064
            com.google.android.gms.ads.internal.client.zzc r0 = r6.zzs     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x0052
            goto L_0x0064
        L_0x0052:
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.internal.ads.zzbzr.zzg(r6)     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzevl r6 = r5.zzg     // Catch:{ all -> 0x0087 }
            r0 = 4
            r2 = 0
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfbi.zzd(r0, r2, r2)     // Catch:{ all -> 0x0087 }
            r6.zza(r0)     // Catch:{ all -> 0x0087 }
            monitor-exit(r5)
            return r1
        L_0x0064:
            boolean r0 = r5.zzY()     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x006c
            monitor-exit(r5)
            return r1
        L_0x006c:
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean     // Catch:{ all -> 0x0087 }
            r0.<init>()     // Catch:{ all -> 0x0087 }
            r5.zzd = r0     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzevr r0 = new com.google.android.gms.internal.ads.zzevr     // Catch:{ all -> 0x0087 }
            r0.<init>(r5)     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzevn r1 = r5.zzf     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = r5.zze     // Catch:{ all -> 0x0087 }
            com.google.android.gms.internal.ads.zzevs r3 = new com.google.android.gms.internal.ads.zzevs     // Catch:{ all -> 0x0087 }
            r3.<init>(r5)     // Catch:{ all -> 0x0087 }
            boolean r6 = r1.zzb(r6, r2, r0, r3)     // Catch:{ all -> 0x0087 }
            monitor-exit(r5)
            return r6
        L_0x0087:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzevt.zzaa(com.google.android.gms.ads.internal.client.zzl):boolean");
    }

    public final synchronized void zzab(zzcf zzcf) {
    }

    public final synchronized void zzb() {
        if (this.zza != null) {
            this.zzj = zzt.zzB().elapsedRealtime();
            int zza2 = this.zza.zza();
            if (zza2 > 0) {
                zzcoj zzcoj = new zzcoj(this.zzb.zzB(), zzt.zzB());
                this.zzk = zzcoj;
                zzcoj.zzd(zza2, new zzevq(this));
            }
        }
    }

    public final void zzbF() {
    }

    public final void zzbo() {
    }

    public final void zzby() {
    }

    public final Bundle zzd() {
        return new Bundle();
    }

    public final synchronized void zze() {
        zzcov zzcov = this.zza;
        if (zzcov != null) {
            zzcov.zze(zzt.zzB().elapsedRealtime() - this.zzj, 1);
        }
    }

    public final void zzf(int i2) {
        if (i2 != 0) {
            int i3 = i2 - 1;
            if (i3 == 0) {
                zzq(2);
            } else if (i3 == 1) {
                zzq(4);
            } else if (i3 != 2) {
                zzq(6);
            } else {
                zzq(3);
            }
        } else {
            throw null;
        }
    }

    public final synchronized zzq zzg() {
        return null;
    }

    public final zzbh zzi() {
        return null;
    }

    public final zzcb zzj() {
        return null;
    }

    public final synchronized zzdn zzk() {
        return null;
    }

    public final synchronized zzdq zzl() {
        return null;
    }

    public final IObjectWrapper zzn() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo() {
        zzq(5);
    }

    public final void zzp() {
        this.zzb.zzA().execute(new zzevp(this));
    }

    public final synchronized String zzr() {
        return this.zze;
    }

    public final synchronized String zzs() {
        return null;
    }

    public final synchronized String zzt() {
        return null;
    }

    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcov zzcov = this.zza;
        if (zzcov != null) {
            zzcov.zzb();
        }
    }

    public final void zzy(zzl zzl, zzbk zzbk) {
    }

    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }
}
