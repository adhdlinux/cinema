package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    final ConnectableObservable<T> f39345b;

    /* renamed from: c  reason: collision with root package name */
    final int f39346c;

    /* renamed from: d  reason: collision with root package name */
    final long f39347d;

    /* renamed from: e  reason: collision with root package name */
    final TimeUnit f39348e;

    /* renamed from: f  reason: collision with root package name */
    final Scheduler f39349f;

    /* renamed from: g  reason: collision with root package name */
    RefConnection f39350g;

    static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {

        /* renamed from: b  reason: collision with root package name */
        final ObservableRefCount<?> f39351b;

        /* renamed from: c  reason: collision with root package name */
        Disposable f39352c;

        /* renamed from: d  reason: collision with root package name */
        long f39353d;

        /* renamed from: e  reason: collision with root package name */
        boolean f39354e;

        /* renamed from: f  reason: collision with root package name */
        boolean f39355f;

        RefConnection(ObservableRefCount<?> observableRefCount) {
            this.f39351b = observableRefCount;
        }

        /* renamed from: a */
        public void accept(Disposable disposable) throws Exception {
            DisposableHelper.c(this, disposable);
            synchronized (this.f39351b) {
                if (this.f39355f) {
                    ((ResettableConnectable) this.f39351b.f39345b).a(disposable);
                }
            }
        }

        public void run() {
            this.f39351b.d(this);
        }
    }

    static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f39356b;

        /* renamed from: c  reason: collision with root package name */
        final ObservableRefCount<T> f39357c;

        /* renamed from: d  reason: collision with root package name */
        final RefConnection f39358d;

        /* renamed from: e  reason: collision with root package name */
        Disposable f39359e;

        RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.f39356b = observer;
            this.f39357c = observableRefCount;
            this.f39358d = refConnection;
        }

        public void dispose() {
            this.f39359e.dispose();
            if (compareAndSet(false, true)) {
                this.f39357c.b(this.f39358d);
            }
        }

        public boolean isDisposed() {
            return this.f39359e.isDisposed();
        }

        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f39357c.c(this.f39358d);
                this.f39356b.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f39357c.c(this.f39358d);
                this.f39356b.onError(th);
                return;
            }
            RxJavaPlugins.s(th);
        }

        public void onNext(T t2) {
            this.f39356b.onNext(t2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39359e, disposable)) {
                this.f39359e = disposable;
                this.f39356b.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, 1, 0, TimeUnit.NANOSECONDS, (Scheduler) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection r0 = r5.f39350g     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d
            if (r0 == r6) goto L_0x0008
            goto L_0x003d
        L_0x0008:
            long r0 = r6.f39353d     // Catch:{ all -> 0x003f }
            r2 = 1
            long r0 = r0 - r2
            r6.f39353d = r0     // Catch:{ all -> 0x003f }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x003b
            boolean r0 = r6.f39354e     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x001a
            goto L_0x003b
        L_0x001a:
            long r0 = r5.f39347d     // Catch:{ all -> 0x003f }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0025
            r5.d(r6)     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x0025:
            io.reactivex.internal.disposables.SequentialDisposable r0 = new io.reactivex.internal.disposables.SequentialDisposable     // Catch:{ all -> 0x003f }
            r0.<init>()     // Catch:{ all -> 0x003f }
            r6.f39352c = r0     // Catch:{ all -> 0x003f }
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            io.reactivex.Scheduler r1 = r5.f39349f
            long r2 = r5.f39347d
            java.util.concurrent.TimeUnit r4 = r5.f39348e
            io.reactivex.disposables.Disposable r6 = r1.d(r6, r2, r4)
            r0.a(r6)
            return
        L_0x003b:
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x003d:
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x003f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableRefCount.b(io.reactivex.internal.operators.observable.ObservableRefCount$RefConnection):void");
    }

    /* access modifiers changed from: package-private */
    public void c(RefConnection refConnection) {
        synchronized (this) {
            RefConnection refConnection2 = this.f39350g;
            if (refConnection2 != null && refConnection2 == refConnection) {
                this.f39350g = null;
                Disposable disposable = refConnection.f39352c;
                if (disposable != null) {
                    disposable.dispose();
                }
            }
            long j2 = refConnection.f39353d - 1;
            refConnection.f39353d = j2;
            if (j2 == 0) {
                ConnectableObservable<T> connectableObservable = this.f39345b;
                if (connectableObservable instanceof Disposable) {
                    ((Disposable) connectableObservable).dispose();
                } else if (connectableObservable instanceof ResettableConnectable) {
                    ((ResettableConnectable) connectableObservable).a((Disposable) refConnection.get());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.f39353d == 0 && refConnection == this.f39350g) {
                this.f39350g = null;
                Disposable disposable = (Disposable) refConnection.get();
                DisposableHelper.a(refConnection);
                ConnectableObservable<T> connectableObservable = this.f39345b;
                if (connectableObservable instanceof Disposable) {
                    ((Disposable) connectableObservable).dispose();
                } else if (connectableObservable instanceof ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.f39355f = true;
                    } else {
                        ((ResettableConnectable) connectableObservable).a(disposable);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        RefConnection refConnection;
        boolean z2;
        Disposable disposable;
        synchronized (this) {
            refConnection = this.f39350g;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f39350g = refConnection;
            }
            long j2 = refConnection.f39353d;
            if (j2 == 0 && (disposable = refConnection.f39352c) != null) {
                disposable.dispose();
            }
            long j3 = j2 + 1;
            refConnection.f39353d = j3;
            if (refConnection.f39354e || j3 != ((long) this.f39346c)) {
                z2 = false;
            } else {
                z2 = true;
                refConnection.f39354e = true;
            }
        }
        this.f39345b.subscribe(new RefCountObserver(observer, this, refConnection));
        if (z2) {
            this.f39345b.b(refConnection);
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.f39345b = connectableObservable;
        this.f39346c = i2;
        this.f39347d = j2;
        this.f39348e = timeUnit;
        this.f39349f = scheduler;
    }
}
