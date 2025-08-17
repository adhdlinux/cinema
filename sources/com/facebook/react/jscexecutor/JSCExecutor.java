package com.facebook.react.jscexecutor;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class JSCExecutor extends JavaScriptExecutor {
    static {
        loadLibrary();
    }

    JSCExecutor(ReadableNativeMap readableNativeMap) {
        super(initHybrid(readableNativeMap));
    }

    private static native HybridData initHybrid(ReadableNativeMap readableNativeMap);

    public static void loadLibrary() throws UnsatisfiedLinkError {
        SoLoader.loadLibrary("jscexecutor");
    }

    public String getName() {
        return "JSCExecutor";
    }
}
