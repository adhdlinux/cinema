package io.reactivex.internal.operators.observable;

import com.facebook.common.time.Clock;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeat<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f39360c;

    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39361b;

        /* renamed from: c  reason: collision with root package name */
        final SequentialDisposable f39362c;

        /* renamed from: d  reason: collision with root package name */
        final ObservableSource<? extends T> f39363d;

        /* renamed from: e  reason: collision with root package name */
        long f39364e;

        RepeatObserver(Observer<? super T> observer, long j2, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f39361b = observer;
            this.f39362c = sequentialDisposable;
            this.f39363d = observableSource;
            this.f39364e = j2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                while (!this.f39362c.isDisposed()) {
                    this.f39363d.subscribe(this);
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public void onComplete() {
            long j2 = this.f39364e;
            if (j2 != Clock.MAX_TIME) {
                this.f39364e = j2 - 1;
            }
            if (j2 != 0) {
                a();
            } else {
                this.f39361b.onComplete();
            }
        }

        public void onError(Throwable th) {
            this.f39361b.onError(th);
        }

        public void onNext(T t2) {
            this.f39361b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f39362c.a(disposable);
        }
    }

    public ObservableRepeat(Observable<T> observable, long j2) {
        super(observable);
        this.f39360c = j2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        long j2 = this.f39360c;
        long j3 = Clock.MAX_TIME;
        if (j2 != Clock.MAX_TIME) {
            j3 = j2 - 1;
        }
        new RepeatObserver(observer, j3, sequentialDisposable, this.f38612b).a();
    }
}
