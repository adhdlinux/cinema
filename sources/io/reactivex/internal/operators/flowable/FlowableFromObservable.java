package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromObservable<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Observable<T> f38450c;

    static final class SubscriberObserver<T> implements Observer<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        final Subscriber<? super T> f38451b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f38452c;

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.f38451b = subscriber;
        }

        public void cancel() {
            this.f38452c.dispose();
        }

        public void onComplete() {
            this.f38451b.onComplete();
        }

        public void onError(Throwable th) {
            this.f38451b.onError(th);
        }

        public void onNext(T t2) {
            this.f38451b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f38452c = disposable;
            this.f38451b.a(this);
        }

        public void request(long j2) {
        }
    }

    public FlowableFromObservable(Observable<T> observable) {
        this.f38450c = observable;
    }

    /* access modifiers changed from: protected */
    public void o(Subscriber<? super T> subscriber) {
        this.f38450c.subscribe(new SubscriberObserver(subscriber));
    }
}
