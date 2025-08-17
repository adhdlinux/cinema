package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzby;
import java.util.Map;

public final /* synthetic */ class zzbhm implements zzbij {
    public static final /* synthetic */ zzbhm zza = new zzbhm();

    private /* synthetic */ zzbhm() {
    }

    public final void zza(Object obj, Map map) {
        zzcga zzcga = (zzcga) obj;
        zzbij zzbij = zzbii.zza;
        String str = (String) map.get("u");
        if (str == null) {
            zzbzr.zzj("URL missing from httpTrack GMSG.");
        } else {
            new zzby(zzcga.getContext(), ((zzcgi) zzcga).zzn().zza, str).zzb();
        }
    }
}
