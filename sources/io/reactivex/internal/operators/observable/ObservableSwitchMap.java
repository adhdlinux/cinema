package io.reactivex.internal.operators.observable;

import androidx.media3.exoplayer.mediacodec.f;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    final Function<? super T, ? extends ObservableSource<? extends R>> f39571c;

    /* renamed from: d  reason: collision with root package name */
    final int f39572d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f39573e;

    static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {

        /* renamed from: b  reason: collision with root package name */
        final SwitchMapObserver<T, R> f39574b;

        /* renamed from: c  reason: collision with root package name */
        final long f39575c;

        /* renamed from: d  reason: collision with root package name */
        final int f39576d;

        /* renamed from: e  reason: collision with root package name */
        volatile SimpleQueue<R> f39577e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f39578f;

        SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j2, int i2) {
            this.f39574b = switchMapObserver;
            this.f39575c = j2;
            this.f39576d = i2;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            if (this.f39575c == this.f39574b.f39589k) {
                this.f39578f = true;
                this.f39574b.b();
            }
        }

        public void onError(Throwable th) {
            this.f39574b.c(this, th);
        }

        public void onNext(R r2) {
            if (this.f39575c == this.f39574b.f39589k) {
                if (r2 != null) {
                    this.f39577e.offer(r2);
                }
                this.f39574b.b();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.f(this, disposable)) {
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int b2 = queueDisposable.b(7);
                    if (b2 == 1) {
                        this.f39577e = queueDisposable;
                        this.f39578f = true;
                        this.f39574b.b();
                        return;
                    } else if (b2 == 2) {
                        this.f39577e = queueDisposable;
                        return;
                    }
                }
                this.f39577e = new SpscLinkedArrayQueue(this.f39576d);
            }
        }
    }

    static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: l  reason: collision with root package name */
        static final SwitchMapInnerObserver<Object, Object> f39579l;

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super R> f39580b;

        /* renamed from: c  reason: collision with root package name */
        final Function<? super T, ? extends ObservableSource<? extends R>> f39581c;

        /* renamed from: d  reason: collision with root package name */
        final int f39582d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f39583e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicThrowable f39584f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f39585g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f39586h;

        /* renamed from: i  reason: collision with root package name */
        Disposable f39587i;

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<SwitchMapInnerObserver<T, R>> f39588j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        volatile long f39589k;

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>((SwitchMapObserver) null, -1, 1);
            f39579l = switchMapInnerObserver;
            switchMapInnerObserver.a();
        }

        SwitchMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z2) {
            this.f39580b = observer;
            this.f39581c = function;
            this.f39582d = i2;
            this.f39583e = z2;
            this.f39584f = new AtomicThrowable();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            SwitchMapInnerObserver<Object, Object> andSet;
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = this.f39588j.get();
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver2 = f39579l;
            if (switchMapInnerObserver != switchMapInnerObserver2 && (andSet = this.f39588j.getAndSet(switchMapInnerObserver2)) != switchMapInnerObserver2 && andSet != null) {
                andSet.a();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x000f A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                io.reactivex.Observer<? super R> r0 = r13.f39580b
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver<T, R>> r1 = r13.f39588j
                boolean r2 = r13.f39583e
                r3 = 1
                r4 = 1
            L_0x000f:
                boolean r5 = r13.f39586h
                if (r5 == 0) goto L_0x0014
                return
            L_0x0014:
                boolean r5 = r13.f39585g
                r6 = 0
                if (r5 == 0) goto L_0x0052
                java.lang.Object r5 = r1.get()
                if (r5 != 0) goto L_0x0021
                r5 = 1
                goto L_0x0022
            L_0x0021:
                r5 = 0
            L_0x0022:
                if (r2 == 0) goto L_0x0038
                if (r5 == 0) goto L_0x0052
                io.reactivex.internal.util.AtomicThrowable r1 = r13.f39584f
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x0034
                r0.onError(r1)
                goto L_0x0037
            L_0x0034:
                r0.onComplete()
            L_0x0037:
                return
            L_0x0038:
                io.reactivex.internal.util.AtomicThrowable r7 = r13.f39584f
                java.lang.Object r7 = r7.get()
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L_0x004c
                io.reactivex.internal.util.AtomicThrowable r1 = r13.f39584f
                java.lang.Throwable r1 = r1.b()
                r0.onError(r1)
                return
            L_0x004c:
                if (r5 == 0) goto L_0x0052
                r0.onComplete()
                return
            L_0x0052:
                java.lang.Object r5 = r1.get()
                io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver r5 = (io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver) r5
                if (r5 == 0) goto L_0x00e9
                io.reactivex.internal.fuseable.SimpleQueue<R> r7 = r5.f39577e
                if (r7 == 0) goto L_0x00e9
                boolean r8 = r5.f39578f
                r9 = 0
                if (r8 == 0) goto L_0x0089
                boolean r8 = r7.isEmpty()
                if (r2 == 0) goto L_0x006f
                if (r8 == 0) goto L_0x0089
                androidx.media3.exoplayer.mediacodec.f.a(r1, r5, r9)
                goto L_0x000f
            L_0x006f:
                io.reactivex.internal.util.AtomicThrowable r10 = r13.f39584f
                java.lang.Object r10 = r10.get()
                java.lang.Throwable r10 = (java.lang.Throwable) r10
                if (r10 == 0) goto L_0x0083
                io.reactivex.internal.util.AtomicThrowable r1 = r13.f39584f
                java.lang.Throwable r1 = r1.b()
                r0.onError(r1)
                return
            L_0x0083:
                if (r8 == 0) goto L_0x0089
                androidx.media3.exoplayer.mediacodec.f.a(r1, r5, r9)
                goto L_0x000f
            L_0x0089:
                r8 = 0
            L_0x008a:
                boolean r10 = r13.f39586h
                if (r10 == 0) goto L_0x008f
                return
            L_0x008f:
                java.lang.Object r10 = r1.get()
                if (r5 == r10) goto L_0x0097
            L_0x0095:
                r8 = 1
                goto L_0x00e1
            L_0x0097:
                if (r2 != 0) goto L_0x00ad
                io.reactivex.internal.util.AtomicThrowable r10 = r13.f39584f
                java.lang.Object r10 = r10.get()
                java.lang.Throwable r10 = (java.lang.Throwable) r10
                if (r10 == 0) goto L_0x00ad
                io.reactivex.internal.util.AtomicThrowable r1 = r13.f39584f
                java.lang.Throwable r1 = r1.b()
                r0.onError(r1)
                return
            L_0x00ad:
                boolean r10 = r5.f39578f
                java.lang.Object r11 = r7.poll()     // Catch:{ all -> 0x00b4 }
                goto L_0x00d2
            L_0x00b4:
                r8 = move-exception
                io.reactivex.exceptions.Exceptions.b(r8)
                io.reactivex.internal.util.AtomicThrowable r11 = r13.f39584f
                r11.a(r8)
                androidx.media3.exoplayer.mediacodec.f.a(r1, r5, r9)
                if (r2 != 0) goto L_0x00cd
                r13.a()
                io.reactivex.disposables.Disposable r8 = r13.f39587i
                r8.dispose()
                r13.f39585g = r3
                goto L_0x00d0
            L_0x00cd:
                r5.a()
            L_0x00d0:
                r11 = r9
                r8 = 1
            L_0x00d2:
                if (r11 != 0) goto L_0x00d6
                r12 = 1
                goto L_0x00d7
            L_0x00d6:
                r12 = 0
            L_0x00d7:
                if (r10 == 0) goto L_0x00df
                if (r12 == 0) goto L_0x00df
                androidx.media3.exoplayer.mediacodec.f.a(r1, r5, r9)
                goto L_0x0095
            L_0x00df:
                if (r12 == 0) goto L_0x00e5
            L_0x00e1:
                if (r8 == 0) goto L_0x00e9
                goto L_0x000f
            L_0x00e5:
                r0.onNext(r11)
                goto L_0x008a
            L_0x00e9:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto L_0x000f
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.b():void");
        }

        /* access modifiers changed from: package-private */
        public void c(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th) {
            if (switchMapInnerObserver.f39575c != this.f39589k || !this.f39584f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f39583e) {
                this.f39587i.dispose();
            }
            switchMapInnerObserver.f39578f = true;
            b();
        }

        public void dispose() {
            if (!this.f39586h) {
                this.f39586h = true;
                this.f39587i.dispose();
                a();
            }
        }

        public boolean isDisposed() {
            return this.f39586h;
        }

        public void onComplete() {
            if (!this.f39585g) {
                this.f39585g = true;
                b();
            }
        }

        public void onError(Throwable th) {
            if (this.f39585g || !this.f39584f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f39583e) {
                a();
            }
            this.f39585g = true;
            b();
        }

        public void onNext(T t2) {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
            long j2 = this.f39589k + 1;
            this.f39589k = j2;
            SwitchMapInnerObserver switchMapInnerObserver2 = this.f39588j.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.a();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.e(this.f39581c.apply(t2), "The ObservableSource returned is null");
                SwitchMapInnerObserver switchMapInnerObserver3 = new SwitchMapInnerObserver(this, j2, this.f39582d);
                do {
                    switchMapInnerObserver = this.f39588j.get();
                    if (switchMapInnerObserver == f39579l) {
                        return;
                    }
                } while (!f.a(this.f39588j, switchMapInnerObserver, switchMapInnerObserver3));
                observableSource.subscribe(switchMapInnerObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f39587i.dispose();
                onError(th);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.h(this.f39587i, disposable)) {
                this.f39587i = disposable;
                this.f39580b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z2) {
        super(observableSource);
        this.f39571c = function;
        this.f39572d = i2;
        this.f39573e = z2;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!ObservableScalarXMap.b(this.f38612b, observer, this.f39571c)) {
            this.f38612b.subscribe(new SwitchMapObserver(observer, this.f39571c, this.f39572d, this.f39573e));
        }
    }
}
