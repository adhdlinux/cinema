package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbhd implements zzbij {
    private final zzbhe zza;

    public zzbhd(zzbhe zzbhe) {
        this.zza = zzbhe;
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get("name");
        if (str == null) {
            zzbzr.zzj("App event with no name parameter.");
        } else {
            this.zza.zzbz(str, (String) map.get("info"));
        }
    }
}
