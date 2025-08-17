package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.cast.internal.Logger;
import java.util.concurrent.Executors;

public final class zzcx {
    protected final Logger zza;
    protected final zzcz zzb;

    public zzcx(Context context) {
        zzcz zzcz;
        if (Build.VERSION.SDK_INT >= 23) {
            zzcz = new zzdc(context, zzqu.zza(Executors.newFixedThreadPool(3)));
        } else {
            zzcz = new zzdd();
        }
        this.zza = new Logger("BaseNetUtils");
        this.zzb = zzcz;
        zzcz.zza();
    }

    public final boolean zza() {
        zzcz zzcz = this.zzb;
        return zzcz != null && zzcz.zzb();
    }
}
