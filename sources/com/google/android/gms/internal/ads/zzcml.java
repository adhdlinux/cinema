package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.Map;

public final class zzcml implements zzcmj {
    private final zzg zza;

    public zzcml(zzg zzg) {
        this.zza = zzg;
    }

    public final void zza(Map map) {
        this.zza.zzx(Boolean.parseBoolean((String) map.get("content_url_opted_out")));
    }
}
