package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableSkipLast<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final int f39526c;

    static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39527b;

        /* renamed from: c  reason: collision with root package name */
        final int f39528c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39529d;

        SkipLastObserver(Observer<? super T> observer, int i2) {
            super(i2);
            this.f39527b = observer;
            this.f39528c = i2;
        }

        public void dispose() {
            this.f39529d.dispose();
        }

        public boolean isDisposed() {
            return this.f39529d.isDisposed();
        }

        public void onComplete() {
            this.f39527b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39527b.onError(th);
        }

        public void onNext(T t2) {
            if (this.f39528c == size()) {
                this.f39527b.onNext(poll());
            }
            offer(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39529d, disposable)) {
                this.f39529d = disposable;
                this.f39527b.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLast(ObservableSource<T> observableSource, int i2) {
        super(observableSource);
        this.f39526c = i2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new SkipLastObserver(observer, this.f39526c));
    }
}
