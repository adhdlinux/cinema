package com.facebook.imagepipeline.producers;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class SwallowResultProducer<T> implements Producer<Void> {
    private final Producer<T> mInputProducer;

    public SwallowResultProducer(Producer<T> producer) {
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<Void> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new DelegatingConsumer<T, Void>(consumer) {
            /* access modifiers changed from: protected */
            public void onNewResultImpl(T t2, int i2) {
                if (BaseConsumer.isLast(i2)) {
                    getConsumer().onNewResult(null, i2);
                }
            }
        }, producerContext);
    }
}
