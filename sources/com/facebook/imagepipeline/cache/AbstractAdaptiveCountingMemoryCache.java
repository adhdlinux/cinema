package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class AbstractAdaptiveCountingMemoryCache<K, V> implements CountingMemoryCache<K, V> {
    static final int DEFAULT_ADAPTIVE_RATE_PROMIL = 10;
    static final int DEFAULT_LFU_FRACTION_PROMIL = 500;
    static final int MAX_FRACTION_PROMIL = 900;
    static final int MIN_FRACTION_PROMIL = 100;
    private static final String TAG = "AbstractArcCountingMemoryCache";
    static final int TOTAL_PROMIL = 1000;
    final int mAdaptiveRatePromil;
    private final MemoryCache.CacheTrimStrategy mCacheTrimStrategy;
    final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mCachedEntries;
    private final int mFrequentlyUsedThreshold;
    final int mGhostListMaxSize;
    int mLFUFractionPromil;
    private long mLastCacheParamsCheck = SystemClock.uptimeMillis();
    final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mLeastFrequentlyUsedExclusiveEntries;
    final AbstractAdaptiveCountingMemoryCache<K, V>.IntMapArrayList<K> mLeastFrequentlyUsedKeysGhostList;
    protected MemoryCacheParams mMemoryCacheParams;
    private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
    final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mMostFrequentlyUsedExclusiveEntries;
    final ArrayList<K> mMostFrequentlyUsedKeysGhostList;
    private final ValueDescriptor<V> mValueDescriptor;

    enum ArrayListType {
        LFU,
        MFU
    }

    class IntMapArrayList<E> {
        private final ArrayList<E> mFirstList;
        private final int mMaxCapacity;
        private final ArrayList<Integer> mSecondList;

        public IntMapArrayList(int i2) {
            this.mFirstList = new ArrayList<>(i2);
            this.mSecondList = new ArrayList<>(i2);
            this.mMaxCapacity = i2;
        }

        public void addPair(E e2, Integer num) {
            if (this.mFirstList.size() == this.mMaxCapacity) {
                this.mFirstList.remove(0);
                this.mSecondList.remove(0);
            }
            this.mFirstList.add(e2);
            this.mSecondList.add(num);
        }

        public boolean contains(E e2) {
            return this.mFirstList.contains(e2);
        }

        public Integer getValue(E e2) {
            int indexOf = this.mFirstList.indexOf(e2);
            if (indexOf < 0) {
                return null;
            }
            return this.mSecondList.get(indexOf);
        }

        public void increaseValueIfExists(E e2) {
            int indexOf = this.mFirstList.indexOf(e2);
            if (indexOf >= 0) {
                Integer valueOf = Integer.valueOf(this.mSecondList.get(indexOf).intValue() + 1);
                int i2 = this.mMaxCapacity;
                if (indexOf == i2 - 1) {
                    this.mSecondList.set(i2 - 1, valueOf);
                    return;
                }
                this.mFirstList.remove(indexOf);
                this.mSecondList.remove(indexOf);
                this.mFirstList.add(e2);
                this.mSecondList.add(valueOf);
            }
        }

        public int size() {
            return this.mFirstList.size();
        }
    }

    public AbstractAdaptiveCountingMemoryCache(Supplier<MemoryCacheParams> supplier, MemoryCache.CacheTrimStrategy cacheTrimStrategy, ValueDescriptor<V> valueDescriptor, int i2, int i3, int i4, int i5) {
        FLog.d(TAG, "Create Adaptive Replacement Cache");
        this.mValueDescriptor = valueDescriptor;
        this.mLeastFrequentlyUsedExclusiveEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mMostFrequentlyUsedExclusiveEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull(supplier.get(), "mMemoryCacheParamsSupplier returned null");
        this.mFrequentlyUsedThreshold = i3;
        this.mGhostListMaxSize = i4;
        this.mLeastFrequentlyUsedKeysGhostList = new IntMapArrayList<>(i4);
        this.mMostFrequentlyUsedKeysGhostList = new ArrayList<>(i4);
        if (i5 < 100 || i5 > 900) {
            this.mLFUFractionPromil = 500;
            logIllegalLfuFraction();
        } else {
            this.mLFUFractionPromil = i5;
        }
        if (i2 <= 0 || i2 >= 1000) {
            this.mAdaptiveRatePromil = 10;
            logIllegalAdaptiveRate();
            return;
        }
        this.mAdaptiveRatePromil = i2;
    }

    private synchronized void addElementToGhostList(K k2, int i2, ArrayListType arrayListType) {
        if (arrayListType == ArrayListType.LFU) {
            this.mLeastFrequentlyUsedKeysGhostList.addPair(k2, Integer.valueOf(i2));
        } else {
            if (this.mMostFrequentlyUsedKeysGhostList.size() == this.mGhostListMaxSize) {
                this.mMostFrequentlyUsedKeysGhostList.remove(0);
            }
            this.mMostFrequentlyUsedKeysGhostList.add(k2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        if (getInUseSizeInBytes() <= (r3.mMemoryCacheParams.maxCacheSize - r4)) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean canCacheNewValue(V r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.facebook.imagepipeline.cache.ValueDescriptor<V> r0 = r3.mValueDescriptor     // Catch:{ all -> 0x0028 }
            int r4 = r0.getSizeInBytes(r4)     // Catch:{ all -> 0x0028 }
            com.facebook.imagepipeline.cache.MemoryCacheParams r0 = r3.mMemoryCacheParams     // Catch:{ all -> 0x0028 }
            int r0 = r0.maxCacheEntrySize     // Catch:{ all -> 0x0028 }
            if (r4 > r0) goto L_0x0025
            int r0 = r3.getInUseCount()     // Catch:{ all -> 0x0028 }
            com.facebook.imagepipeline.cache.MemoryCacheParams r1 = r3.mMemoryCacheParams     // Catch:{ all -> 0x0028 }
            int r1 = r1.maxCacheEntries     // Catch:{ all -> 0x0028 }
            r2 = 1
            int r1 = r1 - r2
            if (r0 > r1) goto L_0x0025
            int r0 = r3.getInUseSizeInBytes()     // Catch:{ all -> 0x0028 }
            com.facebook.imagepipeline.cache.MemoryCacheParams r1 = r3.mMemoryCacheParams     // Catch:{ all -> 0x0028 }
            int r1 = r1.maxCacheSize     // Catch:{ all -> 0x0028 }
            int r1 = r1 - r4
            if (r0 > r1) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            monitor-exit(r3)
            return r2
        L_0x0028:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.canCacheNewValue(java.lang.Object):boolean");
    }

    private synchronized void decreaseClientCount(CountingMemoryCache.Entry<K, V> entry) {
        boolean z2;
        Preconditions.checkNotNull(entry);
        if (entry.clientCount > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        entry.clientCount--;
    }

    private synchronized void increaseAccessCount(CountingMemoryCache.Entry<K, V> entry) {
        boolean z2;
        Preconditions.checkNotNull(entry);
        if (!entry.isOrphan) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        entry.accessCount++;
    }

    private synchronized void increaseCounters(CountingMemoryCache.Entry<K, V> entry) {
        boolean z2;
        Preconditions.checkNotNull(entry);
        if (!entry.isOrphan) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        entry.clientCount++;
        increaseAccessCount(entry);
    }

    private synchronized void makeOrphan(CountingMemoryCache.Entry<K, V> entry) {
        boolean z2;
        Preconditions.checkNotNull(entry);
        if (!entry.isOrphan) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        entry.isOrphan = true;
    }

    private synchronized void makeOrphans(ArrayList<CountingMemoryCache.Entry<K, V>> arrayList, ArrayList<CountingMemoryCache.Entry<K, V>> arrayList2) {
        makeOrphans(arrayList);
        makeOrphans(arrayList2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean maybeAddToExclusives(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r3.isOrphan     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0021
            int r0 = r3.clientCount     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0021
            int r0 = r3.accessCount     // Catch:{ all -> 0x0024 }
            int r1 = r2.mFrequentlyUsedThreshold     // Catch:{ all -> 0x0024 }
            if (r0 <= r1) goto L_0x0017
            com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache$Entry<K, V>> r0 = r2.mMostFrequentlyUsedExclusiveEntries     // Catch:{ all -> 0x0024 }
            K r1 = r3.key     // Catch:{ all -> 0x0024 }
            r0.put(r1, r3)     // Catch:{ all -> 0x0024 }
            goto L_0x001e
        L_0x0017:
            com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache$Entry<K, V>> r0 = r2.mLeastFrequentlyUsedExclusiveEntries     // Catch:{ all -> 0x0024 }
            K r1 = r3.key     // Catch:{ all -> 0x0024 }
            r0.put(r1, r3)     // Catch:{ all -> 0x0024 }
        L_0x001e:
            monitor-exit(r2)
            r3 = 1
            return r3
        L_0x0021:
            monitor-exit(r2)
            r3 = 0
            return r3
        L_0x0024:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.maybeAddToExclusives(com.facebook.imagepipeline.cache.CountingMemoryCache$Entry):boolean");
    }

    private void maybeClose(ArrayList<CountingMemoryCache.Entry<K, V>> arrayList, ArrayList<CountingMemoryCache.Entry<K, V>> arrayList2) {
        maybeClose(arrayList);
        maybeClose(arrayList2);
    }

    private void maybeNotifyExclusiveEntriesRemoval(ArrayList<CountingMemoryCache.Entry<K, V>> arrayList, ArrayList<CountingMemoryCache.Entry<K, V>> arrayList2) {
        maybeNotifyExclusiveEntryRemoval(arrayList);
        maybeNotifyExclusiveEntryRemoval(arrayList2);
    }

    private static <K, V> void maybeNotifyExclusiveEntryInsertion(CountingMemoryCache.Entry<K, V> entry) {
        CountingMemoryCache.EntryStateObserver<K> entryStateObserver;
        if (entry != null && (entryStateObserver = entry.observer) != null) {
            entryStateObserver.onExclusivityChanged(entry.key, true);
        }
    }

    private void maybeNotifyExclusiveEntryRemoval(CountingMemoryCache.Entry<K, V> entry, CountingMemoryCache.Entry<K, V> entry2) {
        maybeNotifyExclusiveEntryRemoval(entry);
        maybeNotifyExclusiveEntryRemoval(entry2);
    }

    private synchronized void maybeUpdateCacheFraction(K k2) {
        if (this.mLeastFrequentlyUsedKeysGhostList.contains(k2)) {
            int i2 = this.mLFUFractionPromil;
            int i3 = this.mAdaptiveRatePromil;
            if (i2 + i3 <= 900) {
                this.mLFUFractionPromil = i2 + i3;
            }
            this.mLeastFrequentlyUsedKeysGhostList.increaseValueIfExists(k2);
        } else if (this.mLFUFractionPromil - this.mAdaptiveRatePromil >= 100 && this.mMostFrequentlyUsedKeysGhostList.contains(k2)) {
            this.mLFUFractionPromil -= this.mAdaptiveRatePromil;
        }
    }

    private synchronized void maybeUpdateCacheParams() {
        if (this.mLastCacheParamsCheck + this.mMemoryCacheParams.paramsCheckIntervalMs <= SystemClock.uptimeMillis()) {
            this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
            this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull(this.mMemoryCacheParamsSupplier.get(), "mMemoryCacheParamsSupplier returned null");
        }
    }

    private synchronized CloseableReference<V> newClientReference(final CountingMemoryCache.Entry<K, V> entry) {
        increaseCounters(entry);
        return CloseableReference.of(entry.valueRef.get(), new ResourceReleaser<V>() {
            public void release(V v2) {
                AbstractAdaptiveCountingMemoryCache.this.releaseClientReference(entry);
            }
        });
    }

    private synchronized CloseableReference<V> referenceToClose(CountingMemoryCache.Entry<K, V> entry) {
        CloseableReference<V> closeableReference;
        Preconditions.checkNotNull(entry);
        if (!entry.isOrphan || entry.clientCount != 0) {
            closeableReference = null;
        } else {
            closeableReference = entry.valueRef;
        }
        return closeableReference;
    }

    /* access modifiers changed from: private */
    public void releaseClientReference(CountingMemoryCache.Entry<K, V> entry) {
        boolean maybeAddToExclusives;
        CloseableReference<V> referenceToClose;
        Preconditions.checkNotNull(entry);
        synchronized (this) {
            decreaseClientCount(entry);
            maybeAddToExclusives = maybeAddToExclusives(entry);
            referenceToClose = referenceToClose(entry);
        }
        CloseableReference.closeSafely((CloseableReference<?>) referenceToClose);
        if (!maybeAddToExclusives) {
            entry = null;
        }
        maybeNotifyExclusiveEntryInsertion(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private synchronized ArrayList<CountingMemoryCache.Entry<K, V>> trimExclusivelyOwnedEntries(int i2, int i3, CountingLruMap<K, CountingMemoryCache.Entry<K, V>> countingLruMap, ArrayListType arrayListType) {
        int max = Math.max(i2, 0);
        int max2 = Math.max(i3, 0);
        if (countingLruMap.getCount() <= max && countingLruMap.getSizeInBytes() <= max2) {
            return null;
        }
        ArrayList<CountingMemoryCache.Entry<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (countingLruMap.getCount() <= max && countingLruMap.getSizeInBytes() <= max2) {
                return arrayList;
            }
            Object checkNotNull = Preconditions.checkNotNull(countingLruMap.getFirstKey());
            addElementToGhostList(checkNotNull, ((CountingMemoryCache.Entry) Preconditions.checkNotNull(countingLruMap.get(checkNotNull))).accessCount, arrayListType);
            countingLruMap.remove(checkNotNull);
            arrayList.add(this.mCachedEntries.remove(checkNotNull));
        }
    }

    private ValueDescriptor<CountingMemoryCache.Entry<K, V>> wrapValueDescriptor(final ValueDescriptor<V> valueDescriptor) {
        return new ValueDescriptor<CountingMemoryCache.Entry<K, V>>() {
            public int getSizeInBytes(CountingMemoryCache.Entry<K, V> entry) {
                return valueDescriptor.getSizeInBytes(entry.valueRef.get());
            }
        };
    }

    public CloseableReference<V> cache(K k2, CloseableReference<V> closeableReference) {
        return cache(k2, closeableReference, (CountingMemoryCache.EntryStateObserver) null);
    }

    public void clear() {
        ArrayList<CountingMemoryCache.Entry<K, V>> clear;
        ArrayList<CountingMemoryCache.Entry<K, V>> clear2;
        ArrayList<CountingMemoryCache.Entry<K, V>> clear3;
        synchronized (this) {
            clear = this.mLeastFrequentlyUsedExclusiveEntries.clear();
            clear2 = this.mMostFrequentlyUsedExclusiveEntries.clear();
            clear3 = this.mCachedEntries.clear();
            makeOrphans(clear3);
        }
        maybeClose(clear3);
        maybeNotifyExclusiveEntriesRemoval(clear, clear2);
        maybeUpdateCacheParams();
    }

    public synchronized boolean contains(Predicate<K> predicate) {
        return !this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
    }

    public CloseableReference<V> get(K k2) {
        CountingMemoryCache.Entry remove;
        CountingMemoryCache.Entry remove2;
        CloseableReference<V> closeableReference;
        Preconditions.checkNotNull(k2);
        synchronized (this) {
            remove = this.mLeastFrequentlyUsedExclusiveEntries.remove(k2);
            remove2 = this.mMostFrequentlyUsedExclusiveEntries.remove(k2);
            CountingMemoryCache.Entry entry = this.mCachedEntries.get(k2);
            if (entry != null) {
                closeableReference = newClientReference(entry);
            } else {
                maybeUpdateCacheFraction(k2);
                closeableReference = null;
            }
        }
        maybeNotifyExclusiveEntryRemoval(remove, remove2);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return closeableReference;
    }

    public CountingLruMap getCachedEntries() {
        return this.mCachedEntries;
    }

    public synchronized int getCount() {
        return this.mCachedEntries.getCount();
    }

    public synchronized int getEvictionQueueCount() {
        return this.mLeastFrequentlyUsedExclusiveEntries.getCount() + this.mMostFrequentlyUsedExclusiveEntries.getCount();
    }

    public synchronized int getEvictionQueueSizeInBytes() {
        return this.mLeastFrequentlyUsedExclusiveEntries.getSizeInBytes() + this.mMostFrequentlyUsedExclusiveEntries.getSizeInBytes();
    }

    public synchronized int getInUseCount() {
        return (this.mCachedEntries.getCount() - this.mLeastFrequentlyUsedExclusiveEntries.getCount()) - this.mMostFrequentlyUsedExclusiveEntries.getCount();
    }

    public synchronized int getInUseSizeInBytes() {
        return (this.mCachedEntries.getSizeInBytes() - this.mLeastFrequentlyUsedExclusiveEntries.getSizeInBytes()) - this.mMostFrequentlyUsedExclusiveEntries.getSizeInBytes();
    }

    public MemoryCacheParams getMemoryCacheParams() {
        return this.mMemoryCacheParams;
    }

    public Map<Bitmap, Object> getOtherEntries() {
        return Collections.emptyMap();
    }

    public synchronized int getSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes();
    }

    /* access modifiers changed from: protected */
    public abstract void logIllegalAdaptiveRate();

    /* access modifiers changed from: protected */
    public abstract void logIllegalLfuFraction();

    public void maybeEvictEntries() {
        ArrayList<CountingMemoryCache.Entry<K, CountingMemoryCache.Entry<K, V>>> trimExclusivelyOwnedEntries;
        ArrayList<CountingMemoryCache.Entry<K, CountingMemoryCache.Entry<K, V>>> trimExclusivelyOwnedEntries2;
        synchronized (this) {
            MemoryCacheParams memoryCacheParams = this.mMemoryCacheParams;
            int min = Math.min(memoryCacheParams.maxEvictionQueueEntries, memoryCacheParams.maxCacheEntries - getInUseCount());
            MemoryCacheParams memoryCacheParams2 = this.mMemoryCacheParams;
            int min2 = Math.min(memoryCacheParams2.maxEvictionQueueSize, memoryCacheParams2.maxCacheSize - getInUseSizeInBytes());
            int i2 = this.mLFUFractionPromil;
            int i3 = (int) ((((long) min) * ((long) i2)) / 1000);
            int i4 = (int) ((((long) min2) * ((long) i2)) / 1000);
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(i3, i4, this.mLeastFrequentlyUsedExclusiveEntries, ArrayListType.LFU);
            trimExclusivelyOwnedEntries2 = trimExclusivelyOwnedEntries(min - i3, min2 - i4, this.mMostFrequentlyUsedExclusiveEntries, ArrayListType.MFU);
            makeOrphans(trimExclusivelyOwnedEntries, trimExclusivelyOwnedEntries2);
        }
        maybeClose(trimExclusivelyOwnedEntries, trimExclusivelyOwnedEntries2);
        maybeNotifyExclusiveEntriesRemoval(trimExclusivelyOwnedEntries, trimExclusivelyOwnedEntries2);
    }

    public void probe(K k2) {
        Preconditions.checkNotNull(k2);
        synchronized (this) {
            CountingMemoryCache.Entry remove = this.mLeastFrequentlyUsedExclusiveEntries.remove(k2);
            if (remove == null) {
                remove = this.mMostFrequentlyUsedExclusiveEntries.remove(k2);
            }
            if (remove != null) {
                increaseAccessCount(remove);
                maybeAddToExclusives(remove);
            }
        }
    }

    public int removeAll(Predicate<K> predicate) {
        ArrayList<CountingMemoryCache.Entry<K, V>> removeAll;
        ArrayList<CountingMemoryCache.Entry<K, V>> removeAll2;
        ArrayList<CountingMemoryCache.Entry<K, V>> removeAll3;
        synchronized (this) {
            removeAll = this.mLeastFrequentlyUsedExclusiveEntries.removeAll(predicate);
            removeAll2 = this.mMostFrequentlyUsedExclusiveEntries.removeAll(predicate);
            removeAll3 = this.mCachedEntries.removeAll(predicate);
            makeOrphans(removeAll3);
        }
        maybeClose(removeAll3);
        maybeNotifyExclusiveEntriesRemoval(removeAll, removeAll2);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return removeAll3.size();
    }

    public String reportData() {
        return Objects.toStringHelper("CountingMemoryCache").add("cached_entries_count:", this.mCachedEntries.getCount()).add("exclusive_entries_count", getEvictionQueueCount()).toString();
    }

    public CloseableReference<V> reuse(K k2) {
        CountingMemoryCache.Entry remove;
        boolean z2;
        CloseableReference<V> closeableReference;
        Preconditions.checkNotNull(k2);
        synchronized (this) {
            remove = this.mLeastFrequentlyUsedExclusiveEntries.remove(k2);
            if (remove == null) {
                remove = this.mMostFrequentlyUsedExclusiveEntries.remove(k2);
            }
            z2 = false;
            if (remove != null) {
                CountingMemoryCache.Entry remove2 = this.mCachedEntries.remove(k2);
                Preconditions.checkNotNull(remove2);
                if (remove2.clientCount == 0) {
                    z2 = true;
                }
                Preconditions.checkState(z2);
                closeableReference = remove2.valueRef;
                z2 = true;
            } else {
                closeableReference = null;
            }
        }
        if (z2) {
            maybeNotifyExclusiveEntryRemoval(remove);
        }
        return closeableReference;
    }

    public void trim(MemoryTrimType memoryTrimType) {
        ArrayList<CountingMemoryCache.Entry<K, CountingMemoryCache.Entry<K, V>>> trimExclusivelyOwnedEntries;
        ArrayList<CountingMemoryCache.Entry<K, CountingMemoryCache.Entry<K, V>>> trimExclusivelyOwnedEntries2;
        double trimRatio = this.mCacheTrimStrategy.getTrimRatio(memoryTrimType);
        synchronized (this) {
            int sizeInBytes = ((int) (((double) this.mCachedEntries.getSizeInBytes()) * (1.0d - trimRatio))) - getInUseSizeInBytes();
            int i2 = 0;
            int max = Math.max(0, sizeInBytes);
            int sizeInBytes2 = this.mMostFrequentlyUsedExclusiveEntries.getSizeInBytes();
            int max2 = Math.max(0, max - sizeInBytes2);
            if (max > sizeInBytes2) {
                max = sizeInBytes2;
                i2 = max2;
            }
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, i2, this.mLeastFrequentlyUsedExclusiveEntries, ArrayListType.LFU);
            trimExclusivelyOwnedEntries2 = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, max, this.mMostFrequentlyUsedExclusiveEntries, ArrayListType.MFU);
            makeOrphans(trimExclusivelyOwnedEntries, trimExclusivelyOwnedEntries2);
        }
        maybeClose(trimExclusivelyOwnedEntries, trimExclusivelyOwnedEntries2);
        maybeNotifyExclusiveEntriesRemoval(trimExclusivelyOwnedEntries, trimExclusivelyOwnedEntries2);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.common.references.CloseableReference<V> cache(K r7, com.facebook.common.references.CloseableReference<V> r8, com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<K> r9) {
        /*
            r6 = this;
            com.facebook.common.internal.Preconditions.checkNotNull(r7)
            com.facebook.common.internal.Preconditions.checkNotNull(r8)
            r6.maybeUpdateCacheParams()
            monitor-enter(r6)
            com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache$Entry<K, V>> r0 = r6.mLeastFrequentlyUsedExclusiveEntries     // Catch:{ all -> 0x006a }
            java.lang.Object r0 = r0.remove(r7)     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r0 = (com.facebook.imagepipeline.cache.CountingMemoryCache.Entry) r0     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache$Entry<K, V>> r1 = r6.mMostFrequentlyUsedExclusiveEntries     // Catch:{ all -> 0x006a }
            java.lang.Object r1 = r1.remove(r7)     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r1 = (com.facebook.imagepipeline.cache.CountingMemoryCache.Entry) r1     // Catch:{ all -> 0x006a }
            r2 = 0
            if (r0 == 0) goto L_0x0022
            if (r1 != 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r3 = 0
            goto L_0x0023
        L_0x0022:
            r3 = 1
        L_0x0023:
            com.facebook.common.internal.Preconditions.checkState(r3)     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache$Entry<K, V>> r3 = r6.mCachedEntries     // Catch:{ all -> 0x006a }
            java.lang.Object r3 = r3.remove(r7)     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r3 = (com.facebook.imagepipeline.cache.CountingMemoryCache.Entry) r3     // Catch:{ all -> 0x006a }
            r4 = 0
            if (r3 == 0) goto L_0x0039
            r6.makeOrphan(r3)     // Catch:{ all -> 0x006a }
            com.facebook.common.references.CloseableReference r3 = r6.referenceToClose(r3)     // Catch:{ all -> 0x006a }
            goto L_0x003a
        L_0x0039:
            r3 = r4
        L_0x003a:
            java.lang.Object r5 = r8.get()     // Catch:{ all -> 0x006a }
            boolean r5 = r6.canCacheNewValue(r5)     // Catch:{ all -> 0x006a }
            if (r5 == 0) goto L_0x005f
            com.facebook.imagepipeline.cache.CountingMemoryCache$Entry r8 = com.facebook.imagepipeline.cache.CountingMemoryCache.Entry.of(r7, r8, r9)     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache<K, V>$IntMapArrayList<K> r9 = r6.mLeastFrequentlyUsedKeysGhostList     // Catch:{ all -> 0x006a }
            java.lang.Integer r9 = r9.getValue(r7)     // Catch:{ all -> 0x006a }
            if (r9 == 0) goto L_0x0054
            int r2 = r9.intValue()     // Catch:{ all -> 0x006a }
        L_0x0054:
            r8.accessCount = r2     // Catch:{ all -> 0x006a }
            com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache$Entry<K, V>> r9 = r6.mCachedEntries     // Catch:{ all -> 0x006a }
            r9.put(r7, r8)     // Catch:{ all -> 0x006a }
            com.facebook.common.references.CloseableReference r4 = r6.newClientReference(r8)     // Catch:{ all -> 0x006a }
        L_0x005f:
            monitor-exit(r6)     // Catch:{ all -> 0x006a }
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r3)
            r6.maybeNotifyExclusiveEntryRemoval(r0, r1)
            r6.maybeEvictEntries()
            return r4
        L_0x006a:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x006a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.cache(java.lang.Object, com.facebook.common.references.CloseableReference, com.facebook.imagepipeline.cache.CountingMemoryCache$EntryStateObserver):com.facebook.common.references.CloseableReference");
    }

    public synchronized boolean contains(K k2) {
        return this.mCachedEntries.contains(k2);
    }

    private void maybeClose(ArrayList<CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.Entry<K, V>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CloseableReference.closeSafely((CloseableReference<?>) referenceToClose(it2.next()));
            }
        }
    }

    private void maybeNotifyExclusiveEntryRemoval(ArrayList<CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.Entry<K, V>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                maybeNotifyExclusiveEntryRemoval(it2.next());
            }
        }
    }

    private synchronized void makeOrphans(ArrayList<CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.Entry<K, V>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                makeOrphan(it2.next());
            }
        }
    }

    private static <K, V> void maybeNotifyExclusiveEntryRemoval(CountingMemoryCache.Entry<K, V> entry) {
        CountingMemoryCache.EntryStateObserver<K> entryStateObserver;
        if (entry != null && (entryStateObserver = entry.observer) != null) {
            entryStateObserver.onExclusivityChanged(entry.key, false);
        }
    }
}
