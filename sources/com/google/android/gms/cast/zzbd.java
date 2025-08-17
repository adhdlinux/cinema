package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbd implements RemoteCall {
    public final /* synthetic */ zzbt zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbd(zzbt zzbt, String str) {
        this.zza = zzbt;
        this.zzb = str;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzN(this.zzb, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
