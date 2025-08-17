package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
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
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzeis extends zzbt implements zzcxw {
    private final Context zza;
    private final zzevz zzb;
    private final String zzc;
    private final zzejm zzd;
    private zzq zze;
    private final zzfag zzf;
    private final zzbzx zzg;
    private final zzdqa zzh;
    /* access modifiers changed from: private */
    public zzcpb zzi;

    public zzeis(Context context, zzq zzq, String str, zzevz zzevz, zzejm zzejm, zzbzx zzbzx, zzdqa zzdqa) {
        this.zza = context;
        this.zzb = zzevz;
        this.zze = zzq;
        this.zzc = str;
        this.zzd = zzejm;
        this.zzf = zzevz.zzi();
        this.zzg = zzbzx;
        this.zzh = zzdqa;
        zzevz.zzp(this);
    }

    private final synchronized void zze(zzq zzq) {
        this.zzf.zzr(zzq);
        this.zzf.zzw(this.zze.zzn);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzf(com.google.android.gms.ads.internal.client.zzl r5) throws android.os.RemoteException {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzh()     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0046 }
        L_0x000c:
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0046 }
            android.content.Context r0 = r4.zza     // Catch:{ all -> 0x0046 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzs.zzD(r0)     // Catch:{ all -> 0x0046 }
            r1 = 0
            if (r0 == 0) goto L_0x0030
            com.google.android.gms.ads.internal.client.zzc r0 = r5.zzs     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0030
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.internal.ads.zzbzr.zzg(r5)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzejm r5 = r4.zzd     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x002d
            r0 = 4
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfbi.zzd(r0, r1, r1)     // Catch:{ all -> 0x0046 }
            r5.zza(r0)     // Catch:{ all -> 0x0046 }
        L_0x002d:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x0030:
            android.content.Context r0 = r4.zza     // Catch:{ all -> 0x0046 }
            boolean r2 = r5.zzf     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzfbc.zza(r0, r2)     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzevz r0 = r4.zzb     // Catch:{ all -> 0x0046 }
            java.lang.String r2 = r4.zzc     // Catch:{ all -> 0x0046 }
            com.google.android.gms.internal.ads.zzeir r3 = new com.google.android.gms.internal.ads.zzeir     // Catch:{ all -> 0x0046 }
            r3.<init>(r4)     // Catch:{ all -> 0x0046 }
            boolean r5 = r0.zzb(r5, r2, r1, r3)     // Catch:{ all -> 0x0046 }
            monitor-exit(r4)
            return r5
        L_0x0046:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeis.zzf(com.google.android.gms.ads.internal.client.zzl):boolean");
    }

    private final boolean zzh() {
        boolean z2;
        if (((Boolean) zzbdd.zzf.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjJ)).booleanValue()) {
                z2 = true;
                if (this.zzg.zzc >= ((Integer) zzba.zzc().zzb(zzbbm.zzjK)).intValue() || !z2) {
                    return true;
                }
                return false;
            }
        }
        z2 = false;
        if (this.zzg.zzc >= ((Integer) zzba.zzc().zzb(zzbbm.zzjK)).intValue()) {
        }
        return true;
    }

    public final synchronized void zzA() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        zzcpb zzcpb = this.zzi;
        if (zzcpb != null) {
            zzcpb.zzg();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r3.zzg.zzc < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzjL)).intValue()) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzB() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbcr r0 = com.google.android.gms.internal.ads.zzbdd.zzh     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x004c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzjF     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x004c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzbzx r0 = r3.zzg     // Catch:{ all -> 0x004c }
            int r0 = r0.zzc     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zzjL     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x004c }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x004c }
            int r1 = r1.intValue()     // Catch:{ all -> 0x004c }
            if (r0 >= r1) goto L_0x003c
        L_0x0037:
            java.lang.String r0 = "resume must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x004c }
        L_0x003c:
            com.google.android.gms.internal.ads.zzcpb r0 = r3.zzi     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzcwf r0 = r0.zzm()     // Catch:{ all -> 0x004c }
            r1 = 0
            r0.zzc(r1)     // Catch:{ all -> 0x004c }
            monitor-exit(r3)
            return
        L_0x004a:
            monitor-exit(r3)
            return
        L_0x004c:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeis.zzB():void");
    }

    public final void zzC(zzbe zzbe) {
        if (zzh()) {
            Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        }
        this.zzb.zzo(zzbe);
    }

    public final void zzD(zzbh zzbh) {
        if (zzh()) {
            Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        }
        this.zzd.zze(zzbh);
    }

    public final void zzE(zzby zzby) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final synchronized void zzF(zzq zzq) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzf.zzr(zzq);
        this.zze = zzq;
        zzcpb zzcpb = this.zzi;
        if (zzcpb != null) {
            zzcpb.zzh(this.zzb.zzd(), zzq);
        }
    }

    public final void zzG(zzcb zzcb) {
        if (zzh()) {
            Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        }
        this.zzd.zzi(zzcb);
    }

    public final void zzH(zzavw zzavw) {
    }

    public final void zzI(zzw zzw) {
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
        if (zzh()) {
            Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        }
        this.zzf.zzy(z2);
    }

    public final synchronized void zzO(zzbck zzbck) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzb.zzq(zzbck);
    }

    public final void zzP(zzdg zzdg) {
        if (zzh()) {
            Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        }
        try {
            if (!zzdg.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException e2) {
            zzbzr.zzf("Error in making CSI ping for reporting paid event callback", e2);
        }
        this.zzd.zzg(zzdg);
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
        if (zzh()) {
            Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        }
        this.zzf.zzF(zzfl);
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final void zzX() {
    }

    public final synchronized boolean zzY() {
        return this.zzb.zza();
    }

    public final boolean zzZ() {
        return false;
    }

    public final synchronized void zza() {
        if (this.zzb.zzr()) {
            zzq zzg2 = this.zzf.zzg();
            zzcpb zzcpb = this.zzi;
            if (!(zzcpb == null || zzcpb.zzf() == null || !this.zzf.zzO())) {
                zzg2 = zzfam.zza(this.zza, Collections.singletonList(this.zzi.zzf()));
            }
            zze(zzg2);
            try {
                zzf(this.zzf.zze());
            } catch (RemoteException unused) {
                zzbzr.zzj("Failed to refresh the banner ad.");
            }
        } else {
            this.zzb.zzn();
        }
    }

    public final synchronized boolean zzaa(zzl zzl) throws RemoteException {
        zze(this.zze);
        return zzf(zzl);
    }

    public final synchronized void zzab(zzcf zzcf) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzf.zzQ(zzcf);
    }

    public final Bundle zzd() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final synchronized zzq zzg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzcpb zzcpb = this.zzi;
        if (zzcpb != null) {
            return zzfam.zza(this.zza, Collections.singletonList(zzcpb.zze()));
        }
        return this.zzf.zzg();
    }

    public final zzbh zzi() {
        return this.zzd.zzc();
    }

    public final zzcb zzj() {
        return this.zzd.zzd();
    }

    public final synchronized zzdn zzk() {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzgA)).booleanValue()) {
            return null;
        }
        zzcpb zzcpb = this.zzi;
        if (zzcpb == null) {
            return null;
        }
        return zzcpb.zzl();
    }

    public final synchronized zzdq zzl() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        zzcpb zzcpb = this.zzi;
        if (zzcpb == null) {
            return null;
        }
        return zzcpb.zzd();
    }

    public final IObjectWrapper zzn() {
        if (zzh()) {
            Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        }
        return ObjectWrapper.wrap(this.zzb.zzd());
    }

    public final synchronized String zzr() {
        return this.zzc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzs() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzcpb r0 = r2.zzi     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcuz r1 = r0.zzl()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcuz r0 = r0.zzl()     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = r0.zzg()     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return r0
        L_0x0015:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeis.zzs():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzt() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzcpb r0 = r2.zzi     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcuz r1 = r0.zzl()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcuz r0 = r0.zzl()     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = r0.zzg()     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return r0
        L_0x0015:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeis.zzt():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r3.zzg.zzc < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzjL)).intValue()) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzx() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbcr r0 = com.google.android.gms.internal.ads.zzbdd.zze     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x0047 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzjG     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x0047 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzbzx r0 = r3.zzg     // Catch:{ all -> 0x0047 }
            int r0 = r0.zzc     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zzjL     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0047 }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x0047 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0047 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0047 }
            if (r0 >= r1) goto L_0x003c
        L_0x0037:
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0047 }
        L_0x003c:
            com.google.android.gms.internal.ads.zzcpb r0 = r3.zzi     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0045
            r0.zzb()     // Catch:{ all -> 0x0047 }
            monitor-exit(r3)
            return
        L_0x0045:
            monitor-exit(r3)
            return
        L_0x0047:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeis.zzx():void");
    }

    public final void zzy(zzl zzl, zzbk zzbk) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0035, code lost:
        if (r3.zzg.zzc < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(com.google.android.gms.internal.ads.zzbbm.zzjL)).intValue()) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzz() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbcr r0 = com.google.android.gms.internal.ads.zzbdd.zzg     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x004c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzjH     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x004c }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x004c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x004c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzbzx r0 = r3.zzg     // Catch:{ all -> 0x004c }
            int r0 = r0.zzc     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbbe r1 = com.google.android.gms.internal.ads.zzbbm.zzjL     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ all -> 0x004c }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x004c }
            int r1 = r1.intValue()     // Catch:{ all -> 0x004c }
            if (r0 >= r1) goto L_0x003c
        L_0x0037:
            java.lang.String r0 = "pause must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x004c }
        L_0x003c:
            com.google.android.gms.internal.ads.zzcpb r0 = r3.zzi     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzcwf r0 = r0.zzm()     // Catch:{ all -> 0x004c }
            r1 = 0
            r0.zzb(r1)     // Catch:{ all -> 0x004c }
            monitor-exit(r3)
            return
        L_0x004a:
            monitor-exit(r3)
            return
        L_0x004c:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeis.zzz():void");
    }
}
