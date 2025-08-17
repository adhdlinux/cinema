package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class CxxCallbackImpl implements Callback {
    @DoNotStrip
    private final HybridData mHybridData;

    @DoNotStrip
    private CxxCallbackImpl(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    private native void nativeInvoke(NativeArray nativeArray);

    public void invoke(Object... objArr) {
        nativeInvoke(Arguments.fromJavaArgs(objArr));
    }
}
