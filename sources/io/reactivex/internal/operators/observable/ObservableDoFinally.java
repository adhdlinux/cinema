package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final Action f38946c;

    static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f38947b;

        /* renamed from: c  reason: collision with root package name */
        final Action f38948c;

        /* renamed from: d  reason: collision with root package name */
        Disposable f38949d;

        /* renamed from: e  reason: collision with root package name */
        QueueDisposable<T> f38950e;

        /* renamed from: f  reason: collision with root package name */
        boolean f38951f;

        DoFinallyObserver(Observer<? super T> observer, Action action) {
            this.f38947b = observer;
            this.f38948c = action;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f38948c.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        public int b(int i2) {
            QueueDisposable<T> queueDisposable = this.f38950e;
            boolean z2 = false;
            if (queueDisposable == null || (i2 & 4) != 0) {
                return 0;
            }
            int b2 = queueDisposable.b(i2);
            if (b2 != 0) {
                if (b2 == 1) {
                    z2 = true;
                }
                this.f38951f = z2;
            }
            return b2;
        }

        public void clear() {
            this.f38950e.clear();
        }

        public void dispose() {
            this.f38949d.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f38949d.isDisposed();
        }

        public boolean isEmpty() {
            return this.f38950e.isEmpty();
        }

        public void onComplete() {
            this.f38947b.onComplete();
            a();
        }

        public void onError(Throwable th) {
            this.f38947b.onError(th);
            a();
        }

        public void onNext(T t2) {
            this.f38947b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38949d, disposable)) {
                this.f38949d = disposable;
                if (disposable instanceof QueueDisposable) {
                    this.f38950e = (QueueDisposable) disposable;
                }
                this.f38947b.onSubscribe(this);
            }
        }

        public T poll() throws Exception {
            T poll = this.f38950e.poll();
            if (poll == null && this.f38951f) {
                a();
            }
            return poll;
        }
    }

    public ObservableDoFinally(ObservableSource<T> observableSource, Action action) {
        super(observableSource);
        this.f38946c = action;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new DoFinallyObserver(observer, this.f38946c));
    }
}
