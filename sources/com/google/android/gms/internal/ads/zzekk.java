package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzekk implements zzeqy {
    private final Context zza;

    zzekk(Context context) {
        this.zza = context;
    }

    public final int zza() {
        return 2;
    }

    public final zzfwm zzb() {
        boolean z2;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzcB)).booleanValue()) {
            return zzfwc.zzh((Object) null);
        }
        if (ContextCompat.checkSelfPermission(this.zza, "com.google.android.gms.permission.AD_ID") == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        return zzfwc.zzh(new zzekl(z2));
    }
}
