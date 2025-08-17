package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzcd implements RemoteCall {
    public final /* synthetic */ LocationSettingsRequest zza;

    public /* synthetic */ zzcd(LocationSettingsRequest locationSettingsRequest) {
        this.zza = locationSettingsRequest;
    }

    public final void accept(Object obj, Object obj2) {
        boolean z2;
        LocationSettingsRequest locationSettingsRequest = this.zza;
        zzda zzda = (zzda) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        if (locationSettingsRequest != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "locationSettingsRequest can't be null");
        ((zzo) zzda.getService()).zzh(locationSettingsRequest, new zzcq(taskCompletionSource), (String) null);
    }
}
