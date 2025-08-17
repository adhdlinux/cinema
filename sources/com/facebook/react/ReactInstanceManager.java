package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.infer.annotation.ThreadSafe;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JSIModuleType;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ProxyJavaScriptExecutor;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactCxxErrorHandler;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.ReactInstanceDevHelper;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.modules.fabric.ReactFabric;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.turbomodule.core.TurboModuleManager;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ThreadSafe
public class ReactInstanceManager {
    /* access modifiers changed from: private */
    public static final String TAG = "ReactInstanceManager";
    private final Context mApplicationContext;
    private final Set<ReactRoot> mAttachedReactRoots = Collections.synchronizedSet(new HashSet());
    private final NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;
    private final JSBundleLoader mBundleLoader;
    /* access modifiers changed from: private */
    public volatile Thread mCreateReactContextThread;
    /* access modifiers changed from: private */
    public Activity mCurrentActivity;
    private volatile ReactContext mCurrentReactContext;
    @ThreadConfined("UI")
    private DefaultHardwareBackBtnHandler mDefaultBackButtonImpl;
    /* access modifiers changed from: private */
    public final DevSupportManager mDevSupportManager;
    /* access modifiers changed from: private */
    public volatile boolean mHasStartedCreatingInitialContext = false;
    /* access modifiers changed from: private */
    public volatile Boolean mHasStartedDestroying = Boolean.FALSE;
    private final JSIModulePackage mJSIModulePackage;
    private final String mJSMainModulePath;
    private final JavaScriptExecutorFactory mJavaScriptExecutorFactory;
    private volatile LifecycleState mLifecycleState;
    private final MemoryPressureRouter mMemoryPressureRouter;
    private final NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
    private final List<ReactPackage> mPackages;
    /* access modifiers changed from: private */
    @ThreadConfined("UI")
    public ReactContextInitParams mPendingReactContextInitParams;
    private final Object mReactContextLock = new Object();
    private final Collection<ReactInstanceEventListener> mReactInstanceEventListeners = Collections.synchronizedList(new ArrayList());
    private final boolean mRequireActivity;
    private final ReactPackageTurboModuleManagerDelegate.Builder mTMMDelegateBuilder;
    private final boolean mUseDeveloperSupport;
    /* access modifiers changed from: private */
    public boolean mUseFallbackBundle = false;
    private List<String> mViewManagerNames = null;
    private List<ViewManager> mViewManagers;

    private class ReactContextInitParams {
        private final JSBundleLoader mJsBundleLoader;
        private final JavaScriptExecutorFactory mJsExecutorFactory;

        public ReactContextInitParams(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
            this.mJsExecutorFactory = (JavaScriptExecutorFactory) Assertions.assertNotNull(javaScriptExecutorFactory);
            this.mJsBundleLoader = (JSBundleLoader) Assertions.assertNotNull(jSBundleLoader);
        }

        public JSBundleLoader getJsBundleLoader() {
            return this.mJsBundleLoader;
        }

        public JavaScriptExecutorFactory getJsExecutorFactory() {
            return this.mJsExecutorFactory;
        }
    }

    @Deprecated
    public interface ReactInstanceEventListener extends ReactInstanceEventListener {
    }

    ReactInstanceManager(Context context, Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader, String str, List<ReactPackage> list, boolean z2, DevSupportManagerFactory devSupportManagerFactory, boolean z3, NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener, LifecycleState lifecycleState, UIImplementationProvider uIImplementationProvider, NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler, RedBoxHandler redBoxHandler, boolean z4, DevBundleDownloadListener devBundleDownloadListener, int i2, int i3, JSIModulePackage jSIModulePackage, Map<String, RequestHandler> map, ReactPackageTurboModuleManagerDelegate.Builder builder, SurfaceDelegateFactory surfaceDelegateFactory) {
        Context context2 = context;
        boolean z5 = z2;
        FLog.d(TAG, "ReactInstanceManager.ctor()");
        initializeSoLoaderIfNecessary(context);
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(context);
        this.mApplicationContext = context2;
        this.mCurrentActivity = activity;
        this.mDefaultBackButtonImpl = defaultHardwareBackBtnHandler;
        this.mJavaScriptExecutorFactory = javaScriptExecutorFactory;
        this.mBundleLoader = jSBundleLoader;
        String str2 = str;
        this.mJSMainModulePath = str2;
        ArrayList arrayList = new ArrayList();
        this.mPackages = arrayList;
        this.mUseDeveloperSupport = z5;
        this.mRequireActivity = z3;
        Systrace.beginSection(0, "ReactInstanceManager.initDevSupportManager");
        DevSupportManager create = devSupportManagerFactory.create(context, createDevHelperInterface(), str2, z2, redBoxHandler, devBundleDownloadListener, i2, map, surfaceDelegateFactory);
        this.mDevSupportManager = create;
        Systrace.endSection(0);
        this.mBridgeIdleDebugListener = notThreadSafeBridgeIdleDebugListener;
        this.mLifecycleState = lifecycleState;
        this.mMemoryPressureRouter = new MemoryPressureRouter(context2);
        this.mNativeModuleCallExceptionHandler = nativeModuleCallExceptionHandler;
        this.mTMMDelegateBuilder = builder;
        synchronized (arrayList) {
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: Use Split Packages");
            arrayList.add(new CoreModulesPackage(this, new DefaultHardwareBackBtnHandler() {
                public void invokeDefaultOnBackPressed() {
                    ReactInstanceManager.this.invokeDefaultOnBackPressed();
                }
            }, uIImplementationProvider, z4, i3));
            if (z5) {
                arrayList.add(new DebugCorePackage());
            }
            arrayList.addAll(list);
        }
        this.mJSIModulePackage = jSIModulePackage;
        ReactChoreographer.initialize();
        if (z5) {
            create.startInspector();
        }
        registerCxxErrorHandlerFunc();
    }

    private void attachRootViewToInstance(final ReactRoot reactRoot) {
        final int i2;
        WritableMap writableMap;
        WritableMap writableMap2;
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.attachRootViewToInstance()");
        Systrace.beginSection(0, "attachRootViewToInstance");
        UIManager uIManager = UIManagerHelper.getUIManager(this.mCurrentReactContext, reactRoot.getUIManagerType());
        if (uIManager != null) {
            Bundle appProperties = reactRoot.getAppProperties();
            if (reactRoot.getUIManagerType() == 2) {
                ViewGroup rootViewGroup = reactRoot.getRootViewGroup();
                String jSModuleName = reactRoot.getJSModuleName();
                if (appProperties == null) {
                    writableMap2 = new WritableNativeMap();
                } else {
                    writableMap2 = Arguments.fromBundle(appProperties);
                }
                i2 = uIManager.startSurface(rootViewGroup, jSModuleName, writableMap2, reactRoot.getWidthMeasureSpec(), reactRoot.getHeightMeasureSpec());
                reactRoot.setRootViewTag(i2);
                reactRoot.setShouldLogContentAppeared(true);
            } else {
                ViewGroup rootViewGroup2 = reactRoot.getRootViewGroup();
                if (appProperties == null) {
                    writableMap = new WritableNativeMap();
                } else {
                    writableMap = Arguments.fromBundle(appProperties);
                }
                i2 = uIManager.addRootView(rootViewGroup2, writableMap, reactRoot.getInitialUITemplate());
                reactRoot.setRootViewTag(i2);
                reactRoot.runApplication();
            }
            Systrace.beginAsyncSection(0, "pre_rootView.onAttachedToReactInstance", i2);
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    Systrace.endAsyncSection(0, "pre_rootView.onAttachedToReactInstance", i2);
                    reactRoot.onStage(101);
                }
            });
            Systrace.endSection(0);
            return;
        }
        throw new IllegalStateException("Unable to attach a rootView to ReactInstance when UIManager is not properly initialized.");
    }

    public static ReactInstanceManagerBuilder builder() {
        return new ReactInstanceManagerBuilder();
    }

    @ThreadConfined("UI")
    private void clearReactRoot(ReactRoot reactRoot) {
        UiThreadUtil.assertOnUiThread();
        reactRoot.getState().compareAndSet(1, 0);
        ViewGroup rootViewGroup = reactRoot.getRootViewGroup();
        rootViewGroup.removeAllViews();
        rootViewGroup.setId(-1);
    }

    private ReactInstanceDevHelper createDevHelperInterface() {
        return new ReactInstanceDevHelper() {
            public View createRootView(String str) {
                Activity currentActivity = getCurrentActivity();
                if (currentActivity == null) {
                    return null;
                }
                ReactRootView reactRootView = new ReactRootView(currentActivity);
                reactRootView.setIsFabric(ReactFeatureFlags.enableFabricRenderer);
                reactRootView.startReactApplication(ReactInstanceManager.this, str, (Bundle) null);
                return reactRootView;
            }

            public void destroyRootView(View view) {
                FLog.e(ReactInstanceManager.TAG, "destroyRootView called");
                if (view instanceof ReactRootView) {
                    FLog.e(ReactInstanceManager.TAG, "destroyRootView called, unmountReactApplication");
                    ((ReactRootView) view).unmountReactApplication();
                }
            }

            public Activity getCurrentActivity() {
                return ReactInstanceManager.this.mCurrentActivity;
            }

            public JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
                return ReactInstanceManager.this.getJSExecutorFactory();
            }

            public void onJSBundleLoadedFromServer() {
                ReactInstanceManager.this.onJSBundleLoadedFromServer();
            }

            public void onReloadWithJSDebugger(JavaJSExecutor.Factory factory) {
                ReactInstanceManager.this.onReloadWithJSDebugger(factory);
            }

            public void toggleElementInspector() {
                ReactInstanceManager.this.toggleElementInspector();
            }
        };
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public ReactApplicationContext createReactContext(JavaScriptExecutor javaScriptExecutor, JSBundleLoader jSBundleLoader) {
        ReactPackageTurboModuleManagerDelegate.Builder builder;
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.createReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_REACT_CONTEXT_START, javaScriptExecutor.getName());
        ReactApplicationContext reactApplicationContext = new ReactApplicationContext(this.mApplicationContext);
        NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler = this.mNativeModuleCallExceptionHandler;
        if (nativeModuleCallExceptionHandler == null) {
            nativeModuleCallExceptionHandler = this.mDevSupportManager;
        }
        reactApplicationContext.setNativeModuleCallExceptionHandler(nativeModuleCallExceptionHandler);
        CatalystInstanceImpl.Builder nativeModuleCallExceptionHandler2 = new CatalystInstanceImpl.Builder().setReactQueueConfigurationSpec(ReactQueueConfigurationSpec.createDefault()).setJSExecutor(javaScriptExecutor).setRegistry(processPackages(reactApplicationContext, this.mPackages, false)).setJSBundleLoader(jSBundleLoader).setNativeModuleCallExceptionHandler(nativeModuleCallExceptionHandler);
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_START);
        Systrace.beginSection(0, "createCatalystInstance");
        try {
            CatalystInstanceImpl build = nativeModuleCallExceptionHandler2.build();
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
            reactApplicationContext.initializeWithInstance(build);
            if (ReactFeatureFlags.useTurboModules && (builder = this.mTMMDelegateBuilder) != null) {
                TurboModuleManager turboModuleManager = new TurboModuleManager(build.getRuntimeExecutor(), builder.setPackages(this.mPackages).setReactApplicationContext(reactApplicationContext).build(), build.getJSCallInvokerHolder(), build.getNativeCallInvokerHolder());
                build.setTurboModuleManager(turboModuleManager);
                for (String module : turboModuleManager.getEagerInitModuleNames()) {
                    turboModuleManager.getModule(module);
                }
            }
            JSIModulePackage jSIModulePackage = this.mJSIModulePackage;
            if (jSIModulePackage != null) {
                build.addJSIModules(jSIModulePackage.getJSIModules(reactApplicationContext, build.getJavaScriptContextHolder()));
            }
            if (ReactFeatureFlags.enableFabricRenderer) {
                build.getJSIModule(JSIModuleType.UIManager);
            }
            NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener = this.mBridgeIdleDebugListener;
            if (notThreadSafeBridgeIdleDebugListener != null) {
                build.addBridgeIdleDebugListener(notThreadSafeBridgeIdleDebugListener);
            }
            if (Systrace.isTracing(0)) {
                build.setGlobalVariable("__RCTProfileIsProfiling", "true");
            }
            ReactMarker.logMarker(ReactMarkerConstants.PRE_RUN_JS_BUNDLE_START);
            Systrace.beginSection(0, "runJSBundle");
            build.runJSBundle();
            Systrace.endSection(0);
            return reactApplicationContext;
        } catch (Throwable th) {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
            throw th;
        }
    }

    private void detachViewFromInstance(ReactRoot reactRoot, CatalystInstance catalystInstance) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.detachViewFromInstance()");
        UiThreadUtil.assertOnUiThread();
        if (reactRoot.getUIManagerType() == 2) {
            ((ReactFabric) catalystInstance.getJSModule(ReactFabric.class)).unmountComponentAtNode(reactRoot.getRootViewTag());
        } else {
            ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).unmountApplicationComponentAtRootTag(reactRoot.getRootViewTag());
        }
    }

    /* access modifiers changed from: private */
    public JavaScriptExecutorFactory getJSExecutorFactory() {
        return this.mJavaScriptExecutorFactory;
    }

    static void initializeSoLoaderIfNecessary(Context context) {
        SoLoader.init(context, false);
    }

    /* access modifiers changed from: private */
    public void invokeDefaultOnBackPressed() {
        UiThreadUtil.assertOnUiThread();
        DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler = this.mDefaultBackButtonImpl;
        if (defaultHardwareBackBtnHandler != null) {
            defaultHardwareBackBtnHandler.invokeDefaultOnBackPressed();
        }
    }

    private void logOnDestroy() {
        FLog.d(TAG, "ReactInstanceManager.destroy called", (Throwable) new RuntimeException("ReactInstanceManager.destroy called"));
    }

    /* access modifiers changed from: private */
    public synchronized void moveReactContextToCurrentLifecycleState() {
        if (this.mLifecycleState == LifecycleState.RESUMED) {
            moveToResumedLifecycleState(true);
        }
    }

    private synchronized void moveToBeforeCreateLifecycleState() {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            if (this.mLifecycleState == LifecycleState.RESUMED) {
                currentReactContext.onHostPause();
                this.mLifecycleState = LifecycleState.BEFORE_RESUME;
            }
            if (this.mLifecycleState == LifecycleState.BEFORE_RESUME) {
                currentReactContext.onHostDestroy();
            }
        }
        this.mLifecycleState = LifecycleState.BEFORE_CREATE;
    }

    private synchronized void moveToBeforeResumeLifecycleState() {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            if (this.mLifecycleState == LifecycleState.BEFORE_CREATE) {
                currentReactContext.onHostResume(this.mCurrentActivity);
                currentReactContext.onHostPause();
            } else if (this.mLifecycleState == LifecycleState.RESUMED) {
                currentReactContext.onHostPause();
            }
        }
        this.mLifecycleState = LifecycleState.BEFORE_RESUME;
    }

    private synchronized void moveToResumedLifecycleState(boolean z2) {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null && (z2 || this.mLifecycleState == LifecycleState.BEFORE_RESUME || this.mLifecycleState == LifecycleState.BEFORE_CREATE)) {
            currentReactContext.onHostResume(this.mCurrentActivity);
        }
        this.mLifecycleState = LifecycleState.RESUMED;
    }

    /* access modifiers changed from: private */
    @ThreadConfined("UI")
    public void onJSBundleLoadedFromServer() {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.onJSBundleLoadedFromServer()");
        recreateReactContextInBackground(this.mJavaScriptExecutorFactory, JSBundleLoader.createCachedBundleFromNetworkLoader(this.mDevSupportManager.getSourceUrl(), this.mDevSupportManager.getDownloadedJSBundleFile()));
    }

    /* access modifiers changed from: private */
    @ThreadConfined("UI")
    public void onReloadWithJSDebugger(JavaJSExecutor.Factory factory) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.onReloadWithJSDebugger()");
        recreateReactContextInBackground(new ProxyJavaScriptExecutor.Factory(factory), JSBundleLoader.createRemoteDebuggerBundleLoader(this.mDevSupportManager.getJSBundleURLForRemoteDebugging(), this.mDevSupportManager.getSourceUrl()));
    }

    private void processPackage(ReactPackage reactPackage, NativeModuleRegistryBuilder nativeModuleRegistryBuilder) {
        SystraceMessage.beginSection(0, "processPackage").arg("className", (Object) reactPackage.getClass().getSimpleName()).flush();
        boolean z2 = reactPackage instanceof ReactPackageLogger;
        if (z2) {
            ((ReactPackageLogger) reactPackage).startProcessPackage();
        }
        nativeModuleRegistryBuilder.processPackage(reactPackage);
        if (z2) {
            ((ReactPackageLogger) reactPackage).endProcessPackage();
        }
        SystraceMessage.endSection(0).flush();
    }

    private NativeModuleRegistry processPackages(ReactApplicationContext reactApplicationContext, List<ReactPackage> list, boolean z2) {
        NativeModuleRegistryBuilder nativeModuleRegistryBuilder = new NativeModuleRegistryBuilder(reactApplicationContext, this);
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_START);
        synchronized (this.mPackages) {
            for (ReactPackage next : list) {
                if (!z2 || !this.mPackages.contains(next)) {
                    Systrace.beginSection(0, "createAndProcessCustomReactPackage");
                    if (z2) {
                        try {
                            this.mPackages.add(next);
                        } catch (Throwable th) {
                            Systrace.endSection(0);
                            throw th;
                        }
                    }
                    processPackage(next, nativeModuleRegistryBuilder);
                    Systrace.endSection(0);
                }
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_END);
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_START);
        Systrace.beginSection(0, "buildNativeModuleRegistry");
        try {
            return nativeModuleRegistryBuilder.build();
        } finally {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
        }
    }

    /* access modifiers changed from: private */
    @ThreadConfined("UI")
    public void recreateReactContextInBackgroundFromBundleLoader() {
        FLog.d(TAG, "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from BundleLoader");
        recreateReactContextInBackground(this.mJavaScriptExecutorFactory, this.mBundleLoader);
    }

    @ThreadConfined("UI")
    private void recreateReactContextInBackgroundInner() {
        FLog.d(TAG, "ReactInstanceManager.recreateReactContextInBackgroundInner()");
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: recreateReactContextInBackground");
        UiThreadUtil.assertOnUiThread();
        if (this.mUseDeveloperSupport && this.mJSMainModulePath != null) {
            final DeveloperSettings devSettings = this.mDevSupportManager.getDevSettings();
            if (!Systrace.isTracing(0)) {
                if (this.mBundleLoader == null) {
                    this.mDevSupportManager.handleReloadJS();
                    return;
                } else {
                    this.mDevSupportManager.isPackagerRunning(new PackagerStatusCallback() {
                        public void onPackagerStatusFetched(final boolean z2) {
                            UiThreadUtil.runOnUiThread(new Runnable() {
                                public void run() {
                                    if (z2) {
                                        ReactInstanceManager.this.mDevSupportManager.handleReloadJS();
                                    } else if (!ReactInstanceManager.this.mDevSupportManager.hasUpToDateJSBundleInCache() || devSettings.isRemoteJSDebugEnabled() || ReactInstanceManager.this.mUseFallbackBundle) {
                                        devSettings.setRemoteJSDebugEnabled(false);
                                        ReactInstanceManager.this.recreateReactContextInBackgroundFromBundleLoader();
                                    } else {
                                        ReactInstanceManager.this.onJSBundleLoadedFromServer();
                                    }
                                }
                            });
                        }
                    });
                    return;
                }
            }
        }
        recreateReactContextInBackgroundFromBundleLoader();
    }

    /* access modifiers changed from: private */
    @ThreadConfined("UI")
    public void runCreateReactContextOnNewThread(final ReactContextInitParams reactContextInitParams) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.runCreateReactContextOnNewThread()");
        UiThreadUtil.assertOnUiThread();
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGE_LOADING_START);
        synchronized (this.mAttachedReactRoots) {
            synchronized (this.mReactContextLock) {
                if (this.mCurrentReactContext != null) {
                    tearDownReactContext(this.mCurrentReactContext);
                    this.mCurrentReactContext = null;
                }
            }
        }
        this.mCreateReactContextThread = new Thread((ThreadGroup) null, new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x000c */
            /* JADX WARNING: Removed duplicated region for block: B:2:0x000c A[LOOP:0: B:2:0x000c->B:23:0x000c, LOOP_START, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.facebook.react.bridge.ReactMarkerConstants r0 = com.facebook.react.bridge.ReactMarkerConstants.REACT_CONTEXT_THREAD_END
                    com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r0)
                    com.facebook.react.ReactInstanceManager r0 = com.facebook.react.ReactInstanceManager.this
                    java.lang.Boolean r0 = r0.mHasStartedDestroying
                    monitor-enter(r0)
                L_0x000c:
                    com.facebook.react.ReactInstanceManager r1 = com.facebook.react.ReactInstanceManager.this     // Catch:{ all -> 0x0085 }
                    java.lang.Boolean r1 = r1.mHasStartedDestroying     // Catch:{ all -> 0x0085 }
                    boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0085 }
                    if (r1 == 0) goto L_0x0022
                    com.facebook.react.ReactInstanceManager r1 = com.facebook.react.ReactInstanceManager.this     // Catch:{ InterruptedException -> 0x000c }
                    java.lang.Boolean r1 = r1.mHasStartedDestroying     // Catch:{ InterruptedException -> 0x000c }
                    r1.wait()     // Catch:{ InterruptedException -> 0x000c }
                    goto L_0x000c
                L_0x0022:
                    monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                    com.facebook.react.ReactInstanceManager r0 = com.facebook.react.ReactInstanceManager.this
                    r1 = 1
                    boolean unused = r0.mHasStartedCreatingInitialContext = r1
                    r0 = -4
                    r1 = 0
                    android.os.Process.setThreadPriority(r0)     // Catch:{ Exception -> 0x006f }
                    com.facebook.react.bridge.ReactMarkerConstants r0 = com.facebook.react.bridge.ReactMarkerConstants.VM_INIT     // Catch:{ Exception -> 0x006f }
                    com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r0)     // Catch:{ Exception -> 0x006f }
                    com.facebook.react.ReactInstanceManager r0 = com.facebook.react.ReactInstanceManager.this     // Catch:{ Exception -> 0x006f }
                    com.facebook.react.ReactInstanceManager$ReactContextInitParams r2 = r5     // Catch:{ Exception -> 0x006f }
                    com.facebook.react.bridge.JavaScriptExecutorFactory r2 = r2.getJsExecutorFactory()     // Catch:{ Exception -> 0x006f }
                    com.facebook.react.bridge.JavaScriptExecutor r2 = r2.create()     // Catch:{ Exception -> 0x006f }
                    com.facebook.react.ReactInstanceManager$ReactContextInitParams r3 = r5     // Catch:{ Exception -> 0x006f }
                    com.facebook.react.bridge.JSBundleLoader r3 = r3.getJsBundleLoader()     // Catch:{ Exception -> 0x006f }
                    com.facebook.react.bridge.ReactApplicationContext r0 = r0.createReactContext(r2, r3)     // Catch:{ Exception -> 0x006f }
                    com.facebook.react.ReactInstanceManager r2 = com.facebook.react.ReactInstanceManager.this     // Catch:{ Exception -> 0x0064 }
                    java.lang.Thread unused = r2.mCreateReactContextThread = r1     // Catch:{ Exception -> 0x0064 }
                    com.facebook.react.bridge.ReactMarkerConstants r1 = com.facebook.react.bridge.ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_START     // Catch:{ Exception -> 0x0064 }
                    com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r1)     // Catch:{ Exception -> 0x0064 }
                    com.facebook.react.ReactInstanceManager$5$1 r1 = new com.facebook.react.ReactInstanceManager$5$1     // Catch:{ Exception -> 0x0064 }
                    r1.<init>()     // Catch:{ Exception -> 0x0064 }
                    com.facebook.react.ReactInstanceManager$5$2 r2 = new com.facebook.react.ReactInstanceManager$5$2     // Catch:{ Exception -> 0x0064 }
                    r2.<init>(r0)     // Catch:{ Exception -> 0x0064 }
                    r0.runOnNativeModulesQueueThread(r2)     // Catch:{ Exception -> 0x0064 }
                    com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r1)     // Catch:{ Exception -> 0x0064 }
                    goto L_0x006e
                L_0x0064:
                    r0 = move-exception
                    com.facebook.react.ReactInstanceManager r1 = com.facebook.react.ReactInstanceManager.this
                    com.facebook.react.devsupport.interfaces.DevSupportManager r1 = r1.mDevSupportManager
                    r1.handleException(r0)
                L_0x006e:
                    return
                L_0x006f:
                    r0 = move-exception
                    com.facebook.react.ReactInstanceManager r2 = com.facebook.react.ReactInstanceManager.this
                    r3 = 0
                    boolean unused = r2.mHasStartedCreatingInitialContext = r3
                    com.facebook.react.ReactInstanceManager r2 = com.facebook.react.ReactInstanceManager.this
                    java.lang.Thread unused = r2.mCreateReactContextThread = r1
                    com.facebook.react.ReactInstanceManager r1 = com.facebook.react.ReactInstanceManager.this
                    com.facebook.react.devsupport.interfaces.DevSupportManager r1 = r1.mDevSupportManager
                    r1.handleException(r0)
                    return
                L_0x0085:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactInstanceManager.AnonymousClass5.run():void");
            }
        }, "create_react_context");
        ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_START);
        this.mCreateReactContextThread.start();
    }

    /* access modifiers changed from: private */
    public void setupReactContext(final ReactApplicationContext reactApplicationContext) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.setupReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_END);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_START);
        Systrace.beginSection(0, "setupReactContext");
        synchronized (this.mAttachedReactRoots) {
            synchronized (this.mReactContextLock) {
                this.mCurrentReactContext = (ReactContext) Assertions.assertNotNull(reactApplicationContext);
            }
            CatalystInstance catalystInstance = (CatalystInstance) Assertions.assertNotNull(reactApplicationContext.getCatalystInstance());
            catalystInstance.initialize();
            this.mDevSupportManager.onNewReactContextCreated(reactApplicationContext);
            this.mMemoryPressureRouter.addMemoryPressureListener(catalystInstance);
            ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_START);
            for (ReactRoot next : this.mAttachedReactRoots) {
                if (next.getState().compareAndSet(0, 1)) {
                    attachRootViewToInstance(next);
                }
            }
            ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_END);
        }
        final ReactInstanceEventListener[] reactInstanceEventListenerArr = (ReactInstanceEventListener[]) this.mReactInstanceEventListeners.toArray(new ReactInstanceEventListener[this.mReactInstanceEventListeners.size()]);
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                ReactInstanceManager.this.moveReactContextToCurrentLifecycleState();
                for (ReactInstanceEventListener reactInstanceEventListener : reactInstanceEventListenerArr) {
                    if (reactInstanceEventListener != null) {
                        reactInstanceEventListener.onReactContextInitialized(reactApplicationContext);
                    }
                }
            }
        });
        reactApplicationContext.runOnJSQueueThread(new Runnable() {
            public void run() {
                Process.setThreadPriority(0);
                ReactMarker.logMarker(ReactMarkerConstants.CHANGE_THREAD_PRIORITY, "js_default");
            }
        });
        reactApplicationContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                Process.setThreadPriority(0);
            }
        });
        Systrace.endSection(0);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_END);
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGE_LOADING_END);
    }

    @ThreadConfined("UI")
    private void tearDownReactContext(ReactContext reactContext) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.tearDownReactContext()");
        UiThreadUtil.assertOnUiThread();
        if (this.mLifecycleState == LifecycleState.RESUMED) {
            reactContext.onHostPause();
        }
        synchronized (this.mAttachedReactRoots) {
            for (ReactRoot clearReactRoot : this.mAttachedReactRoots) {
                clearReactRoot(clearReactRoot);
            }
        }
        this.mMemoryPressureRouter.removeMemoryPressureListener(reactContext.getCatalystInstance());
        reactContext.destroy();
        this.mDevSupportManager.onReactInstanceDestroyed(reactContext);
    }

    /* access modifiers changed from: private */
    public void toggleElementInspector() {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext == null || !currentReactContext.hasActiveReactInstance()) {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot toggleElementInspector, CatalystInstance not available"));
        } else {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) currentReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("toggleElementInspector", (Object) null);
        }
    }

    public void addReactInstanceEventListener(ReactInstanceEventListener reactInstanceEventListener) {
        this.mReactInstanceEventListeners.add(reactInstanceEventListener);
    }

    @ThreadConfined("UI")
    public void attachRootView(ReactRoot reactRoot) {
        UiThreadUtil.assertOnUiThread();
        if (this.mAttachedReactRoots.add(reactRoot)) {
            clearReactRoot(reactRoot);
        }
        ReactContext currentReactContext = getCurrentReactContext();
        if (this.mCreateReactContextThread == null && currentReactContext != null && reactRoot.getState().compareAndSet(0, 1)) {
            attachRootViewToInstance(reactRoot);
        }
    }

    @ThreadConfined("UI")
    public void createReactContextInBackground() {
        FLog.d(TAG, "ReactInstanceManager.createReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        if (!this.mHasStartedCreatingInitialContext) {
            this.mHasStartedCreatingInitialContext = true;
            recreateReactContextInBackgroundInner();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0 = r6.mPackages.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (r0.hasNext() == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        r4 = r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        if ((r4 instanceof com.facebook.react.ViewManagerOnDemandReactPackage) == false) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        r4 = ((com.facebook.react.ViewManagerOnDemandReactPackage) r4).createViewManager(r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        if (r4 == null) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r3 = r6.mPackages;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.uimanager.ViewManager createViewManager(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mReactContextLock
            monitor-enter(r0)
            com.facebook.react.bridge.ReactContext r1 = r6.getCurrentReactContext()     // Catch:{ all -> 0x003e }
            com.facebook.react.bridge.ReactApplicationContext r1 = (com.facebook.react.bridge.ReactApplicationContext) r1     // Catch:{ all -> 0x003e }
            r2 = 0
            if (r1 == 0) goto L_0x003c
            boolean r3 = r1.hasActiveReactInstance()     // Catch:{ all -> 0x003e }
            if (r3 != 0) goto L_0x0013
            goto L_0x003c
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            java.util.List<com.facebook.react.ReactPackage> r3 = r6.mPackages
            monitor-enter(r3)
            java.util.List<com.facebook.react.ReactPackage> r0 = r6.mPackages     // Catch:{ all -> 0x0039 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0039 }
        L_0x001d:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0039 }
            if (r4 == 0) goto L_0x0037
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0039 }
            com.facebook.react.ReactPackage r4 = (com.facebook.react.ReactPackage) r4     // Catch:{ all -> 0x0039 }
            boolean r5 = r4 instanceof com.facebook.react.ViewManagerOnDemandReactPackage     // Catch:{ all -> 0x0039 }
            if (r5 == 0) goto L_0x001d
            com.facebook.react.ViewManagerOnDemandReactPackage r4 = (com.facebook.react.ViewManagerOnDemandReactPackage) r4     // Catch:{ all -> 0x0039 }
            com.facebook.react.uimanager.ViewManager r4 = r4.createViewManager(r1, r7)     // Catch:{ all -> 0x0039 }
            if (r4 == 0) goto L_0x001d
            monitor-exit(r3)     // Catch:{ all -> 0x0039 }
            return r4
        L_0x0037:
            monitor-exit(r3)     // Catch:{ all -> 0x0039 }
            return r2
        L_0x0039:
            r7 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0039 }
            throw r7
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            return r2
        L_0x003e:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003e }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactInstanceManager.createViewManager(java.lang.String):com.facebook.react.uimanager.ViewManager");
    }

    @ThreadConfined("UI")
    public void destroy() {
        UiThreadUtil.assertOnUiThread();
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: Destroy");
        logOnDestroy();
        if (this.mHasStartedDestroying.booleanValue()) {
            FLog.e(ReactConstants.TAG, "ReactInstanceManager.destroy called: bail out, already destroying");
            return;
        }
        this.mHasStartedDestroying = Boolean.TRUE;
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
            this.mDevSupportManager.stopInspector();
        }
        moveToBeforeCreateLifecycleState();
        if (this.mCreateReactContextThread != null) {
            this.mCreateReactContextThread = null;
        }
        this.mMemoryPressureRouter.destroy(this.mApplicationContext);
        synchronized (this.mReactContextLock) {
            if (this.mCurrentReactContext != null) {
                this.mCurrentReactContext.destroy();
                this.mCurrentReactContext = null;
            }
        }
        this.mHasStartedCreatingInitialContext = false;
        this.mCurrentActivity = null;
        ResourceDrawableIdHelper.getInstance().clear();
        this.mHasStartedDestroying = Boolean.FALSE;
        synchronized (this.mHasStartedDestroying) {
            this.mHasStartedDestroying.notifyAll();
        }
        synchronized (this.mPackages) {
            this.mViewManagerNames = null;
        }
        FLog.d(ReactConstants.TAG, "ReactInstanceManager has been destroyed");
    }

    @ThreadConfined("UI")
    public void detachRootView(ReactRoot reactRoot) {
        UiThreadUtil.assertOnUiThread();
        synchronized (this.mAttachedReactRoots) {
            if (this.mAttachedReactRoots.contains(reactRoot)) {
                ReactContext currentReactContext = getCurrentReactContext();
                this.mAttachedReactRoots.remove(reactRoot);
                if (currentReactContext != null && currentReactContext.hasActiveReactInstance()) {
                    detachViewFromInstance(reactRoot, currentReactContext.getCatalystInstance());
                }
            }
        }
    }

    @VisibleForTesting
    public ReactContext getCurrentReactContext() {
        ReactContext reactContext;
        synchronized (this.mReactContextLock) {
            reactContext = this.mCurrentReactContext;
        }
        return reactContext;
    }

    public DevSupportManager getDevSupportManager() {
        return this.mDevSupportManager;
    }

    public String getJsExecutorName() {
        return this.mJavaScriptExecutorFactory.toString();
    }

    public LifecycleState getLifecycleState() {
        return this.mLifecycleState;
    }

    public MemoryPressureRouter getMemoryPressureRouter() {
        return this.mMemoryPressureRouter;
    }

    public List<ViewManager> getOrCreateViewManagers(ReactApplicationContext reactApplicationContext) {
        List<ViewManager> list;
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_START);
        Systrace.beginSection(0, "createAllViewManagers");
        try {
            if (this.mViewManagers == null) {
                synchronized (this.mPackages) {
                    if (this.mViewManagers == null) {
                        this.mViewManagers = new ArrayList();
                        for (ReactPackage createViewManagers : this.mPackages) {
                            this.mViewManagers.addAll(createViewManagers.createViewManagers(reactApplicationContext));
                        }
                        list = this.mViewManagers;
                    }
                }
                Systrace.endSection(0);
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
                return list;
            }
            list = this.mViewManagers;
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
            return list;
        } catch (Throwable th) {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
            throw th;
        }
    }

    public List<ReactPackage> getPackages() {
        return new ArrayList(this.mPackages);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r4 = r10.mPackages;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        if (r10.mViewManagerNames != null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
        r0 = new java.util.HashSet();
        r5 = r10.mPackages.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        if (r5.hasNext() == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        r6 = r5.next();
        com.facebook.systrace.SystraceMessage.beginSection(0, "ReactInstanceManager.getViewManagerName").arg("Package", (java.lang.Object) r6.getClass().getSimpleName()).flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if ((r6 instanceof com.facebook.react.ViewManagerOnDemandReactPackage) == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        r6 = ((com.facebook.react.ViewManagerOnDemandReactPackage) r6).getViewManagerNames(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (r6 == null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        r0.addAll(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0063, code lost:
        com.facebook.systrace.SystraceMessage.endSection(0).flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        com.facebook.systrace.Systrace.endSection(0);
        r10.mViewManagerNames = new java.util.ArrayList(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0075, code lost:
        r0 = r10.mViewManagerNames;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0078, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> getViewManagerNames() {
        /*
            r10 = this;
            java.lang.String r0 = "ReactInstanceManager.getViewManagerNames"
            r1 = 0
            com.facebook.systrace.Systrace.beginSection(r1, r0)
            java.util.List<java.lang.String> r0 = r10.mViewManagerNames
            if (r0 == 0) goto L_0x000c
            return r0
        L_0x000c:
            java.lang.Object r0 = r10.mReactContextLock
            monitor-enter(r0)
            com.facebook.react.bridge.ReactContext r3 = r10.getCurrentReactContext()     // Catch:{ all -> 0x007f }
            com.facebook.react.bridge.ReactApplicationContext r3 = (com.facebook.react.bridge.ReactApplicationContext) r3     // Catch:{ all -> 0x007f }
            if (r3 == 0) goto L_0x007c
            boolean r4 = r3.hasActiveReactInstance()     // Catch:{ all -> 0x007f }
            if (r4 != 0) goto L_0x001e
            goto L_0x007c
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            java.util.List<com.facebook.react.ReactPackage> r4 = r10.mPackages
            monitor-enter(r4)
            java.util.List<java.lang.String> r0 = r10.mViewManagerNames     // Catch:{ all -> 0x0079 }
            if (r0 != 0) goto L_0x0075
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0079 }
            r0.<init>()     // Catch:{ all -> 0x0079 }
            java.util.List<com.facebook.react.ReactPackage> r5 = r10.mPackages     // Catch:{ all -> 0x0079 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0079 }
        L_0x0031:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0079 }
            if (r6 == 0) goto L_0x006b
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0079 }
            com.facebook.react.ReactPackage r6 = (com.facebook.react.ReactPackage) r6     // Catch:{ all -> 0x0079 }
            java.lang.String r7 = "ReactInstanceManager.getViewManagerName"
            com.facebook.systrace.SystraceMessage$Builder r7 = com.facebook.systrace.SystraceMessage.beginSection(r1, r7)     // Catch:{ all -> 0x0079 }
            java.lang.String r8 = "Package"
            java.lang.Class r9 = r6.getClass()     // Catch:{ all -> 0x0079 }
            java.lang.String r9 = r9.getSimpleName()     // Catch:{ all -> 0x0079 }
            com.facebook.systrace.SystraceMessage$Builder r7 = r7.arg((java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x0079 }
            r7.flush()     // Catch:{ all -> 0x0079 }
            boolean r7 = r6 instanceof com.facebook.react.ViewManagerOnDemandReactPackage     // Catch:{ all -> 0x0079 }
            if (r7 == 0) goto L_0x0063
            com.facebook.react.ViewManagerOnDemandReactPackage r6 = (com.facebook.react.ViewManagerOnDemandReactPackage) r6     // Catch:{ all -> 0x0079 }
            java.util.List r6 = r6.getViewManagerNames(r3)     // Catch:{ all -> 0x0079 }
            if (r6 == 0) goto L_0x0063
            r0.addAll(r6)     // Catch:{ all -> 0x0079 }
        L_0x0063:
            com.facebook.systrace.SystraceMessage$Builder r6 = com.facebook.systrace.SystraceMessage.endSection(r1)     // Catch:{ all -> 0x0079 }
            r6.flush()     // Catch:{ all -> 0x0079 }
            goto L_0x0031
        L_0x006b:
            com.facebook.systrace.Systrace.endSection(r1)     // Catch:{ all -> 0x0079 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0079 }
            r1.<init>(r0)     // Catch:{ all -> 0x0079 }
            r10.mViewManagerNames = r1     // Catch:{ all -> 0x0079 }
        L_0x0075:
            java.util.List<java.lang.String> r0 = r10.mViewManagerNames     // Catch:{ all -> 0x0079 }
            monitor-exit(r4)     // Catch:{ all -> 0x0079 }
            return r0
        L_0x0079:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0079 }
            throw r0
        L_0x007c:
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            r0 = 0
            return r0
        L_0x007f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactInstanceManager.getViewManagerNames():java.util.List");
    }

    public void handleCxxError(Exception exc) {
        this.mDevSupportManager.handleException(exc);
    }

    public boolean hasStartedCreatingInitialContext() {
        return this.mHasStartedCreatingInitialContext;
    }

    @ThreadConfined("UI")
    public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            currentReactContext.onActivityResult(activity, i2, i3, intent);
        }
    }

    public void onBackPressed() {
        UiThreadUtil.assertOnUiThread();
        ReactContext reactContext = this.mCurrentReactContext;
        if (reactContext == null) {
            FLog.w(TAG, "Instance detached from instance manager");
            invokeDefaultOnBackPressed();
            return;
        }
        DeviceEventManagerModule deviceEventManagerModule = (DeviceEventManagerModule) reactContext.getNativeModule(DeviceEventManagerModule.class);
        if (deviceEventManagerModule != null) {
            deviceEventManagerModule.emitHardwareBackPressed();
        }
    }

    @ThreadConfined("UI")
    public void onConfigurationChanged(Context context, Configuration configuration) {
        AppearanceModule appearanceModule;
        UiThreadUtil.assertOnUiThread();
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null && (appearanceModule = (AppearanceModule) currentReactContext.getNativeModule(AppearanceModule.class)) != null) {
            appearanceModule.onConfigurationChanged(context);
        }
    }

    @ThreadConfined("UI")
    public void onHostDestroy() {
        UiThreadUtil.assertOnUiThread();
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
        }
        moveToBeforeCreateLifecycleState();
        this.mCurrentActivity = null;
    }

    @ThreadConfined("UI")
    public void onHostPause() {
        UiThreadUtil.assertOnUiThread();
        this.mDefaultBackButtonImpl = null;
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
        }
        moveToBeforeResumeLifecycleState();
    }

    @ThreadConfined("UI")
    public void onHostResume(Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        UiThreadUtil.assertOnUiThread();
        this.mDefaultBackButtonImpl = defaultHardwareBackBtnHandler;
        onHostResume(activity);
    }

    @ThreadConfined("UI")
    public void onNewIntent(Intent intent) {
        DeviceEventManagerModule deviceEventManagerModule;
        UiThreadUtil.assertOnUiThread();
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext == null) {
            FLog.w(TAG, "Instance detached from instance manager");
            return;
        }
        String action = intent.getAction();
        Uri data = intent.getData();
        if (data != null && (("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action)) && (deviceEventManagerModule = (DeviceEventManagerModule) currentReactContext.getNativeModule(DeviceEventManagerModule.class)) != null)) {
            deviceEventManagerModule.emitNewIntentReceived(data);
        }
        currentReactContext.onNewIntent(this.mCurrentActivity, intent);
    }

    @ThreadConfined("UI")
    public void onWindowFocusChange(boolean z2) {
        UiThreadUtil.assertOnUiThread();
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            currentReactContext.onWindowFocusChange(z2);
        }
    }

    @ThreadConfined("UI")
    public void recreateReactContextInBackground() {
        Assertions.assertCondition(this.mHasStartedCreatingInitialContext, "recreateReactContextInBackground should only be called after the initial createReactContextInBackground call.");
        recreateReactContextInBackgroundInner();
    }

    public void registerCxxErrorHandlerFunc() {
        Method method;
        try {
            method = ReactInstanceManager.class.getMethod("handleCxxError", new Class[]{Exception.class});
        } catch (NoSuchMethodException e2) {
            FLog.e("ReactInstanceHolder", "Failed to set cxx error hanlder function", (Throwable) e2);
            method = null;
        }
        ReactCxxErrorHandler.setHandleErrorFunc(this, method);
    }

    public void removeReactInstanceEventListener(ReactInstanceEventListener reactInstanceEventListener) {
        this.mReactInstanceEventListeners.remove(reactInstanceEventListener);
    }

    public synchronized void setUseFallbackBundle(boolean z2) {
        this.mUseFallbackBundle = z2;
    }

    @ThreadConfined("UI")
    public void showDevOptionsDialog() {
        UiThreadUtil.assertOnUiThread();
        this.mDevSupportManager.showDevOptionsDialog();
    }

    @ThreadConfined("UI")
    private void recreateReactContextInBackground(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.recreateReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        ReactContextInitParams reactContextInitParams = new ReactContextInitParams(javaScriptExecutorFactory, jSBundleLoader);
        if (this.mCreateReactContextThread == null) {
            runCreateReactContextOnNewThread(reactContextInitParams);
        } else {
            this.mPendingReactContextInitParams = reactContextInitParams;
        }
    }

    @ThreadConfined("UI")
    public void onHostResume(Activity activity) {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentActivity = activity;
        if (this.mUseDeveloperSupport) {
            if (activity != null) {
                final View decorView = activity.getWindow().getDecorView();
                if (!ViewCompat.U(decorView)) {
                    decorView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                        public void onViewAttachedToWindow(View view) {
                            decorView.removeOnAttachStateChangeListener(this);
                            ReactInstanceManager.this.mDevSupportManager.setDevSupportEnabled(true);
                        }

                        public void onViewDetachedFromWindow(View view) {
                        }
                    });
                } else {
                    this.mDevSupportManager.setDevSupportEnabled(true);
                }
            } else if (!this.mRequireActivity) {
                this.mDevSupportManager.setDevSupportEnabled(true);
            }
        }
        moveToResumedLifecycleState(false);
    }

    @ThreadConfined("UI")
    public void onHostDestroy(Activity activity) {
        if (activity == this.mCurrentActivity) {
            onHostDestroy();
        }
    }

    @ThreadConfined("UI")
    public void onHostPause(Activity activity) {
        boolean z2 = true;
        if (this.mRequireActivity) {
            Assertions.assertCondition(this.mCurrentActivity != null);
        }
        Activity activity2 = this.mCurrentActivity;
        if (activity2 != null) {
            if (activity != activity2) {
                z2 = false;
            }
            Assertions.assertCondition(z2, "Pausing an activity that is not the current activity, this is incorrect! Current activity: " + this.mCurrentActivity.getClass().getSimpleName() + " Paused activity: " + activity.getClass().getSimpleName());
        }
        onHostPause();
    }
}
