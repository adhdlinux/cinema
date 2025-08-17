package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class Schedulers {

    /* renamed from: a  reason: collision with root package name */
    static final Scheduler f40126a = RxJavaPlugins.h(new SingleTask());

    /* renamed from: b  reason: collision with root package name */
    static final Scheduler f40127b = RxJavaPlugins.e(new ComputationTask());

    /* renamed from: c  reason: collision with root package name */
    static final Scheduler f40128c = RxJavaPlugins.f(new IOTask());

    /* renamed from: d  reason: collision with root package name */
    static final Scheduler f40129d = TrampolineScheduler.f();

    /* renamed from: e  reason: collision with root package name */
    static final Scheduler f40130e = RxJavaPlugins.g(new NewThreadTask());

    static final class ComputationHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f40131a = new ComputationScheduler();

        ComputationHolder() {
        }
    }

    static final class ComputationTask implements Callable<Scheduler> {
        ComputationTask() {
        }

        /* renamed from: b */
        public Scheduler call() throws Exception {
            return ComputationHolder.f40131a;
        }
    }

    static final class IOTask implements Callable<Scheduler> {
        IOTask() {
        }

        /* renamed from: b */
        public Scheduler call() throws Exception {
            return IoHolder.f40132a;
        }
    }

    static final class IoHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f40132a = new IoScheduler();

        IoHolder() {
        }
    }

    static final class NewThreadHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f40133a = new NewThreadScheduler();

        NewThreadHolder() {
        }
    }

    static final class NewThreadTask implements Callable<Scheduler> {
        NewThreadTask() {
        }

        /* renamed from: b */
        public Scheduler call() throws Exception {
            return NewThreadHolder.f40133a;
        }
    }

    static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Scheduler f40134a = new SingleScheduler();

        SingleHolder() {
        }
    }

    static final class SingleTask implements Callable<Scheduler> {
        SingleTask() {
        }

        /* renamed from: b */
        public Scheduler call() throws Exception {
            return SingleHolder.f40134a;
        }
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    public static Scheduler a() {
        return RxJavaPlugins.r(f40127b);
    }

    public static Scheduler b(Executor executor) {
        return new ExecutorScheduler(executor, false);
    }

    public static Scheduler c() {
        return RxJavaPlugins.t(f40128c);
    }

    public static Scheduler d() {
        return RxJavaPlugins.v(f40126a);
    }

    public static Scheduler e() {
        return f40129d;
    }
}
