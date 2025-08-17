package com.google.android.gms.internal.ads;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;

final class zzev extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
    private final zzey zza;

    public zzev(zzey zzey) {
        this.zza = zzey;
    }

    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        boolean z2;
        int a2 = telephonyDisplayInfo.getOverrideNetworkType();
        int i2 = 5;
        if (a2 == 3 || a2 == 4 || a2 == 5) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzey zzey = this.zza;
        if (true == z2) {
            i2 = 10;
        }
        zzey.zzc(zzey, i2);
    }
}
