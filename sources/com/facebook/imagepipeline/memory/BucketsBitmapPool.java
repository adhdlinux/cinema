package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
@TargetApi(21)
public class BucketsBitmapPool extends BasePool<Bitmap> implements BitmapPool {
    public BucketsBitmapPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker, boolean z2) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker, z2);
        initialize();
    }

    /* access modifiers changed from: protected */
    public int getBucketedSize(int i2) {
        return i2;
    }

    /* access modifiers changed from: protected */
    public int getSizeInBytes(int i2) {
        return i2;
    }

    /* access modifiers changed from: protected */
    public Bitmap alloc(int i2) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) i2) / 2.0d), Bitmap.Config.RGB_565);
    }

    /* access modifiers changed from: protected */
    public void free(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        bitmap.recycle();
    }

    /* access modifiers changed from: protected */
    public int getBucketedSizeForValue(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        return bitmap.getAllocationByteCount();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.facebook.imagepipeline.memory.Bucket, com.facebook.imagepipeline.memory.Bucket<android.graphics.Bitmap>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap getValue(com.facebook.imagepipeline.memory.Bucket<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            java.lang.Object r2 = super.getValue(r2)
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            if (r2 == 0) goto L_0x000c
            r0 = 0
            r2.eraseColor(r0)
        L_0x000c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BucketsBitmapPool.getValue(com.facebook.imagepipeline.memory.Bucket):android.graphics.Bitmap");
    }

    /* access modifiers changed from: protected */
    public boolean isReusable(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        return !bitmap.isRecycled() && bitmap.isMutable();
    }
}
