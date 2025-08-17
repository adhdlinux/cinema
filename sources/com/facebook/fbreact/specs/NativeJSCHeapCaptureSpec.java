package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeJSCHeapCaptureSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeJSCHeapCaptureSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void captureComplete(String str, String str2);
}
