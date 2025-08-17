package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.List;

final class zzcnk implements zzfvy {
    final /* synthetic */ zzcnm zza;

    zzcnk(zzcnm zzcnm) {
        this.zza = zzcnm;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcnm zzcnm = this.zza;
        zzfar zzd = zzcnm.zzh;
        List zzd2 = zzcnm.zzg.zzd(zzcnm.zze, zzcnm.zzf, false, "", (String) obj, zzcnm.zzf.zzc);
        int i2 = 1;
        if (true == zzt.zzo().zzx(this.zza.zza)) {
            i2 = 2;
        }
        zzd.zzc(zzd2, i2);
    }
}
