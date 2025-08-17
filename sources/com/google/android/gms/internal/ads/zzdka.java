package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdka implements zzfvj {
    public final /* synthetic */ zzfwm zza;

    public /* synthetic */ zzdka(zzfwm zzfwm) {
        this.zza = zzfwm;
    }

    public final zzfwm zza(Object obj) {
        zzfwm zzfwm = this.zza;
        zzcez zzcez = (zzcez) obj;
        if (zzcez != null && zzcez.zzq() != null) {
            return zzfwm;
        }
        throw new zzefu(1, "Retrieve video view in html5 ad response failed.");
    }
}
