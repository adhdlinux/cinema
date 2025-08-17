package com.facebook.react.bridge;

import android.content.res.AssetManager;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.bridge.queue.ReactQueueConfigurationImpl;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.TraceListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@DoNotStrip
public class CatalystInstanceImpl implements CatalystInstance {
    private static final AtomicInteger sNextInstanceIdForTrace = new AtomicInteger(1);
    private volatile boolean mAcceptCalls;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<NotThreadSafeBridgeIdleDebugListener> mBridgeIdleListeners;
    private volatile boolean mDestroyed;
    /* access modifiers changed from: private */
    public final HybridData mHybridData;
    private boolean mInitialized;
    private boolean mJSBundleHasLoaded;
    private final JSBundleLoader mJSBundleLoader;
    private final ArrayList<PendingJSCall> mJSCallsPendingInit;
    private final Object mJSCallsPendingInitLock;
    /* access modifiers changed from: private */
    public final JSIModuleRegistry mJSIModuleRegistry;
    private final JavaScriptModuleRegistry mJSModuleRegistry;
    /* access modifiers changed from: private */
    public JavaScriptContextHolder mJavaScriptContextHolder;
    private final String mJsPendingCallsTitleForTrace;
    private final NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
    /* access modifiers changed from: private */
    public final NativeModuleRegistry mNativeModuleRegistry;
    private final MessageQueueThread mNativeModulesQueueThread;
    /* access modifiers changed from: private */
    public final AtomicInteger mPendingJSCalls;
    private final ReactQueueConfigurationImpl mReactQueueConfiguration;
    private String mSourceURL;
    private final TraceListener mTraceListener;
    /* access modifiers changed from: private */
    public JSIModule mTurboModuleManagerJSIModule;
    private volatile TurboModuleRegistry mTurboModuleRegistry;

    private static class BridgeCallback implements ReactCallback {
        private final WeakReference<CatalystInstanceImpl> mOuter;

        BridgeCallback(CatalystInstanceImpl catalystInstanceImpl) {
            this.mOuter = new WeakReference<>(catalystInstanceImpl);
        }

        public void decrementPendingJSCalls() {
            CatalystInstanceImpl catalystInstanceImpl = this.mOuter.get();
            if (catalystInstanceImpl != null) {
                catalystInstanceImpl.decrementPendingJSCalls();
            }
        }

        public void incrementPendingJSCalls() {
            CatalystInstanceImpl catalystInstanceImpl = this.mOuter.get();
            if (catalystInstanceImpl != null) {
                catalystInstanceImpl.incrementPendingJSCalls();
            }
        }

        public void onBatchComplete() {
            CatalystInstanceImpl catalystInstanceImpl = this.mOuter.get();
            if (catalystInstanceImpl != null) {
                catalystInstanceImpl.mNativeModuleRegistry.onBatchComplete();
            }
        }
    }

    public static class Builder {
        private JSBundleLoader mJSBundleLoader;
        private JavaScriptExecutor mJSExecutor;
        private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
        private ReactQueueConfigurationSpec mReactQueueConfigurationSpec;
        private NativeModuleRegistry mRegistry;

        public CatalystInstanceImpl build() {
            return new CatalystInstanceImpl((ReactQueueConfigurationSpec) Assertions.assertNotNull(this.mReactQueueConfigurationSpec), (JavaScriptExecutor) Assertions.assertNotNull(this.mJSExecutor), (NativeModuleRegistry) Assertions.assertNotNull(this.mRegistry), (JSBundleLoader) Assertions.assertNotNull(this.mJSBundleLoader), (NativeModuleCallExceptionHandler) Assertions.assertNotNull(this.mNativeModuleCallExceptionHandler));
        }

        public Builder setJSBundleLoader(JSBundleLoader jSBundleLoader) {
            this.mJSBundleLoader = jSBundleLoader;
            return this;
        }

        public Builder setJSExecutor(JavaScriptExecutor javaScriptExecutor) {
            this.mJSExecutor = javaScriptExecutor;
            return this;
        }

        public Builder setNativeModuleCallExceptionHandler(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
            this.mNativeModuleCallExceptionHandler = nativeModuleCallExceptionHandler;
            return this;
        }

        public Builder setReactQueueConfigurationSpec(ReactQueueConfigurationSpec reactQueueConfigurationSpec) {
            this.mReactQueueConfigurationSpec = reactQueueConfigurationSpec;
            return this;
        }

        public Builder setRegistry(NativeModuleRegistry nativeModuleRegistry) {
            this.mRegistry = nativeModuleRegistry;
            return this;
        }
    }

    private static class JSProfilerTraceListener implements TraceListener {
        private final WeakReference<CatalystInstanceImpl> mOuter;

        public JSProfilerTraceListener(CatalystInstanceImpl catalystInstanceImpl) {
            this.mOuter = new WeakReference<>(catalystInstanceImpl);
        }

        public void onTraceStarted() {
            CatalystInstanceImpl catalystInstanceImpl = this.mOuter.get();
            if (catalystInstanceImpl != null) {
                ((Systrace) catalystInstanceImpl.getJSModule(Systrace.class)).setEnabled(true);
            }
        }

        public void onTraceStopped() {
            CatalystInstanceImpl catalystInstanceImpl = this.mOuter.get();
            if (catalystInstanceImpl != null) {
                ((Systrace) catalystInstanceImpl.getJSModule(Systrace.class)).setEnabled(false);
            }
        }
    }

    private class NativeExceptionHandler implements QueueThreadExceptionHandler {
        private NativeExceptionHandler() {
        }

        public void handleException(Exception exc) {
            CatalystInstanceImpl.this.onNativeException(exc);
        }
    }

    public static class PendingJSCall {
        public NativeArray mArguments;
        public String mMethod;
        public String mModule;

        public PendingJSCall(String str, String str2, NativeArray nativeArray) {
            this.mModule = str;
            this.mMethod = str2;
            this.mArguments = nativeArray;
        }

        /* access modifiers changed from: package-private */
        public void call(CatalystInstanceImpl catalystInstanceImpl) {
            NativeArray nativeArray = this.mArguments;
            if (nativeArray == null) {
                nativeArray = new WritableNativeArray();
            }
            catalystInstanceImpl.jniCallJSFunction(this.mModule, this.mMethod, nativeArray);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mModule);
            sb.append(".");
            sb.append(this.mMethod);
            sb.append("(");
            NativeArray nativeArray = this.mArguments;
            if (nativeArray == null) {
                str = "";
            } else {
                str = nativeArray.toString();
            }
            sb.append(str);
            sb.append(")");
            return sb.toString();
        }
    }

    static {
        ReactBridge.staticInit();
    }

    /* access modifiers changed from: private */
    public void decrementPendingJSCalls() {
        boolean z2;
        int decrementAndGet = this.mPendingJSCalls.decrementAndGet();
        if (decrementAndGet == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Systrace.traceCounter(0, this.mJsPendingCallsTitleForTrace, decrementAndGet);
        if (z2 && !this.mBridgeIdleListeners.isEmpty()) {
            this.mNativeModulesQueueThread.runOnQueue(new Runnable() {
                public void run() {
                    Iterator it2 = CatalystInstanceImpl.this.mBridgeIdleListeners.iterator();
                    while (it2.hasNext()) {
                        ((NotThreadSafeBridgeIdleDebugListener) it2.next()).onTransitionToBridgeIdle();
                    }
                }
            });
        }
    }

    private native long getJavaScriptContext();

    private <T extends NativeModule> String getNameFromAnnotation(Class<T> cls) {
        ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
        if (reactModule != null) {
            return reactModule.name();
        }
        throw new IllegalArgumentException("Could not find @ReactModule annotation in " + cls.getCanonicalName());
    }

    private TurboModuleRegistry getTurboModuleRegistry() {
        if (ReactFeatureFlags.useTurboModules) {
            return (TurboModuleRegistry) Assertions.assertNotNull(this.mTurboModuleRegistry, "TurboModules are enabled, but mTurboModuleRegistry hasn't been set.");
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void incrementPendingJSCalls() {
        boolean z2;
        int andIncrement = this.mPendingJSCalls.getAndIncrement();
        if (andIncrement == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Systrace.traceCounter(0, this.mJsPendingCallsTitleForTrace, andIncrement + 1);
        if (z2 && !this.mBridgeIdleListeners.isEmpty()) {
            this.mNativeModulesQueueThread.runOnQueue(new Runnable() {
                public void run() {
                    Iterator it2 = CatalystInstanceImpl.this.mBridgeIdleListeners.iterator();
                    while (it2.hasNext()) {
                        ((NotThreadSafeBridgeIdleDebugListener) it2.next()).onTransitionToBridgeBusy();
                    }
                }
            });
        }
    }

    private static native HybridData initHybrid(boolean z2, boolean z3);

    private native void initializeBridge(ReactCallback reactCallback, JavaScriptExecutor javaScriptExecutor, MessageQueueThread messageQueueThread, MessageQueueThread messageQueueThread2, Collection<JavaModuleWrapper> collection, Collection<ModuleHolder> collection2);

    private native void jniCallJSCallback(int i2, NativeArray nativeArray);

    /* access modifiers changed from: private */
    public native void jniCallJSFunction(String str, String str2, NativeArray nativeArray);

    private native void jniExtendNativeModules(Collection<JavaModuleWrapper> collection, Collection<ModuleHolder> collection2);

    private native void jniHandleMemoryPressure(int i2);

    private native void jniLoadScriptFromAssets(AssetManager assetManager, String str, boolean z2);

    private native void jniLoadScriptFromFile(String str, String str2, boolean z2);

    private native void jniRegisterSegment(int i2, String str);

    private native void jniSetSourceURL(String str);

    /* access modifiers changed from: private */
    public void onNativeException(Exception exc) {
        this.mNativeModuleCallExceptionHandler.handleException(exc);
        this.mReactQueueConfiguration.getUIQueueThread().runOnQueue(new Runnable() {
            public void run() {
                CatalystInstanceImpl.this.destroy();
            }
        });
    }

    private native void warnOnLegacyNativeModuleSystemUse();

    public void addBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        this.mBridgeIdleListeners.add(notThreadSafeBridgeIdleDebugListener);
    }

    public void addJSIModules(List<JSIModuleSpec> list) {
        this.mJSIModuleRegistry.registerModules(list);
    }

    public void callFunction(String str, String str2, NativeArray nativeArray) {
        callFunction(new PendingJSCall(str, str2, nativeArray));
    }

    @ThreadConfined("UI")
    public void destroy() {
        FLog.d(ReactConstants.TAG, "CatalystInstanceImpl.destroy() start");
        UiThreadUtil.assertOnUiThread();
        if (!this.mDestroyed) {
            ReactMarker.logMarker(ReactMarkerConstants.DESTROY_CATALYST_INSTANCE_START);
            this.mDestroyed = true;
            this.mNativeModulesQueueThread.runOnQueue(new Runnable() {
                public void run() {
                    CatalystInstanceImpl.this.mNativeModuleRegistry.notifyJSInstanceDestroy();
                    CatalystInstanceImpl.this.mJSIModuleRegistry.notifyJSInstanceDestroy();
                    boolean z2 = false;
                    if (CatalystInstanceImpl.this.mPendingJSCalls.getAndSet(0) == 0) {
                        z2 = true;
                    }
                    if (!CatalystInstanceImpl.this.mBridgeIdleListeners.isEmpty()) {
                        Iterator it2 = CatalystInstanceImpl.this.mBridgeIdleListeners.iterator();
                        while (it2.hasNext()) {
                            NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener = (NotThreadSafeBridgeIdleDebugListener) it2.next();
                            if (!z2) {
                                notThreadSafeBridgeIdleDebugListener.onTransitionToBridgeIdle();
                            }
                            notThreadSafeBridgeIdleDebugListener.onBridgeDestroyed();
                        }
                    }
                    CatalystInstanceImpl.this.getReactQueueConfiguration().getJSQueueThread().runOnQueue(new Runnable() {
                        public void run() {
                            if (CatalystInstanceImpl.this.mTurboModuleManagerJSIModule != null) {
                                CatalystInstanceImpl.this.mTurboModuleManagerJSIModule.onCatalystInstanceDestroy();
                            }
                            CatalystInstanceImpl.this.getReactQueueConfiguration().getUIQueueThread().runOnQueue(new Runnable() {
                                public void run() {
                                    AsyncTask.execute(new Runnable() {
                                        public void run() {
                                            CatalystInstanceImpl.this.mJavaScriptContextHolder.clear();
                                            CatalystInstanceImpl.this.mHybridData.resetNative();
                                            CatalystInstanceImpl.this.getReactQueueConfiguration().destroy();
                                            FLog.d(ReactConstants.TAG, "CatalystInstanceImpl.destroy() end");
                                            ReactMarker.logMarker(ReactMarkerConstants.DESTROY_CATALYST_INSTANCE_END);
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });
            Systrace.unregisterListener(this.mTraceListener);
        }
    }

    public void extendNativeModules(NativeModuleRegistry nativeModuleRegistry) {
        this.mNativeModuleRegistry.registerModules(nativeModuleRegistry);
        jniExtendNativeModules(nativeModuleRegistry.getJavaModules(this), nativeModuleRegistry.getCxxModules());
    }

    public native CallInvokerHolderImpl getJSCallInvokerHolder();

    public JSIModule getJSIModule(JSIModuleType jSIModuleType) {
        return this.mJSIModuleRegistry.getModule(jSIModuleType);
    }

    public <T extends JavaScriptModule> T getJSModule(Class<T> cls) {
        return this.mJSModuleRegistry.getJavaScriptModule(this, cls);
    }

    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.mJavaScriptContextHolder;
    }

    public native CallInvokerHolderImpl getNativeCallInvokerHolder();

    public <T extends NativeModule> T getNativeModule(Class<T> cls) {
        return getNativeModule(getNameFromAnnotation(cls));
    }

    public Collection<NativeModule> getNativeModules() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mNativeModuleRegistry.getAllModules());
        if (getTurboModuleRegistry() != null) {
            Iterator<TurboModule> it2 = getTurboModuleRegistry().getModules().iterator();
            while (it2.hasNext()) {
                arrayList.add((NativeModule) it2.next());
            }
        }
        return arrayList;
    }

    public ReactQueueConfiguration getReactQueueConfiguration() {
        return this.mReactQueueConfiguration;
    }

    public native RuntimeExecutor getRuntimeExecutor();

    public native RuntimeScheduler getRuntimeScheduler();

    public String getSourceURL() {
        return this.mSourceURL;
    }

    public void handleMemoryPressure(int i2) {
        if (!this.mDestroyed) {
            jniHandleMemoryPressure(i2);
        }
    }

    public <T extends NativeModule> boolean hasNativeModule(Class<T> cls) {
        String nameFromAnnotation = getNameFromAnnotation(cls);
        if (getTurboModuleRegistry() == null || !getTurboModuleRegistry().hasModule(nameFromAnnotation)) {
            return this.mNativeModuleRegistry.hasModule(nameFromAnnotation);
        }
        return true;
    }

    public boolean hasRunJSBundle() {
        boolean z2;
        synchronized (this.mJSCallsPendingInitLock) {
            if (!this.mJSBundleHasLoaded || !this.mAcceptCalls) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        return z2;
    }

    @VisibleForTesting
    public void initialize() {
        FLog.d(ReactConstants.TAG, "CatalystInstanceImpl.initialize()");
        Assertions.assertCondition(!this.mInitialized, "This catalyst instance has already been initialized");
        Assertions.assertCondition(this.mAcceptCalls, "RunJSBundle hasn't completed.");
        this.mInitialized = true;
        this.mNativeModulesQueueThread.runOnQueue(new Runnable() {
            public void run() {
                CatalystInstanceImpl.this.mNativeModuleRegistry.notifyJSInstanceInitialized();
            }
        });
    }

    public void invokeCallback(int i2, NativeArrayInterface nativeArrayInterface) {
        if (this.mDestroyed) {
            FLog.w(ReactConstants.TAG, "Invoking JS callback after bridge has been destroyed.");
        } else {
            jniCallJSCallback(i2, (NativeArray) nativeArrayInterface);
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public void loadScriptFromAssets(AssetManager assetManager, String str, boolean z2) {
        this.mSourceURL = str;
        jniLoadScriptFromAssets(assetManager, str, z2);
    }

    public void loadScriptFromFile(String str, String str2, boolean z2) {
        this.mSourceURL = str2;
        jniLoadScriptFromFile(str, str2, z2);
    }

    public void loadSplitBundleFromFile(String str, String str2) {
        jniLoadScriptFromFile(str, str2, false);
    }

    public void registerSegment(int i2, String str) {
        jniRegisterSegment(i2, str);
    }

    public void removeBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        this.mBridgeIdleListeners.remove(notThreadSafeBridgeIdleDebugListener);
    }

    public void runJSBundle() {
        FLog.d(ReactConstants.TAG, "CatalystInstanceImpl.runJSBundle()");
        Assertions.assertCondition(!this.mJSBundleHasLoaded, "JS bundle was already loaded!");
        this.mJSBundleLoader.loadScript(this);
        synchronized (this.mJSCallsPendingInitLock) {
            this.mAcceptCalls = true;
            Iterator<PendingJSCall> it2 = this.mJSCallsPendingInit.iterator();
            while (it2.hasNext()) {
                it2.next().call(this);
            }
            this.mJSCallsPendingInit.clear();
            this.mJSBundleHasLoaded = true;
        }
        Systrace.registerListener(this.mTraceListener);
    }

    public native void setGlobalVariable(String str, String str2);

    public void setSourceURLs(String str, String str2) {
        this.mSourceURL = str;
        jniSetSourceURL(str2);
    }

    public void setTurboModuleManager(JSIModule jSIModule) {
        this.mTurboModuleRegistry = (TurboModuleRegistry) jSIModule;
        this.mTurboModuleManagerJSIModule = jSIModule;
    }

    private CatalystInstanceImpl(ReactQueueConfigurationSpec reactQueueConfigurationSpec, JavaScriptExecutor javaScriptExecutor, NativeModuleRegistry nativeModuleRegistry, JSBundleLoader jSBundleLoader, NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        NativeModuleRegistry nativeModuleRegistry2 = nativeModuleRegistry;
        this.mPendingJSCalls = new AtomicInteger(0);
        this.mJsPendingCallsTitleForTrace = "pending_js_calls_instance" + sNextInstanceIdForTrace.getAndIncrement();
        this.mDestroyed = false;
        this.mJSCallsPendingInit = new ArrayList<>();
        this.mJSCallsPendingInitLock = new Object();
        this.mJSIModuleRegistry = new JSIModuleRegistry();
        this.mInitialized = false;
        this.mAcceptCalls = false;
        this.mTurboModuleRegistry = null;
        this.mTurboModuleManagerJSIModule = null;
        FLog.d(ReactConstants.TAG, "Initializing React Xplat Bridge.");
        Systrace.beginSection(0, "createCatalystInstanceImpl");
        if (ReactFeatureFlags.enableRuntimeSchedulerInTurboModule && !ReactFeatureFlags.enableRuntimeScheduler) {
            Assertions.assertUnreachable();
        }
        this.mHybridData = initHybrid(ReactFeatureFlags.enableRuntimeScheduler, ReactFeatureFlags.enableRuntimeSchedulerInTurboModule);
        ReactQueueConfigurationSpec reactQueueConfigurationSpec2 = reactQueueConfigurationSpec;
        ReactQueueConfigurationImpl create = ReactQueueConfigurationImpl.create(reactQueueConfigurationSpec, new NativeExceptionHandler());
        this.mReactQueueConfiguration = create;
        this.mBridgeIdleListeners = new CopyOnWriteArrayList<>();
        this.mNativeModuleRegistry = nativeModuleRegistry2;
        this.mJSModuleRegistry = new JavaScriptModuleRegistry();
        this.mJSBundleLoader = jSBundleLoader;
        this.mNativeModuleCallExceptionHandler = nativeModuleCallExceptionHandler;
        MessageQueueThread nativeModulesQueueThread = create.getNativeModulesQueueThread();
        this.mNativeModulesQueueThread = nativeModulesQueueThread;
        this.mTraceListener = new JSProfilerTraceListener(this);
        Systrace.endSection(0);
        FLog.d(ReactConstants.TAG, "Initializing React Xplat Bridge before initializeBridge");
        Systrace.beginSection(0, "initializeCxxBridge");
        if (ReactFeatureFlags.warnOnLegacyNativeModuleSystemUse) {
            warnOnLegacyNativeModuleSystemUse();
        }
        initializeBridge(new BridgeCallback(this), javaScriptExecutor, create.getJSQueueThread(), nativeModulesQueueThread, nativeModuleRegistry.getJavaModules(this), nativeModuleRegistry.getCxxModules());
        FLog.d(ReactConstants.TAG, "Initializing React Xplat Bridge after initializeBridge");
        Systrace.endSection(0);
        this.mJavaScriptContextHolder = new JavaScriptContextHolder(getJavaScriptContext());
    }

    public void callFunction(PendingJSCall pendingJSCall) {
        if (this.mDestroyed) {
            String pendingJSCall2 = pendingJSCall.toString();
            FLog.w(ReactConstants.TAG, "Calling JS function after bridge has been destroyed: " + pendingJSCall2);
            return;
        }
        if (!this.mAcceptCalls) {
            synchronized (this.mJSCallsPendingInitLock) {
                if (!this.mAcceptCalls) {
                    this.mJSCallsPendingInit.add(pendingJSCall);
                    return;
                }
            }
        }
        pendingJSCall.call(this);
    }

    public NativeModule getNativeModule(String str) {
        TurboModule module;
        if (getTurboModuleRegistry() != null && (module = getTurboModuleRegistry().getModule(str)) != null) {
            return (NativeModule) module;
        }
        if (this.mNativeModuleRegistry.hasModule(str)) {
            return this.mNativeModuleRegistry.getModule(str);
        }
        return null;
    }
}
