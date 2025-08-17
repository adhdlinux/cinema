package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class WritableNativeArray extends ReadableNativeArray implements WritableArray {
    static {
        ReactBridge.staticInit();
    }

    public WritableNativeArray() {
        super(initHybrid());
    }

    private static native HybridData initHybrid();

    private native void pushNativeArray(ReadableNativeArray readableNativeArray);

    private native void pushNativeMap(ReadableNativeMap readableNativeMap);

    public void pushArray(ReadableArray readableArray) {
        boolean z2;
        if (readableArray == null || (readableArray instanceof ReadableNativeArray)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.assertCondition(z2, "Illegal type provided");
        pushNativeArray((ReadableNativeArray) readableArray);
    }

    public native void pushBoolean(boolean z2);

    public native void pushDouble(double d2);

    public native void pushInt(int i2);

    public void pushMap(ReadableMap readableMap) {
        boolean z2;
        if (readableMap == null || (readableMap instanceof ReadableNativeMap)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.assertCondition(z2, "Illegal type provided");
        pushNativeMap((ReadableNativeMap) readableMap);
    }

    public native void pushNull();

    public native void pushString(String str);
}
