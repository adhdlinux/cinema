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
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final Callable<? extends ObservableSource<B>> f38704c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<U> f38705d;

    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {

        /* renamed from: c  reason: collision with root package name */
        final BufferBoundarySupplierObserver<T, U, B> f38706c;

        /* renamed from: d  reason: collision with root package name */
        boolean f38707d;

        BufferBoundaryObserver(BufferBoundarySupplierObserver<T, U, B> bufferBoundarySupplierObserver) {
            this.f38706c = bufferBoundarySupplierObserver;
        }

        public void onComplete() {
            if (!this.f38707d) {
                this.f38707d = true;
                this.f38706c.l();
            }
        }

        public void onError(Throwable th) {
            if (this.f38707d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38707d = true;
            this.f38706c.onError(th);
        }

        public void onNext(B b2) {
            if (!this.f38707d) {
                this.f38707d = true;
                dispose();
                this.f38706c.l();
            }
        }
    }

    static final class BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Disposable {

        /* renamed from: h  reason: collision with root package name */
        final Callable<U> f38708h;

        /* renamed from: i  reason: collision with root package name */
        final Callable<? extends ObservableSource<B>> f38709i;

        /* renamed from: j  reason: collision with root package name */
        Disposable f38710j;

        /* renamed from: k  reason: collision with root package name */
        final AtomicReference<Disposable> f38711k = new AtomicReference<>();

        /* renamed from: l  reason: collision with root package name */
        U f38712l;

        BufferBoundarySupplierObserver(Observer<? super U> observer, Callable<U> callable, Callable<? extends ObservableSource<B>> callable2) {
            super(observer, new MpscLinkedQueue());
            this.f38708h = callable;
            this.f38709i = callable2;
        }

        public void dispose() {
            if (!this.f38417e) {
                this.f38417e = true;
                this.f38710j.dispose();
                k();
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
            DisposableHelper.a(this.f38711k);
        }

        /* access modifiers changed from: package-private */
        public void l() {
            try {
                U u2 = (Collection) ObjectHelper.e(this.f38708h.call(), "The buffer supplied is null");
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f38709i.call(), "The boundary ObservableSource supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    if (DisposableHelper.c(this.f38711k, bufferBoundaryObserver)) {
                        synchronized (this) {
                            U u3 = this.f38712l;
                            if (u3 != null) {
                                this.f38712l = u2;
                                observableSource.subscribe(bufferBoundaryObserver);
                                h(u3, false, this);
                            }
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f38417e = true;
                    this.f38710j.dispose();
                    this.f38415c.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                dispose();
                this.f38415c.onError(th2);
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
                U r0 = r3.f38712l     // Catch:{ all -> 0x0022 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0022 }
                return
            L_0x0007:
                r1 = 0
                r3.f38712l = r1     // Catch:{ all -> 0x0022 }
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver.onComplete():void");
        }

        public void onError(Throwable th) {
            dispose();
            this.f38415c.onError(th);
        }

        public void onNext(T t2) {
            synchronized (this) {
                U u2 = this.f38712l;
                if (u2 != null) {
                    u2.add(t2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f38710j, disposable)) {
                this.f38710j = disposable;
                Observer<? super V> observer = this.f38415c;
                try {
                    this.f38712l = (Collection) ObjectHelper.e(this.f38708h.call(), "The buffer supplied is null");
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f38709i.call(), "The boundary ObservableSource supplied is null");
                        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                        this.f38711k.set(bufferBoundaryObserver);
                        observer.onSubscribe(this);
                        if (!this.f38417e) {
                            observableSource.subscribe(bufferBoundaryObserver);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f38417e = true;
                        disposable.dispose();
                        EmptyDisposable.e(th, observer);
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f38417e = true;
                    disposable.dispose();
                    EmptyDisposable.e(th2, observer);
                }
            }
        }
    }

    public ObservableBufferBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        super(observableSource);
        this.f38704c = callable;
        this.f38705d = callable2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super U> observer) {
        this.f38612b.subscribe(new BufferBoundarySupplierObserver(new SerializedObserver(observer), this.f38705d, this.f38704c));
    }
}
