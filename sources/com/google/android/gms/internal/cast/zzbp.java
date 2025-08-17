package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class zzbp extends BasePendingResult {
    private final zzbq zza;

    zzbp(zzbq zzbq) {
        super((GoogleApiClient) null);
        this.zza = zzbq;
    }

    /* access modifiers changed from: protected */
    public final Result createFailedResult(Status status) {
        int i2 = CastSession.zza;
        return status;
    }
}
