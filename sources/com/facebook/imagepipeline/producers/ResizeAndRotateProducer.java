package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.facebook.infer.annotation.Nullsafe;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ResizeAndRotateProducer implements Producer<EncodedImage> {
    private static final String INPUT_IMAGE_FORMAT = "Image format";
    static final int MIN_TRANSFORM_INTERVAL_MS = 100;
    private static final String ORIGINAL_SIZE_KEY = "Original size";
    private static final String PRODUCER_NAME = "ResizeAndRotateProducer";
    private static final String REQUESTED_SIZE_KEY = "Requested size";
    private static final String TRANSCODER_ID = "Transcoder id";
    private static final String TRANSCODING_RESULT = "Transcoding result";
    /* access modifiers changed from: private */
    public final Executor mExecutor;
    private final ImageTranscoderFactory mImageTranscoderFactory;
    private final Producer<EncodedImage> mInputProducer;
    private final boolean mIsResizingEnabled;
    /* access modifiers changed from: private */
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    private class TransformingConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        /* access modifiers changed from: private */
        public final ImageTranscoderFactory mImageTranscoderFactory;
        /* access modifiers changed from: private */
        public boolean mIsCancelled = false;
        /* access modifiers changed from: private */
        public final boolean mIsResizingEnabled;
        /* access modifiers changed from: private */
        public final JobScheduler mJobScheduler;
        /* access modifiers changed from: private */
        public final ProducerContext mProducerContext;

        TransformingConsumer(final Consumer<EncodedImage> consumer, ProducerContext producerContext, boolean z2, ImageTranscoderFactory imageTranscoderFactory) {
            super(consumer);
            this.mProducerContext = producerContext;
            Boolean resizingAllowedOverride = producerContext.getImageRequest().getResizingAllowedOverride();
            this.mIsResizingEnabled = resizingAllowedOverride != null ? resizingAllowedOverride.booleanValue() : z2;
            this.mImageTranscoderFactory = imageTranscoderFactory;
            this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, new JobScheduler.JobRunnable(ResizeAndRotateProducer.this) {
                public void run(EncodedImage encodedImage, int i2) {
                    TransformingConsumer transformingConsumer = TransformingConsumer.this;
                    transformingConsumer.doTransform(encodedImage, i2, (ImageTranscoder) Preconditions.checkNotNull(transformingConsumer.mImageTranscoderFactory.createImageTranscoder(encodedImage.getImageFormat(), TransformingConsumer.this.mIsResizingEnabled)));
                }
            }, 100);
            producerContext.addCallbacks(new BaseProducerContextCallbacks(ResizeAndRotateProducer.this) {
                public void onCancellationRequested() {
                    TransformingConsumer.this.mJobScheduler.clearJob();
                    boolean unused = TransformingConsumer.this.mIsCancelled = true;
                    consumer.onCancellation();
                }

                public void onIsIntermediateResultExpectedChanged() {
                    if (TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
                        TransformingConsumer.this.mJobScheduler.scheduleJob();
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        public void doTransform(EncodedImage encodedImage, int i2, ImageTranscoder imageTranscoder) {
            EncodedImage encodedImage2;
            this.mProducerContext.getProducerListener().onProducerStart(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME);
            ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            PooledByteBufferOutputStream newOutputStream = ResizeAndRotateProducer.this.mPooledByteBufferFactory.newOutputStream();
            Map<String, String> map = null;
            try {
                ImageTranscodeResult transcode = imageTranscoder.transcode(encodedImage, newOutputStream, imageRequest.getRotationOptions(), imageRequest.getResizeOptions(), (ImageFormat) null, 85);
                if (transcode.getTranscodeStatus() != 2) {
                    map = getExtraMap(encodedImage, imageRequest.getResizeOptions(), transcode, imageTranscoder.getIdentifier());
                    CloseableReference of = CloseableReference.of(newOutputStream.toByteBuffer());
                    try {
                        encodedImage2 = new EncodedImage((CloseableReference<PooledByteBuffer>) of);
                        encodedImage2.setImageFormat(DefaultImageFormats.JPEG);
                        encodedImage2.parseMetaData();
                        this.mProducerContext.getProducerListener().onProducerFinishWithSuccess(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME, map);
                        if (transcode.getTranscodeStatus() != 1) {
                            i2 |= 16;
                        }
                        getConsumer().onNewResult(encodedImage2, i2);
                        EncodedImage.closeSafely(encodedImage2);
                        CloseableReference.closeSafely((CloseableReference<?>) of);
                        newOutputStream.close();
                    } catch (Throwable th) {
                        CloseableReference.closeSafely((CloseableReference<?>) of);
                        throw th;
                    }
                } else {
                    throw new RuntimeException("Error while transcoding the image");
                }
            } catch (Exception e2) {
                try {
                    this.mProducerContext.getProducerListener().onProducerFinishWithFailure(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME, e2, map);
                    if (BaseConsumer.isLast(i2)) {
                        getConsumer().onFailure(e2);
                    }
                } finally {
                    newOutputStream.close();
                }
            }
        }

        private void forwardNewResult(EncodedImage encodedImage, int i2, ImageFormat imageFormat) {
            EncodedImage encodedImage2;
            if (imageFormat == DefaultImageFormats.JPEG || imageFormat == DefaultImageFormats.HEIF) {
                encodedImage2 = getNewResultsForJpegOrHeif(encodedImage);
            } else {
                encodedImage2 = getNewResultForImagesWithoutExifData(encodedImage);
            }
            getConsumer().onNewResult(encodedImage2, i2);
        }

        private EncodedImage getCloneWithRotationApplied(EncodedImage encodedImage, int i2) {
            EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            if (cloneOrNull != null) {
                cloneOrNull.setRotationAngle(i2);
            }
            return cloneOrNull;
        }

        private Map<String, String> getExtraMap(EncodedImage encodedImage, ResizeOptions resizeOptions, ImageTranscodeResult imageTranscodeResult, String str) {
            String str2;
            if (!this.mProducerContext.getProducerListener().requiresExtraMap(this.mProducerContext, ResizeAndRotateProducer.PRODUCER_NAME)) {
                return null;
            }
            String str3 = encodedImage.getWidth() + "x" + encodedImage.getHeight();
            if (resizeOptions != null) {
                str2 = resizeOptions.width + "x" + resizeOptions.height;
            } else {
                str2 = "Unspecified";
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ResizeAndRotateProducer.INPUT_IMAGE_FORMAT, String.valueOf(encodedImage.getImageFormat()));
            hashMap.put(ResizeAndRotateProducer.ORIGINAL_SIZE_KEY, str3);
            hashMap.put(ResizeAndRotateProducer.REQUESTED_SIZE_KEY, str2);
            hashMap.put("queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
            hashMap.put(ResizeAndRotateProducer.TRANSCODER_ID, str);
            hashMap.put(ResizeAndRotateProducer.TRANSCODING_RESULT, String.valueOf(imageTranscodeResult));
            return ImmutableMap.copyOf(hashMap);
        }

        private EncodedImage getNewResultForImagesWithoutExifData(EncodedImage encodedImage) {
            RotationOptions rotationOptions = this.mProducerContext.getImageRequest().getRotationOptions();
            if (rotationOptions.useImageMetadata() || !rotationOptions.rotationEnabled()) {
                return encodedImage;
            }
            return getCloneWithRotationApplied(encodedImage, rotationOptions.getForcedAngle());
        }

        private EncodedImage getNewResultsForJpegOrHeif(EncodedImage encodedImage) {
            if (this.mProducerContext.getImageRequest().getRotationOptions().canDeferUntilRendered() || encodedImage.getRotationAngle() == 0 || encodedImage.getRotationAngle() == -1) {
                return encodedImage;
            }
            return getCloneWithRotationApplied(encodedImage, 0);
        }

        /* access modifiers changed from: protected */
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
            if (!this.mIsCancelled) {
                boolean isLast = BaseConsumer.isLast(i2);
                if (encodedImage != null) {
                    ImageFormat imageFormat = encodedImage.getImageFormat();
                    TriState access$700 = ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), encodedImage, (ImageTranscoder) Preconditions.checkNotNull(this.mImageTranscoderFactory.createImageTranscoder(imageFormat, this.mIsResizingEnabled)));
                    if (!isLast && access$700 == TriState.UNSET) {
                        return;
                    }
                    if (access$700 != TriState.YES) {
                        forwardNewResult(encodedImage, i2, imageFormat);
                    } else if (this.mJobScheduler.updateJob(encodedImage, i2)) {
                        if (isLast || this.mProducerContext.isIntermediateResultExpected()) {
                            this.mJobScheduler.scheduleJob();
                        }
                    }
                } else if (isLast) {
                    getConsumer().onNewResult(null, 1);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ResizeAndRotateProducer(java.util.concurrent.Executor r1, com.facebook.common.memory.PooledByteBufferFactory r2, com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> r3, boolean r4, com.facebook.imagepipeline.transcoder.ImageTranscoderFactory r5) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r1)
            java.util.concurrent.Executor r1 = (java.util.concurrent.Executor) r1
            r0.mExecutor = r1
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r2)
            com.facebook.common.memory.PooledByteBufferFactory r1 = (com.facebook.common.memory.PooledByteBufferFactory) r1
            r0.mPooledByteBufferFactory = r1
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r3)
            com.facebook.imagepipeline.producers.Producer r1 = (com.facebook.imagepipeline.producers.Producer) r1
            r0.mInputProducer = r1
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r5)
            com.facebook.imagepipeline.transcoder.ImageTranscoderFactory r1 = (com.facebook.imagepipeline.transcoder.ImageTranscoderFactory) r1
            r0.mImageTranscoderFactory = r1
            r0.mIsResizingEnabled = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.ResizeAndRotateProducer.<init>(java.util.concurrent.Executor, com.facebook.common.memory.PooledByteBufferFactory, com.facebook.imagepipeline.producers.Producer, boolean, com.facebook.imagepipeline.transcoder.ImageTranscoderFactory):void");
    }

    private static boolean shouldRotate(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (rotationOptions.canDeferUntilRendered() || (JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage) == 0 && !shouldRotateUsingExifOrientation(rotationOptions, encodedImage))) {
            return false;
        }
        return true;
    }

    private static boolean shouldRotateUsingExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (rotationOptions.rotationEnabled() && !rotationOptions.canDeferUntilRendered()) {
            return JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()));
        }
        encodedImage.setExifOrientation(0);
        return false;
    }

    /* access modifiers changed from: private */
    public static TriState shouldTransform(ImageRequest imageRequest, EncodedImage encodedImage, ImageTranscoder imageTranscoder) {
        boolean z2;
        if (encodedImage == null || encodedImage.getImageFormat() == ImageFormat.UNKNOWN) {
            return TriState.UNSET;
        }
        if (!imageTranscoder.canTranscode(encodedImage.getImageFormat())) {
            return TriState.NO;
        }
        if (shouldRotate(imageRequest.getRotationOptions(), encodedImage) || imageTranscoder.canResize(encodedImage, imageRequest.getRotationOptions(), imageRequest.getResizeOptions())) {
            z2 = true;
        } else {
            z2 = false;
        }
        return TriState.valueOf(z2);
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new TransformingConsumer(consumer, producerContext, this.mIsResizingEnabled, this.mImageTranscoderFactory), producerContext);
    }
}
