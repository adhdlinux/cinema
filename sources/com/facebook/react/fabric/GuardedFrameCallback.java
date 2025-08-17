package com.facebook.react.fabric;

import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat;

public abstract class GuardedFrameCallback extends ChoreographerCompat.FrameCallback {
    private final NativeModuleCallExceptionHandler mExceptionHandler;

    @Deprecated
    protected GuardedFrameCallback(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    public final void doFrame(long j2) {
        try {
            doFrameGuarded(j2);
        } catch (RuntimeException e2) {
            this.mExceptionHandler.handleException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void doFrameGuarded(long j2);

    protected GuardedFrameCallback(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.mExceptionHandler = nativeModuleCallExceptionHandler;
    }
}
