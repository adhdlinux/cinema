package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class LruBitmapPool implements BitmapPool {
    private int mCurrentSize;
    private int mMaxBitmapSize;
    private final int mMaxPoolSize;
    private final PoolStatsTracker mPoolStatsTracker;
    protected final PoolBackend<Bitmap> mStrategy = new BitmapPoolBackend();

    public LruBitmapPool(int i2, int i3, PoolStatsTracker poolStatsTracker, MemoryTrimmableRegistry memoryTrimmableRegistry) {
        this.mMaxPoolSize = i2;
        this.mMaxBitmapSize = i3;
        this.mPoolStatsTracker = poolStatsTracker;
        if (memoryTrimmableRegistry != null) {
            memoryTrimmableRegistry.registerMemoryTrimmable(this);
        }
    }

    private Bitmap alloc(int i2) {
        this.mPoolStatsTracker.onAlloc(i2);
        return Bitmap.createBitmap(1, i2, Bitmap.Config.ALPHA_8);
    }

    private synchronized void trimTo(int i2) {
        while (true) {
            if (this.mCurrentSize <= i2) {
                break;
            }
            Bitmap pop = this.mStrategy.pop();
            if (pop == null) {
                break;
            }
            int size = this.mStrategy.getSize(pop);
            this.mCurrentSize -= size;
            this.mPoolStatsTracker.onFree(size);
        }
    }

    public void trim(MemoryTrimType memoryTrimType) {
        trimTo((int) (((double) this.mMaxPoolSize) * (1.0d - memoryTrimType.getSuggestedTrimRatio())));
    }

    public synchronized Bitmap get(int i2) {
        int i3 = this.mCurrentSize;
        int i4 = this.mMaxPoolSize;
        if (i3 > i4) {
            trimTo(i4);
        }
        Bitmap bitmap = this.mStrategy.get(i2);
        if (bitmap != null) {
            int size = this.mStrategy.getSize(bitmap);
            this.mCurrentSize -= size;
            this.mPoolStatsTracker.onValueReuse(size);
            return bitmap;
        }
        return alloc(i2);
    }

    public void release(Bitmap bitmap) {
        int size = this.mStrategy.getSize(bitmap);
        if (size <= this.mMaxBitmapSize) {
            this.mPoolStatsTracker.onValueRelease(size);
            this.mStrategy.put(bitmap);
            synchronized (this) {
                this.mCurrentSize += size;
            }
        }
    }
}
