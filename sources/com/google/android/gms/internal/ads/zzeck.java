package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzeck implements zzfov {
    public final /* synthetic */ zzecn zza;
    public final /* synthetic */ zzcez zzb;
    public final /* synthetic */ zzezn zzc;
    public final /* synthetic */ zzcom zzd;

    public /* synthetic */ zzeck(zzecn zzecn, zzcez zzcez, zzezn zzezn, zzcom zzcom) {
        this.zza = zzecn;
        this.zzb = zzcez;
        this.zzc = zzezn;
        this.zzd = zzcom;
    }

    public final Object apply(Object obj) {
        zzcez zzcez = this.zzb;
        zzezn zzezn = this.zzc;
        zzcom zzcom = this.zzd;
        if (zzezn.zzN) {
            zzcez.zzae();
        }
        zzcez.zzY();
        zzcez.onPause();
        return zzcom.zza();
    }
}
