package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.fabric.DevToolsReactPerfLogger;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.fabric.mounting.MountItemDispatcher;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.fabric.mounting.mountitems.DispatchIntCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchStringCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.PreAllocateViewMountItem;
import com.facebook.react.fabric.mounting.mountitems.SendAccessibilityEvent;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventCategoryDef;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherImpl;
import com.facebook.react.uimanager.events.LockFreeEventDispatcherImpl;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.text.TextLayoutManagerMapBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

@DoNotStripAny
@SuppressLint({"MissingNativeLoadLibrary"})
public class FabricUIManager implements UIManager, LifecycleEventListener {
    public static final boolean ENABLE_FABRIC_LOGS;
    public static final boolean IS_DEVELOPMENT_ENVIRONMENT = false;
    public static final String TAG = "FabricUIManager";
    /* access modifiers changed from: private */
    public Binding mBinding;
    private long mCommitStartTime = 0;
    private int mCurrentSynchronousCommitNumber = 10000;
    /* access modifiers changed from: private */
    public volatile boolean mDestroyed = false;
    public DevToolsReactPerfLogger mDevToolsReactPerfLogger;
    /* access modifiers changed from: private */
    @ThreadConfined("UI")
    public final DispatchUIFrameCallback mDispatchUIFrameCallback;
    private long mDispatchViewUpdatesTime = 0;
    /* access modifiers changed from: private */
    public boolean mDriveCxxAnimations = false;
    private final EventBeatManager mEventBeatManager;
    private final EventDispatcher mEventDispatcher;
    private long mFinishTransactionCPPTime = 0;
    private long mFinishTransactionTime = 0;
    private long mLayoutTime = 0;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<UIManagerListener> mListeners = new CopyOnWriteArrayList<>();
    /* access modifiers changed from: private */
    public final MountItemDispatcher mMountItemDispatcher;
    private MountingManager.MountItemExecutor mMountItemExecutor = new MountingManager.MountItemExecutor() {
        public void executeItems(Queue<MountItem> queue) {
            FabricUIManager.this.mMountItemDispatcher.dispatchMountItems(queue);
        }
    };
    private final MountingManager mMountingManager;
    private final ReactApplicationContext mReactApplicationContext;
    private volatile boolean mShouldDeallocateEventDispatcher = false;

    private class DispatchUIFrameCallback extends GuardedFrameCallback {
        private volatile boolean mIsMountingEnabled;

        @ThreadConfined("UI")
        public void doFrameGuarded(long j2) {
            if (!this.mIsMountingEnabled || FabricUIManager.this.mDestroyed) {
                FLog.w(FabricUIManager.TAG, "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            if (FabricUIManager.this.mDriveCxxAnimations && FabricUIManager.this.mBinding != null) {
                FabricUIManager.this.mBinding.driveCxxAnimations();
            }
            try {
                FabricUIManager.this.mMountItemDispatcher.dispatchPreMountItems(j2);
                FabricUIManager.this.mMountItemDispatcher.tryDispatchMountItems();
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
            } catch (Exception e2) {
                FLog.e(FabricUIManager.TAG, "Exception thrown when executing UIFrameGuarded", (Throwable) e2);
                stop();
                throw e2;
            } catch (Throwable th) {
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public void stop() {
            this.mIsMountingEnabled = false;
        }

        private DispatchUIFrameCallback(ReactContext reactContext) {
            super(reactContext);
            this.mIsMountingEnabled = true;
        }
    }

    private class MountItemDispatchListener implements MountItemDispatcher.ItemDispatchListener {
        private MountItemDispatchListener() {
        }

        public void didDispatchMountItems() {
            Iterator it2 = FabricUIManager.this.mListeners.iterator();
            while (it2.hasNext()) {
                ((UIManagerListener) it2.next()).didDispatchMountItems(FabricUIManager.this);
            }
        }
    }

    static {
        boolean z2;
        if (ReactFeatureFlags.enableFabricLogs || PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.FABRIC_UI_MANAGER)) {
            z2 = true;
        } else {
            z2 = false;
        }
        ENABLE_FABRIC_LOGS = z2;
        FabricSoLoader.staticInit();
    }

    @Deprecated
    public FabricUIManager(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, EventBeatManager eventBeatManager) {
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        MountingManager mountingManager = new MountingManager(viewManagerRegistry, this.mMountItemExecutor);
        this.mMountingManager = mountingManager;
        this.mMountItemDispatcher = new MountItemDispatcher(mountingManager, new MountItemDispatchListener());
        this.mEventDispatcher = eventDispatcher;
        this.mShouldDeallocateEventDispatcher = false;
        this.mEventBeatManager = eventBeatManager;
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @ThreadConfined("ANY")
    private MountItem createIntBufferBatchMountItem(int i2, int[] iArr, Object[] objArr, int i3) {
        return new IntBufferBatchMountItem(i2, iArr, objArr, i3);
    }

    private long measure(int i2, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, float f3, float f4, float f5) {
        return measure(i2, str, readableMap, readableMap2, readableMap3, f2, f3, f4, f5, (float[]) null);
    }

    private NativeArray measureLines(ReadableMap readableMap, ReadableMap readableMap2, float f2, float f3) {
        return (NativeArray) TextLayoutManager.measureLines(this.mReactApplicationContext, readableMap, readableMap2, PixelUtil.toPixelFromDIP(f2));
    }

    private NativeArray measureLinesMapBuffer(ReadableMapBuffer readableMapBuffer, ReadableMapBuffer readableMapBuffer2, float f2, float f3) {
        return (NativeArray) TextLayoutManagerMapBuffer.measureLines(this.mReactApplicationContext, readableMapBuffer, readableMapBuffer2, PixelUtil.toPixelFromDIP(f2));
    }

    private long measureMapBuffer(int i2, String str, ReadableMapBuffer readableMapBuffer, ReadableMapBuffer readableMapBuffer2, ReadableMapBuffer readableMapBuffer3, float f2, float f3, float f4, float f5, float[] fArr) {
        ReactContext reactContext;
        if (i2 > 0) {
            SurfaceMountingManager surfaceManagerEnforced = this.mMountingManager.getSurfaceManagerEnforced(i2, "measure");
            if (surfaceManagerEnforced.isStopped()) {
                return 0;
            }
            reactContext = surfaceManagerEnforced.getContext();
        } else {
            reactContext = this.mReactApplicationContext;
        }
        return this.mMountingManager.measureMapBuffer(reactContext, str, readableMapBuffer, readableMapBuffer2, readableMapBuffer3, LayoutMetricsConversions.getYogaSize(f2, f3), LayoutMetricsConversions.getYogaMeasureMode(f2, f3), LayoutMetricsConversions.getYogaSize(f4, f5), LayoutMetricsConversions.getYogaMeasureMode(f4, f5), fArr);
    }

    @ThreadConfined("ANY")
    private void preallocateView(int i2, int i3, String str, Object obj, Object obj2, Object obj3, boolean z2) {
        this.mMountItemDispatcher.addPreAllocateMountItem(new PreAllocateViewMountItem(i2, i3, FabricComponents.getFabricComponentName(str), obj, (StateWrapper) obj2, (EventEmitterWrapper) obj3, z2));
    }

    @ThreadConfined("ANY")
    private void scheduleMountItem(MountItem mountItem, int i2, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        boolean z2;
        MountItem mountItem2 = mountItem;
        int i3 = i2;
        long j9 = j2;
        long j10 = j5;
        long j11 = j6;
        long j12 = j7;
        long j13 = j8;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z3 = mountItem2 instanceof IntBufferBatchMountItem;
        if ((!z3 || !((IntBufferBatchMountItem) mountItem2).shouldSchedule()) && (z3 || mountItem2 == null)) {
            z2 = false;
        } else {
            z2 = true;
        }
        for (Iterator<UIManagerListener> it2 = this.mListeners.iterator(); it2.hasNext(); it2 = it2) {
            it2.next().didScheduleMountItems(this);
        }
        if (z3) {
            this.mCommitStartTime = j9;
            this.mLayoutTime = j11 - j10;
            this.mFinishTransactionCPPTime = j13 - j12;
            this.mFinishTransactionTime = uptimeMillis - j12;
            this.mDispatchViewUpdatesTime = SystemClock.uptimeMillis();
        }
        if (z2) {
            this.mMountItemDispatcher.addMountItem(mountItem2);
            if (UiThreadUtil.isOnUiThread()) {
                this.mMountItemDispatcher.tryDispatchMountItems();
            }
        }
        if (z3) {
            int i4 = i2;
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_START, (String) null, i4, j2);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_START, (String) null, i4, j12);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_END, (String) null, i4, j13);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_START, (String) null, i4, j3);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_END, (String) null, i4, j4);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_START, (String) null, i4, j10);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_END, (String) null, i4, j11);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_END, (String) null, i4);
        }
    }

    @ThreadConfined("UI")
    @Deprecated
    public <T extends View> int addRootView(T t2, WritableMap writableMap, String str) {
        String str2 = TAG;
        ReactSoftExceptionLogger.logSoftException(str2, new IllegalViewOperationException("Do not call addRootView in Fabric; it is unsupported. Call startSurface instead."));
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        ReactRoot reactRoot = (ReactRoot) t2;
        this.mMountingManager.startSurface(nextRootViewTag, new ThemedReactContext(this.mReactApplicationContext, t2.getContext(), reactRoot.getSurfaceID(), nextRootViewTag), t2);
        String jSModuleName = reactRoot.getJSModuleName();
        if (ENABLE_FABRIC_LOGS) {
            FLog.d(str2, "Starting surface for module: %s and reactTag: %d", (Object) jSModuleName, (Object) Integer.valueOf(nextRootViewTag));
        }
        this.mBinding.startSurface(nextRootViewTag, jSModuleName, (NativeMap) writableMap);
        if (str != null) {
            this.mBinding.renderTemplateToSurface(nextRootViewTag, str);
        }
        return nextRootViewTag;
    }

    public void addUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mListeners.add(uIManagerListener);
    }

    public void attachRootView(SurfaceHandler surfaceHandler, View view) {
        this.mMountingManager.attachRootView(surfaceHandler.getSurfaceId(), view, new ThemedReactContext(this.mReactApplicationContext, view.getContext(), surfaceHandler.getModuleName(), surfaceHandler.getSurfaceId()));
        surfaceHandler.setMountable(true);
    }

    public void clearJSResponder() {
        this.mMountItemDispatcher.addMountItem(new MountItem() {
            public void execute(MountingManager mountingManager) {
                mountingManager.clearJSResponder();
            }

            public int getSurfaceId() {
                return -1;
            }

            public String toString() {
                return "CLEAR_JS_RESPONDER";
            }
        });
    }

    @ThreadConfined("ANY")
    @Deprecated
    public void dispatchCommand(int i2, int i3, ReadableArray readableArray) {
        throw new UnsupportedOperationException("dispatchCommand called without surfaceId - Fabric dispatchCommand must be called through Fabric JSI API");
    }

    public int getColor(int i2, ReadableMap readableMap) {
        Integer color = ColorPropConverter.getColor(readableMap, this.mMountingManager.getSurfaceManagerEnforced(i2, "getColor").getContext());
        if (color != null) {
            return color.intValue();
        }
        return 0;
    }

    @ThreadConfined("UI")
    public ReadableMap getInspectorDataForInstance(int i2, View view) {
        UiThreadUtil.assertOnUiThread();
        return this.mBinding.getInspectorDataForInstance(this.mMountingManager.getEventEmitter(i2, view.getId()));
    }

    public Map<String, Long> getPerformanceCounters() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.mCommitStartTime));
        hashMap.put("LayoutTime", Long.valueOf(this.mLayoutTime));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mDispatchViewUpdatesTime));
        hashMap.put("RunStartTime", Long.valueOf(this.mMountItemDispatcher.getRunStartTime()));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.mMountItemDispatcher.getBatchedExecutionTime()));
        hashMap.put("FinishFabricTransactionTime", Long.valueOf(this.mFinishTransactionTime));
        hashMap.put("FinishFabricTransactionCPPTime", Long.valueOf(this.mFinishTransactionCPPTime));
        return hashMap;
    }

    public boolean getThemeData(int i2, float[] fArr) {
        ThemedReactContext context = this.mMountingManager.getSurfaceManagerEnforced(i2, "getThemeData").getContext();
        if (context == null) {
            FLog.w(TAG, "\"themedReactContext\" is null when call \"getThemeData\"");
            return false;
        }
        float[] defaultTextInputPadding = UIManagerHelper.getDefaultTextInputPadding(context);
        fArr[0] = defaultTextInputPadding[0];
        fArr[1] = defaultTextInputPadding[1];
        fArr[2] = defaultTextInputPadding[2];
        fArr[3] = defaultTextInputPadding[3];
        return true;
    }

    public void initialize() {
        this.mEventDispatcher.registerEventEmitter(2, (RCTModernEventEmitter) new FabricEventEmitter(this));
        this.mEventDispatcher.addBatchEventDispatchedListener(this.mEventBeatManager);
        if (ENABLE_FABRIC_LOGS) {
            DevToolsReactPerfLogger devToolsReactPerfLogger = new DevToolsReactPerfLogger();
            this.mDevToolsReactPerfLogger = devToolsReactPerfLogger;
            devToolsReactPerfLogger.addDevToolsReactPerfLoggerListener(new DevToolsReactPerfLogger.DevToolsReactPerfLoggerListener() {
                public void onFabricCommitEnd(DevToolsReactPerfLogger.FabricCommitPoint fabricCommitPoint) {
                    String str = FabricUIManager.TAG;
                    FLog.i(str, "Statistic of Fabric commit #: " + fabricCommitPoint.getCommitNumber() + "\n - Total commit time: " + (fabricCommitPoint.getFinishTransactionEnd() - fabricCommitPoint.getCommitStart()) + " ms.\n - Layout: " + (fabricCommitPoint.getLayoutEnd() - fabricCommitPoint.getLayoutStart()) + " ms.\n - Diffing: " + (fabricCommitPoint.getDiffEnd() - fabricCommitPoint.getDiffStart()) + " ms.\n - FinishTransaction (Diffing + JNI serialization): " + (fabricCommitPoint.getFinishTransactionEnd() - fabricCommitPoint.getFinishTransactionStart()) + " ms.\n - Mounting: " + (fabricCommitPoint.getBatchExecutionEnd() - fabricCommitPoint.getBatchExecutionStart()) + " ms.");
                }
            });
            ReactMarker.addFabricListener(this.mDevToolsReactPerfLogger);
        }
    }

    public void onAllAnimationsComplete() {
        this.mDriveCxxAnimations = false;
    }

    public void onAnimationStarted() {
        this.mDriveCxxAnimations = true;
    }

    @ThreadConfined("ANY")
    public void onCatalystInstanceDestroy() {
        String str = TAG;
        FLog.i(str, "FabricUIManager.onCatalystInstanceDestroy");
        DevToolsReactPerfLogger devToolsReactPerfLogger = this.mDevToolsReactPerfLogger;
        if (devToolsReactPerfLogger != null) {
            ReactMarker.removeFabricListener(devToolsReactPerfLogger);
        }
        if (this.mDestroyed) {
            ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException("Cannot double-destroy FabricUIManager"));
            return;
        }
        this.mDestroyed = true;
        this.mDispatchUIFrameCallback.stop();
        this.mEventDispatcher.removeBatchEventDispatchedListener(this.mEventBeatManager);
        this.mEventDispatcher.unregisterEventEmitter(2);
        this.mReactApplicationContext.removeLifecycleEventListener(this);
        onHostPause();
        this.mBinding.unregister();
        this.mBinding = null;
        ViewManagerPropertyUpdater.clear();
        if (this.mShouldDeallocateEventDispatcher) {
            this.mEventDispatcher.onCatalystInstanceDestroyed();
        }
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
        ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    public void onHostResume() {
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    public void onRequestEventBeat() {
        this.mEventDispatcher.dispatchAllEvents();
    }

    public void preInitializeViewManagers(List<String> list) {
        for (String initializeViewManager : list) {
            this.mMountingManager.initializeViewManager(initializeViewManager);
        }
    }

    public void profileNextBatch() {
    }

    public void receiveEvent(int i2, String str, WritableMap writableMap) {
        receiveEvent(-1, i2, str, writableMap);
    }

    public void removeUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mListeners.remove(uIManagerListener);
    }

    @Deprecated
    public String resolveCustomDirectEventName(String str) {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(ViewProps.TOP)) {
            return str;
        }
        return ViewProps.ON + str.substring(3);
    }

    public View resolveView(int i2) {
        UiThreadUtil.assertOnUiThread();
        SurfaceMountingManager surfaceManagerForView = this.mMountingManager.getSurfaceManagerForView(i2);
        if (surfaceManagerForView == null) {
            return null;
        }
        return surfaceManagerForView.getView(i2);
    }

    @ThreadConfined("ANY")
    public void sendAccessibilityEvent(int i2, int i3) {
        this.mMountItemDispatcher.addMountItem(new SendAccessibilityEvent(-1, i2, i3));
    }

    @ThreadConfined("ANY")
    public void sendAccessibilityEventFromJS(int i2, int i3, String str) {
        int i4;
        if ("focus".equals(str)) {
            i4 = 8;
        } else if ("windowStateChange".equals(str)) {
            i4 = 32;
        } else if ("click".equals(str)) {
            i4 = 1;
        } else {
            throw new IllegalArgumentException("sendAccessibilityEventFromJS: invalid eventType " + str);
        }
        this.mMountItemDispatcher.addMountItem(new SendAccessibilityEvent(i2, i3, i4));
    }

    public void setBinding(Binding binding) {
        this.mBinding = binding;
    }

    public void setJSResponder(int i2, int i3, int i4, boolean z2) {
        final int i5 = i2;
        final int i6 = i3;
        final int i7 = i4;
        final boolean z3 = z2;
        this.mMountItemDispatcher.addMountItem(new MountItem() {
            public void execute(MountingManager mountingManager) {
                SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(i5);
                if (surfaceManager != null) {
                    surfaceManager.setJSResponder(i6, i7, z3);
                    return;
                }
                String str = FabricUIManager.TAG;
                FLog.e(str, "setJSResponder skipped, surface no longer available [" + i5 + "]");
            }

            public int getSurfaceId() {
                return i5;
            }

            public String toString() {
                return String.format("SET_JS_RESPONDER [%d] [surface:%d]", new Object[]{Integer.valueOf(i6), Integer.valueOf(i5)});
            }
        });
    }

    @ThreadConfined("ANY")
    public <T extends View> int startSurface(T t2, String str, WritableMap writableMap, int i2, int i3) {
        String str2 = str;
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        Context context = t2.getContext();
        ThemedReactContext themedReactContext = new ThemedReactContext(this.mReactApplicationContext, context, str2, nextRootViewTag);
        if (ENABLE_FABRIC_LOGS) {
            FLog.d(TAG, "Starting surface for module: %s and reactTag: %d", (Object) str2, (Object) Integer.valueOf(nextRootViewTag));
        }
        this.mMountingManager.startSurface(nextRootViewTag, themedReactContext, t2);
        Point viewportOffset = UiThreadUtil.isOnUiThread() ? RootViewUtil.getViewportOffset(t2) : new Point(0, 0);
        this.mBinding.startSurfaceWithConstraints(nextRootViewTag, str, (NativeMap) writableMap, LayoutMetricsConversions.getMinSize(i2), LayoutMetricsConversions.getMaxSize(i2), LayoutMetricsConversions.getMinSize(i3), LayoutMetricsConversions.getMaxSize(i3), (float) viewportOffset.x, (float) viewportOffset.y, I18nUtil.getInstance().isRTL(context), I18nUtil.getInstance().doLeftAndRightSwapInRTL(context));
        return nextRootViewTag;
    }

    public void stopSurface(SurfaceHandler surfaceHandler) {
        if (!surfaceHandler.isRunning()) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Trying to stop surface that hasn't started yet"));
            return;
        }
        this.mMountingManager.stopSurface(surfaceHandler.getSurfaceId());
        surfaceHandler.stop();
        if (surfaceHandler instanceof SurfaceHandlerBinding) {
            this.mBinding.unregisterSurface((SurfaceHandlerBinding) surfaceHandler);
        }
    }

    @ThreadConfined("UI")
    public void synchronouslyUpdateViewOnUIThread(final int i2, final ReadableMap readableMap) {
        UiThreadUtil.assertOnUiThread();
        int i3 = this.mCurrentSynchronousCommitNumber;
        this.mCurrentSynchronousCommitNumber = i3 + 1;
        AnonymousClass3 r12 = new MountItem() {
            public void execute(MountingManager mountingManager) {
                try {
                    mountingManager.updateProps(i2, readableMap);
                } catch (Exception unused) {
                }
            }

            public int getSurfaceId() {
                return -1;
            }

            public String toString() {
                return String.format("SYNC UPDATE PROPS [%d]: %s", new Object[]{Integer.valueOf(i2), "<hidden>"});
            }
        };
        if (!this.mMountingManager.getViewExists(i2)) {
            this.mMountItemDispatcher.addMountItem(r12);
            return;
        }
        ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START, (String) null, i3);
        if (ENABLE_FABRIC_LOGS) {
            FLog.d(TAG, "SynchronouslyUpdateViewOnUIThread for tag %d: %s", (Object) Integer.valueOf(i2), (Object) "<hidden>");
        }
        r12.execute(this.mMountingManager);
        ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, (String) null, i3);
    }

    @ThreadConfined("UI")
    public void updateRootLayoutSpecs(int i2, int i3, int i4, int i5, int i6) {
        boolean z2;
        boolean z3;
        int i7 = i2;
        if (ENABLE_FABRIC_LOGS) {
            FLog.d(TAG, "Updating Root Layout Specs for [%d]", (Object) Integer.valueOf(i2));
        }
        SurfaceMountingManager surfaceManager = this.mMountingManager.getSurfaceManager(i2);
        if (surfaceManager == null) {
            String str = TAG;
            ReactSoftExceptionLogger.logSoftException(str, new IllegalViewOperationException("Cannot updateRootLayoutSpecs on surfaceId that does not exist: " + i2));
            return;
        }
        ThemedReactContext context = surfaceManager.getContext();
        if (context != null) {
            boolean isRTL = I18nUtil.getInstance().isRTL(context);
            z2 = I18nUtil.getInstance().doLeftAndRightSwapInRTL(context);
            z3 = isRTL;
        } else {
            z3 = false;
            z2 = false;
        }
        this.mBinding.setConstraints(i2, LayoutMetricsConversions.getMinSize(i3), LayoutMetricsConversions.getMaxSize(i3), LayoutMetricsConversions.getMinSize(i4), LayoutMetricsConversions.getMaxSize(i4), (float) i5, (float) i6, z3, z2);
    }

    private long measure(int i2, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, float f3, float f4, float f5, float[] fArr) {
        ReactContext reactContext;
        if (i2 > 0) {
            SurfaceMountingManager surfaceManagerEnforced = this.mMountingManager.getSurfaceManagerEnforced(i2, "measure");
            if (surfaceManagerEnforced.isStopped()) {
                return 0;
            }
            reactContext = surfaceManagerEnforced.getContext();
        } else {
            reactContext = this.mReactApplicationContext;
        }
        return this.mMountingManager.measure(reactContext, str, readableMap, readableMap2, readableMap3, LayoutMetricsConversions.getYogaSize(f2, f3), LayoutMetricsConversions.getYogaMeasureMode(f2, f3), LayoutMetricsConversions.getYogaSize(f4, f5), LayoutMetricsConversions.getYogaMeasureMode(f4, f5), fArr);
    }

    @ThreadConfined("ANY")
    @Deprecated
    public void dispatchCommand(int i2, String str, ReadableArray readableArray) {
        throw new UnsupportedOperationException("dispatchCommand called without surfaceId - Fabric dispatchCommand must be called through Fabric JSI API");
    }

    public EventDispatcher getEventDispatcher() {
        return this.mEventDispatcher;
    }

    public void receiveEvent(int i2, int i3, String str, WritableMap writableMap) {
        receiveEvent(i2, i3, str, false, 0, writableMap);
    }

    @ThreadConfined("ANY")
    @Deprecated
    public void dispatchCommand(int i2, int i3, int i4, ReadableArray readableArray) {
        this.mMountItemDispatcher.dispatchCommandMountItem(new DispatchIntCommandMountItem(i2, i3, i4, readableArray));
    }

    public void receiveEvent(int i2, int i3, String str, boolean z2, int i4, WritableMap writableMap) {
        receiveEvent(i2, i3, str, z2, i4, writableMap, 2);
    }

    @ThreadConfined("ANY")
    public void dispatchCommand(int i2, int i3, String str, ReadableArray readableArray) {
        this.mMountItemDispatcher.dispatchCommandMountItem(new DispatchStringCommandMountItem(i2, i3, str, readableArray));
    }

    public void receiveEvent(int i2, int i3, String str, boolean z2, int i4, WritableMap writableMap, @EventCategoryDef int i5) {
        if (this.mDestroyed) {
            FLog.e(TAG, "Attempted to receiveEvent after destruction");
            return;
        }
        EventEmitterWrapper eventEmitter = this.mMountingManager.getEventEmitter(i2, i3);
        if (eventEmitter == null) {
            String str2 = TAG;
            FLog.d(str2, "Unable to invoke event: " + str + " for reactTag: " + i3);
        } else if (z2) {
            eventEmitter.invokeUnique(str, writableMap, i4);
        } else {
            eventEmitter.invoke(str, writableMap, i5);
        }
    }

    @ThreadConfined("ANY")
    public void stopSurface(int i2) {
        this.mMountingManager.stopSurface(i2);
        this.mBinding.stopSurface(i2);
    }

    public void startSurface(SurfaceHandler surfaceHandler, Context context, View view) {
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        this.mMountingManager.startSurface(nextRootViewTag, new ThemedReactContext(this.mReactApplicationContext, context, surfaceHandler.getModuleName(), nextRootViewTag), view);
        surfaceHandler.setSurfaceId(nextRootViewTag);
        if (surfaceHandler instanceof SurfaceHandlerBinding) {
            this.mBinding.registerSurface((SurfaceHandlerBinding) surfaceHandler);
        }
        surfaceHandler.setMountable(view != null);
        surfaceHandler.start();
    }

    public FabricUIManager(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventBeatManager eventBeatManager) {
        EventDispatcher eventDispatcher;
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        MountingManager mountingManager = new MountingManager(viewManagerRegistry, this.mMountItemExecutor);
        this.mMountingManager = mountingManager;
        this.mMountItemDispatcher = new MountItemDispatcher(mountingManager, new MountItemDispatchListener());
        if (ReactFeatureFlags.enableLockFreeEventDispatcher) {
            eventDispatcher = new LockFreeEventDispatcherImpl(reactApplicationContext);
        } else {
            eventDispatcher = new EventDispatcherImpl(reactApplicationContext);
        }
        this.mEventDispatcher = eventDispatcher;
        this.mShouldDeallocateEventDispatcher = true;
        this.mEventBeatManager = eventBeatManager;
        reactApplicationContext.addLifecycleEventListener(this);
    }
}
