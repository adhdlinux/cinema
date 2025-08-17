package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final /* synthetic */ class zzdkw implements Runnable {
    public final /* synthetic */ zzdky zza;

    public /* synthetic */ zzdkw(zzdky zzdky) {
        this.zza = zzdky;
    }

    public final void run() {
        try {
            this.zza.zzd();
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }
}
