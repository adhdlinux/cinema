package com.startapp.sdk.ads.video.tracking;

import com.startapp.i0;

@i0(extendsClass = true)
public class AbsoluteTrackingLink extends VideoTrackingLink {
    private static final long serialVersionUID = 1;
    private int videoOffsetMillis;

    public void a(int i2) {
        this.videoOffsetMillis = i2;
    }

    public int e() {
        return this.videoOffsetMillis;
    }

    public String toString() {
        return super.toString() + ", videoOffsetMillis=" + this.videoOffsetMillis;
    }
}
