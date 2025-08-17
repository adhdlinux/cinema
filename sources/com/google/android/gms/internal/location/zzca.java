package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsRequest;

final class zzca extends zzcb {
    final /* synthetic */ LocationSettingsRequest zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzca(zzcc zzcc, GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest, String str) {
        super(googleApiClient);
        this.zza = locationSettingsRequest;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        boolean z2;
        zzda zzda = (zzda) anyClient;
        LocationSettingsRequest locationSettingsRequest = this.zza;
        if (locationSettingsRequest != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "locationSettingsRequest can't be null");
        ((zzo) zzda.getService()).zzh(locationSettingsRequest, new zzcr(this), (String) null);
    }
}
