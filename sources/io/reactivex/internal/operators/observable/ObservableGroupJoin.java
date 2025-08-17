package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<? extends TRight> f39125c;

    /* renamed from: d  reason: collision with root package name */
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f39126d;

    /* renamed from: e  reason: collision with root package name */
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f39127e;

    /* renamed from: f  reason: collision with root package name */
    final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> f39128f;

    static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, JoinSupport {

        /* renamed from: o  reason: collision with root package name */
        static final Integer f39129o = 1;

        /* renamed from: p  reason: collision with root package name */
        static final Integer f39130p = 2;

        /* renamed from: q  reason: collision with root package name */
        static final Integer f39131q = 3;

        /* renamed from: r  reason: collision with root package name */
        static final Integer f39132r = 4;

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f39133b;

        /* renamed from: c  reason: collision with root package name */
        final SpscLinkedArrayQueue<Object> f39134c = new SpscLinkedArrayQueue<>(Observable.bufferSize());

        /* renamed from: d  reason: collision with root package name */
        final CompositeDisposable f39135d = new CompositeDisposable();

        /* renamed from: e  reason: collision with root package name */
        final Map<Integer, UnicastSubject<TRight>> f39136e = new LinkedHashMap();

        /* renamed from: f  reason: collision with root package name */
        final Map<Integer, TRight> f39137f = new LinkedHashMap();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Throwable> f39138g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> f39139h;

        /* renamed from: i  reason: collision with root package name */
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> f39140i;

        /* renamed from: j  reason: collision with root package name */
        final BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> f39141j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicInteger f39142k;

        /* renamed from: l  reason: collision with root package name */
        int f39143l;

        /* renamed from: m  reason: collision with root package name */
        int f39144m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f39145n;

        GroupJoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
            this.f39133b = observer;
            this.f39139h = function;
            this.f39140i = function2;
            this.f39141j = biFunction;
            this.f39142k = new AtomicInteger(2);
        }

        public void a(boolean z2, Object obj) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f39134c;
                if (z2) {
                    num = f39129o;
                } else {
                    num = f39130p;
                }
                spscLinkedArrayQueue.m(num, obj);
            }
            g();
        }

        public void b(Throwable th) {
            if (ExceptionHelper.a(this.f39138g, th)) {
                this.f39142k.decrementAndGet();
                g();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void c(boolean z2, LeftRightEndObserver leftRightEndObserver) {
            Integer num;
            synchronized (this) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f39134c;
                if (z2) {
                    num = f39131q;
                } else {
                    num = f39132r;
                }
                spscLinkedArrayQueue.m(num, leftRightEndObserver);
            }
            g();
        }

        public void d(Throwable th) {
            if (ExceptionHelper.a(this.f39138g, th)) {
                g();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        public void dispose() {
            if (!this.f39145n) {
                this.f39145n = true;
                f();
                if (getAndIncrement() == 0) {
                    this.f39134c.clear();
                }
            }
        }

        public void e(LeftRightObserver leftRightObserver) {
            this.f39135d.c(leftRightObserver);
            this.f39142k.decrementAndGet();
            g();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f39135d.dispose();
        }

        /* access modifiers changed from: package-private */
        public void g() {
            boolean z2;
            boolean z3;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.f39134c;
                Observer<? super R> observer = this.f39133b;
                int i2 = 1;
                while (!this.f39145n) {
                    if (this.f39138g.get() != null) {
                        spscLinkedArrayQueue.clear();
                        f();
                        h(observer);
                        return;
                    }
                    if (this.f39142k.get() == 0) {
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
                        for (UnicastSubject<TRight> onComplete : this.f39136e.values()) {
                            onComplete.onComplete();
                        }
                        this.f39136e.clear();
                        this.f39137f.clear();
                        this.f39135d.dispose();
                        observer.onComplete();
                        return;
                    } else if (z3) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == f39129o) {
                            UnicastSubject c2 = UnicastSubject.c();
                            int i3 = this.f39143l;
                            this.f39143l = i3 + 1;
                            this.f39136e.put(Integer.valueOf(i3), c2);
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f39139h.apply(poll), "The leftEnd returned a null ObservableSource");
                                LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i3);
                                this.f39135d.b(leftRightEndObserver);
                                observableSource.subscribe(leftRightEndObserver);
                                if (this.f39138g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    f();
                                    h(observer);
                                    return;
                                }
                                try {
                                    observer.onNext(ObjectHelper.e(this.f39141j.apply(poll, c2), "The resultSelector returned a null value"));
                                    for (TRight onNext : this.f39137f.values()) {
                                        c2.onNext(onNext);
                                    }
                                } catch (Throwable th) {
                                    i(th, observer, spscLinkedArrayQueue);
                                    return;
                                }
                            } catch (Throwable th2) {
                                i(th2, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f39130p) {
                            int i4 = this.f39144m;
                            this.f39144m = i4 + 1;
                            this.f39137f.put(Integer.valueOf(i4), poll);
                            try {
                                ObservableSource observableSource2 = (ObservableSource) ObjectHelper.e(this.f39140i.apply(poll), "The rightEnd returned a null ObservableSource");
                                LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i4);
                                this.f39135d.b(leftRightEndObserver2);
                                observableSource2.subscribe(leftRightEndObserver2);
                                if (this.f39138g.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    f();
                                    h(observer);
                                    return;
                                }
                                for (UnicastSubject<TRight> onNext2 : this.f39136e.values()) {
                                    onNext2.onNext(poll);
                                }
                            } catch (Throwable th3) {
                                i(th3, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == f39131q) {
                            LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) poll;
                            UnicastSubject remove = this.f39136e.remove(Integer.valueOf(leftRightEndObserver3.f39148d));
                            this.f39135d.a(leftRightEndObserver3);
                            if (remove != null) {
                                remove.onComplete();
                            }
                        } else if (num == f39132r) {
                            LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) poll;
                            this.f39137f.remove(Integer.valueOf(leftRightEndObserver4.f39148d));
                            this.f39135d.a(leftRightEndObserver4);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void h(Observer<?> observer) {
            Throwable b2 = ExceptionHelper.b(this.f39138g);
            for (UnicastSubject<TRight> onError : this.f39136e.values()) {
                onError.onError(b2);
            }
            this.f39136e.clear();
            this.f39137f.clear();
            observer.onError(b2);
        }

        /* access modifiers changed from: package-private */
        public void i(Throwable th, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.b(th);
            ExceptionHelper.a(this.f39138g, th);
            spscLinkedArrayQueue.clear();
            f();
            h(observer);
        }

        public boolean isDisposed() {
            return this.f39145n;
        }
    }

    interface JoinSupport {
        void a(boolean z2, Object obj);

        void b(Throwable th);

        void c(boolean z2, LeftRightEndObserver leftRightEndObserver);

        void d(Throwable th);

        void e(LeftRightObserver leftRightObserver);
    }

    static final class LeftRightEndObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final JoinSupport f39146b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f39147c;

        /* renamed from: d  reason: collision with root package name */
        final int f39148d;

        LeftRightEndObserver(JoinSupport joinSupport, boolean z2, int i2) {
            this.f39146b = joinSupport;
            this.f39147c = z2;
            this.f39148d = i2;
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public void onComplete() {
            this.f39146b.c(this.f39147c, this);
        }

        public void onError(Throwable th) {
            this.f39146b.d(th);
        }

        public void onNext(Object obj) {
            if (DisposableHelper.a(this)) {
                this.f39146b.c(this.f39147c, this);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }
    }

    static final class LeftRightObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final JoinSupport f39149b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f39150c;

        LeftRightObserver(JoinSupport joinSupport, boolean z2) {
            this.f39149b = joinSupport;
            this.f39150c = z2;
        }

        public void dispose() {
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.b((Disposable) get());
        }

        public void onComplete() {
            this.f39149b.e(this);
        }

        public void onError(Throwable th) {
            this.f39149b.b(th);
        }

        public void onNext(Object obj) {
            this.f39149b.a(this.f39150c, obj);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }
    }

    public ObservableGroupJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super Observable<TRight>, ? extends R> biFunction) {
        super(observableSource);
        this.f39125c = observableSource2;
        this.f39126d = function;
        this.f39127e = function2;
        this.f39128f = biFunction;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(observer, this.f39126d, this.f39127e, this.f39128f);
        observer.onSubscribe(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.f39135d.b(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.f39135d.b(leftRightObserver2);
        this.f38612b.subscribe(leftRightObserver);
        this.f39125c.subscribe(leftRightObserver2);
    }
}
