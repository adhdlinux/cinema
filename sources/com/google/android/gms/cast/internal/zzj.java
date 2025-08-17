package com.google.android.gms.cast.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzj extends IStatusCallback.Stub {
    final /* synthetic */ TaskCompletionSource zza;

    zzj(zzn zzn, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onResult(Status status) throws RemoteException {
        TaskUtil.setResultOrApiException(status, this.zza);
    }
}
