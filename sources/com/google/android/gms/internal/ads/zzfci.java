package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

public final class zzfci {
    private final HashMap zza = new HashMap();

    public final zzfch zza(zzfby zzfby, Context context, zzfbq zzfbq, zzfco zzfco) {
        zzfch zzfch = (zzfch) this.zza.get(zzfby);
        if (zzfch != null) {
            return zzfch;
        }
        zzfbv zzfbv = new zzfbv(zzfcb.zza(zzfby, context));
        zzfch zzfch2 = new zzfch(zzfbv, new zzfcq(zzfbv, zzfbq, zzfco));
        this.zza.put(zzfby, zzfch2);
        return zzfch2;
    }
}
