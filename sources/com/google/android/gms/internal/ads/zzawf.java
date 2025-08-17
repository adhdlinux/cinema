package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzawf implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzawh zza;

    zzawf(zzawh zzawh) {
        this.zza = zzawh;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zza.zzc) {
            try {
                zzawh zzawh = this.zza;
                if (zzawh.zzd != null) {
                    zzawh.zzf = zzawh.zzd.zzq();
                }
            } catch (DeadObjectException e2) {
                zzbzr.zzh("Unable to obtain a cache service instance.", e2);
                zzawh.zzh(this.zza);
            }
            this.zza.zzc.notifyAll();
        }
    }

    public final void onConnectionSuspended(int i2) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            this.zza.zzc.notifyAll();
        }
    }
}
