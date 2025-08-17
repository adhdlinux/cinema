package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzawg implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzawh zza;

    zzawg(zzawh zzawh) {
        this.zza = zzawh;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            zzawh zzawh = this.zza;
            if (zzawh.zzd != null) {
                zzawh.zzd = null;
            }
            this.zza.zzc.notifyAll();
        }
    }
}
