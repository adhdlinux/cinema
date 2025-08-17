package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "HeadlessJsTaskSupport")
public class HeadlessJsTaskSupportModule extends NativeHeadlessJsTaskSupportSpec {
    public static final String NAME = "HeadlessJsTaskSupport";

    public HeadlessJsTaskSupportModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return NAME;
    }

    public void notifyTaskFinished(double d2) {
        int i2 = (int) d2;
        HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(getReactApplicationContext());
        if (instance.isTaskRunning(i2)) {
            instance.finishTask(i2);
            return;
        }
        FLog.w((Class<?>) HeadlessJsTaskSupportModule.class, "Tried to finish non-active task with id %d. Did it time out?", Integer.valueOf(i2));
    }

    public void notifyTaskRetry(double d2, Promise promise) {
        int i2 = (int) d2;
        HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(getReactApplicationContext());
        if (instance.isTaskRunning(i2)) {
            promise.resolve(Boolean.valueOf(instance.retryTask(i2)));
            return;
        }
        FLog.w((Class<?>) HeadlessJsTaskSupportModule.class, "Tried to retry non-active task with id %d. Did it time out?", Integer.valueOf(i2));
        promise.resolve(Boolean.FALSE);
    }
}
