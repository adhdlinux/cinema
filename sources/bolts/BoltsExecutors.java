package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class BoltsExecutors {

    /* renamed from: d  reason: collision with root package name */
    private static final BoltsExecutors f12782d = new BoltsExecutors();

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f12783a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f12784b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f12785c;

    private static class ImmediateExecutor implements Executor {

        /* renamed from: b  reason: collision with root package name */
        private ThreadLocal<Integer> f12786b;

        private ImmediateExecutor() {
            this.f12786b = new ThreadLocal<>();
        }

        private int a() {
            Integer num = this.f12786b.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f12786b.remove();
            } else {
                this.f12786b.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        private int b() {
            Integer num = this.f12786b.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.f12786b.set(Integer.valueOf(intValue));
            return intValue;
        }

        public void execute(Runnable runnable) {
            if (b() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    a();
                    throw th;
                }
            } else {
                BoltsExecutors.a().execute(runnable);
            }
            a();
        }
    }

    private BoltsExecutors() {
        ExecutorService executorService;
        if (!c()) {
            executorService = Executors.newCachedThreadPool();
        } else {
            executorService = AndroidExecutors.b();
        }
        this.f12783a = executorService;
        this.f12784b = Executors.newSingleThreadScheduledExecutor();
        this.f12785c = new ImmediateExecutor();
    }

    public static ExecutorService a() {
        return f12782d.f12783a;
    }

    static Executor b() {
        return f12782d.f12785c;
    }

    private static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }
}
