package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcnd implements zzcwb {
    private final zzfbd zza;

    public zzcnd(zzfbd zzfbd) {
        this.zza = zzfbd;
    }

    public final void zzbn(Context context) {
        try {
            this.zza.zzg();
        } catch (zzfan e2) {
            zzbzr.zzk("Cannot invoke onDestroy for the mediation adapter.", e2);
        }
    }

    public final void zzbp(Context context) {
        try {
            this.zza.zzt();
        } catch (zzfan e2) {
            zzbzr.zzk("Cannot invoke onPause for the mediation adapter.", e2);
        }
    }

    public final void zzbq(Context context) {
        try {
            this.zza.zzu();
            if (context != null) {
                this.zza.zzs(context);
            }
        } catch (zzfan e2) {
            zzbzr.zzk("Cannot invoke onResume for the mediation adapter.", e2);
        }
    }
}
