package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzca;
import java.util.Map;

final class zzblx implements zzbij {
    final /* synthetic */ zzblg zza;
    final /* synthetic */ zzca zzb;
    final /* synthetic */ zzbml zzc;

    zzblx(zzbml zzbml, zzaqs zzaqs, zzblg zzblg, zzca zzca) {
        this.zzc = zzbml;
        this.zza = zzblg;
        this.zzb = zzca;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzbij, java.lang.Object] */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbmm zzbmm = (zzbmm) obj;
        synchronized (this.zzc.zza) {
            zzbzr.zzi("JS Engine is requesting an update");
            if (this.zzc.zzi == 0) {
                zzbzr.zzi("Starting reload.");
                this.zzc.zzi = 2;
                this.zzc.zzd((zzaqs) null);
            }
            this.zza.zzr("/requestReload", this.zzb.zza());
        }
    }
}
