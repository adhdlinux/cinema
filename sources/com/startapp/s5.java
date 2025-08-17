package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.video.VideoMode;

public class s5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoMode f35844a;

    public s5(VideoMode videoMode) {
        this.f35844a = videoMode;
    }

    public void run() {
        try {
            this.f35844a.u();
        } catch (Throwable th) {
            y8.a((Context) this.f35844a.f36704b, th);
        }
    }
}
