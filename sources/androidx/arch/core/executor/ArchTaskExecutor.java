package androidx.arch.core.executor;

import java.util.concurrent.Executor;

public class ArchTaskExecutor extends TaskExecutor {

    /* renamed from: c  reason: collision with root package name */
    private static volatile ArchTaskExecutor f1557c;

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f1558d = new Executor() {
        public void execute(Runnable runnable) {
            ArchTaskExecutor.e().c(runnable);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f1559e = new Executor() {
        public void execute(Runnable runnable) {
            ArchTaskExecutor.e().a(runnable);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private TaskExecutor f1560a;

    /* renamed from: b  reason: collision with root package name */
    private TaskExecutor f1561b;

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.f1561b = defaultTaskExecutor;
        this.f1560a = defaultTaskExecutor;
    }

    public static Executor d() {
        return f1559e;
    }

    public static ArchTaskExecutor e() {
        if (f1557c != null) {
            return f1557c;
        }
        synchronized (ArchTaskExecutor.class) {
            if (f1557c == null) {
                f1557c = new ArchTaskExecutor();
            }
        }
        return f1557c;
    }

    public void a(Runnable runnable) {
        this.f1560a.a(runnable);
    }

    public boolean b() {
        return this.f1560a.b();
    }

    public void c(Runnable runnable) {
        this.f1560a.c(runnable);
    }
}
