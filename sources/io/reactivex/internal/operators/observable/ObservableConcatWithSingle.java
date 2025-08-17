package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithSingle<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final SingleSource<? extends T> f38864c;

    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f38865b;

        /* renamed from: c  reason: collision with root package name */
        SingleSource<? extends T> f38866c;

        /* renamed from: d  reason: collision with root package name */
        boolean f38867d;

        ConcatWithObserver(Observer<? super T> observer, SingleSource<? extends T> singleSource) {
            this.f38865b = observer;
            this.f38866c = singleSource;
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public void onComplete() {
            this.f38867d = true;
            DisposableHelper.c(this, (Disposable) null);
            SingleSource<? extends T> singleSource = this.f38866c;
            this.f38866c = null;
            singleSource.a(this);
        }

        public void onError(Throwable th) {
            this.f38865b.onError(th);
        }

        public void onNext(T t2) {
            this.f38865b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.f(this, disposable) && !this.f38867d) {
                this.f38865b.onSubscribe(this);
            }
        }

        public void onSuccess(T t2) {
            this.f38865b.onNext(t2);
            this.f38865b.onComplete();
        }
    }

    public ObservableConcatWithSingle(Observable<T> observable, SingleSource<? extends T> singleSource) {
        super(observable);
        this.f38864c = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new ConcatWithObserver(observer, this.f38864c));
    }
}
