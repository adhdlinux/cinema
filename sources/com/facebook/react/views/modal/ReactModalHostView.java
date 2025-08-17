package com.facebook.react.views.modal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.FabricViewStateManager;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.common.ContextUtils;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;
import okhttp3.internal.http2.Http2Connection;

public class ReactModalHostView extends ViewGroup implements LifecycleEventListener, FabricViewStateManager.HasFabricViewStateManager {
    private static final String TAG = "ReactModalHost";
    private String mAnimationType;
    private Dialog mDialog;
    private boolean mHardwareAccelerated;
    private DialogRootViewGroup mHostView;
    /* access modifiers changed from: private */
    public OnRequestCloseListener mOnRequestCloseListener;
    private DialogInterface.OnShowListener mOnShowListener;
    private boolean mPropertyRequiresNewDialog;
    private boolean mStatusBarTranslucent;
    private boolean mTransparent;

    static class DialogRootViewGroup extends ReactViewGroup implements RootView, FabricViewStateManager.HasFabricViewStateManager {
        private boolean hasAdjustedSize = false;
        private EventDispatcher mEventDispatcher;
        private final FabricViewStateManager mFabricViewStateManager = new FabricViewStateManager();
        private JSPointerDispatcher mJSPointerDispatcher;
        private final JSTouchDispatcher mJSTouchDispatcher = new JSTouchDispatcher(this);
        /* access modifiers changed from: private */
        public int viewHeight;
        /* access modifiers changed from: private */
        public int viewWidth;

        public DialogRootViewGroup(Context context) {
            super(context);
            if (ReactFeatureFlags.dispatchPointerEvents) {
                this.mJSPointerDispatcher = new JSPointerDispatcher(this);
            }
        }

        /* access modifiers changed from: private */
        public ReactContext getReactContext() {
            return (ReactContext) getContext();
        }

        /* access modifiers changed from: private */
        public void setEventDispatcher(EventDispatcher eventDispatcher) {
            this.mEventDispatcher = eventDispatcher;
        }

        private void updateFirstChildView() {
            if (getChildCount() > 0) {
                this.hasAdjustedSize = false;
                final int id = getChildAt(0).getId();
                if (this.mFabricViewStateManager.hasStateWrapper()) {
                    updateState(this.viewWidth, this.viewHeight);
                    return;
                }
                ReactContext reactContext = getReactContext();
                reactContext.runOnNativeModulesQueueThread(new GuardedRunnable(reactContext) {
                    public void runGuarded() {
                        UIManagerModule uIManagerModule = (UIManagerModule) DialogRootViewGroup.this.getReactContext().getNativeModule(UIManagerModule.class);
                        if (uIManagerModule != null) {
                            uIManagerModule.updateNodeSize(id, DialogRootViewGroup.this.viewWidth, DialogRootViewGroup.this.viewHeight);
                        }
                    }
                });
                return;
            }
            this.hasAdjustedSize = true;
        }

        public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
            super.addView(view, i2, layoutParams);
            if (this.hasAdjustedSize) {
                updateFirstChildView();
            }
        }

        public FabricViewStateManager getFabricViewStateManager() {
            return this.mFabricViewStateManager;
        }

        public void handleException(Throwable th) {
            getReactContext().handleException(new RuntimeException(th));
        }

        public void onChildEndedNativeGesture(View view, MotionEvent motionEvent) {
            this.mJSTouchDispatcher.onChildEndedNativeGesture(motionEvent, this.mEventDispatcher);
            JSPointerDispatcher jSPointerDispatcher = this.mJSPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.onChildEndedNativeGesture();
            }
        }

        public void onChildStartedNativeGesture(MotionEvent motionEvent) {
            onChildStartedNativeGesture((View) null, motionEvent);
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            JSPointerDispatcher jSPointerDispatcher = this.mJSPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.handleMotionEvent(motionEvent, this.mEventDispatcher);
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
            JSPointerDispatcher jSPointerDispatcher = this.mJSPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.handleMotionEvent(motionEvent, this.mEventDispatcher);
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, this.mEventDispatcher);
            JSPointerDispatcher jSPointerDispatcher = this.mJSPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.handleMotionEvent(motionEvent, this.mEventDispatcher);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.viewWidth = i2;
            this.viewHeight = i3;
            updateFirstChildView();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, this.mEventDispatcher);
            JSPointerDispatcher jSPointerDispatcher = this.mJSPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.handleMotionEvent(motionEvent, this.mEventDispatcher);
            }
            super.onTouchEvent(motionEvent);
            return true;
        }

        public void requestDisallowInterceptTouchEvent(boolean z2) {
        }

        public void updateState(int i2, int i3) {
            float f2;
            final float dIPFromPixel = PixelUtil.toDIPFromPixel((float) i2);
            final float dIPFromPixel2 = PixelUtil.toDIPFromPixel((float) i3);
            ReadableMap stateData = getFabricViewStateManager().getStateData();
            if (stateData != null) {
                float f3 = 0.0f;
                if (stateData.hasKey("screenHeight")) {
                    f2 = (float) stateData.getDouble("screenHeight");
                } else {
                    f2 = 0.0f;
                }
                if (stateData.hasKey("screenWidth")) {
                    f3 = (float) stateData.getDouble("screenWidth");
                }
                if (Math.abs(f3 - dIPFromPixel) < 0.9f && Math.abs(f2 - dIPFromPixel2) < 0.9f) {
                    return;
                }
            }
            this.mFabricViewStateManager.setState(new FabricViewStateManager.StateUpdateCallback() {
                public WritableMap getStateUpdate() {
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putDouble("screenWidth", (double) dIPFromPixel);
                    writableNativeMap.putDouble("screenHeight", (double) dIPFromPixel2);
                    return writableNativeMap;
                }
            });
        }

        public void onChildStartedNativeGesture(View view, MotionEvent motionEvent) {
            this.mJSTouchDispatcher.onChildStartedNativeGesture(motionEvent, this.mEventDispatcher);
            JSPointerDispatcher jSPointerDispatcher = this.mJSPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.onChildStartedNativeGesture(view, motionEvent, this.mEventDispatcher);
            }
        }
    }

    public interface OnRequestCloseListener {
        void onRequestClose(DialogInterface dialogInterface);
    }

    public ReactModalHostView(Context context) {
        super(context);
        ((ReactContext) context).addLifecycleEventListener(this);
        this.mHostView = new DialogRootViewGroup(context);
    }

    private void dismiss() {
        Activity activity;
        UiThreadUtil.assertOnUiThread();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            if (dialog.isShowing() && ((activity = (Activity) ContextUtils.findContextOfType(this.mDialog.getContext(), Activity.class)) == null || !activity.isFinishing())) {
                this.mDialog.dismiss();
            }
            this.mDialog = null;
            ((ViewGroup) this.mHostView.getParent()).removeViewAt(0);
        }
    }

    private View getContentView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.mHostView);
        if (this.mStatusBarTranslucent) {
            frameLayout.setSystemUiVisibility(1024);
        } else {
            frameLayout.setFitsSystemWindows(true);
        }
        return frameLayout;
    }

    private Activity getCurrentActivity() {
        return ((ReactContext) getContext()).getCurrentActivity();
    }

    private void updateProperties() {
        Assertions.assertNotNull(this.mDialog, "mDialog must exist when we call updateProperties");
        Activity currentActivity = getCurrentActivity();
        Window window = this.mDialog.getWindow();
        if (currentActivity != null && !currentActivity.isFinishing() && window.isActive()) {
            if ((currentActivity.getWindow().getAttributes().flags & 1024) != 0) {
                window.addFlags(1024);
            } else {
                window.clearFlags(1024);
            }
            if (this.mTransparent) {
                window.clearFlags(2);
                return;
            }
            window.setDimAmount(0.5f);
            window.setFlags(2, 2);
        }
    }

    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
    }

    public void addView(View view, int i2) {
        UiThreadUtil.assertOnUiThread();
        this.mHostView.addView(view, i2);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        this.mHostView.dispatchProvideStructure(viewStructure);
    }

    public View getChildAt(int i2) {
        return this.mHostView.getChildAt(i2);
    }

    public int getChildCount() {
        return this.mHostView.getChildCount();
    }

    @VisibleForTesting
    public Dialog getDialog() {
        return this.mDialog;
    }

    public FabricViewStateManager getFabricViewStateManager() {
        return this.mHostView.getFabricViewStateManager();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismiss();
    }

    public void onDropInstance() {
        ((ReactContext) getContext()).removeLifecycleEventListener(this);
        dismiss();
    }

    public void onHostDestroy() {
        onDropInstance();
    }

    public void onHostPause() {
    }

    public void onHostResume() {
        showOrUpdate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
    }

    public void removeView(View view) {
        UiThreadUtil.assertOnUiThread();
        this.mHostView.removeView(view);
    }

    public void removeViewAt(int i2) {
        UiThreadUtil.assertOnUiThread();
        this.mHostView.removeView(getChildAt(i2));
    }

    /* access modifiers changed from: protected */
    public void setAnimationType(String str) {
        this.mAnimationType = str;
        this.mPropertyRequiresNewDialog = true;
    }

    /* access modifiers changed from: package-private */
    public void setEventDispatcher(EventDispatcher eventDispatcher) {
        this.mHostView.setEventDispatcher(eventDispatcher);
    }

    /* access modifiers changed from: protected */
    public void setHardwareAccelerated(boolean z2) {
        this.mHardwareAccelerated = z2;
        this.mPropertyRequiresNewDialog = true;
    }

    /* access modifiers changed from: protected */
    public void setOnRequestCloseListener(OnRequestCloseListener onRequestCloseListener) {
        this.mOnRequestCloseListener = onRequestCloseListener;
    }

    /* access modifiers changed from: protected */
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.mOnShowListener = onShowListener;
    }

    /* access modifiers changed from: protected */
    public void setStatusBarTranslucent(boolean z2) {
        this.mStatusBarTranslucent = z2;
        this.mPropertyRequiresNewDialog = true;
    }

    /* access modifiers changed from: protected */
    public void setTransparent(boolean z2) {
        this.mTransparent = z2;
    }

    /* access modifiers changed from: protected */
    public void showOrUpdate() {
        Context context;
        UiThreadUtil.assertOnUiThread();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            Context context2 = (Context) ContextUtils.findContextOfType(dialog.getContext(), Activity.class);
            FLog.e(TAG, "Updating existing dialog with context: " + context2 + "@" + context2.hashCode());
            if (this.mPropertyRequiresNewDialog) {
                dismiss();
            } else {
                updateProperties();
                return;
            }
        }
        this.mPropertyRequiresNewDialog = false;
        int i2 = R.style.Theme_FullScreenDialog;
        if (this.mAnimationType.equals("fade")) {
            i2 = R.style.Theme_FullScreenDialogAnimatedFade;
        } else if (this.mAnimationType.equals("slide")) {
            i2 = R.style.Theme_FullScreenDialogAnimatedSlide;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            context = getContext();
        } else {
            context = currentActivity;
        }
        Dialog dialog2 = new Dialog(context, i2);
        this.mDialog = dialog2;
        dialog2.getWindow().setFlags(8, 8);
        FLog.e(TAG, "Creating new dialog from context: " + context + "@" + context.hashCode());
        this.mDialog.setContentView(getContentView());
        updateProperties();
        this.mDialog.setOnShowListener(this.mOnShowListener);
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 1) {
                    return false;
                }
                if (i2 == 4 || i2 == 111) {
                    Assertions.assertNotNull(ReactModalHostView.this.mOnRequestCloseListener, "setOnRequestCloseListener must be called by the manager");
                    ReactModalHostView.this.mOnRequestCloseListener.onRequestClose(dialogInterface);
                    return true;
                }
                Activity currentActivity = ((ReactContext) ReactModalHostView.this.getContext()).getCurrentActivity();
                if (currentActivity != null) {
                    return currentActivity.onKeyUp(i2, keyEvent);
                }
                return false;
            }
        });
        this.mDialog.getWindow().setSoftInputMode(16);
        if (this.mHardwareAccelerated) {
            this.mDialog.getWindow().addFlags(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
        }
        if (currentActivity != null && !currentActivity.isFinishing()) {
            this.mDialog.show();
            if (context instanceof Activity) {
                this.mDialog.getWindow().getDecorView().setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility());
            }
            this.mDialog.getWindow().clearFlags(8);
        }
    }

    public void updateState(int i2, int i3) {
        this.mHostView.updateState(i2, i3);
    }
}
