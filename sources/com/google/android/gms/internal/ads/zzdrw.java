package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final /* synthetic */ class zzdrw implements Runnable {
    public final /* synthetic */ zzdsc zza;
    public final /* synthetic */ zzbkm zzb;

    public /* synthetic */ zzdrw(zzdsc zzdsc, zzbkm zzbkm) {
        this.zza = zzdsc;
        this.zzb = zzbkm;
    }

    public final void run() {
        zzdsc zzdsc = this.zza;
        try {
            this.zzb.zzb(zzdsc.zzg());
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }
}
