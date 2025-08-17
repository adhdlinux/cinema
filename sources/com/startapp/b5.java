package com.startapp;

import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.ads.splash.SplashScreen;

public class b5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashScreen f34237a;

    public b5(SplashScreen splashScreen) {
        this.f34237a = splashScreen;
    }

    public void run() {
        SplashScreen splashScreen = this.f34237a;
        SplashEventHandler splashEventHandler = splashScreen.f36051b;
        SplashScreen.SplashStartAppAd splashStartAppAd = splashScreen.f36057h;
        if (splashEventHandler.f36036i == SplashEventHandler.SplashState.DISPLAYED && !splashEventHandler.f36033f) {
            splashStartAppAd.close();
            splashEventHandler.f36036i = SplashEventHandler.SplashState.HIDDEN;
            splashEventHandler.b();
        }
    }
}
