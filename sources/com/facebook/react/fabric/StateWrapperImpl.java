package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import com.facebook.common.logging.FLog;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.uimanager.StateWrapper;

@DoNotStrip
@SuppressLint({"MissingNativeLoadLibrary"})
public class StateWrapperImpl implements StateWrapper {
    private static final String TAG = "StateWrapperImpl";
    private volatile boolean mDestroyed = false;
    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    static {
        FabricSoLoader.staticInit();
    }

    private StateWrapperImpl() {
    }

    private native ReadableNativeMap getStateDataImpl();

    private native ReadableMapBuffer getStateMapBufferDataImpl();

    private static native HybridData initHybrid();

    public void destroyState() {
        if (!this.mDestroyed) {
            this.mDestroyed = true;
            this.mHybridData.resetNative();
        }
    }

    public ReadableNativeMap getStateData() {
        if (!this.mDestroyed) {
            return getStateDataImpl();
        }
        FLog.e(TAG, "Race between StateWrapperImpl destruction and getState");
        return null;
    }

    public ReadableMapBuffer getStateDataMapBuffer() {
        if (!this.mDestroyed) {
            return getStateMapBufferDataImpl();
        }
        FLog.e(TAG, "Race between StateWrapperImpl destruction and getState");
        return null;
    }

    public void updateState(WritableMap writableMap) {
        if (this.mDestroyed) {
            FLog.e(TAG, "Race between StateWrapperImpl destruction and updateState");
        } else {
            updateStateImpl((NativeMap) writableMap);
        }
    }

    public native void updateStateImpl(NativeMap nativeMap);
}
