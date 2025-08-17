package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.view.View;
import androidx.collection.ArrayMap;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherImpl;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@ReactModule(name = "UIManager")
public class UIManagerModule extends ReactContextBaseJavaModule implements OnBatchCompleteListener, LifecycleEventListener, UIManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.UI_MANAGER);
    public static final String NAME = "UIManager";
    public static final String TAG = "UIManagerModule";
    private int mBatchId;
    private final Map<String, Object> mCustomDirectEvents;
    private final EventDispatcher mEventDispatcher;
    private final List<UIManagerModuleListener> mListeners;
    private final MemoryTrimCallback mMemoryTrimCallback;
    private final Map<String, Object> mModuleConstants;
    private int mNumRootViews;
    /* access modifiers changed from: private */
    public final UIImplementation mUIImplementation;
    private final CopyOnWriteArrayList<UIManagerListener> mUIManagerListeners;
    private Map<String, WritableMap> mViewManagerConstantsCache;
    private volatile int mViewManagerConstantsCacheSize;
    private final ViewManagerRegistry mViewManagerRegistry;

    public interface CustomEventNamesResolver {
        String resolveCustomEventName(String str);
    }

    private class MemoryTrimCallback implements ComponentCallbacks2 {
        private MemoryTrimCallback() {
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i2) {
            if (i2 >= 60) {
                YogaNodePool.get().clear();
            }
        }
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, ViewManagerResolver viewManagerResolver, int i2) {
        this(reactApplicationContext, viewManagerResolver, new UIImplementationProvider(), i2);
    }

    private WritableMap computeConstantsForViewManager(String str) {
        ViewManager viewManager;
        if (str != null) {
            viewManager = this.mUIImplementation.resolveViewManager(str);
        } else {
            viewManager = null;
        }
        if (viewManager == null) {
            return null;
        }
        SystraceMessage.beginSection(0, "UIManagerModule.getConstantsForViewManager").arg("ViewManager", (Object) viewManager.getName()).arg("Lazy", (Object) Boolean.TRUE).flush();
        try {
            Map<String, Object> createConstantsForViewManager = UIManagerModuleConstantsHelper.createConstantsForViewManager(viewManager, (Map) null, (Map) null, (Map) null, this.mCustomDirectEvents);
            if (createConstantsForViewManager != null) {
                return Arguments.makeNativeMap(createConstantsForViewManager);
            }
            SystraceMessage.endSection(0).flush();
            return null;
        } finally {
            SystraceMessage.endSection(0).flush();
        }
    }

    private static Map<String, Object> createConstants(ViewManagerResolver viewManagerResolver) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        SystraceMessage.beginSection(0, "CreateUIManagerConstants").arg("Lazy", (Object) Boolean.TRUE).flush();
        try {
            return UIManagerModuleConstantsHelper.createConstants(viewManagerResolver);
        } finally {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    public <T extends View> int addRootView(T t2) {
        return addRootView(t2, (WritableMap) null, (String) null);
    }

    public void addUIBlock(UIBlock uIBlock) {
        this.mUIImplementation.addUIBlock(uIBlock);
    }

    public void addUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mUIManagerListeners.add(uIManagerListener);
    }

    @Deprecated
    public void addUIManagerListener(UIManagerModuleListener uIManagerModuleListener) {
        this.mListeners.add(uIManagerModuleListener);
    }

    @ReactMethod
    public void clearJSResponder() {
        this.mUIImplementation.clearJSResponder();
    }

    @ReactMethod
    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
        this.mUIImplementation.configureNextLayoutAnimation(readableMap, callback);
    }

    @ReactMethod
    public void createView(int i2, String str, int i3, ReadableMap readableMap) {
        if (DEBUG) {
            String str2 = "(UIManager.createView) tag: " + i2 + ", class: " + str + ", props: " + readableMap;
            FLog.d(ReactConstants.TAG, str2);
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, str2);
        }
        this.mUIImplementation.createView(i2, str, i3, readableMap);
    }

    @ReactMethod
    public void dismissPopupMenu() {
        this.mUIImplementation.dismissPopupMenu();
    }

    @Deprecated
    public void dispatchCommand(int i2, int i3, ReadableArray readableArray) {
        this.mUIImplementation.dispatchViewManagerCommand(i2, i3, readableArray);
    }

    @ReactMethod
    public void dispatchViewManagerCommand(int i2, Dynamic dynamic, ReadableArray readableArray) {
        UIManager uIManager = UIManagerHelper.getUIManager(getReactApplicationContext(), ViewUtil.getUIManagerType(i2));
        if (uIManager != null) {
            if (dynamic.getType() == ReadableType.Number) {
                uIManager.dispatchCommand(i2, dynamic.asInt(), readableArray);
            } else if (dynamic.getType() == ReadableType.String) {
                uIManager.dispatchCommand(i2, dynamic.asString(), readableArray);
            }
        }
    }

    @ReactMethod
    public void findSubviewIn(int i2, ReadableArray readableArray, Callback callback) {
        this.mUIImplementation.findSubviewIn(i2, (float) Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(0))), (float) Math.round(PixelUtil.toPixelFromDIP(readableArray.getDouble(1))), callback);
    }

    public Map<String, Object> getConstants() {
        return this.mModuleConstants;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getConstantsForViewManager(String str) {
        Map<String, WritableMap> map = this.mViewManagerConstantsCache;
        if (map == null || !map.containsKey(str)) {
            return computeConstantsForViewManager(str);
        }
        WritableMap writableMap = this.mViewManagerConstantsCache.get(str);
        int i2 = this.mViewManagerConstantsCacheSize - 1;
        this.mViewManagerConstantsCacheSize = i2;
        if (i2 <= 0) {
            this.mViewManagerConstantsCache = null;
        }
        return writableMap;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getDefaultEventTypes() {
        return Arguments.makeNativeMap(UIManagerModuleConstantsHelper.getDefaultExportableEventTypes());
    }

    @Deprecated
    public CustomEventNamesResolver getDirectEventNamesResolver() {
        return new CustomEventNamesResolver() {
            public String resolveCustomEventName(String str) {
                return UIManagerModule.this.resolveCustomDirectEventName(str);
            }
        };
    }

    public String getName() {
        return NAME;
    }

    public Map<String, Long> getPerformanceCounters() {
        return this.mUIImplementation.getProfiledBatchPerfCounters();
    }

    @Deprecated
    public UIImplementation getUIImplementation() {
        return this.mUIImplementation;
    }

    @Deprecated
    public ViewManagerRegistry getViewManagerRegistry_DO_NOT_USE() {
        return this.mViewManagerRegistry;
    }

    public void initialize() {
        getReactApplicationContext().registerComponentCallbacks(this.mMemoryTrimCallback);
        this.mEventDispatcher.registerEventEmitter(1, (RCTEventEmitter) getReactApplicationContext().getJSModule(RCTEventEmitter.class));
    }

    public void invalidateNodeLayout(int i2) {
        ReactShadowNode resolveShadowNode = this.mUIImplementation.resolveShadowNode(i2);
        if (resolveShadowNode == null) {
            FLog.w(ReactConstants.TAG, "Warning : attempted to dirty a non-existent react shadow node. reactTag=" + i2);
            return;
        }
        resolveShadowNode.dirty();
        this.mUIImplementation.dispatchViewUpdates(-1);
    }

    @ReactMethod
    public void manageChildren(int i2, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
        if (DEBUG) {
            String str = "(UIManager.manageChildren) tag: " + i2 + ", moveFrom: " + readableArray + ", moveTo: " + readableArray2 + ", addTags: " + readableArray3 + ", atIndices: " + readableArray4 + ", removeFrom: " + readableArray5;
            FLog.d(ReactConstants.TAG, str);
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, str);
        }
        this.mUIImplementation.manageChildren(i2, readableArray, readableArray2, readableArray3, readableArray4, readableArray5);
    }

    @ReactMethod
    public void measure(int i2, Callback callback) {
        this.mUIImplementation.measure(i2, callback);
    }

    @ReactMethod
    public void measureInWindow(int i2, Callback callback) {
        this.mUIImplementation.measureInWindow(i2, callback);
    }

    @ReactMethod
    public void measureLayout(int i2, int i3, Callback callback, Callback callback2) {
        this.mUIImplementation.measureLayout(i2, i3, callback, callback2);
    }

    @Deprecated
    @ReactMethod
    public void measureLayoutRelativeToParent(int i2, Callback callback, Callback callback2) {
        this.mUIImplementation.measureLayoutRelativeToParent(i2, callback, callback2);
    }

    public void onBatchComplete() {
        int i2 = this.mBatchId;
        this.mBatchId = i2 + 1;
        SystraceMessage.beginSection(0, "onBatchCompleteUI").arg("BatchId", i2).flush();
        for (UIManagerModuleListener willDispatchViewUpdates : this.mListeners) {
            willDispatchViewUpdates.willDispatchViewUpdates(this);
        }
        Iterator<UIManagerListener> it2 = this.mUIManagerListeners.iterator();
        while (it2.hasNext()) {
            it2.next().willDispatchViewUpdates(this);
        }
        try {
            if (this.mNumRootViews > 0) {
                this.mUIImplementation.dispatchViewUpdates(i2);
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        this.mEventDispatcher.onCatalystInstanceDestroyed();
        this.mUIImplementation.onCatalystInstanceDestroyed();
        getReactApplicationContext().unregisterComponentCallbacks(this.mMemoryTrimCallback);
        YogaNodePool.get().clear();
        ViewManagerPropertyUpdater.clear();
    }

    public void onHostDestroy() {
        this.mUIImplementation.onHostDestroy();
    }

    public void onHostPause() {
        this.mUIImplementation.onHostPause();
    }

    public void onHostResume() {
        this.mUIImplementation.onHostResume();
    }

    @Deprecated
    public void preInitializeViewManagers(List<String> list) {
        ArrayMap arrayMap = new ArrayMap();
        for (String next : list) {
            WritableMap computeConstantsForViewManager = computeConstantsForViewManager(next);
            if (computeConstantsForViewManager != null) {
                arrayMap.put(next, computeConstantsForViewManager);
            }
        }
        this.mViewManagerConstantsCacheSize = list.size();
        this.mViewManagerConstantsCache = Collections.unmodifiableMap(arrayMap);
    }

    public void prependUIBlock(UIBlock uIBlock) {
        this.mUIImplementation.prependUIBlock(uIBlock);
    }

    public void profileNextBatch() {
        this.mUIImplementation.profileNextBatch();
    }

    public void receiveEvent(int i2, String str, WritableMap writableMap) {
        receiveEvent(-1, i2, str, writableMap);
    }

    @ReactMethod
    public void removeRootView(int i2) {
        this.mUIImplementation.removeRootView(i2);
        this.mNumRootViews--;
    }

    @Deprecated
    @ReactMethod
    public void removeSubviewsFromContainerWithID(int i2) {
        this.mUIImplementation.removeSubviewsFromContainerWithID(i2);
    }

    public void removeUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mUIManagerListeners.remove(uIManagerListener);
    }

    @Deprecated
    public void removeUIManagerListener(UIManagerModuleListener uIManagerModuleListener) {
        this.mListeners.remove(uIManagerModuleListener);
    }

    @Deprecated
    @ReactMethod
    public void replaceExistingNonRootView(int i2, int i3) {
        this.mUIImplementation.replaceExistingNonRootView(i2, i3);
    }

    @Deprecated
    public String resolveCustomDirectEventName(String str) {
        Map map;
        if (str == null || (map = (Map) this.mCustomDirectEvents.get(str)) == null) {
            return str;
        }
        return (String) map.get("registrationName");
    }

    @Deprecated
    public int resolveRootTagFromReactTag(int i2) {
        if (ViewUtil.isRootTag(i2)) {
            return i2;
        }
        return this.mUIImplementation.resolveRootTagFromReactTag(i2);
    }

    public View resolveView(int i2) {
        UiThreadUtil.assertOnUiThread();
        return this.mUIImplementation.getUIViewOperationQueue().getNativeViewHierarchyManager().resolveView(i2);
    }

    @ReactMethod
    public void sendAccessibilityEvent(int i2, int i3) {
        int uIManagerType = ViewUtil.getUIManagerType(i2);
        if (uIManagerType == 2) {
            UIManager uIManager = UIManagerHelper.getUIManager(getReactApplicationContext(), uIManagerType);
            if (uIManager != null) {
                uIManager.sendAccessibilityEvent(i2, i3);
                return;
            }
            return;
        }
        this.mUIImplementation.sendAccessibilityEvent(i2, i3);
    }

    @ReactMethod
    public void setChildren(int i2, ReadableArray readableArray) {
        if (DEBUG) {
            String str = "(UIManager.setChildren) tag: " + i2 + ", children: " + readableArray;
            FLog.d(ReactConstants.TAG, str);
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, str);
        }
        this.mUIImplementation.setChildren(i2, readableArray);
    }

    @ReactMethod
    public void setJSResponder(int i2, boolean z2) {
        this.mUIImplementation.setJSResponder(i2, z2);
    }

    @ReactMethod
    public void setLayoutAnimationEnabledExperimental(boolean z2) {
        this.mUIImplementation.setLayoutAnimationEnabledExperimental(z2);
    }

    public void setViewHierarchyUpdateDebugListener(NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.mUIImplementation.setViewHierarchyUpdateDebugListener(notThreadSafeViewHierarchyUpdateDebugListener);
    }

    public void setViewLocalData(final int i2, final Object obj) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.assertOnUiQueueThread();
        reactApplicationContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactApplicationContext) {
            public void runGuarded() {
                UIManagerModule.this.mUIImplementation.setViewLocalData(i2, obj);
            }
        });
    }

    @ReactMethod
    public void showPopupMenu(int i2, ReadableArray readableArray, Callback callback, Callback callback2) {
        this.mUIImplementation.showPopupMenu(i2, readableArray, callback, callback2);
    }

    public <T extends View> int startSurface(T t2, String str, WritableMap writableMap, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    public void stopSurface(int i2) {
        throw new UnsupportedOperationException();
    }

    public void synchronouslyUpdateViewOnUIThread(int i2, ReadableMap readableMap) {
        this.mUIImplementation.synchronouslyUpdateViewOnUIThread(i2, new ReactStylesDiffMap(readableMap));
    }

    public void updateNodeSize(int i2, int i3, int i4) {
        getReactApplicationContext().assertOnNativeModulesQueueThread();
        this.mUIImplementation.updateNodeSize(i2, i3, i4);
    }

    public void updateRootLayoutSpecs(int i2, int i3, int i4, int i5, int i6) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final int i7 = i2;
        final int i8 = i3;
        final int i9 = i4;
        reactApplicationContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactApplicationContext) {
            public void runGuarded() {
                UIManagerModule.this.mUIImplementation.updateRootView(i7, i8, i9);
                UIManagerModule.this.mUIImplementation.dispatchViewUpdates(-1);
            }
        });
    }

    @ReactMethod
    public void updateView(int i2, String str, ReadableMap readableMap) {
        if (DEBUG) {
            String str2 = "(UIManager.updateView) tag: " + i2 + ", class: " + str + ", props: " + readableMap;
            FLog.d(ReactConstants.TAG, str2);
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, str2);
        }
        this.mUIImplementation.updateView(i2, str, readableMap);
    }

    @Deprecated
    @ReactMethod
    public void viewIsDescendantOf(int i2, int i3, Callback callback) {
        this.mUIImplementation.viewIsDescendantOf(i2, i3, callback);
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, List<ViewManager> list, int i2) {
        this(reactApplicationContext, list, new UIImplementationProvider(), i2);
    }

    public <T extends View> int addRootView(T t2, WritableMap writableMap, String str) {
        Systrace.beginSection(0, "UIManagerModule.addRootView");
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        this.mUIImplementation.registerRootView(t2, nextRootViewTag, new ThemedReactContext(getReactApplicationContext(), t2.getContext(), ((ReactRoot) t2).getSurfaceID(), -1));
        this.mNumRootViews++;
        Systrace.endSection(0);
        return nextRootViewTag;
    }

    public void dispatchCommand(int i2, String str, ReadableArray readableArray) {
        this.mUIImplementation.dispatchViewManagerCommand(i2, str, readableArray);
    }

    public EventDispatcher getEventDispatcher() {
        return this.mEventDispatcher;
    }

    public void receiveEvent(int i2, int i3, String str, WritableMap writableMap) {
        ((RCTEventEmitter) getReactApplicationContext().getJSModule(RCTEventEmitter.class)).receiveEvent(i3, str, writableMap);
    }

    @Deprecated
    public UIManagerModule(ReactApplicationContext reactApplicationContext, ViewManagerResolver viewManagerResolver, UIImplementationProvider uIImplementationProvider, int i2) {
        super(reactApplicationContext);
        this.mMemoryTrimCallback = new MemoryTrimCallback();
        this.mListeners = new ArrayList();
        this.mUIManagerListeners = new CopyOnWriteArrayList<>();
        this.mBatchId = 0;
        this.mNumRootViews = 0;
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(reactApplicationContext);
        EventDispatcherImpl eventDispatcherImpl = new EventDispatcherImpl(reactApplicationContext);
        this.mEventDispatcher = eventDispatcherImpl;
        this.mModuleConstants = createConstants(viewManagerResolver);
        this.mCustomDirectEvents = UIManagerModuleConstants.getDirectEventTypeConstants();
        ViewManagerRegistry viewManagerRegistry = new ViewManagerRegistry(viewManagerResolver);
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mUIImplementation = uIImplementationProvider.createUIImplementation(reactApplicationContext, viewManagerRegistry, (EventDispatcher) eventDispatcherImpl, i2);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    private static Map<String, Object> createConstants(List<ViewManager> list, Map<String, Object> map, Map<String, Object> map2) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        SystraceMessage.beginSection(0, "CreateUIManagerConstants").arg("Lazy", (Object) Boolean.FALSE).flush();
        try {
            return UIManagerModuleConstantsHelper.createConstants(list, map, map2);
        } finally {
            Systrace.endSection(0);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    @Deprecated
    public UIManagerModule(ReactApplicationContext reactApplicationContext, List<ViewManager> list, UIImplementationProvider uIImplementationProvider, int i2) {
        super(reactApplicationContext);
        this.mMemoryTrimCallback = new MemoryTrimCallback();
        this.mListeners = new ArrayList();
        this.mUIManagerListeners = new CopyOnWriteArrayList<>();
        this.mBatchId = 0;
        this.mNumRootViews = 0;
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(reactApplicationContext);
        EventDispatcherImpl eventDispatcherImpl = new EventDispatcherImpl(reactApplicationContext);
        this.mEventDispatcher = eventDispatcherImpl;
        HashMap newHashMap = MapBuilder.newHashMap();
        this.mCustomDirectEvents = newHashMap;
        this.mModuleConstants = createConstants(list, (Map<String, Object>) null, newHashMap);
        ViewManagerRegistry viewManagerRegistry = new ViewManagerRegistry(list);
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mUIImplementation = uIImplementationProvider.createUIImplementation(reactApplicationContext, viewManagerRegistry, (EventDispatcher) eventDispatcherImpl, i2);
        reactApplicationContext.addLifecycleEventListener(this);
    }
}
