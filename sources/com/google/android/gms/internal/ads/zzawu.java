package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzawu implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzcaj zza;
    final /* synthetic */ zzawv zzb;

    zzawu(zzawv zzawv, zzcaj zzcaj) {
        this.zzb = zzawv;
        this.zza = zzcaj;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzb.zzd) {
            this.zza.zze(new RuntimeException("Connection failed."));
        }
    }
}
