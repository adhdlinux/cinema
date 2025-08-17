package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zau;

@SuppressLint({"HandlerLeak"})
final class zac extends zau {
    final /* synthetic */ GoogleApiAvailability zaa;
    private final Context zab;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zac(com.google.android.gms.common.GoogleApiAvailability r1, android.content.Context r2) {
        /*
            r0 = this;
            r0.zaa = r1
            android.os.Looper r1 = android.os.Looper.myLooper()
            if (r1 != 0) goto L_0x000d
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            goto L_0x0011
        L_0x000d:
            android.os.Looper r1 = android.os.Looper.myLooper()
        L_0x0011:
            r0.<init>(r1)
            android.content.Context r1 = r2.getApplicationContext()
            r0.zab = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zac.<init>(com.google.android.gms.common.GoogleApiAvailability, android.content.Context):void");
    }

    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i2);
            return;
        }
        int isGooglePlayServicesAvailable = this.zaa.isGooglePlayServicesAvailable(this.zab);
        if (this.zaa.isUserResolvableError(isGooglePlayServicesAvailable)) {
            this.zaa.showErrorNotification(this.zab, isGooglePlayServicesAvailable);
        }
    }
}
