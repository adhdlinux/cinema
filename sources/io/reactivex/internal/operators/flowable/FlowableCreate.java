package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCreate<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    final FlowableOnSubscribe<T> f38422c;

    /* renamed from: d  reason: collision with root package name */
    final BackpressureStrategy f38423d;

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCreate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f38424a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.reactivex.BackpressureStrategy[] r0 = io.reactivex.BackpressureStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f38424a = r0
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f38424a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f38424a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f38424a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCreate.AnonymousClass1.<clinit>():void");
        }
    }

    static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        final Subscriber<? super T> f38425b;

        /* renamed from: c  reason: collision with root package name */
        final SequentialDisposable f38426c = new SequentialDisposable();

        BaseEmitter(Subscriber<? super T> subscriber) {
            this.f38425b = subscriber;
        }

        public final void a(Disposable disposable) {
            this.f38426c.b(disposable);
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (!isCancelled()) {
                try {
                    this.f38425b.onComplete();
                } finally {
                    this.f38426c.dispose();
                }
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        public boolean c(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.f38425b.onError(th);
                this.f38426c.dispose();
                return true;
            } catch (Throwable th2) {
                this.f38426c.dispose();
                throw th2;
            }
        }

        public final void cancel() {
            this.f38426c.dispose();
            f();
        }

        public final void d(Throwable th) {
            if (!g(th)) {
                RxJavaPlugins.s(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
        }

        /* access modifiers changed from: package-private */
        public void f() {
        }

        public boolean g(Throwable th) {
            return c(th);
        }

        public final boolean isCancelled() {
            return this.f38426c.isDisposed();
        }

        public final void request(long j2) {
            if (SubscriptionHelper.f(j2)) {
                BackpressureHelper.a(this, j2);
                e();
            }
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {

        /* renamed from: d  reason: collision with root package name */
        final SpscLinkedArrayQueue<T> f38427d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f38428e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f38429f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f38430g = new AtomicInteger();

        BufferAsyncEmitter(Subscriber<? super T> subscriber, int i2) {
            super(subscriber);
            this.f38427d = new SpscLinkedArrayQueue<>(i2);
        }

        /* access modifiers changed from: package-private */
        public void e() {
            h();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            if (this.f38430g.getAndIncrement() == 0) {
                this.f38427d.clear();
            }
        }

        public boolean g(Throwable th) {
            if (this.f38429f || isCancelled()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f38428e = th;
            this.f38429f = true;
            h();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            int i2;
            boolean z2;
            if (this.f38430g.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f38425b;
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.f38427d;
                int i3 = 1;
                do {
                    long j2 = get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (isCancelled()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        } else {
                            boolean z3 = this.f38429f;
                            T poll = spscLinkedArrayQueue.poll();
                            if (poll == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z3 && z2) {
                                Throwable th = this.f38428e;
                                if (th != null) {
                                    c(th);
                                    return;
                                } else {
                                    b();
                                    return;
                                }
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j3++;
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (isCancelled()) {
                            spscLinkedArrayQueue.clear();
                            return;
                        }
                        boolean z4 = this.f38429f;
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (z4 && isEmpty) {
                            Throwable th2 = this.f38428e;
                            if (th2 != null) {
                                c(th2);
                                return;
                            } else {
                                b();
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        BackpressureHelper.c(this, j3);
                    }
                    i3 = this.f38430g.addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public void onNext(T t2) {
            if (!this.f38429f && !isCancelled()) {
                if (t2 == null) {
                    d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f38427d.offer(t2);
                h();
            }
        }
    }

    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        DropAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        /* access modifiers changed from: package-private */
        public void h() {
        }
    }

    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        /* access modifiers changed from: package-private */
        public void h() {
            d(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<T> f38431d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        Throwable f38432e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f38433f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicInteger f38434g = new AtomicInteger();

        LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        /* access modifiers changed from: package-private */
        public void e() {
            h();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            if (this.f38434g.getAndIncrement() == 0) {
                this.f38431d.lazySet((Object) null);
            }
        }

        public boolean g(Throwable th) {
            if (this.f38433f || isCancelled()) {
                return false;
            }
            if (th == null) {
                d(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.f38432e = th;
            this.f38433f = true;
            h();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            boolean z2;
            int i2;
            boolean z3;
            if (this.f38434g.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.f38425b;
                AtomicReference<T> atomicReference = this.f38431d;
                int i3 = 1;
                do {
                    long j2 = get();
                    long j3 = 0;
                    while (true) {
                        z2 = false;
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        } else if (isCancelled()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        } else {
                            boolean z4 = this.f38433f;
                            T andSet = atomicReference.getAndSet((Object) null);
                            if (andSet == null) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z4 && z3) {
                                Throwable th = this.f38432e;
                                if (th != null) {
                                    c(th);
                                    return;
                                } else {
                                    b();
                                    return;
                                }
                            } else if (z3) {
                                break;
                            } else {
                                subscriber.onNext(andSet);
                                j3++;
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (isCancelled()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        }
                        boolean z5 = this.f38433f;
                        if (atomicReference.get() == null) {
                            z2 = true;
                        }
                        if (z5 && z2) {
                            Throwable th2 = this.f38432e;
                            if (th2 != null) {
                                c(th2);
                                return;
                            } else {
                                b();
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        BackpressureHelper.c(this, j3);
                    }
                    i3 = this.f38434g.addAndGet(-i3);
                } while (i3 != 0);
            }
        }

        public void onNext(T t2) {
            if (!this.f38433f && !isCancelled()) {
                if (t2 == null) {
                    d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f38431d.set(t2);
                h();
            }
        }
    }

    static final class MissingEmitter<T> extends BaseEmitter<T> {
        MissingEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onNext(T t2) {
            long j2;
            if (!isCancelled()) {
                if (t2 != null) {
                    this.f38425b.onNext(t2);
                    do {
                        j2 = get();
                        if (j2 == 0 || compareAndSet(j2, j2 - 1)) {
                            return;
                        }
                        j2 = get();
                        return;
                    } while (compareAndSet(j2, j2 - 1));
                    return;
                }
                d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
        }
    }

    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        /* access modifiers changed from: package-private */
        public abstract void h();

        public final void onNext(T t2) {
            if (!isCancelled()) {
                if (t2 == null) {
                    d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else if (get() != 0) {
                    this.f38425b.onNext(t2);
                    BackpressureHelper.c(this, 1);
                } else {
                    h();
                }
            }
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.f38422c = flowableOnSubscribe;
        this.f38423d = backpressureStrategy;
    }

    public void o(Subscriber<? super T> subscriber) {
        BaseEmitter baseEmitter;
        int i2 = AnonymousClass1.f38424a[this.f38423d.ordinal()];
        if (i2 == 1) {
            baseEmitter = new MissingEmitter(subscriber);
        } else if (i2 == 2) {
            baseEmitter = new ErrorAsyncEmitter(subscriber);
        } else if (i2 == 3) {
            baseEmitter = new DropAsyncEmitter(subscriber);
        } else if (i2 != 4) {
            baseEmitter = new BufferAsyncEmitter(subscriber, Flowable.b());
        } else {
            baseEmitter = new LatestAsyncEmitter(subscriber);
        }
        subscriber.a(baseEmitter);
        try {
            this.f38422c.a(baseEmitter);
        } catch (Throwable th) {
            Exceptions.b(th);
            baseEmitter.d(th);
        }
    }
}
