package com.google.android.gms.internal.consent_sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

final class zzcc implements Executor {
    private final AtomicInteger zza = new AtomicInteger(1);
    private final ThreadPoolExecutor zzb;
    private WeakReference<Thread> zzc = new WeakReference<>((Object) null);

    zzcc(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcb(this, "Google consent worker"));
        this.zzb = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public final void execute(Runnable runnable) {
        if (Thread.currentThread() == this.zzc.get()) {
            runnable.run();
        } else {
            this.zzb.execute(runnable);
        }
    }

    public final /* synthetic */ Thread zza(String str, Runnable runnable) {
        int andIncrement = this.zza.getAndIncrement();
        StringBuilder sb = new StringBuilder(34);
        sb.append("Google consent worker #");
        sb.append(andIncrement);
        Thread thread = new Thread(runnable, sb.toString());
        this.zzc = new WeakReference<>(thread);
        return thread;
    }
}
