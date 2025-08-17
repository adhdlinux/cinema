package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;

final class SerializedSubject<T> extends Subject<T> implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {

    /* renamed from: b  reason: collision with root package name */
    final Subject<T> f40162b;

    /* renamed from: c  reason: collision with root package name */
    boolean f40163c;

    /* renamed from: d  reason: collision with root package name */
    AppendOnlyLinkedArrayList<Object> f40164d;

    /* renamed from: e  reason: collision with root package name */
    volatile boolean f40165e;

    SerializedSubject(Subject<T> subject) {
        this.f40162b = subject;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f40164d;
                if (appendOnlyLinkedArrayList == null) {
                    this.f40163c = false;
                    return;
                }
                this.f40164d = null;
            }
            appendOnlyLinkedArrayList.c(this);
        }
        while (true) {
        }
    }

    public void onComplete() {
        if (!this.f40165e) {
            synchronized (this) {
                if (!this.f40165e) {
                    this.f40165e = true;
                    if (this.f40163c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f40164d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f40164d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.b(NotificationLite.c());
                        return;
                    }
                    this.f40163c = true;
                    this.f40162b.onComplete();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        if (r1 == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        io.reactivex.plugins.RxJavaPlugins.s(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r2.f40162b.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f40165e
            if (r0 == 0) goto L_0x0008
            io.reactivex.plugins.RxJavaPlugins.s(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f40165e     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002d
        L_0x000f:
            r2.f40165e = r1     // Catch:{ all -> 0x003a }
            boolean r0 = r2.f40163c     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x002a
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f40164d     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x003a }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003a }
            r2.f40164d = r0     // Catch:{ all -> 0x003a }
        L_0x0021:
            java.lang.Object r3 = io.reactivex.internal.util.NotificationLite.e(r3)     // Catch:{ all -> 0x003a }
            r0.d(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            return
        L_0x002a:
            r2.f40163c = r1     // Catch:{ all -> 0x003a }
            r1 = 0
        L_0x002d:
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0034
            io.reactivex.plugins.RxJavaPlugins.s(r3)
            return
        L_0x0034:
            io.reactivex.subjects.Subject<T> r0 = r2.f40162b
            r0.onError(r3)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.SerializedSubject.onError(java.lang.Throwable):void");
    }

    public void onNext(T t2) {
        if (!this.f40165e) {
            synchronized (this) {
                if (!this.f40165e) {
                    if (this.f40163c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f40164d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f40164d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.b(NotificationLite.j(t2));
                        return;
                    }
                    this.f40163c = true;
                    this.f40162b.onNext(t2);
                    c();
                }
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        boolean z2 = true;
        if (!this.f40165e) {
            synchronized (this) {
                if (!this.f40165e) {
                    if (this.f40163c) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f40164d;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f40164d = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.b(NotificationLite.d(disposable));
                        return;
                    }
                    this.f40163c = true;
                    z2 = false;
                }
            }
        }
        if (z2) {
            disposable.dispose();
            return;
        }
        this.f40162b.onSubscribe(disposable);
        c();
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f40162b.subscribe(observer);
    }

    public boolean test(Object obj) {
        return NotificationLite.b(obj, this.f40162b);
    }
}
