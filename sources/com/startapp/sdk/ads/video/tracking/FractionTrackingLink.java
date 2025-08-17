package com.startapp.sdk.ads.video.tracking;

import com.startapp.i0;

@i0(extendsClass = true)
public class FractionTrackingLink extends VideoTrackingLink {
    private static final long serialVersionUID = 1;
    private int fraction;

    public void a(int i2) {
        this.fraction = i2;
    }

    public int e() {
        return this.fraction;
    }

    public String toString() {
        return super.toString() + ", fraction=" + this.fraction;
    }
}
