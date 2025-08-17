package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Map;

public abstract class NativeI18nManagerSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeI18nManagerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void allowRTL(boolean z2);

    @DoNotStrip
    @ReactMethod
    public abstract void forceRTL(boolean z2);

    @DoNotStrip
    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> getTypedExportedConstants();

    @DoNotStrip
    @ReactMethod
    public abstract void swapLeftAndRightInRTL(boolean z2);
}
