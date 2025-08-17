package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

public final class ObservableDetach<T> extends AbstractObservableWithUpstream<T, T> {

    static final class DetachObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        Observer<? super T> f38932b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f38933c;

        DetachObserver(Observer<? super T> observer) {
            this.f38932b = observer;
        }

        public void dispose() {
            Disposable disposable = this.f38933c;
            this.f38933c = EmptyComponent.INSTANCE;
            this.f38932b = EmptyComponent.b();
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f38933c.isDisposed();
        }

        public void onComplete() {
            Observer<? super T> observer = this.f38932b;
            this.f38933c = EmptyComponent.INSTANCE;
            this.f38932b = EmptyComponent.b();
            observer.onComplete();
        }

        public void onError(Throwable th) {
            Observer<? super T> observer = this.f38932b;
            this.f38933c = EmptyComponent.INSTANCE;
            this.f38932b = EmptyComponent.b();
            observer.onError(th);
        }

        public void onNext(T t2) {
            this.f38932b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38933c, disposable)) {
                this.f38933c = disposable;
                this.f38932b.onSubscribe(this);
            }
        }
    }

    public ObservableDetach(ObservableSource<T> observableSource) {
        super(observableSource);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new DetachObserver(observer));
    }
}
