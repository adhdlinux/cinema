package com.applovin.impl.sdk.utils;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.Map;

public class AppKilledService extends Service {
    public static final String ACTION_APP_KILLED = "com.applovin.app_killed";

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        AppLovinBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent(ACTION_APP_KILLED), (Map<String, Object>) null);
        stopSelf();
    }
}
