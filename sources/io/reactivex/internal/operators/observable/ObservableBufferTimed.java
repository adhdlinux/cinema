package io.reactivex.internal.operators.observable;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final long f38721c;

    /* renamed from: d  reason: collision with root package name */
    final long f38722d;

    /* renamed from: e  reason: collision with root package name */
    final TimeUnit f38723e;

    /* renamed from: f  reason: collision with root package name */
    final Scheduler f38724f;

    /* renamed from: g  reason: collision with root package name */
    final Callable<U> f38725g;

    /* renamed from: h  reason: collision with root package name */
    final int f38726h;

    /* renamed from: i  reason: collision with root package name */
    final boolean f38727i;

    static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* renamed from: h  reason: collision with root package name */
        final Callable<U> f38728h;

        /* renamed from: i  reason: collision with root package name */
        final long f38729i;

        /* renamed from: j  reason: collision with root package name */
        final TimeUnit f38730j;

        /* renamed from: k  reason: collision with root package name */
        final int f38731k;

        /* renamed from: l  reason: collision with root package name */
        final boolean f38732l;

        /* renamed from: m  reason: collision with root package name */
        final Scheduler.Worker f38733m;

        /* renamed from: n  reason: collision with root package name */
        U f38734n;

        /* renamed from: o  reason: collision with root package name */
        Disposable f38735o;

        /* renamed from: p  reason: collision with root package name */
        Disposable f38736p;

        /* renamed from: q  reason: collision with root package name */
        long f38737q;

        /* renamed from: r  reason: collision with root package name */
        long f38738r;

        BufferExactBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j2, TimeUnit timeUnit, int i2, boolean z2, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.f38728h = callable;
            this.f38729i = j2;
            this.f38730j = timeUnit;
            this.f38731k = i2;
            this.f38732l = z2;
            this.f38733m = worker;
        }

        public void dispose() {
            if (!this.f38417e) {
                this.f38417e = true;
                this.f38736p.dispose();
                this.f38733m.dispose();
                synchronized (this) {
                    this.f38734n = null;
                }
            }
        }

        public boolean isDisposed() {
            return this.f38417e;
        }

        /* renamed from: j */
        public void a(Observer<? super U> observer, U u2) {
            observer.onNext(u2);
        }

        public void onComplete() {
            U u2;
            this.f38733m.dispose();
            synchronized (this) {
                u2 = this.f38734n;
                this.f38734n = null;
            }
            this.f38416d.offer(u2);
            this.f38418f = true;
            if (f()) {
                QueueDrainHelper.c(this.f38416d, this.f38415c, false, this, this);
            }
        }

        public void onError(Throwable th) {
            synchronized (this) {
                this.f38734n = null;
            }
            this.f38415c.onError(th);
            this.f38733m.dispose();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (r7.f38732l == false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            r7.f38735o.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            i(r0, false, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r8 = (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.e(r7.f38728h.call(), "The buffer supplied is null");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r7.f38734n = r8;
            r7.f38738r++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
            if (r7.f38732l == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
            r0 = r7.f38733m;
            r4 = r7.f38729i;
            r7.f38735o = r0.d(r7, r4, r4, r7.f38730j);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
            io.reactivex.exceptions.Exceptions.b(r8);
            r7.f38415c.onError(r8);
            dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                U r0 = r7.f38734n     // Catch:{ all -> 0x0066 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                return
            L_0x0007:
                r0.add(r8)     // Catch:{ all -> 0x0066 }
                int r8 = r0.size()     // Catch:{ all -> 0x0066 }
                int r1 = r7.f38731k     // Catch:{ all -> 0x0066 }
                if (r8 >= r1) goto L_0x0014
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                return
            L_0x0014:
                r8 = 0
                r7.f38734n = r8     // Catch:{ all -> 0x0066 }
                long r1 = r7.f38737q     // Catch:{ all -> 0x0066 }
                r3 = 1
                long r1 = r1 + r3
                r7.f38737q = r1     // Catch:{ all -> 0x0066 }
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                boolean r8 = r7.f38732l
                if (r8 == 0) goto L_0x0028
                io.reactivex.disposables.Disposable r8 = r7.f38735o
                r8.dispose()
            L_0x0028:
                r8 = 0
                r7.i(r0, r8, r7)
                java.util.concurrent.Callable<U> r8 = r7.f38728h     // Catch:{ all -> 0x0059 }
                java.lang.Object r8 = r8.call()     // Catch:{ all -> 0x0059 }
                java.lang.String r0 = "The buffer supplied is null"
                java.lang.Object r8 = io.reactivex.internal.functions.ObjectHelper.e(r8, r0)     // Catch:{ all -> 0x0059 }
                java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x0059 }
                monitor-enter(r7)
                r7.f38734n = r8     // Catch:{ all -> 0x0056 }
                long r0 = r7.f38738r     // Catch:{ all -> 0x0056 }
                long r0 = r0 + r3
                r7.f38738r = r0     // Catch:{ all -> 0x0056 }
                monitor-exit(r7)     // Catch:{ all -> 0x0056 }
                boolean r8 = r7.f38732l
                if (r8 == 0) goto L_0x0055
                io.reactivex.Scheduler$Worker r0 = r7.f38733m
                long r4 = r7.f38729i
                java.util.concurrent.TimeUnit r6 = r7.f38730j
                r1 = r7
                r2 = r4
                io.reactivex.disposables.Disposable r8 = r0.d(r1, r2, r4, r6)
                r7.f38735o = r8
            L_0x0055:
                return
            L_0x0056:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0056 }
                throw r8
            L_0x0059:
                r8 = move-exception
                io.reactivex.exceptions.Exceptions.b(r8)
                io.reactivex.Observer<? super V> r0 = r7.f38415c
                r0.onError(r8)
                r7.dispose()
                return
            L_0x0066:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferExactBoundedObserver.onNext(java.lang.Object):void");
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38736p, disposable)) {
                this.f38736p = disposable;
                try {
                    this.f38734n = (Collection) ObjectHelper.e(this.f38728h.call(), "The buffer supplied is null");
                    this.f38415c.onSubscribe(this);
                    Scheduler.Worker worker = this.f38733m;
                    long j2 = this.f38729i;
                    this.f38735o = worker.d(this, j2, j2, this.f38730j);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    disposable.dispose();
                    EmptyDisposable.e(th, this.f38415c);
                    this.f38733m.dispose();
                }
            }
        }

        public void run() {
            try {
                U u2 = (Collection) ObjectHelper.e(this.f38728h.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u3 = this.f38734n;
                    if (u3 != null) {
                        if (this.f38737q == this.f38738r) {
                            this.f38734n = u2;
                            i(u3, false, this);
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                dispose();
                this.f38415c.onError(th);
            }
        }
    }

    static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* renamed from: h  reason: collision with root package name */
        final Callable<U> f38739h;

        /* renamed from: i  reason: collision with root package name */
        final long f38740i;

        /* renamed from: j  reason: collision with root package name */
        final TimeUnit f38741j;

        /* renamed from: k  reason: collision with root package name */
        final Scheduler f38742k;

        /* renamed from: l  reason: collision with root package name */
        Disposable f38743l;

        /* renamed from: m  reason: collision with root package name */
        U f38744m;

        /* renamed from: n  reason: collision with root package name */
        final AtomicReference<Disposable> f38745n = new AtomicReference<>();

        BufferExactUnboundedObserver(Observer<? super U> observer, Callable<U> callable, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.f38739h = callable;
            this.f38740i = j2;
            this.f38741j = timeUnit;
            this.f38742k = scheduler;
        }

        public void dispose() {
            DisposableHelper.a(this.f38745n);
            this.f38743l.dispose();
        }

        public boolean isDisposed() {
            return this.f38745n.get() == DisposableHelper.DISPOSED;
        }

        /* renamed from: j */
        public void a(Observer<? super U> observer, U u2) {
            this.f38415c.onNext(u2);
        }

        public void onComplete() {
            U u2;
            synchronized (this) {
                u2 = this.f38744m;
                this.f38744m = null;
            }
            if (u2 != null) {
                this.f38416d.offer(u2);
                this.f38418f = true;
                if (f()) {
                    QueueDrainHelper.c(this.f38416d, this.f38415c, false, (Disposable) null, this);
                }
            }
            DisposableHelper.a(this.f38745n);
        }

        public void onError(Throwable th) {
            synchronized (this) {
                this.f38744m = null;
            }
            this.f38415c.onError(th);
            DisposableHelper.a(this.f38745n);
        }

        public void onNext(T t2) {
            synchronized (this) {
                U u2 = this.f38744m;
                if (u2 != null) {
                    u2.add(t2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38743l, disposable)) {
                this.f38743l = disposable;
                try {
                    this.f38744m = (Collection) ObjectHelper.e(this.f38739h.call(), "The buffer supplied is null");
                    this.f38415c.onSubscribe(this);
                    if (!this.f38417e) {
                        Scheduler scheduler = this.f38742k;
                        long j2 = this.f38740i;
                        Disposable e2 = scheduler.e(this, j2, j2, this.f38741j);
                        if (!f.a(this.f38745n, (Object) null, e2)) {
                            e2.dispose();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    dispose();
                    EmptyDisposable.e(th, this.f38415c);
                }
            }
        }

        public void run() {
            U u2;
            try {
                U u3 = (Collection) ObjectHelper.e(this.f38739h.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u2 = this.f38744m;
                    if (u2 != null) {
                        this.f38744m = u3;
                    }
                }
                if (u2 == null) {
                    DisposableHelper.a(this.f38745n);
                } else {
                    h(u2, false, this);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f38415c.onError(th);
                dispose();
            }
        }
    }

    static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* renamed from: h  reason: collision with root package name */
        final Callable<U> f38746h;

        /* renamed from: i  reason: collision with root package name */
        final long f38747i;

        /* renamed from: j  reason: collision with root package name */
        final long f38748j;

        /* renamed from: k  reason: collision with root package name */
        final TimeUnit f38749k;

        /* renamed from: l  reason: collision with root package name */
        final Scheduler.Worker f38750l;

        /* renamed from: m  reason: collision with root package name */
        final List<U> f38751m = new LinkedList();

        /* renamed from: n  reason: collision with root package name */
        Disposable f38752n;

        final class RemoveFromBuffer implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final U f38753b;

            RemoveFromBuffer(U u2) {
                this.f38753b = u2;
            }

            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.f38751m.remove(this.f38753b);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.i(this.f38753b, false, bufferSkipBoundedObserver.f38750l);
            }
        }

        final class RemoveFromBufferEmit implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final U f38755b;

            RemoveFromBufferEmit(U u2) {
                this.f38755b = u2;
            }

            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.f38751m.remove(this.f38755b);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.i(this.f38755b, false, bufferSkipBoundedObserver.f38750l);
            }
        }

        BufferSkipBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j2, long j3, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.f38746h = callable;
            this.f38747i = j2;
            this.f38748j = j3;
            this.f38749k = timeUnit;
            this.f38750l = worker;
        }

        public void dispose() {
            if (!this.f38417e) {
                this.f38417e = true;
                m();
                this.f38752n.dispose();
                this.f38750l.dispose();
            }
        }

        public boolean isDisposed() {
            return this.f38417e;
        }

        /* renamed from: j */
        public void a(Observer<? super U> observer, U u2) {
            observer.onNext(u2);
        }

        /* access modifiers changed from: package-private */
        public void m() {
            synchronized (this) {
                this.f38751m.clear();
            }
        }

        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(this.f38751m);
                this.f38751m.clear();
            }
            for (Collection offer : arrayList) {
                this.f38416d.offer(offer);
            }
            this.f38418f = true;
            if (f()) {
                QueueDrainHelper.c(this.f38416d, this.f38415c, false, this.f38750l, this);
            }
        }

        public void onError(Throwable th) {
            this.f38418f = true;
            m();
            this.f38415c.onError(th);
            this.f38750l.dispose();
        }

        public void onNext(T t2) {
            synchronized (this) {
                for (U add : this.f38751m) {
                    add.add(t2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38752n, disposable)) {
                this.f38752n = disposable;
                try {
                    Collection collection = (Collection) ObjectHelper.e(this.f38746h.call(), "The buffer supplied is null");
                    this.f38751m.add(collection);
                    this.f38415c.onSubscribe(this);
                    Scheduler.Worker worker = this.f38750l;
                    long j2 = this.f38748j;
                    worker.d(this, j2, j2, this.f38749k);
                    this.f38750l.c(new RemoveFromBufferEmit(collection), this.f38747i, this.f38749k);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    disposable.dispose();
                    EmptyDisposable.e(th, this.f38415c);
                    this.f38750l.dispose();
                }
            }
        }

        public void run() {
            if (!this.f38417e) {
                try {
                    Collection collection = (Collection) ObjectHelper.e(this.f38746h.call(), "The bufferSupplier returned a null buffer");
                    synchronized (this) {
                        if (!this.f38417e) {
                            this.f38751m.add(collection);
                            this.f38750l.c(new RemoveFromBuffer(collection), this.f38747i, this.f38749k);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f38415c.onError(th);
                    dispose();
                }
            }
        }
    }

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i2, boolean z2) {
        super(observableSource);
        this.f38721c = j2;
        this.f38722d = j3;
        this.f38723e = timeUnit;
        this.f38724f = scheduler;
        this.f38725g = callable;
        this.f38726h = i2;
        this.f38727i = z2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super U> observer) {
        if (this.f38721c == this.f38722d && this.f38726h == Integer.MAX_VALUE) {
            this.f38612b.subscribe(new BufferExactUnboundedObserver(new SerializedObserver(observer), this.f38725g, this.f38721c, this.f38723e, this.f38724f));
            return;
        }
        Scheduler.Worker a2 = this.f38724f.a();
        if (this.f38721c == this.f38722d) {
            this.f38612b.subscribe(new BufferExactBoundedObserver(new SerializedObserver(observer), this.f38725g, this.f38721c, this.f38723e, this.f38726h, this.f38727i, a2));
        } else {
            this.f38612b.subscribe(new BufferSkipBoundedObserver(new SerializedObserver(observer), this.f38725g, this.f38721c, this.f38722d, this.f38723e, a2));
        }
    }
}
