package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<? extends TRight> f39199c;

    /* renamed from: d  reason: collision with root package name */
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f39200d;

    /* renamed from: e  reason: collision with root package name */
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f39201e;

    /* renamed from: f  reason: collision with root package name */
    final BiFunction<? super TLeft, ? super TRight, ? extends R> f39202f;

    static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.JoinSupport {

        /* renamed from: o  reason: collision with root package name */
        static final Integer f39203o = 1;

        /* renamed from: p  reason: collision with root package name */
        static final Integer f39204p = 2;

        /* renamed from: q  reason: collision with root package name */
        static final Integer f39205q = 3;

        /* renamed from: r  reason: collision with root package name */
        static final Integer f39206r = 4;

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f39207b;

        /* renamed from: c  reason: collision with root package name */
        final SpscLinkedArrayQueue<Object> f39208c = new SpscLinkedArrayQueue<>(Observable.bufferSize());

        /* renamed from: d  reason: collision with root package name */
        final CompositeDisposable f39209d = new CompositeDisposable();

        /* renamed from: e  reason: collision with root package name */
        final Map<Integer, TLeft> f39210e = new LinkedHashMap();

        /* renamed from: f  reason: collision with root package name */
        final Map<Integer, TRight> f39211f = new LinkedHashMap();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Throwable> f39212g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f39213h;

        /* renamed from: i  reason: collision with root package name */
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f39214i;

        /* renamed from: j  reason: collision with root package name */
        final BiFunction<? super TLeft, ? super TRight, ? extends R> f39215j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicInteger f39216k;

        /* renamed from: l  reason: collision with root package name */
        int f39217l;

        /* renamed from: m  reason: collision with root package name */
        int f39218m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f39219n;

        JoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.f39207b = observer;
            this.f39213h = function;
            this.f39214i = function2;
            this.f39215j = biFunction;
            this.f39216k = new AtomicInteger(2);
        }

        public void a(boolean z2, Object obj) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f39208c;
                if (z2) {
                    num = f39203o;
                } else {
                    num = f39204p;
                }
                spscLinkedArrayQueue.m(num, obj);
            }
            g();
        }

        public void b(Throwable th) {
            if (ExceptionHelper.a(this.f39212g, th)) {
                this.f39216k.decrementAndGet();
                g();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void c(boolean z2, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f39208c;
                if (z2) {
                    num = f39205q;
                } else {
                    num = f39206r;
                }
                spscLinkedArrayQueue.m(num, leftRightEndObserver);
            }
            g();
        }

        public void d(Throwable th) {
            if (ExceptionHelper.a(this.f39212g, th)) {
                g();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        public void dispose() {
            if (!this.f39219n) {
                this.f39219n = true;
                f();
                if (getAndIncrement() == 0) {
                    this.f39208c.clear();
                }
            }
        }

        public void e(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.f39209d.c(leftRightObserver);
            this.f39216k.decrementAndGet();
            g();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f39209d.dispose();
        }

        /* access modifiers changed from: package-private */
        public void g() {
            boolean z2;
            boolean z3;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f39208c;
                Observer<? super R> observer = this.f39207b;
                int i2 = 1;
                while (!this.f39219n) {
                    if (this.f39212g.get() != null) {
                        spscLinkedArrayQueue.clear();
                        f();
                        h(observer);
                        return;
                    }
                    if (this.f39216k.get() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    if (num == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2 && z3) {
                        this.f39210e.clear();
                        this.f39211f.clear();
                        this.f39209d.dispose();
                        observer.onComplete();
                        return;
                    } else if (z3) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == f39203o) {
                            int i3 = this.f39217l;
                            this.f39217l = i3 + 1;
                            this.f39210e.put(Integer.valueOf(i3), poll);
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f39213h.apply(poll), "The leftEnd returned a null ObservableSource");
                                ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i3);
                                this.f39209d.b(leftRightEndObserver);
                                observableSource.subscribe(leftRightEndObserver);
                                if (this.f39212g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    f();
                                    h(observer);
                                    return;
                                }
                                for (TRight apply : this.f39211f.values()) {
                                    try {
                                        observer.onNext(ObjectHelper.e(this.f39215j.apply(poll, apply), "The resultSelector returned a null value"));
                                    } catch (Throwable th) {
                                        i(th, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            } catch (Throwable th2) {
                                i(th2, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f39204p) {
                            int i4 = this.f39218m;
                            this.f39218m = i4 + 1;
                            this.f39211f.put(Integer.valueOf(i4), poll);
                            try {
                                ObservableSource observableSource2 = (ObservableSource) ObjectHelper.e(this.f39214i.apply(poll), "The rightEnd returned a null ObservableSource");
                                ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i4);
                                this.f39209d.b(leftRightEndObserver2);
                                observableSource2.subscribe(leftRightEndObserver2);
                                if (this.f39212g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    f();
                                    h(observer);
                                    return;
                                }
                                for (TLeft apply2 : this.f39210e.values()) {
                                    try {
                                        observer.onNext(ObjectHelper.e(this.f39215j.apply(apply2, poll), "The resultSelector returned a null value"));
                                    } catch (Throwable th3) {
                                        i(th3, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            } catch (Throwable th4) {
                                i(th4, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f39205q) {
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                            this.f39210e.remove(Integer.valueOf(leftRightEndObserver3.f39148d));
                            this.f39209d.a(leftRightEndObserver3);
                        } else {
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                            this.f39211f.remove(Integer.valueOf(leftRightEndObserver4.f39148d));
                            this.f39209d.a(leftRightEndObserver4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void h(Observer<?> observer) {
            Throwable b2 = ExceptionHelper.b(this.f39212g);
            this.f39210e.clear();
            this.f39211f.clear();
            observer.onError(b2);
        }

        /* access modifiers changed from: package-private */
        public void i(Throwable th, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.b(th);
            ExceptionHelper.a(this.f39212g, th);
            spscLinkedArrayQueue.clear();
            f();
            h(observer);
        }

        public boolean isDisposed() {
            return this.f39219n;
        }
    }

    public ObservableJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(observableSource);
        this.f39199c = observableSource2;
        this.f39200d = function;
        this.f39201e = function2;
        this.f39202f = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        JoinDisposable joinDisposable = new JoinDisposable(observer, this.f39200d, this.f39201e, this.f39202f);
        observer.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.f39209d.b(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.f39209d.b(leftRightObserver2);
        this.f38612b.subscribe(leftRightObserver);
        this.f39199c.subscribe(leftRightObserver2);
    }
}
