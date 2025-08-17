package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Comparator;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface EntryEvictionComparator extends Comparator<DiskStorage.Entry> {
}
