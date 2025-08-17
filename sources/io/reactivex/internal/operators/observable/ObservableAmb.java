package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableAmb<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<? extends T>[] f38650b;

    /* renamed from: c  reason: collision with root package name */
    final Iterable<? extends ObservableSource<? extends T>> f38651c;

    static final class AmbCoordinator<T> implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f38652b;

        /* renamed from: c  reason: collision with root package name */
        final AmbInnerObserver<T>[] f38653c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f38654d = new AtomicInteger();

        AmbCoordinator(Observer<? super T> observer, int i2) {
            this.f38652b = observer;
            this.f38653c = new AmbInnerObserver[i2];
        }

        public void a(ObservableSource<? extends T>[] observableSourceArr) {
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f38653c;
            int length = ambInnerObserverArr.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                ambInnerObserverArr[i2] = new AmbInnerObserver<>(this, i3, this.f38652b);
                i2 = i3;
            }
            this.f38654d.lazySet(0);
            this.f38652b.onSubscribe(this);
            for (int i4 = 0; i4 < length && this.f38654d.get() == 0; i4++) {
                observableSourceArr[i4].subscribe(ambInnerObserverArr[i4]);
            }
        }

        public boolean b(int i2) {
            int i3 = this.f38654d.get();
            int i4 = 0;
            if (i3 == 0) {
                if (!this.f38654d.compareAndSet(0, i2)) {
                    return false;
                }
                AmbInnerObserver<T>[] ambInnerObserverArr = this.f38653c;
                int length = ambInnerObserverArr.length;
                while (i4 < length) {
                    int i5 = i4 + 1;
                    if (i5 != i2) {
                        ambInnerObserverArr[i4].a();
                    }
                    i4 = i5;
                }
                return true;
            } else if (i3 == i2) {
                return true;
            } else {
                return false;
            }
        }

        public void dispose() {
            if (this.f38654d.get() != -1) {
                this.f38654d.lazySet(-1);
                for (AmbInnerObserver<T> a2 : this.f38653c) {
                    a2.a();
                }
            }
        }

        public boolean isDisposed() {
            return this.f38654d.get() == -1;
        }
    }

    static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final AmbCoordinator<T> f38655b;

        /* renamed from: c  reason: collision with root package name */
        final int f38656c;

        /* renamed from: d  reason: collision with root package name */
        final Observer<? super T> f38657d;

        /* renamed from: e  reason: collision with root package name */
        boolean f38658e;

        AmbInnerObserver(AmbCoordinator<T> ambCoordinator, int i2, Observer<? super T> observer) {
            this.f38655b = ambCoordinator;
            this.f38656c = i2;
            this.f38657d = observer;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            if (this.f38658e) {
                this.f38657d.onComplete();
            } else if (this.f38655b.b(this.f38656c)) {
                this.f38658e = true;
                this.f38657d.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.f38658e) {
                this.f38657d.onError(th);
            } else if (this.f38655b.b(this.f38656c)) {
                this.f38658e = true;
                this.f38657d.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        public void onNext(T t2) {
            if (this.f38658e) {
                this.f38657d.onNext(t2);
            } else if (this.f38655b.b(this.f38656c)) {
                this.f38658e = true;
                this.f38657d.onNext(t2);
            } else {
                ((Disposable) get()).dispose();
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }
    }

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.f38650b = observableSourceArr;
        this.f38651c = iterable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        int i2;
        ObservableSource<? extends T>[] observableSourceArr = this.f38650b;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            try {
                i2 = 0;
                for (ObservableSource<? extends T> observableSource : this.f38651c) {
                    if (observableSource == null) {
                        EmptyDisposable.e(new NullPointerException("One of the sources is null"), observer);
                        return;
                    }
                    if (i2 == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i2 >> 2) + i2)];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i2);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i3 = i2 + 1;
                    observableSourceArr[i2] = observableSource;
                    i2 = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.e(th, observer);
                return;
            }
        } else {
            i2 = observableSourceArr.length;
        }
        if (i2 == 0) {
            EmptyDisposable.c(observer);
        } else if (i2 == 1) {
            observableSourceArr[0].subscribe(observer);
        } else {
            new AmbCoordinator(observer, i2).a(observableSourceArr);
        }
    }
}
