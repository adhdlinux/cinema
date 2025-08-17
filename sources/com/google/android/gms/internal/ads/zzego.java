package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzego implements zzfov {
    public final /* synthetic */ zzegs zza;
    public final /* synthetic */ zzcez zzb;
    public final /* synthetic */ zzezn zzc;
    public final /* synthetic */ zzdmn zzd;

    public /* synthetic */ zzego(zzegs zzegs, zzcez zzcez, zzezn zzezn, zzdmn zzdmn) {
        this.zza = zzegs;
        this.zzb = zzcez;
        this.zzc = zzezn;
        this.zzd = zzdmn;
    }

    public final Object apply(Object obj) {
        zzcez zzcez = this.zzb;
        zzezn zzezn = this.zzc;
        zzdmn zzdmn = this.zzd;
        if (zzezn.zzN) {
            zzcez.zzae();
        }
        zzcez.zzY();
        zzcez.onPause();
        return zzdmn.zzk();
    }
}
