package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzcrr {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzfwm zzc;
    private volatile boolean zzd = true;

    public zzcrr(Executor executor, ScheduledExecutorService scheduledExecutorService, zzfwm zzfwm) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzfwm;
    }

    static /* bridge */ /* synthetic */ void zzb(zzcrr zzcrr, List list, zzfvy zzfvy) {
        if (list == null || list.isEmpty()) {
            zzcrr.zza.execute(new zzcrl(zzfvy));
            return;
        }
        zzfwm zzh = zzfwc.zzh((Object) null);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            zzh = zzfwc.zzm(zzfwc.zzf(zzh, Throwable.class, new zzcrm(zzfvy), zzcrr.zza), new zzcrn(zzcrr, zzfvy, (zzfwm) it2.next()), zzcrr.zza);
        }
        zzfwc.zzq(zzh, new zzcrq(zzcrr, zzfvy), zzcrr.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zza(zzfvy zzfvy, zzfwm zzfwm, zzcrd zzcrd) throws Exception {
        if (zzcrd != null) {
            zzfvy.zzb(zzcrd);
        }
        return zzfwc.zzn(zzfwm, ((Long) zzbdr.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final void zze(zzfvy zzfvy) {
        zzfwc.zzq(this.zzc, new zzcrp(this, zzfvy), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
