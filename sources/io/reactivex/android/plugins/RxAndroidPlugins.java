package io.reactivex.android.plugins;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

public final class RxAndroidPlugins {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Function<Callable<Scheduler>, Scheduler> f38314a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Function<Scheduler, Scheduler> f38315b;

    private RxAndroidPlugins() {
        throw new AssertionError("No instances.");
    }

    static <T, R> R a(Function<T, R> function, T t2) {
        try {
            return function.apply(t2);
        } catch (Throwable th) {
            throw Exceptions.a(th);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static io.reactivex.Scheduler b(io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler> r0, java.util.concurrent.Callable<io.reactivex.Scheduler> r1) {
        /*
            java.lang.Object r0 = a(r0, r1)
            io.reactivex.Scheduler r0 = (io.reactivex.Scheduler) r0
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Scheduler Callable returned null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.android.plugins.RxAndroidPlugins.b(io.reactivex.functions.Function, java.util.concurrent.Callable):io.reactivex.Scheduler");
    }

    static Scheduler c(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.a(th);
        }
    }

    public static Scheduler d(Callable<Scheduler> callable) {
        if (callable != null) {
            Function<Callable<Scheduler>, Scheduler> function = f38314a;
            if (function == null) {
                return c(callable);
            }
            return b(function, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static Scheduler e(Scheduler scheduler) {
        if (scheduler != null) {
            Function function = f38315b;
            if (function == null) {
                return scheduler;
            }
            return (Scheduler) a(function, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }
}
