package io.reactivex.internal.operators.flowable;

import com.facebook.common.time.Clock;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    final int f38474d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f38475e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f38476f;

    /* renamed from: g  reason: collision with root package name */
    final Action f38477g;

    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {

        /* renamed from: b  reason: collision with root package name */
        final Subscriber<? super T> f38478b;

        /* renamed from: c  reason: collision with root package name */
        final SimplePlainQueue<T> f38479c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f38480d;

        /* renamed from: e  reason: collision with root package name */
        final Action f38481e;

        /* renamed from: f  reason: collision with root package name */
        Subscription f38482f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f38483g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f38484h;

        /* renamed from: i  reason: collision with root package name */
        Throwable f38485i;

        /* renamed from: j  reason: collision with root package name */
        final AtomicLong f38486j = new AtomicLong();

        /* renamed from: k  reason: collision with root package name */
        boolean f38487k;

        BackpressureBufferSubscriber(Subscriber<? super T> subscriber, int i2, boolean z2, boolean z3, Action action) {
            SimplePlainQueue<T> simplePlainQueue;
            this.f38478b = subscriber;
            this.f38481e = action;
            this.f38480d = z3;
            if (z2) {
                simplePlainQueue = new SpscLinkedArrayQueue<>(i2);
            } else {
                simplePlainQueue = new SpscArrayQueue<>(i2);
            }
            this.f38479c = simplePlainQueue;
        }

        public void a(Subscription subscription) {
            if (SubscriptionHelper.g(this.f38482f, subscription)) {
                this.f38482f = subscription;
                this.f38478b.a(this);
                subscription.request(Clock.MAX_TIME);
            }
        }

        public int b(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.f38487k = true;
            return 2;
        }

        public void cancel() {
            if (!this.f38483g) {
                this.f38483g = true;
                this.f38482f.cancel();
                if (getAndIncrement() == 0) {
                    this.f38479c.clear();
                }
            }
        }

        public void clear() {
            this.f38479c.clear();
        }

        /* access modifiers changed from: package-private */
        public boolean d(boolean z2, boolean z3, Subscriber<? super T> subscriber) {
            if (this.f38483g) {
                this.f38479c.clear();
                return true;
            } else if (!z2) {
                return false;
            } else {
                if (!this.f38480d) {
                    Throwable th = this.f38485i;
                    if (th != null) {
                        this.f38479c.clear();
                        subscriber.onError(th);
                        return true;
                    } else if (!z3) {
                        return false;
                    } else {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z3) {
                    return false;
                } else {
                    Throwable th2 = this.f38485i;
                    if (th2 != null) {
                        subscriber.onError(th2);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            int i2;
            boolean z2;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<T> simplePlainQueue = this.f38479c;
                Subscriber<? super T> subscriber = this.f38478b;
                int i3 = 1;
                while (!d(this.f38484h, simplePlainQueue.isEmpty(), subscriber)) {
                    long j2 = this.f38486j.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z3 = this.f38484h;
                        T poll = simplePlainQueue.poll();
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
                            j3++;
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !d(this.f38484h, simplePlainQueue.isEmpty(), subscriber)) {
                        if (!(j3 == 0 || j2 == Clock.MAX_TIME)) {
                            this.f38486j.addAndGet(-j3);
                        }
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean isEmpty() {
            return this.f38479c.isEmpty();
        }

        public void onComplete() {
            this.f38484h = true;
            if (this.f38487k) {
                this.f38478b.onComplete();
            } else {
                e();
            }
        }

        public void onError(Throwable th) {
            this.f38485i = th;
            this.f38484h = true;
            if (this.f38487k) {
                this.f38478b.onError(th);
            } else {
                e();
            }
        }

        public void onNext(T t2) {
            if (!this.f38479c.offer(t2)) {
                this.f38482f.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.f38481e.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    missingBackpressureException.initCause(th);
                }
                onError(missingBackpressureException);
            } else if (this.f38487k) {
                this.f38478b.onNext(null);
            } else {
                e();
            }
        }

        public T poll() throws Exception {
            return this.f38479c.poll();
        }

        public void request(long j2) {
            if (!this.f38487k && SubscriptionHelper.f(j2)) {
                BackpressureHelper.a(this.f38486j, j2);
                e();
            }
        }
    }

    public FlowableOnBackpressureBuffer(Flowable<T> flowable, int i2, boolean z2, boolean z3, Action action) {
        super(flowable);
        this.f38474d = i2;
        this.f38475e = z2;
        this.f38476f = z3;
        this.f38477g = action;
    }

    /* access modifiers changed from: protected */
    public void o(Subscriber<? super T> subscriber) {
        this.f38421c.n(new BackpressureBufferSubscriber(subscriber, this.f38474d, this.f38475e, this.f38476f, this.f38477g));
    }
}
