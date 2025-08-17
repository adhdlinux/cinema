package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzeat implements Callable {
    public final /* synthetic */ zzeba zza;

    public /* synthetic */ zzeat(zzeba zzeba) {
        this.zza = zzeba;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
