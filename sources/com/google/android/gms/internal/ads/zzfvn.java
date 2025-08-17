package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

final class zzfvn extends zzfvo {
    final /* synthetic */ zzfvp zza;
    private final Callable zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfvn(zzfvp zzfvp, Callable callable, Executor executor) {
        super(zzfvp, executor);
        this.zza = zzfvp;
        this.zzc = callable;
    }

    /* access modifiers changed from: package-private */
    public final Object zza() throws Exception {
        return this.zzc.call();
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzc.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj) {
        this.zza.zzd(obj);
    }
}
