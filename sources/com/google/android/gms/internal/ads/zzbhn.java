package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;

public final /* synthetic */ class zzbhn implements zzbij {
    public static final /* synthetic */ zzbhn zza = new zzbhn();

    private /* synthetic */ zzbhn() {
    }

    public final void zza(Object obj, Map map) {
        String str;
        zzcga zzcga = (zzcga) obj;
        zzbij zzbij = zzbii.zza;
        String str2 = (String) map.get("urls");
        if (TextUtils.isEmpty(str2)) {
            zzbzr.zzj("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str2.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzcga.getContext().getPackageManager();
        for (String str3 : split) {
            String[] split2 = str3.split(";", 2);
            String trim = split2[0].trim();
            boolean z2 = true;
            if (split2.length > 1) {
                str = split2[1].trim();
            } else {
                str = "android.intent.action.VIEW";
            }
            if (packageManager.resolveActivity(new Intent(str, Uri.parse(trim)), 65536) == null) {
                z2 = false;
            }
            Boolean valueOf = Boolean.valueOf(z2);
            hashMap.put(str3, valueOf);
            zze.zza("/canOpenURLs;" + str3 + ";" + valueOf);
        }
        ((zzblc) zzcga).zzd("openableURLs", hashMap);
    }
}
