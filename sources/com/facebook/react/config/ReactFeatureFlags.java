package com.facebook.react.config;

import com.facebook.proguard.annotations.DoNotStripAny;

@DoNotStripAny
public class ReactFeatureFlags {
    public static boolean dispatchPointerEvents = false;
    public static boolean enableAggressiveEventEmitterCleanup = false;
    public static boolean enableDelayedViewStateDeletion = false;
    public static boolean enableEagerRootViewAttachment = false;
    public static boolean enableFabricLogs = false;
    public static volatile boolean enableFabricRenderer = false;
    public static boolean enableLargeTextMeasureCache = true;
    public static boolean enableLockFreeEventDispatcher = false;
    public static boolean enableRuntimeScheduler = false;
    public static boolean enableRuntimeSchedulerInTurboModule = false;
    public static boolean enableScrollEventThrottle = false;
    public static boolean enableSpannableCache = false;
    public static boolean enableSynchronizationForAnimated = false;
    public static volatile boolean enableTurboModulePromiseAsyncDispatch = false;
    public static boolean insertZReorderBarriersOnViewGroupChildren = true;
    private static boolean mapBufferSerializationEnabled = false;
    public static boolean useGlobalCallbackCleanupScopeUsingRetainJSCallback = false;
    private static boolean useOverflowInset = false;
    public static boolean useTurboModuleManagerCallbackCleanupScope = false;
    public static volatile boolean useTurboModules = false;
    public static volatile boolean warnOnLegacyNativeModuleSystemUse = false;

    public static boolean doesUseOverflowInset() {
        return useOverflowInset;
    }

    public static boolean isMapBufferSerializationEnabled() {
        return mapBufferSerializationEnabled;
    }

    public static void setMapBufferSerializationEnabled(boolean z2) {
        mapBufferSerializationEnabled = z2;
    }

    public static void setUseOverflowInset(boolean z2) {
        useOverflowInset = z2;
    }
}
