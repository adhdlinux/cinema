package com.google.android.gms.internal.ads;

import android.view.View;

final class zzauv implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzauz zzb;

    zzauv(zzauz zzauz, View view) {
        this.zzb = zzauz;
        this.zza = view;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
