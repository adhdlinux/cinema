package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public final class zzfc implements zzdz {
    protected zzfc() {
    }

    public final long zza() {
        return SystemClock.elapsedRealtime();
    }

    public final zzei zzb(Looper looper, Handler.Callback callback) {
        return new zzff(new Handler(looper, callback));
    }
}
