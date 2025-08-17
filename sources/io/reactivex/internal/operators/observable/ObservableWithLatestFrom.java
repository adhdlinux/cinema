package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    final BiFunction<? super T, ? super U, ? extends R> f39845c;

    /* renamed from: d  reason: collision with root package name */
    final ObservableSource<? extends U> f39846d;

    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f39847b;

        /* renamed from: c  reason: collision with root package name */
        final BiFunction<? super T, ? super U, ? extends R> f39848c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<Disposable> f39849d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<Disposable> f39850e = new AtomicReference<>();

        WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.f39847b = observer;
            this.f39848c = biFunction;
        }

        public void a(Throwable th) {
            DisposableHelper.a(this.f39849d);
            this.f39847b.onError(th);
        }

        public boolean b(Disposable disposable) {
            return DisposableHelper.f(this.f39850e, disposable);
        }

        public void dispose() {
            DisposableHelper.a(this.f39849d);
            DisposableHelper.a(this.f39850e);
        }

        public boolean isDisposed() {
            return DisposableHelper.b(this.f39849d.get());
        }

        public void onComplete() {
            DisposableHelper.a(this.f39850e);
            this.f39847b.onComplete();
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.f39850e);
            this.f39847b.onError(th);
        }

        public void onNext(T t2) {
            Object obj = get();
            if (obj != null) {
                try {
                    this.f39847b.onNext(ObjectHelper.e(this.f39848c.apply(t2, obj), "The combiner returned a null value"));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    dispose();
                    this.f39847b.onError(th);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39849d, disposable);
        }
    }

    final class WithLatestFromOtherObserver implements Observer<U> {

        /* renamed from: b  reason: collision with root package name */
        private final WithLatestFromObserver<T, U, R> f39851b;

        WithLatestFromOtherObserver(WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.f39851b = withLatestFromObserver;
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
            this.f39851b.a(th);
        }

        public void onNext(U u2) {
            this.f39851b.lazySet(u2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f39851b.b(disposable);
        }
    }

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f39845c = biFunction;
        this.f39846d = observableSource2;
    }

    public void subscribeActual(Observer<? super R> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(serializedObserver, this.f39845c);
        serializedObserver.onSubscribe(withLatestFromObserver);
        this.f39846d.subscribe(new WithLatestFromOtherObserver(withLatestFromObserver));
        this.f38612b.subscribe(withLatestFromObserver);
    }
}
