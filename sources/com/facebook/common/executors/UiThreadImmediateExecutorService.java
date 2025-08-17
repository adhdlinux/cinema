package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl {
    private static UiThreadImmediateExecutorService sInstance;

    private UiThreadImmediateExecutorService() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static UiThreadImmediateExecutorService getInstance() {
        if (sInstance == null) {
            sInstance = new UiThreadImmediateExecutorService();
        }
        return sInstance;
    }

    public void execute(Runnable runnable) {
        if (isHandlerThread()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
