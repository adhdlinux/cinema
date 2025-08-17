package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends K> f39102c;

    /* renamed from: d  reason: collision with root package name */
    final Function<? super T, ? extends V> f39103d;

    /* renamed from: e  reason: collision with root package name */
    final int f39104e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f39105f;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        static final Object f39106j = new Object();

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super GroupedObservable<K, V>> f39107b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends K> f39108c;

        /* renamed from: d  reason: collision with root package name */
        final Function<? super T, ? extends V> f39109d;

        /* renamed from: e  reason: collision with root package name */
        final int f39110e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f39111f;

        /* renamed from: g  reason: collision with root package name */
        final Map<Object, GroupedUnicast<K, V>> f39112g;

        /* renamed from: h  reason: collision with root package name */
        Disposable f39113h;

        /* renamed from: i  reason: collision with root package name */
        final AtomicBoolean f39114i = new AtomicBoolean();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z2) {
            this.f39107b = observer;
            this.f39108c = function;
            this.f39109d = function2;
            this.f39110e = i2;
            this.f39111f = z2;
            this.f39112g = new ConcurrentHashMap();
            lazySet(1);
        }

        public void a(K k2) {
            if (k2 == null) {
                k2 = f39106j;
            }
            this.f39112g.remove(k2);
            if (decrementAndGet() == 0) {
                this.f39113h.dispose();
            }
        }

        public void dispose() {
            if (this.f39114i.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f39113h.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f39114i.get();
        }

        public void onComplete() {
            ArrayList<GroupedUnicast> arrayList = new ArrayList<>(this.f39112g.values());
            this.f39112g.clear();
            for (GroupedUnicast onComplete : arrayList) {
                onComplete.onComplete();
            }
            this.f39107b.onComplete();
        }

        public void onError(Throwable th) {
            ArrayList<GroupedUnicast> arrayList = new ArrayList<>(this.f39112g.values());
            this.f39112g.clear();
            for (GroupedUnicast onError : arrayList) {
                onError.onError(th);
            }
            this.f39107b.onError(th);
        }

        public void onNext(T t2) {
            Object obj;
            try {
                Object apply = this.f39108c.apply(t2);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = f39106j;
                }
                GroupedUnicast groupedUnicast = this.f39112g.get(obj);
                if (groupedUnicast == null) {
                    if (!this.f39114i.get()) {
                        groupedUnicast = GroupedUnicast.b(apply, this.f39110e, this, this.f39111f);
                        this.f39112g.put(obj, groupedUnicast);
                        getAndIncrement();
                        this.f39107b.onNext(groupedUnicast);
                    } else {
                        return;
                    }
                }
                try {
                    groupedUnicast.onNext(ObjectHelper.e(this.f39109d.apply(t2), "The value supplied is null"));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f39113h.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f39113h.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39113h, disposable)) {
                this.f39113h = disposable;
                this.f39107b.onSubscribe(this);
            }
        }
    }

    static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {

        /* renamed from: c  reason: collision with root package name */
        final State<T, K> f39115c;

        protected GroupedUnicast(K k2, State<T, K> state) {
            super(k2);
            this.f39115c = state;
        }

        public static <T, K> GroupedUnicast<K, T> b(K k2, int i2, GroupByObserver<?, K, T> groupByObserver, boolean z2) {
            return new GroupedUnicast<>(k2, new State(i2, groupByObserver, k2, z2));
        }

        public void onComplete() {
            this.f39115c.c();
        }

        public void onError(Throwable th) {
            this.f39115c.d(th);
        }

        public void onNext(T t2) {
            this.f39115c.e(t2);
        }

        /* access modifiers changed from: protected */
        public void subscribeActual(Observer<? super T> observer) {
            this.f39115c.subscribe(observer);
        }
    }

    static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {

        /* renamed from: b  reason: collision with root package name */
        final K f39116b;

        /* renamed from: c  reason: collision with root package name */
        final SpscLinkedArrayQueue<T> f39117c;

        /* renamed from: d  reason: collision with root package name */
        final GroupByObserver<?, K, T> f39118d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f39119e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f39120f;

        /* renamed from: g  reason: collision with root package name */
        Throwable f39121g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicBoolean f39122h = new AtomicBoolean();

        /* renamed from: i  reason: collision with root package name */
        final AtomicBoolean f39123i = new AtomicBoolean();

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<Observer<? super T>> f39124j = new AtomicReference<>();

        State(int i2, GroupByObserver<?, K, T> groupByObserver, K k2, boolean z2) {
            this.f39117c = new SpscLinkedArrayQueue<>(i2);
            this.f39118d = groupByObserver;
            this.f39116b = k2;
            this.f39119e = z2;
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z2, boolean z3, Observer<? super T> observer, boolean z4) {
            if (this.f39122h.get()) {
                this.f39117c.clear();
                this.f39118d.a(this.f39116b);
                this.f39124j.lazySet((Object) null);
                return true;
            } else if (!z2) {
                return false;
            } else {
                if (!z4) {
                    Throwable th = this.f39121g;
                    if (th != null) {
                        this.f39117c.clear();
                        this.f39124j.lazySet((Object) null);
                        observer.onError(th);
                        return true;
                    } else if (!z3) {
                        return false;
                    } else {
                        this.f39124j.lazySet((Object) null);
                        observer.onComplete();
                        return true;
                    }
                } else if (!z3) {
                    return false;
                } else {
                    Throwable th2 = this.f39121g;
                    this.f39124j.lazySet((Object) null);
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
        public void b() {
            boolean z2;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f39117c;
                boolean z3 = this.f39119e;
                Observer observer = this.f39124j.get();
                int i2 = 1;
                while (true) {
                    if (observer != null) {
                        while (true) {
                            boolean z4 = this.f39120f;
                            T poll = spscLinkedArrayQueue.poll();
                            if (poll == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!a(z4, z2, observer, z3)) {
                                if (z2) {
                                    break;
                                }
                                observer.onNext(poll);
                            } else {
                                return;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 != 0) {
                        if (observer == null) {
                            observer = this.f39124j.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public void c() {
            this.f39120f = true;
            b();
        }

        public void d(Throwable th) {
            this.f39121g = th;
            this.f39120f = true;
            b();
        }

        public void dispose() {
            if (this.f39122h.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f39124j.lazySet((Object) null);
                this.f39118d.a(this.f39116b);
            }
        }

        public void e(T t2) {
            this.f39117c.offer(t2);
            b();
        }

        public boolean isDisposed() {
            return this.f39122h.get();
        }

        public void subscribe(Observer<? super T> observer) {
            if (this.f39123i.compareAndSet(false, true)) {
                observer.onSubscribe(this);
                this.f39124j.lazySet(observer);
                if (this.f39122h.get()) {
                    this.f39124j.lazySet((Object) null);
                } else {
                    b();
                }
            } else {
                EmptyDisposable.e(new IllegalStateException("Only one Observer allowed!"), observer);
            }
        }
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z2) {
        super(observableSource);
        this.f39102c = function;
        this.f39103d = function2;
        this.f39104e = i2;
        this.f39105f = z2;
    }

    public void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.f38612b.subscribe(new GroupByObserver(observer, this.f39102c, this.f39103d, this.f39104e, this.f39105f));
    }
}
