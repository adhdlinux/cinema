package com.facebook.fresco.ui.common;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface LoggingListener {
    void onFadeFinished(String str);

    void onFadeStarted(String str);
}
