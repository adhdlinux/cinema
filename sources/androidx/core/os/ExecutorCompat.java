package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class ExecutorCompat {

    private static class HandlerExecutor implements Executor {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f2614b;

        HandlerExecutor(Handler handler) {
            this.f2614b = (Handler) Preconditions.g(handler);
        }

        public void execute(Runnable runnable) {
            if (!this.f2614b.post((Runnable) Preconditions.g(runnable))) {
                throw new RejectedExecutionException(this.f2614b + " is shutting down");
            }
        }
    }

    private ExecutorCompat() {
    }

    public static Executor a(Handler handler) {
        return new HandlerExecutor(handler);
    }
}
