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
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableZip<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<? extends T>[] f39867b;

    /* renamed from: c  reason: collision with root package name */
    final Iterable<? extends ObservableSource<? extends T>> f39868c;

    /* renamed from: d  reason: collision with root package name */
    final Function<? super Object[], ? extends R> f39869d;

    /* renamed from: e  reason: collision with root package name */
    final int f39870e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f39871f;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f39872b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super Object[], ? extends R> f39873c;

        /* renamed from: d  reason: collision with root package name */
        final ZipObserver<T, R>[] f39874d;

        /* renamed from: e  reason: collision with root package name */
        final T[] f39875e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f39876f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f39877g;

        ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i2, boolean z2) {
            this.f39872b = observer;
            this.f39873c = function;
            this.f39874d = new ZipObserver[i2];
            this.f39875e = new Object[i2];
            this.f39876f = z2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            d();
            b();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            for (ZipObserver<T, R> a2 : this.f39874d) {
                a2.a();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(boolean z2, boolean z3, Observer<? super R> observer, boolean z4, ZipObserver<?, ?> zipObserver) {
            if (this.f39877g) {
                a();
                return true;
            } else if (!z2) {
                return false;
            } else {
                if (!z4) {
                    Throwable th = zipObserver.f39881e;
                    if (th != null) {
                        this.f39877g = true;
                        a();
                        observer.onError(th);
                        return true;
                    } else if (!z3) {
                        return false;
                    } else {
                        this.f39877g = true;
                        a();
                        observer.onComplete();
                        return true;
                    }
                } else if (!z3) {
                    return false;
                } else {
                    Throwable th2 = zipObserver.f39881e;
                    this.f39877g = true;
                    a();
                    if (th2 != null) {
                        observer.onError(th2);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            for (ZipObserver<T, R> zipObserver : this.f39874d) {
                zipObserver.f39879c.clear();
            }
        }

        public void dispose() {
            if (!this.f39877g) {
                this.f39877g = true;
                b();
                if (getAndIncrement() == 0) {
                    d();
                }
            }
        }

        public void e() {
            Throwable th;
            boolean z2;
            if (getAndIncrement() == 0) {
                ZipObserver<T, R>[] zipObserverArr = this.f39874d;
                Observer<? super R> observer = this.f39872b;
                T[] tArr = this.f39875e;
                boolean z3 = this.f39876f;
                int i2 = 1;
                while (true) {
                    int i3 = 0;
                    int i4 = 0;
                    for (ZipObserver<T, R> zipObserver : zipObserverArr) {
                        if (tArr[i4] == null) {
                            boolean z4 = zipObserver.f39880d;
                            T poll = zipObserver.f39879c.poll();
                            if (poll == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!c(z4, z2, observer, z3, zipObserver)) {
                                if (!z2) {
                                    tArr[i4] = poll;
                                } else {
                                    i3++;
                                }
                            } else {
                                return;
                            }
                        } else if (zipObserver.f39880d && !z3 && (th = zipObserver.f39881e) != null) {
                            this.f39877g = true;
                            a();
                            observer.onError(th);
                            return;
                        }
                        i4++;
                    }
                    if (i3 != 0) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        try {
                            observer.onNext(ObjectHelper.e(this.f39873c.apply(tArr.clone()), "The zipper returned a null value"));
                            Arrays.fill(tArr, (Object) null);
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            a();
                            observer.onError(th2);
                            return;
                        }
                    }
                }
            }
        }

        public void f(ObservableSource<? extends T>[] observableSourceArr, int i2) {
            ZipObserver<T, R>[] zipObserverArr = this.f39874d;
            int length = zipObserverArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                zipObserverArr[i3] = new ZipObserver<>(this, i2);
            }
            lazySet(0);
            this.f39872b.onSubscribe(this);
            for (int i4 = 0; i4 < length && !this.f39877g; i4++) {
                observableSourceArr[i4].subscribe(zipObserverArr[i4]);
            }
        }

        public boolean isDisposed() {
            return this.f39877g;
        }
    }

    static final class ZipObserver<T, R> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final ZipCoordinator<T, R> f39878b;

        /* renamed from: c  reason: collision with root package name */
        final SpscLinkedArrayQueue<T> f39879c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f39880d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f39881e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicReference<Disposable> f39882f = new AtomicReference<>();

        ZipObserver(ZipCoordinator<T, R> zipCoordinator, int i2) {
            this.f39878b = zipCoordinator;
            this.f39879c = new SpscLinkedArrayQueue<>(i2);
        }

        public void a() {
            DisposableHelper.a(this.f39882f);
        }

        public void onComplete() {
            this.f39880d = true;
            this.f39878b.e();
        }

        public void onError(Throwable th) {
            this.f39881e = th;
            this.f39880d = true;
            this.f39878b.e();
        }

        public void onNext(T t2) {
            this.f39879c.offer(t2);
            this.f39878b.e();
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this.f39882f, disposable);
        }
    }

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2, boolean z2) {
        this.f39867b = observableSourceArr;
        this.f39868c = iterable;
        this.f39869d = function;
        this.f39870e = i2;
        this.f39871f = z2;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i2;
        ObservableSource<? extends T>[] observableSourceArr = this.f39867b;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            i2 = 0;
            for (ObservableSource<? extends T> observableSource : this.f39868c) {
                if (i2 == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i2 >> 2) + i2)];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i2);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[i2] = observableSource;
                i2++;
            }
        } else {
            i2 = observableSourceArr.length;
        }
        if (i2 == 0) {
            EmptyDisposable.c(observer);
        } else {
            new ZipCoordinator(observer, this.f39869d, i2, this.f39871f).f(observableSourceArr, this.f39870e);
        }
    }
}
