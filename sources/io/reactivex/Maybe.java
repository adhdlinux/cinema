package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.MaybeFromCallable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public abstract class Maybe<T> implements MaybeSource<T> {
    public static <T> Maybe<T> d(Callable<? extends T> callable) {
        ObjectHelper.e(callable, "callable is null");
        return RxJavaPlugins.m(new MaybeFromCallable(callable));
    }

    public final void a(MaybeObserver<? super T> maybeObserver) {
        ObjectHelper.e(maybeObserver, "observer is null");
        MaybeObserver<? super Object> x2 = RxJavaPlugins.x(this, maybeObserver);
        ObjectHelper.e(x2, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            f(x2);
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

    public final Disposable e(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.e(consumer, "onSuccess is null");
        ObjectHelper.e(consumer2, "onError is null");
        ObjectHelper.e(action, "onComplete is null");
        return (Disposable) g(new MaybeCallbackObserver(consumer, consumer2, action));
    }

    /* access modifiers changed from: protected */
    public abstract void f(MaybeObserver<? super T> maybeObserver);

    public final <E extends MaybeObserver<? super T>> E g(E e2) {
        a(e2);
        return e2;
    }
}
