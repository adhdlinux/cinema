package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

public class DecayAnimation extends AnimationDriver {
    private int mCurrentLoop;
    private double mDeceleration;
    private double mFromValue;
    private int mIterations;
    private double mLastValue;
    private long mStartFrameTimeMillis;
    private final double mVelocity;

    public DecayAnimation(ReadableMap readableMap) {
        this.mVelocity = readableMap.getDouble("velocity");
        resetConfig(readableMap);
    }

    public void resetConfig(ReadableMap readableMap) {
        int i2;
        this.mDeceleration = readableMap.getDouble("deceleration");
        boolean z2 = true;
        if (readableMap.hasKey("iterations")) {
            i2 = readableMap.getInt("iterations");
        } else {
            i2 = 1;
        }
        this.mIterations = i2;
        this.mCurrentLoop = 1;
        if (i2 != 0) {
            z2 = false;
        }
        this.mHasFinished = z2;
        this.mStartFrameTimeMillis = -1;
        this.mFromValue = 0.0d;
        this.mLastValue = 0.0d;
    }

    public void runAnimationStep(long j2) {
        long j3 = j2 / 1000000;
        if (this.mStartFrameTimeMillis == -1) {
            this.mStartFrameTimeMillis = j3 - 16;
            double d2 = this.mFromValue;
            if (d2 == this.mLastValue) {
                this.mFromValue = this.mAnimatedValue.mValue;
            } else {
                this.mAnimatedValue.mValue = d2;
            }
            this.mLastValue = this.mAnimatedValue.mValue;
        }
        double d3 = this.mFromValue;
        double d4 = this.mVelocity;
        double d5 = this.mDeceleration;
        double exp = d3 + ((d4 / (1.0d - d5)) * (1.0d - Math.exp((-(1.0d - d5)) * ((double) (j3 - this.mStartFrameTimeMillis)))));
        if (Math.abs(this.mLastValue - exp) < 0.1d) {
            int i2 = this.mIterations;
            if (i2 == -1 || this.mCurrentLoop < i2) {
                this.mStartFrameTimeMillis = -1;
                this.mCurrentLoop++;
            } else {
                this.mHasFinished = true;
                return;
            }
        }
        this.mLastValue = exp;
        this.mAnimatedValue.mValue = exp;
    }
}
