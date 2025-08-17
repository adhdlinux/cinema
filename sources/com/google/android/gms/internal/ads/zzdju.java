package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdju implements zzfvj {
    public final /* synthetic */ zzfwm zza;

    public /* synthetic */ zzdju(zzfwm zzfwm) {
        this.zza = zzfwm;
    }

    public final zzfwm zza(Object obj) {
        zzfwm zzfwm = this.zza;
        if (((zzcez) obj) != null) {
            return zzfwm;
        }
        throw new zzefu(1, "Retrieve Web View from image ad response failed.");
    }
}
