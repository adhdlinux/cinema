package com.vungle.ads.internal.signals;

import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.Logger;

public final class SignalManager$registerNotifications$1 extends ActivityManager.LifeCycleCallback {
    final /* synthetic */ SignalManager this$0;

    SignalManager$registerNotifications$1(SignalManager signalManager) {
        this.this$0 = signalManager;
    }

    public void onBackground() {
        Logger.Companion.d("SignalManager", "SignalManager#onBackground()");
        this.this$0.setEnterBackgroundTime(System.currentTimeMillis());
        SignalManager signalManager = this.this$0;
        signalManager.setSessionDuration(signalManager.getSessionDuration() + (this.this$0.getEnterBackgroundTime() - this.this$0.getEnterForegroundTime()));
    }

    public void onForeground() {
        Logger.Companion.d("SignalManager", "SignalManager#onForeground()");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.this$0.getEnterBackgroundTime() > ConfigManager.INSTANCE.getSignalsSessionTimeout()) {
            this.this$0.createNewSessionData();
        }
        this.this$0.setEnterForegroundTime(currentTimeMillis);
        this.this$0.setEnterBackgroundTime(0);
    }
}
