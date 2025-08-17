package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;

public final class zzekw implements zzeqy {
    private final zzfwn zza;
    private final zzfai zzb;
    private final zzfau zzc;

    zzekw(zzfwn zzfwn, zzfai zzfai, zzfau zzfau) {
        this.zza = zzfwn;
        this.zzb = zzfai;
        this.zzc = zzfau;
    }

    public final int zza() {
        return 5;
    }

    public final zzfwm zzb() {
        return this.zza.zzb(new zzekv(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzekx zzc() throws Exception {
        String str = null;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgW)).booleanValue() && "requester_type_2".equals(zzf.zzb(this.zzb.zzd))) {
            str = zzfau.zza();
        }
        return new zzekx(str);
    }
}
