package com.facebook.react.fabric.mounting;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.views.view.ReactMapBufferViewManager;
import com.facebook.react.views.view.ReactViewManagerWrapper;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SurfaceMountingManager {
    private static final boolean SHOW_CHANGED_VIEW_HIERARCHIES = false;
    public static final String TAG = "SurfaceMountingManager";
    private volatile boolean mIsStopped = false;
    /* access modifiers changed from: private */
    public JSResponderHandler mJSResponderHandler;
    /* access modifiers changed from: private */
    public MountingManager.MountItemExecutor mMountItemExecutor;
    /* access modifiers changed from: private */
    public ConcurrentLinkedQueue<MountItem> mOnViewAttachItems = new ConcurrentLinkedQueue<>();
    /* access modifiers changed from: private */
    public volatile boolean mRootViewAttached = false;
    /* access modifiers changed from: private */
    public RootViewManager mRootViewManager;
    private Set<Integer> mScheduledForDeletionViewStateTags;
    private Set<Integer> mSoftDeletedViewStateTags;
    /* access modifiers changed from: private */
    public final int mSurfaceId;
    /* access modifiers changed from: private */
    public Set<Integer> mTagSetForStoppedSurface;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Integer, ViewState> mTagToViewState = new ConcurrentHashMap<>();
    private ThemedReactContext mThemedReactContext;
    private ViewManagerRegistry mViewManagerRegistry;

    public SurfaceMountingManager(int i2, JSResponderHandler jSResponderHandler, ViewManagerRegistry viewManagerRegistry, RootViewManager rootViewManager, MountingManager.MountItemExecutor mountItemExecutor, ThemedReactContext themedReactContext) {
        this.mSurfaceId = i2;
        this.mJSResponderHandler = jSResponderHandler;
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mRootViewManager = rootViewManager;
        this.mMountItemExecutor = mountItemExecutor;
        this.mThemedReactContext = themedReactContext;
        if (ReactFeatureFlags.enableDelayedViewStateDeletion) {
            this.mSoftDeletedViewStateTags = new HashSet();
            this.mScheduledForDeletionViewStateTags = new HashSet();
        }
    }

    private void addRootView(final View view) {
        if (!isStopped()) {
            this.mTagToViewState.put(Integer.valueOf(this.mSurfaceId), new ViewState(this.mSurfaceId, view, new ReactViewManagerWrapper.DefaultViewManager(this.mRootViewManager), true));
            AnonymousClass1 r02 = new Runnable() {
                public void run() {
                    if (!SurfaceMountingManager.this.isStopped()) {
                        if (view.getId() == SurfaceMountingManager.this.mSurfaceId) {
                            String str = SurfaceMountingManager.TAG;
                            ReactSoftExceptionLogger.logSoftException(str, new IllegalViewOperationException("Race condition in addRootView detected. Trying to set an id of [" + SurfaceMountingManager.this.mSurfaceId + "] on the RootView, but that id has already been set. "));
                        } else if (view.getId() != -1) {
                            FLog.e(SurfaceMountingManager.TAG, "Trying to add RootTag to RootView that already has a tag: existing tag: [%d] new tag: [%d]", Integer.valueOf(view.getId()), Integer.valueOf(SurfaceMountingManager.this.mSurfaceId));
                            throw new IllegalViewOperationException("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
                        }
                        view.setId(SurfaceMountingManager.this.mSurfaceId);
                        View view = view;
                        if (view instanceof ReactRoot) {
                            ((ReactRoot) view).setRootViewTag(SurfaceMountingManager.this.mSurfaceId);
                        }
                        boolean unused = SurfaceMountingManager.this.mRootViewAttached = true;
                        SurfaceMountingManager.this.executeViewAttachMountItems();
                    }
                }
            };
            if (UiThreadUtil.isOnUiThread()) {
                r02.run();
            } else {
                UiThreadUtil.runOnUiThread(r02);
            }
        }
    }

    /* access modifiers changed from: private */
    @ThreadConfined("UI")
    public void executeViewAttachMountItems() {
        this.mMountItemExecutor.executeItems(this.mOnViewAttachItems);
    }

    private ViewState getNullableViewState(int i2) {
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null) {
            return null;
        }
        if (ReactFeatureFlags.enableDelayedViewStateDeletion) {
            this.mScheduledForDeletionViewStateTags.remove(Integer.valueOf(i2));
        }
        return concurrentHashMap.get(Integer.valueOf(i2));
    }

    private static ViewGroupManager<ViewGroup> getViewGroupManager(ViewState viewState) {
        ReactViewManagerWrapper reactViewManagerWrapper = viewState.mViewManager;
        if (reactViewManagerWrapper != null) {
            return reactViewManagerWrapper.getViewGroupManager();
        }
        throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
    }

    private ViewState getViewState(int i2) {
        ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i2));
        if (viewState != null) {
            if (ReactFeatureFlags.enableDelayedViewStateDeletion) {
                this.mScheduledForDeletionViewStateTags.remove(Integer.valueOf(i2));
            }
            return viewState;
        }
        throw new RetryableMountingLayerException("Unable to find viewState for tag " + i2);
    }

    private static void logViewHierarchy(ViewGroup viewGroup, boolean z2) {
        ViewGroup viewGroup2;
        int i2;
        int id = viewGroup.getId();
        String str = TAG;
        FLog.e(str, "  <ViewGroup tag=" + id + " class=" + viewGroup.getClass().toString() + ">");
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            String str2 = TAG;
            FLog.e(str2, "     <View idx=" + i3 + " tag=" + viewGroup.getChildAt(i3).getId() + " class=" + viewGroup.getChildAt(i3).getClass().toString() + ">");
        }
        String str3 = TAG;
        FLog.e(str3, "  </ViewGroup tag=" + id + ">");
        if (z2) {
            FLog.e(str3, "Displaying Ancestors:");
            for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof ViewGroup) {
                    viewGroup2 = (ViewGroup) parent;
                } else {
                    viewGroup2 = null;
                }
                if (viewGroup2 == null) {
                    i2 = -1;
                } else {
                    i2 = viewGroup2.getId();
                }
                String str4 = TAG;
                FLog.e(str4, "<ViewParent tag=" + i2 + " class=" + parent.getClass().toString() + ">");
            }
        }
    }

    /* access modifiers changed from: private */
    public void onViewStateDeleted(ViewState viewState) {
        StateWrapper stateWrapper = viewState.mStateWrapper;
        if (stateWrapper != null) {
            stateWrapper.destroyState();
            viewState.mStateWrapper = null;
        }
        EventEmitterWrapper eventEmitterWrapper = viewState.mEventEmitter;
        if (eventEmitterWrapper != null) {
            eventEmitterWrapper.destroy();
            viewState.mEventEmitter = null;
        }
        ReactViewManagerWrapper reactViewManagerWrapper = viewState.mViewManager;
        if (!viewState.mIsRoot && reactViewManagerWrapper != null) {
            reactViewManagerWrapper.onDropViewInstance(viewState.mView);
        }
    }

    public void addViewAt(int i2, int i3, int i4) {
        int i5;
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i2);
            View view = viewState.mView;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                ViewState viewState2 = getViewState(i3);
                View view2 = viewState2.mView;
                if (view2 != null) {
                    ViewParent parent = view2.getParent();
                    if (parent != null) {
                        if (parent instanceof ViewGroup) {
                            i5 = ((ViewGroup) parent).getId();
                        } else {
                            i5 = -1;
                        }
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("addViewAt: cannot insert view [" + i3 + "] into parent [" + i2 + "]: View already has a parent: [" + i5 + "] " + parent.getClass().getSimpleName()));
                    }
                    try {
                        getViewGroupManager(viewState).addView(viewGroup, view2, i4);
                    } catch (IllegalStateException e2) {
                        throw new IllegalStateException("addViewAt: failed to insert view [" + i3 + "] into parent [" + i2 + "] at index " + i4, e2);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for viewState " + viewState2 + " and tag " + i3);
                }
            } else {
                String str = "Unable to add a view into a view that is not a ViewGroup. ParentTag: " + i2 + " - Tag: " + i3 + " - Index: " + i4;
                FLog.e(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    public void attachRootView(View view, ThemedReactContext themedReactContext) {
        this.mThemedReactContext = themedReactContext;
        addRootView(view);
    }

    public void createView(String str, int i2, Object obj, StateWrapper stateWrapper, EventEmitterWrapper eventEmitterWrapper, boolean z2) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i2);
            if (nullableViewState == null || nullableViewState.mView == null) {
                createViewUnsafe(str, i2, obj, stateWrapper, eventEmitterWrapper, z2);
            }
        }
    }

    public void createViewUnsafe(String str, int i2, Object obj, StateWrapper stateWrapper, EventEmitterWrapper eventEmitterWrapper, boolean z2) {
        Object obj2;
        View view;
        ReactViewManagerWrapper reactViewManagerWrapper;
        if (obj instanceof ReadableMap) {
            obj2 = new ReactStylesDiffMap((ReadableMap) obj);
        } else {
            obj2 = obj;
        }
        if (z2) {
            if (obj instanceof ReadableMapBuffer) {
                reactViewManagerWrapper = ReactMapBufferViewManager.INSTANCE;
            } else {
                reactViewManagerWrapper = new ReactViewManagerWrapper.DefaultViewManager(this.mViewManagerRegistry.get(str));
            }
            view = reactViewManagerWrapper.createView(i2, this.mThemedReactContext, obj2, stateWrapper, this.mJSResponderHandler);
        } else {
            reactViewManagerWrapper = null;
            view = null;
        }
        ViewState viewState = new ViewState(i2, view, reactViewManagerWrapper);
        viewState.mCurrentProps = obj2;
        viewState.mStateWrapper = stateWrapper;
        viewState.mEventEmitter = eventEmitterWrapper;
        this.mTagToViewState.put(Integer.valueOf(i2), viewState);
    }

    public void deleteView(int i2) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i2);
            if (nullableViewState == null) {
                String str = MountingManager.TAG;
                ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException("Unable to find viewState for tag: " + i2 + " for deleteView"));
            } else if (ReactFeatureFlags.enableDelayedViewStateDeletion) {
                this.mSoftDeletedViewStateTags.add(Integer.valueOf(i2));
            } else {
                this.mTagToViewState.remove(Integer.valueOf(i2));
                onViewStateDeleted(nullableViewState);
            }
        }
    }

    public void didUpdateViews() {
        if (ReactFeatureFlags.enableDelayedViewStateDeletion) {
            for (Integer remove : this.mScheduledForDeletionViewStateTags) {
                ViewState remove2 = this.mTagToViewState.remove(remove);
                if (remove2 != null) {
                    onViewStateDeleted(remove2);
                }
            }
            this.mScheduledForDeletionViewStateTags = this.mSoftDeletedViewStateTags;
            this.mSoftDeletedViewStateTags = new HashSet();
        }
    }

    public void executeOnViewAttach(MountItem mountItem) {
        this.mOnViewAttachItems.add(mountItem);
    }

    public ThemedReactContext getContext() {
        return this.mThemedReactContext;
    }

    @ThreadConfined("ANY")
    public EventEmitterWrapper getEventEmitter(int i2) {
        ViewState nullableViewState = getNullableViewState(i2);
        if (nullableViewState == null) {
            return null;
        }
        return nullableViewState.mEventEmitter;
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    public View getView(int i2) {
        View view;
        ViewState nullableViewState = getNullableViewState(i2);
        if (nullableViewState == null) {
            view = null;
        } else {
            view = nullableViewState.mView;
        }
        if (view != null) {
            return view;
        }
        throw new IllegalViewOperationException("Trying to resolve view with tag " + i2 + " which doesn't exist");
    }

    public boolean getViewExists(int i2) {
        Set<Integer> set = this.mTagSetForStoppedSurface;
        if (set != null && set.contains(Integer.valueOf(i2))) {
            return true;
        }
        ConcurrentHashMap<Integer, ViewState> concurrentHashMap = this.mTagToViewState;
        if (concurrentHashMap == null) {
            return false;
        }
        return concurrentHashMap.containsKey(Integer.valueOf(i2));
    }

    public boolean isRootViewAttached() {
        return this.mRootViewAttached;
    }

    public boolean isStopped() {
        return this.mIsStopped;
    }

    public void preallocateView(String str, int i2, Object obj, StateWrapper stateWrapper, EventEmitterWrapper eventEmitterWrapper, boolean z2) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped() && getNullableViewState(i2) == null) {
            createViewUnsafe(str, i2, obj, stateWrapper, eventEmitterWrapper, z2);
        }
    }

    public void printSurfaceState() {
        String str;
        View view;
        FLog.e(TAG, "Views created for surface {%d}:", Integer.valueOf(getSurfaceId()));
        for (ViewState next : this.mTagToViewState.values()) {
            ReactViewManagerWrapper reactViewManagerWrapper = next.mViewManager;
            Integer num = null;
            if (reactViewManagerWrapper != null) {
                str = reactViewManagerWrapper.getName();
            } else {
                str = null;
            }
            View view2 = next.mView;
            if (view2 != null) {
                view = (View) view2.getParent();
            } else {
                view = null;
            }
            if (view != null) {
                num = Integer.valueOf(view.getId());
            }
            FLog.e(TAG, "<%s id=%d parentTag=%s isRoot=%b />", str, Integer.valueOf(next.mReactTag), num, Boolean.valueOf(next.mIsRoot));
        }
    }

    @Deprecated
    public void receiveCommand(int i2, int i3, ReadableArray readableArray) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i2);
            if (nullableViewState != null) {
                ReactViewManagerWrapper reactViewManagerWrapper = nullableViewState.mViewManager;
                if (reactViewManagerWrapper != null) {
                    View view = nullableViewState.mView;
                    if (view != null) {
                        reactViewManagerWrapper.receiveCommand(view, i3, readableArray);
                        return;
                    }
                    throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i2);
                }
                throw new RetryableMountingLayerException("Unable to find viewManager for tag " + i2);
            }
            throw new RetryableMountingLayerException("Unable to find viewState for tag: [" + i2 + "] for commandId: " + i3);
        }
    }

    public void removeViewAt(int i2, int i3, int i4) {
        int i5;
        if (!isStopped()) {
            UiThreadUtil.assertOnUiThread();
            ViewState nullableViewState = getNullableViewState(i3);
            if (nullableViewState == null) {
                ReactSoftExceptionLogger.logSoftException(MountingManager.TAG, new IllegalStateException("Unable to find viewState for tag: [" + i3 + "] for removeViewAt"));
                return;
            }
            View view = nullableViewState.mView;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup != null) {
                    ViewGroupManager<ViewGroup> viewGroupManager = getViewGroupManager(nullableViewState);
                    View childAt = viewGroupManager.getChildAt(viewGroup, i4);
                    if (childAt != null) {
                        i5 = childAt.getId();
                    } else {
                        i5 = -1;
                    }
                    if (i5 != i2) {
                        int childCount = viewGroup.getChildCount();
                        int i6 = 0;
                        while (true) {
                            if (i6 >= childCount) {
                                i6 = -1;
                                break;
                            } else if (viewGroup.getChildAt(i6).getId() == i2) {
                                break;
                            } else {
                                i6++;
                            }
                        }
                        if (i6 == -1) {
                            FLog.e(TAG, "removeViewAt: [" + i2 + "] -> [" + i3 + "] @" + i4 + ": view already removed from parent! Children in parent: " + childCount);
                            return;
                        }
                        logViewHierarchy(viewGroup, true);
                        ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Tried to remove view [" + i2 + "] of parent [" + i3 + "] at index " + i4 + ", but got view tag " + i5 + " - actual index of view: " + i6));
                        i4 = i6;
                    }
                    try {
                        viewGroupManager.removeViewAt(viewGroup, i4);
                    } catch (RuntimeException e2) {
                        int childCount2 = viewGroupManager.getChildCount(viewGroup);
                        logViewHierarchy(viewGroup, true);
                        throw new IllegalStateException("Cannot remove child at index " + i4 + " from parent ViewGroup [" + viewGroup.getId() + "], only " + childCount2 + " children in parent. Warning: childCount may be incorrect!", e2);
                    }
                } else {
                    throw new IllegalStateException("Unable to find view for tag [" + i3 + "]");
                }
            } else {
                String str = "Unable to remove a view from a view that is not a ViewGroup. ParentTag: " + i3 + " - Tag: " + i2 + " - Index: " + i4;
                FLog.e(TAG, str);
                throw new IllegalStateException(str);
            }
        }
    }

    public void sendAccessibilityEvent(int i2, int i3) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i2);
            if (viewState.mViewManager != null) {
                View view = viewState.mView;
                if (view != null) {
                    view.sendAccessibilityEvent(i3);
                    return;
                }
                throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i2);
            }
            throw new RetryableMountingLayerException("Unable to find viewState manager for tag " + i2);
        }
    }

    public synchronized void setJSResponder(int i2, int i3, boolean z2) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            if (!z2) {
                this.mJSResponderHandler.setJSResponder(i3, (ViewParent) null);
                return;
            }
            ViewState viewState = getViewState(i2);
            View view = viewState.mView;
            if (i3 != i2 && (view instanceof ViewParent)) {
                this.mJSResponderHandler.setJSResponder(i3, (ViewParent) view);
            } else if (view == null) {
                SoftAssertions.assertUnreachable("Cannot find view for tag [" + i2 + "].");
            } else {
                if (viewState.mIsRoot) {
                    SoftAssertions.assertUnreachable("Cannot block native responder on [" + i2 + "] that is a root view");
                }
                this.mJSResponderHandler.setJSResponder(i3, view.getParent());
            }
        }
    }

    public void stopSurface() {
        EventEmitterWrapper eventEmitterWrapper;
        if (!isStopped()) {
            this.mIsStopped = true;
            for (ViewState next : this.mTagToViewState.values()) {
                StateWrapper stateWrapper = next.mStateWrapper;
                if (stateWrapper != null) {
                    stateWrapper.destroyState();
                    next.mStateWrapper = null;
                }
                if (ReactFeatureFlags.enableAggressiveEventEmitterCleanup && (eventEmitterWrapper = next.mEventEmitter) != null) {
                    eventEmitterWrapper.destroy();
                    next.mEventEmitter = null;
                }
            }
            AnonymousClass2 r02 = new Runnable() {
                public void run() {
                    for (ViewState access$500 : SurfaceMountingManager.this.mTagToViewState.values()) {
                        SurfaceMountingManager.this.onViewStateDeleted(access$500);
                    }
                    SurfaceMountingManager surfaceMountingManager = SurfaceMountingManager.this;
                    Set unused = surfaceMountingManager.mTagSetForStoppedSurface = surfaceMountingManager.mTagToViewState.keySet();
                    ConcurrentHashMap unused2 = SurfaceMountingManager.this.mTagToViewState = null;
                    JSResponderHandler unused3 = SurfaceMountingManager.this.mJSResponderHandler = null;
                    RootViewManager unused4 = SurfaceMountingManager.this.mRootViewManager = null;
                    MountingManager.MountItemExecutor unused5 = SurfaceMountingManager.this.mMountItemExecutor = null;
                    SurfaceMountingManager.this.mOnViewAttachItems.clear();
                }
            };
            if (UiThreadUtil.isOnUiThread()) {
                r02.run();
            } else {
                UiThreadUtil.runOnUiThread(r02);
            }
        }
    }

    public void updateEventEmitter(int i2, EventEmitterWrapper eventEmitterWrapper) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i2));
            if (viewState == null) {
                viewState = new ViewState(i2, (View) null, (ReactViewManagerWrapper) null);
                this.mTagToViewState.put(Integer.valueOf(i2), viewState);
            }
            EventEmitterWrapper eventEmitterWrapper2 = viewState.mEventEmitter;
            viewState.mEventEmitter = eventEmitterWrapper;
            if (eventEmitterWrapper2 != eventEmitterWrapper && eventEmitterWrapper2 != null) {
                eventEmitterWrapper2.destroy();
            }
        }
    }

    public void updateLayout(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        if (!isStopped()) {
            ViewState viewState = getViewState(i2);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view != null) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
                    ViewParent parent = view.getParent();
                    if (parent instanceof RootView) {
                        parent.requestLayout();
                    }
                    view.layout(i3, i4, i5 + i3, i6 + i4);
                    if (i7 == 0) {
                        i8 = 4;
                    } else {
                        i8 = 0;
                    }
                    if (view.getVisibility() != i8) {
                        view.setVisibility(i8);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Unable to find View for tag: " + i2);
            }
        }
    }

    public void updateOverflowInset(int i2, int i3, int i4, int i5, int i6) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i2);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view == null) {
                    throw new IllegalStateException("Unable to find View for tag: " + i2);
                } else if (view instanceof ReactOverflowViewWithInset) {
                    ((ReactOverflowViewWithInset) view).setOverflowInset(i3, i4, i5, i6);
                }
            }
        }
    }

    public void updatePadding(int i2, int i3, int i4, int i5, int i6) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i2);
            if (!viewState.mIsRoot) {
                View view = viewState.mView;
                if (view != null) {
                    ReactViewManagerWrapper reactViewManagerWrapper = viewState.mViewManager;
                    if (reactViewManagerWrapper != null) {
                        reactViewManagerWrapper.setPadding(view, i3, i4, i5, i6);
                        return;
                    }
                    throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
                }
                throw new IllegalStateException("Unable to find View for tag: " + i2);
            }
        }
    }

    public void updateProps(int i2, Object obj) {
        if (!isStopped()) {
            ViewState viewState = getViewState(i2);
            if (obj instanceof ReadableMap) {
                obj = new ReactStylesDiffMap((ReadableMap) obj);
            }
            viewState.mCurrentProps = obj;
            View view = viewState.mView;
            if (view != null) {
                ((ReactViewManagerWrapper) Assertions.assertNotNull(viewState.mViewManager)).updateProperties(view, viewState.mCurrentProps);
                return;
            }
            throw new IllegalStateException("Unable to find view for tag [" + i2 + "]");
        }
    }

    public void updateState(int i2, StateWrapper stateWrapper) {
        UiThreadUtil.assertOnUiThread();
        if (!isStopped()) {
            ViewState viewState = getViewState(i2);
            StateWrapper stateWrapper2 = viewState.mStateWrapper;
            viewState.mStateWrapper = stateWrapper;
            ReactViewManagerWrapper reactViewManagerWrapper = viewState.mViewManager;
            if (reactViewManagerWrapper != null) {
                Object updateState = reactViewManagerWrapper.updateState(viewState.mView, viewState.mCurrentProps, stateWrapper);
                if (updateState != null) {
                    reactViewManagerWrapper.updateExtraData(viewState.mView, updateState);
                }
                if (stateWrapper2 != null) {
                    stateWrapper2.destroyState();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Unable to find ViewManager for tag: " + i2);
        }
    }

    private static class ViewState {
        public ReadableMap mCurrentLocalData;
        public Object mCurrentProps;
        public EventEmitterWrapper mEventEmitter;
        final boolean mIsRoot;
        final int mReactTag;
        public StateWrapper mStateWrapper;
        final View mView;
        final ReactViewManagerWrapper mViewManager;

        public String toString() {
            boolean z2;
            if (this.mViewManager == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            return "ViewState [" + this.mReactTag + "] - isRoot: " + this.mIsRoot + " - props: " + this.mCurrentProps + " - localData: " + this.mCurrentLocalData + " - viewManager: " + this.mViewManager + " - isLayoutOnly: " + z2;
        }

        private ViewState(int i2, View view, ReactViewManagerWrapper reactViewManagerWrapper) {
            this(i2, view, reactViewManagerWrapper, false);
        }

        private ViewState(int i2, View view, ReactViewManagerWrapper reactViewManagerWrapper, boolean z2) {
            this.mCurrentProps = null;
            this.mCurrentLocalData = null;
            this.mStateWrapper = null;
            this.mEventEmitter = null;
            this.mReactTag = i2;
            this.mView = view;
            this.mIsRoot = z2;
            this.mViewManager = reactViewManagerWrapper;
        }
    }

    public void receiveCommand(int i2, String str, ReadableArray readableArray) {
        if (!isStopped()) {
            ViewState nullableViewState = getNullableViewState(i2);
            if (nullableViewState != null) {
                ReactViewManagerWrapper reactViewManagerWrapper = nullableViewState.mViewManager;
                if (reactViewManagerWrapper != null) {
                    View view = nullableViewState.mView;
                    if (view != null) {
                        reactViewManagerWrapper.receiveCommand(view, str, readableArray);
                        return;
                    }
                    throw new RetryableMountingLayerException("Unable to find viewState view for tag " + i2);
                }
                throw new RetryableMountingLayerException("Unable to find viewState manager for tag " + i2);
            }
            throw new RetryableMountingLayerException("Unable to find viewState for tag: " + i2 + " for commandId: " + str);
        }
    }
}
