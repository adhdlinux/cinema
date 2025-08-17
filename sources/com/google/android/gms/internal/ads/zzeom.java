package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzeom implements zzeqx {
    public final Bundle zza;

    public zzeom(Bundle bundle) {
        this.zza = bundle;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzfat.zza(bundle, "device");
        zza2.putBundle("android_mem_info", this.zza);
        bundle.putBundle("device", zza2);
    }
}
