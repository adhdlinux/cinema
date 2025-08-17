package com.utils;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.yoku.marumovie.R;

public class MyUnboundService extends Service {

    /* renamed from: b  reason: collision with root package name */
    private static Intent f37571b;

    public static Intent a(Context context) {
        if (f37571b == null) {
            f37571b = new Intent(context, MyUnboundService.class);
        }
        return f37571b;
    }

    private void b() {
        Notification c2 = new NotificationCompat.Builder(this, getString(R.string.notification_channel_id)).s(true).y(R.mipmap.ic_launcher).m("Running in background").u(5).h("service").g(true).c();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + getPackageName()));
        c2.contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
        startForeground(2, c2);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            b();
        } else {
            startForeground(1, new Notification());
        }
    }
}
