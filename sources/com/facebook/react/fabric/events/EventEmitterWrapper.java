package com.facebook.react.fabric.events;

import android.annotation.SuppressLint;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.fabric.FabricSoLoader;
import com.facebook.react.uimanager.events.EventCategoryDef;

@SuppressLint({"MissingNativeLoadLibrary"})
public class EventEmitterWrapper {
    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    static {
        FabricSoLoader.staticInit();
    }

    private EventEmitterWrapper() {
    }

    private static native HybridData initHybrid();

    private native void invokeEvent(String str, NativeMap nativeMap, @EventCategoryDef int i2);

    private native void invokeUniqueEvent(String str, NativeMap nativeMap, int i2);

    private boolean isValid() {
        HybridData hybridData = this.mHybridData;
        if (hybridData != null) {
            return hybridData.isValid();
        }
        return false;
    }

    public synchronized void destroy() {
        HybridData hybridData = this.mHybridData;
        if (hybridData != null) {
            hybridData.resetNative();
        }
    }

    public synchronized void invoke(String str, WritableMap writableMap, @EventCategoryDef int i2) {
        NativeMap nativeMap;
        if (isValid()) {
            if (writableMap == null) {
                nativeMap = new WritableNativeMap();
            } else {
                nativeMap = (NativeMap) writableMap;
            }
            invokeEvent(str, nativeMap, i2);
        }
    }

    public synchronized void invokeUnique(String str, WritableMap writableMap, int i2) {
        NativeMap nativeMap;
        if (isValid()) {
            if (writableMap == null) {
                nativeMap = new WritableNativeMap();
            } else {
                nativeMap = (NativeMap) writableMap;
            }
            invokeUniqueEvent(str, nativeMap, i2);
        }
    }
}
