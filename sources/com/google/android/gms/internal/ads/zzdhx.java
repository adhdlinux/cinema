package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

public final /* synthetic */ class zzdhx implements Runnable {
    public final /* synthetic */ zzdia zza;
    public final /* synthetic */ ViewGroup zzb;

    public /* synthetic */ zzdhx(zzdia zzdia, ViewGroup viewGroup) {
        this.zza = zzdia;
        this.zzb = viewGroup;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}
