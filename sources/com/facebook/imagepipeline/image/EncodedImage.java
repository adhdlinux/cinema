package com.facebook.imagepipeline.image;

import android.graphics.ColorSpace;
import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imageutils.HeifExifUtil;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.WebpUtil;
import com.facebook.infer.annotation.FalseOnNull;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;

public class EncodedImage implements Closeable {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    public static final int UNKNOWN_HEIGHT = -1;
    public static final int UNKNOWN_ROTATION_ANGLE = -1;
    public static final int UNKNOWN_STREAM_SIZE = -1;
    public static final int UNKNOWN_WIDTH = -1;
    private static boolean sUseCachedMetadata;
    private BytesRange mBytesRange;
    private ColorSpace mColorSpace;
    private int mExifOrientation;
    private boolean mHasParsedMetadata;
    private int mHeight;
    private ImageFormat mImageFormat;
    private final Supplier<FileInputStream> mInputStreamSupplier;
    private final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;
    private int mRotationAngle;
    private int mSampleSize;
    private int mStreamSize;
    private int mWidth;

    public EncodedImage(CloseableReference<PooledByteBuffer> closeableReference) {
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        Preconditions.checkArgument(Boolean.valueOf(CloseableReference.isValid(closeableReference)));
        this.mPooledByteBufferRef = closeableReference.clone();
        this.mInputStreamSupplier = null;
    }

    public static EncodedImage cloneOrNull(EncodedImage encodedImage) {
        if (encodedImage != null) {
            return encodedImage.cloneOrNull();
        }
        return null;
    }

    public static void closeSafely(EncodedImage encodedImage) {
        if (encodedImage != null) {
            encodedImage.close();
        }
    }

    private void internalParseMetaData() {
        Pair<Integer, Integer> pair;
        ImageFormat imageFormat_WrapIOException = ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
        this.mImageFormat = imageFormat_WrapIOException;
        if (DefaultImageFormats.isWebpFormat(imageFormat_WrapIOException)) {
            pair = readWebPImageSize();
        } else {
            pair = readImageMetaData().getDimensions();
        }
        if (imageFormat_WrapIOException == DefaultImageFormats.JPEG && this.mRotationAngle == -1) {
            if (pair != null) {
                int orientation = JfifUtil.getOrientation(getInputStream());
                this.mExifOrientation = orientation;
                this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(orientation);
            }
        } else if (imageFormat_WrapIOException == DefaultImageFormats.HEIF && this.mRotationAngle == -1) {
            int orientation2 = HeifExifUtil.getOrientation(getInputStream());
            this.mExifOrientation = orientation2;
            this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(orientation2);
        } else if (this.mRotationAngle == -1) {
            this.mRotationAngle = 0;
        }
    }

    public static boolean isMetaDataAvailable(EncodedImage encodedImage) {
        return encodedImage.mRotationAngle >= 0 && encodedImage.mWidth >= 0 && encodedImage.mHeight >= 0;
    }

    private void parseMetadataIfNeeded() {
        if (this.mWidth < 0 || this.mHeight < 0) {
            parseMetaData();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034 A[SYNTHETIC, Splitter:B:15:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.imageutils.ImageMetaData readImageMetaData() {
        /*
            r4 = this;
            java.io.InputStream r0 = r4.getInputStream()     // Catch:{ all -> 0x0030 }
            com.facebook.imageutils.ImageMetaData r1 = com.facebook.imageutils.BitmapUtil.decodeDimensionsAndColorSpace(r0)     // Catch:{ all -> 0x002e }
            android.graphics.ColorSpace r2 = r1.getColorSpace()     // Catch:{ all -> 0x002e }
            r4.mColorSpace = r2     // Catch:{ all -> 0x002e }
            android.util.Pair r2 = r1.getDimensions()     // Catch:{ all -> 0x002e }
            if (r2 == 0) goto L_0x0028
            java.lang.Object r3 = r2.first     // Catch:{ all -> 0x002e }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x002e }
            int r3 = r3.intValue()     // Catch:{ all -> 0x002e }
            r4.mWidth = r3     // Catch:{ all -> 0x002e }
            java.lang.Object r2 = r2.second     // Catch:{ all -> 0x002e }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x002e }
            int r2 = r2.intValue()     // Catch:{ all -> 0x002e }
            r4.mHeight = r2     // Catch:{ all -> 0x002e }
        L_0x0028:
            if (r0 == 0) goto L_0x002d
            r0.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            return r1
        L_0x002e:
            r1 = move-exception
            goto L_0x0032
        L_0x0030:
            r1 = move-exception
            r0 = 0
        L_0x0032:
            if (r0 == 0) goto L_0x0037
            r0.close()     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.image.EncodedImage.readImageMetaData():com.facebook.imageutils.ImageMetaData");
    }

    private Pair<Integer, Integer> readWebPImageSize() {
        Pair<Integer, Integer> size = WebpUtil.getSize(getInputStream());
        if (size != null) {
            this.mWidth = ((Integer) size.first).intValue();
            this.mHeight = ((Integer) size.second).intValue();
        }
        return size;
    }

    public static void setUseCachedMetadata(boolean z2) {
        sUseCachedMetadata = z2;
    }

    public void close() {
        CloseableReference.closeSafely((CloseableReference<?>) this.mPooledByteBufferRef);
    }

    public void copyMetaDataFrom(EncodedImage encodedImage) {
        this.mImageFormat = encodedImage.getImageFormat();
        this.mWidth = encodedImage.getWidth();
        this.mHeight = encodedImage.getHeight();
        this.mRotationAngle = encodedImage.getRotationAngle();
        this.mExifOrientation = encodedImage.getExifOrientation();
        this.mSampleSize = encodedImage.getSampleSize();
        this.mStreamSize = encodedImage.getSize();
        this.mBytesRange = encodedImage.getBytesRange();
        this.mColorSpace = encodedImage.getColorSpace();
        this.mHasParsedMetadata = encodedImage.hasParsedMetaData();
    }

    public CloseableReference<PooledByteBuffer> getByteBufferRef() {
        return CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    }

    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public ColorSpace getColorSpace() {
        parseMetadataIfNeeded();
        return this.mColorSpace;
    }

    public int getExifOrientation() {
        parseMetadataIfNeeded();
        return this.mExifOrientation;
    }

    public String getFirstBytesAsHexString(int i2) {
        CloseableReference<PooledByteBuffer> byteBufferRef = getByteBufferRef();
        if (byteBufferRef == null) {
            return "";
        }
        int min = Math.min(getSize(), i2);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.read(0, bArr, 0, min);
            byteBufferRef.close();
            StringBuilder sb = new StringBuilder(min * 2);
            for (int i3 = 0; i3 < min; i3++) {
                sb.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i3])}));
            }
            return sb.toString();
        } finally {
            byteBufferRef.close();
        }
    }

    public int getHeight() {
        parseMetadataIfNeeded();
        return this.mHeight;
    }

    public ImageFormat getImageFormat() {
        parseMetadataIfNeeded();
        return this.mImageFormat;
    }

    public InputStream getInputStream() {
        Supplier<FileInputStream> supplier = this.mInputStreamSupplier;
        if (supplier != null) {
            return supplier.get();
        }
        CloseableReference<PooledByteBuffer> cloneOrNull = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
        if (cloneOrNull == null) {
            return null;
        }
        try {
            return new PooledByteBufferInputStream(cloneOrNull.get());
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) cloneOrNull);
        }
    }

    public InputStream getInputStreamOrThrow() {
        return (InputStream) Preconditions.checkNotNull(getInputStream());
    }

    public int getRotationAngle() {
        parseMetadataIfNeeded();
        return this.mRotationAngle;
    }

    public int getSampleSize() {
        return this.mSampleSize;
    }

    public int getSize() {
        CloseableReference<PooledByteBuffer> closeableReference = this.mPooledByteBufferRef;
        if (closeableReference == null || closeableReference.get() == null) {
            return this.mStreamSize;
        }
        return this.mPooledByteBufferRef.get().size();
    }

    public synchronized SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly() {
        SharedReference<PooledByteBuffer> sharedReference;
        CloseableReference<PooledByteBuffer> closeableReference = this.mPooledByteBufferRef;
        if (closeableReference != null) {
            sharedReference = closeableReference.getUnderlyingReferenceTestOnly();
        } else {
            sharedReference = null;
        }
        return sharedReference;
    }

    public int getWidth() {
        parseMetadataIfNeeded();
        return this.mWidth;
    }

    /* access modifiers changed from: protected */
    public boolean hasParsedMetaData() {
        return this.mHasParsedMetadata;
    }

    public boolean isCompleteAt(int i2) {
        ImageFormat imageFormat = this.mImageFormat;
        if ((imageFormat != DefaultImageFormats.JPEG && imageFormat != DefaultImageFormats.DNG) || this.mInputStreamSupplier != null) {
            return true;
        }
        Preconditions.checkNotNull(this.mPooledByteBufferRef);
        PooledByteBuffer pooledByteBuffer = this.mPooledByteBufferRef.get();
        if (pooledByteBuffer.read(i2 - 2) == -1 && pooledByteBuffer.read(i2 - 1) == -39) {
            return true;
        }
        return false;
    }

    public synchronized boolean isValid() {
        return CloseableReference.isValid(this.mPooledByteBufferRef) || this.mInputStreamSupplier != null;
    }

    public void parseMetaData() {
        if (!sUseCachedMetadata) {
            internalParseMetaData();
        } else if (!this.mHasParsedMetadata) {
            internalParseMetaData();
            this.mHasParsedMetadata = true;
        }
    }

    public void setBytesRange(BytesRange bytesRange) {
        this.mBytesRange = bytesRange;
    }

    public void setExifOrientation(int i2) {
        this.mExifOrientation = i2;
    }

    public void setHeight(int i2) {
        this.mHeight = i2;
    }

    public void setImageFormat(ImageFormat imageFormat) {
        this.mImageFormat = imageFormat;
    }

    public void setRotationAngle(int i2) {
        this.mRotationAngle = i2;
    }

    public void setSampleSize(int i2) {
        this.mSampleSize = i2;
    }

    public void setStreamSize(int i2) {
        this.mStreamSize = i2;
    }

    public void setWidth(int i2) {
        this.mWidth = i2;
    }

    @FalseOnNull
    public static boolean isValid(EncodedImage encodedImage) {
        return encodedImage != null && encodedImage.isValid();
    }

    public EncodedImage cloneOrNull() {
        EncodedImage encodedImage;
        Supplier<FileInputStream> supplier = this.mInputStreamSupplier;
        if (supplier != null) {
            encodedImage = new EncodedImage(supplier, this.mStreamSize);
        } else {
            CloseableReference<PooledByteBuffer> cloneOrNull = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
            if (cloneOrNull == null) {
                encodedImage = null;
            } else {
                try {
                    encodedImage = new EncodedImage(cloneOrNull);
                } catch (Throwable th) {
                    CloseableReference.closeSafely((CloseableReference<?>) cloneOrNull);
                    throw th;
                }
            }
            CloseableReference.closeSafely((CloseableReference<?>) cloneOrNull);
        }
        if (encodedImage != null) {
            encodedImage.copyMetaDataFrom(this);
        }
        return encodedImage;
    }

    public EncodedImage(Supplier<FileInputStream> supplier) {
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        Preconditions.checkNotNull(supplier);
        this.mPooledByteBufferRef = null;
        this.mInputStreamSupplier = supplier;
    }

    public EncodedImage(Supplier<FileInputStream> supplier, int i2) {
        this(supplier);
        this.mStreamSize = i2;
    }
}
