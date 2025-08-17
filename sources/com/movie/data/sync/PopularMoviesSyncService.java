package com.movie.data.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import timber.log.Timber;

public class PopularMoviesSyncService extends Service {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f31982b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static PopularMoviesSyncAdapter f31983c;

    public IBinder onBind(Intent intent) {
        return f31983c.getSyncAdapterBinder();
    }

    public void onCreate() {
        Timber.b("init", new Object[0]);
        synchronized (f31982b) {
            if (f31983c == null) {
                f31983c = new PopularMoviesSyncAdapter(getApplicationContext(), true);
            }
        }
    }
}
