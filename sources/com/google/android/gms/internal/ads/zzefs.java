package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

public final class zzefs {
    private final zzfax zza;
    private final zzdns zzb;
    private final zzdqa zzc;
    private final zzfev zzd;

    public zzefs(zzfax zzfax, zzdns zzdns, zzdqa zzdqa, zzfev zzfev) {
        this.zza = zzfax;
        this.zzb = zzdns;
        this.zzc = zzdqa;
        this.zzd = zzfev;
    }

    public final void zza(zzezq zzezq, zzezn zzezn, int i2, zzecg zzecg, long j2) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzig)).booleanValue()) {
            zzfeu zzb2 = zzfeu.zzb("adapter_status");
            zzb2.zzg(zzezq);
            zzb2.zzf(zzezn);
            zzb2.zza("adapter_l", String.valueOf(j2));
            zzb2.zza("sc", Integer.toString(i2));
            if (zzecg != null) {
                zzb2.zza("arec", Integer.toString(zzecg.zzb().zza));
                String zza2 = this.zza.zza(zzecg.getMessage());
                if (zza2 != null) {
                    zzb2.zza("areec", zza2);
                }
            }
            zzdnr zzb3 = this.zzb.zzb(zzezn.zzu);
            if (zzb3 != null) {
                zzb2.zza("ancn", zzb3.zza);
                zzbqh zzbqh = zzb3.zzb;
                if (zzbqh != null) {
                    zzb2.zza("adapter_v", zzbqh.toString());
                }
                zzbqh zzbqh2 = zzb3.zzc;
                if (zzbqh2 != null) {
                    zzb2.zza("adapter_sv", zzbqh2.toString());
                }
            }
            this.zzd.zzb(zzb2);
            return;
        }
        zzdpz zza3 = this.zzc.zza();
        zza3.zze(zzezq);
        zza3.zzd(zzezn);
        zza3.zzb("action", "adapter_status");
        zza3.zzb("adapter_l", String.valueOf(j2));
        zza3.zzb("sc", Integer.toString(i2));
        if (zzecg != null) {
            zza3.zzb("arec", Integer.toString(zzecg.zzb().zza));
            String zza4 = this.zza.zza(zzecg.getMessage());
            if (zza4 != null) {
                zza3.zzb("areec", zza4);
            }
        }
        zzdnr zzb4 = this.zzb.zzb(zzezn.zzu);
        if (zzb4 != null) {
            zza3.zzb("ancn", zzb4.zza);
            zzbqh zzbqh3 = zzb4.zzb;
            if (zzbqh3 != null) {
                zza3.zzb("adapter_v", zzbqh3.toString());
            }
            zzbqh zzbqh4 = zzb4.zzc;
            if (zzbqh4 != null) {
                zza3.zzb("adapter_sv", zzbqh4.toString());
            }
        }
        zza3.zzg();
    }
}
