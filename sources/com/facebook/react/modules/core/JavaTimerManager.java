package com.facebook.react.modules.core;

import android.util.SparseArray;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.SystemClock;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ReactChoreographer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class JavaTimerManager {
    private static final float FRAME_DURATION_MS = 16.666666f;
    private static final float IDLE_CALLBACK_FRAME_DEADLINE_MS = 1.0f;
    /* access modifiers changed from: private */
    public final AtomicBoolean isPaused = new AtomicBoolean(true);
    /* access modifiers changed from: private */
    public final AtomicBoolean isRunningTasks = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public IdleCallbackRunnable mCurrentIdleCallbackRunnable;
    private final DevSupportManager mDevSupportManager;
    private boolean mFrameCallbackPosted = false;
    private boolean mFrameIdleCallbackPosted = false;
    /* access modifiers changed from: private */
    public final Object mIdleCallbackGuard = new Object();
    private final IdleFrameCallback mIdleFrameCallback = new IdleFrameCallback();
    /* access modifiers changed from: private */
    public final JavaScriptTimerExecutor mJavaScriptTimerExecutor;
    /* access modifiers changed from: private */
    public final ReactApplicationContext mReactApplicationContext;
    /* access modifiers changed from: private */
    public final ReactChoreographer mReactChoreographer;
    /* access modifiers changed from: private */
    public boolean mSendIdleEvents = false;
    private final TimerFrameCallback mTimerFrameCallback = new TimerFrameCallback();
    /* access modifiers changed from: private */
    public final Object mTimerGuard = new Object();
    /* access modifiers changed from: private */
    public final SparseArray<Timer> mTimerIdsToTimers;
    /* access modifiers changed from: private */
    public final PriorityQueue<Timer> mTimers;

    private class IdleCallbackRunnable implements Runnable {
        private volatile boolean mCancelled = false;
        private final long mFrameStartTime;

        public IdleCallbackRunnable(long j2) {
            this.mFrameStartTime = j2;
        }

        public void cancel() {
            this.mCancelled = true;
        }

        public void run() {
            boolean access$1400;
            if (!this.mCancelled) {
                long uptimeMillis = SystemClock.uptimeMillis() - (this.mFrameStartTime / 1000000);
                long currentTimeMillis = SystemClock.currentTimeMillis() - uptimeMillis;
                if (JavaTimerManager.FRAME_DURATION_MS - ((float) uptimeMillis) >= 1.0f) {
                    synchronized (JavaTimerManager.this.mIdleCallbackGuard) {
                        access$1400 = JavaTimerManager.this.mSendIdleEvents;
                    }
                    if (access$1400) {
                        JavaTimerManager.this.mJavaScriptTimerExecutor.callIdleCallbacks((double) currentTimeMillis);
                    }
                    IdleCallbackRunnable unused = JavaTimerManager.this.mCurrentIdleCallbackRunnable = null;
                }
            }
        }
    }

    private class IdleFrameCallback extends ChoreographerCompat.FrameCallback {
        private IdleFrameCallback() {
        }

        public void doFrame(long j2) {
            if (!JavaTimerManager.this.isPaused.get() || JavaTimerManager.this.isRunningTasks.get()) {
                if (JavaTimerManager.this.mCurrentIdleCallbackRunnable != null) {
                    JavaTimerManager.this.mCurrentIdleCallbackRunnable.cancel();
                }
                JavaTimerManager javaTimerManager = JavaTimerManager.this;
                IdleCallbackRunnable unused = javaTimerManager.mCurrentIdleCallbackRunnable = new IdleCallbackRunnable(j2);
                JavaTimerManager.this.mReactApplicationContext.runOnJSQueueThread(JavaTimerManager.this.mCurrentIdleCallbackRunnable);
                JavaTimerManager.this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this);
            }
        }
    }

    private static class Timer {
        /* access modifiers changed from: private */
        public final int mCallbackID;
        /* access modifiers changed from: private */
        public final int mInterval;
        /* access modifiers changed from: private */
        public final boolean mRepeat;
        /* access modifiers changed from: private */
        public long mTargetTime;

        private Timer(int i2, long j2, int i3, boolean z2) {
            this.mCallbackID = i2;
            this.mTargetTime = j2;
            this.mInterval = i3;
            this.mRepeat = z2;
        }
    }

    private class TimerFrameCallback extends ChoreographerCompat.FrameCallback {
        private WritableArray mTimersToCall;

        private TimerFrameCallback() {
            this.mTimersToCall = null;
        }

        public void doFrame(long j2) {
            if (!JavaTimerManager.this.isPaused.get() || JavaTimerManager.this.isRunningTasks.get()) {
                long j3 = j2 / 1000000;
                synchronized (JavaTimerManager.this.mTimerGuard) {
                    while (!JavaTimerManager.this.mTimers.isEmpty() && ((Timer) JavaTimerManager.this.mTimers.peek()).mTargetTime < j3) {
                        Timer timer = (Timer) JavaTimerManager.this.mTimers.poll();
                        if (this.mTimersToCall == null) {
                            this.mTimersToCall = Arguments.createArray();
                        }
                        this.mTimersToCall.pushInt(timer.mCallbackID);
                        if (timer.mRepeat) {
                            long unused = timer.mTargetTime = ((long) timer.mInterval) + j3;
                            JavaTimerManager.this.mTimers.add(timer);
                        } else {
                            JavaTimerManager.this.mTimerIdsToTimers.remove(timer.mCallbackID);
                        }
                    }
                }
                if (this.mTimersToCall != null) {
                    JavaTimerManager.this.mJavaScriptTimerExecutor.callTimers(this.mTimersToCall);
                    this.mTimersToCall = null;
                }
                JavaTimerManager.this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this);
            }
        }
    }

    public JavaTimerManager(ReactApplicationContext reactApplicationContext, JavaScriptTimerExecutor javaScriptTimerExecutor, ReactChoreographer reactChoreographer, DevSupportManager devSupportManager) {
        this.mReactApplicationContext = reactApplicationContext;
        this.mJavaScriptTimerExecutor = javaScriptTimerExecutor;
        this.mReactChoreographer = reactChoreographer;
        this.mDevSupportManager = devSupportManager;
        this.mTimers = new PriorityQueue<>(11, new Comparator<Timer>() {
            public int compare(Timer timer, Timer timer2) {
                int i2 = ((timer.mTargetTime - timer2.mTargetTime) > 0 ? 1 : ((timer.mTargetTime - timer2.mTargetTime) == 0 ? 0 : -1));
                if (i2 == 0) {
                    return 0;
                }
                return i2 < 0 ? -1 : 1;
            }
        });
        this.mTimerIdsToTimers = new SparseArray<>();
    }

    /* access modifiers changed from: private */
    public void clearChoreographerIdleCallback() {
        if (this.mFrameIdleCallbackPosted) {
            this.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this.mIdleFrameCallback);
            this.mFrameIdleCallbackPosted = false;
        }
    }

    private void clearFrameCallback() {
        HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(this.mReactApplicationContext);
        if (this.mFrameCallbackPosted && this.isPaused.get() && !instance.hasActiveTasks()) {
            this.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.mTimerFrameCallback);
            this.mFrameCallbackPosted = false;
        }
    }

    private static boolean isTimerInRange(Timer timer, long j2) {
        return !timer.mRepeat && ((long) timer.mInterval) < j2;
    }

    private void maybeIdleCallback() {
        if (this.isPaused.get() && !this.isRunningTasks.get()) {
            clearFrameCallback();
        }
    }

    private void maybeSetChoreographerIdleCallback() {
        synchronized (this.mIdleCallbackGuard) {
            if (this.mSendIdleEvents) {
                setChoreographerIdleCallback();
            }
        }
    }

    private void setChoreographerCallback() {
        if (!this.mFrameCallbackPosted) {
            this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.mTimerFrameCallback);
            this.mFrameCallbackPosted = true;
        }
    }

    /* access modifiers changed from: private */
    public void setChoreographerIdleCallback() {
        if (!this.mFrameIdleCallbackPosted) {
            this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this.mIdleFrameCallback);
            this.mFrameIdleCallbackPosted = true;
        }
    }

    public void createAndMaybeCallTimer(int i2, int i3, double d2, boolean z2) {
        long currentTimeMillis = SystemClock.currentTimeMillis();
        long j2 = (long) d2;
        if (this.mDevSupportManager.getDevSupportEnabled() && Math.abs(j2 - currentTimeMillis) > 60000) {
            this.mJavaScriptTimerExecutor.emitTimeDriftWarning("Debugger and device times have drifted by more than 60s. Please correct this by running adb shell \"date `date +%m%d%H%M%Y.%S`\" on your debugger machine.");
        }
        long max = Math.max(0, (j2 - currentTimeMillis) + ((long) i3));
        if (i3 != 0 || z2) {
            createTimer(i2, max, z2);
            return;
        }
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i2);
        this.mJavaScriptTimerExecutor.callTimers(createArray);
    }

    @DoNotStrip
    public void createTimer(int i2, long j2, boolean z2) {
        Timer timer = new Timer(i2, (SystemClock.nanoTime() / 1000000) + j2, (int) j2, z2);
        synchronized (this.mTimerGuard) {
            this.mTimers.add(timer);
            this.mTimerIdsToTimers.put(i2, timer);
        }
    }

    @DoNotStrip
    public void deleteTimer(int i2) {
        synchronized (this.mTimerGuard) {
            Timer timer = this.mTimerIdsToTimers.get(i2);
            if (timer != null) {
                this.mTimerIdsToTimers.remove(i2);
                this.mTimers.remove(timer);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasActiveTimersInRange(long j2) {
        synchronized (this.mTimerGuard) {
            Timer peek = this.mTimers.peek();
            if (peek == null) {
                return false;
            }
            if (isTimerInRange(peek, j2)) {
                return true;
            }
            Iterator<Timer> it2 = this.mTimers.iterator();
            while (it2.hasNext()) {
                if (isTimerInRange(it2.next(), j2)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void onHeadlessJsTaskFinish(int i2) {
        if (!HeadlessJsTaskContext.getInstance(this.mReactApplicationContext).hasActiveTasks()) {
            this.isRunningTasks.set(false);
            clearFrameCallback();
            maybeIdleCallback();
        }
    }

    public void onHeadlessJsTaskStart(int i2) {
        if (!this.isRunningTasks.getAndSet(true)) {
            setChoreographerCallback();
            maybeSetChoreographerIdleCallback();
        }
    }

    public void onHostDestroy() {
        clearFrameCallback();
        maybeIdleCallback();
    }

    public void onHostPause() {
        this.isPaused.set(true);
        clearFrameCallback();
        maybeIdleCallback();
    }

    public void onHostResume() {
        this.isPaused.set(false);
        setChoreographerCallback();
        maybeSetChoreographerIdleCallback();
    }

    public void onInstanceDestroy() {
        clearFrameCallback();
        clearChoreographerIdleCallback();
    }

    @DoNotStrip
    public void setSendIdleEvents(final boolean z2) {
        synchronized (this.mIdleCallbackGuard) {
            this.mSendIdleEvents = z2;
        }
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                synchronized (JavaTimerManager.this.mIdleCallbackGuard) {
                    if (z2) {
                        JavaTimerManager.this.setChoreographerIdleCallback();
                    } else {
                        JavaTimerManager.this.clearChoreographerIdleCallback();
                    }
                }
            }
        });
    }
}
