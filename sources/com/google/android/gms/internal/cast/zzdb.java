package com.google.android.gms.internal.cast;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;

final class zzdb extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzdc zza;

    zzdb(zzdc zzdc) {
        this.zza = zzdc;
    }

    public final void onAvailable(Network network) {
    }

    public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        this.zza.zzg(network, linkProperties);
    }

    public final void onLost(Network network) {
        zzdc.zze(this.zza, network);
    }

    public final void onUnavailable() {
        zzdc.zzd(this.zza);
    }
}
