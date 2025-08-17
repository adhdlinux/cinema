package com.facebook.react.animated;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.ReactConstants;

class FrameBasedAnimationDriver extends AnimationDriver {
    private static final double FRAME_TIME_MILLIS = 16.666666666666668d;
    private int mCurrentLoop;
    private double[] mFrames;
    private double mFromValue;
    private int mIterations;
    private long mStartFrameTimeNanos;
    private double mToValue;

    FrameBasedAnimationDriver(ReadableMap readableMap) {
        resetConfig(readableMap);
    }

    public void resetConfig(ReadableMap readableMap) {
        int i2;
        ReadableArray array = readableMap.getArray("frames");
        int size = array.size();
        double[] dArr = this.mFrames;
        if (dArr == null || dArr.length != size) {
            this.mFrames = new double[size];
        }
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            this.mFrames[i3] = array.getDouble(i3);
        }
        double d2 = 0.0d;
        if (readableMap.hasKey("toValue")) {
            if (readableMap.getType("toValue") == ReadableType.Number) {
                d2 = readableMap.getDouble("toValue");
            }
            this.mToValue = d2;
        } else {
            this.mToValue = 0.0d;
        }
        if (readableMap.hasKey("iterations")) {
            if (readableMap.getType("iterations") == ReadableType.Number) {
                i2 = readableMap.getInt("iterations");
            } else {
                i2 = 1;
            }
            this.mIterations = i2;
        } else {
            this.mIterations = 1;
        }
        this.mCurrentLoop = 1;
        if (this.mIterations == 0) {
            z2 = true;
        }
        this.mHasFinished = z2;
        this.mStartFrameTimeNanos = -1;
    }

    public void runAnimationStep(long j2) {
        double d2;
        if (this.mStartFrameTimeNanos < 0) {
            this.mStartFrameTimeNanos = j2;
            if (this.mCurrentLoop == 1) {
                this.mFromValue = this.mAnimatedValue.mValue;
            }
        }
        int round = (int) Math.round(((double) ((j2 - this.mStartFrameTimeNanos) / 1000000)) / FRAME_TIME_MILLIS);
        if (round < 0) {
            FLog.w(ReactConstants.TAG, "Calculated frame index should never be lower than 0. Called with frameTimeNanos " + j2 + " and mStartFrameTimeNanos " + this.mStartFrameTimeNanos);
        } else if (!this.mHasFinished) {
            double[] dArr = this.mFrames;
            if (round >= dArr.length - 1) {
                d2 = this.mToValue;
                int i2 = this.mIterations;
                if (i2 == -1 || this.mCurrentLoop < i2) {
                    this.mStartFrameTimeNanos = -1;
                    this.mCurrentLoop++;
                } else {
                    this.mHasFinished = true;
                }
            } else {
                double d3 = this.mFromValue;
                d2 = d3 + (dArr[round] * (this.mToValue - d3));
            }
            this.mAnimatedValue.mValue = d2;
        }
    }
}
