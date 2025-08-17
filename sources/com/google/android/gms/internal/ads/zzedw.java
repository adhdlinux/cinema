package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzedw implements zzecc {
    /* access modifiers changed from: private */
    public final zzcpy zza;
    private final zzedd zzb;
    private final zzfwn zzc;
    /* access modifiers changed from: private */
    public final zzcvi zzd;
    private final ScheduledExecutorService zze;

    public zzedw(zzcpy zzcpy, zzedd zzedd, zzcvi zzcvi, ScheduledExecutorService scheduledExecutorService, zzfwn zzfwn) {
        this.zza = zzcpy;
        this.zzb = zzedd;
        this.zzd = zzcvi;
        this.zze = scheduledExecutorService;
        this.zzc = zzfwn;
    }

    public final zzfwm zza(zzezz zzezz, zzezn zzezn) {
        return this.zzc.zzb(new zzedt(this, zzezz, zzezn));
    }

    public final boolean zzb(zzezz zzezz, zzezn zzezn) {
        if (zzezz.zza.zza.zza() == null || !this.zzb.zzb(zzezz, zzezn)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcpb zzc(zzezz zzezz, zzezn zzezn) throws Exception {
        return this.zza.zzb(new zzcrs(zzezz, zzezn, (String) null), new zzcql(zzezz.zza.zza.zza(), new zzedu(this, zzezz, zzezn))).zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzezz zzezz, zzezn zzezn) {
        zzfwc.zzq(zzfwc.zzn(this.zzb.zza(zzezz, zzezn), (long) zzezn.zzS, TimeUnit.SECONDS, this.zze), new zzedv(this), this.zzc);
    }
}
