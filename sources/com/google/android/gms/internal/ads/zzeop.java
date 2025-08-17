package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzeop implements zzeqx {
    public final zzezm zza;

    public zzeop(zzezm zzezm) {
        this.zza = zzezm;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzezm zzezm = this.zza;
        if (zzezm != null) {
            bundle.putBoolean("render_in_browser", zzezm.zzd());
            bundle.putBoolean("disable_ml", this.zza.zzc());
        }
    }
}
