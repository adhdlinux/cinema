package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

public final class ObservableFromIterable<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends T> f39081b;

    static final class FromIterableDisposable<T> extends BasicQueueDisposable<T> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39082b;

        /* renamed from: c  reason: collision with root package name */
        final Iterator<? extends T> f39083c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f39084d;

        /* renamed from: e  reason: collision with root package name */
        boolean f39085e;

        /* renamed from: f  reason: collision with root package name */
        boolean f39086f;

        /* renamed from: g  reason: collision with root package name */
        boolean f39087g;

        FromIterableDisposable(Observer<? super T> observer, Iterator<? extends T> it2) {
            this.f39082b = observer;
            this.f39083c = it2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            while (!isDisposed()) {
                try {
                    this.f39082b.onNext(ObjectHelper.e(this.f39083c.next(), "The iterator returned a null value"));
                    if (!isDisposed()) {
                        try {
                            if (!this.f39083c.hasNext()) {
                                if (!isDisposed()) {
                                    this.f39082b.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            this.f39082b.onError(th);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f39082b.onError(th2);
                    return;
                }
            }
        }

        public int b(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f39085e = true;
            return 1;
        }

        public void clear() {
            this.f39086f = true;
        }

        public void dispose() {
            this.f39084d = true;
        }

        public boolean isDisposed() {
            return this.f39084d;
        }

        public boolean isEmpty() {
            return this.f39086f;
        }

        public T poll() {
            if (this.f39086f) {
                return null;
            }
            if (!this.f39087g) {
                this.f39087g = true;
            } else if (!this.f39083c.hasNext()) {
                this.f39086f = true;
                return null;
            }
            return ObjectHelper.e(this.f39083c.next(), "The iterator returned a null value");
        }
    }

    public ObservableFromIterable(Iterable<? extends T> iterable) {
        this.f39081b = iterable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Iterator<? extends T> it2 = this.f39081b.iterator();
            try {
                if (!it2.hasNext()) {
                    EmptyDisposable.c(observer);
                    return;
                }
                FromIterableDisposable fromIterableDisposable = new FromIterableDisposable(observer, it2);
                observer.onSubscribe(fromIterableDisposable);
                if (!fromIterableDisposable.f39085e) {
                    fromIterableDisposable.a();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.e(th, observer);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptyDisposable.e(th2, observer);
        }
    }
}
