package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.UUID;
import org.json.JSONObject;

public final class zzcob implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzcob(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        String str = (String) this.zzc.zzb();
        boolean equals = "native".equals(str);
        zzt.zzp();
        return new zzatw(UUID.randomUUID().toString(), ((zzchm) this.zza).zza(), str, (JSONObject) this.zzb.zzb(), false, equals);
    }
}
