package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbm;

@TargetApi(30)
public final class zzy extends zzx {
    public final int zzn(Context context) {
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzib)).booleanValue()) {
            return 0;
        }
        return super.zzn(context);
    }
}
