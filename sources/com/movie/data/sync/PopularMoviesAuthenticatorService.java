package com.movie.data.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PopularMoviesAuthenticatorService extends Service {

    /* renamed from: b  reason: collision with root package name */
    private PopularMoviesAuthenticator f31981b;

    public IBinder onBind(Intent intent) {
        return this.f31981b.getIBinder();
    }

    public void onCreate() {
        this.f31981b = new PopularMoviesAuthenticator(this);
    }
}
