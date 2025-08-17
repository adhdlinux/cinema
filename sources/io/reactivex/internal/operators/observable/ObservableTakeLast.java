package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

public final class ObservableTakeLast<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final int f39595c;

    static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39596b;

        /* renamed from: c  reason: collision with root package name */
        final int f39597c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f39598d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f39599e;

        TakeLastObserver(Observer<? super T> observer, int i2) {
            this.f39596b = observer;
            this.f39597c = i2;
        }

        public void dispose() {
            if (!this.f39599e) {
                this.f39599e = true;
                this.f39598d.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f39599e;
        }

        public void onComplete() {
            Observer<? super T> observer = this.f39596b;
            while (!this.f39599e) {
                Object poll = poll();
                if (poll != null) {
                    observer.onNext(poll);
                } else if (!this.f39599e) {
                    observer.onComplete();
                    return;
                } else {
                    return;
                }
            }
        }

        public void onError(Throwable th) {
            this.f39596b.onError(th);
        }

        public void onNext(T t2) {
            if (this.f39597c == size()) {
                poll();
            }
            offer(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39598d, disposable)) {
                this.f39598d = disposable;
                this.f39596b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLast(ObservableSource<T> observableSource, int i2) {
        super(observableSource);
        this.f39595c = i2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new TakeLastObserver(observer, this.f39595c));
    }
}
