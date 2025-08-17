package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.facebook.cache.common.HasDebugData;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@Nullsafe(Nullsafe.Mode.STRICT)
public class LruCountingMemoryCache<K, V> implements CountingMemoryCache<K, V>, MemoryCache<K, V>, HasDebugData {
    private final MemoryCache.CacheTrimStrategy mCacheTrimStrategy;
    final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mCachedEntries;
    private final CountingMemoryCache.EntryStateObserver<K> mEntryStateObserver;
    final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mExclusiveEntries;
    private long mLastCacheParamsCheck;
    protected MemoryCacheParams mMemoryCacheParams;
    private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
    final Map<Bitmap, Object> mOtherEntries = new WeakHashMap();
    private final ValueDescriptor<V> mValueDescriptor;

    public LruCountingMemoryCache(ValueDescriptor<V> valueDescriptor, MemoryCache.CacheTrimStrategy cacheTrimStrategy, Supplier<MemoryCacheParams> supplier, CountingMemoryCache.EntryStateObserver<K> entryStateObserver) {
        this.mValueDescriptor = valueDescriptor;
        this.mExclusiveEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull(supplier.get(), "mMemoryCacheParamsSupplier returned null");
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
        this.mEntryStateObserver = entryStateObserver;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.LruCountingMemoryCache.canCacheNewValue(java.lang.Object):boolean");
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

    private synchronized void increaseClientCount(CountingMemoryCache.Entry<K, V> entry) {
        boolean z2;
        Preconditions.checkNotNull(entry);
        if (!entry.isOrphan) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        entry.clientCount++;
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

    private synchronized void makeOrphans(ArrayList<CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.Entry<K, V>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                makeOrphan(it2.next());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean maybeAddToExclusives(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r3.isOrphan     // Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x0013
            int r0 = r3.clientCount     // Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x0013
            com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache$Entry<K, V>> r0 = r2.mExclusiveEntries     // Catch:{ all -> 0x0016 }
            K r1 = r3.key     // Catch:{ all -> 0x0016 }
            r0.put(r1, r3)     // Catch:{ all -> 0x0016 }
            monitor-exit(r2)
            r3 = 1
            return r3
        L_0x0013:
            monitor-exit(r2)
            r3 = 0
            return r3
        L_0x0016:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.LruCountingMemoryCache.maybeAddToExclusives(com.facebook.imagepipeline.cache.CountingMemoryCache$Entry):boolean");
    }

    private void maybeClose(ArrayList<CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.Entry<K, V>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CloseableReference.closeSafely((CloseableReference<?>) referenceToClose(it2.next()));
            }
        }
    }

    private static <K, V> void maybeNotifyExclusiveEntryInsertion(CountingMemoryCache.Entry<K, V> entry) {
        CountingMemoryCache.EntryStateObserver<K> entryStateObserver;
        if (entry != null && (entryStateObserver = entry.observer) != null) {
            entryStateObserver.onExclusivityChanged(entry.key, true);
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

    private synchronized void maybeUpdateCacheParams() {
        if (this.mLastCacheParamsCheck + this.mMemoryCacheParams.paramsCheckIntervalMs <= SystemClock.uptimeMillis()) {
            this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
            this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull(this.mMemoryCacheParamsSupplier.get(), "mMemoryCacheParamsSupplier returned null");
        }
    }

    private synchronized CloseableReference<V> newClientReference(final CountingMemoryCache.Entry<K, V> entry) {
        increaseClientCount(entry);
        return CloseableReference.of(entry.valueRef.get(), new ResourceReleaser<V>() {
            public void release(V v2) {
                LruCountingMemoryCache.this.releaseClientReference(entry);
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

    private synchronized ArrayList<CountingMemoryCache.Entry<K, V>> trimExclusivelyOwnedEntries(int i2, int i3) {
        int max = Math.max(i2, 0);
        int max2 = Math.max(i3, 0);
        if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
            return null;
        }
        ArrayList<CountingMemoryCache.Entry<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
                return arrayList;
            }
            K firstKey = this.mExclusiveEntries.getFirstKey();
            if (firstKey != null) {
                this.mExclusiveEntries.remove(firstKey);
                arrayList.add(this.mCachedEntries.remove(firstKey));
            } else {
                throw new IllegalStateException(String.format("key is null, but exclusiveEntries count: %d, size: %d", new Object[]{Integer.valueOf(this.mExclusiveEntries.getCount()), Integer.valueOf(this.mExclusiveEntries.getSizeInBytes())}));
            }
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
        return cache(k2, closeableReference, this.mEntryStateObserver);
    }

    public void clear() {
        ArrayList<CountingMemoryCache.Entry<K, V>> clear;
        ArrayList<CountingMemoryCache.Entry<K, V>> clear2;
        synchronized (this) {
            clear = this.mExclusiveEntries.clear();
            clear2 = this.mCachedEntries.clear();
            makeOrphans(clear2);
        }
        maybeClose(clear2);
        maybeNotifyExclusiveEntryRemoval(clear);
        maybeUpdateCacheParams();
    }

    public synchronized boolean contains(Predicate<K> predicate) {
        return !this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
    }

    public CloseableReference<V> get(K k2) {
        CountingMemoryCache.Entry remove;
        CloseableReference<V> closeableReference;
        Preconditions.checkNotNull(k2);
        synchronized (this) {
            remove = this.mExclusiveEntries.remove(k2);
            CountingMemoryCache.Entry entry = this.mCachedEntries.get(k2);
            if (entry != null) {
                closeableReference = newClientReference(entry);
            } else {
                closeableReference = null;
            }
        }
        maybeNotifyExclusiveEntryRemoval(remove);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return closeableReference;
    }

    public CountingLruMap<K, CountingMemoryCache.Entry<K, V>> getCachedEntries() {
        return this.mCachedEntries;
    }

    public synchronized int getCount() {
        return this.mCachedEntries.getCount();
    }

    public synchronized String getDebugData() {
        return Objects.toStringHelper("CountingMemoryCache").add("cached_entries_count", this.mCachedEntries.getCount()).add("cached_entries_size_bytes", this.mCachedEntries.getSizeInBytes()).add("exclusive_entries_count", this.mExclusiveEntries.getCount()).add("exclusive_entries_size_bytes", this.mExclusiveEntries.getSizeInBytes()).toString();
    }

    public synchronized int getEvictionQueueCount() {
        return this.mExclusiveEntries.getCount();
    }

    public synchronized int getEvictionQueueSizeInBytes() {
        return this.mExclusiveEntries.getSizeInBytes();
    }

    public synchronized int getInUseCount() {
        return this.mCachedEntries.getCount() - this.mExclusiveEntries.getCount();
    }

    public synchronized int getInUseSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes() - this.mExclusiveEntries.getSizeInBytes();
    }

    public MemoryCacheParams getMemoryCacheParams() {
        return this.mMemoryCacheParams;
    }

    public Map<Bitmap, Object> getOtherEntries() {
        return this.mOtherEntries;
    }

    public synchronized int getSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes();
    }

    public void maybeEvictEntries() {
        ArrayList trimExclusivelyOwnedEntries;
        synchronized (this) {
            MemoryCacheParams memoryCacheParams = this.mMemoryCacheParams;
            int min = Math.min(memoryCacheParams.maxEvictionQueueEntries, memoryCacheParams.maxCacheEntries - getInUseCount());
            MemoryCacheParams memoryCacheParams2 = this.mMemoryCacheParams;
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(min, Math.min(memoryCacheParams2.maxEvictionQueueSize, memoryCacheParams2.maxCacheSize - getInUseSizeInBytes()));
            makeOrphans(trimExclusivelyOwnedEntries);
        }
        maybeClose(trimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(trimExclusivelyOwnedEntries);
    }

    public void probe(K k2) {
        Preconditions.checkNotNull(k2);
        synchronized (this) {
            CountingMemoryCache.Entry remove = this.mExclusiveEntries.remove(k2);
            if (remove != null) {
                this.mExclusiveEntries.put(k2, remove);
            }
        }
    }

    public int removeAll(Predicate<K> predicate) {
        ArrayList<CountingMemoryCache.Entry<K, V>> removeAll;
        ArrayList<CountingMemoryCache.Entry<K, V>> removeAll2;
        synchronized (this) {
            removeAll = this.mExclusiveEntries.removeAll(predicate);
            removeAll2 = this.mCachedEntries.removeAll(predicate);
            makeOrphans(removeAll2);
        }
        maybeClose(removeAll2);
        maybeNotifyExclusiveEntryRemoval(removeAll);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return removeAll2.size();
    }

    public CloseableReference<V> reuse(K k2) {
        CountingMemoryCache.Entry remove;
        boolean z2;
        CloseableReference<V> closeableReference;
        Preconditions.checkNotNull(k2);
        synchronized (this) {
            remove = this.mExclusiveEntries.remove(k2);
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
        ArrayList trimExclusivelyOwnedEntries;
        double trimRatio = this.mCacheTrimStrategy.getTrimRatio(memoryTrimType);
        synchronized (this) {
            trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, Math.max(0, ((int) (((double) this.mCachedEntries.getSizeInBytes()) * (1.0d - trimRatio))) - getInUseSizeInBytes()));
            makeOrphans(trimExclusivelyOwnedEntries);
        }
        maybeClose(trimExclusivelyOwnedEntries);
        maybeNotifyExclusiveEntryRemoval(trimExclusivelyOwnedEntries);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    public CloseableReference<V> cache(K k2, CloseableReference<V> closeableReference, CountingMemoryCache.EntryStateObserver<K> entryStateObserver) {
        CountingMemoryCache.Entry remove;
        CloseableReference<V> closeableReference2;
        CloseableReference closeableReference3;
        Preconditions.checkNotNull(k2);
        Preconditions.checkNotNull(closeableReference);
        maybeUpdateCacheParams();
        synchronized (this) {
            remove = this.mExclusiveEntries.remove(k2);
            CountingMemoryCache.Entry remove2 = this.mCachedEntries.remove(k2);
            closeableReference2 = null;
            if (remove2 != null) {
                makeOrphan(remove2);
                closeableReference3 = referenceToClose(remove2);
            } else {
                closeableReference3 = null;
            }
            if (canCacheNewValue(closeableReference.get())) {
                CountingMemoryCache.Entry<K, V> of = CountingMemoryCache.Entry.of(k2, closeableReference, entryStateObserver);
                this.mCachedEntries.put(k2, of);
                closeableReference2 = newClientReference(of);
            }
        }
        CloseableReference.closeSafely((CloseableReference<?>) closeableReference3);
        maybeNotifyExclusiveEntryRemoval(remove);
        maybeEvictEntries();
        return closeableReference2;
    }

    public synchronized boolean contains(K k2) {
        return this.mCachedEntries.contains(k2);
    }

    private static <K, V> void maybeNotifyExclusiveEntryRemoval(CountingMemoryCache.Entry<K, V> entry) {
        CountingMemoryCache.EntryStateObserver<K> entryStateObserver;
        if (entry != null && (entryStateObserver = entry.observer) != null) {
            entryStateObserver.onExclusivityChanged(entry.key, false);
        }
    }
}
