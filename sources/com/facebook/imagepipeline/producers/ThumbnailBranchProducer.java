package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ThumbnailBranchProducer implements Producer<EncodedImage> {
    private final ThumbnailProducer<EncodedImage>[] mThumbnailProducers;

    private class ThumbnailConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final ProducerContext mProducerContext;
        private final int mProducerIndex;
        private final ResizeOptions mResizeOptions;

        public ThumbnailConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext, int i2) {
            super(consumer);
            this.mProducerContext = producerContext;
            this.mProducerIndex = i2;
            this.mResizeOptions = producerContext.getImageRequest().getResizeOptions();
        }

        /* access modifiers changed from: protected */
        public void onFailureImpl(Throwable th) {
            if (!ThumbnailBranchProducer.this.produceResultsFromThumbnailProducer(this.mProducerIndex + 1, getConsumer(), this.mProducerContext)) {
                getConsumer().onFailure(th);
            }
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
            if (encodedImage != null && (BaseConsumer.isNotLast(i2) || ThumbnailSizeChecker.isImageBigEnough(encodedImage, this.mResizeOptions))) {
                getConsumer().onNewResult(encodedImage, i2);
            } else if (BaseConsumer.isLast(i2)) {
                EncodedImage.closeSafely(encodedImage);
                if (!ThumbnailBranchProducer.this.produceResultsFromThumbnailProducer(this.mProducerIndex + 1, getConsumer(), this.mProducerContext)) {
                    getConsumer().onNewResult(null, 1);
                }
            }
        }
    }

    public ThumbnailBranchProducer(ThumbnailProducer<EncodedImage>... thumbnailProducerArr) {
        ThumbnailProducer<EncodedImage>[] thumbnailProducerArr2 = (ThumbnailProducer[]) Preconditions.checkNotNull(thumbnailProducerArr);
        this.mThumbnailProducers = thumbnailProducerArr2;
        Preconditions.checkElementIndex(0, thumbnailProducerArr2.length);
    }

    private int findFirstProducerForSize(int i2, ResizeOptions resizeOptions) {
        while (true) {
            ThumbnailProducer<EncodedImage>[] thumbnailProducerArr = this.mThumbnailProducers;
            if (i2 >= thumbnailProducerArr.length) {
                return -1;
            }
            if (thumbnailProducerArr[i2].canProvideImageForSize(resizeOptions)) {
                return i2;
            }
            i2++;
        }
    }

    /* access modifiers changed from: private */
    public boolean produceResultsFromThumbnailProducer(int i2, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        int findFirstProducerForSize = findFirstProducerForSize(i2, producerContext.getImageRequest().getResizeOptions());
        if (findFirstProducerForSize == -1) {
            return false;
        }
        this.mThumbnailProducers[findFirstProducerForSize].produceResults(new ThumbnailConsumer(consumer, producerContext, findFirstProducerForSize), producerContext);
        return true;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (producerContext.getImageRequest().getResizeOptions() == null) {
            consumer.onNewResult(null, 1);
        } else if (!produceResultsFromThumbnailProducer(0, consumer, producerContext)) {
            consumer.onNewResult(null, 1);
        }
    }
}
