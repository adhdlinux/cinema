package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

public final class zzcxa extends zzdaq implements zzbhc {
    private final Bundle zzb = new Bundle();

    zzcxa(Set set) {
        super(set);
    }

    public final synchronized void zza(String str, Bundle bundle) {
        this.zzb.putAll(bundle);
        zzp(zzcwz.zza);
    }

    public final synchronized Bundle zzb() {
        return new Bundle(this.zzb);
    }
}
