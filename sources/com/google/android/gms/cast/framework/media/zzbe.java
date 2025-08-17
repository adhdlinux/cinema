package com.google.android.gms.cast.framework.media;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class zzbe implements OnFailureListener {
    public final /* synthetic */ zzbf zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzbe(zzbf zzbf, long j2) {
        this.zza = zzbf;
        this.zzb = j2;
    }

    public final void onFailure(Exception exc) {
        int i2;
        zzbf zzbf = this.zza;
        long j2 = this.zzb;
        if (exc instanceof ApiException) {
            i2 = ((ApiException) exc).getStatusCode();
        } else {
            i2 = 13;
        }
        zzbf.zza.zze.zzP(j2, i2);
    }
}
