package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.location.LocationSettingsResult;

final class zzcr extends zzr {
    final /* synthetic */ BaseImplementation.ResultHolder zza;

    zzcr(BaseImplementation.ResultHolder resultHolder) {
        this.zza = resultHolder;
    }

    public final void zzb(LocationSettingsResult locationSettingsResult) {
        this.zza.setResult(locationSettingsResult);
    }
}
