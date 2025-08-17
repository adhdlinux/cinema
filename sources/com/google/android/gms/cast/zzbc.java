package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbc implements RemoteCall {
    public final /* synthetic */ zzbt zza;
    public final /* synthetic */ boolean zzb;

    public /* synthetic */ zzbc(zzbt zzbt, boolean z2) {
        this.zza = zzbt;
        this.zzb = z2;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzL(this.zzb, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
