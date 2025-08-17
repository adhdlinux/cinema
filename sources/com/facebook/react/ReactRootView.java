package com.facebook.react;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactClippingProhibitedView;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import java.util.concurrent.atomic.AtomicInteger;

public class ReactRootView extends FrameLayout implements RootView, ReactRoot {
    private static final String TAG = "ReactRootView";
    private final ReactAndroidHWInputDeviceHelper mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
    private Bundle mAppProperties;
    private CustomGlobalLayoutListener mCustomGlobalLayoutListener;
    private int mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
    private String mInitialUITemplate;
    /* access modifiers changed from: private */
    public boolean mIsAttachedToInstance;
    private String mJSModuleName;
    private JSPointerDispatcher mJSPointerDispatcher;
    private JSTouchDispatcher mJSTouchDispatcher;
    /* access modifiers changed from: private */
    public int mLastHeight = 0;
    private int mLastOffsetX = Integer.MIN_VALUE;
    private int mLastOffsetY = Integer.MIN_VALUE;
    private int mLastWidth = 0;
    /* access modifiers changed from: private */
    public ReactInstanceManager mReactInstanceManager;
    private ReactRootViewEventListener mRootViewEventListener;
    private int mRootViewTag = 0;
    private boolean mShouldLogContentAppeared;
    private final AtomicInteger mState = new AtomicInteger(0);
    private int mUIManagerType = 1;
    private boolean mWasMeasured = false;
    private int mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);

    private class CustomGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private int mDeviceRotation = 0;
        private int mKeyboardHeight = 0;
        private final int mMinKeyboardHeightDetected;
        private final Rect mVisibleViewArea;

        CustomGlobalLayoutListener() {
            DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(ReactRootView.this.getContext().getApplicationContext());
            this.mVisibleViewArea = new Rect();
            this.mMinKeyboardHeightDetected = (int) PixelUtil.toPixelFromDIP(60.0f);
        }

        private void checkForDeviceDimensionsChanges() {
            emitUpdateDimensionsEvent();
        }

        private void checkForDeviceOrientationChanges() {
            int rotation = ((WindowManager) ReactRootView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            if (this.mDeviceRotation != rotation) {
                this.mDeviceRotation = rotation;
                DisplayMetricsHolder.initDisplayMetrics(ReactRootView.this.getContext().getApplicationContext());
                emitOrientationChanged(rotation);
            }
        }

        /* access modifiers changed from: private */
        public void checkForKeyboardEvents() {
            int i2;
            boolean z2;
            WindowInsets a2;
            DisplayCutout a3;
            ReactRootView.this.getRootView().getWindowVisibleDisplayFrame(this.mVisibleViewArea);
            if (Build.VERSION.SDK_INT < 28 || (a2 = ReactRootView.this.getRootView().getRootWindowInsets()) == null || (a3 = a2.getDisplayCutout()) == null) {
                i2 = 0;
            } else {
                i2 = a3.getSafeInsetTop();
            }
            int i3 = DisplayMetricsHolder.getWindowDisplayMetrics().heightPixels;
            int i4 = this.mVisibleViewArea.bottom;
            int i5 = (i3 - i4) + i2;
            int i6 = this.mKeyboardHeight;
            boolean z3 = true;
            if (i6 == i5 || i5 <= this.mMinKeyboardHeightDetected) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                this.mKeyboardHeight = i5;
                ReactRootView.this.sendEvent("keyboardDidShow", createKeyboardEventPayload((double) PixelUtil.toDIPFromPixel((float) i4), (double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.left), (double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.width()), (double) PixelUtil.toDIPFromPixel((float) this.mKeyboardHeight)));
                return;
            }
            if (i6 == 0 || i5 > this.mMinKeyboardHeightDetected) {
                z3 = false;
            }
            if (z3) {
                this.mKeyboardHeight = 0;
                ReactRootView reactRootView = ReactRootView.this;
                reactRootView.sendEvent("keyboardDidHide", createKeyboardEventPayload((double) PixelUtil.toDIPFromPixel((float) reactRootView.mLastHeight), 0.0d, (double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.width()), 0.0d));
            }
        }

        private WritableMap createKeyboardEventPayload(double d2, double d3, double d4, double d5) {
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putDouble("height", d5);
            createMap2.putDouble("screenX", d3);
            createMap2.putDouble("width", d4);
            createMap2.putDouble("screenY", d2);
            createMap.putMap("endCoordinates", createMap2);
            createMap.putString("easing", "keyboard");
            createMap.putDouble("duration", 0.0d);
            return createMap;
        }

        private void emitOrientationChanged(int i2) {
            String str;
            double d2;
            boolean z2 = false;
            if (i2 != 0) {
                if (i2 == 1) {
                    str = "landscape-primary";
                    d2 = -90.0d;
                } else if (i2 == 2) {
                    str = "portrait-secondary";
                    d2 = 180.0d;
                } else if (i2 == 3) {
                    str = "landscape-secondary";
                    d2 = 90.0d;
                } else {
                    return;
                }
                z2 = true;
            } else {
                str = "portrait-primary";
                d2 = 0.0d;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putString("name", str);
            createMap.putDouble("rotationDegrees", d2);
            createMap.putBoolean("isLandscape", z2);
            ReactRootView.this.sendEvent("namedOrientationDidChange", createMap);
        }

        private void emitUpdateDimensionsEvent() {
            DeviceInfoModule deviceInfoModule = (DeviceInfoModule) ReactRootView.this.mReactInstanceManager.getCurrentReactContext().getNativeModule(DeviceInfoModule.class);
            if (deviceInfoModule != null) {
                deviceInfoModule.emitUpdateDimensionsEvent();
            }
        }

        public void onGlobalLayout() {
            if (ReactRootView.this.mReactInstanceManager != null && ReactRootView.this.mIsAttachedToInstance && ReactRootView.this.mReactInstanceManager.getCurrentReactContext() != null) {
                checkForKeyboardEvents();
                checkForDeviceOrientationChanges();
                checkForDeviceDimensionsChanges();
            }
        }
    }

    public interface ReactRootViewEventListener {
        void onAttachedToReactInstance(ReactRootView reactRootView);
    }

    public ReactRootView(Context context) {
        super(context);
        init();
    }

    private void attachToReactInstanceManager() {
        Systrace.beginSection(0, "attachToReactInstanceManager");
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_START);
        if (getId() != -1) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalViewOperationException("Trying to attach a ReactRootView with an explicit id already set to [" + getId() + "]. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID."));
        }
        try {
            if (!this.mIsAttachedToInstance) {
                this.mIsAttachedToInstance = true;
                ((ReactInstanceManager) Assertions.assertNotNull(this.mReactInstanceManager)).attachRootView(this);
                getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
                ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END);
                Systrace.endSection(0);
            }
        } finally {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END);
            Systrace.endSection(0);
        }
    }

    private void dispatchJSPointerEvent(MotionEvent motionEvent) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w(TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
        } else if (this.mJSPointerDispatcher != null) {
            UIManager uIManager = UIManagerHelper.getUIManager(this.mReactInstanceManager.getCurrentReactContext(), getUIManagerType());
            if (uIManager != null) {
                this.mJSPointerDispatcher.handleMotionEvent(motionEvent, (EventDispatcher) uIManager.getEventDispatcher());
            }
        } else if (ReactFeatureFlags.dispatchPointerEvents) {
            FLog.w(TAG, "Unable to dispatch pointer events to JS before the dispatcher is available");
        }
    }

    private void dispatchJSTouchEvent(MotionEvent motionEvent) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w(TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
        } else if (this.mJSTouchDispatcher == null) {
            FLog.w(TAG, "Unable to dispatch touch to JS before the dispatcher is available");
        } else {
            UIManager uIManager = UIManagerHelper.getUIManager(this.mReactInstanceManager.getCurrentReactContext(), getUIManagerType());
            if (uIManager != null) {
                this.mJSTouchDispatcher.handleTouchEvent(motionEvent, (EventDispatcher) uIManager.getEventDispatcher());
            }
        }
    }

    private CustomGlobalLayoutListener getCustomGlobalLayoutListener() {
        if (this.mCustomGlobalLayoutListener == null) {
            this.mCustomGlobalLayoutListener = new CustomGlobalLayoutListener();
        }
        return this.mCustomGlobalLayoutListener;
    }

    private void init() {
        setClipChildren(false);
    }

    private boolean isDispatcherReady() {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w(TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
            return false;
        } else if (this.mJSTouchDispatcher == null) {
            FLog.w(TAG, "Unable to dispatch touch to JS before the dispatcher is available");
            return false;
        } else if (!ReactFeatureFlags.dispatchPointerEvents || this.mJSPointerDispatcher != null) {
            return true;
        } else {
            FLog.w(TAG, "Unable to dispatch pointer events to JS before the dispatcher is available");
            return false;
        }
    }

    private boolean isFabric() {
        return getUIManagerType() == 2;
    }

    private boolean isRootViewTagSet() {
        int i2 = this.mRootViewTag;
        return (i2 == 0 || i2 == -1) ? false : true;
    }

    private void removeOnGlobalLayoutListener() {
        getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
    }

    private void setSurfaceConstraintsToScreenSize() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE);
    }

    private void updateRootLayoutSpecs(boolean z2, int i2, int i3) {
        UIManager uIManager;
        int i4;
        int i5;
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_START);
        if (this.mReactInstanceManager == null) {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
            FLog.w(TAG, "Unable to update root layout specs for uninitialized ReactInstanceManager");
            return;
        }
        boolean isFabric = isFabric();
        if (!isFabric || isRootViewTagSet()) {
            ReactContext currentReactContext = this.mReactInstanceManager.getCurrentReactContext();
            if (!(currentReactContext == null || (uIManager = UIManagerHelper.getUIManager(currentReactContext, getUIManagerType())) == null)) {
                if (isFabric) {
                    Point viewportOffset = RootViewUtil.getViewportOffset(this);
                    i4 = viewportOffset.x;
                    i5 = viewportOffset.y;
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                if (!(!z2 && i4 == this.mLastOffsetX && i5 == this.mLastOffsetY)) {
                    uIManager.updateRootLayoutSpecs(getRootViewTag(), i2, i3, i4, i5);
                }
                this.mLastOffsetX = i4;
                this.mLastOffsetY = i5;
            }
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
            return;
        }
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
        FLog.e(TAG, "Unable to update root layout specs for ReactRootView: no rootViewTag set yet");
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (StackOverflowError e2) {
            handleException(e2);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w(TAG, "Unable to handle key event as the catalyst instance has not been attached");
            return super.dispatchKeyEvent(keyEvent);
        }
        this.mAndroidHWInputDeviceHelper.handleKeyEvent(keyEvent);
        return super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        Assertions.assertCondition(!this.mIsAttachedToInstance, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
    }

    public Bundle getAppProperties() {
        return this.mAppProperties;
    }

    public int getHeightMeasureSpec() {
        return this.mHeightMeasureSpec;
    }

    public String getInitialUITemplate() {
        return this.mInitialUITemplate;
    }

    public String getJSModuleName() {
        return (String) Assertions.assertNotNull(this.mJSModuleName);
    }

    public ReactInstanceManager getReactInstanceManager() {
        return this.mReactInstanceManager;
    }

    public ViewGroup getRootViewGroup() {
        return this;
    }

    public int getRootViewTag() {
        return this.mRootViewTag;
    }

    public AtomicInteger getState() {
        return this.mState;
    }

    public String getSurfaceID() {
        Bundle appProperties = getAppProperties();
        if (appProperties != null) {
            return appProperties.getString("surfaceID");
        }
        return null;
    }

    public int getUIManagerType() {
        return this.mUIManagerType;
    }

    public int getWidthMeasureSpec() {
        return this.mWidthMeasureSpec;
    }

    public void handleException(Throwable th) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || reactInstanceManager.getCurrentReactContext() == null) {
            throw new RuntimeException(th);
        }
        this.mReactInstanceManager.getCurrentReactContext().handleException(new IllegalViewOperationException(th.getMessage(), this, th));
    }

    public void onAttachedToReactInstance() {
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.mJSPointerDispatcher = new JSPointerDispatcher(this);
        }
        ReactRootViewEventListener reactRootViewEventListener = this.mRootViewEventListener;
        if (reactRootViewEventListener != null) {
            reactRootViewEventListener.onAttachedToReactInstance(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsAttachedToInstance) {
            removeOnGlobalLayoutListener();
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    public void onChildEndedNativeGesture(View view, MotionEvent motionEvent) {
        UIManager uIManager;
        if (isDispatcherReady() && (uIManager = UIManagerHelper.getUIManager(this.mReactInstanceManager.getCurrentReactContext(), getUIManagerType())) != null) {
            this.mJSTouchDispatcher.onChildEndedNativeGesture(motionEvent, (EventDispatcher) uIManager.getEventDispatcher());
            JSPointerDispatcher jSPointerDispatcher = this.mJSPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.onChildEndedNativeGesture();
            }
        }
    }

    public void onChildStartedNativeGesture(MotionEvent motionEvent) {
        onChildStartedNativeGesture((View) null, motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsAttachedToInstance) {
            removeOnGlobalLayoutListener();
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w(TAG, "Unable to handle focus changed event as the catalyst instance has not been attached");
            super.onFocusChanged(z2, i2, rect);
            return;
        }
        this.mAndroidHWInputDeviceHelper.clearFocus();
        super.onFocusChanged(z2, i2, rect);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        dispatchJSPointerEvent(motionEvent);
        return super.onHoverEvent(motionEvent);
    }

    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        dispatchJSPointerEvent(motionEvent);
        return super.onInterceptHoverEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (shouldDispatchJSTouchEvent(motionEvent)) {
            dispatchJSTouchEvent(motionEvent);
        }
        dispatchJSPointerEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (this.mWasMeasured && isFabric()) {
            updateRootLayoutSpecs(false, this.mWidthMeasureSpec, this.mHeightMeasureSpec);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026 A[Catch:{ all -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036 A[Catch:{ all -> 0x00b6 }, LOOP:0: B:15:0x0030->B:17:0x0036, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a A[Catch:{ all -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069 A[Catch:{ all -> 0x00b6 }, LOOP:1: B:24:0x0063->B:26:0x0069, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094 A[Catch:{ all -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0098 A[ADDED_TO_REGION, Catch:{ all -> 0x00b6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            java.lang.String r0 = "ReactRootView.onMeasure"
            r1 = 0
            com.facebook.systrace.Systrace.beginSection(r1, r0)
            com.facebook.react.bridge.ReactMarkerConstants r0 = com.facebook.react.bridge.ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_START
            com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r0)
            int r0 = r10.mWidthMeasureSpec     // Catch:{ all -> 0x00b6 }
            r3 = 0
            r4 = 1
            if (r11 != r0) goto L_0x0019
            int r0 = r10.mHeightMeasureSpec     // Catch:{ all -> 0x00b6 }
            if (r12 == r0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            r10.mWidthMeasureSpec = r11     // Catch:{ all -> 0x00b6 }
            r10.mHeightMeasureSpec = r12     // Catch:{ all -> 0x00b6 }
            int r5 = android.view.View.MeasureSpec.getMode(r11)     // Catch:{ all -> 0x00b6 }
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x002e
            if (r5 != 0) goto L_0x0029
            goto L_0x002e
        L_0x0029:
            int r11 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x00b6 }
            goto L_0x0054
        L_0x002e:
            r11 = 0
            r5 = 0
        L_0x0030:
            int r7 = r10.getChildCount()     // Catch:{ all -> 0x00b6 }
            if (r5 >= r7) goto L_0x0054
            android.view.View r7 = r10.getChildAt(r5)     // Catch:{ all -> 0x00b6 }
            int r8 = r7.getLeft()     // Catch:{ all -> 0x00b6 }
            int r9 = r7.getMeasuredWidth()     // Catch:{ all -> 0x00b6 }
            int r8 = r8 + r9
            int r9 = r7.getPaddingLeft()     // Catch:{ all -> 0x00b6 }
            int r8 = r8 + r9
            int r7 = r7.getPaddingRight()     // Catch:{ all -> 0x00b6 }
            int r8 = r8 + r7
            int r11 = java.lang.Math.max(r11, r8)     // Catch:{ all -> 0x00b6 }
            int r5 = r5 + 1
            goto L_0x0030
        L_0x0054:
            int r5 = android.view.View.MeasureSpec.getMode(r12)     // Catch:{ all -> 0x00b6 }
            if (r5 == r6) goto L_0x0062
            if (r5 != 0) goto L_0x005d
            goto L_0x0062
        L_0x005d:
            int r12 = android.view.View.MeasureSpec.getSize(r12)     // Catch:{ all -> 0x00b6 }
            goto L_0x0087
        L_0x0062:
            r12 = 0
        L_0x0063:
            int r5 = r10.getChildCount()     // Catch:{ all -> 0x00b6 }
            if (r3 >= r5) goto L_0x0087
            android.view.View r5 = r10.getChildAt(r3)     // Catch:{ all -> 0x00b6 }
            int r6 = r5.getTop()     // Catch:{ all -> 0x00b6 }
            int r7 = r5.getMeasuredHeight()     // Catch:{ all -> 0x00b6 }
            int r6 = r6 + r7
            int r7 = r5.getPaddingTop()     // Catch:{ all -> 0x00b6 }
            int r6 = r6 + r7
            int r5 = r5.getPaddingBottom()     // Catch:{ all -> 0x00b6 }
            int r6 = r6 + r5
            int r12 = java.lang.Math.max(r12, r6)     // Catch:{ all -> 0x00b6 }
            int r3 = r3 + 1
            goto L_0x0063
        L_0x0087:
            r10.setMeasuredDimension(r11, r12)     // Catch:{ all -> 0x00b6 }
            r10.mWasMeasured = r4     // Catch:{ all -> 0x00b6 }
            com.facebook.react.ReactInstanceManager r3 = r10.mReactInstanceManager     // Catch:{ all -> 0x00b6 }
            if (r3 == 0) goto L_0x0098
            boolean r3 = r10.mIsAttachedToInstance     // Catch:{ all -> 0x00b6 }
            if (r3 != 0) goto L_0x0098
            r10.attachToReactInstanceManager()     // Catch:{ all -> 0x00b6 }
            goto L_0x00a9
        L_0x0098:
            if (r0 != 0) goto L_0x00a2
            int r0 = r10.mLastWidth     // Catch:{ all -> 0x00b6 }
            if (r0 != r11) goto L_0x00a2
            int r0 = r10.mLastHeight     // Catch:{ all -> 0x00b6 }
            if (r0 == r12) goto L_0x00a9
        L_0x00a2:
            int r0 = r10.mWidthMeasureSpec     // Catch:{ all -> 0x00b6 }
            int r3 = r10.mHeightMeasureSpec     // Catch:{ all -> 0x00b6 }
            r10.updateRootLayoutSpecs(r4, r0, r3)     // Catch:{ all -> 0x00b6 }
        L_0x00a9:
            r10.mLastWidth = r11     // Catch:{ all -> 0x00b6 }
            r10.mLastHeight = r12     // Catch:{ all -> 0x00b6 }
            com.facebook.react.bridge.ReactMarkerConstants r11 = com.facebook.react.bridge.ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_END
            com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r11)
            com.facebook.systrace.Systrace.endSection(r1)
            return
        L_0x00b6:
            r11 = move-exception
            com.facebook.react.bridge.ReactMarkerConstants r12 = com.facebook.react.bridge.ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_END
            com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r12)
            com.facebook.systrace.Systrace.endSection(r1)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactRootView.onMeasure(int, int):void");
    }

    public void onStage(int i2) {
        if (i2 == 101) {
            onAttachedToReactInstance();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (shouldDispatchJSTouchEvent(motionEvent)) {
            dispatchJSTouchEvent(motionEvent);
        }
        dispatchJSPointerEvent(motionEvent);
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void onViewAdded(final View view) {
        super.onViewAdded(view);
        if (view instanceof ReactClippingProhibitedView) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (!view.isShown()) {
                        ReactSoftExceptionLogger.logSoftException(ReactRootView.TAG, new ReactNoCrashSoftException("A view was illegally added as a child of a ReactRootView. This View should not be a direct child of a ReactRootView, because it is not visible and will never be reachable. Child: " + view.getClass().getCanonicalName().toString() + " child ID: " + view.getId()));
                    }
                }
            });
        }
        if (this.mShouldLogContentAppeared) {
            this.mShouldLogContentAppeared = false;
            String str = this.mJSModuleName;
            if (str != null) {
                ReactMarker.logMarker(ReactMarkerConstants.CONTENT_APPEARED, str, this.mRootViewTag);
            }
        }
    }

    public void requestChildFocus(View view, View view2) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w(TAG, "Unable to handle child focus changed event as the catalyst instance has not been attached");
            super.requestChildFocus(view, view2);
            return;
        }
        this.mAndroidHWInputDeviceHelper.onFocusChanged(view2);
        super.requestChildFocus(view, view2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z2);
        }
    }

    public void runApplication() {
        Systrace.beginSection(0, "ReactRootView.runApplication");
        try {
            ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
            if (reactInstanceManager != null) {
                if (this.mIsAttachedToInstance) {
                    ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                    if (currentReactContext == null) {
                        Systrace.endSection(0);
                        return;
                    }
                    CatalystInstance catalystInstance = currentReactContext.getCatalystInstance();
                    String jSModuleName = getJSModuleName();
                    if (this.mWasMeasured) {
                        updateRootLayoutSpecs(true, this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                    }
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putDouble("rootTag", (double) getRootViewTag());
                    Bundle appProperties = getAppProperties();
                    if (appProperties != null) {
                        writableNativeMap.putMap("initialProps", Arguments.fromBundle(appProperties));
                    }
                    this.mShouldLogContentAppeared = true;
                    ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).runApplication(jSModuleName, writableNativeMap);
                    Systrace.endSection(0);
                }
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void sendEvent(String str, WritableMap writableMap) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactInstanceManager.getCurrentReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }

    @ThreadConfined("UI")
    public void setAppProperties(Bundle bundle) {
        UiThreadUtil.assertOnUiThread();
        this.mAppProperties = bundle;
        if (isRootViewTagSet()) {
            runApplication();
        }
    }

    public void setEventListener(ReactRootViewEventListener reactRootViewEventListener) {
        this.mRootViewEventListener = reactRootViewEventListener;
    }

    public void setIsFabric(boolean z2) {
        this.mUIManagerType = z2 ? 2 : 1;
    }

    public void setRootViewTag(int i2) {
        this.mRootViewTag = i2;
    }

    public void setShouldLogContentAppeared(boolean z2) {
        this.mShouldLogContentAppeared = z2;
    }

    public boolean shouldDispatchJSTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void simulateAttachForTesting() {
        this.mIsAttachedToInstance = true;
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.mJSPointerDispatcher = new JSPointerDispatcher(this);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void simulateCheckForKeyboardForTesting() {
        getCustomGlobalLayoutListener().checkForKeyboardEvents();
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str) {
        startReactApplication(reactInstanceManager, str, (Bundle) null);
    }

    @ThreadConfined("UI")
    public void unmountReactApplication() {
        ReactContext currentReactContext;
        UIManager uIManager;
        UiThreadUtil.assertOnUiThread();
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (!(reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null || !isFabric() || (uIManager = UIManagerHelper.getUIManager(currentReactContext, getUIManagerType())) == null)) {
            int id = getId();
            setId(-1);
            removeAllViews();
            if (id == -1) {
                ReactSoftExceptionLogger.logSoftException(TAG, new RuntimeException("unmountReactApplication called on ReactRootView with invalid id"));
            } else {
                uIManager.stopSurface(id);
            }
        }
        ReactInstanceManager reactInstanceManager2 = this.mReactInstanceManager;
        if (reactInstanceManager2 != null && this.mIsAttachedToInstance) {
            reactInstanceManager2.detachRootView(this);
            this.mIsAttachedToInstance = false;
        }
        this.mReactInstanceManager = null;
        this.mShouldLogContentAppeared = false;
    }

    public void onChildStartedNativeGesture(View view, MotionEvent motionEvent) {
        UIManager uIManager;
        JSPointerDispatcher jSPointerDispatcher;
        if (isDispatcherReady() && (uIManager = UIManagerHelper.getUIManager(this.mReactInstanceManager.getCurrentReactContext(), getUIManagerType())) != null) {
            EventDispatcher eventDispatcher = (EventDispatcher) uIManager.getEventDispatcher();
            this.mJSTouchDispatcher.onChildStartedNativeGesture(motionEvent, eventDispatcher);
            if (view != null && (jSPointerDispatcher = this.mJSPointerDispatcher) != null) {
                jSPointerDispatcher.onChildStartedNativeGesture(view, motionEvent, eventDispatcher);
            }
        }
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, Bundle bundle) {
        startReactApplication(reactInstanceManager, str, bundle, (String) null);
    }

    @ThreadConfined("UI")
    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, Bundle bundle, String str2) {
        Systrace.beginSection(0, "startReactApplication");
        try {
            UiThreadUtil.assertOnUiThread();
            Assertions.assertCondition(this.mReactInstanceManager == null, "This root view has already been attached to a catalyst instance manager");
            this.mReactInstanceManager = reactInstanceManager;
            this.mJSModuleName = str;
            this.mAppProperties = bundle;
            this.mInitialUITemplate = str2;
            reactInstanceManager.createReactContextInBackground();
            if (ReactFeatureFlags.enableEagerRootViewAttachment) {
                if (!this.mWasMeasured) {
                    setSurfaceConstraintsToScreenSize();
                }
                attachToReactInstanceManager();
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    public ReactRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ReactRootView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
