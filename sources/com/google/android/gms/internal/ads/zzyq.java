package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class zzyq implements Executor {
    public final /* synthetic */ Handler zza;

    public /* synthetic */ zzyq(Handler handler) {
        this.zza = handler;
    }

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
