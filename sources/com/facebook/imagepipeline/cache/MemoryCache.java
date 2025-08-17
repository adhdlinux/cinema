package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.HasDebugData;
import com.facebook.common.internal.Predicate;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface MemoryCache<K, V> extends MemoryTrimmable, HasDebugData {

    public interface CacheTrimStrategy {
        double getTrimRatio(MemoryTrimType memoryTrimType);
    }

    CloseableReference<V> cache(K k2, CloseableReference<V> closeableReference);

    boolean contains(Predicate<K> predicate);

    boolean contains(K k2);

    CloseableReference<V> get(K k2);

    int getCount();

    int getSizeInBytes();

    void probe(K k2);

    int removeAll(Predicate<K> predicate);
}
