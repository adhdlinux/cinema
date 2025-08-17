package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeExceptionsManagerSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeExceptionsManagerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public void dismissRedbox() {
    }

    @DoNotStrip
    @ReactMethod
    public void reportException(ReadableMap readableMap) {
    }

    @DoNotStrip
    @ReactMethod
    public abstract void reportFatalException(String str, ReadableArray readableArray, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void reportSoftException(String str, ReadableArray readableArray, double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void updateExceptionMessage(String str, ReadableArray readableArray, double d2);
}
