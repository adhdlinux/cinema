package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

final class zzbhr implements zzbij {
    zzbhr() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zzb;
        zzcez zzcez = (zzcez) obj;
        zzbee zzK = zzcez.zzK();
        if (zzK == null || (zzb = zzK.zzb()) == null) {
            zzcez.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcez.zze("nativeClickMetaReady", zzb);
        }
    }
}
