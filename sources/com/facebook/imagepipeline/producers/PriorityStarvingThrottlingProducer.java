package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executor;

@Nullsafe(Nullsafe.Mode.STRICT)
public class PriorityStarvingThrottlingProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "PriorityStarvingThrottlingProducer";
    /* access modifiers changed from: private */
    public final Executor mExecutor;
    private final Producer<T> mInputProducer;
    private final int mMaxSimultaneousRequests;
    private int mNumCurrentRequests = 0;
    /* access modifiers changed from: private */
    public final Queue<Item<T>> mPendingRequests = new PriorityQueue(11, new PriorityComparator());

    static class Item<T> {
        final Consumer<T> consumer;
        final ProducerContext producerContext;
        final long time;

        Item(Consumer<T> consumer2, ProducerContext producerContext2, long j2) {
            this.consumer = consumer2;
            this.producerContext = producerContext2;
            this.time = j2;
        }
    }

    static class PriorityComparator<T> implements Comparator<Item<T>> {
        PriorityComparator() {
        }

        public int compare(Item<T> item, Item<T> item2) {
            Priority priority = item.producerContext.getPriority();
            Priority priority2 = item2.producerContext.getPriority();
            if (priority == priority2) {
                return Double.compare((double) item.time, (double) item2.time);
            }
            return priority.ordinal() > priority2.ordinal() ? -1 : 1;
        }
    }

    private class ThrottlerConsumer extends DelegatingConsumer<T, T> {
        private void onRequestFinished() {
            final Item item;
            synchronized (PriorityStarvingThrottlingProducer.this) {
                item = (Item) PriorityStarvingThrottlingProducer.this.mPendingRequests.poll();
                if (item == null) {
                    PriorityStarvingThrottlingProducer.access$210(PriorityStarvingThrottlingProducer.this);
                }
            }
            if (item != null) {
                PriorityStarvingThrottlingProducer.this.mExecutor.execute(new Runnable() {
                    public void run() {
                        PriorityStarvingThrottlingProducer.this.produceResultsInternal(item);
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

    public PriorityStarvingThrottlingProducer(int i2, Executor executor, Producer<T> producer) {
        this.mMaxSimultaneousRequests = i2;
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
    }

    static /* synthetic */ int access$210(PriorityStarvingThrottlingProducer priorityStarvingThrottlingProducer) {
        int i2 = priorityStarvingThrottlingProducer.mNumCurrentRequests;
        priorityStarvingThrottlingProducer.mNumCurrentRequests = i2 - 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public void produceResultsInternal(Item<T> item) {
        item.producerContext.getProducerListener().onProducerFinishWithSuccess(item.producerContext, PRODUCER_NAME, (Map<String, String>) null);
        this.mInputProducer.produceResults(new ThrottlerConsumer(item.consumer), item.producerContext);
    }

    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z2;
        long nanoTime = System.nanoTime();
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        synchronized (this) {
            int i2 = this.mNumCurrentRequests;
            z2 = true;
            if (i2 >= this.mMaxSimultaneousRequests) {
                this.mPendingRequests.add(new Item(consumer, producerContext, nanoTime));
            } else {
                this.mNumCurrentRequests = i2 + 1;
                z2 = false;
            }
        }
        if (!z2) {
            produceResultsInternal(new Item(consumer, producerContext, nanoTime));
        }
    }
}
