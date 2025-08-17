package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super Observable<T>, ? extends ObservableSource<R>> f39311c;

    static final class SourceObserver<T, R> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final PublishSubject<T> f39312b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<Disposable> f39313c;

        SourceObserver(PublishSubject<T> publishSubject, AtomicReference<Disposable> atomicReference) {
            this.f39312b = publishSubject;
            this.f39313c = atomicReference;
        }

        public void onComplete() {
            this.f39312b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39312b.onError(th);
        }

        public void onNext(T t2) {
            this.f39312b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39313c, disposable);
        }
    }

    static final class TargetObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f39314b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f39315c;

        TargetObserver(Observer<? super R> observer) {
            this.f39314b = observer;
        }

        public void dispose() {
            this.f39315c.dispose();
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return this.f39315c.isDisposed();
        }

        public void onComplete() {
            DisposableHelper.a(this);
            this.f39314b.onComplete();
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this);
            this.f39314b.onError(th);
        }

        public void onNext(R r2) {
            this.f39314b.onNext(r2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39315c, disposable)) {
                this.f39315c = disposable;
                this.f39314b.onSubscribe(this);
            }
        }
    }

    public ObservablePublishSelector(ObservableSource<T> observableSource, Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        super(observableSource);
        this.f39311c = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        PublishSubject d2 = PublishSubject.d();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f39311c.apply(d2), "The selector returned a null ObservableSource");
            TargetObserver targetObserver = new TargetObserver(observer);
            observableSource.subscribe(targetObserver);
            this.f38612b.subscribe(new SourceObserver(d2, targetObserver));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.e(th, observer);
        }
    }
}
