package com.google.android.gms.internal.ads;

import com.facebook.react.uimanager.ViewProps;
import java.util.Map;

final class zzbig implements zzbij {
    zzbig() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        if (map.keySet().contains(ViewProps.START)) {
            zzcez.zzN().zzl();
        } else if (map.keySet().contains("stop")) {
            zzcez.zzN().zzm();
        } else if (map.keySet().contains("cancel")) {
            zzcez.zzN().zzk();
        }
    }
}
