package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

final class zzaf extends zzah {
    final /* synthetic */ zzag zza;

    zzaf(zzag zzag) {
        this.zza = zzag;
    }

    public final void zzc(boolean z2) {
        Status status;
        zzag zzag = this.zza;
        if (z2) {
            status = Status.RESULT_SUCCESS;
        } else {
            status = zzal.zza;
        }
        zzag.setResult(new zzak(status));
    }
}
