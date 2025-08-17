package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

final class zzqw extends zzqe implements RunnableFuture {
    private volatile zzqo zzb;

    zzqw(Callable callable) {
        this.zzb = new zzqv(this, callable);
    }

    static zzqw zzn(Runnable runnable, Object obj) {
        return new zzqw(Executors.callable(runnable, obj));
    }

    public final void run() {
        zzqo zzqo = this.zzb;
        if (zzqo != null) {
            zzqo.run();
        }
        this.zzb = null;
    }

    /* access modifiers changed from: protected */
    public final String zze() {
        zzqo zzqo = this.zzb;
        if (zzqo == null) {
            return super.zze();
        }
        String obj = zzqo.toString();
        return "task=[" + obj + "]";
    }

    /* access modifiers changed from: protected */
    public final void zzj() {
        zzqo zzqo;
        if (zzm() && (zzqo = this.zzb) != null) {
            zzqo.zze();
        }
        this.zzb = null;
    }
}
