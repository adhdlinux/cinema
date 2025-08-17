package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;

public final class zzerj implements zzeqy {
    private final zzfwn zza;
    private final Context zzb;

    public zzerj(zzfwn zzfwn, Context context) {
        this.zza = zzfwn;
        this.zzb = context;
    }

    public final int zza() {
        return 39;
    }

    public final zzfwm zzb() {
        return this.zza.zzb(new zzeri(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzerh zzc() throws Exception {
        int i2;
        boolean z2;
        int i3;
        TelephonyManager telephonyManager = (TelephonyManager) this.zzb.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int phoneType = telephonyManager.getPhoneType();
        zzt.zzp();
        int i4 = -1;
        if (zzs.zzw(this.zzb, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zzb.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                int ordinal = activeNetworkInfo.getDetailedState().ordinal();
                i3 = type;
                i4 = ordinal;
            } else {
                i3 = -1;
            }
            z2 = connectivityManager.isActiveNetworkMetered();
            i2 = i4;
        } else {
            i3 = -2;
            z2 = false;
            i2 = -1;
        }
        return new zzerh(networkOperator, i3, zzt.zzq().zzn(this.zzb), phoneType, z2, i2);
    }
}
