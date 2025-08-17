package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRetryWhen<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super Observable<Throwable>, ? extends ObservableSource<?>> f39427c;

    static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39428b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f39429c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        final AtomicThrowable f39430d = new AtomicThrowable();

        /* renamed from: e  reason: collision with root package name */
        final Subject<Throwable> f39431e;

        /* renamed from: f  reason: collision with root package name */
        final RepeatWhenObserver<T>.InnerRepeatObserver f39432f = new InnerRepeatObserver();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Disposable> f39433g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        final ObservableSource<T> f39434h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f39435i;

        final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            InnerRepeatObserver() {
            }

            public void onComplete() {
                RepeatWhenObserver.this.a();
            }

            public void onError(Throwable th) {
                RepeatWhenObserver.this.b(th);
            }

            public void onNext(Object obj) {
                RepeatWhenObserver.this.c();
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }
        }

        RepeatWhenObserver(Observer<? super T> observer, Subject<Throwable> subject, ObservableSource<T> observableSource) {
            this.f39428b = observer;
            this.f39431e = subject;
            this.f39434h = observableSource;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            DisposableHelper.a(this.f39433g);
            HalfSerializer.a(this.f39428b, this, this.f39430d);
        }

        /* access modifiers changed from: package-private */
        public void b(Throwable th) {
            DisposableHelper.a(this.f39433g);
            HalfSerializer.c(this.f39428b, th, this, this.f39430d);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            d();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.f39429c.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.f39435i) {
                        this.f39435i = true;
                        this.f39434h.subscribe(this);
                    }
                    if (this.f39429c.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void dispose() {
            DisposableHelper.a(this.f39433g);
            DisposableHelper.a(this.f39432f);
        }

        public boolean isDisposed() {
            return DisposableHelper.b(this.f39433g.get());
        }

        public void onComplete() {
            DisposableHelper.a(this.f39432f);
            HalfSerializer.a(this.f39428b, this, this.f39430d);
        }

        public void onError(Throwable th) {
            DisposableHelper.c(this.f39433g, (Disposable) null);
            this.f39435i = false;
            this.f39431e.onNext(th);
        }

        public void onNext(T t2) {
            HalfSerializer.e(this.f39428b, t2, this, this.f39430d);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.c(this.f39433g, disposable);
        }
    }

    public ObservableRetryWhen(ObservableSource<T> observableSource, Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        super(observableSource);
        this.f39427c = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        Subject b2 = PublishSubject.d().b();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f39427c.apply(b2), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, b2, this.f38612b);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.f39432f);
            repeatWhenObserver.d();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.e(th, observer);
        }
    }
}
