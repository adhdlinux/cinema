package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

final class zzbhq implements zzbij {
    zzbhq() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zza;
        zzcez zzcez = (zzcez) obj;
        zzbee zzK = zzcez.zzK();
        if (zzK == null || (zza = zzK.zza()) == null) {
            zzcez.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcez.zze("nativeAdViewSignalsReady", zza);
        }
    }
}
