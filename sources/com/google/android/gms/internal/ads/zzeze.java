package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzeze extends zzbvm {
    private final zzeza zza;
    private final zzeyq zzb;
    private final String zzc;
    /* access modifiers changed from: private */
    public final zzfaa zzd;
    private final Context zze;
    private final zzbzx zzf;
    private final zzaqs zzg;
    private final zzdqa zzh;
    /* access modifiers changed from: private */
    public zzdmm zzi;
    private boolean zzj = ((Boolean) zzba.zzc().zzb(zzbbm.zzaD)).booleanValue();

    public zzeze(String str, zzeza zzeza, Context context, zzeyq zzeyq, zzfaa zzfaa, zzbzx zzbzx, zzaqs zzaqs, zzdqa zzdqa) {
        this.zzc = str;
        this.zza = zzeza;
        this.zzb = zzeyq;
        this.zzd = zzfaa;
        this.zze = context;
        this.zzf = zzbzx;
        this.zzg = zzaqs;
        this.zzh = zzdqa;
    }

    private final synchronized void zzu(zzl zzl, zzbvu zzbvu, int i2) throws RemoteException {
        boolean z2 = false;
        if (((Boolean) zzbdd.zzl.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjJ)).booleanValue()) {
                z2 = true;
            }
        }
        if (this.zzf.zzc < ((Integer) zzba.zzc().zzb(zzbbm.zzjK)).intValue() || !z2) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        }
        this.zzb.zze(zzbvu);
        zzt.zzp();
        if (zzs.zzD(this.zze)) {
            if (zzl.zzs == null) {
                zzbzr.zzg("Failed to load the ad because app ID is missing.");
                this.zzb.zza(zzfbi.zzd(4, (String) null, (zze) null));
                return;
            }
        }
        if (this.zzi == null) {
            zzeys zzeys = new zzeys((String) null);
            this.zza.zzj(i2);
            this.zza.zzb(zzl, this.zzc, zzeys, new zzezd(this));
        }
    }

    public final Bundle zzb() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdmm zzdmm = this.zzi;
        if (zzdmm != null) {
            return zzdmm.zza();
        }
        return new Bundle();
    }

    public final zzdn zzc() {
        zzdmm zzdmm;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgA)).booleanValue() && (zzdmm = this.zzi) != null) {
            return zzdmm.zzl();
        }
        return null;
    }

    public final zzbvk zzd() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdmm zzdmm = this.zzi;
        if (zzdmm != null) {
            return zzdmm.zzc();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zze() throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzdmm r0 = r2.zzi     // Catch:{ all -> 0x0018 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeze.zze():java.lang.String");
    }

    public final synchronized void zzf(zzl zzl, zzbvu zzbvu) throws RemoteException {
        zzu(zzl, zzbvu, 2);
    }

    public final synchronized void zzg(zzl zzl, zzbvu zzbvu) throws RemoteException {
        zzu(zzl, zzbvu, 3);
    }

    public final synchronized void zzh(boolean z2) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzj = z2;
    }

    public final void zzi(zzdd zzdd) {
        if (zzdd == null) {
            this.zzb.zzb((OnAdMetadataChangedListener) null);
        } else {
            this.zzb.zzb(new zzezc(this, zzdd));
        }
    }

    public final void zzj(zzdg zzdg) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdg.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException e2) {
            zzbzr.zzf("Error in making CSI ping for reporting paid event callback", e2);
        }
        this.zzb.zzc(zzdg);
    }

    public final void zzk(zzbvq zzbvq) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzd(zzbvq);
    }

    public final synchronized void zzl(zzbwb zzbwb) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzfaa zzfaa = this.zzd;
        zzfaa.zza = zzbwb.zza;
        zzfaa.zzb = zzbwb.zzb;
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzn(iObjectWrapper, this.zzj);
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper, boolean z2) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzi == null) {
            zzbzr.zzj("Rewarded can not be shown before loaded");
            this.zzb.zzk(zzfbi.zzd(9, (String) null, (zze) null));
            return;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcr)).booleanValue()) {
            this.zzg.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzi.zzh(z2, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean zzo() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdmm zzdmm = this.zzi;
        if (zzdmm == null || zzdmm.zzf()) {
            return false;
        }
        return true;
    }

    public final void zzp(zzbvv zzbvv) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzi(zzbvv);
    }
}
