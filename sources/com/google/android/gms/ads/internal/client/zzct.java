package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.MuteThisAdListener;

public final class zzct extends zzcr {
    private final MuteThisAdListener zza;

    public zzct(MuteThisAdListener muteThisAdListener) {
        this.zza = muteThisAdListener;
    }

    public final void zze() {
        this.zza.onAdMuted();
    }
}
