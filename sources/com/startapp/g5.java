package com.startapp;

import com.startapp.sdk.ads.video.player.VideoPlayerInterface;

public class g5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f34557a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h5 f34558b;

    public g5(h5 h5Var, int i2) {
        this.f34558b = h5Var;
        this.f34557a = i2;
    }

    public void run() {
        VideoPlayerInterface.a aVar = this.f34558b.f34615b;
        if (aVar != null) {
            ((y5) aVar).a(this.f34557a);
        }
    }
}
