package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;

public final class zzexg implements zzgwe {
    private final zzgwr zza;
    private final zzgwr zzb;
    private final zzgwr zzc;

    public zzexg(zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3) {
        this.zza = zzgwr;
        this.zzb = zzgwr2;
        this.zzc = zzgwr3;
    }

    /* renamed from: zza */
    public final zzexe zzb() {
        zzbyu zzbyu;
        Context context = (Context) this.zza.zzb();
        zzfbq zzfbq = (zzfbq) this.zzb.zzb();
        zzfci zzfci = (zzfci) this.zzc.zzb();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzge)).booleanValue()) {
            zzbyu = zzt.zzo().zzh().zzh();
        } else {
            zzbyu = zzt.zzo().zzh().zzi();
        }
        boolean z2 = false;
        if (zzbyu != null && zzbyu.zzh()) {
            z2 = true;
        }
        if (((Integer) zzba.zzc().zzb(zzbbm.zzgu)).intValue() > 0) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzgd)).booleanValue() || z2) {
                zzfch zza2 = zzfci.zza(zzfby.AppOpen, context, zzfbq, new zzewi(new zzewf()));
                zzewu zzewu = new zzewu(new zzewt());
                zzfbu zzfbu = zza2.zza;
                zzfwn zzfwn = zzcae.zza;
                return new zzewk(zzewu, new zzewq(zzfbu, zzfwn), zza2.zzb, zza2.zza.zza().zzf, zzfwn);
            }
        }
        return new zzewt();
    }
}
