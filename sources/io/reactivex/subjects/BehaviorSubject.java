package io.reactivex.subjects;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class BehaviorSubject<T> extends Subject<T> {

    /* renamed from: i  reason: collision with root package name */
    private static final Object[] f40138i = new Object[0];

    /* renamed from: j  reason: collision with root package name */
    static final BehaviorDisposable[] f40139j = new BehaviorDisposable[0];

    /* renamed from: k  reason: collision with root package name */
    static final BehaviorDisposable[] f40140k = new BehaviorDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<Object> f40141b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<BehaviorDisposable<T>[]> f40142c = new AtomicReference<>(f40139j);

    /* renamed from: d  reason: collision with root package name */
    final ReadWriteLock f40143d;

    /* renamed from: e  reason: collision with root package name */
    final Lock f40144e;

    /* renamed from: f  reason: collision with root package name */
    final Lock f40145f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<Throwable> f40146g = new AtomicReference<>();

    /* renamed from: h  reason: collision with root package name */
    long f40147h;

    static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super T> f40148b;

        /* renamed from: c  reason: collision with root package name */
        final BehaviorSubject<T> f40149c;

        /* renamed from: d  reason: collision with root package name */
        boolean f40150d;

        /* renamed from: e  reason: collision with root package name */
        boolean f40151e;

        /* renamed from: f  reason: collision with root package name */
        AppendOnlyLinkedArrayList<Object> f40152f;

        /* renamed from: g  reason: collision with root package name */
        boolean f40153g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f40154h;

        /* renamed from: i  reason: collision with root package name */
        long f40155i;

        BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            this.f40148b = observer;
            this.f40149c = behaviorSubject;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            if (test(r0) == false) goto L_0x003a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
            b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r4 = this;
                boolean r0 = r4.f40154h
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r4)
                boolean r0 = r4.f40154h     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x000c:
                boolean r0 = r4.f40150d     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x0012
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                return
            L_0x0012:
                io.reactivex.subjects.BehaviorSubject<T> r0 = r4.f40149c     // Catch:{ all -> 0x003e }
                java.util.concurrent.locks.Lock r1 = r0.f40144e     // Catch:{ all -> 0x003e }
                r1.lock()     // Catch:{ all -> 0x003e }
                long r2 = r0.f40147h     // Catch:{ all -> 0x003e }
                r4.f40155i = r2     // Catch:{ all -> 0x003e }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r0.f40141b     // Catch:{ all -> 0x003e }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x003e }
                r1.unlock()     // Catch:{ all -> 0x003e }
                r1 = 1
                if (r0 == 0) goto L_0x002b
                r2 = 1
                goto L_0x002c
            L_0x002b:
                r2 = 0
            L_0x002c:
                r4.f40151e = r2     // Catch:{ all -> 0x003e }
                r4.f40150d = r1     // Catch:{ all -> 0x003e }
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                if (r0 == 0) goto L_0x003d
                boolean r0 = r4.test(r0)
                if (r0 == 0) goto L_0x003a
                return
            L_0x003a:
                r4.b()
            L_0x003d:
                return
            L_0x003e:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x003e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.BehaviorDisposable.a():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            r0.c(r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r2 = this;
            L_0x0000:
                boolean r0 = r2.f40154h
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                monitor-enter(r2)
                io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f40152f     // Catch:{ all -> 0x0017 }
                if (r0 != 0) goto L_0x000f
                r0 = 0
                r2.f40151e = r0     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                return
            L_0x000f:
                r1 = 0
                r2.f40152f = r1     // Catch:{ all -> 0x0017 }
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                r0.c(r2)
                goto L_0x0000
            L_0x0017:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0017 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.BehaviorDisposable.b():void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0031, code lost:
            r3.f40153g = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(java.lang.Object r4, long r5) {
            /*
                r3 = this;
                boolean r0 = r3.f40154h
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                boolean r0 = r3.f40153g
                if (r0 != 0) goto L_0x0037
                monitor-enter(r3)
                boolean r0 = r3.f40154h     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0010
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x0010:
                long r0 = r3.f40155i     // Catch:{ all -> 0x0034 }
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 != 0) goto L_0x0018
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x0018:
                boolean r5 = r3.f40151e     // Catch:{ all -> 0x0034 }
                if (r5 == 0) goto L_0x002d
                io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r5 = r3.f40152f     // Catch:{ all -> 0x0034 }
                if (r5 != 0) goto L_0x0028
                io.reactivex.internal.util.AppendOnlyLinkedArrayList r5 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0034 }
                r6 = 4
                r5.<init>(r6)     // Catch:{ all -> 0x0034 }
                r3.f40152f = r5     // Catch:{ all -> 0x0034 }
            L_0x0028:
                r5.b(r4)     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                return
            L_0x002d:
                r5 = 1
                r3.f40150d = r5     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                r3.f40153g = r5
                goto L_0x0037
            L_0x0034:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                throw r4
            L_0x0037:
                r3.test(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.BehaviorDisposable.c(java.lang.Object, long):void");
        }

        public void dispose() {
            if (!this.f40154h) {
                this.f40154h = true;
                this.f40149c.e(this);
            }
        }

        public boolean isDisposed() {
            return this.f40154h;
        }

        public boolean test(Object obj) {
            return this.f40154h || NotificationLite.a(obj, this.f40148b);
        }
    }

    BehaviorSubject() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f40143d = reentrantReadWriteLock;
        this.f40144e = reentrantReadWriteLock.readLock();
        this.f40145f = reentrantReadWriteLock.writeLock();
    }

    public static <T> BehaviorSubject<T> d() {
        return new BehaviorSubject<>();
    }

    /* access modifiers changed from: package-private */
    public boolean c(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.f40142c.get();
            if (behaviorDisposableArr == f40140k) {
                return false;
            }
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new BehaviorDisposable[(length + 1)];
            System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!f.a(this.f40142c, behaviorDisposableArr, behaviorDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e(BehaviorDisposable<T> behaviorDisposable) {
        BehaviorDisposable<T>[] behaviorDisposableArr;
        BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = (BehaviorDisposable[]) this.f40142c.get();
            int length = behaviorDisposableArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (behaviorDisposableArr[i2] == behaviorDisposable) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        behaviorDisposableArr2 = f40139j;
                    } else {
                        BehaviorDisposable[] behaviorDisposableArr3 = new BehaviorDisposable[(length - 1)];
                        System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i2);
                        System.arraycopy(behaviorDisposableArr, i2 + 1, behaviorDisposableArr3, i2, (length - i2) - 1);
                        behaviorDisposableArr2 = behaviorDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!f.a(this.f40142c, behaviorDisposableArr, behaviorDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    public void f(Object obj) {
        this.f40145f.lock();
        this.f40147h++;
        this.f40141b.lazySet(obj);
        this.f40145f.unlock();
    }

    /* access modifiers changed from: package-private */
    public BehaviorDisposable<T>[] g(Object obj) {
        AtomicReference<BehaviorDisposable<T>[]> atomicReference = this.f40142c;
        BehaviorDisposable<T>[] behaviorDisposableArr = f40140k;
        BehaviorDisposable<T>[] behaviorDisposableArr2 = (BehaviorDisposable[]) atomicReference.getAndSet(behaviorDisposableArr);
        if (behaviorDisposableArr2 != behaviorDisposableArr) {
            f(obj);
        }
        return behaviorDisposableArr2;
    }

    public void onComplete() {
        if (f.a(this.f40146g, (Object) null, ExceptionHelper.f40066a)) {
            Object c2 = NotificationLite.c();
            for (BehaviorDisposable c3 : g(c2)) {
                c3.c(c2, this.f40147h);
            }
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.e(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!f.a(this.f40146g, (Object) null, th)) {
            RxJavaPlugins.s(th);
            return;
        }
        Object e2 = NotificationLite.e(th);
        for (BehaviorDisposable c2 : g(e2)) {
            c2.c(e2, this.f40147h);
        }
    }

    public void onNext(T t2) {
        ObjectHelper.e(t2, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f40146g.get() == null) {
            Object j2 = NotificationLite.j(t2);
            f(j2);
            for (BehaviorDisposable c2 : (BehaviorDisposable[]) this.f40142c.get()) {
                c2.c(j2, this.f40147h);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f40146g.get() != null) {
            disposable.dispose();
        }
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        BehaviorDisposable behaviorDisposable = new BehaviorDisposable(observer, this);
        observer.onSubscribe(behaviorDisposable);
        if (!c(behaviorDisposable)) {
            Throwable th = this.f40146g.get();
            if (th == ExceptionHelper.f40066a) {
                observer.onComplete();
            } else {
                observer.onError(th);
            }
        } else if (behaviorDisposable.f40154h) {
            e(behaviorDisposable);
        } else {
            behaviorDisposable.a();
        }
    }
}
