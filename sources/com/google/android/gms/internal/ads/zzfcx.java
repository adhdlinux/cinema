package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzfcx implements ThreadFactory {
    private final AtomicInteger zza = new AtomicInteger(1);

    zzfcx() {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.zza.getAndIncrement();
        return new Thread(runnable, "AdWorker(NG) #" + andIncrement);
    }
}
