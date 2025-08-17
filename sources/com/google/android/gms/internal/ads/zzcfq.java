package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

final class zzcfq implements zzbij {
    final /* synthetic */ zzcfs zza;

    zzcfq(zzcfs zzcfs) {
        this.zza = zzcfs;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zza) {
                        zzcfs zzcfs = this.zza;
                        if (zzcfs.zzG != parseInt) {
                            zzcfs.zzG = parseInt;
                            this.zza.requestLayout();
                        }
                    }
                } catch (Exception e2) {
                    zzbzr.zzk("Exception occurred while getting webview content height", e2);
                }
            }
        }
    }
}
