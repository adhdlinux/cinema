package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbj implements RemoteCall {
    public final /* synthetic */ zzbt zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Cast.MessageReceivedCallback zzc;

    public /* synthetic */ zzbj(zzbt zzbt, String str, Cast.MessageReceivedCallback messageReceivedCallback) {
        this.zza = zzbt;
        this.zzb = str;
        this.zzc = messageReceivedCallback;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzK(this.zzb, this.zzc, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
