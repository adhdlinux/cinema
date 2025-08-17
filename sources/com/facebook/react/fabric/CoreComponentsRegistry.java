package com.facebook.react.fabric;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class CoreComponentsRegistry {
    @DoNotStrip
    private final HybridData mHybridData;

    static {
        SoLoader.loadLibrary("fabricjni");
    }

    @DoNotStrip
    private CoreComponentsRegistry(ComponentFactory componentFactory) {
        this.mHybridData = initHybrid(componentFactory);
    }

    @DoNotStrip
    private native HybridData initHybrid(ComponentFactory componentFactory);

    @DoNotStrip
    public static CoreComponentsRegistry register(ComponentFactory componentFactory) {
        return new CoreComponentsRegistry(componentFactory);
    }
}
