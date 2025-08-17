package com.facebook.react.animated;

import androidx.media3.exoplayer.mediacodec.f;
import com.facebook.fbreact.specs.NativeAnimatedModuleSpec;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.common.ViewUtil;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

@ReactModule(name = "NativeAnimatedModule")
public class NativeAnimatedModule extends NativeAnimatedModuleSpec implements LifecycleEventListener, UIManagerListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean ANIMATED_MODULE_DEBUG = false;
    public static final String NAME = "NativeAnimatedModule";
    /* access modifiers changed from: private */
    public final GuardedFrameCallback mAnimatedFrameCallback;
    private boolean mBatchingControlledByJS = false;
    private volatile long mCurrentBatchNumber;
    private volatile long mCurrentFrameNumber;
    private boolean mInitializedForFabric = false;
    private boolean mInitializedForNonFabric = false;
    private final AtomicReference<NativeAnimatedNodesManager> mNodesManager = new AtomicReference<>();
    private int mNumFabricAnimations = 0;
    private int mNumNonFabricAnimations = 0;
    /* access modifiers changed from: private */
    public final ConcurrentOperationQueue mOperations;
    /* access modifiers changed from: private */
    public final ConcurrentOperationQueue mPreOperations;
    /* access modifiers changed from: private */
    public final ReactChoreographer mReactChoreographer = ReactChoreographer.getInstance();
    private int mUIManagerType = 1;

    private class ConcurrentOperationQueue {
        private UIThreadOperation mPeekedOperation;
        private final Queue<UIThreadOperation> mQueue;
        private boolean mSynchronizedAccess;

        private ConcurrentOperationQueue() {
            this.mQueue = new ConcurrentLinkedQueue();
            this.mPeekedOperation = null;
            this.mSynchronizedAccess = false;
        }

        private List<UIThreadOperation> drainQueueIntoList(long j2) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                UIThreadOperation uIThreadOperation = this.mPeekedOperation;
                if (uIThreadOperation != null) {
                    if (uIThreadOperation.getBatchNumber() > j2) {
                        break;
                    }
                    arrayList.add(this.mPeekedOperation);
                    this.mPeekedOperation = null;
                }
                UIThreadOperation poll = this.mQueue.poll();
                if (poll == null) {
                    break;
                } else if (poll.getBatchNumber() > j2) {
                    this.mPeekedOperation = poll;
                    break;
                } else {
                    arrayList.add(poll);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public void add(UIThreadOperation uIThreadOperation) {
            if (this.mSynchronizedAccess) {
                synchronized (this) {
                    this.mQueue.add(uIThreadOperation);
                }
                return;
            }
            this.mQueue.add(uIThreadOperation);
        }

        /* access modifiers changed from: package-private */
        public void executeBatch(long j2, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
            List<UIThreadOperation> list;
            if (this.mSynchronizedAccess) {
                synchronized (this) {
                    list = drainQueueIntoList(j2);
                }
            } else {
                list = drainQueueIntoList(j2);
            }
            for (UIThreadOperation execute : list) {
                execute.execute(nativeAnimatedNodesManager);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.mQueue.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public void setSynchronizedAccess(boolean z2) {
            this.mSynchronizedAccess = z2;
        }
    }

    private abstract class UIThreadOperation {
        long mBatchNumber;

        private UIThreadOperation() {
            this.mBatchNumber = -1;
        }

        /* access modifiers changed from: package-private */
        public abstract void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager);

        public long getBatchNumber() {
            return this.mBatchNumber;
        }

        public void setBatchNumber(long j2) {
            this.mBatchNumber = j2;
        }
    }

    public NativeAnimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        ConcurrentOperationQueue concurrentOperationQueue = new ConcurrentOperationQueue();
        this.mOperations = concurrentOperationQueue;
        ConcurrentOperationQueue concurrentOperationQueue2 = new ConcurrentOperationQueue();
        this.mPreOperations = concurrentOperationQueue2;
        this.mAnimatedFrameCallback = new GuardedFrameCallback(reactApplicationContext) {
            /* access modifiers changed from: protected */
            public void doFrameGuarded(long j2) {
                try {
                    NativeAnimatedNodesManager access$100 = NativeAnimatedModule.this.getNodesManager();
                    if (access$100 != null && access$100.hasActiveAnimations()) {
                        access$100.runUpdates(j2);
                    }
                    if (access$100 != null || NativeAnimatedModule.this.mReactChoreographer != null) {
                        ((ReactChoreographer) Assertions.assertNotNull(NativeAnimatedModule.this.mReactChoreographer)).postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, NativeAnimatedModule.this.mAnimatedFrameCallback);
                    }
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
        };
        concurrentOperationQueue.setSynchronizedAccess(ReactFeatureFlags.enableSynchronizationForAnimated);
        concurrentOperationQueue2.setSynchronizedAccess(ReactFeatureFlags.enableSynchronizationForAnimated);
    }

    private void addOperation(UIThreadOperation uIThreadOperation) {
        uIThreadOperation.setBatchNumber(this.mCurrentBatchNumber);
        this.mOperations.add(uIThreadOperation);
    }

    private void addPreOperation(UIThreadOperation uIThreadOperation) {
        uIThreadOperation.setBatchNumber(this.mCurrentBatchNumber);
        this.mPreOperations.add(uIThreadOperation);
    }

    private void addUnbatchedOperation(UIThreadOperation uIThreadOperation) {
        uIThreadOperation.setBatchNumber(-1);
        this.mOperations.add(uIThreadOperation);
    }

    private void clearFrameCallback() {
        ((ReactChoreographer) Assertions.assertNotNull(this.mReactChoreographer)).removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
    }

    private void decrementInFlightAnimationsForViewTag(int i2) {
        if (ViewUtil.getUIManagerType(i2) == 2) {
            this.mNumFabricAnimations--;
        } else {
            this.mNumNonFabricAnimations--;
        }
        int i3 = this.mNumNonFabricAnimations;
        if (i3 == 0 && this.mNumFabricAnimations > 0 && this.mUIManagerType != 2) {
            this.mUIManagerType = 2;
        } else if (this.mNumFabricAnimations == 0 && i3 > 0 && this.mUIManagerType != 1) {
            this.mUIManagerType = 1;
        }
    }

    private void enqueueFrameCallback() {
        ((ReactChoreographer) Assertions.assertNotNull(this.mReactChoreographer)).postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
    }

    /* access modifiers changed from: private */
    public NativeAnimatedNodesManager getNodesManager() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn;
        if (this.mNodesManager.get() == null && (reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn()) != null) {
            f.a(this.mNodesManager, (Object) null, new NativeAnimatedNodesManager(reactApplicationContextIfActiveOrWarn));
        }
        return this.mNodesManager.get();
    }

    private void initializeLifecycleEventListenersForViewTag(int i2) {
        ReactApplicationContext reactApplicationContext;
        UIManager uIManager;
        int uIManagerType = ViewUtil.getUIManagerType(i2);
        this.mUIManagerType = uIManagerType;
        if (uIManagerType == 2) {
            this.mNumFabricAnimations++;
        } else {
            this.mNumNonFabricAnimations++;
        }
        NativeAnimatedNodesManager nodesManager = getNodesManager();
        if (nodesManager != null) {
            nodesManager.initializeEventListenerForUIManagerType(this.mUIManagerType);
        } else {
            ReactSoftExceptionLogger.logSoftException(NAME, new RuntimeException("initializeLifecycleEventListenersForViewTag could not get NativeAnimatedNodesManager"));
        }
        if (this.mInitializedForFabric && this.mUIManagerType == 2) {
            return;
        }
        if ((!this.mInitializedForNonFabric || this.mUIManagerType != 1) && (reactApplicationContext = getReactApplicationContext()) != null && (uIManager = UIManagerHelper.getUIManager(reactApplicationContext, this.mUIManagerType)) != null) {
            uIManager.addUIManagerEventListener(this);
            if (this.mUIManagerType == 2) {
                this.mInitializedForFabric = true;
            } else {
                this.mInitializedForNonFabric = true;
            }
        }
    }

    public void addAnimatedEventToView(double d2, final String str, final ReadableMap readableMap) {
        final int i2 = (int) d2;
        initializeLifecycleEventListenersForViewTag(i2);
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.addAnimatedEventToView(i2, str, readableMap);
            }
        });
    }

    public void addListener(String str) {
    }

    public void connectAnimatedNodeToView(double d2, double d3) {
        final int i2 = (int) d2;
        final int i3 = (int) d3;
        initializeLifecycleEventListenersForViewTag(i3);
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.connectAnimatedNodeToView(i2, i3);
            }
        });
    }

    public void connectAnimatedNodes(double d2, double d3) {
        final int i2 = (int) d2;
        final int i3 = (int) d3;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.connectAnimatedNodes(i2, i3);
            }
        });
    }

    public void createAnimatedNode(double d2, final ReadableMap readableMap) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.createAnimatedNode(i2, readableMap);
            }
        });
    }

    public void didDispatchMountItems(UIManager uIManager) {
        if (this.mUIManagerType == 2) {
            long j2 = this.mCurrentBatchNumber - 1;
            if (!this.mBatchingControlledByJS) {
                this.mCurrentFrameNumber++;
                if (this.mCurrentFrameNumber - this.mCurrentBatchNumber > 2) {
                    this.mCurrentBatchNumber = this.mCurrentFrameNumber;
                    j2 = this.mCurrentBatchNumber;
                }
            }
            this.mPreOperations.executeBatch(j2, getNodesManager());
            this.mOperations.executeBatch(j2, getNodesManager());
        }
    }

    public void didScheduleMountItems(UIManager uIManager) {
        this.mCurrentFrameNumber++;
    }

    public void disconnectAnimatedNodeFromView(double d2, double d3) {
        final int i2 = (int) d2;
        final int i3 = (int) d3;
        decrementInFlightAnimationsForViewTag(i3);
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.disconnectAnimatedNodeFromView(i2, i3);
            }
        });
    }

    public void disconnectAnimatedNodes(double d2, double d3) {
        final int i2 = (int) d2;
        final int i3 = (int) d3;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.disconnectAnimatedNodes(i2, i3);
            }
        });
    }

    public void dropAnimatedNode(double d2) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.dropAnimatedNode(i2);
            }
        });
    }

    public void extractAnimatedNodeOffset(double d2) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.extractAnimatedNodeOffset(i2);
            }
        });
    }

    public void finishOperationBatch() {
        this.mBatchingControlledByJS = true;
        this.mCurrentBatchNumber++;
    }

    public void flattenAnimatedNodeOffset(double d2) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.flattenAnimatedNodeOffset(i2);
            }
        });
    }

    public String getName() {
        return NAME;
    }

    public void getValue(double d2, final Callback callback) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.getValue(i2, callback);
            }
        });
    }

    public void initialize() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.addLifecycleEventListener(this);
        }
    }

    public void invalidate() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.removeLifecycleEventListener(this);
        }
    }

    public void onHostDestroy() {
        clearFrameCallback();
    }

    public void onHostPause() {
        clearFrameCallback();
    }

    public void onHostResume() {
        enqueueFrameCallback();
    }

    public void removeAnimatedEventFromView(double d2, final String str, double d3) {
        final int i2 = (int) d2;
        final int i3 = (int) d3;
        decrementInFlightAnimationsForViewTag(i2);
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.removeAnimatedEventFromView(i2, str, i3);
            }
        });
    }

    public void removeListeners(double d2) {
    }

    public void restoreDefaultValues(double d2) {
        final int i2 = (int) d2;
        addPreOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.restoreDefaultValues(i2);
            }
        });
    }

    public void setAnimatedNodeOffset(double d2, final double d3) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.setAnimatedNodeOffset(i2, d3);
            }
        });
    }

    public void setAnimatedNodeValue(double d2, final double d3) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.setAnimatedNodeValue(i2, d3);
            }
        });
    }

    @VisibleForTesting
    public void setNodesManager(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        this.mNodesManager.set(nativeAnimatedNodesManager);
    }

    public void startAnimatingNode(double d2, double d3, ReadableMap readableMap, Callback callback) {
        final int i2 = (int) d2;
        final int i3 = (int) d3;
        final ReadableMap readableMap2 = readableMap;
        final Callback callback2 = callback;
        addUnbatchedOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.startAnimatingNode(i2, i3, readableMap2, callback2);
            }
        });
    }

    public void startListeningToAnimatedNodeValue(double d2) {
        final int i2 = (int) d2;
        final AnonymousClass6 r3 = new AnimatedNodeValueListener() {
            public void onValueUpdate(double d2) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("tag", i2);
                createMap.putDouble(AppMeasurementSdk.ConditionalUserProperty.VALUE, d2);
                ReactApplicationContext access$700 = NativeAnimatedModule.this.getReactApplicationContextIfActiveOrWarn();
                if (access$700 != null) {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) access$700.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onAnimatedValueUpdate", createMap);
                }
            }
        };
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.startListeningToAnimatedNodeValue(i2, r3);
            }
        });
    }

    public void startOperationBatch() {
        this.mBatchingControlledByJS = true;
        this.mCurrentBatchNumber++;
    }

    public void stopAnimation(double d2) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.stopAnimation(i2);
            }
        });
    }

    public void stopListeningToAnimatedNodeValue(double d2) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.stopListeningToAnimatedNodeValue(i2);
            }
        });
    }

    public void updateAnimatedNodeConfig(double d2, final ReadableMap readableMap) {
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.updateAnimatedNodeConfig(i2, readableMap);
            }
        });
    }

    public void willDispatchViewUpdates(UIManager uIManager) {
        if ((!this.mOperations.isEmpty() || !this.mPreOperations.isEmpty()) && this.mUIManagerType != 2) {
            final long j2 = this.mCurrentBatchNumber;
            this.mCurrentBatchNumber = 1 + j2;
            AnonymousClass2 r2 = new UIBlock() {
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    NativeAnimatedModule.this.mPreOperations.executeBatch(j2, NativeAnimatedModule.this.getNodesManager());
                }
            };
            AnonymousClass3 r3 = new UIBlock() {
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    NativeAnimatedModule.this.mOperations.executeBatch(j2, NativeAnimatedModule.this.getNodesManager());
                }
            };
            UIManagerModule uIManagerModule = (UIManagerModule) uIManager;
            uIManagerModule.prependUIBlock(r2);
            uIManagerModule.addUIBlock(r3);
        }
    }
}
