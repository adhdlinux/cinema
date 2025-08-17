package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class zzfjq implements OnFailureListener {
    public final /* synthetic */ zzfju zza;

    public /* synthetic */ zzfjq(zzfju zzfju) {
        this.zza = zzfju;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzf(exc);
    }
}
