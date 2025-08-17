package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;

public final /* synthetic */ class zzbho implements zzbij {
    public static final /* synthetic */ zzbho zza = new zzbho();

    private /* synthetic */ zzbho() {
    }

    public final void zza(Object obj, Map map) {
        boolean z2;
        zzcga zzcga = (zzcga) obj;
        zzbij zzbij = zzbii.zza;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzhN)).booleanValue()) {
            zzbzr.zzj("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get("package_name");
        if (TextUtils.isEmpty(str)) {
            zzbzr.zzj("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        if (zzcga.getContext().getPackageManager().getLaunchIntentForPackage(str) != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Boolean valueOf = Boolean.valueOf(z2);
        hashMap.put(str, valueOf);
        zze.zza("/canOpenApp;" + str + ";" + valueOf);
        ((zzblc) zzcga).zzd("openableApp", hashMap);
    }
}
