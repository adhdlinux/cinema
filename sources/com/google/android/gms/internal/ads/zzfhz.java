package com.google.android.gms.internal.ads;

import android.webkit.WebView;

final class zzfhz implements Runnable {
    final /* synthetic */ zzfia zza;
    private final WebView zzb;

    zzfhz(zzfia zzfia) {
        this.zza = zzfia;
        this.zzb = zzfia.zza;
    }

    public final void run() {
        this.zzb.destroy();
    }
}
