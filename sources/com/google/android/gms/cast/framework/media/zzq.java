package com.google.android.gms.cast.framework.media;

import java.util.TimerTask;

final class zzq extends TimerTask {
    final /* synthetic */ MediaQueue zza;

    zzq(MediaQueue mediaQueue) {
        this.zza = mediaQueue;
    }

    public final void run() {
        MediaQueue.zzj(this.zza);
    }
}
