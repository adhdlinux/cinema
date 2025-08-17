package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzeug implements zzeqy {
    private final zzbza zza;
    private final boolean zzb;
    private final boolean zzc;
    private final ScheduledExecutorService zzd;
    private final zzfwn zze;
    private final String zzf;
    private final zzbyp zzg;

    zzeug(zzbza zzbza, boolean z2, boolean z3, zzbyp zzbyp, zzfwn zzfwn, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzbza;
        this.zzb = z2;
        this.zzc = z3;
        this.zzg = zzbyp;
        this.zze = zzfwn;
        this.zzf = str;
        this.zzd = scheduledExecutorService;
    }

    public final int zza() {
        return 50;
    }

    public final zzfwm zzb() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgV)).booleanValue() && this.zzc) {
            return zzfwc.zzh((Object) null);
        }
        if (!this.zzb) {
            return zzfwc.zzh((Object) null);
        }
        return zzfwc.zze(zzfwc.zzn(zzfwc.zzl(zzfwc.zzh((Object) null), zzeue.zza, this.zze), ((Long) zzbds.zzc.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd), Exception.class, new zzeuf(this), this.zze);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeuh zzc(Exception exc) {
        this.zza.zzu(exc, "TrustlessTokenSignal");
        return null;
    }
}
