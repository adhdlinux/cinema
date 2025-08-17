package rx.schedulers;

import java.util.concurrent.Executor;
import rx.Scheduler;
import rx.plugins.RxJavaPlugins;

public final class Schedulers {

    /* renamed from: d  reason: collision with root package name */
    private static final Schedulers f42137d = new Schedulers();

    /* renamed from: a  reason: collision with root package name */
    private final Scheduler f42138a;

    /* renamed from: b  reason: collision with root package name */
    private final Scheduler f42139b;

    /* renamed from: c  reason: collision with root package name */
    private final Scheduler f42140c;

    private Schedulers() {
        Scheduler a2 = RxJavaPlugins.b().e().a();
        if (a2 != null) {
            this.f42138a = a2;
        } else {
            this.f42138a = new EventLoopsScheduler();
        }
        Scheduler c2 = RxJavaPlugins.b().e().c();
        if (c2 != null) {
            this.f42139b = c2;
        } else {
            this.f42139b = new CachedThreadScheduler();
        }
        Scheduler d2 = RxJavaPlugins.b().e().d();
        if (d2 != null) {
            this.f42140c = d2;
        } else {
            this.f42140c = NewThreadScheduler.a();
        }
    }

    public static Scheduler computation() {
        return f42137d.f42138a;
    }

    public static Scheduler from(Executor executor) {
        return new ExecutorScheduler(executor);
    }

    public static Scheduler immediate() {
        return ImmediateScheduler.a();
    }

    public static Scheduler io() {
        return f42137d.f42139b;
    }

    public static Scheduler newThread() {
        return f42137d.f42140c;
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static Scheduler trampoline() {
        return TrampolineScheduler.a();
    }
}
