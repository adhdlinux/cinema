package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface CountingMemoryCache<K, V> extends MemoryCache<K, V>, MemoryTrimmable {

    public static class Entry<K, V> {
        public int accessCount;
        public int clientCount = 0;
        public boolean isOrphan = false;
        public final K key;
        public final EntryStateObserver<K> observer;
        public final CloseableReference<V> valueRef;

        private Entry(K k2, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
            this.key = Preconditions.checkNotNull(k2);
            this.valueRef = (CloseableReference) Preconditions.checkNotNull(CloseableReference.cloneOrNull(closeableReference));
            this.observer = entryStateObserver;
            this.accessCount = 0;
        }

        public static <K, V> Entry<K, V> of(K k2, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
            return new Entry<>(k2, closeableReference, entryStateObserver);
        }
    }

    public interface EntryStateObserver<K> {
        void onExclusivityChanged(K k2, boolean z2);
    }

    CloseableReference<V> cache(K k2, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver);

    void clear();

    CountingLruMap<K, Entry<K, V>> getCachedEntries();

    int getEvictionQueueCount();

    int getEvictionQueueSizeInBytes();

    int getInUseSizeInBytes();

    MemoryCacheParams getMemoryCacheParams();

    Map<Bitmap, Object> getOtherEntries();

    void maybeEvictEntries();

    CloseableReference<V> reuse(K k2);
}
