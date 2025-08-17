package com.facebook.imagepipeline.producers;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class RemoveImageTransformMetaDataProducer implements Producer<CloseableReference<PooledByteBuffer>> {
    private final Producer<EncodedImage> mInputProducer;

    private class RemoveImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, CloseableReference<PooledByteBuffer>> {
        private RemoveImageTransformMetaDataConsumer(Consumer<CloseableReference<PooledByteBuffer>> consumer) {
            super(consumer);
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
            CloseableReference<PooledByteBuffer> closeableReference = null;
            try {
                if (EncodedImage.isValid(encodedImage)) {
                    closeableReference = encodedImage.getByteBufferRef();
                }
                getConsumer().onNewResult(closeableReference, i2);
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
            }
        }
    }

    public RemoveImageTransformMetaDataProducer(Producer<EncodedImage> producer) {
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<CloseableReference<PooledByteBuffer>> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new RemoveImageTransformMetaDataConsumer(consumer), producerContext);
    }
}
