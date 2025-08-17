package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzg extends zzp {
    final /* synthetic */ String zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzg(zzm zzm, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        doExecute((zzw) anyClient);
    }

    public final void zza(zzw zzw) throws RemoteException {
        try {
            String str = this.zza;
            LaunchOptions launchOptions = new LaunchOptions();
            launchOptions.setRelaunchIfRunning(false);
            zzw.zzM(str, launchOptions, this);
        } catch (IllegalStateException unused) {
            zzc(2001);
        }
    }
}
