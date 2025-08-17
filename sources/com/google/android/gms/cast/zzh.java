package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzh extends zzp {
    final /* synthetic */ String zza;
    final /* synthetic */ LaunchOptions zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzh(zzm zzm, GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions) {
        super(googleApiClient);
        this.zza = str;
        this.zzb = launchOptions;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        doExecute((zzw) anyClient);
    }

    public final void zza(zzw zzw) throws RemoteException {
        try {
            zzw.zzM(this.zza, this.zzb, this);
        } catch (IllegalStateException unused) {
            zzc(2001);
        }
    }
}
