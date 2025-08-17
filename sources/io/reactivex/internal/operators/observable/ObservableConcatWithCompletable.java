package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final CompletableSource f38856c;

    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, CompletableObserver, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f38857b;

        /* renamed from: c  reason: collision with root package name */
        CompletableSource f38858c;

        /* renamed from: d  reason: collision with root package name */
        boolean f38859d;

        ConcatWithObserver(Observer<? super T> observer, CompletableSource completableSource) {
            this.f38857b = observer;
            this.f38858c = completableSource;
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public void onComplete() {
            if (this.f38859d) {
                this.f38857b.onComplete();
                return;
            }
            this.f38859d = true;
            DisposableHelper.c(this, (Disposable) null);
            CompletableSource completableSource = this.f38858c;
            this.f38858c = null;
            completableSource.a(this);
        }

        public void onError(Throwable th) {
            this.f38857b.onError(th);
        }

        public void onNext(T t2) {
            this.f38857b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.f(this, disposable) && !this.f38859d) {
                this.f38857b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.f38856c = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new ConcatWithObserver(observer, this.f38856c));
    }
}
