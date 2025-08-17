package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public final class zzdj extends zzdh {
    final /* synthetic */ zzdk zza;

    protected zzdj(zzdk zzdk) {
        this.zza = zzdk;
    }

    public final void zzd(int i2) throws RemoteException {
        zzdm.zza.d("onError: %d", Integer.valueOf(i2));
        zzdm.zzf(this.zza.zzc);
        this.zza.setResult(new zzdl(Status.RESULT_INTERNAL_ERROR));
    }

    public final void zzf() throws RemoteException {
        zzdm.zza.d("onDisconnected", new Object[0]);
        zzdm.zzf(this.zza.zzc);
        this.zza.setResult(new zzdl(Status.RESULT_SUCCESS));
    }
}
