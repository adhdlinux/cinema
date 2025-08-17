package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableConcatMapEager<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<? extends R>> f38838c;

    /* renamed from: d  reason: collision with root package name */
    final ErrorMode f38839d;

    /* renamed from: e  reason: collision with root package name */
    final int f38840e;

    /* renamed from: f  reason: collision with root package name */
    final int f38841f;

    static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f38842b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends R>> f38843c;

        /* renamed from: d  reason: collision with root package name */
        final int f38844d;

        /* renamed from: e  reason: collision with root package name */
        final int f38845e;

        /* renamed from: f  reason: collision with root package name */
        final ErrorMode f38846f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicThrowable f38847g = new AtomicThrowable();

        /* renamed from: h  reason: collision with root package name */
        final ArrayDeque<InnerQueuedObserver<R>> f38848h = new ArrayDeque<>();

        /* renamed from: i  reason: collision with root package name */
        SimpleQueue<T> f38849i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f38850j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f38851k;

        /* renamed from: l  reason: collision with root package name */
        int f38852l;

        /* renamed from: m  reason: collision with root package name */
        volatile boolean f38853m;

        /* renamed from: n  reason: collision with root package name */
        InnerQueuedObserver<R> f38854n;

        /* renamed from: o  reason: collision with root package name */
        int f38855o;

        ConcatMapEagerMainObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, int i3, ErrorMode errorMode) {
            this.f38842b = observer;
            this.f38843c = function;
            this.f38844d = i2;
            this.f38845e = i3;
            this.f38846f = errorMode;
        }

        public void a() {
            boolean z2;
            boolean z3;
            if (getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.f38849i;
                ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.f38848h;
                Observer<? super R> observer = this.f38842b;
                ErrorMode errorMode = this.f38846f;
                int i2 = 1;
                while (true) {
                    int i3 = this.f38855o;
                    while (true) {
                        if (i3 == this.f38844d) {
                            break;
                        } else if (this.f38853m) {
                            simpleQueue.clear();
                            e();
                            return;
                        } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f38847g.get()) == null) {
                            try {
                                T poll = simpleQueue.poll();
                                if (poll == null) {
                                    break;
                                }
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f38843c.apply(poll), "The mapper returned a null ObservableSource");
                                InnerQueuedObserver innerQueuedObserver = new InnerQueuedObserver(this, this.f38845e);
                                arrayDeque.offer(innerQueuedObserver);
                                observableSource.subscribe(innerQueuedObserver);
                                i3++;
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                this.f38850j.dispose();
                                simpleQueue.clear();
                                e();
                                this.f38847g.a(th);
                                observer.onError(this.f38847g.b());
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            e();
                            observer.onError(this.f38847g.b());
                            return;
                        }
                    }
                    this.f38855o = i3;
                    if (this.f38853m) {
                        simpleQueue.clear();
                        e();
                        return;
                    } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f38847g.get()) == null) {
                        InnerQueuedObserver<R> innerQueuedObserver2 = this.f38854n;
                        if (innerQueuedObserver2 == null) {
                            if (errorMode != ErrorMode.BOUNDARY || ((Throwable) this.f38847g.get()) == null) {
                                boolean z4 = this.f38851k;
                                InnerQueuedObserver<R> poll2 = arrayDeque.poll();
                                if (poll2 == null) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (!z4 || !z3) {
                                    if (!z3) {
                                        this.f38854n = poll2;
                                    }
                                    innerQueuedObserver2 = poll2;
                                } else if (((Throwable) this.f38847g.get()) != null) {
                                    simpleQueue.clear();
                                    e();
                                    observer.onError(this.f38847g.b());
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            } else {
                                simpleQueue.clear();
                                e();
                                observer.onError(this.f38847g.b());
                                return;
                            }
                        }
                        if (innerQueuedObserver2 != null) {
                            SimpleQueue<R> b2 = innerQueuedObserver2.b();
                            while (!this.f38853m) {
                                boolean a2 = innerQueuedObserver2.a();
                                if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.f38847g.get()) == null) {
                                    try {
                                        R poll3 = b2.poll();
                                        if (poll3 == null) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (a2 && z2) {
                                            this.f38854n = null;
                                            this.f38855o--;
                                        } else if (!z2) {
                                            observer.onNext(poll3);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.b(th2);
                                        this.f38847g.a(th2);
                                        this.f38854n = null;
                                        this.f38855o--;
                                    }
                                } else {
                                    simpleQueue.clear();
                                    e();
                                    observer.onError(this.f38847g.b());
                                    return;
                                }
                            }
                            simpleQueue.clear();
                            e();
                            return;
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        e();
                        observer.onError(this.f38847g.b());
                        return;
                    }
                }
            }
        }

        public void b(InnerQueuedObserver<R> innerQueuedObserver, Throwable th) {
            if (this.f38847g.a(th)) {
                if (this.f38846f == ErrorMode.IMMEDIATE) {
                    this.f38850j.dispose();
                }
                innerQueuedObserver.c();
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void c(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.c();
            a();
        }

        public void d(InnerQueuedObserver<R> innerQueuedObserver, R r2) {
            innerQueuedObserver.b().offer(r2);
            a();
        }

        public void dispose() {
            if (!this.f38853m) {
                this.f38853m = true;
                this.f38850j.dispose();
                f();
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            InnerQueuedObserver<R> innerQueuedObserver = this.f38854n;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver poll = this.f38848h.poll();
                if (poll != null) {
                    poll.dispose();
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            if (getAndIncrement() == 0) {
                do {
                    this.f38849i.clear();
                    e();
                } while (decrementAndGet() != 0);
            }
        }

        public boolean isDisposed() {
            return this.f38853m;
        }

        public void onComplete() {
            this.f38851k = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.f38847g.a(th)) {
                this.f38851k = true;
                a();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            if (this.f38852l == 0) {
                this.f38849i.offer(t2);
            }
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38850j, disposable)) {
                this.f38850j = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int b2 = queueDisposable.b(3);
                    if (b2 == 1) {
                        this.f38852l = b2;
                        this.f38849i = queueDisposable;
                        this.f38851k = true;
                        this.f38842b.onSubscribe(this);
                        a();
                        return;
                    } else if (b2 == 2) {
                        this.f38852l = b2;
                        this.f38849i = queueDisposable;
                        this.f38842b.onSubscribe(this);
                        return;
                    }
                }
                this.f38849i = new SpscLinkedArrayQueue(this.f38845e);
                this.f38842b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapEager(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, ErrorMode errorMode, int i2, int i3) {
        super(observableSource);
        this.f38838c = function;
        this.f38839d = errorMode;
        this.f38840e = i2;
        this.f38841f = i3;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        this.f38612b.subscribe(new ConcatMapEagerMainObserver(observer, this.f38838c, this.f38840e, this.f38841f, this.f38839d));
    }
}
