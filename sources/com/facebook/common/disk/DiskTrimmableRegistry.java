package com.facebook.common.disk;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface DiskTrimmableRegistry {
    void registerDiskTrimmable(DiskTrimmable diskTrimmable);

    void unregisterDiskTrimmable(DiskTrimmable diskTrimmable);
}
