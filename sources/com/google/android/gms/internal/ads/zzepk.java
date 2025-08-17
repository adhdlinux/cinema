package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzepk implements zzeqx {
    private final Bundle zza;

    public zzepk(Bundle bundle) {
        this.zza = bundle;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle bundle2 = this.zza;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }
}
