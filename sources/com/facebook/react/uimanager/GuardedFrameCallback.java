package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat;

public abstract class GuardedFrameCallback extends ChoreographerCompat.FrameCallback {
    private final ReactContext mReactContext;

    protected GuardedFrameCallback(ReactContext reactContext) {
        this.mReactContext = reactContext;
    }

    public final void doFrame(long j2) {
        try {
            doFrameGuarded(j2);
        } catch (RuntimeException e2) {
            this.mReactContext.handleException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void doFrameGuarded(long j2);
}
