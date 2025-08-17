package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final /* synthetic */ class zzdkp implements zzaua {
    public final /* synthetic */ zzcez zza;

    public /* synthetic */ zzdkp(zzcez zzcez) {
        this.zza = zzcez;
    }

    public final void zzc(zzatz zzatz) {
        String str;
        zzcez zzcez = this.zza;
        HashMap hashMap = new HashMap();
        if (true != zzatz.zzj) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("isVisible", str);
        zzcez.zzd("onAdVisibilityChanged", hashMap);
    }
}
