package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventParameters;
import java.util.Map;

public final class zzbiz implements zzbij {
    private final zzbiy zza;

    public zzbiz(zzbiy zzbiy) {
        this.zza = zzbiy;
    }

    public static void zzb(zzcez zzcez, zzbiy zzbiy) {
        zzcez.zzad("/reward", new zzbiz(zzbiy));
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            zzbvg zzbvg = null;
            try {
                int parseInt = Integer.parseInt((String) map.get(AppLovinEventParameters.REVENUE_AMOUNT));
                String str2 = (String) map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzbvg = new zzbvg(str2, parseInt);
                }
            } catch (NumberFormatException e2) {
                zzbzr.zzk("Unable to parse reward amount.", e2);
            }
            this.zza.zza(zzbvg);
        } else if ("video_start".equals(str)) {
            this.zza.zzc();
        } else if ("video_complete".equals(str)) {
            this.zza.zzb();
        }
    }
}
