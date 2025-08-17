package com.vungle.ads.internal.util;

import android.os.CountDownTimer;

public final class SuspendableTimer$createCountdown$1 extends CountDownTimer {
    final /* synthetic */ SuspendableTimer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuspendableTimer$createCountdown$1(long j2, SuspendableTimer suspendableTimer) {
        super(j2, j2);
        this.this$0 = suspendableTimer;
    }

    public void onFinish() {
        SuspendableTimer suspendableTimer = this.this$0;
        suspendableTimer.onFinish.invoke();
        if (!suspendableTimer.repeats || suspendableTimer.isCanceled) {
            suspendableTimer.cancel();
            return;
        }
        suspendableTimer.setNextDurationSecs$vungle_ads_release(suspendableTimer.durationSecs);
        suspendableTimer.start();
    }

    public void onTick(long j2) {
        this.this$0.onTick.invoke();
    }
}
