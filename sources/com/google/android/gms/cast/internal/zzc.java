package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

public abstract class zzc extends BaseImplementation.ApiMethodImpl {
    public zzc(GoogleApiClient googleApiClient) {
        super((Api<?>) Cast.API, googleApiClient);
    }

    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }

    public final void zzc(int i2) {
        setResult(createFailedResult(new Status(2001)));
    }
}
