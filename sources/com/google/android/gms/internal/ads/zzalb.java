package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class zzalb {
    private final Executor zza;

    public zzalb(Handler handler) {
        this.zza = new zzakz(this, handler);
    }

    public final void zza(zzalk zzalk, zzalt zzalt) {
        zzalk.zzm("post-error");
        zzalq zza2 = zzalq.zza(zzalt);
        Executor executor = this.zza;
        ((zzakz) executor).zza.post(new zzala(zzalk, zza2, (Runnable) null));
    }

    public final void zzb(zzalk zzalk, zzalq zzalq, Runnable runnable) {
        zzalk.zzq();
        zzalk.zzm("post-response");
        Executor executor = this.zza;
        ((zzakz) executor).zza.post(new zzala(zzalk, zzalq, runnable));
    }
}
