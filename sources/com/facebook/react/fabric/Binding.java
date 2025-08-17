package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.RuntimeScheduler;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.uimanager.PixelUtil;

@DoNotStrip
@SuppressLint({"MissingNativeLoadLibrary"})
public class Binding {
    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    static {
        FabricSoLoader.staticInit();
    }

    private static native HybridData initHybrid();

    private native void installFabricUIManager(RuntimeExecutor runtimeExecutor, RuntimeScheduler runtimeScheduler, Object obj, EventBeatManager eventBeatManager, ComponentFactory componentFactory, Object obj2);

    private native void uninstallFabricUIManager();

    public native void driveCxxAnimations();

    public native ReadableNativeMap getInspectorDataForInstance(EventEmitterWrapper eventEmitterWrapper);

    public void register(RuntimeExecutor runtimeExecutor, RuntimeScheduler runtimeScheduler, FabricUIManager fabricUIManager, EventBeatManager eventBeatManager, ComponentFactory componentFactory, ReactNativeConfig reactNativeConfig) {
        fabricUIManager.setBinding(this);
        installFabricUIManager(runtimeExecutor, runtimeScheduler, fabricUIManager, eventBeatManager, componentFactory, reactNativeConfig);
        setPixelDensity(PixelUtil.getDisplayMetricDensity());
    }

    public native void registerSurface(SurfaceHandlerBinding surfaceHandlerBinding);

    public native void renderTemplateToSurface(int i2, String str);

    public native void setConstraints(int i2, float f2, float f3, float f4, float f5, float f6, float f7, boolean z2, boolean z3);

    public native void setPixelDensity(float f2);

    public native void startSurface(int i2, String str, NativeMap nativeMap);

    public native void startSurfaceWithConstraints(int i2, String str, NativeMap nativeMap, float f2, float f3, float f4, float f5, float f6, float f7, boolean z2, boolean z3);

    public native void stopSurface(int i2);

    public void unregister() {
        uninstallFabricUIManager();
    }

    public native void unregisterSurface(SurfaceHandlerBinding surfaceHandlerBinding);
}
