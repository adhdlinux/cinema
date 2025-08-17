package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.view.Choreographer;

public abstract class zzef {
    private Runnable zza;
    private Choreographer.FrameCallback zzb;

    public abstract void zza(long j2);

    /* access modifiers changed from: package-private */
    @TargetApi(16)
    public final Choreographer.FrameCallback zzb() {
        if (this.zzb == null) {
            this.zzb = new zzee(this);
        }
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final Runnable zzc() {
        if (this.zza == null) {
            this.zza = new zzed(this);
        }
        return this.zza;
    }
}
