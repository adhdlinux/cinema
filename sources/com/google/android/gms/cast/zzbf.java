package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzag;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbf implements RemoteCall {
    public static final /* synthetic */ zzbf zza = new zzbf();

    private /* synthetic */ zzbf() {
    }

    public final void accept(Object obj, Object obj2) {
        int i2 = zzbt.zzf;
        ((zzag) ((zzx) obj).getService()).zzf();
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
