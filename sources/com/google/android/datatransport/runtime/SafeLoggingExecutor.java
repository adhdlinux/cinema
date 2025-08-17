package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;

class SafeLoggingExecutor implements Executor {

    /* renamed from: b  reason: collision with root package name */
    private final Executor f22515b;

    static class SafeLoggingRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f22516b;

        SafeLoggingRunnable(Runnable runnable) {
            this.f22516b = runnable;
        }

        public void run() {
            try {
                this.f22516b.run();
            } catch (Exception e2) {
                Logging.c("Executor", "Background execution failure.", e2);
            }
        }
    }

    SafeLoggingExecutor(Executor executor) {
        this.f22515b = executor;
    }

    public void execute(Runnable runnable) {
        this.f22515b.execute(new SafeLoggingRunnable(runnable));
    }
}
