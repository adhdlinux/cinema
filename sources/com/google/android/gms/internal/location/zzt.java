package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

final class zzt extends zzv {
    final /* synthetic */ long zza;
    final /* synthetic */ PendingIntent zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzt(zzw zzw, GoogleApiClient googleApiClient, long j2, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zza = j2;
        this.zzb = pendingIntent;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        boolean z2;
        zzf zzf = (zzf) anyClient;
        long j2 = this.zza;
        PendingIntent pendingIntent = this.zzb;
        Preconditions.checkNotNull(pendingIntent);
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "detectionIntervalMillis must be >= 0");
        ((zzo) zzf.getService()).zzr(j2, true, pendingIntent);
        setResult(Status.RESULT_SUCCESS);
    }
}
