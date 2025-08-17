package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.video.VideoMode;

public class q5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f35647a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoMode f35648b;

    public q5(VideoMode videoMode, int i2) {
        this.f35648b = videoMode;
        this.f35647a = i2;
    }

    public void run() {
        try {
            this.f35648b.f(this.f35647a);
        } catch (Throwable th) {
            y8.a((Context) this.f35648b.f36704b, th);
        }
    }
}
