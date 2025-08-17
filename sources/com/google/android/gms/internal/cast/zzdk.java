package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
class zzdk extends BaseImplementation.ApiMethodImpl {
    final /* synthetic */ zzdm zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdk(zzdm zzdm, GoogleApiClient googleApiClient) {
        super((Api<?>) zzdm.zzb, googleApiClient);
        this.zzc = zzdm;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzdl(status);
    }

    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }

    @VisibleForTesting
    /* renamed from: zza */
    public void doExecute(zzdp zzdp) throws RemoteException {
        throw null;
    }
}
