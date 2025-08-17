package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Scheduler f39561c;

    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39562b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<Disposable> f39563c = new AtomicReference<>();

        SubscribeOnObserver(Observer<? super T> observer) {
            this.f39562b = observer;
        }

        /* access modifiers changed from: package-private */
        public void a(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }

        public void dispose() {
            DisposableHelper.a(this.f39563c);
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public void onComplete() {
            this.f39562b.onComplete();
        }

        public void onError(Throwable th) {
            this.f39562b.onError(th);
        }

        public void onNext(T t2) {
            this.f39562b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39563c, disposable);
        }
    }

    final class SubscribeTask implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final SubscribeOnObserver<T> f39564b;

        SubscribeTask(SubscribeOnObserver<T> subscribeOnObserver) {
            this.f39564b = subscribeOnObserver;
        }

        public void run() {
            ObservableSubscribeOn.this.f38612b.subscribe(this.f39564b);
        }
    }

    public ObservableSubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f39561c = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(observer);
        observer.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.a(this.f39561c.c(new SubscribeTask(subscribeOnObserver)));
    }
}
