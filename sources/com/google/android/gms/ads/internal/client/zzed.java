package com.google.android.gms.ads.internal.client;

import android.content.Context;

public final /* synthetic */ class zzed implements Runnable {
    public final /* synthetic */ zzej zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzed(zzej zzej, Context context, String str) {
        this.zza = zzej;
        this.zzb = context;
    }

    public final void run() {
        this.zza.zzp(this.zzb, (String) null);
    }
}
