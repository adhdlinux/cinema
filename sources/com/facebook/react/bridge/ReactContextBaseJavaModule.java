package com.facebook.react.bridge;

import android.app.Activity;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;

public abstract class ReactContextBaseJavaModule extends BaseJavaModule {
    private final ReactApplicationContext mReactApplicationContext;

    public ReactContextBaseJavaModule() {
        this.mReactApplicationContext = null;
    }

    /* access modifiers changed from: protected */
    public final Activity getCurrentActivity() {
        return this.mReactApplicationContext.getCurrentActivity();
    }

    /* access modifiers changed from: protected */
    public final ReactApplicationContext getReactApplicationContext() {
        return (ReactApplicationContext) Assertions.assertNotNull(this.mReactApplicationContext, "Tried to get ReactApplicationContext even though NativeModule wasn't instantiated with one");
    }

    /* access modifiers changed from: protected */
    @ThreadConfined("ANY")
    public final ReactApplicationContext getReactApplicationContextIfActiveOrWarn() {
        if (this.mReactApplicationContext.hasActiveReactInstance()) {
            return this.mReactApplicationContext;
        }
        ReactSoftExceptionLogger.logSoftException("ReactContextBaseJavaModule", new RuntimeException("Catalyst Instance has already disappeared: requested by " + getName()));
        return null;
    }

    public ReactContextBaseJavaModule(ReactApplicationContext reactApplicationContext) {
        this.mReactApplicationContext = reactApplicationContext;
    }
}
