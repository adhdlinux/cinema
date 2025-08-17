package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzbxt implements ThreadFactory {
    private final AtomicInteger zza = new AtomicInteger(1);

    zzbxt(zzbxw zzbxw) {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.zza.getAndIncrement();
        return new Thread(runnable, "AdWorker(SCION_TASK_EXECUTOR) #" + andIncrement);
    }
}
