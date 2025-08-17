package com.google.android.gms.internal.ads;

import android.net.Network;
import java.net.URL;
import java.net.URLConnection;

public final /* synthetic */ class zzfls implements zzflx {
    public final /* synthetic */ Network zza;
    public final /* synthetic */ URL zzb;

    public /* synthetic */ zzfls(Network network, URL url) {
        this.zza = network;
        this.zzb = url;
    }

    public final URLConnection zza() {
        return this.zza.openConnection(this.zzb);
    }
}
