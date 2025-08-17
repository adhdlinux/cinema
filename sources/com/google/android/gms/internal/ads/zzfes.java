package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzfes {
    private final Executor zza;
    private final zzbzw zzb;

    public zzfes(Executor executor, zzbzw zzbzw) {
        this.zza = executor;
        this.zzb = zzbzw;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        this.zzb.zza(str);
    }

    public final void zzb(String str) {
        this.zza.execute(new zzfer(this, str));
    }
}
