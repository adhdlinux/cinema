package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

public final class zzcnb implements zzcmj {
    private final zzdsx zza;

    zzcnb(zzdsx zzdsx) {
        this.zza = zzdsx;
    }

    public final void zza(Map map) {
        String str = (String) map.get("test_mode_enabled");
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzm(str.equals("true"));
        }
    }
}
