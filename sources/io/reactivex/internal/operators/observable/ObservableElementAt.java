package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final long f38965c;

    /* renamed from: d  reason: collision with root package name */
    final T f38966d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f38967e;

    static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f38968b;

        /* renamed from: c  reason: collision with root package name */
        final long f38969c;

        /* renamed from: d  reason: collision with root package name */
        final T f38970d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f38971e;

        /* renamed from: f  reason: collision with root package name */
        Disposable f38972f;

        /* renamed from: g  reason: collision with root package name */
        long f38973g;

        /* renamed from: h  reason: collision with root package name */
        boolean f38974h;

        ElementAtObserver(Observer<? super T> observer, long j2, T t2, boolean z2) {
            this.f38968b = observer;
            this.f38969c = j2;
            this.f38970d = t2;
            this.f38971e = z2;
        }

        public void dispose() {
            this.f38972f.dispose();
        }

        public boolean isDisposed() {
            return this.f38972f.isDisposed();
        }

        public void onComplete() {
            if (!this.f38974h) {
                this.f38974h = true;
                T t2 = this.f38970d;
                if (t2 != null || !this.f38971e) {
                    if (t2 != null) {
                        this.f38968b.onNext(t2);
                    }
                    this.f38968b.onComplete();
                    return;
                }
                this.f38968b.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th) {
            if (this.f38974h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38974h = true;
            this.f38968b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f38974h) {
                long j2 = this.f38973g;
                if (j2 == this.f38969c) {
                    this.f38974h = true;
                    this.f38972f.dispose();
                    this.f38968b.onNext(t2);
                    this.f38968b.onComplete();
                    return;
                }
                this.f38973g = j2 + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38972f, disposable)) {
                this.f38972f = disposable;
                this.f38968b.onSubscribe(this);
            }
        }
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j2, T t2, boolean z2) {
        super(observableSource);
        this.f38965c = j2;
        this.f38966d = t2;
        this.f38967e = z2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f38612b.subscribe(new ElementAtObserver(observer, this.f38965c, this.f38966d, this.f38967e));
    }
}
