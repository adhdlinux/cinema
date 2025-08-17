package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzaz implements RemoteCall {
    public final /* synthetic */ zzbt zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ LaunchOptions zzc;

    public /* synthetic */ zzaz(zzbt zzbt, String str, LaunchOptions launchOptions) {
        this.zza = zzbt;
        this.zzb = str;
        this.zzc = launchOptions;
    }

    public final void accept(Object obj, Object obj2) {
        this.zza.zzH(this.zzb, this.zzc, (zzx) obj, (TaskCompletionSource) obj2);
    }
}
