package com.facebook.imagepipeline.transcoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;
import java.io.OutputStream;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class SimpleImageTranscoder implements ImageTranscoder {
    private static final String TAG = "SimpleImageTranscoder";
    private final int mMaxBitmapSize;
    private final boolean mResizingEnabled;

    public SimpleImageTranscoder(boolean z2, int i2) {
        this.mResizingEnabled = z2;
        this.mMaxBitmapSize = i2;
    }

    private static Bitmap.CompressFormat getOutputFormat(ImageFormat imageFormat) {
        if (imageFormat == null) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (imageFormat == DefaultImageFormats.JPEG) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (imageFormat == DefaultImageFormats.PNG) {
            return Bitmap.CompressFormat.PNG;
        }
        if (DefaultImageFormats.isStaticWebpFormat(imageFormat)) {
            return Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    private int getSampleSize(EncodedImage encodedImage, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        if (!this.mResizingEnabled) {
            return 1;
        }
        return DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.mMaxBitmapSize);
    }

    public boolean canResize(EncodedImage encodedImage, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.autoRotate();
        }
        if (!this.mResizingEnabled || DownsampleUtil.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.mMaxBitmapSize) <= 1) {
            return false;
        }
        return true;
    }

    public boolean canTranscode(ImageFormat imageFormat) {
        return imageFormat == DefaultImageFormats.HEIF || imageFormat == DefaultImageFormats.JPEG;
    }

    public String getIdentifier() {
        return TAG;
    }

    public ImageTranscodeResult transcode(EncodedImage encodedImage, OutputStream outputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ImageFormat imageFormat, Integer num) {
        Integer num2;
        SimpleImageTranscoder simpleImageTranscoder;
        RotationOptions rotationOptions2;
        Bitmap bitmap;
        EncodedImage encodedImage2 = encodedImage;
        if (num == null) {
            num2 = 85;
        } else {
            num2 = num;
        }
        if (rotationOptions == null) {
            rotationOptions2 = RotationOptions.autoRotate();
            simpleImageTranscoder = this;
        } else {
            simpleImageTranscoder = this;
            rotationOptions2 = rotationOptions;
        }
        int sampleSize = simpleImageTranscoder.getSampleSize(encodedImage2, rotationOptions2, resizeOptions);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = sampleSize;
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(encodedImage.getInputStream(), (Rect) null, options);
            if (decodeStream == null) {
                FLog.e(TAG, "Couldn't decode the EncodedImage InputStream ! ");
                return new ImageTranscodeResult(2);
            }
            Matrix transformationMatrix = JpegTranscoderUtils.getTransformationMatrix(encodedImage2, rotationOptions2);
            if (transformationMatrix != null) {
                try {
                    bitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), transformationMatrix, false);
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    bitmap = decodeStream;
                    try {
                        FLog.e(TAG, "Out-Of-Memory during transcode", (Throwable) e);
                        ImageTranscodeResult imageTranscodeResult = new ImageTranscodeResult(2);
                        bitmap.recycle();
                        decodeStream.recycle();
                        return imageTranscodeResult;
                    } catch (Throwable th) {
                        th = th;
                        bitmap.recycle();
                        decodeStream.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bitmap = decodeStream;
                    bitmap.recycle();
                    decodeStream.recycle();
                    throw th;
                }
            } else {
                bitmap = decodeStream;
            }
            try {
                bitmap.compress(getOutputFormat(imageFormat), num2.intValue(), outputStream);
                int i2 = 1;
                if (sampleSize > 1) {
                    i2 = 0;
                }
                ImageTranscodeResult imageTranscodeResult2 = new ImageTranscodeResult(i2);
                bitmap.recycle();
                decodeStream.recycle();
                return imageTranscodeResult2;
            } catch (OutOfMemoryError e3) {
                e = e3;
                FLog.e(TAG, "Out-Of-Memory during transcode", (Throwable) e);
                ImageTranscodeResult imageTranscodeResult3 = new ImageTranscodeResult(2);
                bitmap.recycle();
                decodeStream.recycle();
                return imageTranscodeResult3;
            }
        } catch (OutOfMemoryError e4) {
            FLog.e(TAG, "Out-Of-Memory during transcode", (Throwable) e4);
            return new ImageTranscodeResult(2);
        }
    }
}
