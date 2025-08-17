package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;

public class n5 extends td {

    /* renamed from: h  reason: collision with root package name */
    public Runnable f34953h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f34954i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f34955j;

    public n5(Context context, Runnable runnable, Runnable runnable2, Runnable runnable3, Runnable runnable4, Runnable runnable5, TrackingParams trackingParams, boolean z2) {
        super(context, runnable, runnable2, trackingParams);
        this.f34953h = runnable3;
        this.f34954i = runnable4;
        this.f34955j = runnable5;
        this.f36583b = z2;
    }

    @JavascriptInterface
    public void replayVideo() {
        if (this.f34953h != null) {
            new Handler(Looper.getMainLooper()).post(this.f34953h);
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        if (this.f34954i != null) {
            new Handler(Looper.getMainLooper()).post(this.f34954i);
        }
    }

    @JavascriptInterface
    public void toggleSound() {
        if (this.f34955j != null) {
            new Handler(Looper.getMainLooper()).post(this.f34955j);
        }
    }
}
