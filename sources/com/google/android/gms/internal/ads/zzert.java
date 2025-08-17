package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;

public final class zzert implements zzeqy {
    private final Executor zza;
    private final String zzb;
    private final PackageInfo zzc;
    private final zzbyr zzd;

    public zzert(zzbyr zzbyr, Executor executor, String str, PackageInfo packageInfo, int i2) {
        this.zzd = zzbyr;
        this.zza = executor;
        this.zzb = str;
        this.zzc = packageInfo;
    }

    public final int zza() {
        return 41;
    }

    public final zzfwm zzb() {
        return zzfwc.zzf(zzfwc.zzl(zzfwc.zzh(this.zzb), zzerr.zza, this.zza), Throwable.class, new zzers(this), this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(Throwable th) throws Exception {
        return zzfwc.zzh(new zzeru(this.zzb));
    }
}
