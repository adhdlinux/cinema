package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ThrottlingProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "ThrottlingProducer";
    /* access modifiers changed from: private */
    public final Executor mExecutor;
    private final Producer<T> mInputProducer;
    private final int mMaxSimultaneousRequests;
    private int mNumCurrentRequests = 0;
    /* access modifiers changed from: private */
    public final ConcurrentLinkedQueue<Pair<Consumer<T>, ProducerContext>> mPendingRequests = new ConcurrentLinkedQueue<>();

    private class ThrottlerConsumer extends DelegatingConsumer<T, T> {
        private void onRequestFinished() {
            final Pair pair;
            synchronized (ThrottlingProducer.this) {
                pair = (Pair) ThrottlingProducer.this.mPendingRequests.poll();
                if (pair == null) {
                    ThrottlingProducer.access$210(ThrottlingProducer.this);
                }
            }
            if (pair != null) {
                ThrottlingProducer.this.mExecutor.execute(new Runnable() {
                    public void run() {
                        ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                        Pair pair = pair;
                        throttlingProducer.produceResultsInternal((Consumer) pair.first, (ProducerContext) pair.second);
                    }
                });
            }
        }

        /* access modifiers changed from: protected */
        public void onCancellationImpl() {
            getConsumer().onCancellation();
            onRequestFinished();
        }

        /* access modifiers changed from: protected */
        public void onFailureImpl(Throwable th) {
            getConsumer().onFailure(th);
            onRequestFinished();
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(T t2, int i2) {
            getConsumer().onNewResult(t2, i2);
            if (BaseConsumer.isLast(i2)) {
                onRequestFinished();
            }
        }

        private ThrottlerConsumer(Consumer<T> consumer) {
            super(consumer);
        }
    }

    public ThrottlingProducer(int i2, Executor executor, Producer<T> producer) {
        this.mMaxSimultaneousRequests = i2;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
    }

    static /* synthetic */ int access$210(ThrottlingProducer throttlingProducer) {
        int i2 = throttlingProducer.mNumCurrentRequests;
        throttlingProducer.mNumCurrentRequests = i2 - 1;
        return i2;
    }

    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z2;
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        synchronized (this) {
            int i2 = this.mNumCurrentRequests;
            z2 = true;
            if (i2 >= this.mMaxSimultaneousRequests) {
                this.mPendingRequests.add(Pair.create(consumer, producerContext));
            } else {
                this.mNumCurrentRequests = i2 + 1;
                z2 = false;
            }
        }
        if (!z2) {
            produceResultsInternal(consumer, producerContext);
        }
    }

    /* access modifiers changed from: package-private */
    public void produceResultsInternal(Consumer<T> consumer, ProducerContext producerContext) {
        producerContext.getProducerListener().onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, (Map<String, String>) null);
        this.mInputProducer.produceResults(new ThrottlerConsumer(consumer), producerContext);
    }
}
