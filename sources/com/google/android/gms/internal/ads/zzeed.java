package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzeed implements zzfov {
    public final /* synthetic */ zzeef zza;
    public final /* synthetic */ zzcez zzb;
    public final /* synthetic */ zzezn zzc;
    public final /* synthetic */ zzddo zzd;

    public /* synthetic */ zzeed(zzeef zzeef, zzcez zzcez, zzezn zzezn, zzddo zzddo) {
        this.zza = zzeef;
        this.zzb = zzcez;
        this.zzc = zzezn;
        this.zzd = zzddo;
    }

    public final Object apply(Object obj) {
        zzcez zzcez = this.zzb;
        zzezn zzezn = this.zzc;
        zzddo zzddo = this.zzd;
        if (zzezn.zzN) {
            zzcez.zzae();
        }
        zzcez.zzY();
        zzcez.onPause();
        return zzddo.zzg();
    }
}
