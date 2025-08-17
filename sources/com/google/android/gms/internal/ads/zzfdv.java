package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

public final class zzfdv {
    public static final zzfec zza(Callable callable, Object obj, zzfed zzfed) {
        return zzb(callable, zzfed.zzb, obj, zzfed);
    }

    public static final zzfec zzb(Callable callable, zzfwn zzfwn, Object obj, zzfed zzfed) {
        return new zzfec(zzfed, obj, (String) null, zzfed.zza, Collections.emptyList(), zzfwn.zzb(callable), (zzfeb) null);
    }

    public static final zzfec zzc(zzfwm zzfwm, Object obj, zzfed zzfed) {
        return new zzfec(zzfed, obj, (String) null, zzfed.zza, Collections.emptyList(), zzfwm, (zzfeb) null);
    }

    public static final zzfec zzd(zzfdp zzfdp, zzfwn zzfwn, Object obj, zzfed zzfed) {
        return zzb(new zzfdu(zzfdp), zzfwn, obj, zzfed);
    }
}
