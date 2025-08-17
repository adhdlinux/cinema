package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class DiskCacheReadProducer implements Producer<EncodedImage> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "DiskCacheProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    /* access modifiers changed from: private */
    public final Producer<EncodedImage> mInputProducer;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    public DiskCacheReadProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    static Map<String, String> getExtraMap(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z2, int i2) {
        if (!producerListener2.requiresExtraMap(producerContext, PRODUCER_NAME)) {
            return null;
        }
        if (z2) {
            return ImmutableMap.of("cached_value_found", String.valueOf(z2), "encodedImageSize", String.valueOf(i2));
        }
        return ImmutableMap.of("cached_value_found", String.valueOf(z2));
    }

    /* access modifiers changed from: private */
    public static boolean isTaskCancelled(Task<?> task) {
        if (task.p() || (task.r() && (task.m() instanceof CancellationException))) {
            return true;
        }
        return false;
    }

    private void maybeStartInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            producerContext.putOriginExtra("disk", "nil-result_read");
            consumer.onNewResult(null, 1);
            return;
        }
        this.mInputProducer.produceResults(consumer, producerContext);
    }

    private Continuation<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> consumer, final ProducerContext producerContext) {
        final ProducerListener2 producerListener = producerContext.getProducerListener();
        return new Continuation<EncodedImage, Void>() {
            public Void then(Task<EncodedImage> task) throws Exception {
                if (DiskCacheReadProducer.isTaskCancelled(task)) {
                    producerListener.onProducerFinishWithCancellation(producerContext, DiskCacheReadProducer.PRODUCER_NAME, (Map<String, String>) null);
                    consumer.onCancellation();
                } else if (task.r()) {
                    producerListener.onProducerFinishWithFailure(producerContext, DiskCacheReadProducer.PRODUCER_NAME, task.m(), (Map<String, String>) null);
                    DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                } else {
                    EncodedImage n2 = task.n();
                    if (n2 != null) {
                        ProducerListener2 producerListener2 = producerListener;
                        ProducerContext producerContext = producerContext;
                        producerListener2.onProducerFinishWithSuccess(producerContext, DiskCacheReadProducer.PRODUCER_NAME, DiskCacheReadProducer.getExtraMap(producerListener2, producerContext, true, n2.getSize()));
                        producerListener.onUltimateProducerReached(producerContext, DiskCacheReadProducer.PRODUCER_NAME, true);
                        producerContext.putOriginExtra("disk");
                        consumer.onProgressUpdate(1.0f);
                        consumer.onNewResult(n2, 1);
                        n2.close();
                    } else {
                        ProducerListener2 producerListener22 = producerListener;
                        ProducerContext producerContext2 = producerContext;
                        producerListener22.onProducerFinishWithSuccess(producerContext2, DiskCacheReadProducer.PRODUCER_NAME, DiskCacheReadProducer.getExtraMap(producerListener22, producerContext2, false, 0));
                        DiskCacheReadProducer.this.mInputProducer.produceResults(consumer, producerContext);
                    }
                }
                return null;
            }
        };
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        boolean z2;
        BufferedDiskCache bufferedDiskCache;
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (!imageRequest.isDiskCacheEnabled()) {
            maybeStartInputProducer(consumer, producerContext);
            return;
        }
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, producerContext.getCallerContext());
        if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            bufferedDiskCache = this.mSmallImageBufferedDiskCache;
        } else {
            bufferedDiskCache = this.mDefaultBufferedDiskCache;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        bufferedDiskCache.get(encodedCacheKey, atomicBoolean).g(onFinishDiskReads(consumer, producerContext));
        subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
    }
}
