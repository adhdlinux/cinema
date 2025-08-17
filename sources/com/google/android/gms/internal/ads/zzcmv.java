package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

public final class zzcmv implements zzcmj {
    private final zzezm zza;

    public zzcmv(zzezm zzezm) {
        this.zza = zzezm;
    }

    public final void zza(Map map) {
        String str = (String) map.get("render_in_browser");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.zza.zzb(Boolean.parseBoolean(str));
            } catch (Exception e2) {
                throw new IllegalStateException("Invalid render_in_browser state", e2);
            }
        }
    }
}
