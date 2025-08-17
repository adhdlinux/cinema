package com.startapp;

import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.ads.splash.SplashScreen;
import com.startapp.sdk.adsbase.cache.CacheKey;

public class z4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashScreen f36979a;

    public z4(SplashScreen splashScreen) {
        this.f36979a = splashScreen;
    }

    public void run() {
        SplashScreen splashScreen = this.f36979a;
        SplashEventHandler splashEventHandler = splashScreen.f36051b;
        Runnable runnable = splashScreen.f36060k;
        CacheKey cacheKey = splashScreen.f36053d;
        boolean z2 = false;
        if (!splashEventHandler.f36034g) {
            SplashEventHandler.SplashState splashState = splashEventHandler.f36036i;
            if (splashState == SplashEventHandler.SplashState.LOADING) {
                splashEventHandler.f36031d = false;
                splashEventHandler.f36036i = SplashEventHandler.SplashState.DO_NOT_DISPLAY;
                splashEventHandler.c();
                z2 = true;
            } else if (splashState == SplashEventHandler.SplashState.RECEIVED) {
                splashEventHandler.f36035h = true;
                splashEventHandler.a(runnable, cacheKey);
            }
        }
        if (z2) {
            SplashScreen splashScreen2 = this.f36979a;
            splashScreen2.f36057h = null;
            splashScreen2.f36053d = null;
        }
    }
}
