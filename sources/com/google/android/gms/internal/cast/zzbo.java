package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class zzbo implements OnFailureListener {
    public final /* synthetic */ zzbp zza;
    public final /* synthetic */ zzbq zzb;

    public /* synthetic */ zzbo(zzbp zzbp, zzbq zzbq) {
        this.zza = zzbp;
        this.zzb = zzbq;
    }

    public final void onFailure(Exception exc) {
        zzbp zzbp = this.zza;
        Status status = new Status(8, "unknown error");
        if (exc instanceof ApiException) {
            ApiException apiException = (ApiException) exc;
            status = new Status(apiException.getStatusCode(), apiException.getMessage());
        }
        int i2 = CastSession.zza;
        zzbp.setResult(status);
    }
}
