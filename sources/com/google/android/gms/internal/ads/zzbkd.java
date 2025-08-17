package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzbkd implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzcaj zza;

    zzbkd(zzbke zzbke, zzcaj zzcaj) {
        this.zza = zzcaj;
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zza.zze(new RuntimeException("Connection failed."));
    }
}
