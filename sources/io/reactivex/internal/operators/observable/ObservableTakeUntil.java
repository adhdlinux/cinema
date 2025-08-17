package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<? extends U> f39619c;

    static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39620b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<Disposable> f39621c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        final TakeUntilMainObserver<T, U>.OtherObserver f39622d = new OtherObserver();

        /* renamed from: e  reason: collision with root package name */
        final AtomicThrowable f39623e = new AtomicThrowable();

        final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
            OtherObserver() {
            }

            public void onComplete() {
                TakeUntilMainObserver.this.a();
            }

            public void onError(Throwable th) {
                TakeUntilMainObserver.this.b(th);
            }

            public void onNext(U u2) {
                DisposableHelper.a(this);
                TakeUntilMainObserver.this.a();
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }
        }

        TakeUntilMainObserver(Observer<? super T> observer) {
            this.f39620b = observer;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            DisposableHelper.a(this.f39621c);
            HalfSerializer.a(this.f39620b, this, this.f39623e);
        }

        /* access modifiers changed from: package-private */
        public void b(Throwable th) {
            DisposableHelper.a(this.f39621c);
            HalfSerializer.c(this.f39620b, th, this, this.f39623e);
        }

        public void dispose() {
            DisposableHelper.a(this.f39621c);
            DisposableHelper.a(this.f39622d);
        }

        public boolean isDisposed() {
            return DisposableHelper.b(this.f39621c.get());
        }

        public void onComplete() {
            DisposableHelper.a(this.f39622d);
            HalfSerializer.a(this.f39620b, this, this.f39623e);
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.f39622d);
            HalfSerializer.c(this.f39620b, th, this, this.f39623e);
        }

        public void onNext(T t2) {
            HalfSerializer.e(this.f39620b, t2, this, this.f39623e);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39621c, disposable);
        }
    }

    public ObservableTakeUntil(ObservableSource<T> observableSource, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f39619c = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(observer);
        observer.onSubscribe(takeUntilMainObserver);
        this.f39619c.subscribe(takeUntilMainObserver.f39622d);
        this.f38612b.subscribe(takeUntilMainObserver);
    }
}
