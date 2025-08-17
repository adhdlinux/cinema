package com.facebook.cache.disk;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface EntryEvictionComparatorSupplier {
    EntryEvictionComparator get();
}
