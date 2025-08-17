package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbik implements zzbij {
    private final zzbil zza;

    public zzbik(zzbil zzbil) {
        this.zza = zzbil;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        float f2 = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f2 = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e2) {
            zzbzr.zzh("Fail to parse float", e2);
        }
        this.zza.zzc(equals);
        this.zza.zzb(equals2, f2);
        zzcez.zzat(equals);
    }
}
