package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzefy {
    private zzefr zza;

    zzefy() {
    }

    private zzefy(zzefr zzefr) {
        this.zza = zzefr;
    }

    public static zzefy zzb(zzefr zzefr) {
        return new zzefy(zzefr);
    }

    public final zzefr zza(Clock clock, zzefs zzefs, zzech zzech, zzfgr zzfgr) {
        zzefr zzefr = this.zza;
        return zzefr != null ? zzefr : new zzefr(clock, zzefs, zzech, zzfgr);
    }
}
