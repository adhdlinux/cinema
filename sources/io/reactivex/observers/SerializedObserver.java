package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;

public final class SerializedObserver<T> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    final Observer<? super T> f40093b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f40094c;

    /* renamed from: d  reason: collision with root package name */
    Disposable f40095d;

    /* renamed from: e  reason: collision with root package name */
    boolean f40096e;

    /* renamed from: f  reason: collision with root package name */
    AppendOnlyLinkedArrayList<Object> f40097f;

    /* renamed from: g  reason: collision with root package name */
    volatile boolean f40098g;

    public SerializedObserver(Observer<? super T> observer) {
        this(observer, false);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f40097f;
                if (appendOnlyLinkedArrayList == null) {
                    this.f40096e = false;
                    return;
                }
                this.f40097f = null;
            }
        } while (!appendOnlyLinkedArrayList.a(this.f40093b));
    }

    public void dispose() {
        this.f40095d.dispose();
    }

    public boolean isDisposed() {
        return this.f40095d.isDisposed();
    }

    public void onComplete() {
        if (!this.f40098g) {
            synchronized (this) {
                if (!this.f40098g) {
                    if (this.f40096e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f40097f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f40097f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.b(NotificationLite.c());
                        return;
                    }
                    this.f40098g = true;
                    this.f40096e = true;
                    this.f40093b.onComplete();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        io.reactivex.plugins.RxJavaPlugins.s(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.f40093b.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f40098g
            if (r0 == 0) goto L_0x0008
            io.reactivex.plugins.RxJavaPlugins.s(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f40098g     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f40096e     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f40098g = r1     // Catch:{ all -> 0x0044 }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f40097f     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f40097f = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.e(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f40094c     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.b(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.d(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f40098g = r1     // Catch:{ all -> 0x0044 }
            r2.f40096e = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            io.reactivex.plugins.RxJavaPlugins.s(r3)
            return
        L_0x003e:
            io.reactivex.Observer<? super T> r0 = r2.f40093b
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.observers.SerializedObserver.onError(java.lang.Throwable):void");
    }

    public void onNext(T t2) {
        if (!this.f40098g) {
            if (t2 == null) {
                this.f40095d.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f40098g) {
                    if (this.f40096e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f40097f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f40097f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.b(NotificationLite.j(t2));
                        return;
                    }
                    this.f40096e = true;
                    this.f40093b.onNext(t2);
                    a();
                }
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.h(this.f40095d, disposable)) {
            this.f40095d = disposable;
            this.f40093b.onSubscribe(this);
        }
    }

    public SerializedObserver(Observer<? super T> observer, boolean z2) {
        this.f40093b = observer;
        this.f40094c = z2;
    }
}
