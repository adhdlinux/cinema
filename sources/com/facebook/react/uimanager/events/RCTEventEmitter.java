package com.facebook.react.uimanager.events;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

@DoNotStrip
@Deprecated
public interface RCTEventEmitter extends JavaScriptModule {
    @Deprecated
    void receiveEvent(int i2, String str, WritableMap writableMap);

    void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2);
}
