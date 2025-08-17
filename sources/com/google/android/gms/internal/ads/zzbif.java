package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzbif implements zzbij {
    zzbif() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzcez.zzbj();
        } else if ("resume".equals(str)) {
            zzcez.zzbk();
        }
    }
}
