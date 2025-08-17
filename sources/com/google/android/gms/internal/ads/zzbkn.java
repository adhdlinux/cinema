package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

public final class zzbkn implements AdapterStatus {
    private final AdapterStatus.State zza;
    private final String zzb;
    private final int zzc;

    public zzbkn(AdapterStatus.State state, String str, int i2) {
        this.zza = state;
        this.zzb = str;
        this.zzc = i2;
    }

    public final String getDescription() {
        return this.zzb;
    }

    public final AdapterStatus.State getInitializationState() {
        return this.zza;
    }

    public final int getLatency() {
        return this.zzc;
    }
}
