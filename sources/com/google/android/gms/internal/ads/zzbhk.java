package com.google.android.gms.internal.ads;

import java.util.Map;

public final /* synthetic */ class zzbhk implements zzbij {
    public final /* synthetic */ zzdcu zza;

    public /* synthetic */ zzbhk(zzdcu zzdcu) {
        this.zza = zzdcu;
    }

    public final void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        zzbii.zzc(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            zzbzr.zzj("URL missing from click GMSG.");
        } else {
            zzfwc.zzq(zzbii.zza(zzcez, str), new zzbhz(zzcez), zzcae.zza);
        }
    }
}
