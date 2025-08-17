package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class DefaultEntryEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    public EntryEvictionComparator get() {
        return new EntryEvictionComparator() {
            public int compare(DiskStorage.Entry entry, DiskStorage.Entry entry2) {
                long timestamp = entry.getTimestamp();
                long timestamp2 = entry2.getTimestamp();
                if (timestamp < timestamp2) {
                    return -1;
                }
                return timestamp2 == timestamp ? 0 : 1;
            }
        };
    }
}
