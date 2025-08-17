package com.google.android.gms.ads.h5;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbjn;

public final class H5AdsRequestHandler {
    private final zzbjn zza;

    public H5AdsRequestHandler(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = new zzbjn(context, onH5AdsEventListener);
    }

    public void clearAdObjects() {
        this.zza.zza();
    }

    public boolean handleH5AdsRequest(String str) {
        return this.zza.zzb(str);
    }

    public boolean shouldInterceptRequest(String str) {
        return zzbjn.zzc(str);
    }
}
