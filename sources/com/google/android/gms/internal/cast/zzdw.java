package com.google.android.gms.internal.cast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;

public final class zzdw extends ContextCompat {
    @Deprecated
    public static Intent zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i2;
        if (!zzdv.zza()) {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        }
        if (true != zzdv.zza()) {
            i2 = 0;
        } else {
            i2 = 2;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, i2);
    }
}
