package com.google.android.gms.internal.ads;

import java.util.Map;

public final /* synthetic */ class zzbhl implements zzbij {
    public static final /* synthetic */ zzbhl zza = new zzbhl();

    private /* synthetic */ zzbhl() {
    }

    public final void zza(Object obj, Map map) {
        zzcgh zzcgh = (zzcgh) obj;
        zzbij zzbij = zzbii.zza;
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzaqs zzI = zzcgh.zzI();
            if (zzI != null) {
                zzI.zzc().zzl(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzbzr.zzj("Could not parse touch parameters from gmsg.");
        }
    }
}
