package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeVibrationSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeVibrationSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void cancel();

    @DoNotStrip
    @ReactMethod
    public abstract void vibrate(double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void vibrateByPattern(ReadableArray readableArray, double d2);
}
