package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ThreadHandoffProducer<T> implements Producer<T> {
    public static final String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
    /* access modifiers changed from: private */
    public final Producer<T> mInputProducer;
    /* access modifiers changed from: private */
    public final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public ThreadHandoffProducer(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
    }

    private static String getInstrumentationTag(ProducerContext producerContext) {
        if (!FrescoInstrumenter.isTracing()) {
            return null;
        }
        return "ThreadHandoffProducer_produceResults_" + producerContext.getId();
    }

    public void produceResults(Consumer<T> consumer, ProducerContext producerContext) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ThreadHandoffProducer#produceResults");
            }
            final ProducerListener2 producerListener = producerContext.getProducerListener();
            final ProducerContext producerContext2 = producerContext;
            final Consumer<T> consumer2 = consumer;
            final AnonymousClass1 r02 = new StatefulProducerRunnable<T>(consumer, producerListener, producerContext, PRODUCER_NAME) {
                /* access modifiers changed from: protected */
                public void disposeResult(T t2) {
                }

                /* access modifiers changed from: protected */
                public T getResult() throws Exception {
                    return null;
                }

                /* access modifiers changed from: protected */
                public void onSuccess(T t2) {
                    producerListener.onProducerFinishWithSuccess(producerContext2, ThreadHandoffProducer.PRODUCER_NAME, (Map<String, String>) null);
                    ThreadHandoffProducer.this.mInputProducer.produceResults(consumer2, producerContext2);
                }
            };
            producerContext.addCallbacks(new BaseProducerContextCallbacks() {
                public void onCancellationRequested() {
                    r02.cancel();
                    ThreadHandoffProducer.this.mThreadHandoffProducerQueue.remove(r02);
                }
            });
            this.mThreadHandoffProducerQueue.addToQueueOrExecute(FrescoInstrumenter.decorateRunnable(r02, getInstrumentationTag(producerContext)));
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }
}
