package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.regex.Pattern;

public final class zzezk extends zzbuw {
    private final zzeza zza;
    private final zzeyq zzb;
    /* access modifiers changed from: private */
    public final zzfaa zzc;
    /* access modifiers changed from: private */
    public zzdmm zzd;
    private boolean zze = false;

    public zzezk(zzeza zzeza, zzeyq zzeyq, zzfaa zzfaa) {
        this.zza = zzeza;
        this.zzb = zzeyq;
        this.zzc = zzfaa;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzy() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdmm r0 = r1.zzd     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.zze()     // Catch:{ all -> 0x0011 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzezk.zzy():boolean");
    }

    public final Bundle zzb() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzdmm zzdmm = this.zzd;
        if (zzdmm != null) {
            return zzdmm.zza();
        }
        return new Bundle();
    }

    public final synchronized zzdn zzc() throws RemoteException {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzgA)).booleanValue()) {
            return null;
        }
        zzdmm zzdmm = this.zzd;
        if (zzdmm == null) {
            return null;
        }
        return zzdmm.zzl();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzd() throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzdmm r0 = r2.zzd     // Catch:{ all -> 0x0018 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzezk.zzd():java.lang.String");
    }

    public final void zze() throws RemoteException {
        zzf((IObjectWrapper) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzf(com.google.android.gms.dynamic.IObjectWrapper r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzeyq r0 = r2.zzb     // Catch:{ all -> 0x0027 }
            r1 = 0
            r0.zzb(r1)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzdmm r0 = r2.zzd     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0025
            if (r3 != 0) goto L_0x0013
            goto L_0x001a
        L_0x0013:
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)     // Catch:{ all -> 0x0027 }
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x0027 }
        L_0x001a:
            com.google.android.gms.internal.ads.zzdmm r3 = r2.zzd     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads.zzcwf r3 = r3.zzm()     // Catch:{ all -> 0x0027 }
            r3.zza(r1)     // Catch:{ all -> 0x0027 }
            monitor-exit(r2)
            return
        L_0x0025:
            monitor-exit(r2)
            return
        L_0x0027:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzezk.zzf(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final synchronized void zzg(zzbvb zzbvb) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        String str = zzbvb.zzb;
        String str2 = (String) zzba.zzc().zzb(zzbbm.zzff);
        if (!(str2 == null || str == null)) {
            try {
                if (Pattern.matches(str2, str)) {
                    return;
                }
            } catch (RuntimeException e2) {
                zzt.zzo().zzu(e2, "NonagonUtil.isPatternMatched");
            }
        }
        if (zzy()) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzfh)).booleanValue()) {
                return;
            }
        }
        zzeys zzeys = new zzeys((String) null);
        this.zzd = null;
        this.zza.zzj(1);
        this.zza.zzb(zzbvb.zza, zzbvb.zzb, zzeys, new zzezi(this));
    }

    public final void zzh() {
        zzi((IObjectWrapper) null);
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzd != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzd.zzm().zzb(context);
        }
    }

    public final void zzj() {
        zzk((IObjectWrapper) null);
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzd != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzd.zzm().zzc(context);
        }
    }

    public final void zzl(zzby zzby) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzby == null) {
            this.zzb.zzb((OnAdMetadataChangedListener) null);
        } else {
            this.zzb.zzb(new zzezj(this, zzby));
        }
    }

    public final synchronized void zzm(String str) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
        this.zzc.zzb = str;
    }

    public final synchronized void zzn(boolean z2) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zze = z2;
    }

    public final void zzo(zzbva zzbva) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzb.zzf(zzbva);
    }

    public final synchronized void zzp(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzc.zza = str;
    }

    public final synchronized void zzq() throws RemoteException {
        zzr((IObjectWrapper) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.app.Activity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzr(com.google.android.gms.dynamic.IObjectWrapper r3) throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "showAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0024 }
            com.google.android.gms.internal.ads.zzdmm r0 = r2.zzd     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            r0 = 0
            if (r3 != 0) goto L_0x000e
            goto L_0x0019
        L_0x000e:
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)     // Catch:{ all -> 0x0024 }
            boolean r1 = r3 instanceof android.app.Activity     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0019
            r0 = r3
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ all -> 0x0024 }
        L_0x0019:
            com.google.android.gms.internal.ads.zzdmm r3 = r2.zzd     // Catch:{ all -> 0x0024 }
            boolean r1 = r2.zze     // Catch:{ all -> 0x0024 }
            r3.zzh(r1, r0)     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0022:
            monitor-exit(r2)
            return
        L_0x0024:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzezk.zzr(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final boolean zzs() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzy();
    }

    public final boolean zzt() {
        zzdmm zzdmm = this.zzd;
        return zzdmm != null && zzdmm.zzg();
    }

    public final void zzu(zzbuv zzbuv) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzb.zzg(zzbuv);
    }
}
