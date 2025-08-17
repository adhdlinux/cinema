package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.view.Choreographer;

@TargetApi(16)
final class zzeh extends zzei {
    private final Choreographer zza = Choreographer.getInstance();

    public final void zza(zzef zzef) {
        this.zza.postFrameCallback(zzef.zzb());
    }
}
