package com.google.android.gms.internal.cast;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zztx {
    private static final zztx zza = new zztx();
    private final zzub zzb = new zzth();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    private zztx() {
    }

    public static zztx zza() {
        return zza;
    }

    public final zzua zzb(Class cls) {
        zzsq.zzc(cls, "messageType");
        zzua zzua = (zzua) this.zzc.get(cls);
        if (zzua == null) {
            zzua = this.zzb.zza(cls);
            zzsq.zzc(cls, "messageType");
            zzsq.zzc(zzua, "schema");
            zzua zzua2 = (zzua) this.zzc.putIfAbsent(cls, zzua);
            if (zzua2 == null) {
                return zzua;
            }
            return zzua2;
        }
        return zzua;
    }
}
