package com.facebook.react.fabric.mounting;

import android.content.Context;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.yoga.YogaMeasureMode;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MountingManager {
    private static final int MAX_STOPPED_SURFACE_IDS_LENGTH = 15;
    public static final String TAG = "MountingManager";
    private final JSResponderHandler mJSResponderHandler = new JSResponderHandler();
    private SurfaceMountingManager mLastQueriedSurfaceMountingManager;
    private SurfaceMountingManager mMostRecentSurfaceMountingManager;
    private final MountItemExecutor mMountItemExecutor;
    private final RootViewManager mRootViewManager = new RootViewManager();
    private final CopyOnWriteArrayList<Integer> mStoppedSurfaceIds = new CopyOnWriteArrayList<>();
    private final ConcurrentHashMap<Integer, SurfaceMountingManager> mSurfaceIdToManager = new ConcurrentHashMap<>();
    private final ViewManagerRegistry mViewManagerRegistry;

    public interface MountItemExecutor {
        @ThreadConfined("UI")
        void executeItems(Queue<MountItem> queue);
    }

    public MountingManager(ViewManagerRegistry viewManagerRegistry, MountItemExecutor mountItemExecutor) {
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mMountItemExecutor = mountItemExecutor;
    }

    public void attachRootView(int i2, View view, ThemedReactContext themedReactContext) {
        SurfaceMountingManager surfaceManagerEnforced = getSurfaceManagerEnforced(i2, "attachView");
        if (surfaceManagerEnforced.isStopped()) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Trying to attach a view to a stopped surface"));
        } else {
            surfaceManagerEnforced.attachRootView(view, themedReactContext);
        }
    }

    public void clearJSResponder() {
        this.mJSResponderHandler.clearJSResponder();
    }

    @ThreadConfined("ANY")
    public EventEmitterWrapper getEventEmitter(int i2, int i3) {
        SurfaceMountingManager surfaceMountingManager;
        if (i2 == -1) {
            surfaceMountingManager = getSurfaceManagerForView(i3);
        } else {
            surfaceMountingManager = getSurfaceManager(i2);
        }
        if (surfaceMountingManager == null) {
            return null;
        }
        return surfaceMountingManager.getEventEmitter(i3);
    }

    public SurfaceMountingManager getSurfaceManager(int i2) {
        SurfaceMountingManager surfaceMountingManager = this.mLastQueriedSurfaceMountingManager;
        if (surfaceMountingManager != null && surfaceMountingManager.getSurfaceId() == i2) {
            return this.mLastQueriedSurfaceMountingManager;
        }
        SurfaceMountingManager surfaceMountingManager2 = this.mMostRecentSurfaceMountingManager;
        if (surfaceMountingManager2 != null && surfaceMountingManager2.getSurfaceId() == i2) {
            return this.mMostRecentSurfaceMountingManager;
        }
        SurfaceMountingManager surfaceMountingManager3 = this.mSurfaceIdToManager.get(Integer.valueOf(i2));
        this.mLastQueriedSurfaceMountingManager = surfaceMountingManager3;
        return surfaceMountingManager3;
    }

    public SurfaceMountingManager getSurfaceManagerEnforced(int i2, String str) {
        SurfaceMountingManager surfaceManager = getSurfaceManager(i2);
        if (surfaceManager != null) {
            return surfaceManager;
        }
        throw new RetryableMountingLayerException("Unable to find SurfaceMountingManager for surfaceId: [" + i2 + "]. Context: " + str);
    }

    public SurfaceMountingManager getSurfaceManagerForView(int i2) {
        SurfaceMountingManager surfaceMountingManager = this.mMostRecentSurfaceMountingManager;
        if (surfaceMountingManager != null && surfaceMountingManager.getViewExists(i2)) {
            return this.mMostRecentSurfaceMountingManager;
        }
        for (Map.Entry<Integer, SurfaceMountingManager> value : this.mSurfaceIdToManager.entrySet()) {
            SurfaceMountingManager surfaceMountingManager2 = (SurfaceMountingManager) value.getValue();
            if (surfaceMountingManager2 != this.mMostRecentSurfaceMountingManager && surfaceMountingManager2.getViewExists(i2)) {
                if (this.mMostRecentSurfaceMountingManager == null) {
                    this.mMostRecentSurfaceMountingManager = surfaceMountingManager2;
                }
                return surfaceMountingManager2;
            }
        }
        return null;
    }

    public SurfaceMountingManager getSurfaceManagerForViewEnforced(int i2) {
        SurfaceMountingManager surfaceManagerForView = getSurfaceManagerForView(i2);
        if (surfaceManagerForView != null) {
            return surfaceManagerForView;
        }
        throw new RetryableMountingLayerException("Unable to find SurfaceMountingManager for tag: [" + i2 + "]");
    }

    public boolean getViewExists(int i2) {
        return getSurfaceManagerForView(i2) != null;
    }

    public void initializeViewManager(String str) {
        this.mViewManagerRegistry.get(str);
    }

    public boolean isWaitingForViewAttach(int i2) {
        SurfaceMountingManager surfaceManager = getSurfaceManager(i2);
        if (surfaceManager != null && !surfaceManager.isStopped()) {
            return !surfaceManager.isRootViewAttached();
        }
        return false;
    }

    public long measure(ReactContext reactContext, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2, float[] fArr) {
        String str2 = str;
        return this.mViewManagerRegistry.get(str).measure((Context) reactContext, readableMap, readableMap2, readableMap3, f2, yogaMeasureMode, f3, yogaMeasureMode2, fArr);
    }

    public long measureMapBuffer(ReactContext reactContext, String str, MapBuffer mapBuffer, MapBuffer mapBuffer2, MapBuffer mapBuffer3, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2, float[] fArr) {
        String str2 = str;
        return this.mViewManagerRegistry.get(str).measure((Context) reactContext, mapBuffer, mapBuffer2, mapBuffer3, f2, yogaMeasureMode, f3, yogaMeasureMode2, fArr);
    }

    @Deprecated
    public void receiveCommand(int i2, int i3, int i4, ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        getSurfaceManagerEnforced(i2, "receiveCommand:int").receiveCommand(i3, i4, readableArray);
    }

    public void sendAccessibilityEvent(int i2, int i3, int i4) {
        UiThreadUtil.assertOnUiThread();
        if (i2 == -1) {
            getSurfaceManagerForViewEnforced(i3).sendAccessibilityEvent(i3, i4);
        } else {
            getSurfaceManagerEnforced(i2, "sendAccessibilityEvent").sendAccessibilityEvent(i3, i4);
        }
    }

    public SurfaceMountingManager startSurface(int i2, ThemedReactContext themedReactContext, View view) {
        SurfaceMountingManager surfaceMountingManager = new SurfaceMountingManager(i2, this.mJSResponderHandler, this.mViewManagerRegistry, this.mRootViewManager, this.mMountItemExecutor, themedReactContext);
        this.mSurfaceIdToManager.putIfAbsent(Integer.valueOf(i2), surfaceMountingManager);
        if (this.mSurfaceIdToManager.get(Integer.valueOf(i2)) != surfaceMountingManager) {
            String str = TAG;
            ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException("Called startSurface more than once for the SurfaceId [" + i2 + "]"));
        }
        this.mMostRecentSurfaceMountingManager = this.mSurfaceIdToManager.get(Integer.valueOf(i2));
        if (view != null) {
            surfaceMountingManager.attachRootView(view, themedReactContext);
        }
        return surfaceMountingManager;
    }

    public void stopSurface(int i2) {
        SurfaceMountingManager surfaceMountingManager = this.mSurfaceIdToManager.get(Integer.valueOf(i2));
        if (surfaceMountingManager != null) {
            while (this.mStoppedSurfaceIds.size() >= 15) {
                Integer num = this.mStoppedSurfaceIds.get(0);
                this.mSurfaceIdToManager.remove(Integer.valueOf(num.intValue()));
                this.mStoppedSurfaceIds.remove(num);
                FLog.d(TAG, "Removing stale SurfaceMountingManager: [%d]", (Object) Integer.valueOf(num.intValue()));
            }
            this.mStoppedSurfaceIds.add(Integer.valueOf(i2));
            surfaceMountingManager.stopSurface();
            if (surfaceMountingManager == this.mMostRecentSurfaceMountingManager) {
                this.mMostRecentSurfaceMountingManager = null;
                return;
            }
            return;
        }
        String str = TAG;
        ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException("Cannot call stopSurface on non-existent surface: [" + i2 + "]"));
    }

    public boolean surfaceIsStopped(int i2) {
        if (this.mStoppedSurfaceIds.contains(Integer.valueOf(i2))) {
            return true;
        }
        SurfaceMountingManager surfaceManager = getSurfaceManager(i2);
        if (surfaceManager == null || !surfaceManager.isStopped()) {
            return false;
        }
        return true;
    }

    public void updateProps(int i2, ReadableMap readableMap) {
        UiThreadUtil.assertOnUiThread();
        if (readableMap != null) {
            getSurfaceManagerForViewEnforced(i2).updateProps(i2, readableMap);
        }
    }

    public void receiveCommand(int i2, int i3, String str, ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        getSurfaceManagerEnforced(i2, "receiveCommand:string").receiveCommand(i3, str, readableArray);
    }
}
