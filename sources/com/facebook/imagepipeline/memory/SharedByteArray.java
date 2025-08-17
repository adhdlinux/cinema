package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.Semaphore;

@Nullsafe(Nullsafe.Mode.STRICT)
public class SharedByteArray implements MemoryTrimmable {
    final OOMSoftReference<byte[]> mByteArraySoftRef;
    final int mMaxByteArraySize;
    final int mMinByteArraySize;
    private final ResourceReleaser<byte[]> mResourceReleaser;
    final Semaphore mSemaphore;

    public SharedByteArray(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams) {
        boolean z2;
        Preconditions.checkNotNull(memoryTrimmableRegistry);
        boolean z3 = false;
        if (poolParams.minBucketSize > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        Preconditions.checkArgument(Boolean.valueOf(poolParams.maxBucketSize >= poolParams.minBucketSize ? true : z3));
        this.mMaxByteArraySize = poolParams.maxBucketSize;
        this.mMinByteArraySize = poolParams.minBucketSize;
        this.mByteArraySoftRef = new OOMSoftReference<>();
        this.mSemaphore = new Semaphore(1);
        this.mResourceReleaser = new ResourceReleaser<byte[]>() {
            public void release(byte[] bArr) {
                SharedByteArray.this.mSemaphore.release();
            }
        };
        memoryTrimmableRegistry.registerMemoryTrimmable(this);
    }

    private synchronized byte[] allocateByteArray(int i2) {
        byte[] bArr;
        this.mByteArraySoftRef.clear();
        bArr = new byte[i2];
        this.mByteArraySoftRef.set(bArr);
        return bArr;
    }

    private byte[] getByteArray(int i2) {
        int bucketedSize = getBucketedSize(i2);
        byte[] bArr = this.mByteArraySoftRef.get();
        if (bArr == null || bArr.length < bucketedSize) {
            return allocateByteArray(bucketedSize);
        }
        return bArr;
    }

    public CloseableReference<byte[]> get(int i2) {
        boolean z2;
        boolean z3 = true;
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "Size must be greater than zero");
        if (i2 > this.mMaxByteArraySize) {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Requested size is too big");
        this.mSemaphore.acquireUninterruptibly();
        try {
            return CloseableReference.of(getByteArray(i2), this.mResourceReleaser);
        } catch (Throwable th) {
            this.mSemaphore.release();
            throw Throwables.propagate(th);
        }
    }

    /* access modifiers changed from: package-private */
    public int getBucketedSize(int i2) {
        return Integer.highestOneBit(Math.max(i2, this.mMinByteArraySize) - 1) * 2;
    }

    public void trim(MemoryTrimType memoryTrimType) {
        if (this.mSemaphore.tryAcquire()) {
            try {
                this.mByteArraySoftRef.clear();
            } finally {
                this.mSemaphore.release();
            }
        }
    }
}
