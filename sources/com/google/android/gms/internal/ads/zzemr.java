package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzemr implements zzeqy {
    private final zzfwn zza;
    private final Context zzb;

    zzemr(zzfwn zzfwn, Context context) {
        this.zza = zzfwn;
        this.zzb = context;
    }

    public final int zza() {
        return 14;
    }

    @SuppressLint({"UnprotectedReceiver"})
    public final zzfwm zzb() {
        return this.zza.zzb(new zzemq(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzems zzc() throws Exception {
        Intent intent;
        double d2;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjA)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            intent = this.zzb.registerReceiver((BroadcastReceiver) null, intentFilter);
        } else {
            intent = this.zzb.registerReceiver((BroadcastReceiver) null, intentFilter, 4);
        }
        boolean z2 = false;
        if (intent != null) {
            int intExtra = intent.getIntExtra("status", -1);
            double intExtra2 = (double) intent.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1);
            double intExtra3 = (double) intent.getIntExtra("scale", -1);
            if (intExtra == 2 || intExtra == 5) {
                z2 = true;
            }
            d2 = intExtra2 / intExtra3;
        } else {
            d2 = -1.0d;
        }
        return new zzems(d2, z2);
    }
}
