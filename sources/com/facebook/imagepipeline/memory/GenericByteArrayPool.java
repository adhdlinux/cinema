package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class GenericByteArrayPool extends BasePool<byte[]> implements ByteArrayPool {
    private final int[] mBucketSizes;

    public GenericByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        SparseIntArray sparseIntArray = (SparseIntArray) Preconditions.checkNotNull(poolParams.bucketSizes);
        this.mBucketSizes = new int[sparseIntArray.size()];
        for (int i2 = 0; i2 < sparseIntArray.size(); i2++) {
            this.mBucketSizes[i2] = sparseIntArray.keyAt(i2);
        }
        initialize();
    }

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

    public int getMinBufferSize() {
        return this.mBucketSizes[0];
    }

    /* access modifiers changed from: protected */
    public int getSizeInBytes(int i2) {
        return i2;
    }

    /* access modifiers changed from: protected */
    public byte[] alloc(int i2) {
        return new byte[i2];
    }

    /* access modifiers changed from: protected */
    public void free(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
    }

    /* access modifiers changed from: protected */
    public int getBucketedSizeForValue(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        return bArr.length;
    }
}
