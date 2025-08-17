package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzdg extends zzdk {
    zzdg(zzdm zzdm, GoogleApiClient googleApiClient) {
        super(zzdm, googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        doExecute((zzdp) anyClient);
    }

    public final void zza(zzdp zzdp) throws RemoteException {
        zzdp.zzs(new zzdj(this));
    }
}
