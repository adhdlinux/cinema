package com.squareup.sqlbrite;

import com.facebook.common.time.Clock;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

final class BackpressureBufferLastOperator<T> implements Observable.Operator<T, T> {
    static final Observable.Operator<Object, Object> instance = new BackpressureBufferLastOperator();

    static final class BufferLastSubscriber<T> extends Subscriber<T> {
        /* access modifiers changed from: private */
        public static final Object NONE = new Object();
        /* access modifiers changed from: private */
        public final Subscriber<? super T> child;
        /* access modifiers changed from: private */
        public volatile Object last = NONE;
        final Producer producer = new Producer() {
            public void request(long j2) {
                Object access$000;
                int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                if (i2 < 0) {
                    throw new IllegalArgumentException("requested " + j2 + " < 0");
                } else if (i2 != 0) {
                    synchronized (BufferLastSubscriber.this) {
                        access$000 = BufferLastSubscriber.this.last;
                        long access$100 = BufferLastSubscriber.this.requested;
                        if (Clock.MAX_TIME - j2 <= access$100) {
                            long unused = BufferLastSubscriber.this.requested = Clock.MAX_TIME;
                        } else {
                            if (access$000 != BufferLastSubscriber.NONE) {
                                j2--;
                            }
                            long unused2 = BufferLastSubscriber.this.requested = access$100 + j2;
                        }
                    }
                    if (access$000 != BufferLastSubscriber.NONE) {
                        BufferLastSubscriber.this.child.onNext(access$000);
                    }
                }
            }
        };
        /* access modifiers changed from: private */
        public volatile long requested;

        public BufferLastSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        public void onCompleted() {
            this.child.onCompleted();
        }

        public void onError(Throwable th) {
            this.child.onError(th);
        }

        public void onNext(T t2) {
            boolean z2;
            synchronized (this) {
                long j2 = this.requested;
                z2 = true;
                if (j2 != Clock.MAX_TIME) {
                    if (j2 > 0) {
                        this.requested = j2 - 1;
                    } else {
                        this.last = t2;
                        z2 = false;
                    }
                }
            }
            if (z2) {
                this.child.onNext(t2);
            }
        }

        public void onStart() {
            request(Clock.MAX_TIME);
        }
    }

    private BackpressureBufferLastOperator() {
    }

    static <T> Observable.Operator<T, T> instance() {
        return instance;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        BufferLastSubscriber bufferLastSubscriber = new BufferLastSubscriber(subscriber);
        subscriber.add(bufferLastSubscriber);
        subscriber.setProducer(bufferLastSubscriber.producer);
        return bufferLastSubscriber;
    }
}
