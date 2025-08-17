package com.facebook.imagepipeline.transcoder;

import android.graphics.Matrix;
import com.facebook.common.internal.ImmutableList;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class JpegTranscoderUtils {
    public static final int DEFAULT_JPEG_QUALITY = 85;
    private static final int FULL_ROUND = 360;
    public static final ImmutableList<Integer> INVERTED_EXIF_ORIENTATIONS = ImmutableList.of(2, 7, 4, 5);
    public static final int MAX_QUALITY = 100;
    public static final int MAX_SCALE_NUMERATOR = 16;
    public static final int MIN_QUALITY = 0;
    public static final int MIN_SCALE_NUMERATOR = 1;
    public static final int SCALE_DENOMINATOR = 8;

    public static int calculateDownsampleNumerator(int i2) {
        return Math.max(1, 8 / i2);
    }

    public static float determineResizeRatio(ResizeOptions resizeOptions, int i2, int i3) {
        if (resizeOptions == null) {
            return 1.0f;
        }
        float f2 = (float) i2;
        float f3 = (float) i3;
        float max = Math.max(((float) resizeOptions.width) / f2, ((float) resizeOptions.height) / f3);
        float f4 = resizeOptions.maxBitmapSize;
        if (f2 * max > f4) {
            max = f4 / f2;
        }
        if (f3 * max > f4) {
            return f4 / f3;
        }
        return max;
    }

    private static int extractOrientationFromMetadata(EncodedImage encodedImage) {
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) {
            return encodedImage.getRotationAngle();
        }
        return 0;
    }

    public static int getForceRotatedInvertedExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        int i2;
        int exifOrientation = encodedImage.getExifOrientation();
        ImmutableList<Integer> immutableList = INVERTED_EXIF_ORIENTATIONS;
        int indexOf = immutableList.indexOf(Integer.valueOf(exifOrientation));
        if (indexOf >= 0) {
            if (!rotationOptions.useImageMetadata()) {
                i2 = rotationOptions.getForcedAngle();
            } else {
                i2 = 0;
            }
            return immutableList.get((indexOf + (i2 / 90)) % immutableList.size()).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    public static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (!rotationOptions.rotationEnabled()) {
            return 0;
        }
        int extractOrientationFromMetadata = extractOrientationFromMetadata(encodedImage);
        if (rotationOptions.useImageMetadata()) {
            return extractOrientationFromMetadata;
        }
        return (extractOrientationFromMetadata + rotationOptions.getForcedAngle()) % FULL_ROUND;
    }

    public static int getSoftwareNumerator(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage encodedImage, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (!z2 || resizeOptions == null) {
            return 8;
        }
        int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
        boolean z3 = false;
        if (INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()))) {
            i2 = getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage);
        } else {
            i2 = 0;
        }
        if (rotationAngle == 90 || rotationAngle == 270 || i2 == 5 || i2 == 7) {
            z3 = true;
        }
        if (z3) {
            i3 = encodedImage.getHeight();
        } else {
            i3 = encodedImage.getWidth();
        }
        if (z3) {
            i4 = encodedImage.getWidth();
        } else {
            i4 = encodedImage.getHeight();
        }
        int roundNumerator = roundNumerator(determineResizeRatio(resizeOptions, i3, i4), resizeOptions.roundUpFraction);
        if (roundNumerator > 8) {
            return 8;
        }
        if (roundNumerator < 1) {
            return 1;
        }
        return roundNumerator;
    }

    public static Matrix getTransformationMatrix(EncodedImage encodedImage, RotationOptions rotationOptions) {
        if (INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()))) {
            return getTransformationMatrixFromInvertedExif(getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage));
        }
        int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
        if (rotationAngle == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) rotationAngle);
        return matrix;
    }

    private static Matrix getTransformationMatrixFromInvertedExif(int i2) {
        Matrix matrix = new Matrix();
        if (i2 == 2) {
            matrix.setScale(-1.0f, 1.0f);
        } else if (i2 == 7) {
            matrix.setRotate(-90.0f);
            matrix.postScale(-1.0f, 1.0f);
        } else if (i2 == 4) {
            matrix.setRotate(180.0f);
            matrix.postScale(-1.0f, 1.0f);
        } else if (i2 != 5) {
            return null;
        } else {
            matrix.setRotate(90.0f);
            matrix.postScale(-1.0f, 1.0f);
        }
        return matrix;
    }

    public static boolean isExifOrientationAllowed(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static boolean isRotationAngleAllowed(int i2) {
        return i2 >= 0 && i2 <= 270 && i2 % 90 == 0;
    }

    public static int roundNumerator(float f2, float f3) {
        return (int) (f3 + (f2 * 8.0f));
    }
}
