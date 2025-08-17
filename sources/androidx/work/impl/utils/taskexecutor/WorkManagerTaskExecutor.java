package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.work.impl.utils.SerialExecutor;
import java.util.concurrent.Executor;

public class WorkManagerTaskExecutor implements TaskExecutor {

    /* renamed from: a  reason: collision with root package name */
    private final SerialExecutor f12672a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f12673b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final Executor f12674c = new Executor() {
        public void execute(Runnable runnable) {
            WorkManagerTaskExecutor.this.c(runnable);
        }
    };

    public WorkManagerTaskExecutor(Executor executor) {
        this.f12672a = new SerialExecutor(executor);
    }

    public Executor a() {
        return this.f12674c;
    }

    public void b(Runnable runnable) {
        this.f12672a.execute(runnable);
    }

    public void c(Runnable runnable) {
        this.f12673b.post(runnable);
    }

    public SerialExecutor getBackgroundExecutor() {
        return this.f12672a;
    }
}
