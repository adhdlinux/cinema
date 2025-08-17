package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class CxxModuleWrapperBase implements NativeModule {
    @DoNotStrip
    private HybridData mHybridData;

    static {
        ReactBridge.staticInit();
    }

    protected CxxModuleWrapperBase(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public boolean canOverrideExistingModule() {
        return false;
    }

    public native String getName();

    public void initialize() {
    }

    public void invalidate() {
        this.mHybridData.resetNative();
    }

    public void onCatalystInstanceDestroy() {
    }

    /* access modifiers changed from: protected */
    public void resetModule(HybridData hybridData) {
        HybridData hybridData2 = this.mHybridData;
        if (hybridData != hybridData2) {
            hybridData2.resetNative();
            this.mHybridData = hybridData;
        }
    }
}
