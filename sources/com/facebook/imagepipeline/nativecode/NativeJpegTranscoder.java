package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.transcoder.DownsampleUtil;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Nullsafe(Nullsafe.Mode.STRICT)
@DoNotStrip
public class NativeJpegTranscoder implements ImageTranscoder {
    public static final String TAG = "NativeJpegTranscoder";
    private int mMaxBitmapSize;
    private boolean mResizingEnabled;
    private boolean mUseDownsamplingRatio;

    public NativeJpegTranscoder(boolean z2, int i2, boolean z3, boolean z4) {
        this.mResizingEnabled = z2;
        this.mMaxBitmapSize = i2;
        this.mUseDownsamplingRatio = z3;
        if (z4) {
            NativeJpegTranscoderSoLoader.ensure();
        }
    }

    @DoNotStrip
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException;

    @DoNotStrip
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException;

    public static void transcodeJpeg(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        NativeJpegTranscoderSoLoader.ensure();
        boolean z6 = false;
        if (i3 >= 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        if (i3 <= 16) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z3));
        if (i4 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z4));
        if (i4 <= 100) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z5));
        Preconditions.checkArgument(Boolean.valueOf(JpegTranscoderUtils.isRotationAngleAllowed(i2)));
        if (!(i3 == 8 && i2 == 0)) {
            z6 = true;
        }
        Preconditions.checkArgument(z6, "no transformation requested");
        nativeTranscodeJpeg((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i2, i3, i4);
    }

    public static void transcodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        NativeJpegTranscoderSoLoader.ensure();
        boolean z6 = false;
        if (i3 >= 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        if (i3 <= 16) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z3));
        if (i4 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z4));
        if (i4 <= 100) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z5));
        Preconditions.checkArgument(Boolean.valueOf(JpegTranscoderUtils.isExifOrientationAllowed(i2)));
        if (!(i3 == 8 && i2 == 1)) {
            z6 = true;
        }
        Preconditions.checkArgument(z6, "no transformation requested");
        nativeTranscodeJpegWithExifOrientation((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i2, i3, i4);
    }

    public boolean canResize(EncodedImage encodedImage, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.autoRotate();
        }
        if (JpegTranscoderUtils.getSoftwareNumerator(rotationOptions, resizeOptions, encodedImage, this.mResizingEnabled) < 8) {
            return true;
        }
        return false;
    }

    public boolean canTranscode(ImageFormat imageFormat) {
        return imageFormat == DefaultImageFormats.JPEG;
    }

    public String getIdentifier() {
        return TAG;
    }

    /* JADX INFO: finally extract failed */
    public ImageTranscodeResult transcode(EncodedImage encodedImage, OutputStream outputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ImageFormat imageFormat, Integer num) throws IOException {
        if (num == null) {
            num = 85;
        }
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.autoRotate();
        }
        int determineSampleSize = DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.mMaxBitmapSize);
        InputStream inputStream = null;
        try {
            int softwareNumerator = JpegTranscoderUtils.getSoftwareNumerator(rotationOptions, resizeOptions, encodedImage, this.mResizingEnabled);
            int calculateDownsampleNumerator = JpegTranscoderUtils.calculateDownsampleNumerator(determineSampleSize);
            if (this.mUseDownsamplingRatio) {
                softwareNumerator = calculateDownsampleNumerator;
            }
            inputStream = encodedImage.getInputStream();
            if (JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()))) {
                transcodeJpegWithExifOrientation((InputStream) Preconditions.checkNotNull(inputStream, "Cannot transcode from null input stream!"), outputStream, JpegTranscoderUtils.getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage), softwareNumerator, num.intValue());
            } else {
                transcodeJpeg((InputStream) Preconditions.checkNotNull(inputStream, "Cannot transcode from null input stream!"), outputStream, JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage), softwareNumerator, num.intValue());
            }
            Closeables.closeQuietly(inputStream);
            int i2 = 1;
            if (determineSampleSize != 1) {
                i2 = 0;
            }
            return new ImageTranscodeResult(i2);
        } catch (Throwable th) {
            Closeables.closeQuietly(inputStream);
            throw th;
        }
    }
}
