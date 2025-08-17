package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.HasBitmap;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.BitmapUtil;

public class CloseableStaticBitmap extends CloseableBitmap implements HasBitmap {
    private volatile Bitmap mBitmap;
    private CloseableReference<Bitmap> mBitmapReference;
    private final int mExifOrientation;
    private final QualityInfo mQualityInfo;
    private final int mRotationAngle;

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i2) {
        this(bitmap, resourceReleaser, qualityInfo, i2, 0);
    }

    private synchronized CloseableReference<Bitmap> detachBitmapReference() {
        CloseableReference<Bitmap> closeableReference;
        closeableReference = this.mBitmapReference;
        this.mBitmapReference = null;
        this.mBitmap = null;
        return closeableReference;
    }

    private static int getBitmapHeight(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    private static int getBitmapWidth(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    public synchronized CloseableReference<Bitmap> cloneUnderlyingBitmapReference() {
        return CloseableReference.cloneOrNull(this.mBitmapReference);
    }

    public void close() {
        CloseableReference<Bitmap> detachBitmapReference = detachBitmapReference();
        if (detachBitmapReference != null) {
            detachBitmapReference.close();
        }
    }

    public synchronized CloseableReference<Bitmap> convertToBitmapReference() {
        Preconditions.checkNotNull(this.mBitmapReference, "Cannot convert a closed static bitmap");
        return detachBitmapReference();
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public int getHeight() {
        int i2;
        if (this.mRotationAngle % RotationOptions.ROTATE_180 != 0 || (i2 = this.mExifOrientation) == 5 || i2 == 7) {
            return getBitmapWidth(this.mBitmap);
        }
        return getBitmapHeight(this.mBitmap);
    }

    public QualityInfo getQualityInfo() {
        return this.mQualityInfo;
    }

    public int getRotationAngle() {
        return this.mRotationAngle;
    }

    public int getSizeInBytes() {
        return BitmapUtil.getSizeInBytes(this.mBitmap);
    }

    public Bitmap getUnderlyingBitmap() {
        return this.mBitmap;
    }

    public int getWidth() {
        int i2;
        if (this.mRotationAngle % RotationOptions.ROTATE_180 != 0 || (i2 = this.mExifOrientation) == 5 || i2 == 7) {
            return getBitmapHeight(this.mBitmap);
        }
        return getBitmapWidth(this.mBitmap);
    }

    public synchronized boolean isClosed() {
        boolean z2;
        if (this.mBitmapReference == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CloseableStaticBitmap(android.graphics.Bitmap r1, com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap> r2, com.facebook.imagepipeline.image.QualityInfo r3, int r4, int r5) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r1)
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            r0.mBitmap = r1
            android.graphics.Bitmap r1 = r0.mBitmap
            java.lang.Object r2 = com.facebook.common.internal.Preconditions.checkNotNull(r2)
            com.facebook.common.references.ResourceReleaser r2 = (com.facebook.common.references.ResourceReleaser) r2
            com.facebook.common.references.CloseableReference r1 = com.facebook.common.references.CloseableReference.of(r1, r2)
            r0.mBitmapReference = r1
            r0.mQualityInfo = r3
            r0.mRotationAngle = r4
            r0.mExifOrientation = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.image.CloseableStaticBitmap.<init>(android.graphics.Bitmap, com.facebook.common.references.ResourceReleaser, com.facebook.imagepipeline.image.QualityInfo, int, int):void");
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i2) {
        this(closeableReference, qualityInfo, i2, 0);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.facebook.common.references.CloseableReference, com.facebook.common.references.CloseableReference<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CloseableStaticBitmap(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> r1, com.facebook.imagepipeline.image.QualityInfo r2, int r3, int r4) {
        /*
            r0 = this;
            r0.<init>()
            com.facebook.common.references.CloseableReference r1 = r1.cloneOrNull()
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r1)
            com.facebook.common.references.CloseableReference r1 = (com.facebook.common.references.CloseableReference) r1
            r0.mBitmapReference = r1
            java.lang.Object r1 = r1.get()
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            r0.mBitmap = r1
            r0.mQualityInfo = r2
            r0.mRotationAngle = r3
            r0.mExifOrientation = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.image.CloseableStaticBitmap.<init>(com.facebook.common.references.CloseableReference, com.facebook.imagepipeline.image.QualityInfo, int, int):void");
    }
}
