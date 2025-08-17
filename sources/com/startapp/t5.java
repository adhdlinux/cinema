package com.startapp;

import com.startapp.sdk.ads.video.VideoMode;

public class t5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoMode f36569a;

    public t5(VideoMode videoMode) {
        this.f36569a = videoMode;
    }

    public void run() {
        VideoMode videoMode = this.f36569a;
        if (videoMode.M != null) {
            videoMode.R = !videoMode.R;
            videoMode.L();
            VideoMode videoMode2 = this.f36569a;
            videoMode2.a(videoMode2.R);
        }
    }
}
