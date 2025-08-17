package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.yoga.YogaDirection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UIImplementation {
    protected final EventDispatcher mEventDispatcher;
    private long mLastCalculateLayoutTime;
    protected LayoutUpdateListener mLayoutUpdateListener;
    private final int[] mMeasureBuffer;
    private final NativeViewHierarchyOptimizer mNativeViewHierarchyOptimizer;
    private final UIViewOperationQueue mOperationsQueue;
    protected final ReactApplicationContext mReactContext;
    protected final ShadowNodeRegistry mShadowNodeRegistry;
    private final ViewManagerRegistry mViewManagers;
    private volatile boolean mViewOperationsEnabled;
    protected Object uiImplementationThreadLock;

    public interface LayoutUpdateListener {
        void onLayoutUpdated(ReactShadowNode reactShadowNode);
    }

    public UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerResolver viewManagerResolver, EventDispatcher eventDispatcher, int i2) {
        this(reactApplicationContext, new ViewManagerRegistry(viewManagerResolver), eventDispatcher, i2);
    }

    private void assertNodeDoesNotNeedCustomLayoutForChildren(ReactShadowNode reactShadowNode) {
        ViewManager viewManager = (ViewManager) Assertions.assertNotNull(this.mViewManagers.get(reactShadowNode.getViewClass()));
        if (viewManager instanceof IViewManagerWithChildren) {
            IViewManagerWithChildren iViewManagerWithChildren = (IViewManagerWithChildren) viewManager;
            if (iViewManagerWithChildren != null && iViewManagerWithChildren.needsCustomLayoutForChildren()) {
                throw new IllegalViewOperationException("Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children (" + reactShadowNode.getViewClass() + "). Use measure instead.");
            }
            return;
        }
        throw new IllegalViewOperationException("Trying to use view " + reactShadowNode.getViewClass() + " as a parent, but its Manager doesn't extends ViewGroupManager");
    }

    private void assertViewExists(int i2, String str) {
        if (this.mShadowNodeRegistry.getNode(i2) == null) {
            throw new IllegalViewOperationException("Unable to execute operation " + str + " on view with tag: " + i2 + ", since the view does not exists");
        }
    }

    private void dispatchViewUpdatesIfNeeded() {
        if (this.mOperationsQueue.isEmpty()) {
            dispatchViewUpdates(-1);
        }
    }

    private void measureLayoutRelativeToVerifiedAncestor(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int[] iArr) {
        int i2;
        int i3;
        if (reactShadowNode == reactShadowNode2 || reactShadowNode.isVirtual()) {
            i3 = 0;
            i2 = 0;
        } else {
            i3 = Math.round(reactShadowNode.getLayoutX());
            i2 = Math.round(reactShadowNode.getLayoutY());
            for (ReactShadowNode parent = reactShadowNode.getParent(); parent != reactShadowNode2; parent = parent.getParent()) {
                Assertions.assertNotNull(parent);
                assertNodeDoesNotNeedCustomLayoutForChildren(parent);
                i3 += Math.round(parent.getLayoutX());
                i2 += Math.round(parent.getLayoutY());
            }
            assertNodeDoesNotNeedCustomLayoutForChildren(reactShadowNode2);
        }
        iArr[0] = i3;
        iArr[1] = i2;
        iArr[2] = reactShadowNode.getScreenWidth();
        iArr[3] = reactShadowNode.getScreenHeight();
    }

    private void notifyOnBeforeLayoutRecursive(ReactShadowNode reactShadowNode) {
        if (reactShadowNode.hasUpdates()) {
            for (int i2 = 0; i2 < reactShadowNode.getChildCount(); i2++) {
                notifyOnBeforeLayoutRecursive(reactShadowNode.getChildAt(i2));
            }
            reactShadowNode.onBeforeLayout(this.mNativeViewHierarchyOptimizer);
        }
    }

    private void removeShadowNodeRecursive(ReactShadowNode reactShadowNode) {
        NativeViewHierarchyOptimizer.handleRemoveNode(reactShadowNode);
        this.mShadowNodeRegistry.removeNode(reactShadowNode.getReactTag());
        for (int childCount = reactShadowNode.getChildCount() - 1; childCount >= 0; childCount--) {
            removeShadowNodeRecursive(reactShadowNode.getChildAt(childCount));
        }
        reactShadowNode.removeAndDisposeAllChildren();
    }

    public void addUIBlock(UIBlock uIBlock) {
        this.mOperationsQueue.enqueueUIBlock(uIBlock);
    }

    /* access modifiers changed from: protected */
    public void applyUpdatesRecursive(ReactShadowNode reactShadowNode, float f2, float f3) {
        if (reactShadowNode.hasUpdates()) {
            Iterable<? extends ReactShadowNode> calculateLayoutOnChildren = reactShadowNode.calculateLayoutOnChildren();
            if (calculateLayoutOnChildren != null) {
                for (ReactShadowNode applyUpdatesRecursive : calculateLayoutOnChildren) {
                    applyUpdatesRecursive(applyUpdatesRecursive, reactShadowNode.getLayoutX() + f2, reactShadowNode.getLayoutY() + f3);
                }
            }
            int reactTag = reactShadowNode.getReactTag();
            if (!this.mShadowNodeRegistry.isRootNode(reactTag) && reactShadowNode.dispatchUpdates(f2, f3, this.mOperationsQueue, this.mNativeViewHierarchyOptimizer) && reactShadowNode.shouldNotifyOnLayout()) {
                this.mEventDispatcher.dispatchEvent(OnLayoutEvent.obtain(-1, reactTag, reactShadowNode.getScreenX(), reactShadowNode.getScreenY(), reactShadowNode.getScreenWidth(), reactShadowNode.getScreenHeight()));
            }
            reactShadowNode.markUpdateSeen();
            this.mNativeViewHierarchyOptimizer.onViewUpdatesCompleted(reactShadowNode);
        }
    }

    /* access modifiers changed from: protected */
    public void calculateRootLayout(ReactShadowNode reactShadowNode) {
        float f2;
        SystraceMessage.beginSection(0, "cssRoot.calculateLayout").arg("rootTag", reactShadowNode.getReactTag()).flush();
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            int intValue = reactShadowNode.getWidthMeasureSpec().intValue();
            int intValue2 = reactShadowNode.getHeightMeasureSpec().intValue();
            float f3 = Float.NaN;
            if (View.MeasureSpec.getMode(intValue) == 0) {
                f2 = Float.NaN;
            } else {
                f2 = (float) View.MeasureSpec.getSize(intValue);
            }
            if (View.MeasureSpec.getMode(intValue2) != 0) {
                f3 = (float) View.MeasureSpec.getSize(intValue2);
            }
            reactShadowNode.calculateLayout(f2, f3);
        } finally {
            Systrace.endSection(0);
            this.mLastCalculateLayoutTime = SystemClock.uptimeMillis() - uptimeMillis;
        }
    }

    public void clearJSResponder() {
        this.mOperationsQueue.enqueueClearJSResponder();
    }

    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback) {
        this.mOperationsQueue.enqueueConfigureLayoutAnimation(readableMap, callback);
    }

    /* access modifiers changed from: protected */
    public ReactShadowNode createRootShadowNode() {
        ReactShadowNodeImpl reactShadowNodeImpl = new ReactShadowNodeImpl();
        if (I18nUtil.getInstance().isRTL(this.mReactContext)) {
            reactShadowNodeImpl.setLayoutDirection(YogaDirection.RTL);
        }
        reactShadowNodeImpl.setViewClassName("Root");
        return reactShadowNodeImpl;
    }

    /* access modifiers changed from: protected */
    public ReactShadowNode createShadowNode(String str) {
        return this.mViewManagers.get(str).createShadowNodeInstance(this.mReactContext);
    }

    public void createView(int i2, String str, int i3, ReadableMap readableMap) {
        ReactStylesDiffMap reactStylesDiffMap;
        if (this.mViewOperationsEnabled) {
            synchronized (this.uiImplementationThreadLock) {
                ReactShadowNode createShadowNode = createShadowNode(str);
                ReactShadowNode node = this.mShadowNodeRegistry.getNode(i3);
                Assertions.assertNotNull(node, "Root node with tag " + i3 + " doesn't exist");
                createShadowNode.setReactTag(i2);
                createShadowNode.setViewClassName(str);
                createShadowNode.setRootTag(node.getReactTag());
                createShadowNode.setThemedContext(node.getThemedContext());
                this.mShadowNodeRegistry.addNode(createShadowNode);
                if (readableMap != null) {
                    reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
                    createShadowNode.updateProperties(reactStylesDiffMap);
                } else {
                    reactStylesDiffMap = null;
                }
                handleCreateView(createShadowNode, i3, reactStylesDiffMap);
            }
        }
    }

    public void dismissPopupMenu() {
        this.mOperationsQueue.enqueueDismissPopupMenu();
    }

    @Deprecated
    public void dispatchViewManagerCommand(int i2, int i3, ReadableArray readableArray) {
        assertViewExists(i2, "dispatchViewManagerCommand: " + i3);
        this.mOperationsQueue.enqueueDispatchCommand(i2, i3, readableArray);
    }

    public void dispatchViewUpdates(int i2) {
        SystraceMessage.beginSection(0, "UIImplementation.dispatchViewUpdates").arg("batchId", i2).flush();
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            updateViewHierarchy();
            this.mNativeViewHierarchyOptimizer.onBatchComplete();
            this.mOperationsQueue.dispatchViewUpdates(i2, uptimeMillis, this.mLastCalculateLayoutTime);
        } finally {
            Systrace.endSection(0);
        }
    }

    public void findSubviewIn(int i2, float f2, float f3, Callback callback) {
        this.mOperationsQueue.enqueueFindTargetForTouch(i2, f2, f3, callback);
    }

    public Map<String, Long> getProfiledBatchPerfCounters() {
        return this.mOperationsQueue.getProfiledBatchPerfCounters();
    }

    /* access modifiers changed from: package-private */
    public UIViewOperationQueue getUIViewOperationQueue() {
        return this.mOperationsQueue;
    }

    /* access modifiers changed from: protected */
    public void handleCreateView(ReactShadowNode reactShadowNode, int i2, ReactStylesDiffMap reactStylesDiffMap) {
        if (!reactShadowNode.isVirtual()) {
            this.mNativeViewHierarchyOptimizer.handleCreateView(reactShadowNode, reactShadowNode.getThemedContext(), reactStylesDiffMap);
        }
    }

    /* access modifiers changed from: protected */
    public void handleUpdateView(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        if (!reactShadowNode.isVirtual()) {
            this.mNativeViewHierarchyOptimizer.handleUpdateView(reactShadowNode, str, reactStylesDiffMap);
        }
    }

    public void manageChildren(int i2, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
        int i3;
        int i4;
        int i5;
        int i6 = i2;
        ReadableArray readableArray6 = readableArray;
        ReadableArray readableArray7 = readableArray2;
        ReadableArray readableArray8 = readableArray3;
        ReadableArray readableArray9 = readableArray4;
        ReadableArray readableArray10 = readableArray5;
        if (this.mViewOperationsEnabled) {
            synchronized (this.uiImplementationThreadLock) {
                try {
                    ReactShadowNode node = this.mShadowNodeRegistry.getNode(i6);
                    if (readableArray6 == null) {
                        i3 = 0;
                    } else {
                        i3 = readableArray.size();
                    }
                    if (readableArray8 == null) {
                        i4 = 0;
                    } else {
                        i4 = readableArray3.size();
                    }
                    if (readableArray10 == null) {
                        i5 = 0;
                    } else {
                        i5 = readableArray5.size();
                    }
                    if (i3 != 0) {
                        if (readableArray7 == null || i3 != readableArray2.size()) {
                            throw new IllegalViewOperationException("Size of moveFrom != size of moveTo!");
                        }
                    }
                    if (i4 != 0) {
                        if (readableArray9 == null || i4 != readableArray4.size()) {
                            throw new IllegalViewOperationException("Size of addChildTags != size of addAtIndices!");
                        }
                    }
                    int i7 = i3 + i4;
                    ViewAtIndex[] viewAtIndexArr = new ViewAtIndex[i7];
                    int i8 = i3 + i5;
                    int[] iArr = new int[i8];
                    int[] iArr2 = new int[i8];
                    int i9 = i7;
                    int[] iArr3 = new int[i5];
                    if (i3 > 0) {
                        Assertions.assertNotNull(readableArray);
                        Assertions.assertNotNull(readableArray2);
                        int i10 = 0;
                        while (i10 < i3) {
                            int i11 = i8;
                            int i12 = readableArray6.getInt(i10);
                            int reactTag = node.getChildAt(i12).getReactTag();
                            viewAtIndexArr[i10] = new ViewAtIndex(reactTag, readableArray7.getInt(i10));
                            iArr[i10] = i12;
                            iArr2[i10] = reactTag;
                            i10++;
                            readableArray6 = readableArray;
                            i8 = i11;
                            iArr3 = iArr3;
                            node = node;
                        }
                    }
                    ReactShadowNode reactShadowNode = node;
                    int[] iArr4 = iArr3;
                    int i13 = i8;
                    if (i4 > 0) {
                        Assertions.assertNotNull(readableArray3);
                        Assertions.assertNotNull(readableArray4);
                        for (int i14 = 0; i14 < i4; i14++) {
                            viewAtIndexArr[i3 + i14] = new ViewAtIndex(readableArray8.getInt(i14), readableArray9.getInt(i14));
                        }
                    }
                    if (i5 > 0) {
                        Assertions.assertNotNull(readableArray5);
                        int i15 = 0;
                        while (i15 < i5) {
                            int i16 = readableArray10.getInt(i15);
                            ReactShadowNode reactShadowNode2 = reactShadowNode;
                            int reactTag2 = reactShadowNode2.getChildAt(i16).getReactTag();
                            int i17 = i3 + i15;
                            iArr[i17] = i16;
                            iArr2[i17] = reactTag2;
                            iArr4[i15] = reactTag2;
                            i15++;
                            reactShadowNode = reactShadowNode2;
                        }
                    }
                    ReactShadowNode reactShadowNode3 = reactShadowNode;
                    Arrays.sort(viewAtIndexArr, ViewAtIndex.COMPARATOR);
                    Arrays.sort(iArr);
                    int i18 = i13 - 1;
                    int i19 = -1;
                    while (i18 >= 0) {
                        int i20 = iArr[i18];
                        if (i20 != i19) {
                            reactShadowNode3.removeChildAt(i20);
                            i19 = iArr[i18];
                            i18--;
                        } else {
                            throw new IllegalViewOperationException("Repeated indices in Removal list for view tag: " + i2);
                        }
                    }
                    int i21 = 0;
                    while (true) {
                        int i22 = i9;
                        if (i21 < i22) {
                            ViewAtIndex viewAtIndex = viewAtIndexArr[i21];
                            int[] iArr5 = iArr2;
                            ReactShadowNode node2 = this.mShadowNodeRegistry.getNode(viewAtIndex.mTag);
                            if (node2 != null) {
                                reactShadowNode3.addChildAt(node2, viewAtIndex.mIndex);
                                i21++;
                                iArr2 = iArr5;
                                i9 = i22;
                            } else {
                                throw new IllegalViewOperationException("Trying to add unknown view tag: " + viewAtIndex.mTag);
                            }
                        } else {
                            int[] iArr6 = iArr2;
                            this.mNativeViewHierarchyOptimizer.handleManageChildren(reactShadowNode3, iArr, iArr6, viewAtIndexArr, iArr4);
                            for (int i23 = 0; i23 < i5; i23++) {
                                removeShadowNode(this.mShadowNodeRegistry.getNode(iArr4[i23]));
                            }
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            }
        }
    }

    public void measure(int i2, Callback callback) {
        if (this.mViewOperationsEnabled) {
            this.mOperationsQueue.enqueueMeasure(i2, callback);
        }
    }

    public void measureInWindow(int i2, Callback callback) {
        if (this.mViewOperationsEnabled) {
            this.mOperationsQueue.enqueueMeasureInWindow(i2, callback);
        }
    }

    public void measureLayout(int i2, int i3, Callback callback, Callback callback2) {
        if (this.mViewOperationsEnabled) {
            try {
                measureLayout(i2, i3, this.mMeasureBuffer);
                callback2.invoke(Float.valueOf(PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[0])), Float.valueOf(PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[1])), Float.valueOf(PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[2])), Float.valueOf(PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[3])));
            } catch (IllegalViewOperationException e2) {
                callback.invoke(e2.getMessage());
            }
        }
    }

    public void measureLayoutRelativeToParent(int i2, Callback callback, Callback callback2) {
        if (this.mViewOperationsEnabled) {
            try {
                measureLayoutRelativeToParent(i2, this.mMeasureBuffer);
                callback2.invoke(Float.valueOf(PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[0])), Float.valueOf(PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[1])), Float.valueOf(PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[2])), Float.valueOf(PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[3])));
            } catch (IllegalViewOperationException e2) {
                callback.invoke(e2.getMessage());
            }
        }
    }

    public void onCatalystInstanceDestroyed() {
        this.mViewOperationsEnabled = false;
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
        this.mOperationsQueue.pauseFrameCallback();
    }

    public void onHostResume() {
        this.mOperationsQueue.resumeFrameCallback();
    }

    public void prependUIBlock(UIBlock uIBlock) {
        this.mOperationsQueue.prependUIBlock(uIBlock);
    }

    public void profileNextBatch() {
        this.mOperationsQueue.profileNextBatch();
    }

    public <T extends View> void registerRootView(T t2, int i2, ThemedReactContext themedReactContext) {
        synchronized (this.uiImplementationThreadLock) {
            final ReactShadowNode createRootShadowNode = createRootShadowNode();
            createRootShadowNode.setReactTag(i2);
            createRootShadowNode.setThemedContext(themedReactContext);
            themedReactContext.runOnNativeModulesQueueThread(new Runnable() {
                public void run() {
                    UIImplementation.this.mShadowNodeRegistry.addRootNode(createRootShadowNode);
                }
            });
            this.mOperationsQueue.addRootView(i2, t2);
        }
    }

    public void removeLayoutUpdateListener() {
        this.mLayoutUpdateListener = null;
    }

    public void removeRootShadowNode(int i2) {
        synchronized (this.uiImplementationThreadLock) {
            this.mShadowNodeRegistry.removeRootNode(i2);
        }
    }

    public void removeRootView(int i2) {
        removeRootShadowNode(i2);
        this.mOperationsQueue.enqueueRemoveRootView(i2);
    }

    /* access modifiers changed from: protected */
    public final void removeShadowNode(ReactShadowNode reactShadowNode) {
        removeShadowNodeRecursive(reactShadowNode);
        reactShadowNode.dispose();
    }

    public void removeSubviewsFromContainerWithID(int i2) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
        if (node != null) {
            WritableArray createArray = Arguments.createArray();
            for (int i3 = 0; i3 < node.getChildCount(); i3++) {
                createArray.pushInt(i3);
            }
            manageChildren(i2, (ReadableArray) null, (ReadableArray) null, (ReadableArray) null, (ReadableArray) null, createArray);
            return;
        }
        throw new IllegalViewOperationException("Trying to remove subviews of an unknown view tag: " + i2);
    }

    public void replaceExistingNonRootView(int i2, int i3) {
        if (this.mShadowNodeRegistry.isRootNode(i2) || this.mShadowNodeRegistry.isRootNode(i3)) {
            throw new IllegalViewOperationException("Trying to add or replace a root tag!");
        }
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
        if (node != null) {
            ReactShadowNode parent = node.getParent();
            if (parent != null) {
                int indexOf = parent.indexOf(node);
                if (indexOf >= 0) {
                    WritableArray createArray = Arguments.createArray();
                    createArray.pushInt(i3);
                    WritableArray createArray2 = Arguments.createArray();
                    createArray2.pushInt(indexOf);
                    WritableArray createArray3 = Arguments.createArray();
                    createArray3.pushInt(indexOf);
                    manageChildren(parent.getReactTag(), (ReadableArray) null, (ReadableArray) null, createArray, createArray2, createArray3);
                    return;
                }
                throw new IllegalStateException("Didn't find child tag in parent");
            }
            throw new IllegalViewOperationException("Node is not attached to a parent: " + i2);
        }
        throw new IllegalViewOperationException("Trying to replace unknown view tag: " + i2);
    }

    public int resolveRootTagFromReactTag(int i2) {
        if (this.mShadowNodeRegistry.isRootNode(i2)) {
            return i2;
        }
        ReactShadowNode resolveShadowNode = resolveShadowNode(i2);
        if (resolveShadowNode != null) {
            return resolveShadowNode.getRootTag();
        }
        FLog.w(ReactConstants.TAG, "Warning : attempted to resolve a non-existent react shadow node. reactTag=" + i2);
        return 0;
    }

    public final ReactShadowNode resolveShadowNode(int i2) {
        return this.mShadowNodeRegistry.getNode(i2);
    }

    /* access modifiers changed from: protected */
    public final ViewManager resolveViewManager(String str) {
        return this.mViewManagers.getViewManagerIfExists(str);
    }

    public void sendAccessibilityEvent(int i2, int i3) {
        this.mOperationsQueue.enqueueSendAccessibilityEvent(i2, i3);
    }

    public void setChildren(int i2, ReadableArray readableArray) {
        if (this.mViewOperationsEnabled) {
            synchronized (this.uiImplementationThreadLock) {
                ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
                int i3 = 0;
                while (i3 < readableArray.size()) {
                    ReactShadowNode node2 = this.mShadowNodeRegistry.getNode(readableArray.getInt(i3));
                    if (node2 != null) {
                        node.addChildAt(node2, i3);
                        i3++;
                    } else {
                        throw new IllegalViewOperationException("Trying to add unknown view tag: " + readableArray.getInt(i3));
                    }
                }
                this.mNativeViewHierarchyOptimizer.handleSetChildren(node, readableArray);
            }
        }
    }

    public void setJSResponder(int i2, boolean z2) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
        if (node != null) {
            while (node.getNativeKind() == NativeKind.NONE) {
                node = node.getParent();
            }
            this.mOperationsQueue.enqueueSetJSResponder(node.getReactTag(), i2, z2);
        }
    }

    public void setLayoutAnimationEnabledExperimental(boolean z2) {
        this.mOperationsQueue.enqueueSetLayoutAnimationEnabled(z2);
    }

    public void setLayoutUpdateListener(LayoutUpdateListener layoutUpdateListener) {
        this.mLayoutUpdateListener = layoutUpdateListener;
    }

    public void setViewHierarchyUpdateDebugListener(NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.mOperationsQueue.setViewHierarchyUpdateDebugListener(notThreadSafeViewHierarchyUpdateDebugListener);
    }

    public void setViewLocalData(int i2, Object obj) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
        if (node == null) {
            FLog.w(ReactConstants.TAG, "Attempt to set local data for view with unknown tag: " + i2);
            return;
        }
        node.setLocalData(obj);
        dispatchViewUpdatesIfNeeded();
    }

    public void showPopupMenu(int i2, ReadableArray readableArray, Callback callback, Callback callback2) {
        assertViewExists(i2, "showPopupMenu");
        this.mOperationsQueue.enqueueShowPopupMenu(i2, readableArray, callback, callback2);
    }

    public void synchronouslyUpdateViewOnUIThread(int i2, ReactStylesDiffMap reactStylesDiffMap) {
        UiThreadUtil.assertOnUiThread();
        this.mOperationsQueue.getNativeViewHierarchyManager().updateProperties(i2, reactStylesDiffMap);
    }

    public void updateNodeSize(int i2, int i3, int i4) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
        if (node == null) {
            FLog.w(ReactConstants.TAG, "Tried to update size of non-existent tag: " + i2);
            return;
        }
        node.setStyleWidth((float) i3);
        node.setStyleHeight((float) i4);
        dispatchViewUpdatesIfNeeded();
    }

    public void updateRootView(int i2, int i3, int i4) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
        if (node == null) {
            FLog.w(ReactConstants.TAG, "Tried to update non-existent root tag: " + i2);
            return;
        }
        updateRootView(node, i3, i4);
    }

    public void updateView(int i2, String str, ReadableMap readableMap) {
        if (this.mViewOperationsEnabled) {
            if (this.mViewManagers.get(str) != null) {
                ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
                if (node == null) {
                    throw new IllegalViewOperationException("Trying to update non-existent view with tag " + i2);
                } else if (readableMap != null) {
                    ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(readableMap);
                    node.updateProperties(reactStylesDiffMap);
                    handleUpdateView(node, str, reactStylesDiffMap);
                }
            } else {
                throw new IllegalViewOperationException("Got unknown view type: " + str);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006f, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateViewHierarchy() {
        /*
            r7 = this;
            java.lang.String r0 = "rootTag"
            java.lang.String r1 = "UIImplementation.updateViewHierarchy"
            r2 = 0
            com.facebook.systrace.Systrace.beginSection(r2, r1)
            r1 = 0
        L_0x000a:
            com.facebook.react.uimanager.ShadowNodeRegistry r4 = r7.mShadowNodeRegistry     // Catch:{ all -> 0x0077 }
            int r4 = r4.getRootNodeCount()     // Catch:{ all -> 0x0077 }
            if (r1 >= r4) goto L_0x0073
            com.facebook.react.uimanager.ShadowNodeRegistry r4 = r7.mShadowNodeRegistry     // Catch:{ all -> 0x0077 }
            int r4 = r4.getRootTag(r1)     // Catch:{ all -> 0x0077 }
            com.facebook.react.uimanager.ShadowNodeRegistry r5 = r7.mShadowNodeRegistry     // Catch:{ all -> 0x0077 }
            com.facebook.react.uimanager.ReactShadowNode r4 = r5.getNode(r4)     // Catch:{ all -> 0x0077 }
            java.lang.Integer r5 = r4.getWidthMeasureSpec()     // Catch:{ all -> 0x0077 }
            if (r5 == 0) goto L_0x0070
            java.lang.Integer r5 = r4.getHeightMeasureSpec()     // Catch:{ all -> 0x0077 }
            if (r5 == 0) goto L_0x0070
            java.lang.String r5 = "UIImplementation.notifyOnBeforeLayoutRecursive"
            com.facebook.systrace.SystraceMessage$Builder r5 = com.facebook.systrace.SystraceMessage.beginSection(r2, r5)     // Catch:{ all -> 0x0077 }
            int r6 = r4.getReactTag()     // Catch:{ all -> 0x0077 }
            com.facebook.systrace.SystraceMessage$Builder r5 = r5.arg((java.lang.String) r0, (int) r6)     // Catch:{ all -> 0x0077 }
            r5.flush()     // Catch:{ all -> 0x0077 }
            r7.notifyOnBeforeLayoutRecursive(r4)     // Catch:{ all -> 0x006b }
            com.facebook.systrace.Systrace.endSection(r2)     // Catch:{ all -> 0x0077 }
            r7.calculateRootLayout(r4)     // Catch:{ all -> 0x0077 }
            java.lang.String r5 = "UIImplementation.applyUpdatesRecursive"
            com.facebook.systrace.SystraceMessage$Builder r5 = com.facebook.systrace.SystraceMessage.beginSection(r2, r5)     // Catch:{ all -> 0x0077 }
            int r6 = r4.getReactTag()     // Catch:{ all -> 0x0077 }
            com.facebook.systrace.SystraceMessage$Builder r5 = r5.arg((java.lang.String) r0, (int) r6)     // Catch:{ all -> 0x0077 }
            r5.flush()     // Catch:{ all -> 0x0077 }
            r5 = 0
            r7.applyUpdatesRecursive(r4, r5, r5)     // Catch:{ all -> 0x0066 }
            com.facebook.systrace.Systrace.endSection(r2)     // Catch:{ all -> 0x0077 }
            com.facebook.react.uimanager.UIImplementation$LayoutUpdateListener r5 = r7.mLayoutUpdateListener     // Catch:{ all -> 0x0077 }
            if (r5 == 0) goto L_0x0070
            com.facebook.react.uimanager.UIViewOperationQueue r6 = r7.mOperationsQueue     // Catch:{ all -> 0x0077 }
            r6.enqueueLayoutUpdateFinished(r4, r5)     // Catch:{ all -> 0x0077 }
            goto L_0x0070
        L_0x0066:
            r0 = move-exception
            com.facebook.systrace.Systrace.endSection(r2)     // Catch:{ all -> 0x0077 }
            throw r0     // Catch:{ all -> 0x0077 }
        L_0x006b:
            r0 = move-exception
            com.facebook.systrace.Systrace.endSection(r2)     // Catch:{ all -> 0x0077 }
            throw r0     // Catch:{ all -> 0x0077 }
        L_0x0070:
            int r1 = r1 + 1
            goto L_0x000a
        L_0x0073:
            com.facebook.systrace.Systrace.endSection(r2)
            return
        L_0x0077:
            r0 = move-exception
            com.facebook.systrace.Systrace.endSection(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIImplementation.updateViewHierarchy():void");
    }

    @Deprecated
    public void viewIsDescendantOf(int i2, int i3, Callback callback) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
        ReactShadowNode node2 = this.mShadowNodeRegistry.getNode(i3);
        if (node == null || node2 == null) {
            callback.invoke(Boolean.FALSE);
            return;
        }
        callback.invoke(Boolean.valueOf(node.isDescendantOf(node2)));
    }

    public UIImplementation(ReactApplicationContext reactApplicationContext, List<ViewManager> list, EventDispatcher eventDispatcher, int i2) {
        this(reactApplicationContext, new ViewManagerRegistry(list), eventDispatcher, i2);
    }

    UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, int i2) {
        this(reactApplicationContext, viewManagerRegistry, new UIViewOperationQueue(reactApplicationContext, new NativeViewHierarchyManager(viewManagerRegistry), i2), eventDispatcher);
    }

    public void dispatchViewManagerCommand(int i2, String str, ReadableArray readableArray) {
        assertViewExists(i2, "dispatchViewManagerCommand: " + str);
        this.mOperationsQueue.enqueueDispatchCommand(i2, str, readableArray);
    }

    protected UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, UIViewOperationQueue uIViewOperationQueue, EventDispatcher eventDispatcher) {
        this.uiImplementationThreadLock = new Object();
        ShadowNodeRegistry shadowNodeRegistry = new ShadowNodeRegistry();
        this.mShadowNodeRegistry = shadowNodeRegistry;
        this.mMeasureBuffer = new int[4];
        this.mLastCalculateLayoutTime = 0;
        this.mViewOperationsEnabled = true;
        this.mReactContext = reactApplicationContext;
        this.mViewManagers = viewManagerRegistry;
        this.mOperationsQueue = uIViewOperationQueue;
        this.mNativeViewHierarchyOptimizer = new NativeViewHierarchyOptimizer(uIViewOperationQueue, shadowNodeRegistry);
        this.mEventDispatcher = eventDispatcher;
    }

    public void updateRootView(ReactShadowNode reactShadowNode, int i2, int i3) {
        reactShadowNode.setMeasureSpecs(i2, i3);
    }

    private void measureLayout(int i2, int i3, int[] iArr) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
        ReactShadowNode node2 = this.mShadowNodeRegistry.getNode(i3);
        if (node == null || node2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tag ");
            if (node != null) {
                i2 = i3;
            }
            sb.append(i2);
            sb.append(" does not exist");
            throw new IllegalViewOperationException(sb.toString());
        }
        if (node != node2) {
            ReactShadowNode parent = node.getParent();
            while (parent != node2) {
                if (parent != null) {
                    parent = parent.getParent();
                } else {
                    throw new IllegalViewOperationException("Tag " + i3 + " is not an ancestor of tag " + i2);
                }
            }
        }
        measureLayoutRelativeToVerifiedAncestor(node, node2, iArr);
    }

    private void measureLayoutRelativeToParent(int i2, int[] iArr) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
        if (node != null) {
            ReactShadowNode parent = node.getParent();
            if (parent != null) {
                measureLayoutRelativeToVerifiedAncestor(node, parent, iArr);
                return;
            }
            throw new IllegalViewOperationException("View with tag " + i2 + " doesn't have a parent!");
        }
        throw new IllegalViewOperationException("No native view for tag " + i2 + " exists!");
    }
}
