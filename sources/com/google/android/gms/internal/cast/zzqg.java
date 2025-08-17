package com.google.android.gms.internal.cast;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class zzqg extends zzez implements Future {
    protected zzqg() {
    }

    public boolean cancel(boolean z2) {
        return zzb().cancel(z2);
    }

    public final Object get() throws InterruptedException, ExecutionException {
        return zzb().get();
    }

    public final boolean isCancelled() {
        return zzb().isCancelled();
    }

    public final boolean isDone() {
        return zzb().isDone();
    }

    /* access modifiers changed from: protected */
    public /* bridge */ /* synthetic */ Object zza() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public abstract Future zzb();

    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return zzb().get(j2, timeUnit);
    }
}
