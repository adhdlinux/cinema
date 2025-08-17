package com.facebook.imagepipeline.transcoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class DownsampleUtil {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    private static final float INTERVAL_ROUNDING = 0.33333334f;

    private DownsampleUtil() {
    }

    public static float determineDownsampleRatio(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage encodedImage) {
        boolean z2;
        int i2;
        int i3;
        Preconditions.checkArgument(Boolean.valueOf(EncodedImage.isMetaDataAvailable(encodedImage)));
        if (resizeOptions == null || resizeOptions.height <= 0 || resizeOptions.width <= 0 || encodedImage.getWidth() == 0 || encodedImage.getHeight() == 0) {
            return 1.0f;
        }
        int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
        if (rotationAngle == 90 || rotationAngle == 270) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i2 = encodedImage.getHeight();
        } else {
            i2 = encodedImage.getWidth();
        }
        if (z2) {
            i3 = encodedImage.getWidth();
        } else {
            i3 = encodedImage.getHeight();
        }
        float f2 = ((float) resizeOptions.width) / ((float) i2);
        float f3 = ((float) resizeOptions.height) / ((float) i3);
        float max = Math.max(f2, f3);
        FLog.v("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f", Integer.valueOf(resizeOptions.width), Integer.valueOf(resizeOptions.height), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(max));
        return max;
    }

    public static int determineSampleSize(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage encodedImage, int i2) {
        int i3;
        float f2;
        int i4;
        if (!EncodedImage.isMetaDataAvailable(encodedImage)) {
            return 1;
        }
        float determineDownsampleRatio = determineDownsampleRatio(rotationOptions, resizeOptions, encodedImage);
        if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
            i3 = ratioToSampleSizeJPEG(determineDownsampleRatio);
        } else {
            i3 = ratioToSampleSize(determineDownsampleRatio);
        }
        int max = Math.max(encodedImage.getHeight(), encodedImage.getWidth());
        if (resizeOptions != null) {
            f2 = resizeOptions.maxBitmapSize;
        } else {
            f2 = (float) i2;
        }
        while (((float) (max / i3)) > f2) {
            if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
                i4 = i3 * 2;
            } else {
                i4 = i3 + 1;
            }
        }
        return i3;
    }

    public static int determineSampleSizeJPEG(EncodedImage encodedImage, int i2, int i3) {
        int sampleSize = encodedImage.getSampleSize();
        while ((((encodedImage.getWidth() * encodedImage.getHeight()) * i2) / sampleSize) / sampleSize > i3) {
            sampleSize *= 2;
        }
        return sampleSize;
    }

    private static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        boolean z2 = false;
        if (!rotationOptions.useImageMetadata()) {
            return 0;
        }
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 0 || rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) {
            z2 = true;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        return rotationAngle;
    }

    public static int ratioToSampleSize(float f2) {
        if (f2 > 0.6666667f) {
            return 1;
        }
        int i2 = 2;
        while (true) {
            double d2 = (double) i2;
            if ((1.0d / d2) + ((1.0d / (Math.pow(d2, 2.0d) - d2)) * 0.3333333432674408d) <= ((double) f2)) {
                return i2 - 1;
            }
            i2++;
        }
    }

    public static int ratioToSampleSizeJPEG(float f2) {
        if (f2 > 0.6666667f) {
            return 1;
        }
        int i2 = 2;
        while (true) {
            int i3 = i2 * 2;
            double d2 = 1.0d / ((double) i3);
            if (d2 + (0.3333333432674408d * d2) <= ((double) f2)) {
                return i2;
            }
            i2 = i3;
        }
    }

    public static int roundToPowerOfTwo(int i2) {
        int i3 = 1;
        while (i3 < i2) {
            i3 *= 2;
        }
        return i3;
    }
}
