package com.startapp;

import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.ads.splash.SplashEventHandler;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;

public class w4 implements da {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f36810a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CacheKey f36811b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SplashEventHandler f36812c;

    public w4(SplashEventHandler splashEventHandler, Runnable runnable, CacheKey cacheKey) {
        this.f36812c = splashEventHandler;
        this.f36810a = runnable;
        this.f36811b = cacheKey;
    }

    public void a(MetaDataRequest.RequestReason requestReason, boolean z2) {
        SplashEventHandler splashEventHandler = this.f36812c;
        Runnable runnable = this.f36810a;
        CacheKey cacheKey = this.f36811b;
        splashEventHandler.getClass();
        new Handler(Looper.getMainLooper()).post(new v4(splashEventHandler, runnable, cacheKey));
    }

    public void a(MetaDataRequest.RequestReason requestReason) {
        SplashEventHandler splashEventHandler = this.f36812c;
        Runnable runnable = this.f36810a;
        CacheKey cacheKey = this.f36811b;
        splashEventHandler.getClass();
        new Handler(Looper.getMainLooper()).post(new v4(splashEventHandler, runnable, cacheKey));
    }
}
