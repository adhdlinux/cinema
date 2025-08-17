package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.io.InputStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzduw {
    private final ScheduledExecutorService zza;
    private final zzfwn zzb;
    private final zzfwn zzc;
    private final zzdvn zzd;
    private final zzgvy zze;

    public zzduw(ScheduledExecutorService scheduledExecutorService, zzfwn zzfwn, zzfwn zzfwn2, zzdvn zzdvn, zzgvy zzgvy) {
        this.zza = scheduledExecutorService;
        this.zzb = zzfwn;
        this.zzc = zzfwn2;
        this.zzd = zzdvn;
        this.zze = zzgvy;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zza(zzbue zzbue, int i2, Throwable th) throws Exception {
        return ((zzdyh) this.zze.zzb()).zzd(zzbue, i2);
    }

    public final zzfwm zzb(zzbue zzbue) {
        zzfwm zzfwm;
        String str = zzbue.zzd;
        zzt.zzp();
        if (zzs.zzy(str)) {
            zzfwm = zzfwc.zzg(new zzdwa(1));
        } else {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzhn)).booleanValue()) {
                zzfwm = this.zzc.zzb(new zzduu(this, zzbue));
            } else {
                zzfwm = this.zzd.zzb(zzbue);
            }
        }
        int callingUid = Binder.getCallingUid();
        return zzfwc.zzf((zzfvt) zzfwc.zzn(zzfvt.zzv(zzfwm), (long) ((Integer) zzba.zzc().zzb(zzbbm.zzfm)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzduv(this, zzbue, callingUid), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzc(zzbue zzbue) throws Exception {
        return (InputStream) this.zzd.zzb(zzbue).get((long) ((Integer) zzba.zzc().zzb(zzbbm.zzfm)).intValue(), TimeUnit.SECONDS);
    }
}
