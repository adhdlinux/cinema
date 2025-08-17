package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzeso implements zzeqy {
    private final zzbza zza;
    private final String zzb;
    private final ScheduledExecutorService zzc;
    private final zzfwn zzd;
    private final zzawc zze;

    zzeso(String str, zzawc zzawc, zzbza zzbza, ScheduledExecutorService scheduledExecutorService, zzfwn zzfwn) {
        this.zzb = str;
        this.zze = zzawc;
        this.zza = zzbza;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfwn;
    }

    public final int zza() {
        return 43;
    }

    public final zzfwm zzb() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzcu)).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzcz)).booleanValue()) {
                zzfwm zzm = zzfwc.zzm(zzfml.zza(Tasks.forResult(null)), zzesm.zza, this.zzd);
                if (((Boolean) zzbcu.zza.zze()).booleanValue()) {
                    zzm = zzfwc.zzn(zzm, ((Long) zzbcu.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzfwc.zze(zzm, Exception.class, new zzesn(this), this.zzd);
            }
        }
        return zzfwc.zzh(new zzesp((String) null, -1));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzesp zzc(Exception exc) {
        this.zza.zzu(exc, "AppSetIdInfoGmscoreSignal");
        return new zzesp((String) null, -1);
    }
}
