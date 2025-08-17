package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zzad;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzf extends zzad {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzf(zzm zzm, GoogleApiClient googleApiClient, String str, String str2) {
        super(googleApiClient);
        this.zza = str;
        this.zzb = str2;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        doExecute((zzw) anyClient);
    }

    public final void zza(zzw zzw) throws RemoteException {
        try {
            zzw.zzQ(this.zza, this.zzb, this);
        } catch (IllegalArgumentException | IllegalStateException unused) {
            zzc(2001);
        }
    }
}
