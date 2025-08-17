package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public abstract class MemoryChunkPool extends BasePool<MemoryChunk> {
    private final int[] mBucketSizes;

    MemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        SparseIntArray sparseIntArray = (SparseIntArray) Preconditions.checkNotNull(poolParams.bucketSizes);
        this.mBucketSizes = new int[sparseIntArray.size()];
        int i2 = 0;
        while (true) {
            int[] iArr = this.mBucketSizes;
            if (i2 < iArr.length) {
                iArr[i2] = sparseIntArray.keyAt(i2);
                i2++;
            } else {
                initialize();
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract MemoryChunk alloc(int i2);

    /* access modifiers changed from: protected */
    public int getBucketedSize(int i2) {
        if (i2 > 0) {
            for (int i3 : this.mBucketSizes) {
                if (i3 >= i2) {
                    return i3;
                }
            }
            return i2;
        }
        throw new BasePool.InvalidSizeException(Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public int getMinBufferSize() {
        return this.mBucketSizes[0];
    }

    /* access modifiers changed from: protected */
    public int getSizeInBytes(int i2) {
        return i2;
    }

    /* access modifiers changed from: protected */
    public void free(MemoryChunk memoryChunk) {
        Preconditions.checkNotNull(memoryChunk);
        memoryChunk.close();
    }

    /* access modifiers changed from: protected */
    public int getBucketedSizeForValue(MemoryChunk memoryChunk) {
        Preconditions.checkNotNull(memoryChunk);
        return memoryChunk.getSize();
    }

    /* access modifiers changed from: protected */
    public boolean isReusable(MemoryChunk memoryChunk) {
        Preconditions.checkNotNull(memoryChunk);
        return !memoryChunk.isClosed();
    }
}
