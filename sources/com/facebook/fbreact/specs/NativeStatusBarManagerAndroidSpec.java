package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Map;

public abstract class NativeStatusBarManagerAndroidSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeStatusBarManagerAndroidSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> getTypedExportedConstants();

    @DoNotStrip
    @ReactMethod
    public abstract void setColor(double d2, boolean z2);

    @DoNotStrip
    @ReactMethod
    public abstract void setHidden(boolean z2);

    @DoNotStrip
    @ReactMethod
    public abstract void setStyle(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void setTranslucent(boolean z2);
}
