package com.google.android.gms.internal.ads;

import com.facebook.hermes.intl.Constants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.internal.zzt;
import java.io.IOException;
import java.util.Map;

final class zzbhy implements zzbij {
    zzbhy() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        try {
            String str = (String) map.get(ViewProps.ENABLED);
            if (!zzfon.zzc("true", str)) {
                if (!zzfon.zzc(Constants.CASEFIRST_FALSE, str)) {
                    return;
                }
            }
            zzfmi.zzi(zzcez.getContext()).zzm(Boolean.parseBoolean(str));
        } catch (IOException e2) {
            zzt.zzo().zzu(e2, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
