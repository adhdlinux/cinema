package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbh implements RemoteCall {
    public final /* synthetic */ zzbt zza;
    public final /* synthetic */ double zzb;

    public /* synthetic */ zzbh(zzbt zzbt, double d2) {
        this.zza = zzbt;
        this.zzb = d2;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzM(this.zzb, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
