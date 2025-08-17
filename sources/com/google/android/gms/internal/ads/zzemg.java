package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;

public final class zzemg implements zzeqy {
    private static final Object zza = new Object();
    private final String zzb;
    private final String zzc;
    private final zzcsu zzd;
    private final zzfbo zze;
    private final zzfai zzf;
    private final zzg zzg = zzt.zzo().zzh();
    private final zzdpv zzh;

    public zzemg(String str, String str2, zzcsu zzcsu, zzfbo zzfbo, zzfai zzfai, zzdpv zzdpv) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzcsu;
        this.zze = zzfbo;
        this.zzf = zzfai;
        this.zzh = zzdpv;
    }

    public final int zza() {
        return 12;
    }

    public final zzfwm zzb() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzhl)).booleanValue()) {
            this.zzh.zza().put("seq_num", this.zzb);
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfp)).booleanValue()) {
            this.zzd.zzg(this.zzf.zzd);
            bundle.putAll(this.zze.zzb());
        }
        return zzfwc.zzh(new zzemf(this, bundle));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfp)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzfo)).booleanValue()) {
                synchronized (zza) {
                    this.zzd.zzg(this.zzf.zzd);
                    bundle2.putBundle("quality_signals", this.zze.zzb());
                }
            } else {
                this.zzd.zzg(this.zzf.zzd);
                bundle2.putBundle("quality_signals", this.zze.zzb());
            }
        }
        bundle2.putString("seq_num", this.zzb);
        if (!this.zzg.zzP()) {
            bundle2.putString("session_id", this.zzc);
        }
    }
}
