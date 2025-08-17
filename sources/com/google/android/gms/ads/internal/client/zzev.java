package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbzr;

final class zzev implements Runnable {
    final /* synthetic */ zzew zza;

    zzev(zzew zzew) {
        this.zza = zzew;
    }

    public final void run() {
        zzew zzew = this.zza;
        if (zzew.zza != null) {
            try {
                zzew.zza.zze(1);
            } catch (RemoteException e2) {
                zzbzr.zzk("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
