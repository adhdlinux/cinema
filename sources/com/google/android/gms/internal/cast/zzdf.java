package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzdf extends zzdk {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdm zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdf(zzdm zzdm, GoogleApiClient googleApiClient, String str) {
        super(zzdm, googleApiClient);
        this.zzb = zzdm;
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        doExecute((zzdp) anyClient);
    }

    public final void zza(zzdp zzdp) throws RemoteException {
        zzdp.zzr(new zzdi(this, zzdp), this.zzb.zzd, this.zza);
    }
}
