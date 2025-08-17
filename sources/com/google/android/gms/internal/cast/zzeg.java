package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;

final class zzeg extends zzei {
    private final Handler zza;

    public zzeg(Looper looper) {
        this.zza = new Handler(looper);
    }

    public final void zza(zzef zzef) {
        this.zza.postDelayed(zzef.zzc(), 0);
    }
}
