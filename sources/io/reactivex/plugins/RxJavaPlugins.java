package io.reactivex.plugins;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class RxJavaPlugins {

    /* renamed from: a  reason: collision with root package name */
    static volatile Consumer<? super Throwable> f40104a;

    /* renamed from: b  reason: collision with root package name */
    static volatile Function<? super Runnable, ? extends Runnable> f40105b;

    /* renamed from: c  reason: collision with root package name */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f40106c;

    /* renamed from: d  reason: collision with root package name */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f40107d;

    /* renamed from: e  reason: collision with root package name */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f40108e;

    /* renamed from: f  reason: collision with root package name */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f40109f;

    /* renamed from: g  reason: collision with root package name */
    static volatile Function<? super Scheduler, ? extends Scheduler> f40110g;

    /* renamed from: h  reason: collision with root package name */
    static volatile Function<? super Scheduler, ? extends Scheduler> f40111h;

    /* renamed from: i  reason: collision with root package name */
    static volatile Function<? super Scheduler, ? extends Scheduler> f40112i;

    /* renamed from: j  reason: collision with root package name */
    static volatile Function<? super Flowable, ? extends Flowable> f40113j;

    /* renamed from: k  reason: collision with root package name */
    static volatile Function<? super Observable, ? extends Observable> f40114k;

    /* renamed from: l  reason: collision with root package name */
    static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> f40115l;

    /* renamed from: m  reason: collision with root package name */
    static volatile Function<? super Maybe, ? extends Maybe> f40116m;

    /* renamed from: n  reason: collision with root package name */
    static volatile Function<? super Single, ? extends Single> f40117n;

    /* renamed from: o  reason: collision with root package name */
    static volatile Function<? super Completable, ? extends Completable> f40118o;

    /* renamed from: p  reason: collision with root package name */
    static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> f40119p;

    /* renamed from: q  reason: collision with root package name */
    static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> f40120q;

    /* renamed from: r  reason: collision with root package name */
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> f40121r;

    /* renamed from: s  reason: collision with root package name */
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> f40122s;

    /* renamed from: t  reason: collision with root package name */
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> f40123t;

    /* renamed from: u  reason: collision with root package name */
    static volatile boolean f40124u;

    /* renamed from: v  reason: collision with root package name */
    static volatile boolean f40125v;

    private RxJavaPlugins() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Subscriber<? super T> A(Flowable<T> flowable, Subscriber<? super T> subscriber) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction = f40119p;
        if (biFunction != null) {
            return (Subscriber) a(biFunction, flowable, subscriber);
        }
        return subscriber;
    }

    public static void B(Consumer<? super Throwable> consumer) {
        if (!f40124u) {
            f40104a = consumer;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    static void C(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    static <T, U, R> R a(BiFunction<T, U, R> biFunction, T t2, U u2) {
        try {
            return biFunction.apply(t2, u2);
        } catch (Throwable th) {
            throw ExceptionHelper.d(th);
        }
    }

    static <T, R> R b(Function<T, R> function, T t2) {
        try {
            return function.apply(t2);
        } catch (Throwable th) {
            throw ExceptionHelper.d(th);
        }
    }

    static Scheduler c(Function<? super Callable<Scheduler>, ? extends Scheduler> function, Callable<Scheduler> callable) {
        return (Scheduler) ObjectHelper.e(b(function, callable), "Scheduler Callable result can't be null");
    }

    static Scheduler d(Callable<Scheduler> callable) {
        try {
            return (Scheduler) ObjectHelper.e(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.d(th);
        }
    }

    public static Scheduler e(Callable<Scheduler> callable) {
        ObjectHelper.e(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f40106c;
        if (function == null) {
            return d(callable);
        }
        return c(function, callable);
    }

    public static Scheduler f(Callable<Scheduler> callable) {
        ObjectHelper.e(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f40108e;
        if (function == null) {
            return d(callable);
        }
        return c(function, callable);
    }

    public static Scheduler g(Callable<Scheduler> callable) {
        ObjectHelper.e(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f40109f;
        if (function == null) {
            return d(callable);
        }
        return c(function, callable);
    }

    public static Scheduler h(Callable<Scheduler> callable) {
        ObjectHelper.e(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f40107d;
        if (function == null) {
            return d(callable);
        }
        return c(function, callable);
    }

    static boolean i(Throwable th) {
        if (!(th instanceof OnErrorNotImplementedException) && !(th instanceof MissingBackpressureException) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof CompositeException)) {
            return false;
        }
        return true;
    }

    public static boolean j() {
        return f40125v;
    }

    public static Completable k(Completable completable) {
        Function<? super Completable, ? extends Completable> function = f40118o;
        if (function != null) {
            return (Completable) b(function, completable);
        }
        return completable;
    }

    public static <T> Flowable<T> l(Flowable<T> flowable) {
        Function<? super Flowable, ? extends Flowable> function = f40113j;
        if (function != null) {
            return (Flowable) b(function, flowable);
        }
        return flowable;
    }

    public static <T> Maybe<T> m(Maybe<T> maybe) {
        Function<? super Maybe, ? extends Maybe> function = f40116m;
        if (function != null) {
            return (Maybe) b(function, maybe);
        }
        return maybe;
    }

    public static <T> Observable<T> n(Observable<T> observable) {
        Function<? super Observable, ? extends Observable> function = f40114k;
        if (function != null) {
            return (Observable) b(function, observable);
        }
        return observable;
    }

    public static <T> Single<T> o(Single<T> single) {
        Function<? super Single, ? extends Single> function = f40117n;
        if (function != null) {
            return (Single) b(function, single);
        }
        return single;
    }

    public static <T> ConnectableObservable<T> p(ConnectableObservable<T> connectableObservable) {
        Function<? super ConnectableObservable, ? extends ConnectableObservable> function = f40115l;
        if (function != null) {
            return (ConnectableObservable) b(function, connectableObservable);
        }
        return connectableObservable;
    }

    public static boolean q() {
        return false;
    }

    public static Scheduler r(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f40110g;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) b(function, scheduler);
    }

    public static void s(Throwable th) {
        Consumer<? super Throwable> consumer = f40104a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th)) {
            th = new UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                C(th2);
            }
        }
        th.printStackTrace();
        C(th);
    }

    public static Scheduler t(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f40112i;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) b(function, scheduler);
    }

    public static Runnable u(Runnable runnable) {
        ObjectHelper.e(runnable, "run is null");
        Function<? super Runnable, ? extends Runnable> function = f40105b;
        if (function == null) {
            return runnable;
        }
        return (Runnable) b(function, runnable);
    }

    public static Scheduler v(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f40111h;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) b(function, scheduler);
    }

    public static CompletableObserver w(Completable completable, CompletableObserver completableObserver) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = f40123t;
        if (biFunction != null) {
            return (CompletableObserver) a(biFunction, completable, completableObserver);
        }
        return completableObserver;
    }

    public static <T> MaybeObserver<? super T> x(Maybe<T> maybe, MaybeObserver<? super T> maybeObserver) {
        BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> biFunction = f40120q;
        if (biFunction != null) {
            return (MaybeObserver) a(biFunction, maybe, maybeObserver);
        }
        return maybeObserver;
    }

    public static <T> Observer<? super T> y(Observable<T> observable, Observer<? super T> observer) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction = f40121r;
        if (biFunction != null) {
            return (Observer) a(biFunction, observable, observer);
        }
        return observer;
    }

    public static <T> SingleObserver<? super T> z(Single<T> single, SingleObserver<? super T> singleObserver) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = f40122s;
        if (biFunction != null) {
            return (SingleObserver) a(biFunction, single, singleObserver);
        }
        return singleObserver;
    }
}
