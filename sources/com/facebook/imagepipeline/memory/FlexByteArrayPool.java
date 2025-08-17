package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class FlexByteArrayPool {
    final SoftRefByteArrayPool mDelegatePool;
    private final ResourceReleaser<byte[]> mResourceReleaser;

    static class SoftRefByteArrayPool extends GenericByteArrayPool {
        public SoftRefByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
            super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        }

        /* access modifiers changed from: package-private */
        public Bucket<byte[]> newBucket(int i2) {
            return new OOMSoftReferenceBucket(getSizeInBytes(i2), this.mPoolParams.maxNumThreads, 0);
        }
    }

    public FlexByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams) {
        boolean z2;
        if (poolParams.maxNumThreads > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(Boolean.valueOf(z2));
        this.mDelegatePool = new SoftRefByteArrayPool(memoryTrimmableRegistry, poolParams, NoOpPoolStatsTracker.getInstance());
        this.mResourceReleaser = new ResourceReleaser<byte[]>() {
            public void release(byte[] bArr) {
                FlexByteArrayPool.this.release(bArr);
            }
        };
    }

    public CloseableReference<byte[]> get(int i2) {
        return CloseableReference.of(this.mDelegatePool.get(i2), this.mResourceReleaser);
    }

    public int getMinBufferSize() {
        return this.mDelegatePool.getMinBufferSize();
    }

    public Map<String, Integer> getStats() {
        return this.mDelegatePool.getStats();
    }

    public void release(byte[] bArr) {
        this.mDelegatePool.release(bArr);
    }
}
