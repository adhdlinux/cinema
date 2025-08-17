package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;

final class zzqv extends zzqo {
    final /* synthetic */ zzqw zza;
    private final Callable zzb;

    zzqv(zzqw zzqw, Callable callable) {
        this.zza = zzqw;
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
    public final void zzc(Throwable th) {
        this.zza.zzl(th);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Object obj) {
        this.zza.zzk(obj);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return this.zza.isDone();
    }
}
