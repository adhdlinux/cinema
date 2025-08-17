package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class RequestExecutor {

    private static class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        private String f2668b;

        /* renamed from: c  reason: collision with root package name */
        private int f2669c;

        private static class ProcessPriorityThread extends Thread {

            /* renamed from: b  reason: collision with root package name */
            private final int f2670b;

            ProcessPriorityThread(Runnable runnable, String str, int i2) {
                super(runnable, str);
                this.f2670b = i2;
            }

            public void run() {
                Process.setThreadPriority(this.f2670b);
                super.run();
            }
        }

        DefaultThreadFactory(String str, int i2) {
            this.f2668b = str;
            this.f2669c = i2;
        }

        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.f2668b, this.f2669c);
        }
    }

    private static class ReplyRunnable<T> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private Callable<T> f2671b;

        /* renamed from: c  reason: collision with root package name */
        private Consumer<T> f2672c;

        /* renamed from: d  reason: collision with root package name */
        private Handler f2673d;

        ReplyRunnable(Handler handler, Callable<T> callable, Consumer<T> consumer) {
            this.f2671b = callable;
            this.f2672c = consumer;
            this.f2673d = handler;
        }

        public void run() {
            final T t2;
            try {
                t2 = this.f2671b.call();
            } catch (Exception unused) {
                t2 = null;
            }
            final Consumer<T> consumer = this.f2672c;
            this.f2673d.post(new Runnable() {
                public void run() {
                    consumer.accept(t2);
                }
            });
        }
    }

    private RequestExecutor() {
    }

    static ThreadPoolExecutor a(String str, int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) i3, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i2));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static <T> void b(Executor executor, Callable<T> callable, Consumer<T> consumer) {
        executor.execute(new ReplyRunnable(CalleeHandler.a(), callable, consumer));
    }

    static <T> T c(ExecutorService executorService, Callable<T> callable, int i2) throws InterruptedException {
        try {
            return executorService.submit(callable).get((long) i2, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (InterruptedException e3) {
            throw e3;
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
