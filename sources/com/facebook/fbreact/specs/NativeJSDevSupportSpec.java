package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Map;

public abstract class NativeJSDevSupportSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeJSDevSupportSpec(ReactApplicationContext reactApplicationContext) {
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
    public abstract void onFailure(double d2, String str);

    @DoNotStrip
    @ReactMethod
    public abstract void onSuccess(String str);
}
