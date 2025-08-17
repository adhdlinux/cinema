package com.facebook.imagepipeline.animated.factory;

import android.content.Context;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public interface AnimatedFactory {
    DrawableFactory getAnimatedDrawableFactory(Context context);

    ImageDecoder getGifDecoder();

    ImageDecoder getWebPDecoder();
}
