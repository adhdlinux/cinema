package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzems implements zzeqx {
    public final double zza;
    public final boolean zzb;

    public zzems(double d2, boolean z2) {
        this.zza = d2;
        this.zzb = z2;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzfat.zza(bundle, "device");
        bundle.putBundle("device", zza2);
        Bundle zza3 = zzfat.zza(zza2, "battery");
        zza2.putBundle("battery", zza3);
        zza3.putBoolean("is_charging", this.zzb);
        zza3.putDouble("battery_level", this.zza);
    }
}
