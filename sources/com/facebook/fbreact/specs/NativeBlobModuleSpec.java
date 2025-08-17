package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Map;

public abstract class NativeBlobModuleSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeBlobModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void addNetworkingHandler();

    @DoNotStrip
    @ReactMethod
    public abstract void addWebSocketHandler(double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void createFromParts(ReadableArray readableArray, String str);

    @DoNotStrip
    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> getTypedExportedConstants();

    @DoNotStrip
    @ReactMethod
    public abstract void release(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void removeWebSocketHandler(double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void sendOverSocket(ReadableMap readableMap, double d2);
}
