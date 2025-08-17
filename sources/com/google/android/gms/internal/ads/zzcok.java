package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

public final class zzcok {
    private final zzfev zza;
    private final zzdqa zzb;
    private final zzezz zzc;

    public zzcok(zzdqa zzdqa, zzezz zzezz, zzfev zzfev) {
        this.zza = zzfev;
        this.zzb = zzdqa;
        this.zzc = zzezz;
    }

    private static String zzb(int i2) {
        int i3 = i2 - 1;
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "u" : "ac" : "cb" : "cc" : "bb" : "h";
    }

    public final void zza(long j2, int i2) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzig)).booleanValue()) {
            zzfev zzfev = this.zza;
            zzfeu zzb2 = zzfeu.zzb("ad_closed");
            zzb2.zzg(this.zzc.zzb.zzb);
            zzb2.zza("show_time", String.valueOf(j2));
            zzb2.zza("ad_format", "app_open_ad");
            zzb2.zza("acr", zzb(i2));
            zzfev.zzb(zzb2);
            return;
        }
        zzdpz zza2 = this.zzb.zza();
        zza2.zze(this.zzc.zzb.zzb);
        zza2.zzb("action", "ad_closed");
        zza2.zzb("show_time", String.valueOf(j2));
        zza2.zzb("ad_format", "app_open_ad");
        zza2.zzb("acr", zzb(i2));
        zza2.zzg();
    }
}
