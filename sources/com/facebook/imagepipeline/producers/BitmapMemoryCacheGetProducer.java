package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class BitmapMemoryCacheGetProducer extends BitmapMemoryCacheProducer {
    private static final String ORIGIN_SUBCATEGORY = "pipe_ui";
    public static final String PRODUCER_NAME = "BitmapMemoryCacheGetProducer";

    public BitmapMemoryCacheGetProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        super(memoryCache, cacheKeyFactory, producer);
    }

    /* access modifiers changed from: protected */
    public String getOriginSubcategory() {
        return ORIGIN_SUBCATEGORY;
    }

    /* access modifiers changed from: protected */
    public String getProducerName() {
        return PRODUCER_NAME;
    }

    /* access modifiers changed from: protected */
    public Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z2) {
        return consumer;
    }
}
