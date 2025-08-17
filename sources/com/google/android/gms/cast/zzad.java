package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzad extends zzaf {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ CastRemoteDisplayClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzad(CastRemoteDisplayClient castRemoteDisplayClient, TaskCompletionSource taskCompletionSource) {
        super((zzae) null);
        this.zzb = castRemoteDisplayClient;
        this.zza = taskCompletionSource;
    }

    public final void zzd(int i2) throws RemoteException {
        this.zzb.zzc.d("onError: %d", Integer.valueOf(i2));
        CastRemoteDisplayClient.zzd(this.zzb);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, this.zza);
    }

    public final void zzf() throws RemoteException {
        this.zzb.zzc.d("onDisconnected", new Object[0]);
        CastRemoteDisplayClient.zzd(this.zzb);
        TaskUtil.setResultOrApiException(Status.RESULT_SUCCESS, this.zza);
    }
}
