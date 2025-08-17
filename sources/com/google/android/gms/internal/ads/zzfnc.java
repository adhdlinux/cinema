package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;

public final class zzfnc {
    @SuppressLint({"RestrictedApi"})
    public static zzfnb zza(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return new zzfnd(new zzfnj(context));
    }
}
