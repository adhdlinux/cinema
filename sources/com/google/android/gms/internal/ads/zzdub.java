package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class zzdub {
    private final zzfwn zza;
    private final zzfwn zzb;
    private final zzdvj zzc;
    private final zzgvy zzd;

    public zzdub(zzfwn zzfwn, zzfwn zzfwn2, zzdvj zzdvj, zzgvy zzgvy) {
        this.zza = zzfwn;
        this.zzb = zzfwn2;
        this.zzc = zzdvj;
        this.zzd = zzgvy;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zza(zzbue zzbue, int i2, zzdwa zzdwa) throws Exception {
        return ((zzdyh) this.zzd.zzb()).zzc(zzbue, i2);
    }

    public final zzfwm zzb(zzbue zzbue) {
        zzfwm zzfwm;
        String str = zzbue.zzd;
        zzt.zzp();
        if (zzs.zzy(str)) {
            zzfwm = zzfwc.zzg(new zzdwa(1));
        } else {
            zzfwm = zzfwc.zzf(this.zza.zzb(new zzdty(this, zzbue)), ExecutionException.class, zzdtz.zza, this.zzb);
        }
        return zzfwc.zzf(zzfwm, zzdwa.class, new zzdua(this, zzbue, Binder.getCallingUid()), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzc(zzbue zzbue) throws Exception {
        zzcaj zzcaj;
        zzdvj zzdvj = this.zzc;
        synchronized (zzdvj.zzb) {
            if (zzdvj.zzc) {
                zzcaj = zzdvj.zza;
            } else {
                zzdvj.zzc = true;
                zzdvj.zze = zzbue;
                zzdvj.zzf.checkAvailabilityAndConnect();
                zzdvj.zza.zzc(new zzdvi(zzdvj), zzcae.zzf);
                zzcaj = zzdvj.zza;
            }
        }
        return (InputStream) zzcaj.get((long) ((Integer) zzba.zzc().zzb(zzbbm.zzfm)).intValue(), TimeUnit.SECONDS);
    }
}
