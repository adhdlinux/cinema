package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    final Observer<? super T> f38395b;

    /* renamed from: c  reason: collision with root package name */
    final Consumer<? super Disposable> f38396c;

    /* renamed from: d  reason: collision with root package name */
    final Action f38397d;

    /* renamed from: e  reason: collision with root package name */
    Disposable f38398e;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.f38395b = observer;
        this.f38396c = consumer;
        this.f38397d = action;
    }

    public void dispose() {
        Disposable disposable = this.f38398e;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f38398e = disposableHelper;
            try {
                this.f38397d.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
            disposable.dispose();
        }
    }

    public boolean isDisposed() {
        return this.f38398e.isDisposed();
    }

    public void onComplete() {
        Disposable disposable = this.f38398e;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f38398e = disposableHelper;
            this.f38395b.onComplete();
        }
    }

    public void onError(Throwable th) {
        Disposable disposable = this.f38398e;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f38398e = disposableHelper;
            this.f38395b.onError(th);
            return;
        }
        RxJavaPlugins.s(th);
    }

    public void onNext(T t2) {
        this.f38395b.onNext(t2);
    }

    public void onSubscribe(Disposable disposable) {
        try {
            this.f38396c.accept(disposable);
            if (DisposableHelper.h(this.f38398e, disposable)) {
                this.f38398e = disposable;
                this.f38395b.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            disposable.dispose();
            this.f38398e = DisposableHelper.DISPOSED;
            EmptyDisposable.e(th, this.f38395b);
        }
    }
}
