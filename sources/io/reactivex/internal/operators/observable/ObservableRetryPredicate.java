package io.reactivex.internal.operators.observable;

import com.facebook.common.time.Clock;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRetryPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Predicate<? super Throwable> f39420c;

    /* renamed from: d  reason: collision with root package name */
    final long f39421d;

    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39422b;

        /* renamed from: c  reason: collision with root package name */
        final SequentialDisposable f39423c;

        /* renamed from: d  reason: collision with root package name */
        final ObservableSource<? extends T> f39424d;

        /* renamed from: e  reason: collision with root package name */
        final Predicate<? super Throwable> f39425e;

        /* renamed from: f  reason: collision with root package name */
        long f39426f;

        RepeatObserver(Observer<? super T> observer, long j2, Predicate<? super Throwable> predicate, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f39422b = observer;
            this.f39423c = sequentialDisposable;
            this.f39424d = observableSource;
            this.f39425e = predicate;
            this.f39426f = j2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f39423c.isDisposed()) {
                    this.f39424d.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            this.f39422b.onComplete();
        }

        public void onError(Throwable th) {
            long j2 = this.f39426f;
            if (j2 != Clock.MAX_TIME) {
                this.f39426f = j2 - 1;
            }
            if (j2 == 0) {
                this.f39422b.onError(th);
                return;
            }
            try {
                if (!this.f39425e.test(th)) {
                    this.f39422b.onError(th);
                } else {
                    a();
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f39422b.onError(new CompositeException(th, th2));
            }
        }

        public void onNext(T t2) {
            this.f39422b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f39423c.a(disposable);
        }
    }

    public ObservableRetryPredicate(Observable<T> observable, long j2, Predicate<? super Throwable> predicate) {
        super(observable);
        this.f39420c = predicate;
        this.f39421d = j2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatObserver(observer, this.f39421d, this.f39420c, sequentialDisposable, this.f38612b).a();
    }
}
