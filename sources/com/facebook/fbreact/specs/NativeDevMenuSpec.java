package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeDevMenuSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeDevMenuSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void debugRemotely(boolean z2);

    @DoNotStrip
    @ReactMethod
    public abstract void reload();

    @DoNotStrip
    @ReactMethod
    public abstract void setHotLoadingEnabled(boolean z2);

    @DoNotStrip
    @ReactMethod
    public abstract void setProfilingEnabled(boolean z2);

    @DoNotStrip
    @ReactMethod
    public abstract void show();
}
