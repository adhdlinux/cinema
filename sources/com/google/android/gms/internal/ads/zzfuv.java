package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

public abstract class zzfuv extends AbstractExecutorService implements zzfwn {
    /* access modifiers changed from: protected */
    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return zzfxc.zzf(runnable, obj);
    }

    public final /* synthetic */ Future submit(Runnable runnable) {
        return (zzfwm) super.submit(runnable);
    }

    public final zzfwm zza(Runnable runnable) {
        return (zzfwm) super.submit(runnable);
    }

    public final zzfwm zzb(Callable callable) {
        return (zzfwm) super.submit(callable);
    }

    /* access modifiers changed from: protected */
    public final RunnableFuture newTaskFor(Callable callable) {
        return new zzfxc(callable);
    }

    public final /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (zzfwm) super.submit(runnable, obj);
    }

    public final /* synthetic */ Future submit(Callable callable) {
        return (zzfwm) super.submit(callable);
    }
}
