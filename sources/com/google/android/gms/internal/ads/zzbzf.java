package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzbzf implements ThreadFactory {
    final /* synthetic */ String zza;
    private final AtomicInteger zzb = new AtomicInteger(1);

    zzbzf(String str) {
        this.zza = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.zza;
        int andIncrement = this.zzb.getAndIncrement();
        return new Thread(runnable, "AdWorker(" + str + ") #" + andIncrement);
    }
}
