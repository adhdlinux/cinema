package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzdzr implements Callable {
    public final /* synthetic */ zzdzp zza;

    public /* synthetic */ zzdzr(zzdzp zzdzp) {
        this.zza = zzdzp;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
