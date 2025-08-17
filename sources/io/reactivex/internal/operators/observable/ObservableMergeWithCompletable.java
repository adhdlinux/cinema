package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final CompletableSource f39243c;

    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39244b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<Disposable> f39245c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        final OtherObserver f39246d = new OtherObserver(this);

        /* renamed from: e  reason: collision with root package name */
        final AtomicThrowable f39247e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f39248f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f39249g;

        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {

            /* renamed from: b  reason: collision with root package name */
            final MergeWithObserver<?> f39250b;

            OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.f39250b = mergeWithObserver;
            }

            public void onComplete() {
                this.f39250b.a();
            }

            public void onError(Throwable th) {
                this.f39250b.b(th);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.f(this, disposable);
            }
        }

        MergeWithObserver(Observer<? super T> observer) {
            this.f39244b = observer;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f39249g = true;
            if (this.f39248f) {
                HalfSerializer.a(this.f39244b, this, this.f39247e);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(Throwable th) {
            DisposableHelper.a(this.f39245c);
            HalfSerializer.c(this.f39244b, th, this, this.f39247e);
        }

        public void dispose() {
            DisposableHelper.a(this.f39245c);
            DisposableHelper.a(this.f39246d);
        }

        public boolean isDisposed() {
            return DisposableHelper.b(this.f39245c.get());
        }

        public void onComplete() {
            this.f39248f = true;
            if (this.f39249g) {
                HalfSerializer.a(this.f39244b, this, this.f39247e);
            }
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this.f39245c);
            HalfSerializer.c(this.f39244b, th, this, this.f39247e);
        }

        public void onNext(T t2) {
            HalfSerializer.e(this.f39244b, t2, this, this.f39247e);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39245c, disposable);
        }
    }

    public ObservableMergeWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.f39243c = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.f38612b.subscribe(mergeWithObserver);
        this.f39243c.a(mergeWithObserver.f39246d);
    }
}
