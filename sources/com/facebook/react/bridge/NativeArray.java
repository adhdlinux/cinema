package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public abstract class NativeArray implements NativeArrayInterface {
    @DoNotStrip
    private HybridData mHybridData;

    static {
        ReactBridge.staticInit();
    }

    protected NativeArray(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public native String toString();
}
