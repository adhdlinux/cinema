package com.startapp;

import android.os.Handler;
import com.startapp.sdk.ads.video.VideoMode;

public class o5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoMode f35551a;

    public o5(VideoMode videoMode) {
        this.f35551a = videoMode;
    }

    public void run() {
        int N = this.f35551a.N();
        if (N >= 1000) {
            Handler handler = this.f35551a.f36081o0;
            long j2 = 1000;
            long j3 = ((long) N) % 1000;
            if (j3 != 0) {
                j2 = j3;
            }
            handler.postDelayed(this, j2 + 50);
        }
    }
}
