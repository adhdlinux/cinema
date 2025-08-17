package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzfmb implements zzflz {
    private zzfmb() {
    }

    /* synthetic */ zzfmb(zzfma zzfma) {
    }

    public final ExecutorService zza(int i2) {
        return zzc(1, Executors.defaultThreadFactory(), 2);
    }

    public final ExecutorService zzb(ThreadFactory threadFactory, int i2) {
        return zzc(1, threadFactory, 1);
    }

    public final ExecutorService zzc(int i2, ThreadFactory threadFactory, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
