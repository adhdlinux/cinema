package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;

public final /* synthetic */ class zzema implements zzfvj {
    public static final /* synthetic */ zzema zza = new zzema();

    private /* synthetic */ zzema() {
    }

    public final zzfwm zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        if (appSetIdInfo == null) {
            return zzfwc.zzh(new zzemd((String) null, -1));
        }
        return zzfwc.zzh(new zzemd(appSetIdInfo.getId(), appSetIdInfo.getScope()));
    }
}
