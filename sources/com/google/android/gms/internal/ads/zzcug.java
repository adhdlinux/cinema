package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

final class zzcug implements zzcwu, zzcwb {
    private final Context zza;
    private final zzezn zzb;
    private final zzbry zzc;

    public zzcug(Context context, zzezn zzezn, zzbry zzbry) {
        this.zza = context;
        this.zzb = zzezn;
        this.zzc = zzbry;
    }

    public final void zzbn(Context context) {
    }

    public final void zzbp(Context context) {
    }

    public final void zzbq(Context context) {
    }

    public final void zzn() {
        zzbrz zzbrz = this.zzb.zzae;
        if (zzbrz != null && zzbrz.zza) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzb.zzae.zzb.isEmpty()) {
                arrayList.add(this.zzb.zzae.zzb);
            }
        }
    }
}
