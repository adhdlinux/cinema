package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.video.VideoMode;

public class r5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f35751a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoMode f35752b;

    public r5(VideoMode videoMode, int i2) {
        this.f35752b = videoMode;
        this.f35751a = i2;
    }

    public void run() {
        try {
            this.f35752b.e(this.f35751a);
        } catch (Throwable th) {
            y8.a((Context) this.f35752b.f36704b, th);
        }
    }
}
