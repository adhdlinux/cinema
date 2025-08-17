package com.utils.cast;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.original.tase.Logger;

public class LocalWebserver extends Service {
    private boolean a() {
        boolean e2 = WebServerManager.a().e();
        if (!e2) {
            Logger.d(new RuntimeException("Failed to start subtitles server..."), true);
        }
        return e2;
    }

    private void b() {
        WebServerManager.a().f();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        b();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (!a() || intent == null) {
            return 2;
        }
        try {
            if (intent.getExtras() == null) {
                return 2;
            }
            Bundle extras = intent.getExtras();
            if (extras.isEmpty() || !extras.containsKey("isNeededToRefreshTracks") || !extras.getBoolean("isNeededToRefreshTracks", false) || !extras.containsKey("videoAndSubTrackIdArray") || !extras.containsKey("videoOnlyTrackIdArray")) {
                return 2;
            }
            CastHelper.g(this, extras.getLongArray("videoAndSubTrackIdArray"), extras.getLongArray("videoOnlyTrackIdArray"));
            return 2;
        } catch (Exception e2) {
            Logger.d(e2, true);
            return 2;
        }
    }
}
