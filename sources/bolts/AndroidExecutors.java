package bolts;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class AndroidExecutors {

    /* renamed from: b  reason: collision with root package name */
    private static final AndroidExecutors f12777b = new AndroidExecutors();

    /* renamed from: c  reason: collision with root package name */
    private static final int f12778c;

    /* renamed from: d  reason: collision with root package name */
    static final int f12779d;

    /* renamed from: e  reason: collision with root package name */
    static final int f12780e;

    /* renamed from: a  reason: collision with root package name */
    private final Executor f12781a = new UIThreadExecutor();

    private static class UIThreadExecutor implements Executor {
        private UIThreadExecutor() {
        }

        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f12778c = availableProcessors;
        f12779d = availableProcessors + 1;
        f12780e = (availableProcessors * 2) + 1;
    }

    private AndroidExecutors() {
    }

    @SuppressLint({"NewApi"})
    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z2) {
        threadPoolExecutor.allowCoreThreadTimeOut(z2);
    }

    public static ExecutorService b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f12779d, f12780e, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    public static Executor c() {
        return f12777b.f12781a;
    }
}
