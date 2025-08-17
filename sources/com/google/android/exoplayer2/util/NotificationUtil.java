package com.google.android.exoplayer2.util;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

@SuppressLint({"InlinedApi"})
public final class NotificationUtil {
    private NotificationUtil() {
    }

    public static void a(Context context, String str, int i2, int i3, int i4) {
        if (Util.f28808a >= 26) {
            NotificationManager notificationManager = (NotificationManager) Assertions.e((NotificationManager) context.getSystemService("notification"));
            NotificationChannel notificationChannel = new NotificationChannel(str, context.getString(i2), i4);
            if (i3 != 0) {
                notificationChannel.setDescription(context.getString(i3));
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
