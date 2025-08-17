package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;

public final class zzdzf implements zzdbz {
    private boolean zza = false;
    private boolean zzb = false;
    private final String zzc;
    private final zzfev zzd;
    private final zzg zze;

    public zzdzf(String str, zzfev zzfev) {
        this.zzc = str;
        this.zzd = zzfev;
        this.zze = zzt.zzo().zzh();
    }

    private final zzfeu zzg(String str) {
        String str2;
        if (this.zze.zzP()) {
            str2 = "";
        } else {
            str2 = this.zzc;
        }
        zzfeu zzb2 = zzfeu.zzb(str);
        zzb2.zza("tms", Long.toString(zzt.zzB().elapsedRealtime(), 10));
        zzb2.zza(ScarConstants.TOKEN_ID_KEY, str2);
        return zzb2;
    }

    public final void zza(String str) {
        zzfev zzfev = this.zzd;
        zzfeu zzg = zzg("aaia");
        zzg.zza("aair", "MalformedJson");
        zzfev.zzb(zzg);
    }

    public final void zzb(String str, String str2) {
        zzfev zzfev = this.zzd;
        zzfeu zzg = zzg("adapter_init_finished");
        zzg.zza("ancn", str);
        zzg.zza("rqe", str2);
        zzfev.zzb(zzg);
    }

    public final void zzc(String str) {
        zzfev zzfev = this.zzd;
        zzfeu zzg = zzg("adapter_init_started");
        zzg.zza("ancn", str);
        zzfev.zzb(zzg);
    }

    public final void zzd(String str) {
        zzfev zzfev = this.zzd;
        zzfeu zzg = zzg("adapter_init_finished");
        zzg.zza("ancn", str);
        zzfev.zzb(zzg);
    }

    public final synchronized void zze() {
        if (!this.zzb) {
            this.zzd.zzb(zzg("init_finished"));
            this.zzb = true;
        }
    }

    public final synchronized void zzf() {
        if (!this.zza) {
            this.zzd.zzb(zzg("init_started"));
            this.zza = true;
        }
    }
}
