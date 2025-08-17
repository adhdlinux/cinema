package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.systrace.Systrace;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UIViewOperationQueue {
    public static final int DEFAULT_MIN_TIME_LEFT_IN_FRAME_FOR_NONBATCHED_OPERATION_MS = 8;
    /* access modifiers changed from: private */
    public static final String TAG = "UIViewOperationQueue";
    private long mCreateViewCount;
    private final Object mDispatchRunnablesLock = new Object();
    private final DispatchUIFrameCallback mDispatchUIFrameCallback;
    private ArrayList<Runnable> mDispatchUIRunnables = new ArrayList<>();
    private boolean mIsDispatchUIFrameCallbackEnqueued = false;
    /* access modifiers changed from: private */
    public boolean mIsInIllegalUIState = false;
    /* access modifiers changed from: private */
    public boolean mIsProfilingNextBatch = false;
    /* access modifiers changed from: private */
    public final int[] mMeasureBuffer = new int[4];
    /* access modifiers changed from: private */
    public final NativeViewHierarchyManager mNativeViewHierarchyManager;
    private long mNonBatchedExecutionTotalTime;
    /* access modifiers changed from: private */
    public ArrayDeque<UIOperation> mNonBatchedOperations = new ArrayDeque<>();
    /* access modifiers changed from: private */
    public final Object mNonBatchedOperationsLock = new Object();
    private ArrayList<UIOperation> mOperations = new ArrayList<>();
    private long mProfiledBatchBatchedExecutionTime;
    /* access modifiers changed from: private */
    public long mProfiledBatchCommitEndTime;
    /* access modifiers changed from: private */
    public long mProfiledBatchCommitStartTime;
    /* access modifiers changed from: private */
    public long mProfiledBatchDispatchViewUpdatesTime;
    /* access modifiers changed from: private */
    public long mProfiledBatchLayoutTime;
    private long mProfiledBatchNonBatchedExecutionTime;
    /* access modifiers changed from: private */
    public long mProfiledBatchRunEndTime;
    /* access modifiers changed from: private */
    public long mProfiledBatchRunStartTime;
    /* access modifiers changed from: private */
    public final ReactApplicationContext mReactApplicationContext;
    /* access modifiers changed from: private */
    public long mThreadCpuTime;
    private long mUpdatePropertiesOperationCount;
    /* access modifiers changed from: private */
    public ArrayList<DispatchCommandViewOperation> mViewCommandOperations = new ArrayList<>();
    /* access modifiers changed from: private */
    public NotThreadSafeViewHierarchyUpdateDebugListener mViewHierarchyUpdateDebugListener;

    private static abstract class AnimationOperation implements UIOperation {
        protected final int mAnimationID;

        public AnimationOperation(int i2) {
            this.mAnimationID = i2;
        }
    }

    private final class ChangeJSResponderOperation extends ViewOperation {
        private final boolean mBlockNativeResponder;
        private final boolean mClearResponder;
        private final int mInitialTag;

        public ChangeJSResponderOperation(int i2, int i3, boolean z2, boolean z3) {
            super(i2);
            this.mInitialTag = i3;
            this.mClearResponder = z2;
            this.mBlockNativeResponder = z3;
        }

        public void execute() {
            if (!this.mClearResponder) {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.setJSResponder(this.mTag, this.mInitialTag, this.mBlockNativeResponder);
            } else {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.clearJSResponder();
            }
        }
    }

    private class ConfigureLayoutAnimationOperation implements UIOperation {
        private final Callback mAnimationComplete;
        private final ReadableMap mConfig;

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.configureLayoutAnimation(this.mConfig, this.mAnimationComplete);
        }

        private ConfigureLayoutAnimationOperation(ReadableMap readableMap, Callback callback) {
            this.mConfig = readableMap;
            this.mAnimationComplete = callback;
        }
    }

    private final class CreateViewOperation extends ViewOperation {
        private final String mClassName;
        private final ReactStylesDiffMap mInitialProps;
        private final ThemedReactContext mThemedContext;

        public CreateViewOperation(ThemedReactContext themedReactContext, int i2, String str, ReactStylesDiffMap reactStylesDiffMap) {
            super(i2);
            this.mThemedContext = themedReactContext;
            this.mClassName = str;
            this.mInitialProps = reactStylesDiffMap;
            Systrace.startAsyncFlow(0, "createView", this.mTag);
        }

        public void execute() {
            Systrace.endAsyncFlow(0, "createView", this.mTag);
            UIViewOperationQueue.this.mNativeViewHierarchyManager.createView(this.mThemedContext, this.mTag, this.mClassName, this.mInitialProps);
        }
    }

    private final class DismissPopupMenuOperation implements UIOperation {
        private DismissPopupMenuOperation() {
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.dismissPopupMenu();
        }
    }

    @Deprecated
    private final class DispatchCommandOperation extends ViewOperation implements DispatchCommandViewOperation {
        private final ReadableArray mArgs;
        private final int mCommand;
        private int numRetries = 0;

        public DispatchCommandOperation(int i2, int i3, ReadableArray readableArray) {
            super(i2);
            this.mCommand = i3;
            this.mArgs = readableArray;
        }

        public void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
            } catch (Throwable th) {
                ReactSoftExceptionLogger.logSoftException(UIViewOperationQueue.TAG, new RuntimeException("Error dispatching View Command", th));
            }
        }

        public void executeWithExceptions() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
        }

        public int getRetries() {
            return this.numRetries;
        }

        public void incrementRetries() {
            this.numRetries++;
        }
    }

    private interface DispatchCommandViewOperation {
        void executeWithExceptions();

        int getRetries();

        void incrementRetries();
    }

    private final class DispatchStringCommandOperation extends ViewOperation implements DispatchCommandViewOperation {
        private final ReadableArray mArgs;
        private final String mCommand;
        private int numRetries = 0;

        public DispatchStringCommandOperation(int i2, String str, ReadableArray readableArray) {
            super(i2);
            this.mCommand = str;
            this.mArgs = readableArray;
        }

        public void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
            } catch (Throwable th) {
                ReactSoftExceptionLogger.logSoftException(UIViewOperationQueue.TAG, new RuntimeException("Error dispatching View Command", th));
            }
        }

        public void executeWithExceptions() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.dispatchCommand(this.mTag, this.mCommand, this.mArgs);
        }

        public int getRetries() {
            return this.numRetries;
        }

        public void incrementRetries() {
            this.numRetries++;
        }
    }

    private class DispatchUIFrameCallback extends GuardedFrameCallback {
        private static final int FRAME_TIME_MS = 16;
        private final int mMinTimeLeftInFrameForNonBatchedOperationMs;

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r2 = android.os.SystemClock.uptimeMillis();
            r1.execute();
            com.facebook.react.uimanager.UIViewOperationQueue.access$2914(r6.this$0, android.os.SystemClock.uptimeMillis() - r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0048, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
            com.facebook.react.uimanager.UIViewOperationQueue.access$2502(r6.this$0, true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
            throw r7;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void dispatchPendingNonBatchedOperations(long r7) {
            /*
                r6 = this;
            L_0x0000:
                long r0 = java.lang.System.nanoTime()
                long r0 = r0 - r7
                r2 = 1000000(0xf4240, double:4.940656E-318)
                long r0 = r0 / r2
                r2 = 16
                long r2 = r2 - r0
                int r0 = r6.mMinTimeLeftInFrameForNonBatchedOperationMs
                long r0 = (long) r0
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 >= 0) goto L_0x0014
                goto L_0x0028
            L_0x0014:
                com.facebook.react.uimanager.UIViewOperationQueue r0 = com.facebook.react.uimanager.UIViewOperationQueue.this
                java.lang.Object r0 = r0.mNonBatchedOperationsLock
                monitor-enter(r0)
                com.facebook.react.uimanager.UIViewOperationQueue r1 = com.facebook.react.uimanager.UIViewOperationQueue.this     // Catch:{ all -> 0x0050 }
                java.util.ArrayDeque r1 = r1.mNonBatchedOperations     // Catch:{ all -> 0x0050 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0050 }
                if (r1 == 0) goto L_0x0029
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            L_0x0028:
                return
            L_0x0029:
                com.facebook.react.uimanager.UIViewOperationQueue r1 = com.facebook.react.uimanager.UIViewOperationQueue.this     // Catch:{ all -> 0x0050 }
                java.util.ArrayDeque r1 = r1.mNonBatchedOperations     // Catch:{ all -> 0x0050 }
                java.lang.Object r1 = r1.pollFirst()     // Catch:{ all -> 0x0050 }
                com.facebook.react.uimanager.UIViewOperationQueue$UIOperation r1 = (com.facebook.react.uimanager.UIViewOperationQueue.UIOperation) r1     // Catch:{ all -> 0x0050 }
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                long r2 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x0048 }
                r1.execute()     // Catch:{ Exception -> 0x0048 }
                com.facebook.react.uimanager.UIViewOperationQueue r0 = com.facebook.react.uimanager.UIViewOperationQueue.this     // Catch:{ Exception -> 0x0048 }
                long r4 = android.os.SystemClock.uptimeMillis()     // Catch:{ Exception -> 0x0048 }
                long r4 = r4 - r2
                com.facebook.react.uimanager.UIViewOperationQueue.access$2914(r0, r4)     // Catch:{ Exception -> 0x0048 }
                goto L_0x0000
            L_0x0048:
                r7 = move-exception
                com.facebook.react.uimanager.UIViewOperationQueue r8 = com.facebook.react.uimanager.UIViewOperationQueue.this
                r0 = 1
                boolean unused = r8.mIsInIllegalUIState = r0
                throw r7
            L_0x0050:
                r7 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.DispatchUIFrameCallback.dispatchPendingNonBatchedOperations(long):void");
        }

        /* JADX INFO: finally extract failed */
        public void doFrameGuarded(long j2) {
            if (UIViewOperationQueue.this.mIsInIllegalUIState) {
                FLog.w(ReactConstants.TAG, "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            Systrace.beginSection(0, "dispatchNonBatchedUIOperations");
            try {
                dispatchPendingNonBatchedOperations(j2);
                Systrace.endSection(0);
                UIViewOperationQueue.this.flushPendingBatches();
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this);
            } catch (Throwable th) {
                Systrace.endSection(0);
                throw th;
            }
        }

        private DispatchUIFrameCallback(ReactContext reactContext, int i2) {
            super(reactContext);
            this.mMinTimeLeftInFrameForNonBatchedOperationMs = i2;
        }
    }

    private final class EmitOnLayoutEventOperation extends ViewOperation {
        private final int mScreenHeight;
        private final int mScreenWidth;
        private final int mScreenX;
        private final int mScreenY;

        public EmitOnLayoutEventOperation(int i2, int i3, int i4, int i5, int i6) {
            super(i2);
            this.mScreenX = i3;
            this.mScreenY = i4;
            this.mScreenWidth = i5;
            this.mScreenHeight = i6;
        }

        public void execute() {
            UIManagerModule uIManagerModule = (UIManagerModule) UIViewOperationQueue.this.mReactApplicationContext.getNativeModule(UIManagerModule.class);
            if (uIManagerModule != null) {
                uIManagerModule.getEventDispatcher().dispatchEvent(OnLayoutEvent.obtain(-1, this.mTag, this.mScreenX, this.mScreenY, this.mScreenWidth, this.mScreenHeight));
            }
        }
    }

    private final class FindTargetForTouchOperation implements UIOperation {
        private final Callback mCallback;
        private final int mReactTag;
        private final float mTargetX;
        private final float mTargetY;

        public void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
                float f2 = (float) UIViewOperationQueue.this.mMeasureBuffer[0];
                float f3 = (float) UIViewOperationQueue.this.mMeasureBuffer[1];
                int findTargetTagForTouch = UIViewOperationQueue.this.mNativeViewHierarchyManager.findTargetTagForTouch(this.mReactTag, this.mTargetX, this.mTargetY);
                try {
                    UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(findTargetTagForTouch, UIViewOperationQueue.this.mMeasureBuffer);
                    float dIPFromPixel = PixelUtil.toDIPFromPixel(((float) UIViewOperationQueue.this.mMeasureBuffer[0]) - f2);
                    float dIPFromPixel2 = PixelUtil.toDIPFromPixel(((float) UIViewOperationQueue.this.mMeasureBuffer[1]) - f3);
                    float dIPFromPixel3 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[2]);
                    float dIPFromPixel4 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[3]);
                    this.mCallback.invoke(Integer.valueOf(findTargetTagForTouch), Float.valueOf(dIPFromPixel), Float.valueOf(dIPFromPixel2), Float.valueOf(dIPFromPixel3), Float.valueOf(dIPFromPixel4));
                } catch (IllegalViewOperationException unused) {
                    this.mCallback.invoke(new Object[0]);
                }
            } catch (IllegalViewOperationException unused2) {
                this.mCallback.invoke(new Object[0]);
            }
        }

        private FindTargetForTouchOperation(int i2, float f2, float f3, Callback callback) {
            this.mReactTag = i2;
            this.mTargetX = f2;
            this.mTargetY = f3;
            this.mCallback = callback;
        }
    }

    private final class LayoutUpdateFinishedOperation implements UIOperation {
        private final UIImplementation.LayoutUpdateListener mListener;
        private final ReactShadowNode mNode;

        public void execute() {
            this.mListener.onLayoutUpdated(this.mNode);
        }

        private LayoutUpdateFinishedOperation(ReactShadowNode reactShadowNode, UIImplementation.LayoutUpdateListener layoutUpdateListener) {
            this.mNode = reactShadowNode;
            this.mListener = layoutUpdateListener;
        }
    }

    private final class ManageChildrenOperation extends ViewOperation {
        private final int[] mIndicesToRemove;
        private final int[] mTagsToDelete;
        private final ViewAtIndex[] mViewsToAdd;

        public ManageChildrenOperation(int i2, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
            super(i2);
            this.mIndicesToRemove = iArr;
            this.mViewsToAdd = viewAtIndexArr;
            this.mTagsToDelete = iArr2;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.manageChildren(this.mTag, this.mIndicesToRemove, this.mViewsToAdd, this.mTagsToDelete);
        }
    }

    private final class MeasureInWindowOperation implements UIOperation {
        private final Callback mCallback;
        private final int mReactTag;

        public void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.measureInWindow(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
                float dIPFromPixel = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[0]);
                float dIPFromPixel2 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[1]);
                float dIPFromPixel3 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[2]);
                float dIPFromPixel4 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[3]);
                this.mCallback.invoke(Float.valueOf(dIPFromPixel), Float.valueOf(dIPFromPixel2), Float.valueOf(dIPFromPixel3), Float.valueOf(dIPFromPixel4));
            } catch (NoSuchNativeViewException unused) {
                this.mCallback.invoke(new Object[0]);
            }
        }

        private MeasureInWindowOperation(int i2, Callback callback) {
            this.mReactTag = i2;
            this.mCallback = callback;
        }
    }

    private final class MeasureOperation implements UIOperation {
        private final Callback mCallback;
        private final int mReactTag;

        public void execute() {
            try {
                UIViewOperationQueue.this.mNativeViewHierarchyManager.measure(this.mReactTag, UIViewOperationQueue.this.mMeasureBuffer);
                float dIPFromPixel = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[0]);
                float dIPFromPixel2 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[1]);
                float dIPFromPixel3 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[2]);
                float dIPFromPixel4 = PixelUtil.toDIPFromPixel((float) UIViewOperationQueue.this.mMeasureBuffer[3]);
                this.mCallback.invoke(0, 0, Float.valueOf(dIPFromPixel3), Float.valueOf(dIPFromPixel4), Float.valueOf(dIPFromPixel), Float.valueOf(dIPFromPixel2));
            } catch (NoSuchNativeViewException unused) {
                this.mCallback.invoke(new Object[0]);
            }
        }

        private MeasureOperation(int i2, Callback callback) {
            this.mReactTag = i2;
            this.mCallback = callback;
        }
    }

    private final class RemoveRootViewOperation extends ViewOperation {
        public RemoveRootViewOperation(int i2) {
            super(i2);
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.removeRootView(this.mTag);
        }
    }

    private final class SendAccessibilityEvent extends ViewOperation {
        private final int mEventType;

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.sendAccessibilityEvent(this.mTag, this.mEventType);
        }

        private SendAccessibilityEvent(int i2, int i3) {
            super(i2);
            this.mEventType = i3;
        }
    }

    private final class SetChildrenOperation extends ViewOperation {
        private final ReadableArray mChildrenTags;

        public SetChildrenOperation(int i2, ReadableArray readableArray) {
            super(i2);
            this.mChildrenTags = readableArray;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.setChildren(this.mTag, this.mChildrenTags);
        }
    }

    private class SetLayoutAnimationEnabledOperation implements UIOperation {
        private final boolean mEnabled;

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.setLayoutAnimationEnabled(this.mEnabled);
        }

        private SetLayoutAnimationEnabledOperation(boolean z2) {
            this.mEnabled = z2;
        }
    }

    private final class ShowPopupMenuOperation extends ViewOperation {
        private final Callback mError;
        private final ReadableArray mItems;
        private final Callback mSuccess;

        public ShowPopupMenuOperation(int i2, ReadableArray readableArray, Callback callback, Callback callback2) {
            super(i2);
            this.mItems = readableArray;
            this.mError = callback;
            this.mSuccess = callback2;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.showPopupMenu(this.mTag, this.mItems, this.mSuccess, this.mError);
        }
    }

    private class UIBlockOperation implements UIOperation {
        private final UIBlock mBlock;

        public UIBlockOperation(UIBlock uIBlock) {
            this.mBlock = uIBlock;
        }

        public void execute() {
            this.mBlock.execute(UIViewOperationQueue.this.mNativeViewHierarchyManager);
        }
    }

    public interface UIOperation {
        void execute();
    }

    private final class UpdateInstanceHandleOperation extends ViewOperation {
        private final long mInstanceHandle;

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateInstanceHandle(this.mTag, this.mInstanceHandle);
        }

        private UpdateInstanceHandleOperation(int i2, long j2) {
            super(i2);
            this.mInstanceHandle = j2;
        }
    }

    private final class UpdateLayoutOperation extends ViewOperation {
        private final int mHeight;
        private final int mParentTag;
        private final int mWidth;
        private final int mX;
        private final int mY;

        public UpdateLayoutOperation(int i2, int i3, int i4, int i5, int i6, int i7) {
            super(i3);
            this.mParentTag = i2;
            this.mX = i4;
            this.mY = i5;
            this.mWidth = i6;
            this.mHeight = i7;
            Systrace.startAsyncFlow(0, "updateLayout", this.mTag);
        }

        public void execute() {
            Systrace.endAsyncFlow(0, "updateLayout", this.mTag);
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateLayout(this.mParentTag, this.mTag, this.mX, this.mY, this.mWidth, this.mHeight);
        }
    }

    private final class UpdatePropertiesOperation extends ViewOperation {
        private final ReactStylesDiffMap mProps;

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateProperties(this.mTag, this.mProps);
        }

        private UpdatePropertiesOperation(int i2, ReactStylesDiffMap reactStylesDiffMap) {
            super(i2);
            this.mProps = reactStylesDiffMap;
        }
    }

    private final class UpdateViewExtraData extends ViewOperation {
        private final Object mExtraData;

        public UpdateViewExtraData(int i2, Object obj) {
            super(i2);
            this.mExtraData = obj;
        }

        public void execute() {
            UIViewOperationQueue.this.mNativeViewHierarchyManager.updateViewExtraData(this.mTag, this.mExtraData);
        }
    }

    private abstract class ViewOperation implements UIOperation {
        public int mTag;

        public ViewOperation(int i2) {
            this.mTag = i2;
        }
    }

    public UIViewOperationQueue(ReactApplicationContext reactApplicationContext, NativeViewHierarchyManager nativeViewHierarchyManager, int i2) {
        this.mNativeViewHierarchyManager = nativeViewHierarchyManager;
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext, i2 == -1 ? 8 : i2);
        this.mReactApplicationContext = reactApplicationContext;
    }

    static /* synthetic */ long access$2914(UIViewOperationQueue uIViewOperationQueue, long j2) {
        long j3 = uIViewOperationQueue.mNonBatchedExecutionTotalTime + j2;
        uIViewOperationQueue.mNonBatchedExecutionTotalTime = j3;
        return j3;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        r2 = android.os.SystemClock.uptimeMillis();
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r0.hasNext() == false) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        r0.next().run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r12.mIsProfilingNextBatch == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        r12.mProfiledBatchBatchedExecutionTime = android.os.SystemClock.uptimeMillis() - r2;
        r12.mProfiledBatchNonBatchedExecutionTime = r12.mNonBatchedExecutionTotalTime;
        r12.mIsProfilingNextBatch = false;
        com.facebook.systrace.Systrace.beginAsyncSection(0, "batchedExecutionTime", 0, 1000000 * r2);
        com.facebook.systrace.Systrace.endAsyncSection(0, "batchedExecutionTime", 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        r12.mNonBatchedExecutionTotalTime = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void flushPendingBatches() {
        /*
            r12 = this;
            boolean r0 = r12.mIsInIllegalUIState
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "ReactNative"
            java.lang.String r1 = "Not flushing pending UI operations because of previously thrown Exception"
            com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r1)
            return
        L_0x000c:
            java.lang.Object r0 = r12.mDispatchRunnablesLock
            monitor-enter(r0)
            java.util.ArrayList<java.lang.Runnable> r1 = r12.mDispatchUIRunnables     // Catch:{ all -> 0x0064 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0064 }
            if (r1 != 0) goto L_0x0062
            java.util.ArrayList<java.lang.Runnable> r1 = r12.mDispatchUIRunnables     // Catch:{ all -> 0x0064 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0064 }
            r2.<init>()     // Catch:{ all -> 0x0064 }
            r12.mDispatchUIRunnables = r2     // Catch:{ all -> 0x0064 }
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            long r2 = android.os.SystemClock.uptimeMillis()
            java.util.Iterator r0 = r1.iterator()
        L_0x0029:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r0.next()
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r1.run()
            goto L_0x0029
        L_0x0039:
            boolean r0 = r12.mIsProfilingNextBatch
            r4 = 0
            if (r0 == 0) goto L_0x005f
            long r0 = android.os.SystemClock.uptimeMillis()
            long r0 = r0 - r2
            r12.mProfiledBatchBatchedExecutionTime = r0
            long r0 = r12.mNonBatchedExecutionTotalTime
            r12.mProfiledBatchNonBatchedExecutionTime = r0
            r0 = 0
            r12.mIsProfilingNextBatch = r0
            r6 = 0
            java.lang.String r8 = "batchedExecutionTime"
            r9 = 0
            r10 = 1000000(0xf4240, double:4.940656E-318)
            long r10 = r10 * r2
            com.facebook.systrace.Systrace.beginAsyncSection(r6, r8, r9, r10)
            java.lang.String r1 = "batchedExecutionTime"
            com.facebook.systrace.Systrace.endAsyncSection(r4, r1, r0)
        L_0x005f:
            r12.mNonBatchedExecutionTotalTime = r4
            return
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            return
        L_0x0064:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0064 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.flushPendingBatches():void");
    }

    public void addRootView(int i2, View view) {
        this.mNativeViewHierarchyManager.addRootView(i2, view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b3, code lost:
        r0 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchViewUpdates(int r20, long r21, long r23) {
        /*
            r19 = this;
            r15 = r19
            r0 = r20
            java.lang.String r1 = "UIViewOperationQueue.dispatchViewUpdates"
            r13 = 0
            com.facebook.systrace.SystraceMessage$Builder r1 = com.facebook.systrace.SystraceMessage.beginSection(r13, r1)
            java.lang.String r2 = "batchId"
            com.facebook.systrace.SystraceMessage$Builder r1 = r1.arg((java.lang.String) r2, (int) r0)
            r1.flush()
            long r11 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00b5 }
            long r16 = android.os.SystemClock.currentThreadTimeMillis()     // Catch:{ all -> 0x00b5 }
            java.util.ArrayList<com.facebook.react.uimanager.UIViewOperationQueue$DispatchCommandViewOperation> r1 = r15.mViewCommandOperations     // Catch:{ all -> 0x00b5 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00b5 }
            r2 = 0
            if (r1 != 0) goto L_0x0031
            java.util.ArrayList<com.facebook.react.uimanager.UIViewOperationQueue$DispatchCommandViewOperation> r1 = r15.mViewCommandOperations     // Catch:{ all -> 0x00b5 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00b5 }
            r3.<init>()     // Catch:{ all -> 0x00b5 }
            r15.mViewCommandOperations = r3     // Catch:{ all -> 0x00b5 }
            r4 = r1
            goto L_0x0032
        L_0x0031:
            r4 = r2
        L_0x0032:
            java.util.ArrayList<com.facebook.react.uimanager.UIViewOperationQueue$UIOperation> r1 = r15.mOperations     // Catch:{ all -> 0x00b5 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00b5 }
            if (r1 != 0) goto L_0x0045
            java.util.ArrayList<com.facebook.react.uimanager.UIViewOperationQueue$UIOperation> r1 = r15.mOperations     // Catch:{ all -> 0x00b5 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00b5 }
            r3.<init>()     // Catch:{ all -> 0x00b5 }
            r15.mOperations = r3     // Catch:{ all -> 0x00b5 }
            r6 = r1
            goto L_0x0046
        L_0x0045:
            r6 = r2
        L_0x0046:
            java.lang.Object r1 = r15.mNonBatchedOperationsLock     // Catch:{ all -> 0x00b5 }
            monitor-enter(r1)     // Catch:{ all -> 0x00b5 }
            java.util.ArrayDeque<com.facebook.react.uimanager.UIViewOperationQueue$UIOperation> r3 = r15.mNonBatchedOperations     // Catch:{ all -> 0x00ad }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00ad }
            if (r3 != 0) goto L_0x005a
            java.util.ArrayDeque<com.facebook.react.uimanager.UIViewOperationQueue$UIOperation> r2 = r15.mNonBatchedOperations     // Catch:{ all -> 0x00ad }
            java.util.ArrayDeque r3 = new java.util.ArrayDeque     // Catch:{ all -> 0x00ad }
            r3.<init>()     // Catch:{ all -> 0x00ad }
            r15.mNonBatchedOperations = r3     // Catch:{ all -> 0x00ad }
        L_0x005a:
            r5 = r2
            monitor-exit(r1)     // Catch:{ all -> 0x00ad }
            com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener r1 = r15.mViewHierarchyUpdateDebugListener     // Catch:{ all -> 0x00b5 }
            if (r1 == 0) goto L_0x0063
            r1.onViewHierarchyUpdateEnqueued()     // Catch:{ all -> 0x00b5 }
        L_0x0063:
            com.facebook.react.uimanager.UIViewOperationQueue$1 r9 = new com.facebook.react.uimanager.UIViewOperationQueue$1     // Catch:{ all -> 0x00b5 }
            r1 = r9
            r2 = r19
            r3 = r20
            r7 = r21
            r18 = r9
            r9 = r23
            r13 = r16
            r1.<init>(r3, r4, r5, r6, r7, r9, r11, r13)     // Catch:{ all -> 0x00a9 }
            java.lang.String r1 = "acquiring mDispatchRunnablesLock"
            r2 = 0
            com.facebook.systrace.SystraceMessage$Builder r1 = com.facebook.systrace.SystraceMessage.beginSection(r2, r1)     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = "batchId"
            com.facebook.systrace.SystraceMessage$Builder r0 = r1.arg((java.lang.String) r4, (int) r0)     // Catch:{ all -> 0x00b1 }
            r0.flush()     // Catch:{ all -> 0x00b1 }
            java.lang.Object r1 = r15.mDispatchRunnablesLock     // Catch:{ all -> 0x00b1 }
            monitor-enter(r1)     // Catch:{ all -> 0x00b1 }
            com.facebook.systrace.Systrace.endSection(r2)     // Catch:{ all -> 0x00a6 }
            java.util.ArrayList<java.lang.Runnable> r0 = r15.mDispatchUIRunnables     // Catch:{ all -> 0x00a6 }
            r4 = r18
            r0.add(r4)     // Catch:{ all -> 0x00a6 }
            monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
            boolean r0 = r15.mIsDispatchUIFrameCallbackEnqueued     // Catch:{ all -> 0x00b1 }
            if (r0 != 0) goto L_0x00a2
            com.facebook.react.uimanager.UIViewOperationQueue$2 r0 = new com.facebook.react.uimanager.UIViewOperationQueue$2     // Catch:{ all -> 0x00b1 }
            com.facebook.react.bridge.ReactApplicationContext r1 = r15.mReactApplicationContext     // Catch:{ all -> 0x00b1 }
            r0.<init>(r1)     // Catch:{ all -> 0x00b1 }
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r0)     // Catch:{ all -> 0x00b1 }
        L_0x00a2:
            com.facebook.systrace.Systrace.endSection(r2)
            return
        L_0x00a6:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
            throw r0     // Catch:{ all -> 0x00b1 }
        L_0x00a9:
            r0 = move-exception
            r2 = 0
            goto L_0x00b7
        L_0x00ad:
            r0 = move-exception
            r2 = r13
        L_0x00af:
            monitor-exit(r1)     // Catch:{ all -> 0x00b3 }
            throw r0     // Catch:{ all -> 0x00b1 }
        L_0x00b1:
            r0 = move-exception
            goto L_0x00b7
        L_0x00b3:
            r0 = move-exception
            goto L_0x00af
        L_0x00b5:
            r0 = move-exception
            r2 = r13
        L_0x00b7:
            com.facebook.systrace.Systrace.endSection(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.UIViewOperationQueue.dispatchViewUpdates(int, long, long):void");
    }

    public void enqueueClearJSResponder() {
        this.mOperations.add(new ChangeJSResponderOperation(0, 0, true, false));
    }

    public void enqueueConfigureLayoutAnimation(ReadableMap readableMap, Callback callback) {
        this.mOperations.add(new ConfigureLayoutAnimationOperation(readableMap, callback));
    }

    public void enqueueCreateView(ThemedReactContext themedReactContext, int i2, String str, ReactStylesDiffMap reactStylesDiffMap) {
        synchronized (this.mNonBatchedOperationsLock) {
            this.mCreateViewCount++;
            this.mNonBatchedOperations.addLast(new CreateViewOperation(themedReactContext, i2, str, reactStylesDiffMap));
        }
    }

    public void enqueueDismissPopupMenu() {
        this.mOperations.add(new DismissPopupMenuOperation());
    }

    @Deprecated
    public void enqueueDispatchCommand(int i2, int i3, ReadableArray readableArray) {
        this.mViewCommandOperations.add(new DispatchCommandOperation(i2, i3, readableArray));
    }

    public void enqueueFindTargetForTouch(int i2, float f2, float f3, Callback callback) {
        this.mOperations.add(new FindTargetForTouchOperation(i2, f2, f3, callback));
    }

    public void enqueueLayoutUpdateFinished(ReactShadowNode reactShadowNode, UIImplementation.LayoutUpdateListener layoutUpdateListener) {
        this.mOperations.add(new LayoutUpdateFinishedOperation(reactShadowNode, layoutUpdateListener));
    }

    public void enqueueManageChildren(int i2, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        this.mOperations.add(new ManageChildrenOperation(i2, iArr, viewAtIndexArr, iArr2));
    }

    public void enqueueMeasure(int i2, Callback callback) {
        this.mOperations.add(new MeasureOperation(i2, callback));
    }

    public void enqueueMeasureInWindow(int i2, Callback callback) {
        this.mOperations.add(new MeasureInWindowOperation(i2, callback));
    }

    public void enqueueOnLayoutEvent(int i2, int i3, int i4, int i5, int i6) {
        this.mOperations.add(new EmitOnLayoutEventOperation(i2, i3, i4, i5, i6));
    }

    public void enqueueRemoveRootView(int i2) {
        this.mOperations.add(new RemoveRootViewOperation(i2));
    }

    public void enqueueSendAccessibilityEvent(int i2, int i3) {
        this.mOperations.add(new SendAccessibilityEvent(i2, i3));
    }

    public void enqueueSetChildren(int i2, ReadableArray readableArray) {
        this.mOperations.add(new SetChildrenOperation(i2, readableArray));
    }

    public void enqueueSetJSResponder(int i2, int i3, boolean z2) {
        this.mOperations.add(new ChangeJSResponderOperation(i2, i3, false, z2));
    }

    public void enqueueSetLayoutAnimationEnabled(boolean z2) {
        this.mOperations.add(new SetLayoutAnimationEnabledOperation(z2));
    }

    public void enqueueShowPopupMenu(int i2, ReadableArray readableArray, Callback callback, Callback callback2) {
        this.mOperations.add(new ShowPopupMenuOperation(i2, readableArray, callback, callback2));
    }

    public void enqueueUIBlock(UIBlock uIBlock) {
        this.mOperations.add(new UIBlockOperation(uIBlock));
    }

    /* access modifiers changed from: protected */
    public void enqueueUIOperation(UIOperation uIOperation) {
        SoftAssertions.assertNotNull(uIOperation);
        this.mOperations.add(uIOperation);
    }

    public void enqueueUpdateExtraData(int i2, Object obj) {
        this.mOperations.add(new UpdateViewExtraData(i2, obj));
    }

    public void enqueueUpdateInstanceHandle(int i2, long j2) {
        this.mOperations.add(new UpdateInstanceHandleOperation(i2, j2));
    }

    public void enqueueUpdateLayout(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mOperations.add(new UpdateLayoutOperation(i2, i3, i4, i5, i6, i7));
    }

    public void enqueueUpdateProperties(int i2, String str, ReactStylesDiffMap reactStylesDiffMap) {
        this.mUpdatePropertiesOperationCount++;
        this.mOperations.add(new UpdatePropertiesOperation(i2, reactStylesDiffMap));
    }

    /* access modifiers changed from: package-private */
    public NativeViewHierarchyManager getNativeViewHierarchyManager() {
        return this.mNativeViewHierarchyManager;
    }

    public Map<String, Long> getProfiledBatchPerfCounters() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.mProfiledBatchCommitStartTime));
        hashMap.put("CommitEndTime", Long.valueOf(this.mProfiledBatchCommitEndTime));
        hashMap.put("LayoutTime", Long.valueOf(this.mProfiledBatchLayoutTime));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mProfiledBatchDispatchViewUpdatesTime));
        hashMap.put("RunStartTime", Long.valueOf(this.mProfiledBatchRunStartTime));
        hashMap.put("RunEndTime", Long.valueOf(this.mProfiledBatchRunEndTime));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.mProfiledBatchBatchedExecutionTime));
        hashMap.put("NonBatchedExecutionTime", Long.valueOf(this.mProfiledBatchNonBatchedExecutionTime));
        hashMap.put("NativeModulesThreadCpuTime", Long.valueOf(this.mThreadCpuTime));
        hashMap.put("CreateViewCount", Long.valueOf(this.mCreateViewCount));
        hashMap.put("UpdatePropsCount", Long.valueOf(this.mUpdatePropertiesOperationCount));
        return hashMap;
    }

    public boolean isEmpty() {
        return this.mOperations.isEmpty() && this.mViewCommandOperations.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void pauseFrameCallback() {
        this.mIsDispatchUIFrameCallbackEnqueued = false;
        ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
        flushPendingBatches();
    }

    public void prependUIBlock(UIBlock uIBlock) {
        this.mOperations.add(0, new UIBlockOperation(uIBlock));
    }

    public void profileNextBatch() {
        this.mIsProfilingNextBatch = true;
        this.mProfiledBatchCommitStartTime = 0;
        this.mCreateViewCount = 0;
        this.mUpdatePropertiesOperationCount = 0;
    }

    /* access modifiers changed from: package-private */
    public void resumeFrameCallback() {
        this.mIsDispatchUIFrameCallbackEnqueued = true;
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    public void setViewHierarchyUpdateDebugListener(NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.mViewHierarchyUpdateDebugListener = notThreadSafeViewHierarchyUpdateDebugListener;
    }

    public void enqueueDispatchCommand(int i2, String str, ReadableArray readableArray) {
        this.mViewCommandOperations.add(new DispatchStringCommandOperation(i2, str, readableArray));
    }
}
