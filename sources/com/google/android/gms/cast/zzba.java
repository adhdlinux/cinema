package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzba implements RemoteCall {
    public final /* synthetic */ zzbt zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzba(zzbt zzbt, String str, String str2, String str3) {
        this.zza = zzbt;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzJ((String) null, this.zzb, this.zzc, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
