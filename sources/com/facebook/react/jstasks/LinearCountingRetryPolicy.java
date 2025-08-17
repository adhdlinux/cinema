package com.facebook.react.jstasks;

public class LinearCountingRetryPolicy implements HeadlessJsTaskRetryPolicy {
    private final int mDelayBetweenAttemptsInMs;
    private final int mRetryAttempts;

    public LinearCountingRetryPolicy(int i2, int i3) {
        this.mRetryAttempts = i2;
        this.mDelayBetweenAttemptsInMs = i3;
    }

    public boolean canRetry() {
        return this.mRetryAttempts > 0;
    }

    public HeadlessJsTaskRetryPolicy copy() {
        return new LinearCountingRetryPolicy(this.mRetryAttempts, this.mDelayBetweenAttemptsInMs);
    }

    public int getDelay() {
        return this.mDelayBetweenAttemptsInMs;
    }

    public HeadlessJsTaskRetryPolicy update() {
        int i2 = this.mRetryAttempts - 1;
        if (i2 > 0) {
            return new LinearCountingRetryPolicy(i2, this.mDelayBetweenAttemptsInMs);
        }
        return NoRetryPolicy.INSTANCE;
    }
}
