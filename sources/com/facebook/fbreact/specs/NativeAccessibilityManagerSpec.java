package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeAccessibilityManagerSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeAccessibilityManagerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void announceForAccessibility(String str);

    @DoNotStrip
    @ReactMethod
    public void announceForAccessibilityWithOptions(String str, ReadableMap readableMap) {
    }

    @DoNotStrip
    @ReactMethod
    public abstract void getCurrentBoldTextState(Callback callback, Callback callback2);

    @DoNotStrip
    @ReactMethod
    public abstract void getCurrentGrayscaleState(Callback callback, Callback callback2);

    @DoNotStrip
    @ReactMethod
    public abstract void getCurrentInvertColorsState(Callback callback, Callback callback2);

    @DoNotStrip
    @ReactMethod
    public abstract void getCurrentReduceMotionState(Callback callback, Callback callback2);

    @DoNotStrip
    @ReactMethod
    public abstract void getCurrentReduceTransparencyState(Callback callback, Callback callback2);

    @DoNotStrip
    @ReactMethod
    public abstract void getCurrentVoiceOverState(Callback callback, Callback callback2);

    @DoNotStrip
    @ReactMethod
    public abstract void setAccessibilityContentSizeMultipliers(ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void setAccessibilityFocus(double d2);
}
