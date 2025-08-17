package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final class zzfxb extends zzfwl {
    final /* synthetic */ zzfxc zza;
    private final Callable zzb;

    zzfxb(zzfxc zzfxc, Callable callable) {
        this.zza = zzfxc;
        callable.getClass();
        this.zzb = callable;
    }

    /* access modifiers changed from: package-private */
    public final Object zza() throws Exception {
        return this.zzb.call();
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Throwable th) {
        this.zza.zze(th);
    }

    /* access modifiers changed from: package-private */
    public final void zze(Object obj) {
        this.zza.zzd(obj);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return this.zza.isDone();
    }
}
