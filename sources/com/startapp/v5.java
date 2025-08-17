package com.startapp;

import com.startapp.sdk.ads.video.VideoMode;

public class v5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoMode f36729a;

    public v5(VideoMode videoMode) {
        this.f36729a = videoMode;
    }

    public void run() {
        VideoMode videoMode = this.f36729a;
        if (videoMode.M != null) {
            videoMode.F++;
            videoMode.N.setVisibility(0);
            VideoMode videoMode2 = this.f36729a;
            videoMode2.V = false;
            videoMode2.S = 0;
            lb.a(videoMode2.f36800w, true, "videoApi.setVideoCurrentPosition", 0);
            lb.a(videoMode2.f36800w, true, "videoApi.setSkipTimer", 0);
            this.f36729a.M();
        }
    }
}
