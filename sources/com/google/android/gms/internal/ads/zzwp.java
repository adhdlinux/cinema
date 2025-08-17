package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class zzwp implements Executor {
    public final /* synthetic */ Handler zza;

    public /* synthetic */ zzwp(Handler handler) {
        this.zza = handler;
    }

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
