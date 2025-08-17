package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class HoneycombBitmapCreator implements BitmapCreator {
    private final FlexByteArrayPool mFlexByteArrayPool;
    private final EmptyJpegGenerator mJpegGenerator;

    public HoneycombBitmapCreator(PoolFactory poolFactory) {
        this.mFlexByteArrayPool = poolFactory.getFlexByteArrayPool();
        this.mJpegGenerator = new EmptyJpegGenerator(poolFactory.getPooledByteBufferFactory());
    }

    private static BitmapFactory.Options getBitmapFactoryOptions(int i2, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i2;
        options.inMutable = true;
        return options;
    }

    @TargetApi(12)
    public Bitmap createNakedBitmap(int i2, int i3, Bitmap.Config config) {
        EncodedImage encodedImage;
        CloseableReference<PooledByteBuffer> generate = this.mJpegGenerator.generate((short) i2, (short) i3);
        CloseableReference<byte[]> closeableReference = null;
        try {
            encodedImage = new EncodedImage(generate);
            try {
                encodedImage.setImageFormat(DefaultImageFormats.JPEG);
                BitmapFactory.Options bitmapFactoryOptions = getBitmapFactoryOptions(encodedImage.getSampleSize(), config);
                int size = generate.get().size();
                closeableReference = this.mFlexByteArrayPool.get(size + 2);
                byte[] bArr = closeableReference.get();
                generate.get().read(0, bArr, 0, size);
                Bitmap bitmap = (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(bArr, 0, size, bitmapFactoryOptions));
                bitmap.setHasAlpha(true);
                bitmap.eraseColor(0);
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely((CloseableReference<?>) generate);
                return bitmap;
            } catch (Throwable th) {
                th = th;
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely((CloseableReference<?>) generate);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            encodedImage = null;
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
            EncodedImage.closeSafely(encodedImage);
            CloseableReference.closeSafely((CloseableReference<?>) generate);
            throw th;
        }
    }
}
