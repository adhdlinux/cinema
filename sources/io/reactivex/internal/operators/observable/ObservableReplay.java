package io.reactivex.internal.operators.observable;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay<T> extends ConnectableObservable<T> implements ResettableConnectable {

    /* renamed from: f  reason: collision with root package name */
    static final BufferSupplier f39378f = new UnBoundedFactory();

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<T> f39379b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<ReplayObserver<T>> f39380c;

    /* renamed from: d  reason: collision with root package name */
    final BufferSupplier<T> f39381d;

    /* renamed from: e  reason: collision with root package name */
    final ObservableSource<T> f39382e;

    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {

        /* renamed from: b  reason: collision with root package name */
        Node f39383b;

        /* renamed from: c  reason: collision with root package name */
        int f39384c;

        BoundedReplayBuffer() {
            Node node = new Node((Object) null);
            this.f39383b = node;
            set(node);
        }

        public final void a() {
            e(new Node(f(NotificationLite.c())));
            m();
        }

        public final void b(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    Node node = (Node) innerDisposable.a();
                    if (node == null) {
                        node = g();
                        innerDisposable.f39388d = node;
                    }
                    while (!innerDisposable.isDisposed()) {
                        Node node2 = (Node) node.get();
                        if (node2 == null) {
                            innerDisposable.f39388d = node;
                            i2 = innerDisposable.addAndGet(-i2);
                        } else if (NotificationLite.a(h(node2.f39392b), innerDisposable.f39387c)) {
                            innerDisposable.f39388d = null;
                            return;
                        } else {
                            node = node2;
                        }
                    }
                    innerDisposable.f39388d = null;
                    return;
                } while (i2 != 0);
            }
        }

        public final void c(Throwable th) {
            e(new Node(f(NotificationLite.e(th))));
            m();
        }

        public final void d(T t2) {
            e(new Node(f(NotificationLite.j(t2))));
            l();
        }

        /* access modifiers changed from: package-private */
        public final void e(Node node) {
            this.f39383b.set(node);
            this.f39383b = node;
            this.f39384c++;
        }

        /* access modifiers changed from: package-private */
        public Object f(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public Node g() {
            return (Node) get();
        }

        /* access modifiers changed from: package-private */
        public Object h(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public final void i() {
            this.f39384c--;
            j((Node) ((Node) get()).get());
        }

        /* access modifiers changed from: package-private */
        public final void j(Node node) {
            set(node);
        }

        /* access modifiers changed from: package-private */
        public final void k() {
            Node node = (Node) get();
            if (node.f39392b != null) {
                Node node2 = new Node((Object) null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void l();

        /* access modifiers changed from: package-private */
        public void m() {
            k();
        }
    }

    interface BufferSupplier<T> {
        ReplayBuffer<T> call();
    }

    static final class DisposeConsumer<R> implements Consumer<Disposable> {

        /* renamed from: b  reason: collision with root package name */
        private final ObserverResourceWrapper<R> f39385b;

        DisposeConsumer(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.f39385b = observerResourceWrapper;
        }

        /* renamed from: a */
        public void accept(Disposable disposable) {
            this.f39385b.a(disposable);
        }
    }

    static final class InnerDisposable<T> extends AtomicInteger implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        final ReplayObserver<T> f39386b;

        /* renamed from: c  reason: collision with root package name */
        final Observer<? super T> f39387c;

        /* renamed from: d  reason: collision with root package name */
        Object f39388d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f39389e;

        InnerDisposable(ReplayObserver<T> replayObserver, Observer<? super T> observer) {
            this.f39386b = replayObserver;
            this.f39387c = observer;
        }

        /* access modifiers changed from: package-private */
        public <U> U a() {
            return this.f39388d;
        }

        public void dispose() {
            if (!this.f39389e) {
                this.f39389e = true;
                this.f39386b.b(this);
                this.f39388d = null;
            }
        }

        public boolean isDisposed() {
            return this.f39389e;
        }
    }

    static final class MulticastReplay<R, U> extends Observable<R> {

        /* renamed from: b  reason: collision with root package name */
        private final Callable<? extends ConnectableObservable<U>> f39390b;

        /* renamed from: c  reason: collision with root package name */
        private final Function<? super Observable<U>, ? extends ObservableSource<R>> f39391c;

        MulticastReplay(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
            this.f39390b = callable;
            this.f39391c = function;
        }

        /* access modifiers changed from: protected */
        public void subscribeActual(Observer<? super R> observer) {
            try {
                ConnectableObservable connectableObservable = (ConnectableObservable) ObjectHelper.e(this.f39390b.call(), "The connectableFactory returned a null ConnectableObservable");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f39391c.apply(connectableObservable), "The selector returned a null ObservableSource");
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(observer);
                observableSource.subscribe(observerResourceWrapper);
                connectableObservable.b(new DisposeConsumer(observerResourceWrapper));
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.e(th, observer);
            }
        }
    }

    static final class Node extends AtomicReference<Node> {

        /* renamed from: b  reason: collision with root package name */
        final Object f39392b;

        Node(Object obj) {
            this.f39392b = obj;
        }
    }

    static final class Replay<T> extends ConnectableObservable<T> {

        /* renamed from: b  reason: collision with root package name */
        private final ConnectableObservable<T> f39393b;

        /* renamed from: c  reason: collision with root package name */
        private final Observable<T> f39394c;

        Replay(ConnectableObservable<T> connectableObservable, Observable<T> observable) {
            this.f39393b = connectableObservable;
            this.f39394c = observable;
        }

        public void b(Consumer<? super Disposable> consumer) {
            this.f39393b.b(consumer);
        }

        /* access modifiers changed from: protected */
        public void subscribeActual(Observer<? super T> observer) {
            this.f39394c.subscribe(observer);
        }
    }

    interface ReplayBuffer<T> {
        void a();

        void b(InnerDisposable<T> innerDisposable);

        void c(Throwable th);

        void d(T t2);
    }

    static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f39395a;

        ReplayBufferSupplier(int i2) {
            this.f39395a = i2;
        }

        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.f39395a);
        }
    }

    static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

        /* renamed from: f  reason: collision with root package name */
        static final InnerDisposable[] f39396f = new InnerDisposable[0];

        /* renamed from: g  reason: collision with root package name */
        static final InnerDisposable[] f39397g = new InnerDisposable[0];

        /* renamed from: b  reason: collision with root package name */
        final ReplayBuffer<T> f39398b;

        /* renamed from: c  reason: collision with root package name */
        boolean f39399c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<InnerDisposable[]> f39400d = new AtomicReference<>(f39396f);

        /* renamed from: e  reason: collision with root package name */
        final AtomicBoolean f39401e = new AtomicBoolean();

        ReplayObserver(ReplayBuffer<T> replayBuffer) {
            this.f39398b = replayBuffer;
        }

        /* access modifiers changed from: package-private */
        public boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f39400d.get();
                if (innerDisposableArr == f39397g) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!f.a(this.f39400d, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f39400d.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (innerDisposableArr[i2].equals(innerDisposable)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            innerDisposableArr2 = f39396f;
                        } else {
                            InnerDisposable[] innerDisposableArr3 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i2);
                            System.arraycopy(innerDisposableArr, i2 + 1, innerDisposableArr3, i2, (length - i2) - 1);
                            innerDisposableArr2 = innerDisposableArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!f.a(this.f39400d, innerDisposableArr, innerDisposableArr2));
        }

        /* access modifiers changed from: package-private */
        public void c() {
            for (InnerDisposable b2 : this.f39400d.get()) {
                this.f39398b.b(b2);
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            for (InnerDisposable b2 : this.f39400d.getAndSet(f39397g)) {
                this.f39398b.b(b2);
            }
        }

        public void dispose() {
            this.f39400d.set(f39397g);
            DisposableHelper.a(this);
        }

        public boolean isDisposed() {
            return this.f39400d.get() == f39397g;
        }

        public void onComplete() {
            if (!this.f39399c) {
                this.f39399c = true;
                this.f39398b.a();
                d();
            }
        }

        public void onError(Throwable th) {
            if (!this.f39399c) {
                this.f39399c = true;
                this.f39398b.c(th);
                d();
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            if (!this.f39399c) {
                this.f39398b.d(t2);
                c();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.f(this, disposable)) {
                c();
            }
        }
    }

    static final class ReplaySource<T> implements ObservableSource<T> {

        /* renamed from: b  reason: collision with root package name */
        private final AtomicReference<ReplayObserver<T>> f39402b;

        /* renamed from: c  reason: collision with root package name */
        private final BufferSupplier<T> f39403c;

        ReplaySource(AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
            this.f39402b = atomicReference;
            this.f39403c = bufferSupplier;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void subscribe(io.reactivex.Observer<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r3.f39402b
                java.lang.Object r0 = r0.get()
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver) r0
                if (r0 != 0) goto L_0x0020
                io.reactivex.internal.operators.observable.ObservableReplay$BufferSupplier<T> r0 = r3.f39403c
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer r0 = r0.call()
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r1 = new io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver
                r1.<init>(r0)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r3.f39402b
                r2 = 0
                boolean r0 = androidx.media3.exoplayer.mediacodec.f.a(r0, r2, r1)
                if (r0 != 0) goto L_0x001f
                goto L_0x0000
            L_0x001f:
                r0 = r1
            L_0x0020:
                io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable r1 = new io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable
                r1.<init>(r0, r4)
                r4.onSubscribe(r1)
                r0.a(r1)
                boolean r4 = r1.isDisposed()
                if (r4 == 0) goto L_0x0035
                r0.b(r1)
                return
            L_0x0035:
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer<T> r4 = r0.f39398b
                r4.b(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.ReplaySource.subscribe(io.reactivex.Observer):void");
        }
    }

    static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f39404a;

        /* renamed from: b  reason: collision with root package name */
        private final long f39405b;

        /* renamed from: c  reason: collision with root package name */
        private final TimeUnit f39406c;

        /* renamed from: d  reason: collision with root package name */
        private final Scheduler f39407d;

        ScheduledReplaySupplier(int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            this.f39404a = i2;
            this.f39405b = j2;
            this.f39406c = timeUnit;
            this.f39407d = scheduler;
        }

        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.f39404a, this.f39405b, this.f39406c, this.f39407d);
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {

        /* renamed from: d  reason: collision with root package name */
        final Scheduler f39408d;

        /* renamed from: e  reason: collision with root package name */
        final long f39409e;

        /* renamed from: f  reason: collision with root package name */
        final TimeUnit f39410f;

        /* renamed from: g  reason: collision with root package name */
        final int f39411g;

        SizeAndTimeBoundReplayBuffer(int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            this.f39408d = scheduler;
            this.f39411g = i2;
            this.f39409e = j2;
            this.f39410f = timeUnit;
        }

        /* access modifiers changed from: package-private */
        public Object f(Object obj) {
            return new Timed(obj, this.f39408d.b(this.f39410f), this.f39410f);
        }

        /* access modifiers changed from: package-private */
        public Node g() {
            Node node;
            long b2 = this.f39408d.b(this.f39410f) - this.f39409e;
            Node node2 = (Node) get();
            Object obj = node2.get();
            while (true) {
                Node node3 = (Node) obj;
                node = node2;
                node2 = node3;
                if (node2 != null) {
                    Timed timed = (Timed) node2.f39392b;
                    if (NotificationLite.h(timed.b()) || NotificationLite.i(timed.b()) || timed.a() > b2) {
                        break;
                    }
                    obj = node2.get();
                } else {
                    break;
                }
            }
            return node;
        }

        /* access modifiers changed from: package-private */
        public Object h(Object obj) {
            return ((Timed) obj).b();
        }

        /* access modifiers changed from: package-private */
        public void l() {
            Node node;
            long b2 = this.f39408d.b(this.f39410f) - this.f39409e;
            Node node2 = (Node) get();
            Node node3 = (Node) node2.get();
            int i2 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i3 = this.f39384c;
                    if (i3 <= this.f39411g) {
                        if (((Timed) node2.f39392b).a() > b2) {
                            break;
                        }
                        i2++;
                        this.f39384c--;
                        node3 = (Node) node2.get();
                    } else {
                        i2++;
                        this.f39384c = i3 - 1;
                        node3 = (Node) node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i2 != 0) {
                j(node);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void m() {
            /*
                r10 = this;
                io.reactivex.Scheduler r0 = r10.f39408d
                java.util.concurrent.TimeUnit r1 = r10.f39410f
                long r0 = r0.b(r1)
                long r2 = r10.f39409e
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r2 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r3
                r4 = 0
            L_0x0018:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L_0x003c
                int r5 = r10.f39384c
                r6 = 1
                if (r5 <= r6) goto L_0x003c
                java.lang.Object r5 = r2.f39392b
                io.reactivex.schedulers.Timed r5 = (io.reactivex.schedulers.Timed) r5
                long r7 = r5.a()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L_0x003c
                int r4 = r4 + 1
                int r3 = r10.f39384c
                int r3 = r3 - r6
                r10.f39384c = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r3
                goto L_0x0018
            L_0x003c:
                if (r4 == 0) goto L_0x0041
                r10.j(r3)
            L_0x0041:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.SizeAndTimeBoundReplayBuffer.m():void");
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {

        /* renamed from: d  reason: collision with root package name */
        final int f39412d;

        SizeBoundReplayBuffer(int i2) {
            this.f39412d = i2;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            if (this.f39384c > this.f39412d) {
                i();
            }
        }
    }

    static final class UnBoundedFactory implements BufferSupplier<Object> {
        UnBoundedFactory() {
        }

        public ReplayBuffer<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {

        /* renamed from: b  reason: collision with root package name */
        volatile int f39413b;

        UnboundedReplayBuffer(int i2) {
            super(i2);
        }

        public void a() {
            add(NotificationLite.c());
            this.f39413b++;
        }

        public void b(InnerDisposable<T> innerDisposable) {
            int i2;
            if (innerDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = innerDisposable.f39387c;
                int i3 = 1;
                while (!innerDisposable.isDisposed()) {
                    int i4 = this.f39413b;
                    Integer num = (Integer) innerDisposable.a();
                    if (num != null) {
                        i2 = num.intValue();
                    } else {
                        i2 = 0;
                    }
                    while (i2 < i4) {
                        if (!NotificationLite.a(get(i2), observer) && !innerDisposable.isDisposed()) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    innerDisposable.f39388d = Integer.valueOf(i2);
                    i3 = innerDisposable.addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
        }

        public void c(Throwable th) {
            add(NotificationLite.e(th));
            this.f39413b++;
        }

        public void d(T t2) {
            add(NotificationLite.j(t2));
            this.f39413b++;
        }
    }

    private ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
        this.f39382e = observableSource;
        this.f39379b = observableSource2;
        this.f39380c = atomicReference;
        this.f39381d = bufferSupplier;
    }

    public static <T> ConnectableObservable<T> d(ObservableSource<T> observableSource, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            return h(observableSource);
        }
        return g(observableSource, new ReplayBufferSupplier(i2));
    }

    public static <T> ConnectableObservable<T> e(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return f(observableSource, j2, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableObservable<T> f(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2) {
        return g(observableSource, new ScheduledReplaySupplier(i2, j2, timeUnit, scheduler));
    }

    static <T> ConnectableObservable<T> g(ObservableSource<T> observableSource, BufferSupplier<T> bufferSupplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.p(new ObservableReplay(new ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
    }

    public static <T> ConnectableObservable<T> h(ObservableSource<? extends T> observableSource) {
        return g(observableSource, f39378f);
    }

    public static <U, R> Observable<R> i(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        return RxJavaPlugins.n(new MulticastReplay(callable, function));
    }

    public static <T> ConnectableObservable<T> j(ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        return RxJavaPlugins.p(new Replay(connectableObservable, connectableObservable.observeOn(scheduler)));
    }

    public void a(Disposable disposable) {
        f.a(this.f39380c, (ReplayObserver) disposable, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r4.f39380c
            java.lang.Object r0 = r0.get()
            io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.isDisposed()
            if (r1 == 0) goto L_0x0025
        L_0x0010:
            io.reactivex.internal.operators.observable.ObservableReplay$BufferSupplier<T> r1 = r4.f39381d
            io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer r1 = r1.call()
            io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r2 = new io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver
            r2.<init>(r1)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r1 = r4.f39380c
            boolean r0 = androidx.media3.exoplayer.mediacodec.f.a(r1, r0, r2)
            if (r0 != 0) goto L_0x0024
            goto L_0x0000
        L_0x0024:
            r0 = r2
        L_0x0025:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f39401e
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0039
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f39401e
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0039
            r1 = 1
            goto L_0x003a
        L_0x0039:
            r1 = 0
        L_0x003a:
            r5.accept(r0)     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0044
            io.reactivex.ObservableSource<T> r5 = r4.f39379b
            r5.subscribe(r0)
        L_0x0044:
            return
        L_0x0045:
            r5 = move-exception
            if (r1 == 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.f39401e
            r0.compareAndSet(r2, r3)
        L_0x004d:
            io.reactivex.exceptions.Exceptions.b(r5)
            java.lang.RuntimeException r5 = io.reactivex.internal.util.ExceptionHelper.d(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.b(io.reactivex.functions.Consumer):void");
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f39382e.subscribe(observer);
    }
}
