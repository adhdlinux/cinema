package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.adlisteners.VideoListener;

public final class p7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoListener f35611a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f35612b;

    public p7(VideoListener videoListener, Context context) {
        this.f35611a = videoListener;
        this.f35612b = context;
    }

    public void run() {
        try {
            this.f35611a.onVideoCompleted();
        } catch (Throwable th) {
            lb.a(this.f35612b, (Object) this.f35611a, th);
        }
    }
}
