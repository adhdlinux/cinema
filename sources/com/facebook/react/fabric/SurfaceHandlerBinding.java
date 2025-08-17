package com.facebook.react.fabric;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SurfaceHandlerBinding implements SurfaceHandler {
    public static final int DISPLAY_MODE_HIDDEN = 2;
    public static final int DISPLAY_MODE_SUSPENDED = 1;
    public static final int DISPLAY_MODE_VISIBLE = 0;
    private static final int NO_SURFACE_ID = 0;
    @DoNotStrip
    private final HybridData mHybridData;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayModeTypeDef {
    }

    static {
        FabricSoLoader.staticInit();
    }

    public SurfaceHandlerBinding(String str) {
        this.mHybridData = initHybrid(0, str);
    }

    private native String getModuleNameNative();

    private native int getSurfaceIdNative();

    private static native HybridData initHybrid(int i2, String str);

    private native boolean isRunningNative();

    private native void setDisplayModeNative(int i2);

    private native void setLayoutConstraintsNative(float f2, float f3, float f4, float f5, float f6, float f7, boolean z2, boolean z3, float f8);

    private native void setPropsNative(NativeMap nativeMap);

    private native void setSurfaceIdNative(int i2);

    private native void startNative();

    private native void stopNative();

    public String getModuleName() {
        return getModuleNameNative();
    }

    public int getSurfaceId() {
        return getSurfaceIdNative();
    }

    public boolean isRunning() {
        return isRunningNative();
    }

    public void setLayoutConstraints(int i2, int i3, int i4, int i5, boolean z2, boolean z3, float f2) {
        setLayoutConstraintsNative(LayoutMetricsConversions.getMinSize(i2) / f2, LayoutMetricsConversions.getMaxSize(i2) / f2, LayoutMetricsConversions.getMinSize(i3) / f2, LayoutMetricsConversions.getMaxSize(i3) / f2, ((float) i4) / f2, ((float) i5) / f2, z2, z3, f2);
    }

    public void setMountable(boolean z2) {
        setDisplayModeNative(z2 ^ true ? 1 : 0);
    }

    public void setProps(NativeMap nativeMap) {
        setPropsNative(nativeMap);
    }

    public void setSurfaceId(int i2) {
        setSurfaceIdNative(i2);
    }

    public void start() {
        startNative();
    }

    public void stop() {
        stopNative();
    }
}
