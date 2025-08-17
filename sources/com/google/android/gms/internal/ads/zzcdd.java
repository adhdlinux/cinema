package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;

public final class zzcdd extends zzb {
    final zzcca zza;
    final zzcdl zzb;
    private final String zzc;
    private final String[] zzd;

    zzcdd(zzcca zzcca, zzcdl zzcdl, String str, String[] strArr) {
        this.zza = zzcca;
        this.zzb = zzcdl;
        this.zzc = str;
        this.zzd = strArr;
        zzt.zzy().zzb(this);
    }

    public final void zza() {
        try {
            this.zzb.zzu(this.zzc, this.zzd);
        } finally {
            zzs.zza.post(new zzcdc(this));
        }
    }

    public final zzfwm zzb() {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzbP)).booleanValue() || !(this.zzb instanceof zzcdu)) {
            return super.zzb();
        }
        return zzcae.zze.zzb(new zzcdb(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Boolean zzd() throws Exception {
        return Boolean.valueOf(this.zzb.zzw(this.zzc, this.zzd, this));
    }

    public final String zze() {
        return this.zzc;
    }
}
