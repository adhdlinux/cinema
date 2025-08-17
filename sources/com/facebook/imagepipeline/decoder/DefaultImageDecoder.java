package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.transformation.CircularTransformation;
import com.facebook.imagepipeline.transformation.TransformationUtils;
import com.facebook.infer.annotation.Nullsafe;
import java.io.InputStream;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class DefaultImageDecoder implements ImageDecoder {
    private final ImageDecoder mAnimatedGifDecoder;
    private final ImageDecoder mAnimatedWebPDecoder;
    private final Map<ImageFormat, ImageDecoder> mCustomDecoders;
    private final ImageDecoder mDefaultDecoder;
    private final PlatformDecoder mPlatformDecoder;

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder) {
        this(imageDecoder, imageDecoder2, platformDecoder, (Map<ImageFormat, ImageDecoder>) null);
    }

    public CloseableImage decode(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        InputStream inputStream;
        ImageDecoder imageDecoder2 = imageDecodeOptions.customImageDecoder;
        if (imageDecoder2 != null) {
            return imageDecoder2.decode(encodedImage, i2, qualityInfo, imageDecodeOptions);
        }
        ImageFormat imageFormat = encodedImage.getImageFormat();
        if ((imageFormat == null || imageFormat == ImageFormat.UNKNOWN) && (inputStream = encodedImage.getInputStream()) != null) {
            imageFormat = ImageFormatChecker.getImageFormat_WrapIOException(inputStream);
            encodedImage.setImageFormat(imageFormat);
        }
        Map<ImageFormat, ImageDecoder> map = this.mCustomDecoders;
        if (map == null || (imageDecoder = map.get(imageFormat)) == null) {
            return this.mDefaultDecoder.decode(encodedImage, i2, qualityInfo, imageDecodeOptions);
        }
        return imageDecoder.decode(encodedImage, i2, qualityInfo, imageDecodeOptions);
    }

    public CloseableImage decodeAnimatedWebp(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder = this.mAnimatedWebPDecoder;
        if (imageDecoder != null) {
            return imageDecoder.decode(encodedImage, i2, qualityInfo, imageDecodeOptions);
        }
        throw new DecodeException("Animated WebP support not set up!", encodedImage);
    }

    public CloseableImage decodeGif(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        ImageDecoder imageDecoder;
        if (encodedImage.getWidth() == -1 || encodedImage.getHeight() == -1) {
            throw new DecodeException("image width or height is incorrect", encodedImage);
        } else if (imageDecodeOptions.forceStaticImage || (imageDecoder = this.mAnimatedGifDecoder) == null) {
            return decodeStaticImage(encodedImage, imageDecodeOptions);
        } else {
            return imageDecoder.decode(encodedImage, i2, qualityInfo, imageDecodeOptions);
        }
    }

    public CloseableStaticBitmap decodeJpeg(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
        boolean z2;
        CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeJPEGFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, (Rect) null, i2, imageDecodeOptions.colorSpace);
        try {
            boolean maybeApplyTransformation = TransformationUtils.maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, decodeJPEGFromEncodedImageWithColorSpace);
            CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(decodeJPEGFromEncodedImageWithColorSpace, qualityInfo, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
            if (!maybeApplyTransformation || !(imageDecodeOptions.bitmapTransformation instanceof CircularTransformation)) {
                z2 = false;
            } else {
                z2 = true;
            }
            closeableStaticBitmap.setImageExtra("is_rounded", Boolean.valueOf(z2));
            return closeableStaticBitmap;
        } finally {
            decodeJPEGFromEncodedImageWithColorSpace.close();
        }
    }

    public CloseableStaticBitmap decodeStaticImage(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        boolean z2;
        CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace = this.mPlatformDecoder.decodeFromEncodedImageWithColorSpace(encodedImage, imageDecodeOptions.bitmapConfig, (Rect) null, imageDecodeOptions.colorSpace);
        try {
            boolean maybeApplyTransformation = TransformationUtils.maybeApplyTransformation(imageDecodeOptions.bitmapTransformation, decodeFromEncodedImageWithColorSpace);
            CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(decodeFromEncodedImageWithColorSpace, ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), encodedImage.getExifOrientation());
            if (!maybeApplyTransformation || !(imageDecodeOptions.bitmapTransformation instanceof CircularTransformation)) {
                z2 = false;
            } else {
                z2 = true;
            }
            closeableStaticBitmap.setImageExtra("is_rounded", Boolean.valueOf(z2));
            return closeableStaticBitmap;
        } finally {
            decodeFromEncodedImageWithColorSpace.close();
        }
    }

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, PlatformDecoder platformDecoder, Map<ImageFormat, ImageDecoder> map) {
        this.mDefaultDecoder = new ImageDecoder() {
            public CloseableImage decode(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                ImageFormat imageFormat = encodedImage.getImageFormat();
                if (imageFormat == DefaultImageFormats.JPEG) {
                    return DefaultImageDecoder.this.decodeJpeg(encodedImage, i2, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == DefaultImageFormats.GIF) {
                    return DefaultImageDecoder.this.decodeGif(encodedImage, i2, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat == DefaultImageFormats.WEBP_ANIMATED) {
                    return DefaultImageDecoder.this.decodeAnimatedWebp(encodedImage, i2, qualityInfo, imageDecodeOptions);
                }
                if (imageFormat != ImageFormat.UNKNOWN) {
                    return DefaultImageDecoder.this.decodeStaticImage(encodedImage, imageDecodeOptions);
                }
                throw new DecodeException("unknown image format", encodedImage);
            }
        };
        this.mAnimatedGifDecoder = imageDecoder;
        this.mAnimatedWebPDecoder = imageDecoder2;
        this.mPlatformDecoder = platformDecoder;
        this.mCustomDecoders = map;
    }
}
