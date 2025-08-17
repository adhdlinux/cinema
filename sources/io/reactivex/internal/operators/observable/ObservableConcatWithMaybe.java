package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final MaybeSource<? extends T> f38860c;

    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f38861b;

        /* renamed from: c  reason: collision with root package name */
        MaybeSource<? extends T> f38862c;

        /* renamed from: d  reason: collision with root package name */
        boolean f38863d;

        ConcatWithObserver(Observer<? super T> observer, MaybeSource<? extends T> maybeSource) {
            this.f38861b = observer;
            this.f38862c = maybeSource;
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public void onComplete() {
            if (this.f38863d) {
                this.f38861b.onComplete();
                return;
            }
            this.f38863d = true;
            DisposableHelper.c(this, (Disposable) null);
            MaybeSource<? extends T> maybeSource = this.f38862c;
            this.f38862c = null;
            maybeSource.a(this);
        }

        public void onError(Throwable th) {
            this.f38861b.onError(th);
        }

        public void onNext(T t2) {
            this.f38861b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.f(this, disposable) && !this.f38863d) {
                this.f38861b.onSubscribe(this);
            }
        }

        public void onSuccess(T t2) {
            this.f38861b.onNext(t2);
            this.f38861b.onComplete();
        }
    }

    public ObservableConcatWithMaybe(Observable<T> observable, MaybeSource<? extends T> maybeSource) {
        super(observable);
        this.f38860c = maybeSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new ConcatWithObserver(observer, this.f38860c));
    }
}
