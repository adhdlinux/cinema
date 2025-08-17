package com.startapp;

import com.startapp.sdk.ads.video.VideoMode;

public class u5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoMode f36644a;

    public u5(VideoMode videoMode) {
        this.f36644a = videoMode;
    }

    public void run() {
        VideoMode videoMode = this.f36644a;
        if (videoMode.M != null) {
            videoMode.S();
        }
    }
}
