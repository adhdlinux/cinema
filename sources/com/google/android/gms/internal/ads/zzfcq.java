package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import java.util.ArrayDeque;

public final class zzfcq {
    private final zzfbu zza;
    private final zzfco zzb;
    private final zzfbq zzc;
    /* access modifiers changed from: private */
    public final ArrayDeque zzd;
    /* access modifiers changed from: private */
    public zzfcw zze;
    /* access modifiers changed from: private */
    public int zzf = 1;

    public zzfcq(zzfbu zzfbu, zzfbq zzfbq, zzfco zzfco) {
        this.zza = zzfbu;
        this.zzc = zzfbq;
        this.zzb = zzfco;
        this.zzd = new ArrayDeque();
        zzfbq.zzb(new zzfcl(this));
    }

    /* access modifiers changed from: private */
    public final synchronized void zzh() {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzgc)).booleanValue()) {
            if (!zzt.zzo().zzh().zzh().zzh()) {
                this.zzd.clear();
                return;
            }
        }
        if (zzi()) {
            while (!this.zzd.isEmpty()) {
                zzfcp zzfcp = (zzfcp) this.zzd.pollFirst();
                if (zzfcp == null || (zzfcp.zza() != null && this.zza.zze(zzfcp.zza()))) {
                    zzfcw zzfcw = new zzfcw(this.zza, this.zzb, zzfcp);
                    this.zze = zzfcw;
                    zzfcw.zzd(new zzfcm(this, zzfcp));
                    return;
                }
            }
        }
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized zzfwm zza(zzfcp zzfcp) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zza(zzfcp);
    }

    public final synchronized void zze(zzfcp zzfcp) {
        this.zzd.add(zzfcp);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        synchronized (this) {
            this.zzf = 1;
            zzh();
        }
    }
}
