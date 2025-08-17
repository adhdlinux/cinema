package com.vungle.ads.internal.util;

import android.os.CountDownTimer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class SuspendableTimer {
    /* access modifiers changed from: private */
    public final double durationSecs;
    /* access modifiers changed from: private */
    public boolean isCanceled;
    private boolean isPaused;
    private double nextDurationSecs;
    /* access modifiers changed from: private */
    public final Function0<Unit> onFinish;
    /* access modifiers changed from: private */
    public final Function0<Unit> onTick;
    /* access modifiers changed from: private */
    public final boolean repeats;
    private long startTimeMillis;
    private CountDownTimer timer;

    public SuspendableTimer(double d2, boolean z2, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.f(function0, "onTick");
        Intrinsics.f(function02, "onFinish");
        this.durationSecs = d2;
        this.repeats = z2;
        this.onTick = function0;
        this.onFinish = function02;
        this.nextDurationSecs = d2;
    }

    private final CountDownTimer createCountdown(long j2) {
        return new SuspendableTimer$createCountdown$1(j2, this);
    }

    private final long getDurationMillis() {
        return (long) (this.durationSecs * ((double) 1000));
    }

    public static /* synthetic */ void getElapsedMillis$vungle_ads_release$annotations() {
    }

    private final double getElapsedSecs() {
        return (double) (getElapsedMillis$vungle_ads_release() / ((long) 1000));
    }

    private final long getNextDurationMillis() {
        return (long) (this.nextDurationSecs * ((double) 1000));
    }

    public static /* synthetic */ void getNextDurationSecs$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getStartTimeMillis$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getTimer$vungle_ads_release$annotations() {
    }

    public final void cancel() {
        this.isPaused = false;
        this.isCanceled = true;
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
    }

    public final long getElapsedMillis$vungle_ads_release() {
        long currentTimeMillis;
        long j2;
        if (this.isPaused) {
            currentTimeMillis = getDurationMillis();
            j2 = getNextDurationMillis();
        } else {
            currentTimeMillis = System.currentTimeMillis();
            j2 = this.startTimeMillis;
        }
        return currentTimeMillis - j2;
    }

    public final double getNextDurationSecs$vungle_ads_release() {
        return this.nextDurationSecs;
    }

    public final long getStartTimeMillis$vungle_ads_release() {
        return this.startTimeMillis;
    }

    public final CountDownTimer getTimer$vungle_ads_release() {
        return this.timer;
    }

    public final void pause() {
        if (this.timer != null) {
            this.nextDurationSecs -= getElapsedSecs();
            this.isPaused = true;
            CountDownTimer countDownTimer = this.timer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.timer = null;
        }
    }

    public final void reset() {
        cancel();
        start();
    }

    public final void resume() {
        if (this.isPaused) {
            this.isPaused = false;
            start();
        }
    }

    public final void setNextDurationSecs$vungle_ads_release(double d2) {
        this.nextDurationSecs = d2;
    }

    public final void setStartTimeMillis$vungle_ads_release(long j2) {
        this.startTimeMillis = j2;
    }

    public final void setTimer$vungle_ads_release(CountDownTimer countDownTimer) {
        this.timer = countDownTimer;
    }

    public final void start() {
        this.startTimeMillis = System.currentTimeMillis();
        CountDownTimer createCountdown = createCountdown(getNextDurationMillis());
        this.timer = createCountdown;
        if (createCountdown != null) {
            createCountdown.start();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuspendableTimer(double d2, boolean z2, Function0 function0, Function0 function02, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(d2, z2, (i2 & 4) != 0 ? AnonymousClass1.INSTANCE : function0, function02);
    }
}
