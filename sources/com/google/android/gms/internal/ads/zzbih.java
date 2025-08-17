package com.google.android.gms.internal.ads;

import com.facebook.react.uimanager.ViewProps;
import java.util.Map;

final class zzbih implements zzbij {
    zzbih() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        if (map.keySet().contains(ViewProps.START)) {
            zzcez.zzas(true);
        }
        if (map.keySet().contains("stop")) {
            zzcez.zzas(false);
        }
    }
}
