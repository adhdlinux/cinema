package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zzre extends Handler {
    final /* synthetic */ zzrg zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzre(zzrg zzrg, Looper looper) {
        super(looper);
        this.zza = zzrg;
    }

    public final void handleMessage(Message message) {
        zzrg.zza(this.zza, message);
    }
}
