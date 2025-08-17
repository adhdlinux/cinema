package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;

public final /* synthetic */ class zzbhj implements zzfov {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzbhj(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        String str = this.zza;
        Throwable th = (Throwable) obj;
        zzbij zzbij = zzbii.zza;
        if (((Boolean) zzbde.zzk.zze()).booleanValue()) {
            zzt.zzo().zzu(th, "prepareClickUrl.attestation2");
        }
        return str;
    }
}
