package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

public final class zzdix implements zzcwa {
    private final zzdha zza;
    private final zzdhf zzb;

    public zzdix(zzdha zzdha, zzdhf zzdhf) {
        this.zza = zzdha;
        this.zzb = zzdhf;
    }

    public final void zzl() {
        zzdha zzdha = this.zza;
        if (zzdha.zzt() != null) {
            zzcez zzq = zzdha.zzq();
            zzcez zzr = zzdha.zzr();
            if (zzq == null) {
                zzq = zzr == null ? null : zzr;
            }
            if (this.zzb.zzd() && zzq != null) {
                zzq.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }
}
