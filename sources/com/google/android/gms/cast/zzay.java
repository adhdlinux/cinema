package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzag;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzay implements RemoteCall {
    public final /* synthetic */ zzbt zza;

    public /* synthetic */ zzay(zzbt zzbt) {
        this.zza = zzbt;
    }

    public final void accept(Object obj, Object obj2) {
        zzx zzx = (zzx) obj;
        ((zzag) zzx.getService()).zzj(this.zza.zza);
        ((zzag) zzx.getService()).zze();
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
