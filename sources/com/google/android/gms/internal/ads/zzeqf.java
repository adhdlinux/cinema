package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.nonagon.signalgeneration.zzac;
import com.google.android.gms.ads.nonagon.signalgeneration.zzg;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzeqf implements zzeqy {
    private final String zza;
    private final zzfwn zzb;
    private final ScheduledExecutorService zzc;
    private final Context zzd;
    private final zzfai zze;
    private final zzcgu zzf;

    zzeqf(zzfwn zzfwn, ScheduledExecutorService scheduledExecutorService, String str, Context context, zzfai zzfai, zzcgu zzcgu) {
        this.zzb = zzfwn;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = context;
        this.zze = zzfai;
        this.zzf = zzcgu;
    }

    public static /* synthetic */ zzfwm zzc(zzeqf zzeqf) {
        String str = zzeqf.zza;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgT)).booleanValue()) {
            str = AdFormat.UNKNOWN.name();
        }
        zzg zzn = zzeqf.zzf.zzn();
        zzcuo zzcuo = new zzcuo();
        zzcuo.zze(zzeqf.zzd);
        zzfag zzfag = new zzfag();
        zzfag.zzs("adUnitId");
        zzfag.zzE(zzeqf.zze.zzd);
        zzfag.zzr(new zzq());
        zzcuo.zzi(zzfag.zzG());
        zzn.zza(zzcuo.zzj());
        zzac zzac = new zzac();
        zzac.zza(str);
        zzn.zzb(zzac.zzb());
        new zzdar();
        return zzfwc.zze(zzfwc.zzl((zzfvt) zzfwc.zzn(zzfvt.zzv(zzn.zzc().zzc()), ((Long) zzba.zzc().zzb(zzbbm.zzgU)).longValue(), TimeUnit.MILLISECONDS, zzeqf.zzc), zzeqd.zza, zzeqf.zzb), Exception.class, zzeqe.zza, zzeqf.zzb);
    }

    public final int zza() {
        return 33;
    }

    public final zzfwm zzb() {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzgS)).booleanValue() || "adUnitId".equals(this.zze.zzf)) {
            return zzfwc.zzh(new zzeqg((String) null));
        }
        return zzfwc.zzk(new zzeqc(this), this.zzb);
    }
}
