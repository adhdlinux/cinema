package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class zzfmd extends Handler {
    private final Looper zza = Looper.getMainLooper();

    public zzfmd() {
    }

    public final void dispatchMessage(Message message) {
        zza(message);
    }

    /* access modifiers changed from: protected */
    public void zza(Message message) {
        super.dispatchMessage(message);
    }

    public zzfmd(Looper looper) {
        super(looper);
    }
}
