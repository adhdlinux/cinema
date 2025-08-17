package com.facebook.imagepipeline.animated.factory;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.ExecutorService;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class AnimatedFactoryProvider {
    private static AnimatedFactory sImpl;
    private static boolean sImplLoaded;

    public static AnimatedFactory getAnimatedFactory(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, boolean z2, ExecutorService executorService) {
        if (!sImplLoaded) {
            try {
                sImpl = (AnimatedFactory) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(new Class[]{PlatformBitmapFactory.class, ExecutorSupplier.class, CountingMemoryCache.class, Boolean.TYPE, SerialExecutorService.class}).newInstance(new Object[]{platformBitmapFactory, executorSupplier, countingMemoryCache, Boolean.valueOf(z2), executorService});
            } catch (Throwable unused) {
            }
            if (sImpl != null) {
                sImplLoaded = true;
            }
        }
        return sImpl;
    }
}
