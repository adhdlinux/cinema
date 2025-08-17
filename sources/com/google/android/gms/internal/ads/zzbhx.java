package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.io.IOException;
import java.util.Map;

final class zzbhx implements zzbij {
    zzbhx() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        try {
            zzfmh.zzj(zzcez.getContext()).zzk();
            zzfmi.zzi(zzcez.getContext()).zzj();
        } catch (IOException e2) {
            zzt.zzo().zzu(e2, "DefaultGmsgHandlers.ResetPaid");
        }
    }
}
