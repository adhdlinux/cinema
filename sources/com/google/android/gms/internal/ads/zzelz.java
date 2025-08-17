package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;

public final /* synthetic */ class zzelz implements zzfov {
    public static final /* synthetic */ zzelz zza = new zzelz();

    private /* synthetic */ zzelz() {
    }

    public final Object apply(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        return new zzemd(appSetIdInfo.getId(), appSetIdInfo.getScope());
    }
}
