package com.google.android.gms.internal.ads;

final class zzcbn implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcbo zzb;

    zzcbn(zzcbo zzcbo, boolean z2) {
        this.zzb = zzcbo;
        this.zza = z2;
    }

    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
