package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.UUID;
import org.json.JSONObject;

public final class zzdgg implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;

    public zzdgg(zzgwr zzgwr, zzgwr zzgwr2) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbzx zza2 = ((zzchm) this.zza).zza();
        zzt.zzp();
        return new zzatw(UUID.randomUUID().toString(), zza2, "native", new JSONObject(), false, true);
    }
}
