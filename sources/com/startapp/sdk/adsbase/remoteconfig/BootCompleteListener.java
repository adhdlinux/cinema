package com.startapp.sdk.adsbase.remoteconfig;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.startapp.c7;
import com.startapp.ia;
import com.startapp.sdk.adsbase.StartAppSDKInternal;

public class BootCompleteListener extends BroadcastReceiver {
    @SuppressLint({"UnsafeProtectedBroadcastReceiver"})
    public void onReceive(Context context, Intent intent) {
        String str = StartAppSDKInternal.f36218a;
        Context b2 = ia.b(context);
        StartAppSDKInternal.a(b2, (Runnable) new c7(b2));
    }
}
