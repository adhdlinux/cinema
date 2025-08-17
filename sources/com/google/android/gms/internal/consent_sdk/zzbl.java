package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import java.util.concurrent.Executor;

public final /* synthetic */ class zzbl implements Executor {
    public final /* synthetic */ Handler zza;

    public /* synthetic */ zzbl(Handler handler) {
        this.zza = handler;
    }

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
