package com.google.android.gms.cast.internal;

import android.content.Context;
import androidx.core.content.ContextCompat;

public final class zzas {
    public static boolean zza(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            return true;
        }
        return false;
    }
}
