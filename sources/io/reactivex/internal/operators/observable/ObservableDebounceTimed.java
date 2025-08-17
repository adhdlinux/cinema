package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f38889c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f38890d;

    /* renamed from: e  reason: collision with root package name */
    final Scheduler f38891e;

    static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final T f38892b;

        /* renamed from: c  reason: collision with root package name */
        final long f38893c;

        /* renamed from: d  reason: collision with root package name */
        final DebounceTimedObserver<T> f38894d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicBoolean f38895e = new AtomicBoolean();

        DebounceEmitter(T t2, long j2, DebounceTimedObserver<T> debounceTimedObserver) {
            this.f38892b = t2;
            this.f38893c = j2;
            this.f38894d = debounceTimedObserver;
        }

        public void a(Disposable disposable) {
            DisposableHelper.c(this, disposable);
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (this.f38895e.compareAndSet(false, true)) {
                this.f38894d.a(this.f38893c, this.f38892b, this);
            }
        }
    }

    static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f38896b;

        /* renamed from: c  reason: collision with root package name */
        final long f38897c;

        /* renamed from: d  reason: collision with root package name */
        final TimeUnit f38898d;

        /* renamed from: e  reason: collision with root package name */
        final Scheduler.Worker f38899e;

        /* renamed from: f  reason: collision with root package name */
        Disposable f38900f;

        /* renamed from: g  reason: collision with root package name */
        Disposable f38901g;

        /* renamed from: h  reason: collision with root package name */
        volatile long f38902h;

        /* renamed from: i  reason: collision with root package name */
        boolean f38903i;

        DebounceTimedObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f38896b = observer;
            this.f38897c = j2;
            this.f38898d = timeUnit;
            this.f38899e = worker;
        }

        /* access modifiers changed from: package-private */
        public void a(long j2, T t2, DebounceEmitter<T> debounceEmitter) {
            if (j2 == this.f38902h) {
                this.f38896b.onNext(t2);
                debounceEmitter.dispose();
            }
        }

        public void dispose() {
            this.f38900f.dispose();
            this.f38899e.dispose();
        }

        public boolean isDisposed() {
            return this.f38899e.isDisposed();
        }

        public void onComplete() {
            if (!this.f38903i) {
                this.f38903i = true;
                Disposable disposable = this.f38901g;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                if (debounceEmitter != null) {
                    debounceEmitter.run();
                }
                this.f38896b.onComplete();
                this.f38899e.dispose();
            }
        }

        public void onError(Throwable th) {
            if (this.f38903i) {
                RxJavaPlugins.s(th);
                return;
            }
            Disposable disposable = this.f38901g;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f38903i = true;
            this.f38896b.onError(th);
            this.f38899e.dispose();
        }

        public void onNext(T t2) {
            if (!this.f38903i) {
                long j2 = this.f38902h + 1;
                this.f38902h = j2;
                Disposable disposable = this.f38901g;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t2, j2, this);
                this.f38901g = debounceEmitter;
                debounceEmitter.a(this.f38899e.c(debounceEmitter, this.f38897c, this.f38898d));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38900f, disposable)) {
                this.f38900f = disposable;
                this.f38896b.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f38889c = j2;
        this.f38890d = timeUnit;
        this.f38891e = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.f38889c, this.f38890d, this.f38891e.a()));
    }
}
