package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public abstract class BaseConsumer<T> implements Consumer<T> {
    private boolean mIsFinished = false;

    public static boolean isLast(int i2) {
        return (i2 & 1) == 1;
    }

    public static boolean isNotLast(int i2) {
        return !isLast(i2);
    }

    public static int simpleStatusForIsLast(boolean z2) {
        return z2 ? 1 : 0;
    }

    public static boolean statusHasAnyFlag(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public static boolean statusHasFlag(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    public static int turnOffStatusFlag(int i2, int i3) {
        return i2 & (~i3);
    }

    public static int turnOnStatusFlag(int i2, int i3) {
        return i2 | i3;
    }

    public synchronized void onCancellation() {
        if (!this.mIsFinished) {
            this.mIsFinished = true;
            try {
                onCancellationImpl();
            } catch (Exception e2) {
                onUnhandledException(e2);
            }
        } else {
            return;
        }
        return;
    }

    /* access modifiers changed from: protected */
    public abstract void onCancellationImpl();

    public synchronized void onFailure(Throwable th) {
        if (!this.mIsFinished) {
            this.mIsFinished = true;
            try {
                onFailureImpl(th);
            } catch (Exception e2) {
                onUnhandledException(e2);
            }
        } else {
            return;
        }
        return;
    }

    /* access modifiers changed from: protected */
    public abstract void onFailureImpl(Throwable th);

    public synchronized void onNewResult(T t2, int i2) {
        if (!this.mIsFinished) {
            this.mIsFinished = isLast(i2);
            try {
                onNewResultImpl(t2, i2);
            } catch (Exception e2) {
                onUnhandledException(e2);
            }
        } else {
            return;
        }
        return;
    }

    /* access modifiers changed from: protected */
    public abstract void onNewResultImpl(T t2, int i2);

    public synchronized void onProgressUpdate(float f2) {
        if (!this.mIsFinished) {
            try {
                onProgressUpdateImpl(f2);
            } catch (Exception e2) {
                onUnhandledException(e2);
            }
        } else {
            return;
        }
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdateImpl(float f2) {
    }

    /* access modifiers changed from: protected */
    public void onUnhandledException(Exception exc) {
        FLog.wtf(getClass(), "unhandled exception", (Throwable) exc);
    }
}
