package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

final class zzakz implements Executor {
    final /* synthetic */ Handler zza;

    zzakz(zzalb zzalb, Handler handler) {
        this.zza = handler;
    }

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
