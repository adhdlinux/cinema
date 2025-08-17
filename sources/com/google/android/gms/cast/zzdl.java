package com.google.android.gms.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class zzdl implements ResultCallback {
    final /* synthetic */ zzdm zza;
    private final long zzb;

    zzdl(zzdm zzdm, long j2) {
        this.zza = zzdm;
        this.zzb = j2;
    }

    public final /* bridge */ /* synthetic */ void onResult(Result result) {
        Status status = (Status) result;
        if (!status.isSuccess()) {
            this.zza.zza.zzb.zzP(this.zzb, status.getStatusCode());
        }
    }
}
