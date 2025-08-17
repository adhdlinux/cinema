package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzemc implements zzeqy {
    final zzbza zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzfwn zzd;
    private final Context zze;

    zzemc(Context context, zzbza zzbza, ScheduledExecutorService scheduledExecutorService, zzfwn zzfwn) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzcy)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzbza;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfwn;
    }

    public final int zza() {
        return 11;
    }

    public final zzfwm zzb() {
        Task<AppSetIdInfo> task;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcu)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzcz)).booleanValue()) {
                if (!((Boolean) zzba.zzc().zzb(zzbbm.zzcv)).booleanValue()) {
                    return zzfwc.zzl(zzfml.zza(this.zzb.getAppSetIdInfo()), zzelz.zza, zzcae.zzf);
                }
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzcy)).booleanValue()) {
                    task = zzfbl.zza(this.zze);
                } else {
                    task = this.zzb.getAppSetIdInfo();
                }
                if (task == null) {
                    return zzfwc.zzh(new zzemd((String) null, -1));
                }
                zzfwm zzm = zzfwc.zzm(zzfml.zza(task), zzema.zza, zzcae.zzf);
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzcw)).booleanValue()) {
                    zzm = zzfwc.zzn(zzm, ((Long) zzba.zzc().zzb(zzbbm.zzcx)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzfwc.zze(zzm, Exception.class, new zzemb(this), this.zzd);
            }
        }
        return zzfwc.zzh(new zzemd((String) null, -1));
    }
}
