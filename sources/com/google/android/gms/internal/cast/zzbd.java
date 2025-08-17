package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzbd implements OnCompleteListener {
    public final /* synthetic */ zzbf zza;
    public final /* synthetic */ CastOptions zzb;

    public /* synthetic */ zzbd(zzbf zzbf, CastOptions castOptions) {
        this.zza = zzbf;
        this.zzb = castOptions;
    }

    public final void onComplete(Task task) {
        this.zza.zzp(this.zzb, task);
    }
}
