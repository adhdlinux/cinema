package com.google.android.gms.internal.cast;

import android.view.Choreographer;

public final /* synthetic */ class zzee implements Choreographer.FrameCallback {
    public final /* synthetic */ zzef zza;

    public /* synthetic */ zzee(zzef zzef) {
        this.zza = zzef;
    }

    public final void doFrame(long j2) {
        this.zza.zza(j2);
    }
}
