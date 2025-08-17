package com.facebook.react.modules.core;

import com.facebook.react.bridge.WritableArray;

public interface JavaScriptTimerExecutor {
    void callIdleCallbacks(double d2);

    void callTimers(WritableArray writableArray);

    void emitTimeDriftWarning(String str);
}
