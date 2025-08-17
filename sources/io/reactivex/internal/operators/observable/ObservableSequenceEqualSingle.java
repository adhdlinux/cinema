package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<? extends T> f39492b;

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<? extends T> f39493c;

    /* renamed from: d  reason: collision with root package name */
    final BiPredicate<? super T, ? super T> f39494d;

    /* renamed from: e  reason: collision with root package name */
    final int f39495e;

    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        final SingleObserver<? super Boolean> f39496b;

        /* renamed from: c  reason: collision with root package name */
        final BiPredicate<? super T, ? super T> f39497c;

        /* renamed from: d  reason: collision with root package name */
        final ArrayCompositeDisposable f39498d = new ArrayCompositeDisposable(2);

        /* renamed from: e  reason: collision with root package name */
        final ObservableSource<? extends T> f39499e;

        /* renamed from: f  reason: collision with root package name */
        final ObservableSource<? extends T> f39500f;

        /* renamed from: g  reason: collision with root package name */
        final EqualObserver<T>[] f39501g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f39502h;

        /* renamed from: i  reason: collision with root package name */
        T f39503i;

        /* renamed from: j  reason: collision with root package name */
        T f39504j;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i2, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.f39496b = singleObserver;
            this.f39499e = observableSource;
            this.f39500f = observableSource2;
            this.f39497c = biPredicate;
            EqualObserver<T>[] equalObserverArr = new EqualObserver[2];
            this.f39501g = equalObserverArr;
            equalObserverArr[0] = new EqualObserver<>(this, 0, i2);
            equalObserverArr[1] = new EqualObserver<>(this, 1, i2);
        }

        /* access modifiers changed from: package-private */
        public void a(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.f39502h = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            boolean z2;
            boolean z3;
            Throwable th;
            Throwable th2;
            if (getAndIncrement() == 0) {
                EqualObserver<T>[] equalObserverArr = this.f39501g;
                EqualObserver<T> equalObserver = equalObserverArr[0];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.f39506c;
                EqualObserver<T> equalObserver2 = equalObserverArr[1];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.f39506c;
                int i2 = 1;
                while (!this.f39502h) {
                    boolean z4 = equalObserver.f39508e;
                    if (!z4 || (th2 = equalObserver.f39509f) == null) {
                        boolean z5 = equalObserver2.f39508e;
                        if (!z5 || (th = equalObserver2.f39509f) == null) {
                            if (this.f39503i == null) {
                                this.f39503i = spscLinkedArrayQueue.poll();
                            }
                            if (this.f39503i == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (this.f39504j == null) {
                                this.f39504j = spscLinkedArrayQueue2.poll();
                            }
                            T t2 = this.f39504j;
                            if (t2 == null) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z4 && z5 && z2 && z3) {
                                this.f39496b.onSuccess(Boolean.TRUE);
                                return;
                            } else if (!z4 || !z5 || z2 == z3) {
                                if (!z2 && !z3) {
                                    try {
                                        if (!this.f39497c.test(this.f39503i, t2)) {
                                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                            this.f39496b.onSuccess(Boolean.FALSE);
                                            return;
                                        }
                                        this.f39503i = null;
                                        this.f39504j = null;
                                    } catch (Throwable th3) {
                                        Exceptions.b(th3);
                                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                        this.f39496b.onError(th3);
                                        return;
                                    }
                                }
                                if ((z2 || z3) && (i2 = addAndGet(-i2)) == 0) {
                                    return;
                                }
                            } else {
                                a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.f39496b.onSuccess(Boolean.FALSE);
                                return;
                            }
                        } else {
                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f39496b.onError(th);
                            return;
                        }
                    } else {
                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.f39496b.onError(th2);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(Disposable disposable, int i2) {
            return this.f39498d.a(i2, disposable);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            EqualObserver<T>[] equalObserverArr = this.f39501g;
            this.f39499e.subscribe(equalObserverArr[0]);
            this.f39500f.subscribe(equalObserverArr[1]);
        }

        public void dispose() {
            if (!this.f39502h) {
                this.f39502h = true;
                this.f39498d.dispose();
                if (getAndIncrement() == 0) {
                    EqualObserver<T>[] equalObserverArr = this.f39501g;
                    equalObserverArr[0].f39506c.clear();
                    equalObserverArr[1].f39506c.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f39502h;
        }
    }

    static final class EqualObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final EqualCoordinator<T> f39505b;

        /* renamed from: c  reason: collision with root package name */
        final SpscLinkedArrayQueue<T> f39506c;

        /* renamed from: d  reason: collision with root package name */
        final int f39507d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f39508e;

        /* renamed from: f  reason: collision with root package name */
        Throwable f39509f;

        EqualObserver(EqualCoordinator<T> equalCoordinator, int i2, int i3) {
            this.f39505b = equalCoordinator;
            this.f39507d = i2;
            this.f39506c = new SpscLinkedArrayQueue<>(i3);
        }

        public void onComplete() {
            this.f39508e = true;
            this.f39505b.b();
        }

        public void onError(Throwable th) {
            this.f39509f = th;
            this.f39508e = true;
            this.f39505b.b();
        }

        public void onNext(T t2) {
            this.f39506c.offer(t2);
            this.f39505b.b();
        }

        public void onSubscribe(Disposable disposable) {
            this.f39505b.c(disposable, this.f39507d);
        }
    }

    public ObservableSequenceEqualSingle(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i2) {
        this.f39492b = observableSource;
        this.f39493c = observableSource2;
        this.f39494d = biPredicate;
        this.f39495e = i2;
    }

    public Observable<Boolean> b() {
        return RxJavaPlugins.n(new ObservableSequenceEqual(this.f39492b, this.f39493c, this.f39494d, this.f39495e));
    }

    public void j(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f39495e, this.f39492b, this.f39493c, this.f39494d);
        singleObserver.onSubscribe(equalCoordinator);
        equalCoordinator.d();
    }
}
