package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@TargetApi(11)
public abstract class DefaultDecoder implements PlatformDecoder {
    private static final int DECODE_BUFFER_SIZE = 16384;
    private static final byte[] EOI_TAIL = {-1, -39};
    private static final Class<?> TAG = DefaultDecoder.class;
    private final BitmapPool mBitmapPool;
    final Pools$SynchronizedPool<ByteBuffer> mDecodeBuffers;
    private final PreverificationHelper mPreverificationHelper;

    public DefaultDecoder(BitmapPool bitmapPool, int i2, Pools$SynchronizedPool pools$SynchronizedPool) {
        PreverificationHelper preverificationHelper;
        if (Build.VERSION.SDK_INT >= 26) {
            preverificationHelper = new PreverificationHelper();
        } else {
            preverificationHelper = null;
        }
        this.mPreverificationHelper = preverificationHelper;
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = pools$SynchronizedPool;
        for (int i3 = 0; i3 < i2; i3++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        com.facebook.common.logging.FLog.e(TAG, "Could not decode region %s, decoding full bitmap instead.", r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0097, code lost:
        if (r0 != null) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r0.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009d, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009e, code lost:
        r7 = r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x008c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:78:0x00f6 */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a1 A[Catch:{ IllegalArgumentException -> 0x00d6, RuntimeException -> 0x00cd, all -> 0x00cb, IOException -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a8 A[Catch:{ IllegalArgumentException -> 0x00d6, RuntimeException -> 0x00cd, all -> 0x00cb, IOException -> 0x00f6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeFromStream(java.io.InputStream r10, android.graphics.BitmapFactory.Options r11, android.graphics.Rect r12, android.graphics.ColorSpace r13) {
        /*
            r9 = this;
            com.facebook.common.internal.Preconditions.checkNotNull(r10)
            int r0 = r11.outWidth
            int r1 = r11.outHeight
            if (r12 == 0) goto L_0x0017
            int r0 = r12.width()
            int r1 = r11.inSampleSize
            int r0 = r0 / r1
            int r1 = r12.height()
            int r2 = r11.inSampleSize
            int r1 = r1 / r2
        L_0x0017:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            r4 = 1
            r5 = 0
            if (r2 < r3) goto L_0x002d
            com.facebook.imagepipeline.platform.PreverificationHelper r6 = r9.mPreverificationHelper
            if (r6 == 0) goto L_0x002d
            android.graphics.Bitmap$Config r7 = r11.inPreferredConfig
            boolean r6 = r6.shouldUseHardwareBitmapConfig(r7)
            if (r6 == 0) goto L_0x002d
            r6 = 1
            goto L_0x002e
        L_0x002d:
            r6 = 0
        L_0x002e:
            r7 = 0
            if (r12 != 0) goto L_0x0037
            if (r6 == 0) goto L_0x0037
            r11.inMutable = r5
            r6 = r7
            goto L_0x004d
        L_0x0037:
            if (r12 == 0) goto L_0x003f
            if (r6 == 0) goto L_0x003f
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
            r11.inPreferredConfig = r6
        L_0x003f:
            int r6 = r9.getBitmapSize(r0, r1, r11)
            com.facebook.imagepipeline.memory.BitmapPool r8 = r9.mBitmapPool
            java.lang.Object r6 = r8.get(r6)
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            if (r6 == 0) goto L_0x00fd
        L_0x004d:
            r11.inBitmap = r6
            if (r2 < r3) goto L_0x005e
            if (r13 != 0) goto L_0x005b
            android.graphics.ColorSpace$Named r13 = android.graphics.ColorSpace.Named.SRGB
            android.graphics.ColorSpace r13 = android.graphics.ColorSpace.get(r13)
        L_0x005b:
            r11.inPreferredColorSpace = r13
        L_0x005e:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r13 = r9.mDecodeBuffers
            java.lang.Object r13 = r13.acquire()
            java.nio.ByteBuffer r13 = (java.nio.ByteBuffer) r13
            if (r13 != 0) goto L_0x006e
            r13 = 16384(0x4000, float:2.2959E-41)
            java.nio.ByteBuffer r13 = java.nio.ByteBuffer.allocate(r13)
        L_0x006e:
            byte[] r2 = r13.array()     // Catch:{ IllegalArgumentException -> 0x00d6, RuntimeException -> 0x00cd }
            r11.inTempStorage = r2     // Catch:{ IllegalArgumentException -> 0x00d6, RuntimeException -> 0x00cd }
            if (r12 == 0) goto L_0x00a5
            if (r6 == 0) goto L_0x00a5
            android.graphics.Bitmap$Config r2 = r11.inPreferredConfig     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            r6.reconfigure(r0, r1, r2)     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            android.graphics.BitmapRegionDecoder r0 = android.graphics.BitmapRegionDecoder.newInstance(r10, r4)     // Catch:{ IOException -> 0x008b, all -> 0x0089 }
            android.graphics.Bitmap r12 = r0.decodeRegion(r12, r11)     // Catch:{ IOException -> 0x008c }
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x00d6, RuntimeException -> 0x00cd }
            goto L_0x00a6
        L_0x0089:
            r11 = move-exception
            goto L_0x009f
        L_0x008b:
            r0 = r7
        L_0x008c:
            java.lang.Class<?> r1 = TAG     // Catch:{ all -> 0x009d }
            java.lang.String r2 = "Could not decode region %s, decoding full bitmap instead."
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x009d }
            r3[r5] = r12     // Catch:{ all -> 0x009d }
            com.facebook.common.logging.FLog.e((java.lang.Class<?>) r1, (java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x009d }
            if (r0 == 0) goto L_0x00a5
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x00d6, RuntimeException -> 0x00cd }
            goto L_0x00a5
        L_0x009d:
            r11 = move-exception
            r7 = r0
        L_0x009f:
            if (r7 == 0) goto L_0x00a4
            r7.recycle()     // Catch:{ IllegalArgumentException -> 0x00d6, RuntimeException -> 0x00cd }
        L_0x00a4:
            throw r11     // Catch:{ IllegalArgumentException -> 0x00d6, RuntimeException -> 0x00cd }
        L_0x00a5:
            r12 = r7
        L_0x00a6:
            if (r12 != 0) goto L_0x00ac
            android.graphics.Bitmap r12 = android.graphics.BitmapFactory.decodeStream(r10, r7, r11)     // Catch:{ IllegalArgumentException -> 0x00d6, RuntimeException -> 0x00cd }
        L_0x00ac:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r10 = r9.mDecodeBuffers
            r10.release(r13)
            if (r6 == 0) goto L_0x00c4
            if (r6 != r12) goto L_0x00b6
            goto L_0x00c4
        L_0x00b6:
            com.facebook.imagepipeline.memory.BitmapPool r10 = r9.mBitmapPool
            r10.release(r6)
            r12.recycle()
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r10.<init>()
            throw r10
        L_0x00c4:
            com.facebook.imagepipeline.memory.BitmapPool r10 = r9.mBitmapPool
            com.facebook.common.references.CloseableReference r10 = com.facebook.common.references.CloseableReference.of(r12, r10)
            return r10
        L_0x00cb:
            r10 = move-exception
            goto L_0x00f7
        L_0x00cd:
            r10 = move-exception
            if (r6 == 0) goto L_0x00d5
            com.facebook.imagepipeline.memory.BitmapPool r11 = r9.mBitmapPool     // Catch:{ all -> 0x00cb }
            r11.release(r6)     // Catch:{ all -> 0x00cb }
        L_0x00d5:
            throw r10     // Catch:{ all -> 0x00cb }
        L_0x00d6:
            r11 = move-exception
            if (r6 == 0) goto L_0x00de
            com.facebook.imagepipeline.memory.BitmapPool r12 = r9.mBitmapPool     // Catch:{ all -> 0x00cb }
            r12.release(r6)     // Catch:{ all -> 0x00cb }
        L_0x00de:
            r10.reset()     // Catch:{ IOException -> 0x00f6 }
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeStream(r10)     // Catch:{ IOException -> 0x00f6 }
            if (r10 == 0) goto L_0x00f5
            com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser r12 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance()     // Catch:{ IOException -> 0x00f6 }
            com.facebook.common.references.CloseableReference r10 = com.facebook.common.references.CloseableReference.of(r10, r12)     // Catch:{ IOException -> 0x00f6 }
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r11 = r9.mDecodeBuffers
            r11.release(r13)
            return r10
        L_0x00f5:
            throw r11     // Catch:{ IOException -> 0x00f6 }
        L_0x00f6:
            throw r11     // Catch:{ all -> 0x00cb }
        L_0x00f7:
            androidx.core.util.Pools$SynchronizedPool<java.nio.ByteBuffer> r11 = r9.mDecodeBuffers
            r11.release(r13)
            throw r10
        L_0x00fd:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException
            java.lang.String r11 = "BitmapPool.get returned null"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.DefaultDecoder.decodeFromStream(java.io.InputStream, android.graphics.BitmapFactory$Options, android.graphics.Rect, android.graphics.ColorSpace):com.facebook.common.references.CloseableReference");
    }

    private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.getInputStream(), (Rect) null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }

    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, (ColorSpace) null);
    }

    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        boolean z2;
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        if (decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888) {
            z2 = true;
        } else {
            z2 = false;
        }
        try {
            return decodeFromStream((InputStream) Preconditions.checkNotNull(encodedImage.getInputStream()), decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e2) {
            if (z2) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e2;
        }
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, Rect rect, int i2) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i2, (ColorSpace) null);
    }

    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, Rect rect, int i2, ColorSpace colorSpace) {
        boolean z2;
        boolean isCompleteAt = encodedImage.isCompleteAt(i2);
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        TailAppendingInputStream inputStream = encodedImage.getInputStream();
        Preconditions.checkNotNull(inputStream);
        if (encodedImage.getSize() > i2) {
            inputStream = new LimitedInputStream(inputStream, i2);
        }
        if (!isCompleteAt) {
            inputStream = new TailAppendingInputStream(inputStream, EOI_TAIL);
        }
        if (decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888) {
            z2 = true;
        } else {
            z2 = false;
        }
        try {
            CloseableReference<Bitmap> decodeFromStream = decodeFromStream(inputStream, decodeOptionsForStream, rect, colorSpace);
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return decodeFromStream;
        } catch (RuntimeException e3) {
            if (z2) {
                CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace = decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i2, colorSpace);
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return decodeJPEGFromEncodedImageWithColorSpace;
            }
            throw e3;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, Rect rect) {
        return decodeFromStream(inputStream, options, rect, (ColorSpace) null);
    }

    public abstract int getBitmapSize(int i2, int i3, BitmapFactory.Options options);
}
