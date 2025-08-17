package com.facebook.react.uimanager.events;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ReactChoreographer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class LockFreeEventDispatcherImpl implements EventDispatcher, LifecycleEventListener {
    private final boolean DEBUG_MODE = false;
    private final String TAG = LockFreeEventDispatcherImpl.class.getSimpleName();
    /* access modifiers changed from: private */
    public final ScheduleDispatchFrameCallback mCurrentFrameCallback = new ScheduleDispatchFrameCallback();
    private final CopyOnWriteArrayList<EventDispatcherListener> mListeners = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<BatchEventDispatchedListener> mPostEventDispatchListeners = new CopyOnWriteArrayList<>();
    /* access modifiers changed from: private */
    public final ReactApplicationContext mReactContext;
    private volatile ReactEventEmitter mReactEventEmitter;

    private class ScheduleDispatchFrameCallback extends ChoreographerCompat.FrameCallback {
        private volatile boolean mIsPosted;
        private boolean mShouldStop;

        private ScheduleDispatchFrameCallback() {
            this.mIsPosted = false;
            this.mShouldStop = false;
        }

        private void post() {
            ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, LockFreeEventDispatcherImpl.this.mCurrentFrameCallback);
        }

        public void doFrame(long j2) {
            UiThreadUtil.assertOnUiThread();
            if (this.mShouldStop) {
                this.mIsPosted = false;
            } else {
                post();
            }
            LockFreeEventDispatcherImpl.this.driveEventBeats();
        }

        public void maybePost() {
            if (!this.mIsPosted) {
                this.mIsPosted = true;
                post();
            }
        }

        public void maybePostFromNonUI() {
            if (!this.mIsPosted) {
                if (LockFreeEventDispatcherImpl.this.mReactContext.isOnUiQueueThread()) {
                    maybePost();
                } else {
                    LockFreeEventDispatcherImpl.this.mReactContext.runOnUiQueueThread(new Runnable() {
                        public void run() {
                            ScheduleDispatchFrameCallback.this.maybePost();
                        }
                    });
                }
            }
        }

        public void resume() {
            this.mShouldStop = false;
            maybePost();
        }

        public void stop() {
            this.mShouldStop = true;
        }
    }

    public LockFreeEventDispatcherImpl(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
        this.mReactEventEmitter = new ReactEventEmitter(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    public void driveEventBeats() {
        Iterator<BatchEventDispatchedListener> it2 = this.mPostEventDispatchListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onBatchEventDispatched();
        }
    }

    private void maybePostFrameCallbackFromNonUI() {
        if (this.mReactEventEmitter != null) {
            this.mCurrentFrameCallback.maybePostFromNonUI();
        }
    }

    /* access modifiers changed from: private */
    public void stopFrameCallback() {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentFrameCallback.stop();
    }

    public void addBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener) {
        this.mPostEventDispatchListeners.add(batchEventDispatchedListener);
    }

    public void addListener(EventDispatcherListener eventDispatcherListener) {
        this.mListeners.add(eventDispatcherListener);
    }

    public void dispatchAllEvents() {
        maybePostFrameCallbackFromNonUI();
    }

    public void dispatchEvent(Event event) {
        Assertions.assertCondition(event.isInitialized(), "Dispatched event hasn't been initialized");
        Assertions.assertNotNull(this.mReactEventEmitter);
        Iterator<EventDispatcherListener> it2 = this.mListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onEventDispatch(event);
        }
        event.dispatchModern(this.mReactEventEmitter);
        event.dispose();
    }

    public void onCatalystInstanceDestroyed() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                LockFreeEventDispatcherImpl.this.stopFrameCallback();
            }
        });
    }

    public void onHostDestroy() {
        stopFrameCallback();
    }

    public void onHostPause() {
        stopFrameCallback();
    }

    public void onHostResume() {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentFrameCallback.resume();
    }

    public void registerEventEmitter(int i2, RCTEventEmitter rCTEventEmitter) {
        this.mReactEventEmitter.register(i2, rCTEventEmitter);
    }

    public void removeBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener) {
        this.mPostEventDispatchListeners.remove(batchEventDispatchedListener);
    }

    public void removeListener(EventDispatcherListener eventDispatcherListener) {
        this.mListeners.remove(eventDispatcherListener);
    }

    public void unregisterEventEmitter(int i2) {
        this.mReactEventEmitter.unregister(i2);
    }

    public void registerEventEmitter(int i2, RCTModernEventEmitter rCTModernEventEmitter) {
        this.mReactEventEmitter.register(i2, rCTModernEventEmitter);
    }
}
