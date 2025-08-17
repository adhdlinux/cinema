package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzt;

@TargetApi(26)
public class zzv extends zzu {
    public final Intent zzg(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        return intent;
    }

    public final void zzh(Context context, String str, String str2) {
        NotificationChannel notificationChannel = new NotificationChannel("offline_notification_channel", "AdMob Offline Notifications", 2);
        notificationChannel.setShowBadge(false);
        ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
    }

    public final boolean zzi(Context context, String str) {
        NotificationChannel a2 = ((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationChannel("offline_notification_channel");
        if (a2 != null && a2.getImportance() == 0) {
            return true;
        }
        return false;
    }

    public final int zzj(Context context, TelephonyManager telephonyManager) {
        zzt.zzp();
        if (!zzs.zzw(context, "android.permission.ACCESS_NETWORK_STATE") || !telephonyManager.isDataEnabled()) {
            return 1;
        }
        return 2;
    }
}
