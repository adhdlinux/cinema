package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zzc;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
class zzp extends zzc {
    public zzp(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzo(this, status);
    }

    /* renamed from: zza */
    public void doExecute(zzw zzw) throws RemoteException {
        throw null;
    }
}
