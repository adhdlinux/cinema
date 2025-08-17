package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.operators.single.SingleDoOnError;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public abstract class Single<T> implements SingleSource<T> {
    public static <T> Single<T> f(T t2) {
        ObjectHelper.e(t2, "item is null");
        return RxJavaPlugins.o(new SingleJust(t2));
    }

    public final void a(SingleObserver<? super T> singleObserver) {
        ObjectHelper.e(singleObserver, "observer is null");
        SingleObserver<? super Object> z2 = RxJavaPlugins.z(this, singleObserver);
        ObjectHelper.e(z2, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            j(z2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            Exceptions.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final T c() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        a(blockingMultiObserver);
        return blockingMultiObserver.a();
    }

    public final Single<T> d(Consumer<? super Throwable> consumer) {
        ObjectHelper.e(consumer, "onError is null");
        return RxJavaPlugins.o(new SingleDoOnError(this, consumer));
    }

    public final Single<T> e(Consumer<? super T> consumer) {
        ObjectHelper.e(consumer, "onSuccess is null");
        return RxJavaPlugins.o(new SingleDoOnSuccess(this, consumer));
    }

    public final <R> Single<R> g(Function<? super T, ? extends R> function) {
        ObjectHelper.e(function, "mapper is null");
        return RxJavaPlugins.o(new SingleMap(this, function));
    }

    public final Single<T> h(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.o(new SingleObserveOn(this, scheduler));
    }

    public final Disposable i(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObjectHelper.e(consumer, "onSuccess is null");
        ObjectHelper.e(consumer2, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(consumer, consumer2);
        a(consumerSingleObserver);
        return consumerSingleObserver;
    }

    /* access modifiers changed from: protected */
    public abstract void j(SingleObserver<? super T> singleObserver);

    public final Single<T> k(Scheduler scheduler) {
        ObjectHelper.e(scheduler, "scheduler is null");
        return RxJavaPlugins.o(new SingleSubscribeOn(this, scheduler));
    }

    public final Observable<T> l() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).b();
        }
        return RxJavaPlugins.n(new SingleToObservable(this));
    }
}
