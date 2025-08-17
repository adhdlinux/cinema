package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

final class zzex extends BroadcastReceiver {
    final /* synthetic */ zzey zza;

    /* synthetic */ zzex(zzey zzey, zzew zzew) {
        this.zza = zzey;
    }

    public final void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i2 = 0;
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    int type = activeNetworkInfo.getType();
                    if (type != 0) {
                        if (type != 1) {
                            if (!(type == 4 || type == 5)) {
                                if (type != 6) {
                                    i2 = type != 9 ? 8 : 7;
                                }
                                i2 = 5;
                            }
                        }
                        i2 = 2;
                    }
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                            i2 = 3;
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            i2 = 4;
                            break;
                        case 13:
                            break;
                        case 18:
                            break;
                        case 20:
                            if (zzfj.zza >= 29) {
                                i2 = 9;
                                break;
                            }
                            break;
                        default:
                            i2 = 6;
                            break;
                    }
                } else {
                    i2 = 1;
                }
            } catch (SecurityException unused) {
            }
        }
        if (zzfj.zza < 31 || i2 != 5) {
            zzey.zzc(this.zza, i2);
            return;
        }
        zzey zzey = this.zza;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            telephonyManager.getClass();
            zzev zzev = new zzev(zzey);
            telephonyManager.registerTelephonyCallback(context.getMainExecutor(), zzev);
            telephonyManager.unregisterTelephonyCallback(zzev);
        } catch (RuntimeException unused2) {
            zzey.zzc(zzey, 5);
        }
    }
}
