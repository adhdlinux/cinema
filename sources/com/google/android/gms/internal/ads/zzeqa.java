package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzeqa implements zzeqx {
    private final String zza;
    private final Bundle zzb;

    public zzeqa(String str, Bundle bundle) {
        this.zza = str;
        this.zzb = bundle;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("rtb", this.zza);
        if (!this.zzb.isEmpty()) {
            bundle.putBundle("adapter_initialization_status", this.zzb);
        }
    }
}
