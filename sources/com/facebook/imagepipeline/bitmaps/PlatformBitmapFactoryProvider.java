package com.facebook.imagepipeline.bitmaps;

import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class PlatformBitmapFactoryProvider {
    public static PlatformBitmapFactory buildPlatformBitmapFactory(PoolFactory poolFactory, PlatformDecoder platformDecoder, CloseableReferenceFactory closeableReferenceFactory) {
        return new ArtBitmapFactory(poolFactory.getBitmapPool(), closeableReferenceFactory);
    }
}
