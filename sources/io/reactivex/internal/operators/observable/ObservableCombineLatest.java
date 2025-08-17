package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCombineLatest<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    final ObservableSource<? extends T>[] f38791b;

    /* renamed from: c  reason: collision with root package name */
    final Iterable<? extends ObservableSource<? extends T>> f38792c;

    /* renamed from: d  reason: collision with root package name */
    final Function<? super Object[], ? extends R> f38793d;

    /* renamed from: e  reason: collision with root package name */
    final int f38794e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f38795f;

    static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        final LatestCoordinator<T, R> f38796b;

        /* renamed from: c  reason: collision with root package name */
        final int f38797c;

        CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i2) {
            this.f38796b = latestCoordinator;
            this.f38797c = i2;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.f38796b.d(this.f38797c);
        }

        public void onError(Throwable th) {
            this.f38796b.e(this.f38797c, th);
        }

        public void onNext(T t2) {
            this.f38796b.f(this.f38797c, t2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }
    }

    static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f38798b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super Object[], ? extends R> f38799c;

        /* renamed from: d  reason: collision with root package name */
        final CombinerObserver<T, R>[] f38800d;

        /* renamed from: e  reason: collision with root package name */
        Object[] f38801e;

        /* renamed from: f  reason: collision with root package name */
        final SpscLinkedArrayQueue<Object[]> f38802f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f38803g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f38804h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f38805i;

        /* renamed from: j  reason: collision with root package name */
        final AtomicThrowable f38806j = new AtomicThrowable();

        /* renamed from: k  reason: collision with root package name */
        int f38807k;

        /* renamed from: l  reason: collision with root package name */
        int f38808l;

        LatestCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i2, int i3, boolean z2) {
            this.f38798b = observer;
            this.f38799c = function;
            this.f38803g = z2;
            this.f38801e = new Object[i2];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                combinerObserverArr[i4] = new CombinerObserver<>(this, i4);
            }
            this.f38800d = combinerObserverArr;
            this.f38802f = new SpscLinkedArrayQueue<>(i3);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            for (CombinerObserver<T, R> a2 : this.f38800d) {
                a2.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            synchronized (this) {
                this.f38801e = null;
            }
            spscLinkedArrayQueue.clear();
        }

        /* access modifiers changed from: package-private */
        public void c() {
            boolean z2;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object[]> spscLinkedArrayQueue = this.f38802f;
                Observer<? super R> observer = this.f38798b;
                boolean z3 = this.f38803g;
                int i2 = 1;
                while (!this.f38804h) {
                    if (z3 || this.f38806j.get() == null) {
                        boolean z4 = this.f38805i;
                        Object[] poll = spscLinkedArrayQueue.poll();
                        if (poll == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z4 && z2) {
                            b(spscLinkedArrayQueue);
                            Throwable b2 = this.f38806j.b();
                            if (b2 == null) {
                                observer.onComplete();
                                return;
                            } else {
                                observer.onError(b2);
                                return;
                            }
                        } else if (z2) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            try {
                                observer.onNext(ObjectHelper.e(this.f38799c.apply(poll), "The combiner returned a null value"));
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                this.f38806j.a(th);
                                a();
                                b(spscLinkedArrayQueue);
                                observer.onError(this.f38806j.b());
                                return;
                            }
                        }
                    } else {
                        a();
                        b(spscLinkedArrayQueue);
                        observer.onError(this.f38806j.b());
                        return;
                    }
                }
                b(spscLinkedArrayQueue);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            if (r2 == r0.length) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
            if (r4 == false) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
            a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
            c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.f38801e     // Catch:{ all -> 0x0025 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                return
            L_0x0007:
                r4 = r0[r4]     // Catch:{ all -> 0x0025 }
                r1 = 1
                if (r4 != 0) goto L_0x000e
                r4 = 1
                goto L_0x000f
            L_0x000e:
                r4 = 0
            L_0x000f:
                if (r4 != 0) goto L_0x0019
                int r2 = r3.f38808l     // Catch:{ all -> 0x0025 }
                int r2 = r2 + r1
                r3.f38808l = r2     // Catch:{ all -> 0x0025 }
                int r0 = r0.length     // Catch:{ all -> 0x0025 }
                if (r2 != r0) goto L_0x001b
            L_0x0019:
                r3.f38805i = r1     // Catch:{ all -> 0x0025 }
            L_0x001b:
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                if (r4 == 0) goto L_0x0021
                r3.a()
            L_0x0021:
                r3.c()
                return
            L_0x0025:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.d(int):void");
        }

        public void dispose() {
            if (!this.f38804h) {
                this.f38804h = true;
                a();
                if (getAndIncrement() == 0) {
                    b(this.f38802f);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
            if (r1 == r4.length) goto L_0x0025;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
            r0 = r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void e(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.reactivex.internal.util.AtomicThrowable r0 = r2.f38806j
                boolean r0 = r0.a(r4)
                if (r0 == 0) goto L_0x0036
                boolean r4 = r2.f38803g
                r0 = 1
                if (r4 == 0) goto L_0x002d
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.f38801e     // Catch:{ all -> 0x002a }
                if (r4 != 0) goto L_0x0014
                monitor-exit(r2)     // Catch:{ all -> 0x002a }
                return
            L_0x0014:
                r3 = r4[r3]     // Catch:{ all -> 0x002a }
                if (r3 != 0) goto L_0x001a
                r3 = 1
                goto L_0x001b
            L_0x001a:
                r3 = 0
            L_0x001b:
                if (r3 != 0) goto L_0x0025
                int r1 = r2.f38808l     // Catch:{ all -> 0x002a }
                int r1 = r1 + r0
                r2.f38808l = r1     // Catch:{ all -> 0x002a }
                int r4 = r4.length     // Catch:{ all -> 0x002a }
                if (r1 != r4) goto L_0x0027
            L_0x0025:
                r2.f38805i = r0     // Catch:{ all -> 0x002a }
            L_0x0027:
                monitor-exit(r2)     // Catch:{ all -> 0x002a }
                r0 = r3
                goto L_0x002d
            L_0x002a:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x002a }
                throw r3
            L_0x002d:
                if (r0 == 0) goto L_0x0032
                r2.a()
            L_0x0032:
                r2.c()
                goto L_0x0039
            L_0x0036:
                io.reactivex.plugins.RxJavaPlugins.s(r4)
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.e(int, java.lang.Throwable):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            if (r4 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f(int r4, T r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.f38801e     // Catch:{ all -> 0x0029 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                return
            L_0x0007:
                r1 = r0[r4]     // Catch:{ all -> 0x0029 }
                int r2 = r3.f38807k     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0011
                int r2 = r2 + 1
                r3.f38807k = r2     // Catch:{ all -> 0x0029 }
            L_0x0011:
                r0[r4] = r5     // Catch:{ all -> 0x0029 }
                int r4 = r0.length     // Catch:{ all -> 0x0029 }
                if (r2 != r4) goto L_0x0021
                io.reactivex.internal.queue.SpscLinkedArrayQueue<java.lang.Object[]> r4 = r3.f38802f     // Catch:{ all -> 0x0029 }
                java.lang.Object r5 = r0.clone()     // Catch:{ all -> 0x0029 }
                r4.offer(r5)     // Catch:{ all -> 0x0029 }
                r4 = 1
                goto L_0x0022
            L_0x0021:
                r4 = 0
            L_0x0022:
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                if (r4 == 0) goto L_0x0028
                r3.c()
            L_0x0028:
                return
            L_0x0029:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.f(int, java.lang.Object):void");
        }

        public void g(ObservableSource<? extends T>[] observableSourceArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.f38800d;
            int length = combinerObserverArr.length;
            this.f38798b.onSubscribe(this);
            for (int i2 = 0; i2 < length && !this.f38805i && !this.f38804h; i2++) {
                observableSourceArr[i2].subscribe(combinerObserverArr[i2]);
            }
        }

        public boolean isDisposed() {
            return this.f38804h;
        }
    }

    public ObservableCombineLatest(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i2, boolean z2) {
        this.f38791b = observableSourceArr;
        this.f38792c = iterable;
        this.f38793d = function;
        this.f38794e = i2;
        this.f38795f = z2;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i2;
        ObservableSource<? extends T>[] observableSourceArr = this.f38791b;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            i2 = 0;
            for (ObservableSource<? extends T> observableSource : this.f38792c) {
                if (i2 == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i2 >> 2) + i2)];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i2);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[i2] = observableSource;
                i2++;
            }
        } else {
            i2 = observableSourceArr.length;
        }
        int i3 = i2;
        if (i3 == 0) {
            EmptyDisposable.c(observer);
            return;
        }
        new LatestCoordinator(observer, this.f38793d, i3, this.f38794e, this.f38795f).g(observableSourceArr);
    }
}
