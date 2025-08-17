package com.google.android.gms.internal.ads;

import android.app.Activity;
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
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzfl;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzeju extends zzbt {
    private final zzq zza;
    private final Context zzb;
    private final zzexq zzc;
    private final String zzd;
    private final zzbzx zze;
    private final zzejm zzf;
    private final zzeyq zzg;
    private final zzaqs zzh;
    private final zzdqa zzi;
    /* access modifiers changed from: private */
    public zzddn zzj;
    private boolean zzk = ((Boolean) zzba.zzc().zzb(zzbbm.zzaD)).booleanValue();

    public zzeju(Context context, zzq zzq, String str, zzexq zzexq, zzejm zzejm, zzeyq zzeyq, zzbzx zzbzx, zzaqs zzaqs, zzdqa zzdqa) {
        this.zza = zzq;
        this.zzd = str;
        this.zzb = context;
        this.zzc = zzexq;
        this.zzf = zzejm;
        this.zzg = zzeyq;
        this.zze = zzbzx;
        this.zzh = zzaqs;
        this.zzi = zzdqa;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zze() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzddn r0 = r1.zzj     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.zza()     // Catch:{ all -> 0x0011 }
            if (r0 != 0) goto L_0x000e
            monitor-exit(r1)
            r0 = 1
            return r0
        L_0x000e:
            monitor-exit(r1)
            r0 = 0
            return r0
        L_0x0011:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeju.zze():boolean");
    }

    public final void zzA() {
    }

    public final synchronized void zzB() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzddn zzddn = this.zzj;
        if (zzddn != null) {
            zzddn.zzm().zzc((Context) null);
        }
    }

    public final void zzC(zzbe zzbe) {
    }

    public final void zzD(zzbh zzbh) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzf.zze(zzbh);
    }

    public final void zzE(zzby zzby) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final void zzF(zzq zzq) {
    }

    public final void zzG(zzcb zzcb) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzf.zzi(zzcb);
    }

    public final void zzH(zzavw zzavw) {
    }

    public final void zzI(zzw zzw) {
    }

    public final void zzJ(zzci zzci) {
        this.zzf.zzt(zzci);
    }

    public final void zzK(zzdu zzdu) {
    }

    public final synchronized void zzL(boolean z2) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzk = z2;
    }

    public final void zzM(zzbsc zzbsc) {
    }

    public final void zzN(boolean z2) {
    }

    public final synchronized void zzO(zzbck zzbck) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzc.zzi(zzbck);
    }

    public final void zzP(zzdg zzdg) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdg.zzf()) {
                this.zzi.zze();
            }
        } catch (RemoteException e2) {
            zzbzr.zzf("Error in making CSI ping for reporting paid event callback", e2);
        }
        this.zzf.zzg(zzdg);
    }

    public final void zzQ(zzbsf zzbsf, String str) {
    }

    public final void zzR(String str) {
    }

    public final void zzS(zzbva zzbva) {
        this.zzg.zzf(zzbva);
    }

    public final void zzT(String str) {
    }

    public final void zzU(zzfl zzfl) {
    }

    public final synchronized void zzW(IObjectWrapper iObjectWrapper) {
        if (this.zzj == null) {
            zzbzr.zzj("Interstitial can not be shown before loaded.");
            this.zzf.zzk(zzfbi.zzd(9, (String) null, (zze) null));
            return;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcr)).booleanValue()) {
            this.zzh.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzj.zzc(this.zzk, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzX() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.zzj == null) {
            zzbzr.zzj("Interstitial can not be shown before loaded.");
            this.zzf.zzk(zzfbi.zzd(9, (String) null, (zze) null));
            return;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcr)).booleanValue()) {
            this.zzh.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzj.zzc(this.zzk, (Activity) null);
    }

    public final synchronized boolean zzY() {
        return this.zzc.zza();
    }

    public final synchronized boolean zzZ() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zze();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0064, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0065 A[SYNTHETIC, Splitter:B:21:0x0065] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzaa(com.google.android.gms.ads.internal.client.zzl r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.gms.internal.ads.zzbcr r0 = com.google.android.gms.internal.ads.zzbdd.zzi     // Catch:{ all -> 0x008c }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x008c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x008c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x008c }
            r1 = 0
            if (r0 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzjJ     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzbbk r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008c }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ all -> 0x008c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x008c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x008c }
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            com.google.android.gms.internal.ads.zzbzx r2 = r5.zze     // Catch:{ all -> 0x008c }
            int r2 = r2.zzc     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zzjK     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzbbk r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008c }
            java.lang.Object r3 = r4.zzb(r3)     // Catch:{ all -> 0x008c }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x008c }
            int r3 = r3.intValue()     // Catch:{ all -> 0x008c }
            if (r2 < r3) goto L_0x003d
            if (r0 != 0) goto L_0x0042
        L_0x003d:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x008c }
        L_0x0042:
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x008c }
            android.content.Context r0 = r5.zzb     // Catch:{ all -> 0x008c }
            boolean r0 = com.google.android.gms.ads.internal.util.zzs.zzD(r0)     // Catch:{ all -> 0x008c }
            r2 = 0
            if (r0 == 0) goto L_0x0065
            com.google.android.gms.ads.internal.client.zzc r0 = r6.zzs     // Catch:{ all -> 0x008c }
            if (r0 != 0) goto L_0x0065
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.internal.ads.zzbzr.zzg(r6)     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzejm r6 = r5.zzf     // Catch:{ all -> 0x008c }
            if (r6 == 0) goto L_0x0063
            r0 = 4
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfbi.zzd(r0, r2, r2)     // Catch:{ all -> 0x008c }
            r6.zza(r0)     // Catch:{ all -> 0x008c }
        L_0x0063:
            monitor-exit(r5)
            return r1
        L_0x0065:
            boolean r0 = r5.zze()     // Catch:{ all -> 0x008c }
            if (r0 == 0) goto L_0x006d
            monitor-exit(r5)
            return r1
        L_0x006d:
            android.content.Context r0 = r5.zzb     // Catch:{ all -> 0x008c }
            boolean r1 = r6.zzf     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzfbc.zza(r0, r1)     // Catch:{ all -> 0x008c }
            r5.zzj = r2     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzexq r0 = r5.zzc     // Catch:{ all -> 0x008c }
            java.lang.String r1 = r5.zzd     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzexj r2 = new com.google.android.gms.internal.ads.zzexj     // Catch:{ all -> 0x008c }
            com.google.android.gms.ads.internal.client.zzq r3 = r5.zza     // Catch:{ all -> 0x008c }
            r2.<init>(r3)     // Catch:{ all -> 0x008c }
            com.google.android.gms.internal.ads.zzejt r3 = new com.google.android.gms.internal.ads.zzejt     // Catch:{ all -> 0x008c }
            r3.<init>(r5)     // Catch:{ all -> 0x008c }
            boolean r6 = r0.zzb(r6, r1, r2, r3)     // Catch:{ all -> 0x008c }
            monitor-exit(r5)
            return r6
        L_0x008c:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeju.zzaa(com.google.android.gms.ads.internal.client.zzl):boolean");
    }

    public final void zzab(zzcf zzcf) {
    }

    public final Bundle zzd() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final zzq zzg() {
        return null;
    }

    public final zzbh zzi() {
        return this.zzf.zzc();
    }

    public final zzcb zzj() {
        return this.zzf.zzd();
    }

    public final synchronized zzdn zzk() {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzgA)).booleanValue()) {
            return null;
        }
        zzddn zzddn = this.zzj;
        if (zzddn == null) {
            return null;
        }
        return zzddn.zzl();
    }

    public final zzdq zzl() {
        return null;
    }

    public final IObjectWrapper zzn() {
        return null;
    }

    public final synchronized String zzr() {
        return this.zzd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzs() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzddn r0 = r2.zzj     // Catch:{ all -> 0x0018 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeju.zzs():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzt() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzddn r0 = r2.zzj     // Catch:{ all -> 0x0018 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeju.zzt():java.lang.String");
    }

    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzddn zzddn = this.zzj;
        if (zzddn != null) {
            zzddn.zzm().zza((Context) null);
        }
    }

    public final void zzy(zzl zzl, zzbk zzbk) {
        this.zzf.zzf(zzbk);
        zzaa(zzl);
    }

    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzddn zzddn = this.zzj;
        if (zzddn != null) {
            zzddn.zzm().zzb((Context) null);
        }
    }
}
