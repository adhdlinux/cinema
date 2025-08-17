package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

final class zzhr extends BroadcastReceiver implements Runnable {
    final /* synthetic */ zzht zza;
    private final zzhs zzb;
    private final Handler zzc;

    public zzhr(zzht zzht, Handler handler, zzhs zzhs) {
        this.zza = zzht;
        this.zzc = handler;
        this.zzb = zzhs;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.zzc.post(this);
        }
    }

    public final void run() {
    }
}
