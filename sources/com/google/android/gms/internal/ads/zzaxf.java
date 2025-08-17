package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutorService;

public final class zzaxf {
    zzatv zza;
    boolean zzb;
    /* access modifiers changed from: private */
    public final ExecutorService zzc;

    public zzaxf() {
        this.zzc = zzbzg.zzb;
    }

    public zzaxf(Context context) {
        ExecutorService executorService = zzbzg.zzb;
        this.zzc = executorService;
        executorService.execute(new zzaxa(this, context));
    }
}
