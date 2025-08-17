package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

final class zzfvp extends zzfvb {
    /* access modifiers changed from: private */
    public zzfvo zza;

    zzfvp(zzfrx zzfrx, boolean z2, Executor executor, Callable callable) {
        super(zzfrx, z2, false);
        this.zza = new zzfvn(this, callable, executor);
        zzw();
    }

    /* access modifiers changed from: package-private */
    public final void zzg(int i2, Object obj) {
    }

    /* access modifiers changed from: protected */
    public final void zzr() {
        zzfvo zzfvo = this.zza;
        if (zzfvo != null) {
            zzfvo.zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzv() {
        zzfvo zzfvo = this.zza;
        if (zzfvo != null) {
            zzfvo.zzf();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzz(int i2) {
        super.zzz(i2);
        if (i2 == 1) {
            this.zza = null;
        }
    }
}
