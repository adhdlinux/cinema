package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zzad;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzj extends zzad {
    zzj(zzm zzm, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        doExecute((zzw) anyClient);
    }

    public final void zza(zzw zzw) throws RemoteException {
        try {
            zzw.zzN(this);
        } catch (IllegalStateException unused) {
            zzc(2001);
        }
    }
}
