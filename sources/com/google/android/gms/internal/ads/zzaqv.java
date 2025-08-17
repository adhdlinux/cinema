package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

final class zzaqv extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzaqw zza;

    zzaqv(zzaqw zzaqw) {
        this.zza = zzaqw;
    }

    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (zzaqw.class) {
            this.zza.zza = networkCapabilities;
        }
    }

    public final void onLost(Network network) {
        synchronized (zzaqw.class) {
            this.zza.zza = null;
        }
    }
}
