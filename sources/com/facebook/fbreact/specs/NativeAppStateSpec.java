package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Map;

public abstract class NativeAppStateSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeAppStateSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }

    @DoNotStrip
    @ReactMethod
    public abstract void getCurrentAppState(Callback callback, Callback callback2);

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> getTypedExportedConstants();

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d2);
}
