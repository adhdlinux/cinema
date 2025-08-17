package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbvu;
import com.google.android.gms.internal.ads.zzbzr;

public final /* synthetic */ class zzfb implements Runnable {
    public final /* synthetic */ zzbvu zza;

    public /* synthetic */ zzfb(zzbvu zzbvu) {
        this.zza = zzbvu;
    }

    public final void run() {
        zzbvu zzbvu = this.zza;
        if (zzbvu != null) {
            try {
                zzbvu.zze(1);
            } catch (RemoteException e2) {
                zzbzr.zzl("#007 Could not call remote method.", e2);
            }
        }
    }
}
