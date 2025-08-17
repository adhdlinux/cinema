package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
class JSCJavaScriptExecutor extends JavaScriptExecutor {
    static {
        ReactBridge.staticInit();
    }

    JSCJavaScriptExecutor(ReadableNativeMap readableNativeMap) {
        super(initHybrid(readableNativeMap));
    }

    private static native HybridData initHybrid(ReadableNativeMap readableNativeMap);

    public String getName() {
        return "JSCJavaScriptExecutor";
    }
}
