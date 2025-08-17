package io.reactivex.internal.operators.flowable;

import com.facebook.common.time.Clock;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final Scheduler f38455d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f38456e;

    /* renamed from: f  reason: collision with root package name */
    final int f38457f;

    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Scheduler.Worker f38458b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f38459c;

        /* renamed from: d  reason: collision with root package name */
        final int f38460d;

        /* renamed from: e  reason: collision with root package name */
        final int f38461e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f38462f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        Subscription f38463g;

        /* renamed from: h  reason: collision with root package name */
        SimpleQueue<T> f38464h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f38465i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f38466j;

        /* renamed from: k  reason: collision with root package name */
        Throwable f38467k;

        /* renamed from: l  reason: collision with root package name */
        int f38468l;

        /* renamed from: m  reason: collision with root package name */
        long f38469m;

        /* renamed from: n  reason: collision with root package name */
        boolean f38470n;

        BaseObserveOnSubscriber(Scheduler.Worker worker, boolean z2, int i2) {
            this.f38458b = worker;
            this.f38459c = z2;
            this.f38460d = i2;
            this.f38461e = i2 - (i2 >> 2);
        }

        public final int b(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.f38470n = true;
            return 2;
        }

        public final void cancel() {
            if (!this.f38465i) {
                this.f38465i = true;
                this.f38463g.cancel();
                this.f38458b.dispose();
                if (getAndIncrement() == 0) {
                    this.f38464h.clear();
                }
            }
        }

        public final void clear() {
            this.f38464h.clear();
        }

        /* access modifiers changed from: package-private */
        public final boolean d(boolean z2, boolean z3, Subscriber<?> subscriber) {
            if (this.f38465i) {
                clear();
                return true;
            } else if (!z2) {
                return false;
            } else {
                if (!this.f38459c) {
                    Throwable th = this.f38467k;
                    if (th != null) {
                        this.f38465i = true;
                        clear();
                        subscriber.onError(th);
                        this.f38458b.dispose();
                        return true;
                    } else if (!z3) {
                        return false;
                    } else {
                        this.f38465i = true;
                        subscriber.onComplete();
                        this.f38458b.dispose();
                        return true;
                    }
                } else if (!z3) {
                    return false;
                } else {
                    this.f38465i = true;
                    Throwable th2 = this.f38467k;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onComplete();
                    }
                    this.f38458b.dispose();
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void e();

        /* access modifiers changed from: package-private */
        public abstract void f();

        /* access modifiers changed from: package-private */
        public abstract void g();

        /* access modifiers changed from: package-private */
        public final void h() {
            if (getAndIncrement() == 0) {
                this.f38458b.b(this);
            }
        }

        public final boolean isEmpty() {
            return this.f38464h.isEmpty();
        }

        public final void onComplete() {
            if (!this.f38466j) {
                this.f38466j = true;
                h();
            }
        }

        public final void onError(Throwable th) {
            if (this.f38466j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f38467k = th;
            this.f38466j = true;
            h();
        }

        public final void onNext(T t2) {
            if (!this.f38466j) {
                if (this.f38468l == 2) {
                    h();
                    return;
                }
                if (!this.f38464h.offer(t2)) {
                    this.f38463g.cancel();
                    this.f38467k = new MissingBackpressureException("Queue is full?!");
                    this.f38466j = true;
                }
                h();
            }
        }

        public final void request(long j2) {
            if (SubscriptionHelper.f(j2)) {
                BackpressureHelper.a(this.f38462f, j2);
                h();
            }
        }

        public final void run() {
            if (this.f38470n) {
                f();
            } else if (this.f38468l == 1) {
                g();
            } else {
                e();
            }
        }
    }

    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {

        /* renamed from: o  reason: collision with root package name */
        final ConditionalSubscriber<? super T> f38471o;

        /* renamed from: p  reason: collision with root package name */
        long f38472p;

        ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Scheduler.Worker worker, boolean z2, int i2) {
            super(worker, z2, i2);
            this.f38471o = conditionalSubscriber;
        }

        public void a(Subscription subscription) {
            if (SubscriptionHelper.g(this.f38463g, subscription)) {
                this.f38463g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int b2 = queueSubscription.b(7);
                    if (b2 == 1) {
                        this.f38468l = 1;
                        this.f38464h = queueSubscription;
                        this.f38466j = true;
                        this.f38471o.a(this);
                        return;
                    } else if (b2 == 2) {
                        this.f38468l = 2;
                        this.f38464h = queueSubscription;
                        this.f38471o.a(this);
                        subscription.request((long) this.f38460d);
                        return;
                    }
                }
                this.f38464h = new SpscArrayQueue(this.f38460d);
                this.f38471o.a(this);
                subscription.request((long) this.f38460d);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            int i2;
            boolean z2;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f38471o;
            SimpleQueue<T> simpleQueue = this.f38464h;
            long j2 = this.f38469m;
            long j3 = this.f38472p;
            int i3 = 1;
            while (true) {
                long j4 = this.f38462f.get();
                while (true) {
                    i2 = (j2 > j4 ? 1 : (j2 == j4 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z3 = this.f38466j;
                    try {
                        T poll = simpleQueue.poll();
                        if (poll == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!d(z3, z2, conditionalSubscriber)) {
                            if (z2) {
                                break;
                            }
                            if (conditionalSubscriber.c(poll)) {
                                j2++;
                            }
                            j3++;
                            if (j3 == ((long) this.f38461e)) {
                                this.f38463g.request(j3);
                                j3 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f38465i = true;
                        this.f38463g.cancel();
                        simpleQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.f38458b.dispose();
                        return;
                    }
                }
                if (i2 != 0 || !d(this.f38466j, simpleQueue.isEmpty(), conditionalSubscriber)) {
                    int i4 = get();
                    if (i3 == i4) {
                        this.f38469m = j2;
                        this.f38472p = j3;
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else {
                        i3 = i4;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            int i2 = 1;
            while (!this.f38465i) {
                boolean z2 = this.f38466j;
                this.f38471o.onNext(null);
                if (z2) {
                    this.f38465i = true;
                    Throwable th = this.f38467k;
                    if (th != null) {
                        this.f38471o.onError(th);
                    } else {
                        this.f38471o.onComplete();
                    }
                    this.f38458b.dispose();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            ConditionalSubscriber<? super T> conditionalSubscriber = this.f38471o;
            SimpleQueue<T> simpleQueue = this.f38464h;
            long j2 = this.f38469m;
            int i2 = 1;
            while (true) {
                long j3 = this.f38462f.get();
                while (j2 != j3) {
                    try {
                        T poll = simpleQueue.poll();
                        if (!this.f38465i) {
                            if (poll == null) {
                                this.f38465i = true;
                                conditionalSubscriber.onComplete();
                                this.f38458b.dispose();
                                return;
                            } else if (conditionalSubscriber.c(poll)) {
                                j2++;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f38465i = true;
                        this.f38463g.cancel();
                        conditionalSubscriber.onError(th);
                        this.f38458b.dispose();
                        return;
                    }
                }
                if (!this.f38465i) {
                    if (simpleQueue.isEmpty()) {
                        this.f38465i = true;
                        conditionalSubscriber.onComplete();
                        this.f38458b.dispose();
                        return;
                    }
                    int i3 = get();
                    if (i2 == i3) {
                        this.f38469m = j2;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        i2 = i3;
                    }
                } else {
                    return;
                }
            }
        }

        public T poll() throws Exception {
            T poll = this.f38464h.poll();
            if (!(poll == null || this.f38468l == 1)) {
                long j2 = this.f38472p + 1;
                if (j2 == ((long) this.f38461e)) {
                    this.f38472p = 0;
                    this.f38463g.request(j2);
                } else {
                    this.f38472p = j2;
                }
            }
            return poll;
        }
    }

    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> {

        /* renamed from: o  reason: collision with root package name */
        final Subscriber<? super T> f38473o;

        ObserveOnSubscriber(Subscriber<? super T> subscriber, Scheduler.Worker worker, boolean z2, int i2) {
            super(worker, z2, i2);
            this.f38473o = subscriber;
        }

        public void a(Subscription subscription) {
            if (SubscriptionHelper.g(this.f38463g, subscription)) {
                this.f38463g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int b2 = queueSubscription.b(7);
                    if (b2 == 1) {
                        this.f38468l = 1;
                        this.f38464h = queueSubscription;
                        this.f38466j = true;
                        this.f38473o.a(this);
                        return;
                    } else if (b2 == 2) {
                        this.f38468l = 2;
                        this.f38464h = queueSubscription;
                        this.f38473o.a(this);
                        subscription.request((long) this.f38460d);
                        return;
                    }
                }
                this.f38464h = new SpscArrayQueue(this.f38460d);
                this.f38473o.a(this);
                subscription.request((long) this.f38460d);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            int i2;
            boolean z2;
            Subscriber<? super T> subscriber = this.f38473o;
            SimpleQueue<T> simpleQueue = this.f38464h;
            long j2 = this.f38469m;
            int i3 = 1;
            while (true) {
                long j3 = this.f38462f.get();
                while (true) {
                    i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z3 = this.f38466j;
                    try {
                        T poll = simpleQueue.poll();
                        if (poll == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!d(z3, z2, subscriber)) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j2++;
                            if (j2 == ((long) this.f38461e)) {
                                if (j3 != Clock.MAX_TIME) {
                                    j3 = this.f38462f.addAndGet(-j2);
                                }
                                this.f38463g.request(j2);
                                j2 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f38465i = true;
                        this.f38463g.cancel();
                        simpleQueue.clear();
                        subscriber.onError(th);
                        this.f38458b.dispose();
                        return;
                    }
                }
                if (i2 != 0 || !d(this.f38466j, simpleQueue.isEmpty(), subscriber)) {
                    int i4 = get();
                    if (i3 == i4) {
                        this.f38469m = j2;
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else {
                        i3 = i4;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            int i2 = 1;
            while (!this.f38465i) {
                boolean z2 = this.f38466j;
                this.f38473o.onNext(null);
                if (z2) {
                    this.f38465i = true;
                    Throwable th = this.f38467k;
                    if (th != null) {
                        this.f38473o.onError(th);
                    } else {
                        this.f38473o.onComplete();
                    }
                    this.f38458b.dispose();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            Subscriber<? super T> subscriber = this.f38473o;
            SimpleQueue<T> simpleQueue = this.f38464h;
            long j2 = this.f38469m;
            int i2 = 1;
            while (true) {
                long j3 = this.f38462f.get();
                while (j2 != j3) {
                    try {
                        T poll = simpleQueue.poll();
                        if (!this.f38465i) {
                            if (poll == null) {
                                this.f38465i = true;
                                subscriber.onComplete();
                                this.f38458b.dispose();
                                return;
                            }
                            subscriber.onNext(poll);
                            j2++;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f38465i = true;
                        this.f38463g.cancel();
                        subscriber.onError(th);
                        this.f38458b.dispose();
                        return;
                    }
                }
                if (!this.f38465i) {
                    if (simpleQueue.isEmpty()) {
                        this.f38465i = true;
                        subscriber.onComplete();
                        this.f38458b.dispose();
                        return;
                    }
                    int i3 = get();
                    if (i2 == i3) {
                        this.f38469m = j2;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        i2 = i3;
                    }
                } else {
                    return;
                }
            }
        }

        public T poll() throws Exception {
            T poll = this.f38464h.poll();
            if (!(poll == null || this.f38468l == 1)) {
                long j2 = this.f38469m + 1;
                if (j2 == ((long) this.f38461e)) {
                    this.f38469m = 0;
                    this.f38463g.request(j2);
                } else {
                    this.f38469m = j2;
                }
            }
            return poll;
        }
    }

    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean z2, int i2) {
        super(flowable);
        this.f38455d = scheduler;
        this.f38456e = z2;
        this.f38457f = i2;
    }

    public void o(Subscriber<? super T> subscriber) {
        Scheduler.Worker a2 = this.f38455d.a();
        if (subscriber instanceof ConditionalSubscriber) {
            this.f38421c.n(new ObserveOnConditionalSubscriber((ConditionalSubscriber) subscriber, a2, this.f38456e, this.f38457f));
        } else {
            this.f38421c.n(new ObserveOnSubscriber(subscriber, a2, this.f38456e, this.f38457f));
        }
    }
}
