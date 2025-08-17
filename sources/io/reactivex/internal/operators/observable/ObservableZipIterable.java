package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

public final class ObservableZipIterable<T, U, V> extends Observable<V> {

    /* renamed from: b  reason: collision with root package name */
    final Observable<? extends T> f39883b;

    /* renamed from: c  reason: collision with root package name */
    final Iterable<U> f39884c;

    /* renamed from: d  reason: collision with root package name */
    final BiFunction<? super T, ? super U, ? extends V> f39885d;

    static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super V> f39886b;

        /* renamed from: c  reason: collision with root package name */
        final Iterator<U> f39887c;

        /* renamed from: d  reason: collision with root package name */
        final BiFunction<? super T, ? super U, ? extends V> f39888d;

        /* renamed from: e  reason: collision with root package name */
        Disposable f39889e;

        /* renamed from: f  reason: collision with root package name */
        boolean f39890f;

        ZipIterableObserver(Observer<? super V> observer, Iterator<U> it2, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.f39886b = observer;
            this.f39887c = it2;
            this.f39888d = biFunction;
        }

        /* access modifiers changed from: package-private */
        public void a(Throwable th) {
            this.f39890f = true;
            this.f39889e.dispose();
            this.f39886b.onError(th);
        }

        public void dispose() {
            this.f39889e.dispose();
        }

        public boolean isDisposed() {
            return this.f39889e.isDisposed();
        }

        public void onComplete() {
            if (!this.f39890f) {
                this.f39890f = true;
                this.f39886b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f39890f) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f39890f = true;
            this.f39886b.onError(th);
        }

        public void onNext(T t2) {
            if (!this.f39890f) {
                try {
                    try {
                        this.f39886b.onNext(ObjectHelper.e(this.f39888d.apply(t2, ObjectHelper.e(this.f39887c.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                        try {
                            if (!this.f39887c.hasNext()) {
                                this.f39890f = true;
                                this.f39889e.dispose();
                                this.f39886b.onComplete();
                            }
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            a(th);
                        }
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        a(th2);
                    }
                } catch (Throwable th3) {
                    Exceptions.b(th3);
                    a(th3);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39889e, disposable)) {
                this.f39889e = disposable;
                this.f39886b.onSubscribe(this);
            }
        }
    }

    public ObservableZipIterable(Observable<? extends T> observable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.f39883b = observable;
        this.f39884c = iterable;
        this.f39885d = biFunction;
    }

    public void subscribeActual(Observer<? super V> observer) {
        try {
            Iterator it2 = (Iterator) ObjectHelper.e(this.f39884c.iterator(), "The iterator returned by other is null");
            try {
                if (!it2.hasNext()) {
                    EmptyDisposable.c(observer);
                } else {
                    this.f39883b.subscribe(new ZipIterableObserver(observer, it2, this.f39885d));
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
