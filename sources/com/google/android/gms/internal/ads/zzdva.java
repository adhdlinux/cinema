package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.regex.Matcher;

final class zzdva implements zzfvy {
    final /* synthetic */ zzdvb zza;

    zzdva(zzdvb zzdvb) {
        this.zza = zzdvb;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfW)).booleanValue()) {
            Matcher matcher = zzdvb.zza.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zza.zzf.zzi(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzezz zzezz = (zzezz) obj;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfW)).booleanValue()) {
            this.zza.zzf.zzi(zzezz.zzb.zzb.zze);
            this.zza.zzf.zzj(zzezz.zzb.zzb.zzf);
        }
    }
}
