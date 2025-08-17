package com.google.android.gms.cast.framework.media;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class zzbh extends BasePendingResult {
    zzbh() {
        super((GoogleApiClient) null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzbg(this, status);
    }
}
