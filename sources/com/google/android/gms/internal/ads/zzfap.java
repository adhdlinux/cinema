package com.google.android.gms.internal.ads;

import java.util.Map;

public final /* synthetic */ class zzfap implements zzbij {
    public final /* synthetic */ zzdcu zza;
    public final /* synthetic */ zzfgr zzb;
    public final /* synthetic */ zzeba zzc;

    public /* synthetic */ zzfap(zzdcu zzdcu, zzfgr zzfgr, zzeba zzeba) {
        this.zza = zzdcu;
        this.zzb = zzfgr;
        this.zzc = zzeba;
    }

    public final void zza(Object obj, Map map) {
        zzdcu zzdcu = this.zza;
        zzfgr zzfgr = this.zzb;
        zzeba zzeba = this.zzc;
        zzcez zzcez = (zzcez) obj;
        zzbii.zzc(map, zzdcu);
        String str = (String) map.get("u");
        if (str == null) {
            zzbzr.zzj("URL missing from click GMSG.");
        } else {
            zzfwc.zzq(zzbii.zza(zzcez, str), new zzfaq(zzcez, zzfgr, zzeba), zzcae.zza);
        }
    }
}
