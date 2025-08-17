package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

final class zzfe implements zzeh {
    private Message zza;
    private zzff zzb;

    private zzfe() {
    }

    /* synthetic */ zzfe(zzfd zzfd) {
    }

    private final void zzd() {
        this.zza = null;
        this.zzb = null;
        zzff.zzl(this);
    }

    public final void zza() {
        Message message = this.zza;
        message.getClass();
        message.sendToTarget();
        zzd();
    }

    public final zzfe zzb(Message message, zzff zzff) {
        this.zza = message;
        this.zzb = zzff;
        return this;
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        message.getClass();
        boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        zzd();
        return sendMessageAtFrontOfQueue;
    }
}
