package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.ExecutionException;

public final class zzdwq {
    private final zzfwn zza;
    private final zzfwn zzb;
    private final zzdxl zzc;
    private final zzgvy zzd;

    zzdwq(zzfwn zzfwn, zzfwn zzfwn2, zzdxl zzdxl, zzgvy zzgvy) {
        this.zza = zzfwn;
        this.zzb = zzfwn2;
        this.zzc = zzdxl;
        this.zzd = zzgvy;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zza(zzbtm zzbtm) throws Exception {
        return this.zzc.zza(zzbtm, ((Long) zzba.zzc().zzb(zzbbm.zzjV)).longValue());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzb(zzbtm zzbtm, int i2, zzdwa zzdwa) throws Exception {
        return ((zzdyr) this.zzd.zzb()).zzb(zzbtm, i2);
    }

    public final zzfwm zzc(zzbtm zzbtm) {
        zzfwm zzfwm;
        String str = zzbtm.zzf;
        zzt.zzp();
        if (zzs.zzy(str)) {
            zzfwm = zzfwc.zzg(new zzdwa(1, "Ads service proxy force local"));
        } else {
            zzfwm = zzfwc.zzf(zzfwc.zzk(new zzdwn(this, zzbtm), this.zza), ExecutionException.class, zzdwo.zza, this.zzb);
        }
        return zzfwc.zzf(zzfwm, zzdwa.class, new zzdwp(this, zzbtm, Binder.getCallingUid()), this.zzb);
    }
}
