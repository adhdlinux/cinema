package com.startapp;

import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.adsbase.cache.CacheKey;

public class v4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f36726a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CacheKey f36727b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SplashEventHandler f36728c;

    public v4(SplashEventHandler splashEventHandler, Runnable runnable, CacheKey cacheKey) {
        this.f36728c = splashEventHandler;
        this.f36726a = runnable;
        this.f36727b = cacheKey;
    }

    public void run() {
        SplashEventHandler splashEventHandler = this.f36728c;
        splashEventHandler.f36035h = true;
        if (splashEventHandler.f36036i != SplashEventHandler.SplashState.DO_NOT_DISPLAY) {
            splashEventHandler.a(this.f36726a, this.f36727b);
        }
    }
}
