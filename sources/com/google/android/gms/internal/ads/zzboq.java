package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

final class zzboq implements InitializationCompleteCallback {
    final /* synthetic */ zzbkj zza;

    zzboq(zzbow zzbow, zzbkj zzbkj) {
        this.zza = zzbkj;
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zza.zzf();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }
}
