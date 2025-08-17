package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final ObservableSource<B> f38713c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<U> f38714d;

    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {

        /* renamed from: c  reason: collision with root package name */
        final BufferExactBoundaryObserver<T, U, B> f38715c;

        BufferBoundaryObserver(BufferExactBoundaryObserver<T, U, B> bufferExactBoundaryObserver) {
            this.f38715c = bufferExactBoundaryObserver;
        }

        public void onComplete() {
            this.f38715c.onComplete();
        }

        public void onError(Throwable th) {
            this.f38715c.onError(th);
        }

        public void onNext(B b2) {
            this.f38715c.k();
        }
    }

    static final class BufferExactBoundaryObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Disposable {

        /* renamed from: h  reason: collision with root package name */
        final Callable<U> f38716h;

        /* renamed from: i  reason: collision with root package name */
        final ObservableSource<B> f38717i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f38718j;

        /* renamed from: k  reason: collision with root package name */
        Disposable f38719k;

        /* renamed from: l  reason: collision with root package name */
        U f38720l;

        BufferExactBoundaryObserver(Observer<? super U> observer, Callable<U> callable, ObservableSource<B> observableSource) {
            super(observer, new MpscLinkedQueue());
            this.f38716h = callable;
            this.f38717i = observableSource;
        }

        public void dispose() {
            if (!this.f38417e) {
                this.f38417e = true;
                this.f38719k.dispose();
                this.f38718j.dispose();
                if (f()) {
                    this.f38416d.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f38417e;
        }

        /* renamed from: j */
        public void a(Observer<? super U> observer, U u2) {
            this.f38415c.onNext(u2);
        }

        /* access modifiers changed from: package-private */
        public void k() {
            try {
                U u2 = (Collection) ObjectHelper.e(this.f38716h.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u3 = this.f38720l;
                    if (u3 != null) {
                        this.f38720l = u2;
                        h(u3, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                dispose();
                this.f38415c.onError(th);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            io.reactivex.internal.util.QueueDrainHelper.c(r3.f38416d, r3.f38415c, false, r3, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r3.f38416d.offer(r0);
            r3.f38418f = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (f() == false) goto L_?;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r3 = this;
                monitor-enter(r3)
                U r0 = r3.f38720l     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                return
            L_0x0007:
                r1 = 0
                r3.f38720l = r1     // Catch:{ all -> 0x0022 }
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r1 = r3.f38416d
                r1.offer(r0)
                r0 = 1
                r3.f38418f = r0
                boolean r0 = r3.f()
                if (r0 == 0) goto L_0x0021
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r3.f38416d
                io.reactivex.Observer<? super V> r1 = r3.f38415c
                r2 = 0
                io.reactivex.internal.util.QueueDrainHelper.c(r0, r1, r2, r3, r3)
            L_0x0021:
                return
            L_0x0022:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferExactBoundary.BufferExactBoundaryObserver.onComplete():void");
        }

        public void onError(Throwable th) {
            dispose();
            this.f38415c.onError(th);
        }

        public void onNext(T t2) {
            synchronized (this) {
                U u2 = this.f38720l;
                if (u2 != null) {
                    u2.add(t2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38718j, disposable)) {
                this.f38718j = disposable;
                try {
                    this.f38720l = (Collection) ObjectHelper.e(this.f38716h.call(), "The buffer supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    this.f38719k = bufferBoundaryObserver;
                    this.f38415c.onSubscribe(this);
                    if (!this.f38417e) {
                        this.f38717i.subscribe(bufferBoundaryObserver);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f38417e = true;
                    disposable.dispose();
                    EmptyDisposable.e(th, this.f38415c);
                }
            }
        }
    }

    public ObservableBufferExactBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Callable<U> callable) {
        super(observableSource);
        this.f38713c = observableSource2;
        this.f38714d = callable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super U> observer) {
        this.f38612b.subscribe(new BufferExactBoundaryObserver(new SerializedObserver(observer), this.f38714d, this.f38713c));
    }
}
