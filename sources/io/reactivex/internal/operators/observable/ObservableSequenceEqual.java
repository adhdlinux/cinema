package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSequenceEqual<T> extends Observable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<? extends T> f39474b;

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<? extends T> f39475c;

    /* renamed from: d  reason: collision with root package name */
    final BiPredicate<? super T, ? super T> f39476d;

    /* renamed from: e  reason: collision with root package name */
    final int f39477e;

    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super Boolean> f39478b;

        /* renamed from: c  reason: collision with root package name */
        final BiPredicate<? super T, ? super T> f39479c;

        /* renamed from: d  reason: collision with root package name */
        final ArrayCompositeDisposable f39480d = new ArrayCompositeDisposable(2);

        /* renamed from: e  reason: collision with root package name */
        final ObservableSource<? extends T> f39481e;

        /* renamed from: f  reason: collision with root package name */
        final ObservableSource<? extends T> f39482f;

        /* renamed from: g  reason: collision with root package name */
        final EqualObserver<T>[] f39483g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f39484h;

        /* renamed from: i  reason: collision with root package name */
        T f39485i;

        /* renamed from: j  reason: collision with root package name */
        T f39486j;

        EqualCoordinator(Observer<? super Boolean> observer, int i2, ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
            this.f39478b = observer;
            this.f39481e = observableSource;
            this.f39482f = observableSource2;
            this.f39479c = biPredicate;
            EqualObserver<T>[] equalObserverArr = new EqualObserver[2];
            this.f39483g = equalObserverArr;
            equalObserverArr[0] = new EqualObserver<>(this, 0, i2);
            equalObserverArr[1] = new EqualObserver<>(this, 1, i2);
        }

        /* access modifiers changed from: package-private */
        public void a(SpscLinkedArrayQueue<T> spscLinkedArrayQueue, SpscLinkedArrayQueue<T> spscLinkedArrayQueue2) {
            this.f39484h = true;
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
                EqualObserver<T>[] equalObserverArr = this.f39483g;
                EqualObserver<T> equalObserver = equalObserverArr[0];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = equalObserver.f39488c;
                EqualObserver<T> equalObserver2 = equalObserverArr[1];
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = equalObserver2.f39488c;
                int i2 = 1;
                while (!this.f39484h) {
                    boolean z4 = equalObserver.f39490e;
                    if (!z4 || (th2 = equalObserver.f39491f) == null) {
                        boolean z5 = equalObserver2.f39490e;
                        if (!z5 || (th = equalObserver2.f39491f) == null) {
                            if (this.f39485i == null) {
                                this.f39485i = spscLinkedArrayQueue.poll();
                            }
                            if (this.f39485i == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (this.f39486j == null) {
                                this.f39486j = spscLinkedArrayQueue2.poll();
                            }
                            T t2 = this.f39486j;
                            if (t2 == null) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z4 && z5 && z2 && z3) {
                                this.f39478b.onNext(Boolean.TRUE);
                                this.f39478b.onComplete();
                                return;
                            } else if (!z4 || !z5 || z2 == z3) {
                                if (!z2 && !z3) {
                                    try {
                                        if (!this.f39479c.test(this.f39485i, t2)) {
                                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                            this.f39478b.onNext(Boolean.FALSE);
                                            this.f39478b.onComplete();
                                            return;
                                        }
                                        this.f39485i = null;
                                        this.f39486j = null;
                                    } catch (Throwable th3) {
                                        Exceptions.b(th3);
                                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                        this.f39478b.onError(th3);
                                        return;
                                    }
                                }
                                if ((z2 || z3) && (i2 = addAndGet(-i2)) == 0) {
                                    return;
                                }
                            } else {
                                a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                                this.f39478b.onNext(Boolean.FALSE);
                                this.f39478b.onComplete();
                                return;
                            }
                        } else {
                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f39478b.onError(th);
                            return;
                        }
                    } else {
                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.f39478b.onError(th2);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
                spscLinkedArrayQueue2.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(Disposable disposable, int i2) {
            return this.f39480d.a(i2, disposable);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            EqualObserver<T>[] equalObserverArr = this.f39483g;
            this.f39481e.subscribe(equalObserverArr[0]);
            this.f39482f.subscribe(equalObserverArr[1]);
        }

        public void dispose() {
            if (!this.f39484h) {
                this.f39484h = true;
                this.f39480d.dispose();
                if (getAndIncrement() == 0) {
                    EqualObserver<T>[] equalObserverArr = this.f39483g;
                    equalObserverArr[0].f39488c.clear();
                    equalObserverArr[1].f39488c.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f39484h;
        }
    }

    static final class EqualObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final EqualCoordinator<T> f39487b;

        /* renamed from: c  reason: collision with root package name */
        final SpscLinkedArrayQueue<T> f39488c;

        /* renamed from: d  reason: collision with root package name */
        final int f39489d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f39490e;

        /* renamed from: f  reason: collision with root package name */
        Throwable f39491f;

        EqualObserver(EqualCoordinator<T> equalCoordinator, int i2, int i3) {
            this.f39487b = equalCoordinator;
            this.f39489d = i2;
            this.f39488c = new SpscLinkedArrayQueue<>(i3);
        }

        public void onComplete() {
            this.f39490e = true;
            this.f39487b.b();
        }

        public void onError(Throwable th) {
            this.f39491f = th;
            this.f39490e = true;
            this.f39487b.b();
        }

        public void onNext(T t2) {
            this.f39488c.offer(t2);
            this.f39487b.b();
        }

        public void onSubscribe(Disposable disposable) {
            this.f39487b.c(disposable, this.f39489d);
        }
    }

    public ObservableSequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i2) {
        this.f39474b = observableSource;
        this.f39475c = observableSource2;
        this.f39476d = biPredicate;
        this.f39477e = i2;
    }

    public void subscribeActual(Observer<? super Boolean> observer) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(observer, this.f39477e, this.f39474b, this.f39475c, this.f39476d);
        observer.onSubscribe(equalCoordinator);
        equalCoordinator.d();
    }
}
