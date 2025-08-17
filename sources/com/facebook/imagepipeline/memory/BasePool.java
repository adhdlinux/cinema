package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class BasePool<V> implements Pool<V> {
    private final Class<?> TAG;
    private boolean mAllowNewBuckets;
    final SparseArray<Bucket<V>> mBuckets;
    final Counter mFree;
    private boolean mIgnoreHardCap;
    final Set<V> mInUseValues;
    final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    final PoolParams mPoolParams;
    private final PoolStatsTracker mPoolStatsTracker;
    final Counter mUsed;

    static class Counter {
        private static final String TAG = "com.facebook.imagepipeline.memory.BasePool.Counter";
        int mCount;
        int mNumBytes;

        Counter() {
        }

        public void decrement(int i2) {
            int i3;
            int i4 = this.mNumBytes;
            if (i4 < i2 || (i3 = this.mCount) <= 0) {
                FLog.wtf(TAG, "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i2), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount));
                return;
            }
            this.mCount = i3 - 1;
            this.mNumBytes = i4 - i2;
        }

        public void increment(int i2) {
            this.mCount++;
            this.mNumBytes += i2;
        }

        public void reset() {
            this.mCount = 0;
            this.mNumBytes = 0;
        }
    }

    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i2, int i3, int i4, int i5) {
            super("Pool hard cap violation? Hard cap = " + i2 + " Used size = " + i3 + " Free size = " + i4 + " Request size = " + i5);
        }
    }

    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        this.TAG = getClass();
        this.mMemoryTrimmableRegistry = (MemoryTrimmableRegistry) Preconditions.checkNotNull(memoryTrimmableRegistry);
        PoolParams poolParams2 = (PoolParams) Preconditions.checkNotNull(poolParams);
        this.mPoolParams = poolParams2;
        this.mPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
        this.mBuckets = new SparseArray<>();
        if (poolParams2.fixBucketsReinitialization) {
            initBuckets();
        } else {
            legacyInitBuckets(new SparseIntArray(0));
        }
        this.mInUseValues = Sets.newIdentityHashSet();
        this.mFree = new Counter();
        this.mUsed = new Counter();
    }

    private synchronized void ensurePoolSizeInvariant() {
        boolean z2;
        if (isMaxSizeSoftCapExceeded()) {
            if (this.mFree.mNumBytes != 0) {
                z2 = false;
                Preconditions.checkState(z2);
            }
        }
        z2 = true;
        Preconditions.checkState(z2);
    }

    private void fillBuckets(SparseIntArray sparseIntArray) {
        this.mBuckets.clear();
        for (int i2 = 0; i2 < sparseIntArray.size(); i2++) {
            int keyAt = sparseIntArray.keyAt(i2);
            this.mBuckets.put(keyAt, new Bucket(getSizeInBytes(keyAt), sparseIntArray.valueAt(i2), 0, this.mPoolParams.fixBucketsReinitialization));
        }
    }

    private synchronized Bucket<V> getBucketIfPresent(int i2) {
        return this.mBuckets.get(i2);
    }

    private synchronized void initBuckets() {
        SparseIntArray sparseIntArray = this.mPoolParams.bucketSizes;
        if (sparseIntArray != null) {
            fillBuckets(sparseIntArray);
            this.mAllowNewBuckets = false;
        } else {
            this.mAllowNewBuckets = true;
        }
    }

    private synchronized void legacyInitBuckets(SparseIntArray sparseIntArray) {
        Preconditions.checkNotNull(sparseIntArray);
        this.mBuckets.clear();
        SparseIntArray sparseIntArray2 = this.mPoolParams.bucketSizes;
        if (sparseIntArray2 != null) {
            for (int i2 = 0; i2 < sparseIntArray2.size(); i2++) {
                int keyAt = sparseIntArray2.keyAt(i2);
                this.mBuckets.put(keyAt, new Bucket(getSizeInBytes(keyAt), sparseIntArray2.valueAt(i2), sparseIntArray.get(keyAt, 0), this.mPoolParams.fixBucketsReinitialization));
            }
            this.mAllowNewBuckets = false;
        } else {
            this.mAllowNewBuckets = true;
        }
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void logStats() {
        if (FLog.isLoggable(2)) {
            FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", (Object) Integer.valueOf(this.mUsed.mCount), (Object) Integer.valueOf(this.mUsed.mNumBytes), (Object) Integer.valueOf(this.mFree.mCount), (Object) Integer.valueOf(this.mFree.mNumBytes));
        }
    }

    private List<Bucket<V>> refillBuckets() {
        ArrayList arrayList = new ArrayList(this.mBuckets.size());
        int size = this.mBuckets.size();
        for (int i2 = 0; i2 < size; i2++) {
            Bucket bucket = (Bucket) Preconditions.checkNotNull(this.mBuckets.valueAt(i2));
            int i3 = bucket.mItemSize;
            int i4 = bucket.mMaxLength;
            int inUseCount = bucket.getInUseCount();
            if (bucket.getFreeListSize() > 0) {
                arrayList.add(bucket);
            }
            this.mBuckets.setValueAt(i2, new Bucket(getSizeInBytes(i3), i4, inUseCount, this.mPoolParams.fixBucketsReinitialization));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public abstract V alloc(int i2);

    /* access modifiers changed from: package-private */
    public synchronized boolean canAllocate(int i2) {
        if (this.mIgnoreHardCap) {
            return true;
        }
        PoolParams poolParams = this.mPoolParams;
        int i3 = poolParams.maxSizeHardCap;
        int i4 = this.mUsed.mNumBytes;
        if (i2 > i3 - i4) {
            this.mPoolStatsTracker.onHardCapReached();
            return false;
        }
        int i5 = poolParams.maxSizeSoftCap;
        if (i2 > i5 - (i4 + this.mFree.mNumBytes)) {
            trimToSize(i5 - i2);
        }
        if (i2 <= i3 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            return true;
        }
        this.mPoolStatsTracker.onHardCapReached();
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void free(V v2);

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0052, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0 = alloc(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006e, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r4.mUsed.decrement(r2);
        r3 = getBucket(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        if (r3 != null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007a, code lost:
        r3.decrementInUseCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
        com.facebook.common.internal.Throwables.propagateIfPossible(r0);
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0082, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        com.facebook.common.internal.Preconditions.checkState(r4.mInUseValues.add(r0));
        trimToSoftCap();
        r4.mPoolStatsTracker.onAlloc(r2);
        logStats();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009b, code lost:
        if (com.facebook.common.logging.FLog.isLoggable(2) == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        com.facebook.common.logging.FLog.v(r4.TAG, "get (alloc) (object, size) = (%x, %s)", (java.lang.Object) java.lang.Integer.valueOf(java.lang.System.identityHashCode(r0)), (java.lang.Object) java.lang.Integer.valueOf(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b1, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V get(int r5) {
        /*
            r4 = this;
            r4.ensurePoolSizeInvariant()
            int r5 = r4.getBucketedSize(r5)
            monitor-enter(r4)
            com.facebook.imagepipeline.memory.Bucket r0 = r4.getBucket(r5)     // Catch:{ all -> 0x00ca }
            r1 = 2
            if (r0 == 0) goto L_0x0053
            java.lang.Object r2 = r4.getValue(r0)     // Catch:{ all -> 0x00ca }
            if (r2 == 0) goto L_0x0053
            java.util.Set<V> r5 = r4.mInUseValues     // Catch:{ all -> 0x00ca }
            boolean r5 = r5.add(r2)     // Catch:{ all -> 0x00ca }
            com.facebook.common.internal.Preconditions.checkState(r5)     // Catch:{ all -> 0x00ca }
            int r5 = r4.getBucketedSizeForValue(r2)     // Catch:{ all -> 0x00ca }
            int r0 = r4.getSizeInBytes(r5)     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r4.mUsed     // Catch:{ all -> 0x00ca }
            r3.increment(r0)     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r4.mFree     // Catch:{ all -> 0x00ca }
            r3.decrement(r0)     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.PoolStatsTracker r3 = r4.mPoolStatsTracker     // Catch:{ all -> 0x00ca }
            r3.onValueReuse(r0)     // Catch:{ all -> 0x00ca }
            r4.logStats()     // Catch:{ all -> 0x00ca }
            boolean r0 = com.facebook.common.logging.FLog.isLoggable(r1)     // Catch:{ all -> 0x00ca }
            if (r0 == 0) goto L_0x0051
            java.lang.Class<?> r0 = r4.TAG     // Catch:{ all -> 0x00ca }
            java.lang.String r1 = "get (reuse) (object, size) = (%x, %s)"
            int r3 = java.lang.System.identityHashCode(r2)     // Catch:{ all -> 0x00ca }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00ca }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00ca }
            com.facebook.common.logging.FLog.v((java.lang.Class<?>) r0, (java.lang.String) r1, (java.lang.Object) r3, (java.lang.Object) r5)     // Catch:{ all -> 0x00ca }
        L_0x0051:
            monitor-exit(r4)     // Catch:{ all -> 0x00ca }
            return r2
        L_0x0053:
            int r2 = r4.getSizeInBytes(r5)     // Catch:{ all -> 0x00ca }
            boolean r3 = r4.canAllocate(r2)     // Catch:{ all -> 0x00ca }
            if (r3 == 0) goto L_0x00b8
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r4.mUsed     // Catch:{ all -> 0x00ca }
            r3.increment(r2)     // Catch:{ all -> 0x00ca }
            if (r0 == 0) goto L_0x0067
            r0.incrementInUseCount()     // Catch:{ all -> 0x00ca }
        L_0x0067:
            monitor-exit(r4)     // Catch:{ all -> 0x00ca }
            java.lang.Object r0 = r4.alloc(r5)     // Catch:{ all -> 0x006d }
            goto L_0x0082
        L_0x006d:
            r0 = move-exception
            monitor-enter(r4)
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r4.mUsed     // Catch:{ all -> 0x00b5 }
            r3.decrement(r2)     // Catch:{ all -> 0x00b5 }
            com.facebook.imagepipeline.memory.Bucket r3 = r4.getBucket(r5)     // Catch:{ all -> 0x00b5 }
            if (r3 == 0) goto L_0x007d
            r3.decrementInUseCount()     // Catch:{ all -> 0x00b5 }
        L_0x007d:
            monitor-exit(r4)     // Catch:{ all -> 0x00b5 }
            com.facebook.common.internal.Throwables.propagateIfPossible(r0)
            r0 = 0
        L_0x0082:
            monitor-enter(r4)
            java.util.Set<V> r3 = r4.mInUseValues     // Catch:{ all -> 0x00b2 }
            boolean r3 = r3.add(r0)     // Catch:{ all -> 0x00b2 }
            com.facebook.common.internal.Preconditions.checkState(r3)     // Catch:{ all -> 0x00b2 }
            r4.trimToSoftCap()     // Catch:{ all -> 0x00b2 }
            com.facebook.imagepipeline.memory.PoolStatsTracker r3 = r4.mPoolStatsTracker     // Catch:{ all -> 0x00b2 }
            r3.onAlloc(r2)     // Catch:{ all -> 0x00b2 }
            r4.logStats()     // Catch:{ all -> 0x00b2 }
            boolean r1 = com.facebook.common.logging.FLog.isLoggable(r1)     // Catch:{ all -> 0x00b2 }
            if (r1 == 0) goto L_0x00b0
            java.lang.Class<?> r1 = r4.TAG     // Catch:{ all -> 0x00b2 }
            java.lang.String r2 = "get (alloc) (object, size) = (%x, %s)"
            int r3 = java.lang.System.identityHashCode(r0)     // Catch:{ all -> 0x00b2 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00b2 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00b2 }
            com.facebook.common.logging.FLog.v((java.lang.Class<?>) r1, (java.lang.String) r2, (java.lang.Object) r3, (java.lang.Object) r5)     // Catch:{ all -> 0x00b2 }
        L_0x00b0:
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            return r0
        L_0x00b2:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            throw r5
        L_0x00b5:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b5 }
            throw r5
        L_0x00b8:
            com.facebook.imagepipeline.memory.BasePool$PoolSizeViolationException r5 = new com.facebook.imagepipeline.memory.BasePool$PoolSizeViolationException     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.PoolParams r0 = r4.mPoolParams     // Catch:{ all -> 0x00ca }
            int r0 = r0.maxSizeHardCap     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.BasePool$Counter r1 = r4.mUsed     // Catch:{ all -> 0x00ca }
            int r1 = r1.mNumBytes     // Catch:{ all -> 0x00ca }
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r4.mFree     // Catch:{ all -> 0x00ca }
            int r3 = r3.mNumBytes     // Catch:{ all -> 0x00ca }
            r5.<init>(r0, r1, r3, r2)     // Catch:{ all -> 0x00ca }
            throw r5     // Catch:{ all -> 0x00ca }
        L_0x00ca:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00ca }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.get(int):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.facebook.imagepipeline.memory.Bucket<V> getBucket(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> r0 = r3.mBuckets     // Catch:{ all -> 0x002f }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002f }
            com.facebook.imagepipeline.memory.Bucket r0 = (com.facebook.imagepipeline.memory.Bucket) r0     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x002d
            boolean r1 = r3.mAllowNewBuckets     // Catch:{ all -> 0x002f }
            if (r1 != 0) goto L_0x0010
            goto L_0x002d
        L_0x0010:
            r0 = 2
            boolean r0 = com.facebook.common.logging.FLog.isLoggable(r0)     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0022
            java.lang.Class<?> r0 = r3.TAG     // Catch:{ all -> 0x002f }
            java.lang.String r1 = "creating new bucket %s"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x002f }
            com.facebook.common.logging.FLog.v((java.lang.Class<?>) r0, (java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x002f }
        L_0x0022:
            com.facebook.imagepipeline.memory.Bucket r0 = r3.newBucket(r4)     // Catch:{ all -> 0x002f }
            android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> r1 = r3.mBuckets     // Catch:{ all -> 0x002f }
            r1.put(r4, r0)     // Catch:{ all -> 0x002f }
            monitor-exit(r3)
            return r0
        L_0x002d:
            monitor-exit(r3)
            return r0
        L_0x002f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.getBucket(int):com.facebook.imagepipeline.memory.Bucket");
    }

    /* access modifiers changed from: protected */
    public abstract int getBucketedSize(int i2);

    /* access modifiers changed from: protected */
    public abstract int getBucketedSizeForValue(V v2);

    /* access modifiers changed from: protected */
    public abstract int getSizeInBytes(int i2);

    public synchronized Map<String, Integer> getStats() {
        HashMap hashMap;
        hashMap = new HashMap();
        for (int i2 = 0; i2 < this.mBuckets.size(); i2++) {
            int keyAt = this.mBuckets.keyAt(i2);
            hashMap.put(PoolStatsTracker.BUCKETS_USED_PREFIX + getSizeInBytes(keyAt), Integer.valueOf(((Bucket) Preconditions.checkNotNull(this.mBuckets.valueAt(i2))).getInUseCount()));
        }
        hashMap.put(PoolStatsTracker.SOFT_CAP, Integer.valueOf(this.mPoolParams.maxSizeSoftCap));
        hashMap.put(PoolStatsTracker.HARD_CAP, Integer.valueOf(this.mPoolParams.maxSizeHardCap));
        hashMap.put(PoolStatsTracker.USED_COUNT, Integer.valueOf(this.mUsed.mCount));
        hashMap.put(PoolStatsTracker.USED_BYTES, Integer.valueOf(this.mUsed.mNumBytes));
        hashMap.put(PoolStatsTracker.FREE_COUNT, Integer.valueOf(this.mFree.mCount));
        hashMap.put(PoolStatsTracker.FREE_BYTES, Integer.valueOf(this.mFree.mNumBytes));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public synchronized V getValue(Bucket<V> bucket) {
        return bucket.get();
    }

    /* access modifiers changed from: protected */
    public void initialize() {
        this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
        this.mPoolStatsTracker.setBasePool(this);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isMaxSizeSoftCapExceeded() {
        boolean z2;
        if (this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.mPoolStatsTracker.onSoftCapReached();
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public boolean isReusable(V v2) {
        Preconditions.checkNotNull(v2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public Bucket<V> newBucket(int i2) {
        return new Bucket<>(getSizeInBytes(i2), Integer.MAX_VALUE, 0, this.mPoolParams.fixBucketsReinitialization);
    }

    /* access modifiers changed from: protected */
    public void onParamsChanged() {
    }

    public void release(V v2) {
        Preconditions.checkNotNull(v2);
        int bucketedSizeForValue = getBucketedSizeForValue(v2);
        int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
        synchronized (this) {
            Bucket bucketIfPresent = getBucketIfPresent(bucketedSizeForValue);
            if (!this.mInUseValues.remove(v2)) {
                FLog.e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v2)), Integer.valueOf(bucketedSizeForValue));
                free(v2);
                this.mPoolStatsTracker.onFree(sizeInBytes);
            } else {
                if (bucketIfPresent != null && !bucketIfPresent.isMaxLengthExceeded() && !isMaxSizeSoftCapExceeded()) {
                    if (isReusable(v2)) {
                        bucketIfPresent.release(v2);
                        this.mFree.increment(sizeInBytes);
                        this.mUsed.decrement(sizeInBytes);
                        this.mPoolStatsTracker.onValueRelease(sizeInBytes);
                        if (FLog.isLoggable(2)) {
                            FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", (Object) Integer.valueOf(System.identityHashCode(v2)), (Object) Integer.valueOf(bucketedSizeForValue));
                        }
                    }
                }
                if (bucketIfPresent != null) {
                    bucketIfPresent.decrementInUseCount();
                }
                if (FLog.isLoggable(2)) {
                    FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", (Object) Integer.valueOf(System.identityHashCode(v2)), (Object) Integer.valueOf(bucketedSizeForValue));
                }
                free(v2);
                this.mUsed.decrement(sizeInBytes);
                this.mPoolStatsTracker.onFree(sizeInBytes);
            }
            logStats();
        }
    }

    public void trim(MemoryTrimType memoryTrimType) {
        trimToNothing();
    }

    /* access modifiers changed from: package-private */
    public void trimToNothing() {
        int i2;
        List list;
        synchronized (this) {
            if (this.mPoolParams.fixBucketsReinitialization) {
                list = refillBuckets();
            } else {
                list = new ArrayList(this.mBuckets.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i3 = 0; i3 < this.mBuckets.size(); i3++) {
                    Bucket bucket = (Bucket) Preconditions.checkNotNull(this.mBuckets.valueAt(i3));
                    if (bucket.getFreeListSize() > 0) {
                        list.add(bucket);
                    }
                    sparseIntArray.put(this.mBuckets.keyAt(i3), bucket.getInUseCount());
                }
                legacyInitBuckets(sparseIntArray);
            }
            this.mFree.reset();
            logStats();
        }
        onParamsChanged();
        for (i2 = 0; i2 < list.size(); i2++) {
            Bucket bucket2 = (Bucket) list.get(i2);
            while (true) {
                Object pop = bucket2.pop();
                if (pop == null) {
                    break;
                }
                free(pop);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void trimToSize(int r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.facebook.imagepipeline.memory.BasePool$Counter r0 = r7.mUsed     // Catch:{ all -> 0x008c }
            int r0 = r0.mNumBytes     // Catch:{ all -> 0x008c }
            com.facebook.imagepipeline.memory.BasePool$Counter r1 = r7.mFree     // Catch:{ all -> 0x008c }
            int r1 = r1.mNumBytes     // Catch:{ all -> 0x008c }
            int r0 = r0 + r1
            int r0 = r0 - r8
            int r0 = java.lang.Math.min(r0, r1)     // Catch:{ all -> 0x008c }
            if (r0 > 0) goto L_0x0013
            monitor-exit(r7)
            return
        L_0x0013:
            r1 = 2
            boolean r2 = com.facebook.common.logging.FLog.isLoggable(r1)     // Catch:{ all -> 0x008c }
            if (r2 == 0) goto L_0x0036
            java.lang.Class<?> r2 = r7.TAG     // Catch:{ all -> 0x008c }
            java.lang.String r3 = "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x008c }
            com.facebook.imagepipeline.memory.BasePool$Counter r5 = r7.mUsed     // Catch:{ all -> 0x008c }
            int r5 = r5.mNumBytes     // Catch:{ all -> 0x008c }
            com.facebook.imagepipeline.memory.BasePool$Counter r6 = r7.mFree     // Catch:{ all -> 0x008c }
            int r6 = r6.mNumBytes     // Catch:{ all -> 0x008c }
            int r5 = r5 + r6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x008c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x008c }
            com.facebook.common.logging.FLog.v((java.lang.Class<?>) r2, (java.lang.String) r3, (java.lang.Object) r4, (java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x008c }
        L_0x0036:
            r7.logStats()     // Catch:{ all -> 0x008c }
            r2 = 0
        L_0x003a:
            android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> r3 = r7.mBuckets     // Catch:{ all -> 0x008c }
            int r3 = r3.size()     // Catch:{ all -> 0x008c }
            if (r2 >= r3) goto L_0x0069
            if (r0 > 0) goto L_0x0045
            goto L_0x0069
        L_0x0045:
            android.util.SparseArray<com.facebook.imagepipeline.memory.Bucket<V>> r3 = r7.mBuckets     // Catch:{ all -> 0x008c }
            java.lang.Object r3 = r3.valueAt(r2)     // Catch:{ all -> 0x008c }
            java.lang.Object r3 = com.facebook.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x008c }
            com.facebook.imagepipeline.memory.Bucket r3 = (com.facebook.imagepipeline.memory.Bucket) r3     // Catch:{ all -> 0x008c }
        L_0x0051:
            if (r0 <= 0) goto L_0x0066
            java.lang.Object r4 = r3.pop()     // Catch:{ all -> 0x008c }
            if (r4 != 0) goto L_0x005a
            goto L_0x0066
        L_0x005a:
            r7.free(r4)     // Catch:{ all -> 0x008c }
            int r4 = r3.mItemSize     // Catch:{ all -> 0x008c }
            int r0 = r0 - r4
            com.facebook.imagepipeline.memory.BasePool$Counter r5 = r7.mFree     // Catch:{ all -> 0x008c }
            r5.decrement(r4)     // Catch:{ all -> 0x008c }
            goto L_0x0051
        L_0x0066:
            int r2 = r2 + 1
            goto L_0x003a
        L_0x0069:
            r7.logStats()     // Catch:{ all -> 0x008c }
            boolean r0 = com.facebook.common.logging.FLog.isLoggable(r1)     // Catch:{ all -> 0x008c }
            if (r0 == 0) goto L_0x008a
            java.lang.Class<?> r0 = r7.TAG     // Catch:{ all -> 0x008c }
            java.lang.String r1 = "trimToSize: TargetSize = %d; Final Size = %d"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x008c }
            com.facebook.imagepipeline.memory.BasePool$Counter r2 = r7.mUsed     // Catch:{ all -> 0x008c }
            int r2 = r2.mNumBytes     // Catch:{ all -> 0x008c }
            com.facebook.imagepipeline.memory.BasePool$Counter r3 = r7.mFree     // Catch:{ all -> 0x008c }
            int r3 = r3.mNumBytes     // Catch:{ all -> 0x008c }
            int r2 = r2 + r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x008c }
            com.facebook.common.logging.FLog.v((java.lang.Class<?>) r0, (java.lang.String) r1, (java.lang.Object) r8, (java.lang.Object) r2)     // Catch:{ all -> 0x008c }
        L_0x008a:
            monitor-exit(r7)
            return
        L_0x008c:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.trimToSize(int):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void trimToSoftCap() {
        if (isMaxSizeSoftCapExceeded()) {
            trimToSize(this.mPoolParams.maxSizeSoftCap);
        }
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker, boolean z2) {
        this(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        this.mIgnoreHardCap = z2;
    }
}
