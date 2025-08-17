package com.facebook.imagepipeline.nativecode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounter;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.DoNotOptimize;
import java.util.Locale;

@Nullsafe(Nullsafe.Mode.STRICT)
@DoNotStrip
public abstract class DalvikPurgeableDecoder implements PlatformDecoder {
    protected static final byte[] EOI = {-1, -39};
    private final BitmapCounter mUnpooledBitmapsCounter = BitmapCounterProvider.get();

    @DoNotOptimize
    private static class OreoUtils {
        private OreoUtils() {
        }

        @TargetApi(26)
        static void setColorSpace(BitmapFactory.Options options, ColorSpace colorSpace) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
    }

    static {
        ImagePipelineNativeLoader.load();
    }

    protected DalvikPurgeableDecoder() {
    }

    public static boolean endsWithEOI(CloseableReference<PooledByteBuffer> closeableReference, int i2) {
        PooledByteBuffer pooledByteBuffer = closeableReference.get();
        if (i2 >= 2 && pooledByteBuffer.read(i2 - 2) == -1 && pooledByteBuffer.read(i2 - 1) == -39) {
            return true;
        }
        return false;
    }

    public static BitmapFactory.Options getBitmapFactoryOptions(int i2, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i2;
        options.inMutable = true;
        return options;
    }

    @DoNotStrip
    private static native void nativePinBitmap(Bitmap bitmap);

    /* access modifiers changed from: protected */
    public abstract Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options);

    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, (ColorSpace) null);
    }

    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        BitmapFactory.Options bitmapFactoryOptions = getBitmapFactoryOptions(encodedImage.getSampleSize(), config);
        if (Build.VERSION.SDK_INT >= 26) {
            OreoUtils.setColorSpace(bitmapFactoryOptions, colorSpace);
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        Preconditions.checkNotNull(byteBufferRef);
        try {
            return pinBitmap(decodeByteArrayAsPurgeable(byteBufferRef, bitmapFactoryOptions));
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) byteBufferRef);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i2, BitmapFactory.Options options);

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, Rect rect, int i2) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i2, (ColorSpace) null);
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, Rect rect, int i2, ColorSpace colorSpace) {
        BitmapFactory.Options bitmapFactoryOptions = getBitmapFactoryOptions(encodedImage.getSampleSize(), config);
        if (Build.VERSION.SDK_INT >= 26) {
            OreoUtils.setColorSpace(bitmapFactoryOptions, colorSpace);
        }
        CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
        Preconditions.checkNotNull(byteBufferRef);
        try {
            return pinBitmap(decodeJPEGByteArrayAsPurgeable(byteBufferRef, i2, bitmapFactoryOptions));
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) byteBufferRef);
        }
    }

    public CloseableReference<Bitmap> pinBitmap(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        try {
            nativePinBitmap(bitmap);
            if (this.mUnpooledBitmapsCounter.increase(bitmap)) {
                return CloseableReference.of(bitmap, this.mUnpooledBitmapsCounter.getReleaser());
            }
            int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
            bitmap.recycle();
            throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", new Object[]{Integer.valueOf(sizeInBytes), Integer.valueOf(this.mUnpooledBitmapsCounter.getCount()), Long.valueOf(this.mUnpooledBitmapsCounter.getSize()), Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxCount()), Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxSize())}));
        } catch (Exception e2) {
            bitmap.recycle();
            throw Throwables.propagate(e2);
        }
    }
}
