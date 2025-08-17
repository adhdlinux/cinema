package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzag;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzbe implements RemoteCall {
    public static final /* synthetic */ zzbe zza = new zzbe();

    private /* synthetic */ zzbe() {
    }

    public final void accept(Object obj, Object obj2) {
        int i2 = zzbt.zzf;
        ((zzag) ((zzx) obj).getService()).zzq();
        ((TaskCompletionSource) obj2).setResult(Boolean.TRUE);
    }
}
