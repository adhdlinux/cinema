package com.facebook.react.modules.core;

import com.facebook.fbreact.specs.NativeTimingSpec;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "Timing")
public final class TimingModule extends NativeTimingSpec implements LifecycleEventListener, HeadlessJsTaskEventListener {
    public static final String NAME = "Timing";
    private final JavaTimerManager mJavaTimerManager;

    public class BridgeTimerExecutor implements JavaScriptTimerExecutor {
        public BridgeTimerExecutor() {
        }

        public void callIdleCallbacks(double d2) {
            ReactApplicationContext access$100 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (access$100 != null) {
                ((JSTimers) access$100.getJSModule(JSTimers.class)).callIdleCallbacks(d2);
            }
        }

        public void callTimers(WritableArray writableArray) {
            ReactApplicationContext access$000 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (access$000 != null) {
                ((JSTimers) access$000.getJSModule(JSTimers.class)).callTimers(writableArray);
            }
        }

        public void emitTimeDriftWarning(String str) {
            ReactApplicationContext access$200 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (access$200 != null) {
                ((JSTimers) access$200.getJSModule(JSTimers.class)).emitTimeDriftWarning(str);
            }
        }
    }

    public TimingModule(ReactApplicationContext reactApplicationContext, DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        this.mJavaTimerManager = new JavaTimerManager(reactApplicationContext, new BridgeTimerExecutor(), ReactChoreographer.getInstance(), devSupportManager);
    }

    public void createTimer(double d2, double d3, double d4, boolean z2) {
        this.mJavaTimerManager.createAndMaybeCallTimer((int) d2, (int) d3, d4, z2);
    }

    public void deleteTimer(double d2) {
        this.mJavaTimerManager.deleteTimer((int) d2);
    }

    public String getName() {
        return NAME;
    }

    @VisibleForTesting
    public boolean hasActiveTimersInRange(long j2) {
        return this.mJavaTimerManager.hasActiveTimersInRange(j2);
    }

    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
        HeadlessJsTaskContext.getInstance(getReactApplicationContext()).addTaskEventListener(this);
    }

    public void invalidate() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        HeadlessJsTaskContext.getInstance(reactApplicationContext).removeTaskEventListener(this);
        this.mJavaTimerManager.onInstanceDestroy();
        reactApplicationContext.removeLifecycleEventListener(this);
    }

    public void onHeadlessJsTaskFinish(int i2) {
        this.mJavaTimerManager.onHeadlessJsTaskFinish(i2);
    }

    public void onHeadlessJsTaskStart(int i2) {
        this.mJavaTimerManager.onHeadlessJsTaskStart(i2);
    }

    public void onHostDestroy() {
        this.mJavaTimerManager.onHostDestroy();
    }

    public void onHostPause() {
        this.mJavaTimerManager.onHostPause();
    }

    public void onHostResume() {
        this.mJavaTimerManager.onHostResume();
    }

    public void setSendIdleEvents(boolean z2) {
        this.mJavaTimerManager.setSendIdleEvents(z2);
    }
}
