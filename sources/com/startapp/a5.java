package com.startapp;

import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.ads.splash.SplashScreen;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;

public class a5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SplashScreen f34187a;

    public a5(SplashScreen splashScreen) {
        this.f34187a = splashScreen;
    }

    public void run() {
        SplashScreen splashScreen = this.f34187a;
        SplashEventHandler splashEventHandler = splashScreen.f36051b;
        Runnable runnable = splashScreen.f36060k;
        CacheKey cacheKey = splashScreen.f36053d;
        splashEventHandler.f36030c = true;
        if (splashEventHandler.f36036i != SplashEventHandler.SplashState.DO_NOT_DISPLAY) {
            w4 w4Var = new w4(splashEventHandler, runnable, cacheKey);
            synchronized (MetaData.f36372a) {
                if (MetaData.f36379h.f36382k) {
                    w4Var.a((MetaDataRequest.RequestReason) null, false);
                } else {
                    MetaData.f36379h.a((da) w4Var);
                }
            }
            return;
        }
        splashEventHandler.c();
    }
}
