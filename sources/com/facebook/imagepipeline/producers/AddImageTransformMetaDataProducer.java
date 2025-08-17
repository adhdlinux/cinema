package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class AddImageTransformMetaDataProducer implements Producer<EncodedImage> {
    private final Producer<EncodedImage> mInputProducer;

    private static class AddImageTransformMetaDataConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private AddImageTransformMetaDataConsumer(Consumer<EncodedImage> consumer) {
            super(consumer);
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
            if (encodedImage == null) {
                getConsumer().onNewResult(null, i2);
                return;
            }
            if (!EncodedImage.isMetaDataAvailable(encodedImage)) {
                encodedImage.parseMetaData();
            }
            getConsumer().onNewResult(encodedImage, i2);
        }
    }

    public AddImageTransformMetaDataProducer(Producer<EncodedImage> producer) {
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new AddImageTransformMetaDataConsumer(consumer), producerContext);
    }
}
