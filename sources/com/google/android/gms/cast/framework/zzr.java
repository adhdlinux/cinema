package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzr extends zzad {
    private final CastStateListener zza;

    public zzr(CastStateListener castStateListener) {
        this.zza = castStateListener;
    }

    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final void zzc(int i2) {
        this.zza.onCastStateChanged(i2);
    }
}
