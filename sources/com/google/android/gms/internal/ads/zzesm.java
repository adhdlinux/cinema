package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;

public final /* synthetic */ class zzesm implements zzfvj {
    public static final /* synthetic */ zzesm zza = new zzesm();

    private /* synthetic */ zzesm() {
    }

    public final zzfwm zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        if (appSetIdInfo == null) {
            return zzfwc.zzh(new zzesp((String) null, -1));
        }
        return zzfwc.zzh(new zzesp(appSetIdInfo.getId(), appSetIdInfo.getScope()));
    }
}
