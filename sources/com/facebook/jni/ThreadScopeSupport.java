package com.facebook.jni;

import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.soloader.nativeloader.NativeLoader;

@DoNotStrip
public class ThreadScopeSupport {
    static {
        NativeLoader.loadLibrary("fbjni");
    }

    @DoNotStrip
    private static void runStdFunction(long j2) {
        runStdFunctionImpl(j2);
    }

    private static native void runStdFunctionImpl(long j2);
}
