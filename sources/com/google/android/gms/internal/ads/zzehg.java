package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;

final class zzehg implements zzcwp {
    boolean zza = false;
    final /* synthetic */ zzecf zzb;
    final /* synthetic */ zzcaj zzc;
    final /* synthetic */ zzehh zzd;

    zzehg(zzehh zzehh, zzecf zzecf, zzcaj zzcaj) {
        this.zzd = zzehh;
        this.zzb = zzecf;
        this.zzc = zzcaj;
    }

    private final synchronized void zze(zze zze) {
        int i2 = 1;
        if (true == ((Boolean) zzba.zzc().zzb(zzbbm.zzfi)).booleanValue()) {
            i2 = 3;
        }
        this.zzc.zze(new zzecg(i2, zze));
    }

    public final synchronized void zza(int i2) {
        if (!this.zza) {
            this.zza = true;
            zze(new zze(i2, zzehh.zze(this.zzb.zza, i2), "undefined", (zze) null, (IBinder) null));
        }
    }

    public final synchronized void zzb(zze zze) {
        if (!this.zza) {
            this.zza = true;
            zze(zze);
        }
    }

    public final synchronized void zzc(int i2, String str) {
        if (!this.zza) {
            this.zza = true;
            if (str == null) {
                str = zzehh.zze(this.zzb.zza, i2);
            }
            zze(new zze(i2, str, "undefined", (zze) null, (IBinder) null));
        }
    }

    public final synchronized void zzd() {
        this.zzc.zzd((Object) null);
    }
}
