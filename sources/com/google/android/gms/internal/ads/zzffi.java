package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzffi implements zzfev {
    private final zzfff zza;
    private final zzffd zzb;

    public zzffi(zzfff zzfff, zzffd zzffd) {
        this.zza = zzfff;
        this.zzb = zzffd;
    }

    public final String zza(zzfeu zzfeu) {
        zzfff zzfff = this.zza;
        Map zzj = zzfeu.zzj();
        this.zzb.zza(zzj);
        return zzfff.zza(zzj);
    }

    public final void zzb(zzfeu zzfeu) {
    }
}
