package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class WritableNativeMap extends ReadableNativeMap implements WritableMap {
    static {
        ReactBridge.staticInit();
    }

    public WritableNativeMap() {
        super(initHybrid());
    }

    private static native HybridData initHybrid();

    private native void mergeNativeMap(ReadableNativeMap readableNativeMap);

    private native void putNativeArray(String str, ReadableNativeArray readableNativeArray);

    private native void putNativeMap(String str, ReadableNativeMap readableNativeMap);

    public WritableMap copy() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.merge(this);
        return writableNativeMap;
    }

    public void merge(ReadableMap readableMap) {
        Assertions.assertCondition(readableMap instanceof ReadableNativeMap, "Illegal type provided");
        mergeNativeMap((ReadableNativeMap) readableMap);
    }

    public void putArray(String str, ReadableArray readableArray) {
        boolean z2;
        if (readableArray == null || (readableArray instanceof ReadableNativeArray)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.assertCondition(z2, "Illegal type provided");
        putNativeArray(str, (ReadableNativeArray) readableArray);
    }

    public native void putBoolean(String str, boolean z2);

    public native void putDouble(String str, double d2);

    public native void putInt(String str, int i2);

    public void putMap(String str, ReadableMap readableMap) {
        boolean z2;
        if (readableMap == null || (readableMap instanceof ReadableNativeMap)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.assertCondition(z2, "Illegal type provided");
        putNativeMap(str, (ReadableNativeMap) readableMap);
    }

    public native void putNull(String str);

    public native void putString(String str, String str2);
}
