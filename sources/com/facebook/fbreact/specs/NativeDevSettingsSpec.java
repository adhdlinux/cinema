package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeDevSettingsSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeDevSettingsSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void addMenuItem(String str);

    @DoNotStrip
    @ReactMethod
    public void onFastRefresh() {
    }

    @DoNotStrip
    @ReactMethod
    public abstract void reload();

    @DoNotStrip
    @ReactMethod
    public void reloadWithReason(String str) {
    }

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void setHotLoadingEnabled(boolean z2);

    @DoNotStrip
    @ReactMethod
    public abstract void setIsDebuggingRemotely(boolean z2);

    @DoNotStrip
    @ReactMethod
    public abstract void setIsShakeToShowDevMenuEnabled(boolean z2);

    @DoNotStrip
    @ReactMethod
    public abstract void setProfilingEnabled(boolean z2);

    @DoNotStrip
    @ReactMethod
    public abstract void toggleElementInspector();
}
