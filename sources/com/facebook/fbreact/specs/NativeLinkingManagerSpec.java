package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeLinkingManagerSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeLinkingManagerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void canOpenURL(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void getInitialURL(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void openSettings(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void openURL(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d2);
}
