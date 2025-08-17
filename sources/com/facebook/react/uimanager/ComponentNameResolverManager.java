package com.facebook.react.uimanager;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.soloader.SoLoader;

@DoNotStripAny
public class ComponentNameResolverManager {
    @DoNotStrip
    private final HybridData mHybridData;

    static {
        staticInit();
    }

    public ComponentNameResolverManager(RuntimeExecutor runtimeExecutor, Object obj) {
        this.mHybridData = initHybrid(runtimeExecutor, obj);
        installJSIBindings();
    }

    private native HybridData initHybrid(RuntimeExecutor runtimeExecutor, Object obj);

    private native void installJSIBindings();

    private static void staticInit() {
        SoLoader.loadLibrary("uimanagerjni");
    }
}
