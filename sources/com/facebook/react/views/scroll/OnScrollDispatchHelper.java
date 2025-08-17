package com.facebook.react.views.scroll;

import android.os.SystemClock;

public class OnScrollDispatchHelper {
    private static final int MIN_EVENT_SEPARATION_MS = 10;
    private long mLastScrollEventTimeMs = -11;
    private int mPrevX = Integer.MIN_VALUE;
    private int mPrevY = Integer.MIN_VALUE;
    private float mXFlingVelocity = 0.0f;
    private float mYFlingVelocity = 0.0f;

    public float getXFlingVelocity() {
        return this.mXFlingVelocity;
    }

    public float getYFlingVelocity() {
        return this.mYFlingVelocity;
    }

    public boolean onScrollChanged(int i2, int i3) {
        boolean z2;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j2 = this.mLastScrollEventTimeMs;
        if (uptimeMillis - j2 <= 10 && this.mPrevX == i2 && this.mPrevY == i3) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (uptimeMillis - j2 != 0) {
            this.mXFlingVelocity = ((float) (i2 - this.mPrevX)) / ((float) (uptimeMillis - j2));
            this.mYFlingVelocity = ((float) (i3 - this.mPrevY)) / ((float) (uptimeMillis - j2));
        }
        this.mLastScrollEventTimeMs = uptimeMillis;
        this.mPrevX = i2;
        this.mPrevY = i3;
        return z2;
    }
}
