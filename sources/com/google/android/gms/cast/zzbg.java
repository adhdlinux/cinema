package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbg implements RemoteCall {
    public final /* synthetic */ zzbt zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzbg(zzbt zzbt, String str, String str2, zzbu zzbu) {
        this.zza = zzbt;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzG(this.zzb, this.zzc, (zzbu) null, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
