package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzeeh implements zzdew {
    private final zzezn zza;
    private final zzbpt zzb;
    private final AdFormat zzc;
    private zzcvy zzd = null;

    zzeeh(zzezn zzezn, zzbpt zzbpt, AdFormat adFormat) {
        this.zza = zzezn;
        this.zzb = zzbpt;
        this.zzc = adFormat;
    }

    public final void zza(boolean z2, Context context, zzcvt zzcvt) throws zzdev {
        boolean z3;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int ordinal = this.zzc.ordinal();
            if (ordinal == 1) {
                z3 = this.zzb.zzs(ObjectWrapper.wrap(context));
            } else if (ordinal != 2) {
                if (ordinal == 6) {
                    z3 = this.zzb.zzr(ObjectWrapper.wrap(context));
                }
                throw new zzdev("Adapter failed to show.");
            } else {
                z3 = this.zzb.zzt(ObjectWrapper.wrap(context));
            }
            if (z3) {
                if (this.zzd != null) {
                    if (!((Boolean) zzba.zzc().zzb(zzbbm.zzbs)).booleanValue() && this.zza.zzZ == 2) {
                        this.zzd.zza();
                        return;
                    }
                    return;
                }
                return;
            }
            throw new zzdev("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdev(th);
        }
    }

    public final void zzb(zzcvy zzcvy) {
        this.zzd = zzcvy;
    }
}
