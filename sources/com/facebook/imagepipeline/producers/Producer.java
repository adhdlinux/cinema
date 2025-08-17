package com.facebook.imagepipeline.producers;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface Producer<T> {
    void produceResults(Consumer<T> consumer, ProducerContext producerContext);
}
