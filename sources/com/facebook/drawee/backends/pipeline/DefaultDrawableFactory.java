package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class DefaultDrawableFactory implements DrawableFactory {
    private final DrawableFactory mAnimatedDrawableFactory;
    private final Resources mResources;

    public DefaultDrawableFactory(Resources resources, DrawableFactory drawableFactory) {
        this.mResources = resources;
        this.mAnimatedDrawableFactory = drawableFactory;
    }

    private static boolean hasTransformableExifOrientation(CloseableStaticBitmap closeableStaticBitmap) {
        if (closeableStaticBitmap.getExifOrientation() == 1 || closeableStaticBitmap.getExifOrientation() == 0) {
            return false;
        }
        return true;
    }

    private static boolean hasTransformableRotationAngle(CloseableStaticBitmap closeableStaticBitmap) {
        if (closeableStaticBitmap.getRotationAngle() == 0 || closeableStaticBitmap.getRotationAngle() == -1) {
            return false;
        }
        return true;
    }

    public Drawable createDrawable(CloseableImage closeableImage) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DefaultDrawableFactory#createDrawable");
            }
            if (closeableImage instanceof CloseableStaticBitmap) {
                CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mResources, closeableStaticBitmap.getUnderlyingBitmap());
                if (!hasTransformableRotationAngle(closeableStaticBitmap) && !hasTransformableExifOrientation(closeableStaticBitmap)) {
                    return bitmapDrawable;
                }
                OrientedDrawable orientedDrawable = new OrientedDrawable(bitmapDrawable, closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return orientedDrawable;
            }
            DrawableFactory drawableFactory = this.mAnimatedDrawableFactory;
            if (drawableFactory != null && drawableFactory.supportsImageType(closeableImage)) {
                Drawable createDrawable = this.mAnimatedDrawableFactory.createDrawable(closeableImage);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return createDrawable;
            } else if (!FrescoSystrace.isTracing()) {
                return null;
            } else {
                FrescoSystrace.endSection();
                return null;
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public boolean supportsImageType(CloseableImage closeableImage) {
        return true;
    }
}
