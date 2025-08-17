package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

class SpringAnimation extends AnimationDriver {
    private static final double MAX_DELTA_TIME_SEC = 0.064d;
    private static final double SOLVER_TIMESTEP_SEC = 0.001d;
    private int mCurrentLoop;
    private final PhysicsState mCurrentState;
    private double mDisplacementFromRestThreshold;
    private double mEndValue;
    private double mInitialVelocity;
    private int mIterations;
    private long mLastTime;
    private double mOriginalValue;
    private boolean mOvershootClampingEnabled;
    private double mRestSpeedThreshold;
    private double mSpringDamping;
    private double mSpringMass;
    private boolean mSpringStarted;
    private double mSpringStiffness;
    private double mStartValue;
    private double mTimeAccumulator;

    private static class PhysicsState {
        double position;
        double velocity;

        private PhysicsState() {
        }
    }

    SpringAnimation(ReadableMap readableMap) {
        PhysicsState physicsState = new PhysicsState();
        this.mCurrentState = physicsState;
        physicsState.velocity = readableMap.getDouble("initialVelocity");
        resetConfig(readableMap);
    }

    private void advance(double d2) {
        double d3;
        double d4;
        if (!isAtRest()) {
            double d5 = MAX_DELTA_TIME_SEC;
            if (d2 <= MAX_DELTA_TIME_SEC) {
                d5 = d2;
            }
            this.mTimeAccumulator += d5;
            double d6 = this.mSpringDamping;
            double d7 = this.mSpringMass;
            double d8 = this.mSpringStiffness;
            double d9 = -this.mInitialVelocity;
            double sqrt = d6 / (Math.sqrt(d8 * d7) * 2.0d);
            double sqrt2 = Math.sqrt(d8 / d7);
            double sqrt3 = Math.sqrt(1.0d - (sqrt * sqrt)) * sqrt2;
            double d10 = this.mEndValue - this.mStartValue;
            double d11 = this.mTimeAccumulator;
            if (sqrt < 1.0d) {
                double exp = Math.exp((-sqrt) * sqrt2 * d11);
                double d12 = sqrt * sqrt2;
                double d13 = d9 + (d12 * d10);
                double d14 = d11 * sqrt3;
                double d15 = exp;
                d3 = this.mEndValue - ((((d13 / sqrt3) * Math.sin(d14)) + (Math.cos(d14) * d10)) * d15);
                d4 = ((d12 * d15) * (((Math.sin(d14) * d13) / sqrt3) + (Math.cos(d14) * d10))) - (((Math.cos(d14) * d13) - ((sqrt3 * d10) * Math.sin(d14))) * d15);
            } else {
                double exp2 = Math.exp((-sqrt2) * d11);
                double d16 = this.mEndValue - (((((sqrt2 * d10) + d9) * d11) + d10) * exp2);
                d4 = exp2 * ((d9 * ((d11 * sqrt2) - 1.0d)) + (d11 * d10 * sqrt2 * sqrt2));
                d3 = d16;
            }
            PhysicsState physicsState = this.mCurrentState;
            physicsState.position = d3;
            physicsState.velocity = d4;
            if (isAtRest() || (this.mOvershootClampingEnabled && isOvershooting())) {
                if (this.mSpringStiffness > 0.0d) {
                    double d17 = this.mEndValue;
                    this.mStartValue = d17;
                    this.mCurrentState.position = d17;
                } else {
                    double d18 = this.mCurrentState.position;
                    this.mEndValue = d18;
                    this.mStartValue = d18;
                }
                this.mCurrentState.velocity = 0.0d;
            }
        }
    }

    private double getDisplacementDistanceForState(PhysicsState physicsState) {
        return Math.abs(this.mEndValue - physicsState.position);
    }

    private boolean isAtRest() {
        if (Math.abs(this.mCurrentState.velocity) > this.mRestSpeedThreshold || (getDisplacementDistanceForState(this.mCurrentState) > this.mDisplacementFromRestThreshold && this.mSpringStiffness != 0.0d)) {
            return false;
        }
        return true;
    }

    private boolean isOvershooting() {
        if (this.mSpringStiffness > 0.0d) {
            double d2 = this.mStartValue;
            double d3 = this.mEndValue;
            return (d2 < d3 && this.mCurrentState.position > d3) || (d2 > d3 && this.mCurrentState.position < d3);
        }
    }

    public void resetConfig(ReadableMap readableMap) {
        int i2;
        this.mSpringStiffness = readableMap.getDouble("stiffness");
        this.mSpringDamping = readableMap.getDouble("damping");
        this.mSpringMass = readableMap.getDouble("mass");
        this.mInitialVelocity = this.mCurrentState.velocity;
        this.mEndValue = readableMap.getDouble("toValue");
        this.mRestSpeedThreshold = readableMap.getDouble("restSpeedThreshold");
        this.mDisplacementFromRestThreshold = readableMap.getDouble("restDisplacementThreshold");
        this.mOvershootClampingEnabled = readableMap.getBoolean("overshootClamping");
        boolean z2 = true;
        if (readableMap.hasKey("iterations")) {
            i2 = readableMap.getInt("iterations");
        } else {
            i2 = 1;
        }
        this.mIterations = i2;
        if (i2 != 0) {
            z2 = false;
        }
        this.mHasFinished = z2;
        this.mCurrentLoop = 0;
        this.mTimeAccumulator = 0.0d;
        this.mSpringStarted = false;
    }

    public void runAnimationStep(long j2) {
        long j3 = j2 / 1000000;
        if (!this.mSpringStarted) {
            if (this.mCurrentLoop == 0) {
                this.mOriginalValue = this.mAnimatedValue.mValue;
                this.mCurrentLoop = 1;
            }
            PhysicsState physicsState = this.mCurrentState;
            double d2 = this.mAnimatedValue.mValue;
            physicsState.position = d2;
            this.mStartValue = d2;
            this.mLastTime = j3;
            this.mTimeAccumulator = 0.0d;
            this.mSpringStarted = true;
        }
        advance(((double) (j3 - this.mLastTime)) / 1000.0d);
        this.mLastTime = j3;
        this.mAnimatedValue.mValue = this.mCurrentState.position;
        if (isAtRest()) {
            int i2 = this.mIterations;
            if (i2 == -1 || this.mCurrentLoop < i2) {
                this.mSpringStarted = false;
                this.mAnimatedValue.mValue = this.mOriginalValue;
                this.mCurrentLoop++;
                return;
            }
            this.mHasFinished = true;
        }
    }
}
