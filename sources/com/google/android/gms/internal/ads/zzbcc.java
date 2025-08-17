package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public final class zzbcc {
    private final Map zza = new HashMap();
    private final zzbce zzb;

    public zzbcc(zzbce zzbce) {
        this.zzb = zzbce;
    }

    public final zzbce zza() {
        return this.zzb;
    }

    public final void zzb(String str, zzbcb zzbcb) {
        this.zza.put(str, zzbcb);
    }

    public final void zzc(String str, String str2, long j2) {
        zzbce zzbce = this.zzb;
        zzbcb zzbcb = (zzbcb) this.zza.get(str2);
        String[] strArr = {str};
        if (zzbcb != null) {
            zzbce.zze(zzbcb, j2, strArr);
        }
        this.zza.put(str, new zzbcb(j2, (String) null, (zzbcb) null));
    }
}
