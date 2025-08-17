package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;

final class zzbyx extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzbza zza;

    zzbyx(zzbza zzbza) {
        this.zza = zzbza;
    }

    public final void onAvailable(Network network) {
        this.zza.zzn.set(true);
    }

    public final void onLost(Network network) {
        this.zza.zzn.set(false);
    }
}
