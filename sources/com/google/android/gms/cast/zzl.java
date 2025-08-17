package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzad;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzl extends zzad {
    final /* synthetic */ String zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzl(zzm zzm, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        doExecute((zzw) anyClient);
    }

    public final void zza(zzw zzw) throws RemoteException {
        if (TextUtils.isEmpty(this.zza)) {
            setResult(new Status(2001, "IllegalArgument: sessionId cannot be null or empty", (PendingIntent) null));
            return;
        }
        try {
            zzw.zzV(this.zza, this);
        } catch (IllegalStateException unused) {
            zzc(2001);
        }
    }
}
