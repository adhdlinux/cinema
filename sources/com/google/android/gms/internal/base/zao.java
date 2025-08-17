package com.google.android.gms.internal.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;

public final class zao extends ContextCompat {
    @Deprecated
    public static Intent zaa(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        int i2;
        if (!zan.zaa()) {
            return context.registerReceiver(broadcastReceiver, intentFilter);
        }
        if (true != zan.zaa()) {
            i2 = 0;
        } else {
            i2 = 2;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, i2);
    }
}
