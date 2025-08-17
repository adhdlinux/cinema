package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.core.ChoreographerCompat;
import java.util.ArrayDeque;

public class ReactChoreographer {
    private static ReactChoreographer sInstance;
    /* access modifiers changed from: private */
    public final ArrayDeque<ChoreographerCompat.FrameCallback>[] mCallbackQueues;
    /* access modifiers changed from: private */
    public final Object mCallbackQueuesLock = new Object();
    /* access modifiers changed from: private */
    public volatile ChoreographerCompat mChoreographer;
    /* access modifiers changed from: private */
    public boolean mHasPostedCallback;
    private final ReactChoreographerDispatcher mReactChoreographerDispatcher;
    private int mTotalCallbacks;

    public enum CallbackType {
        PERF_MARKERS(0),
        DISPATCH_UI(1),
        NATIVE_ANIMATED_MODULE(2),
        TIMERS_EVENTS(3),
        IDLE_EVENT(4);
        
        private final int mOrder;

        private CallbackType(int i2) {
            this.mOrder = i2;
        }

        /* access modifiers changed from: package-private */
        public int getOrder() {
            return this.mOrder;
        }
    }

    private class ReactChoreographerDispatcher extends ChoreographerCompat.FrameCallback {
        private ReactChoreographerDispatcher() {
        }

        public void doFrame(long j2) {
            synchronized (ReactChoreographer.this.mCallbackQueuesLock) {
                boolean unused = ReactChoreographer.this.mHasPostedCallback = false;
                for (ArrayDeque arrayDeque : ReactChoreographer.this.mCallbackQueues) {
                    int size = arrayDeque.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ChoreographerCompat.FrameCallback frameCallback = (ChoreographerCompat.FrameCallback) arrayDeque.pollFirst();
                        if (frameCallback != null) {
                            frameCallback.doFrame(j2);
                            ReactChoreographer.access$610(ReactChoreographer.this);
                        } else {
                            FLog.e(ReactConstants.TAG, "Tried to execute non-existent frame callback");
                        }
                    }
                }
                ReactChoreographer.this.maybeRemoveFrameCallback();
            }
        }
    }

    private ReactChoreographer() {
        int i2 = 0;
        this.mTotalCallbacks = 0;
        this.mHasPostedCallback = false;
        this.mReactChoreographerDispatcher = new ReactChoreographerDispatcher();
        this.mCallbackQueues = new ArrayDeque[CallbackType.values().length];
        while (true) {
            ArrayDeque<ChoreographerCompat.FrameCallback>[] arrayDequeArr = this.mCallbackQueues;
            if (i2 < arrayDequeArr.length) {
                arrayDequeArr[i2] = new ArrayDeque<>();
                i2++;
            } else {
                initializeChoreographer((Runnable) null);
                return;
            }
        }
    }

    static /* synthetic */ int access$610(ReactChoreographer reactChoreographer) {
        int i2 = reactChoreographer.mTotalCallbacks;
        reactChoreographer.mTotalCallbacks = i2 - 1;
        return i2;
    }

    public static ReactChoreographer getInstance() {
        Assertions.assertNotNull(sInstance, "ReactChoreographer needs to be initialized.");
        return sInstance;
    }

    public static void initialize() {
        if (sInstance == null) {
            sInstance = new ReactChoreographer();
        }
    }

    /* access modifiers changed from: private */
    public void maybeRemoveFrameCallback() {
        boolean z2;
        if (this.mTotalCallbacks >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.assertCondition(z2);
        if (this.mTotalCallbacks == 0 && this.mHasPostedCallback) {
            if (this.mChoreographer != null) {
                this.mChoreographer.removeFrameCallback(this.mReactChoreographerDispatcher);
            }
            this.mHasPostedCallback = false;
        }
    }

    /* access modifiers changed from: private */
    public void postFrameCallbackOnChoreographer() {
        this.mChoreographer.postFrameCallback(this.mReactChoreographerDispatcher);
        this.mHasPostedCallback = true;
    }

    public void initializeChoreographer(final Runnable runnable) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                synchronized (ReactChoreographer.class) {
                    if (ReactChoreographer.this.mChoreographer == null) {
                        ChoreographerCompat unused = ReactChoreographer.this.mChoreographer = ChoreographerCompat.getInstance();
                    }
                }
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    public void postFrameCallback(CallbackType callbackType, ChoreographerCompat.FrameCallback frameCallback) {
        synchronized (this.mCallbackQueuesLock) {
            this.mCallbackQueues[callbackType.getOrder()].addLast(frameCallback);
            boolean z2 = true;
            int i2 = this.mTotalCallbacks + 1;
            this.mTotalCallbacks = i2;
            if (i2 <= 0) {
                z2 = false;
            }
            Assertions.assertCondition(z2);
            if (!this.mHasPostedCallback) {
                if (this.mChoreographer == null) {
                    initializeChoreographer(new Runnable() {
                        public void run() {
                            ReactChoreographer.this.postFrameCallbackOnChoreographer();
                        }
                    });
                } else {
                    postFrameCallbackOnChoreographer();
                }
            }
        }
    }

    public void removeFrameCallback(CallbackType callbackType, ChoreographerCompat.FrameCallback frameCallback) {
        synchronized (this.mCallbackQueuesLock) {
            if (this.mCallbackQueues[callbackType.getOrder()].removeFirstOccurrence(frameCallback)) {
                this.mTotalCallbacks--;
                maybeRemoveFrameCallback();
            } else {
                FLog.e(ReactConstants.TAG, "Tried to remove non-existent frame callback");
            }
        }
    }
}
