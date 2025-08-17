package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1562a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f1563b = Executors.newFixedThreadPool(4, new ThreadFactory() {

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f1565b = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f1565b.getAndIncrement())}));
            return thread;
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private volatile Handler f1564c;

    private static Handler d(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    public void a(Runnable runnable) {
        this.f1563b.execute(runnable);
    }

    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void c(Runnable runnable) {
        if (this.f1564c == null) {
            synchronized (this.f1562a) {
                if (this.f1564c == null) {
                    this.f1564c = d(Looper.getMainLooper());
                }
            }
        }
        this.f1564c.post(runnable);
    }
}
