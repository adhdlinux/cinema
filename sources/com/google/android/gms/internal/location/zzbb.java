package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbb implements RemoteCall {
    public final /* synthetic */ boolean zza;

    public /* synthetic */ zzbb(boolean z2) {
        this.zza = z2;
    }

    public final void accept(Object obj, Object obj2) {
        Api api = zzbp.zzb;
        ((zzda) obj).zzA(this.zza, (TaskCompletionSource) obj2);
    }
}
