package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleWithObservable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<?> f39448c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f39449d;

    static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f39450f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f39451g;

        SampleMainEmitLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f39451g = true;
            if (this.f39450f.getAndIncrement() == 0) {
                c();
                this.f39452b.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (this.f39450f.getAndIncrement() == 0) {
                do {
                    boolean z2 = this.f39451g;
                    c();
                    if (z2) {
                        this.f39452b.onComplete();
                        return;
                    }
                } while (this.f39450f.decrementAndGet() != 0);
            }
        }
    }

    static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        SampleMainNoLast(Observer<? super T> observer, ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f39452b.onComplete();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            c();
        }
    }

    static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39452b;

        /* renamed from: c  reason: collision with root package name */
        final ObservableSource<?> f39453c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<Disposable> f39454d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        Disposable f39455e;

        SampleMainObserver(Observer<? super T> observer, ObservableSource<?> observableSource) {
            this.f39452b = observer;
            this.f39453c = observableSource;
        }

        public void a() {
            this.f39455e.dispose();
            b();
        }

        /* access modifiers changed from: package-private */
        public abstract void b();

        /* access modifiers changed from: package-private */
        public void c() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.f39452b.onNext(andSet);
            }
        }

        public void d(Throwable th) {
            this.f39455e.dispose();
            this.f39452b.onError(th);
        }

        public void dispose() {
            DisposableHelper.a(this.f39454d);
            this.f39455e.dispose();
        }

        /* access modifiers changed from: package-private */
        public abstract void e();

        /* access modifiers changed from: package-private */
        public boolean f(Disposable disposable) {
            return DisposableHelper.f(this.f39454d, disposable);
        }

        public boolean isDisposed() {
            return this.f39454d.get() == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            DisposableHelper.a(this.f39454d);
            b();
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.f39454d);
            this.f39452b.onError(th);
        }

        public void onNext(T t2) {
            lazySet(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39455e, disposable)) {
                this.f39455e = disposable;
                this.f39452b.onSubscribe(this);
                if (this.f39454d.get() == null) {
                    this.f39453c.subscribe(new SamplerObserver(this));
                }
            }
        }
    }

    static final class SamplerObserver<T> implements Observer<Object> {

        /* renamed from: b  reason: collision with root package name */
        final SampleMainObserver<T> f39456b;

        SamplerObserver(SampleMainObserver<T> sampleMainObserver) {
            this.f39456b = sampleMainObserver;
        }

        public void onComplete() {
            this.f39456b.a();
        }

        public void onError(Throwable th) {
            this.f39456b.d(th);
        }

        public void onNext(Object obj) {
            this.f39456b.e();
        }

        public void onSubscribe(Disposable disposable) {
            this.f39456b.f(disposable);
        }
    }

    public ObservableSampleWithObservable(ObservableSource<T> observableSource, ObservableSource<?> observableSource2, boolean z2) {
        super(observableSource);
        this.f39448c = observableSource2;
        this.f39449d = z2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f39449d) {
            this.f38612b.subscribe(new SampleMainEmitLast(serializedObserver, this.f39448c));
        } else {
            this.f38612b.subscribe(new SampleMainNoLast(serializedObserver, this.f39448c));
        }
    }
}
