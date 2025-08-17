package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzgre {
    private static final zzgre zza = new zzgre();
    private final zzgrq zzb = new zzgqo();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    private zzgre() {
    }

    public static zzgre zza() {
        return zza;
    }

    public final zzgrp zzb(Class cls) {
        zzgpw.zzc(cls, "messageType");
        zzgrp zzgrp = (zzgrp) this.zzc.get(cls);
        if (zzgrp == null) {
            zzgrp = this.zzb.zza(cls);
            zzgpw.zzc(cls, "messageType");
            zzgrp zzgrp2 = (zzgrp) this.zzc.putIfAbsent(cls, zzgrp);
            if (zzgrp2 == null) {
                return zzgrp;
            }
            return zzgrp2;
        }
        return zzgrp;
    }
}
