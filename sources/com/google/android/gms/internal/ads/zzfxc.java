package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

final class zzfxc extends zzfvs implements RunnableFuture {
    private volatile zzfwl zza;

    zzfxc(zzfvi zzfvi) {
        this.zza = new zzfxa(this, zzfvi);
    }

    static zzfxc zzf(Runnable runnable, Object obj) {
        return new zzfxc(Executors.callable(runnable, obj));
    }

    public final void run() {
        zzfwl zzfwl = this.zza;
        if (zzfwl != null) {
            zzfwl.run();
        }
        this.zza = null;
    }

    /* access modifiers changed from: protected */
    public final String zza() {
        zzfwl zzfwl = this.zza;
        if (zzfwl == null) {
            return super.zza();
        }
        String obj = zzfwl.toString();
        return "task=[" + obj + "]";
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzfwl zzfwl;
        if (zzu() && (zzfwl = this.zza) != null) {
            zzfwl.zzh();
        }
        this.zza = null;
    }

    zzfxc(Callable callable) {
        this.zza = new zzfxb(this, callable);
    }
}
